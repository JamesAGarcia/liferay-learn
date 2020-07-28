# Defining Environment Variables

Environment variables are a set of dynamic placeholders that can affect the way a service behaves within an environment.

You can define environment variables via the DXP Cloud console or by configuring the `LCP.json` file for each service.

```note::
   DXP Cloud always applies the most recent changes to settings. If the latest changes are made in the LCP.json file, upon restart, the environment variables will be reflected in the web console. However, if the environment variables are changed in the web console, the container will be restarted with those new configurations.
```

## Defining Environment Variables via the DXP Cloud Console

You can add, change, or remove environment variables for a service via the DXP Cloud console. When configuring a service in this way, all variables are scoped to the project environment in which they are defined.

Follow these steps to add environment variables to a service via the DXP Cloud console:

1. Navigate to a project environment.

1. Click on *Services* in the environment menu.

1. Click on the service you want to configure.

1. Click on the *Environment Variables* tab.

   ![Figure 1: Navigate to the service's Environment Variables tab.](./defining-environment-variables/images/01.png)

1. Enter a new environment variable as a key-value pair. The following example disables clustering for the Liferay DXP service:

    * **Key**: `LCP_PROJECT_LIFERAY_CLUSTER_ENABLED`
    * **Value**:  `false`

1. Click on *Save Changes* to restart the service with the new environment variable.

```note::
   While restarting, the service may stop receiving requests for some minutes and behave differently depending on the variable values.
```

Once an environment variable is added to a service, you can change its value or remove the variable at any time from the service's *Environment Variables* tab.

To change a variable's value, follow these steps:

1. Click on the *Show* icon to view the value of the variable you want to change.

1. Change the variable's value.

1. Click on *Save Changes* to restart the service with the updated value.

![Figure 2: Click on the Show icon to view and edit a variable's value.](./defining-environment-variables/images/02.png)

## Defining Environment Variables via LCP.json

You can define environment variables for a service via its `LCP.json` file using the `env` property. When configuring a service in this way, you can define the service's behavior across all or select environments.

The following example defines the `LCP_PROJECT_LIFERAY_CLUSTER_ENABLED` variable with the value `true`.This variable is set as a top level attribute applied by default to all environments, unless otherwise specified.

```json
{
  "id": "liferay",
  "image": "@liferay.workspace.lcp.liferay.image@",
  "env": {
    "LCP_PROJECT_LIFERAY_CLUSTER_ENABLED": "true"
  }
}
```

The following example creates an exception to the top level attribute, defining the `LCP_PROJECT_LIFERAY_CLUSTER_ENABLED` variable with the value `false` for the `dev` environment:

```json
{
  "environments": {
    "dev": {
      "env": {
        "LCP_PROJECT_LIFERAY_CLUSTER_ENABLED": "false"
      }
    }
  }
}
```

When you are finished editing the service's `LCP.json` file, save and deploy your changes to update environment variables. See [Overview of the DXP Cloud Deployment Workflow](../build-and-deploy/overview-of-the-dxp-cloud-deployment-workflow.md) for more information.

## Secret Environment Variables

Normal environment variables do not have special security measures. Any Users that can access your DXP Cloud project can also see the variables for your services.

However, to store sensitive values (such as credentials) as variables, you can use secrets instead. Secrets are encrypted in the backend and can be hidden from Users without the *Admin* role. See [Managing Secure Environment Variables with Secrets](../infrastructure-and-operations/security/managing-secure-environment-variables-with-secrets.md) for more information.

## Additional Information

* [Configuration via LCP.json](../reference/configuration-via-lcp-json.md)
* [Managing Secure Environment Variables with Secrets](../infrastructure-and-operations/security/managing-secure-environment-variables-with-secrets.md)
* [Overview of the DXP Cloud Deployment Workflow](../build-and-deploy/overview-of-the-dxp-cloud-deployment-workflow.md)
