# Initial Setup Overview

To get started with Liferay DXP Cloud, verify all essential provisions are in place.

- Check the email account associated with your DXP Cloud subscription for initial onboarding emails.
- Log in to Liferay DXP Cloud Management Console, GitHub, and Jenkins.
- Verify all purchased Environments are listed in the Liferay DXP Cloud Management Console.
- Verify DXP Cloud stack services are deployed to *dev* Environments.
- Verify webserver service is functional.
- Verify each Environment location is correct.

<!-- Include Github Configuration: Verify GitHub is properly configured/connected. Locate the DXP Cloud repository in their GitHub account. -->

## Onboarding Emails

Initial administrators should receive a DXP Cloud onboarding email, GitHub email, and email invitations for each purchased DXP Cloud Environment.

1. DXP Cloud Onboarding Email: the onboarding email provides necessary credentials for accessing Jenkins and Liferay DXP Cloud on Non-Production Environments, as well as steps for how to get started using the DXP Cloud Account. <!-- What about Production Environments? -->
1. Github Email: the Github email provides ___. <!-- What does this email say? -->
1. DXP Cloud Environment Invitations: each Environment invitation grants access to a single purchased DXP Cloud Environment. Be sure to accept all Environment invitations to gain access.

```important::
   Before proceeding, verify you have received all necessary onboarding emails.
```

## Logging In

DXP Cloud functionalities depend on users logging in to the DXP Cloud Management Console, GitHub, and Jenkins. <!-- Should this be more nuanced? -->

<!-- Include: ### Locating Login Credentials ? -->

### DXP Cloud Management Console

New users will need to create an account on DXP Cloud using their registered/associated email address.

1. Go to the DXP Cloud Management Console [login page](https://console.liferay.cloud/login).
1. Sign up using your registered/associated email account
1. Log in using your new DXP Cloud account.
<!-- What does this look like? Is there any other step in here? -->
After Logging in, users will be brought to the DXP Cloud Management Console [home page](https://console.liferay.cloud/projects). From here, users can manage Environments and deployments. Administrators can also invite other team members to the Environment.

<!-- Insert IMG -->

See [Team Collaboration & Access Control](https://learn.liferay.com/dxp-cloud-latest/manage-and-optimize/team-collaboration-and-access-control.html) for more information.

### GitHub

Upon receiving the DXP Cloud onboarding email, new users will be provisioned a temporary GitHub repository hosted in the `dxpcloud` organization. To locate this repository:

1. Go to [GitHub](https://github.com/)
1. Log in. <!-- Will the user need to create a Github account using the email associated with the DXP Cloud Subscription? How is the GitHub email relevant? -->
1. Search `dxpcloud` in the 'Your teams' search box.

<!-- Insert IMG -->

```important::
   If there is no dxpcloud/{project_name} team returned when searching, please contact the Liferay Support team.
```

This temporary repository should be used as a template for a team’s separate private DXP Cloud development repository. See [Configuring Your GitHub Repository](https://learn.liferay.com/dxp-cloud-latest/getting-started/configuring-your-github-repository.html) for how to transfer the temporary provisioned repository to a private GitHub repository.

```note::
   Using an alternative hosting service? See how to configure your [Bitbucket](https://learn.liferay.com/dxp-cloud-latest/getting-started/configuring-your-bitbucket-repository.html) or [GitLab](https://learn.liferay.com/dxp-cloud-latest/getting-started/configuring-your-gitlab-repository.html) repositories.
```

### Jenkins

Jenkins is a common automation server used for application testing and comes pre-installed in your DXP Cloud Infrastructure (*infra*) Environment. To log in to Jenkins:

1. Log in to DXP Cloud Management Console.
1. Navigate to *infra* Environment.
1. Click *Services* in the left menu.
1. Select *ci* service.
1. Click the Jenkins web page URL (e.g., ci-{project_id}-infra.lfr.cloud) to access the Jenkins login page.
1. Enter your Jenkins login credentials provided in your initial onboarding email.

```note::
   Your Jenkins login credentials are also listed on under *Environment Variables* in the *ci* service page.
```
<!-- Insert IMG -->

See [Continuous Integration](https://learn.liferay.com/dxp-cloud-latest/platform-services/continuous-integration.html) for more information about Jenkins.

## Verifying Environment Setup

<!-- Insert Intro Remarks -->

### Verifying Environments

Environments hold all the necessary components, or Services, needed to run DXP in the cloud. Before beginning deployment in Liferay DXP Cloud, verify all purchased Environments are listed in the [Projects](https://console.liferay.cloud/projects) section of the DXP Cloud Management Console.

<!-- Insert IMG -->

If any Environments are missing, consider adding it back using the *Add Environment* option or contact Support. <!-- Why would I choose one or the other? -->

<!-- Had: See [Understanding DXP Cloud Environments](https://learn.liferay.com/dxp-cloud-latest/getting-started/understanding-dxp-cloud-environments.html?highlight=location) for more information. -->

### Verifying Environment Locations

Environment location is where an Environment's data center is located. Before beginning deployment in a DXP Cloud Environment, verify its location is accurate.

The Environment location can be found in either the Environment Overview page, or Settings page.

<!-- Insert IMG -->

```important::
   If the Environment location does not match the location requested by your team, please contact support.
```
<!-- Had: See [Understanding DXP Cloud Environments](https://learn.liferay.com/dxp-cloud-latest/getting-started/understanding-dxp-cloud-environments.html?highlight=location) for more information. -->

### Verifying Cloud Stack Services

When first accessing the Liferay DXP Cloud Management Console, verify the default DXP Cloud stack services are properly deployed.

1. Access the *dev* Environment.
1. Navigating to the *Services* page.

<!-- Insert IMG -->

When properly deployed, the status of all 5 default Cloud Stack Services should be 'Ready'.

See [Platform Services](https://learn.liferay.com/dxp-cloud-latest/platform_services.html) for more information about these services.

### Verifying Webserver Service is Functional

Verify the webserver is functional: 
1. Navigate on the *dev* Environment Services page
1. Click on the webserver URL, which should look like “webserver-{project_id}-dev.lfr.cloud/”, Liferay DXP front page should be displayed.
1. The URL should lead to the Liferay DXP front page.

## Additional Information
- [Configuring Your GitHub Repository](https://learn.liferay.com/dxp-cloud-latest/getting-started/configuring-your-github-repository.html)
- [Understanding DXP Cloud Environments](https://learn.liferay.com/dxp-cloud-latest/getting-started/understanding-dxp-cloud-environments.html?highlight=location)
- [Logging into Your DXP Cloud Services](https://learn.liferay.com/dxp-cloud-latest/getting-started/logging-into-your-dxp-cloud-services.html)