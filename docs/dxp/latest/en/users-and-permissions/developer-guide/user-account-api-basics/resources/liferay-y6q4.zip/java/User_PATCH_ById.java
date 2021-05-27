import com.liferay.headless.admin.user.client.dto.v1_0.UserAccount;
import com.liferay.headless.admin.user.client.resource.v1_0.UserAccountResource;

public class User_PATCH_ById {

	/**
	 * java -classpath .:* -DuserId=1234 User_PATCH_ById
	 */
	public static void main(String[] args) throws Exception {
		UserAccountResource.Builder builder = UserAccountResource.builder();

		UserAccountResource userAccountResource = builder.authentication(
			"test@liferay.com", "test"
		).build();

		UserAccount userAccount = userAccountResource.patchUserAccount(
			Long.valueOf(System.getProperty("userId")),
			new UserAccount() {
				{
					familyName = "Bar";
				}
			});

		System.out.println(userAccount);
	}

}