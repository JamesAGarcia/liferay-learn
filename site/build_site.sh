#!/bin/bash

set -eo pipefail

readonly CURRENT_DIR_NAME=$(dirname "$0")

source ../_common.sh

function activate_venv {
	if [[ "$(uname)" == "Darwin" || "$(uname)" == "Linux" ]]
	then
		python3 -m venv venv

		source venv/bin/activate
	else
		if [[ -z $(find ${PWD} -maxdepth 1 -mindepth 1 -name venv -type d) ]]
		then
			python -m venv ${PWD}/venv
		fi

		source ${PWD}/venv/scripts/activate
	fi
}

function check_args {
	if [[ ${#} -eq 0 ]]
	then
		return
	fi

	if [[ ${#} -eq 1 ]]
	then
		if [ "${1}" != "prod" ]
		then
			echo "Invalid Argument: Pass no arguments to build for dev, or pass \"prod\" to build for production."

			exit 1
		fi
	fi

	if [[ ${#} -gt 1 ]]
	then
		echo "Too Many Arguments: Pass no arguments to build for dev, or pass \"prod\" to build for production."

		exit 1
	fi
}

function check_utils {

	#
	# https://stackoverflow.com/a/677212
	#

	for util in "${@}"
	do
		command -v ${util} >/dev/null 2>&1 || { echo >&2 "The utility ${util} is not installed."; exit 1; }
	done
}

function configure_env {
	if [ "${1}" == "prod" ]
	then
		rm -fr venv
	fi

	activate_venv

	check_utils 7z pip3

	pip install pipenv --force-reinstall

	pipenv install

	if [ "${1}" == "prod" ]
	then
		nodeenv -p --node=15.14.0

		activate_venv

		npm_install generator-liferay-fragments generator-liferay-theme yo
	fi
}

function generate_sphinx_input {
	rm -fr build

	if [ "${1}" == "prod" ]
	then
		pushd ../docs

		git clean -dfx .

		./update_examples.sh "${1}" && ./update_permissions.sh

		pushd ../site
	fi

	for docs_dir_name in $(find ../docs -maxdepth 4 -mindepth 4 -type f -name "contents.rst" -printf "%h\n")
	do
		local product_version_language_dir_name=$(get_product_version_language_dir_name)

		mkdir -p build/input/"${product_version_language_dir_name}"/docs

		local product_version_english_dir_name=$(get_product_version_language_dir_name | sed 's@/[^/]*$@/en@')

		rsync -a --exclude '*.md' --exclude '*.rst' --ignore-existing ../docs/"${product_version_english_dir_name}"/* build/input/"${product_version_language_dir_name}"/

		cp -R docs/* build/input/"${product_version_language_dir_name}"

		cp -R ../docs/"${product_version_language_dir_name}"/* build/input/"${product_version_language_dir_name}"
	done

	rsync -a homepage/* build/input/homepage --exclude={'*.json','node_modules'}

	#
	# Replace tokens.
	#

	for md_file_name in $(find build/input -name "*.md" -type f)
	do
		sed -i "s/${LIFERAY_LEARN_COMMERCE_DOCKER_IMAGE_TOKEN}/${LIFERAY_LEARN_COMMERCE_DOCKER_IMAGE_VALUE}/g" "${md_file_name}"
		sed -i "s/${LIFERAY_LEARN_COMMERCE_GIT_TAG_TOKEN}/${LIFERAY_LEARN_COMMERCE_GIT_TAG_VALUE}/g" "${md_file_name}"
		sed -i "s/${LIFERAY_LEARN_DXP_DOCKER_IMAGE_TOKEN}/${LIFERAY_LEARN_DXP_DOCKER_IMAGE_VALUE}/g" "${md_file_name}"
		sed -i "s/${LIFERAY_LEARN_PORTAL_DOCKER_IMAGE_TOKEN}/${LIFERAY_LEARN_PORTAL_DOCKER_IMAGE_VALUE}/g" "${md_file_name}"
		sed -i "s/${LIFERAY_LEARN_PORTAL_GIT_TAG_TOKEN}/${LIFERAY_LEARN_PORTAL_GIT_TAG_VALUE}/g" "${md_file_name}"
	done
}

function generate_static_html {
	for docs_dir_name in $(find build/input -maxdepth 4 -mindepth 4 -type f -name "contents.rst" -printf "%h\n" )
	do
		local product_version_language_dir_name=$(get_product_version_language_dir_name)

		echo "Generating static HTML for $(get_product_version_language_dir_name)."

		#
		# Use Sphinx to generate static HTML for each product, version, and language.
		#

		sphinx-build -M html "build/input/${product_version_language_dir_name}" "build/output/${product_version_language_dir_name}"

		mv build/output/"${product_version_language_dir_name}"/html/* build/output/"${product_version_language_dir_name}"

		#
		# Fix broken links.
		#

		for html_file_name in $(find build/output/"${product_version_language_dir_name}" -name *.html -type f)
		do
			sed -i 's/.md"/.html"/g' ${html_file_name}
			sed -i 's/.md#/.html#/g' ${html_file_name}
			sed -i 's/README.html"/index.html"/g' ${html_file_name}
			sed -i 's/README.html#/index.html#/g' ${html_file_name}
		done

		#
		# Include unbuilt resources (root level files only) in the built site.
		#

		for resources_dir in $(find build/input/"${product_version_language_dir_name}" -name resources -prune -type d)
		do
			if [[ -n $(find "${resources_dir}" -maxdepth 1 -type f) ]]
			then
				mkdir -p "${resources_dir/input/output}"

				find "${resources_dir}" -maxdepth 1 -type f -exec cp {} "${resources_dir/input/output}" \;
			fi
		done

		#
		# Rename README.html to index.html.
		#

		for readme_file_name in $(find build/output/"${product_version_language_dir_name}" -name *README.html -type f)
		do
			mv "${readme_file_name}" "$(dirname "${readme_file_name}")"/index.html
		done

		#
		# Update search references for README.html to index.html.
		#

		sed -i 's/README"/index"/g' build/output/"${product_version_language_dir_name}"/searchindex.js

		#
		# Make ZIP files.
		#

		for zip_dir_name in $(find build/input/"${product_version_language_dir_name}" -name *.zip -type d)
		do
			pushd "${zip_dir_name}"

			local zip_file_name=$(basename "${zip_dir_name}")

			7z a ${zip_file_name} ../${zip_file_name}\

			7z rn ${zip_file_name} ${zip_file_name} ${zip_file_name%.*}

			local output_dir_name=$(dirname "${zip_dir_name}")

			output_dir_name=$(dirname "${output_dir_name}")
			output_dir_name=$(dirname "${output_dir_name}")
			output_dir_name=${output_dir_name/input/output}

			popd

			mkdir -p "${output_dir_name}"

			mv "${zip_dir_name}"/"${zip_file_name}" "${output_dir_name}"
		done
	done

	#
	# Build the Homepage separately.
	#

	sphinx-build -M html build/input/homepage build/output/homepage

	mv build/output/homepage/html/* build/output/

	rm -fr build/output/homepage
}

function get_product_version_language_dir_name {
	local language=$(echo "${docs_dir_name}" | cut -f5 -d'/')
	local product=$(echo "${docs_dir_name}" | cut -f3 -d'/')
	local version=$(echo "${docs_dir_name}" | cut -f4 -d'/')

	echo "${product}"/"${version}"/"${language}"
}

function main {
	pushd "${CURRENT_DIR_NAME}" || exit 1

	check_args "${@}"

	configure_env ${1}

	generate_sphinx_input ${1}

	generate_static_html

	upload_to_server
}

function npm_install {
	for package_name in "${@}"
	do
		if [[ -z $(npm list --depth=0 --global --loglevel=silent --no-versions --parseable | grep ${package_name}) ]]
		then
			npm install -g ${package_name}
		fi
	done
}

function upload_to_server {

	#
	# TODO
	#

	echo upload_to_server
}

main "${@}"