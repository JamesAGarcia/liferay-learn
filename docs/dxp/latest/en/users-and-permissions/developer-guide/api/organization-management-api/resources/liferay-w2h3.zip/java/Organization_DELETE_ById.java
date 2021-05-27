import com.liferay.headless.admin.user.client.resource.v1_0.OrganizationResource;

public class Organization_DELETE_ById {

	/**
	 * java -classpath .:* -DorganizationId=1234 Organization_DELETE_ById
	 */
	public static void main(String[] args) throws Exception {
		OrganizationResource.Builder builder = OrganizationResource.builder();

		OrganizationResource organizationResource = builder.authentication(
			"test@liferay.com", "test"
		).build();

		organizationResource.deleteOrganization(
			String.valueOf(System.getProperty("organizationId")));
	}

}