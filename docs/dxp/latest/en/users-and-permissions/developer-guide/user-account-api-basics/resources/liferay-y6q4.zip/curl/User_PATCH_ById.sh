curl \
	-H "Content-Type: application/json" \
	-X PATCH \
	"http://localhost:8080/o/headless-admin-user/v1.0/user-accounts/${1}" \
	-d "{\"familyName\": \"Bar\"}" \
	-u "test@liferay.com:test"