import com.liferay.headless.admin.user.client.dto.v1_0.Role;
import com.liferay.headless.admin.user.client.pagination.Page;
import com.liferay.headless.admin.user.client.pagination.Pagination;
import com.liferay.headless.admin.user.client.resource.v1_0.RoleResource;

public class Roles_GET_FromInstance {

	/**
	 * java -classpath .:* Roles_GET_FromInstance
	 */
	public static void main(String[] args) throws Exception {
		RoleResource.Builder builder = RoleResource.builder();

		RoleResource roleResource = builder.authentication(
			"test@liferay.com", "test"
		).build();

		Page<Role> role = roleResource.getRolesPage(Pagination.of(1, 2));

		System.out.println(role);
	}

}