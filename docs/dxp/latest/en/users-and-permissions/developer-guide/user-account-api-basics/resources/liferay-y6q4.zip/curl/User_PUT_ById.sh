curl \
	-H "Content-Type: application/json" \
	-X PUT \
	"http://localhost:8080/o/headless-admin-user/v1.0/user-accounts/${1}" \
	-d "{\"alternateName\": \"Able\", \"emailAddress\": \"able@liferay.com\", \"familyName\": \"Goo\", \"givenName\": \"Able\"}" \
	-u "test@liferay.com:test"