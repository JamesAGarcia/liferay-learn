import com.liferay.headless.admin.user.client.dto.v1_0.Role;
import com.liferay.headless.admin.user.client.resource.v1_0.RoleResource;

public class Role_GET_ById {

	/**
	 * java -classpath .:* -DroleId=1234 Role_GET_ById
	 */
	public static void main(String[] args) throws Exception {
		RoleResource.Builder builder = RoleResource.builder();

		RoleResource roleResource = builder.authentication(
			"test@liferay.com", "test"
		).build();

		Role role = roleResource.getRole(
			Long.valueOf(System.getProperty("roleId")));

		System.out.println(role);
	}

}