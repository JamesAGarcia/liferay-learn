# Command-Line Tool

Liferay's CLI tool can be used to view and manage your DXP Cloud services. Once installed, you can run `lcp --help` in your terminal to view available actions.

* [Installing the CLI Tool](#installing-the-cli-tool)
* [Upgrading the CLI Tool from v2 to v3](#upgrading-the-cli-tool-from-v2-to-v3)
* [Configuring the CLI Remote](#configuring-the-cli-remote)
* [Showing the Service Logs](#showing-the-service-logs)
* [Changing the Number of Service Instances](#changing-the-number-of-service-instances)
* [Listing Projects or Services](#listing-projects-or-services)
* [Restarting a Service](#restarting-a-service)
* [Accessing a Service's Shell](#accessing-a-services-shell)
* [Uninstalling v3 of the CLI Tool](#uninstalling-v3-of-the-cli-tool)

## Installing the CLI Tool

### \*nix Systems

Open your terminal, and run the following command:

```bash
curl https://cdn.liferay.cloud/lcp/stable/latest/install.sh -fsSL | bash
```

If you get a permissions error, try running the same command with `sudo`.

### Windows Systems

Download the latest version of the [Windows installer](https://cdn.liferay.cloud/lcp/stable/latest/lcp-install.exe), and follow the steps in the wizard.

## Upgrading the CLI Tool from v2 to v3

If you're running v2 of the CLI tool and want to upgrade to v3, you must first uninstall your current version before you can install and use v3. This prevent conflicts with the same binary name.

```important::
   The following instructions are specific to uninstalling CLI v2 and are **not** the same as those for `uninstalling v3 of the CLI tool <#uninstalling-v3-of-the-cli-tool>`__.
```

### Uninstalling v2 on MacOS or Linux

1. Open a terminal and run: `lcp uninstall`.

1. Verify uninstall is complete by running the command `lcp`.

### Uninstalling v2 on Windows

1. In Windows 10, go to *Control Panel* &rarr; *Programs* &rarr; *Uninstall a program*. Alternatively, for Windows 7 and 8, go to *Control Panel* &rarr; *Add or Remove Programs*.

1. Select `lcp amd64-installer-0.3`

1. Click _Uninstall_ then confirm.

1. Verify uninstall is complete by running the command `lcp` or `lcp.exe`.

Verify that CLI version 2 has been uninstalled before installing version 3.

### Installing v3

Once v2 is uninstalled, you can following the [above instructions](#installing-the-cli) to install v3 of the CLI tool.

## Configuring the CLI Remote

To access DXP Cloud services via the CLI tool, it must be configured to point to DXP Cloud's remote URL: `liferay.cloud`. To list the CLI's remotes, run the following command:

```shell
lcp remote
```

You can add new remotes to the CLI tool using the following command:

```shell
lcp remote set <remote-alias> <remote-url>
```

If desired, you can change its default remote:

```shell
lcp remote default <remote-alias>
```

Alternatively, you can specify the remote inline:

```shell
lcp shell -p <project-id> --service <service-id> --remote <remote-alias>
```

## Showing the Service Logs

Use `lcp log` commands to display logs for specific projects, services, and instances. The following examples include some common commands, though you can see available command options by running `lcp log --help`.

View all service logs for a project environment:

```shell
lcp log -p <project>-<environment>
```

View logs for a single service in a project environment:

```shell
lcp log -p <project>-<environment> -s <service>
```

Alternatively, use a service's full URL to view its logs:

```shell
lcp log --url <service>-<project>-<environment>.lfr.cloud
```

By default, the `lcp log` command only returns 10,000 lines to reduce network impact. However, you can avoid this restriction by using `--since` and `--until` parameters to specify a period of time (e.g., `yesterday`, `"yesterday at 9pm"`, `"10 minutes ago"`, `"mm/dd/YYYY HH:mm:ss"`).

View all service logs for a project environment from a specific time to the present:

```shell
lcp log -p <project>-<environment> --since <start_time>
```

View all service logs for a project environment from a specific period of time:

```shell
lcp log --since "<start_time>" --until "<end_time>"
```

You can also pipe the output of an `lcp log` command into a file by appending `>> "<new-file.txt>"` to the end of the command. When run, the new file is created in your terminal's current path.

```shell
lcp log -p <project>-<environment> -s <service> --since "<start_time>" --until "<end_time>" >> "<new-file.txt>"
```

## Changing the Number of Service Instances

Use `lcp scale` commands to individually scale environment services. The following examples include some common commands, though you can see available command options by running `lcp scale --help`.

View all services and their instances for a project environment, and then select a service to scale:

```shell
lcp scale -p <project>-<environment>
```

Then, follow the terminal prompts to select a service and determine the number of its instances.

Alternatively, specify the target service and desired number of instances as part of the `lcp scale` command:

```shell
lcp scale -p <project>-<environment> -s <service> <instances>
```

You can also scale instances using its full URL:

```shell
lcp scale --url <service>-<project>-<environment>.lfr.cloud <instances>
```

## Listing Projects or Services

Use `lcp list` commands to view project services, each with its image and status. The following examples include some common commands, though you can see available command options by running `lcp list --help`.

View a complete list of projects, services, and instances that you either own or collaborate on:

```shell
lcp list
```

View the image and status of environment specific services:

```shell
lcp list -p <project>-<environment>
```

Check the image and status of a specific service:

```shell
lcp list -p <project>-<environment> --service <serviceID>
```

Alternatively, you can check a service by passing its full URL to `lcp list`:

```shell
lcp list --url <service>-<project>-<environment>.lfr.cloud
```

## Restarting a Service

Use `lcp restart` commands to restart an environment service. The following examples include some common commands, though you can see available command options by running `lcp restart --help`.

View all project environments and services, and then select an environment service to restart:

```shell
lcp restart
```

Restart a specific service in a project:

```shell
lcp restart -p <project>-<environment> -s <service>
```

Alternatively, restart a service by passing its full URL to `lcp restart`:

```shell
lcp restart --url <serviceID>-<projectID>.lfr.cloud
```

## Accessing a Service's Shell

To access a service container's shell, run the following command:

```shell
lcp shell
```

This lists all the services in the container and prompts users you to choose
which one to access.

Alternatively, access the shell of a specific service's container by adding the
service's project ID and service ID to the `lcp shell` command:

```shell
lcp shell -p <project>-<environment> -s <service>
```

## Open docs

Use the `lcp docs` command to access Liferay DXP Cloud resources, including official documentation, Help Center content, and more.

## Uninstalling v3 of the CLI Tool

For Mac and Linux, run the following command:

```bash
curl https://cdn.liferay.cloud/lcp/stable/latest/uninstall.sh -fsSL | bash
```

For Windows 7 and 8, go to *Control Panel* &rarr; *Add or Remove Programs*. In Windows 10, go to *Control Panel* &rarr; *Programs* &rarr; *Uninstall a program*. Then, find *LCP CLI* in the list of programs, select it, and click *Uninstall*. Follow the steps in the wizard.

## Additional Information

* [Troubleshooting Tools and Resources](../troubleshooting/troubleshooting-tools-and-resources.md)
* [Deploying Changes Via the CLI Tool](../build-and-deploy/deploying-changes-via-the-cli-tool.md)
* [Upgrading Your DXP Cloud Stack](./upgrading-your-dxp-cloud-stack.md)
