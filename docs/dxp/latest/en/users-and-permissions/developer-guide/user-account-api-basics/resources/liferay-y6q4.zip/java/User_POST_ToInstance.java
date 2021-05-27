import com.liferay.headless.admin.user.client.dto.v1_0.UserAccount;
import com.liferay.headless.admin.user.client.resource.v1_0.UserAccountResource;

public class User_POST_ToInstance {

	/**
	 * java -classpath .:* User_POST_ToInstance
	 */
	public static void main(String[] args) throws Exception {
		UserAccountResource.Builder builder = UserAccountResource.builder();

		UserAccountResource userAccountResource = builder.authentication(
			"test@liferay.com", "test"
		).build();

		UserAccount userAccount = userAccountResource.postUserAccount(
			new UserAccount() {
				{
					alternateName = "Baker";
					emailAddress = "baker@liferay.com";
					familyName = "Foo";
					givenName = "Baker";
				}
			});

		System.out.println(userAccount);
	}

}