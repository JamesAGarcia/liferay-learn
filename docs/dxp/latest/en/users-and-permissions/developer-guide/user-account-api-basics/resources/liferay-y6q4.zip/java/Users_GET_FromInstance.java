import com.liferay.headless.admin.user.client.dto.v1_0.UserAccount;
import com.liferay.headless.admin.user.client.pagination.Page;
import com.liferay.headless.admin.user.client.pagination.Pagination;
import com.liferay.headless.admin.user.client.resource.v1_0.UserAccountResource;

public class Users_GET_FromInstance {

	/**
	 * java -classpath .:* Users_GET_FromInstance
	 */
	public static void main(String[] args) throws Exception {
		UserAccountResource.Builder builder = UserAccountResource.builder();

		UserAccountResource userAccountResource = builder.authentication(
			"test@liferay.com", "test"
		).build();

		Page<UserAccount> page = userAccountResource.getUserAccountsPage(
			null, null, Pagination.of(1, 2), null);

		System.out.println(page);
	}

}