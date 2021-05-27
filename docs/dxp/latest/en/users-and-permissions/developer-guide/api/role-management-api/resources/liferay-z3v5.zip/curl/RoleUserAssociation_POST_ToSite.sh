curl \
	-H "Content-Type: application/json" \
	-X POST \
	"http://localhost:8080/o/headless-admin-user/v1.0/roles/${1}/association/user-account/${1}/site/${1}" \
	-u "test@liferay.com:test"