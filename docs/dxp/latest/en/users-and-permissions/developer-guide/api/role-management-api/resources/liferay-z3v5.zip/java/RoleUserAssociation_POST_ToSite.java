import com.liferay.headless.admin.user.client.resource.v1_0.RoleResource;

public class RoleUserAssociation_POST_ToSite {

	/**
	 * java -classpath .:* -DroleId=1234 -DsiteId=5678 -DuserAccountId=9012 RoleUserAssociation_POST_ToSite
	 */
	public static void main(String[] args) throws Exception {
		RoleResource.Builder builder = RoleResource.builder();

		RoleResource roleResource = builder.authentication(
			"test@liferay.com", "test"
		).build();

		roleResource.postSiteRoleUserAccountAssociation(
			Long.valueOf(System.getProperty("roleId")),
			Long.valueOf(System.getProperty("userAccountId")),
			Long.valueOf(System.getProperty("siteId")));
	}

}