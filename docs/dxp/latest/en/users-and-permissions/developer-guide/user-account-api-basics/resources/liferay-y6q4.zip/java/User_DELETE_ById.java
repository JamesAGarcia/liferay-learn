import com.liferay.headless.admin.user.client.resource.v1_0.UserAccountResource;

public class User_DELETE_ById {

	/**
	 * java -classpath .:* -DuserId=1234 User_DELETE_ById
	 */
	public static void main(String[] args) throws Exception {
		UserAccountResource.Builder builder = UserAccountResource.builder();

		UserAccountResource userAccountResource = builder.authentication(
			"test@liferay.com", "test"
		).build();

		userAccountResource.deleteUserAccount(
			Long.valueOf(System.getProperty("userId")));
	}

}