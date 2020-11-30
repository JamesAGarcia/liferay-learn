# Continuous Integration

DXP Cloud uses [Jenkins](https://jenkins.io/) to power its continuous integration infrastructure service. When you send a pull request or push a commit to one of your pre-configured GitHub branches, an automatic and configurable build will be triggered.

```note::
   DXP Cloud customers (using the ``customer`` login) have permissions to manage and review their builds, but do not have full administrative privileges.
```

By default, this automated build will compile code and can be configured to execute tests. DXP Cloud will build your services and show their status on your environment's Builds page. If the tests fail, you can check the Jenkins dashboard and logs at `https://ci-companyname-infra.lfr.cloud`.

```note::
   Continuous integration only works if you deploy from GitHub, GitLab, or Bitbucket, not the CLI.
```

## Using the Default Jenkinsfile

Starting with CI service version `liferaycloud/jenkins:2.222.1-3.2.0`, a default Jenkinsfile is available when it is not overridden. The default Jenkinsfile is always available for use for projects [using version 4.x.x services](../reference/understanding-service-stack-versions.md).

The default Jenkinsfile encapsulates all the logic that was previously stored on the Jenkinsfile and moves it to a Jenkins plugin. This means that all bug fixes, security fixes, and improvements can be applied without requiring any CI configuration.

Apart from that, a powerful set of extension points are now provided to customize every step of the CI pipeline.

### Enable the Default Jenkinsfile

If your project is already updated to [version 4.x.x](../reference/understanding-service-stack-versions.md), then these steps are already complete. Otherwise, enable the default Jenkinsfile by performing the following steps:

1. Update your CI service to version `liferaycloud/jenkins:2.222.1-3.2.0`

1. Delete the `Jenkinsfile` located on the root folder

1. Add the following environment variable: `LCP_CI_USE_DEFAULT_JENKINSFILE: true`

1. Deploy Jenkins service

### Extending the Default Jenkinsfile

To extend the default Jenkinsfile, you can add the following files to the `ci` folder in your project repository:

- `Jenkinsfile-before-all`
- `Jenkinsfile-before-cloud-build`
- `Jenkinsfile-before-cloud-deploy`
- `Jenkinsfile-after-all`
- `Jenkinsfile-post-always`

Here is a basic overview of the steps in the CI build process:

1. Load `ci/Jenkinsfile-before-all`, if it exists.

1. Build the Liferay Workspace.

1. Load `ci/Jenkinsfile-before-cloud-build`, if it exists.

1. Create the DXP Cloud build that you see in console.

1. Load `ci/Jenkinsfile-before-cloud-deploy`, if it exists.

1. Optionally deploy the build to an environment in the cloud, depending on if
   the current branch has been specified as the deploy branch. This is
   configured through the `LCP_CI_DEPLOY_BRANCH` environment variable. The
   `LCP_CI_DEPLOY_TARGET` environment variable specifies which environment to deploy
   to.

1. Load `ci/Jenkinsfile-after-all`, if it exists. This will run when all steps are done.

1. Load `ci/Jenkinsfile-post-always`, if it exists. This will run both when the
   build fails and when it succeeds.

```note::
   If you are using version 3.x.x services, then these extensions to the Jenkinsfile are located in the ``lcp/ci/`` folder instead. See `Understanding Service Stack Versions <../reference/understanding-service-stack-versions.md>`__ for more information on checking the version.
```

To see how they are used in the default pipeline, monitor the Jenkins service startup logs. The full default Jenkinsfile is printed out in the startup logs.

## Extra Pipeline Customization and External Calls

It is possible to use the additional steps in your pipeline to call external services. For example, you may call a third-party monitoring service through REST API, or call a script to run during the build process.

You can also create your own pipeline by defining your own `Jenkinsfile` in your repository's `ci/` folder. See the [Jenkins website](https://www.jenkins.io/doc/book/pipeline/jenkinsfile/) for more information.

```warning::
   External services or custom pipelines should be used with discretion and are outside the scope of DXP Cloud Support. Custom Jenkins plugins are not supported.
```

```note::
   If you are using version 3.x.x services and defining your own ``Jenkinsfile``, then you should define it at the root of your repository instead. See `Understanding Service Stack Versions <../reference/understanding-service-stack-versions.md>`__ for more information on checking the version.
```

## Reusing Code Between Different Extension Points

You will likely want a way to share code between these extension points. One basic way is to load a groovy script. For example, you could create a groovy file in the `ci/` folder called `util.groovy` with these contents:

```
def sendSlackMessage(message) {
	println(message)
}

return this
```

Then you could insert the following in `ci/Jenkinsfile-before-cloud-build`:

```
def util = load("ci/util.groovy")

util.sendSlackMessage("About to create DXP Cloud build...")
```

```note::
   If you are using version 3.x.x services, then these files instead belong in the ``lcp/ci/`` directory in the repository. See `Understanding Service Stack Versions <../reference/understanding-service-stack-versions.md>`__ for more information on checking the version.
```

## Environment Variables Reference

The following environment variables are only used in the default Jenkinsfile. To see what they do please refer to [Jenkins documentation regarding pipeline options](https://jenkins.io/doc/book/pipeline/syntax/#options).

Name                                          | Default Value   | Description |
--------------------------------------------- | --------------- | ----------- |
`LCP_CI_USE_DEFAULT_JENKINSFILE`      | `false`         | Option to enable or disable the Default Jenkinsfile |
`LCP_CI_LIFERAY_DXP_HOTFIXES_{ENV}`   |                 | Comma-delimited list of hotfixes for CI to apply automatically when deploying the Liferay service. Replace `{ENV}` with the environment name (in all-caps), or `COMMON`. |
`LCP_CI_BUILD_TIMEOUT_MINUTES`        | `30`            | Set a timeout period for the Pipeline run, after which Jenkins should abort the Pipeline  |
`LCP_CI_PRESERVE_STASHES_BUILD_COUNT` | `20`            | Set the number of recent builds for which *stashes* are preserved. Stashes cannot be preserved for more builds than allowed by the `LCP_CI_ARTIFACT_NUM_TO_KEEP` variable. |
`LCP_CI_BUILD_NUM_TO_KEEP`            | `10`            | Number of builds that are stored |
`LCP_CI_BUILD_DAYS_TO_KEEP`           | `14`            | Number of days that builds are stored |
`LCP_CI_ARTIFACT_NUM_TO_KEEP`         | `1`             | Set the number of recent builds for which *artifacts* and *stashes* are preserved. |
`LCP_CI_ARTIFACT_DAYS_TO_KEEP`        | `-1`            | Number of days that artifacts are stored |

## Additional Information

* [Logging into your DXP Cloud Services](../getting-started/logging-into-your-dxp-cloud-services.md)
* [Configuring Your GitLab Repository](../getting-started/configuring-your-gitlab-repository.md)
* [Configuring Your Bitbucket Repository](../getting-started/configuring-your-bitbucket-repository.md)
* [DXP Cloud Project Changes in Version 4](../reference/dxp-cloud-project-changes-in-version-4.md)
<!-- While Version 3 is still supported, because of the fact a large part of this article hinges on the project version, this link may be helpful. This link should likely be removed once version 3 is no longer supported. -->