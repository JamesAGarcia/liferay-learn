import com.liferay.headless.admin.user.client.resource.v1_0.RoleResource;

public class RoleUserAssociation_DELETE_FromInstance {

	/**
	 * java -classpath .:* -DroleId=1234 -DuserAccountId=5678 RoleUserAssociation_DELETE_FromInstance
	 */
	public static void main(String[] args) throws Exception {
		RoleResource.Builder builder = RoleResource.builder();

		RoleResource roleResource = builder.authentication(
			"test@liferay.com", "test"
		).build();

		roleResource.deleteRoleUserAccountAssociation(
			Long.valueOf(System.getProperty("roleId")),
			Long.valueOf(System.getProperty("userAccountId")));
	}

}