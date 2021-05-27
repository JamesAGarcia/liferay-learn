import com.liferay.headless.admin.user.client.dto.v1_0.Organization;
import com.liferay.headless.admin.user.client.resource.v1_0.OrganizationResource;

public class Organization_POST_ToInstance {

	/**
	 * java -classpath .:* Organization_POST_ToInstance
	 */
	public static void main(String[] args) throws Exception {
		OrganizationResource.Builder builder = OrganizationResource.builder();

		OrganizationResource organizationResource = builder.authentication(
			"test@liferay.com", "test"
		).build();

		Organization organization = organizationResource.postOrganization(
			new Organization() {
				{
					name = "Dog";
				}
			});

		System.out.println(organization);
	}

}