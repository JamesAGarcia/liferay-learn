import com.liferay.headless.admin.user.client.dto.v1_0.Organization;
import com.liferay.headless.admin.user.client.resource.v1_0.OrganizationResource;

public class Organization_PUT_ById {

	/**
	 * java -classpath .:* -DorganizationId=1234 Organization_PUT_ById
	 */
	public static void main(String[] args) throws Exception {
		OrganizationResource.Builder builder = OrganizationResource.builder();

		OrganizationResource organizationResource = builder.authentication(
			"test@liferay.com", "test"
		).build();

		Organization organization = organizationResource.putOrganization(
			String.valueOf(System.getProperty("organizationId")),
			new Organization() {
				{
					name = "Fox";
				}
			});

		System.out.println(organization);
	}

}