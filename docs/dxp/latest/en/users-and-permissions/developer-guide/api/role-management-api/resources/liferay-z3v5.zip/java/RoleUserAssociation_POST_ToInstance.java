import com.liferay.headless.admin.user.client.resource.v1_0.RoleResource;

public class RoleUserAssociation_POST_ToInstance {

	/**
	 * java -classpath .:* -DroleId=1234 -DuserAccountId=5678 RoleUserAssociation_POST_ToInstance
	 */
	public static void main(String[] args) throws Exception {
		RoleResource.Builder builder = RoleResource.builder();

		RoleResource roleResource = builder.authentication(
			"test@liferay.com", "test"
		).build();

		roleResource.postRoleUserAccountAssociation(
			Long.valueOf(System.getProperty("roleId")),
			Long.valueOf(System.getProperty("userAccountId")));
	}

}