import com.liferay.headless.admin.user.client.dto.v1_0.UserAccount;
import com.liferay.headless.admin.user.client.resource.v1_0.UserAccountResource;

public class User_PUT_ById {

	/**
	 * java -classpath .:* -DuserId=1234 User_PUT_ById
	 */
	public static void main(String[] args) throws Exception {
		UserAccountResource.Builder builder = UserAccountResource.builder();

		UserAccountResource userAccountResource = builder.authentication(
			"test@liferay.com", "test"
		).build();

		UserAccount userAccount = userAccountResource.putUserAccount(
			Long.valueOf(System.getProperty("userId")),
			new UserAccount() {
				{
					alternateName = "Baker";
					emailAddress = "baker@liferay.com";
					familyName = "Goo";
					givenName = "Baker";
				}
			});

		System.out.println(userAccount);
	}

}