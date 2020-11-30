# Introduction to the Liferay DXP Service

The Liferay DXP service is the heartbeat of any project. It runs the application's Liferay DXP instance and interacts with other services like the web server, Elasticsearch, and MySQL database.

![Figure 1: The Liferay DXP service is one of several services available in DXP Cloud.](./introduction-to-the-liferay-dxp-service/images/01.png)

The Liferay DXP service in DXP Cloud can be used in many of the same ways as an on-premise instance of Liferay DXP. However, there are also several differences in configuration and development workflow when working with an instance in DXP Cloud.

* [Choosing a Version](#choosing-a-version)
* [Deployment (Customization, Patching, and Licensing)](#deployment-customization-patching-and-licensing)
* [Configuration](#configuration)
* [Hot Deploy](#hot-deploy)
* [Enabling Clustering](#enabling-clustering)
* [Environment Variables](#environment-variables-reference)
* [Running Scripts](#running-scripts)

## Choosing a Version

The major version of Liferay DXP that you are using is configured within the `LCP.json` file within the `liferay/` folder of your Git repository. Set the major version as the `image` variable using a Docker image name within the `LCP.json` file:

```
"image": "liferaycloud/liferay-dxp:7.2-4.0.1"
```

Define the specific service pack and fix pack through the `gradle.properties` file within the same `liferay/` folder. The `liferay.workspace.docker.image.liferay` property defines another Docker image name with this specific fix pack level that is used for the actual deployment:

```properties
liferay.workspace.docker.image.liferay=liferay/dxp:7.2.10-sp2-202005120922
```

```note::
   If your DXP Cloud stack is not yet updated to 4.x.x, then by default, this version is instead located within a ``gradle.properties`` file at the root of the repository. In this case, define the version with the ``liferay.workspace.lcp.liferay.image`` property (which does not need to be defined separately from the major version). See `Understanding Service Stack Versions <../reference/understanding-service-stack-versions.md>`__ for more information on checking the version.
```

You can check the [Services Changelog](https://help.liferay.com/hc/en-us/sections/360006251311-Services-Changelog) for DXP Cloud to see a reference for each new release. Each new Service update includes Docker images that you can use for your instance. You can also directly check the [DXP tags on Docker Hub](https://hub.docker.com/r/liferay/dxp/tags?page=1) to find the Docker image names to use.

Use the new version from the release notes to update the Docker image value. The new Docker image will be used when your instance starts up or the next time you deploy the Liferay service from your repository. You can also use the Docker images for new releases to upgrade the properties for your other services.

## Deployment (Customization, Patching, and Licensing)

Deploying custom additions to Liferay DXP involves adding the new module, license, or hotfix to the appropriate locations in the Git repository.

With the exception of the `common/` directory, changes added to an environment-specific folder (e.g., `dev`, `uat`, `prod`) will _only_ be propagated when deploying to the corresponding environment. Changes added to a `common/` directory will _always_ be deployed, regardless of the target deployment environment. This applies to all subfolders within the `configs/` directory, for all services.

See [Overview of the Deployment Workflow](../build-and-deploy/overview-of-the-dxp-cloud-deployment-workflow.md) for more information on how the deployment workflow. For a tutorial on deploying to DXP Cloud, see [Deploying Changes via the DCP Cloud Console](../build-and-deploy/deploying-changes-via-the-dxp-cloud-console.md).

### Themes, Portlets, and OSGi Modules

To install themes, portlets, or OSGi modules, include a WAR or JAR file into a `configs/{ENV}/deploy/` folder in your Liferay DXP service directory.

For example, to deploy a custom JAR file to your development environment (using the `dev/` environment folder), your Liferay DXP service directory could look like this:

```
liferay
  ├── LCP.json
  └── configs
      └── dev
          ├── deploy
          │   └── com.liferay.apio.samples.portlet-1.0.0.jar
          ├── osgi
          ├── patching
          ├── scripts
          └── portal-ext.properties
```

```note::
   If you are using version 3.x.x services in your repository, then themes, portlets, and OSGi modules instead belong in the appropriate ``lcp/liferay/deploy/{ENV}`` folder. See `Understanding Service Stack Versions <../reference/understanding-service-stack-versions.md>`__ for more information on checking the version.
```

### Source Code

The source code for new additions can also be included in a CI build. When the build starts, it will automatically compile the source code.

A CI build will compile source code within these folders:

* The `liferay/modules` folder for new modules
* The `liferay/themes` folder for custom themes
* The `liferay/wars` folder for exploded WARs

```note::
   Source code will only be included in a deployment if it is deployed from a build in CI.
```

```note::
   If you are using version 3.x.x services, then these subfolders are located at the root of the repository instead of in the ``liferay/`` directory. See `Understanding Service Stack Versions <../reference/understanding-service-stack-versions.md>`__ for more information on checking the version.
```

### Hotfixes

To apply hotfixes, add the hotfix ZIP file to a `configs/{ENV}/patching/` folder within the Liferay DXP service directory. When you deploy this change, the hotfix is applied to the Liferay DXP instance.

For example, you can deploy a hotfix to your development environment with a structure like the following:

```
liferay
  ├── LCP.json
  └── configs
      └── dev
          ├── deploy
          ├── osgi
          ├── patching
          │   └── liferay-hotfix-2-7110.zip
          └── scripts
```

Note that hotfixes will each need to be re-applied each time the server starts up. For this reason, updating to the latest Fix Pack or Service pack of the Liferay DXP Docker image in your `LCP.json` file is better than adding many hotfixes into this folder for the long term; you can update the Docker version by replacing the `image` environment variable in this file (in the `liferay/` directory.

```note::
   If you are using version 3.x.x services, then hotfixes are instead added into the ``lcp/liferay/hotfix/`` folder. The Docker image version in this case is instead defined with the ``liferay.workspace.lcp.liferay.image`` property, in your repository's ``gradle.properties`` file. See `Understanding Service Stack Versions <../reference/understanding-service-stack-versions.md>`__ for more information on checking the version.
```

#### Patching via Environment Variable

You can also install hotfixes as part of the CI build process instead of directly committing them to your Git repository. This approach is ideal for large hotfixes so you can avoid keeping large files in your repository.

Add a comma-delimited list of hotfixes to the `LCP_CI_LIFERAY_DXP_HOTFIXES_{ENV}` environment variable (either through the `Environment Variables` tab in the DXP Cloud console, or in the `ci` service's `LCP.json` file) for the CI service to automatically apply them during the build process.

See the following example of defining hotfixes through in the `LCP.json` file:

```
"env": {
    "LCP_CI_LIFERAY_DXP_HOTFIXES_COMMON": "liferay-hotfix-10-7210,liferay-hotfix-17-7210",
    "LCP_CI_LIFERAY_DXP_HOTFIXES_DEV": "liferay-hotfix-15-7210,liferay-hotfix-33-7210",
}
```

```note::
   This environment variable is only available if you have upgraded to at least version 4.x.x services. See `Understanding Service Stack Versions <../reference/understanding-service-stack-versions.md>`__ for more information on checking the version.
```

### Licenses

You can add your own license by putting it into a `configs/{ENV}/deploy/` folder within the Liferay DXP service directory.

For example, you can add licenses to your development environment with a structure like this in your Liferay DXP service directory:

```
liferay
  ├── LCP.json
  └── configs
      └── dev
          ├── deploy
          │   ├── license.xml
          │   └── license.aatf
          ├── osgi
          ├── patching
          └── scripts
```

Behind the scenes, XML licenses are copied to `$LIFERAY_HOME/deploy`, and AATF licenses are copied to `$LIFERAY_HOME/data`.

```note::
   If you are using version 3.x.x services, then licenses instead belong in the ``lcp/liferay/license/{ENV}/ folder in your repository. See `Understanding Service Stack Versions <../reference/understanding-service-stack-versions.md>`__ for more information on checking the version.
```

## Configuration

Applying configurations to the Liferay service, like `portal.properties` changes, requires adding them to the Git repository and pushing the changes to Git. For more information on adding these configuration files, see [Configuring the Liferay DXP Service](./configuring-the-liferay-dxp-service.md).

## Hot Deploy

Hot deploy can be done via the Liferay DXP UI. To do so, navigate to the Control Panel → Apps → App Manager. Then, click the dots in the upper-right corner, and click "Upload." From this screen, you can choose a file from your local file system to deploy and install.

```note::
   Using hot deploy in DXP Cloud is *not* recommended because any customizations deployed with this method will be lost upon a subsequent DXP service deployment.
```

## Enabling Clustering

Clustering Liferay DXP in DXP Cloud is a very simplified process compared to doing so in Liferay DXP. Support for clustering is available and enabled out-of-the-box in DXP Cloud. Additional configurations for clustering behavior and scale does require a few extra steps. See [Setting Up Clustering in DXP Cloud](./setting-up-clustering-in-dxp-cloud.md) for more information.

## Running Scripts

Any `.sh` files found in the `configs/{ENV}/scripts` folder are automatically run prior to starting the service. Scripts may be used for more extensive customizations. However, use caution when doing so. This is the most powerful way to customize Liferay DXP and it can cause undesired side effects.

For example, to include a script that removes all log files, place it in the following directory structure within the project's Git repository:

```
liferay
├── LCP.json
└── configs
    └── dev
        ├── deploy
        ├── osgi
        ├── patching
        └── scripts
            └── remove-log-files.sh
```

```note::
   If you are using version 3.x.x services, then scripts instead belong in the ``lcp/liferay/script/`` folder in the repository. See `Understanding Service Stack Versions <../reference/understanding-service-stack-versions.md>`__ for more information on checking the version.
```

## Environment Variables Reference

Name                                  | Default Value | Description  |
------------------------------------- | ------------- | ------------ |
`LCP_PROJECT_LIFERAY_CLUSTER_ENABLED` | `true` | Whether to enable clustering and communication between nodes. |
`LCP_PROJECT_MONITOR_DYNATRACE_TENANT` |  | A string with eight characters. It's part of the URL (prefix) of your Dynatrace SaaS account. |
`LCP_PROJECT_MONITOR_DYNATRACE_TOKEN` |  | A string with 22 characters that you can find in your Dynatrace account at *Deploy Dynatrace* &rarr; *Start installation* &rarr; *Set up PaaS monitoring* &rarr; *Installer Download*. |
`LIFERAY_JAVA_OPTS` | | JVM options that will be appended to `CATALINA_OPTS` to override the default recommended options. |

## Additional Information

* [Logging Into Your DXP Cloud Services](../getting-started/logging-into-your-dxp-cloud-services.md)
* [Configuring the Liferay DXP Service](./configuring-the-liferay-dxp-service.md)
* [Deploying Changes via the DCP Cloud Console](../build-and-deploy/deploying-changes-via-the-dxp-cloud-console.md)
