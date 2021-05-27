import com.liferay.headless.admin.user.client.dto.v1_0.Organization;
import com.liferay.headless.admin.user.client.pagination.Page;
import com.liferay.headless.admin.user.client.pagination.Pagination;
import com.liferay.headless.admin.user.client.resource.v1_0.OrganizationResource;

public class Organizations_GET_FromInstance {

	/**
	 * java -classpath .:* Organizations_GET_FromInstance
	 */
	public static void main(String[] args) throws Exception {
		OrganizationResource.Builder builder = OrganizationResource.builder();

		OrganizationResource organizationResource = builder.authentication(
			"test@liferay.com", "test"
		).build();

		Page<Organization> page = organizationResource.getOrganizationsPage(
			null, null, null, Pagination.of(1, 2), null);

		System.out.println(page);
	}

}