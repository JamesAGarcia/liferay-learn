curl \
	-H "Content-Type: application/json" \
	-X PUT \
	"http://localhost:8080/o/headless-admin-user/v1.0/organizations/${1}" \
	-d "{\"name\": \"Charlie\"}" \
	-u "test@liferay.com:test"