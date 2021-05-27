import com.liferay.headless.admin.user.client.resource.v1_0.RoleResource;

public class RoleUserAssociation_DELETE_FromOrganization {

	/**
	 * java -classpath .:* -DorganizationId=1234 -DroleId=5678 -DuserAccountId=9012 RoleUserAssociation_DELETE_FromOrganization
	 */
	public static void main(String[] args) throws Exception {
		RoleResource.Builder builder = RoleResource.builder();

		RoleResource roleResource = builder.authentication(
			"test@liferay.com", "test"
		).build();

		roleResource.deleteOrganizationRoleUserAccountAssociation(
			Long.valueOf(System.getProperty("roleId")),
			Long.valueOf(System.getProperty("userAccountId")),
			Long.valueOf(System.getProperty("organizationId")));
	}

}