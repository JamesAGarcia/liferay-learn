# Troubleshooting Tools and Resources

The ability to quickly diagnose and resolve technical issues is vital. Familiarize yourself with available tools and resources for troubleshooting problems pre- and post-launch in your Liferay DXP Cloud projects:

* [Application Metrics](#application-metrics)
* [Real-Time Alerts](#real-time-alerts)
* [Environment Activities](#environment-activities)
* [Environment Logs](#environment-service-logs)
* [Shell Access](#shell-access)
* [Support Access](#support-access)
* [Self-Healing](#self-healing)
* [Disaster Recovery](#disaster-recovery)
* [Liferay Cloud Platform Status](#liferay-cloud-platform-status)
* [Liferay DXP Cloud Updates](#liferay-dxp-cloud-updates)
* [Help Center](#help-center)

With these tools and resources, you can track project activities, configure services, resolve technical issues, and more.

```note::
   Details are subject to your legal agreement with Liferay. For information about legal agreements and services, see the `Liferay Legal <https://www.liferay.com/legal>`_ page.
```

## Application Metrics

With Liferay DXP Cloud’s built-in monitoring, you can track resources used by each environment service. These application metrics include memory and CPU usage, as well as network data transfer.

Metrics are available for the default DXP Cloud stack services: Webserver, Liferay, Search, Database, and Backup. CI metrics are also available in the infra environment.

![Figure 1: View application metrics via the Monitoring page in the DXP Cloud console](./troubleshooting-tools-and-resources/images/01.png)

Users can also integrate [Dynatrace’s](https://www.dynatrace.com/) advanced performance monitoring with production environments.

See [Application Metrics](../manage-and-optimize/application-metrics.md) for more information.

## Real-Time Alerts

Liferay DXP Cloud can alert system administrators of unexpected behaviors in a project. Examples of unexpected behaviors include auto-scaling events, higher than expected memory consumption, reaching the allotted CPU quota, and database connection issues.

View all environment alerts and set alert preferences via the DXP Cloud console.

![Figure 2: View and manage alerts via the Alerts page in the DXP Cloud console](./troubleshooting-tools-and-resources/images/02.png)

See [Real-Time Alerts](../manage-and-optimize/real-time-alerts.md) for more information.

## Environment Activities

Within each environment, activities are organized into two sections: *Builds and Deployments* and *General Activities*.

**Builds and Deployments**: This section lists all build, deployment, and CI related activities in a project environment. Each entry includes a Build ID, start time, duration, and status (e.g., in process, successful, failed, interrupted).

**General Activities**: This section lists automated service events and manual team member activities other than build, deployment, and CI activities. General activities include the following categories: Services, Settings, Backup, Scaling, and Membership.

![Figure 3: View environment activities from the DXP Cloud console](./troubleshooting-tools-and-resources/images/03.png)

See [Team Activities](../manage-and-optimize/team-activities.md) for more information.

## Environment Logs

Environment logs are crucial for diagnosing and resolving technical issues in a project. You can access and download environment logs via the DXP Cloud console or your OS terminal.

Application, status, and build logs are provided for each DXP Cloud Service:

* **Application Logs**: These logs list runtime information generated after the application is running and accessed by users.
* **Status Logs**: These logs list orchestration layer information from the Kubernetes cluster.
* **Build Logs**: These logs list build information generated as the application boots up.

![Figure 4: View logs via the Logs page in the DXP Cloud console](./troubleshooting-tools-and-resources/images/04.png)

See [Log Management](./log-management.md) for more information.

## Shell Access

Command-line tools in the DXP Cloud console contribute to the developer's workflow by delivering speed, control, traceability, scripting, and automation capabilities.

Use the shell access tool to see what's going on inside your application, including side effects not easily spotted in logs.

![Figure 5: Use the shell access tool in the DXP Cloud console to see what's going on inside your application.](./troubleshooting-tools-and-resources/images/05.png)

See [Shell Access](./shell-access.md) for more information.

## Support Access

Support Access is an optional setting that expedites troubleshooting by giving Liferay engineers direct access to a DXP Cloud project environment.

DXP Cloud administrators can enable or disable Support Access for individual project environments from the environment *Settings* page.

See [Support Access](./support-access.md) for more information.

## Self-Healing

The self-healing functionality of DXP Cloud detects if a service or application has become unresponsive and automatically initiates procedures to recover the unresponsive service. The platform uses probes to monitor the services.

DXP Cloud offers two probes used in conjunction to manage applications:

* **Liveness Probe**: This probe indicates whether the service is running.
* **Readiness Probe**: This probe indicates whether the service is ready to receive requests.

See [Self-Healing](./self-healing.md) for more information about configuring each probe.

## Disaster Recovery

Liferay DXP Cloud offers two strategies for disaster recovery: Automatic and Cross-Region.

Liferay DXP Cloud's automatic disaster recovery strategy replicates services between three availability zones within the same region. If an availability zone becomes unavailable, the load balancer will automatically route to the remaining availability zones without the need for user action.

However, in the event of a cross-region disaster, users intervention is required. To learn more about cross-region disaster recovery processes and tools, see [Configuring Cross Region Disaster Recovery](./configuring-cross-region-disaster-recovery.md).

See [Disaster Recovery Overview](./disaster-recovery-overview.md) to learn more about both disaster recovery strategies.

## Liferay Cloud Platform Status

Users can view the status of Liferay Cloud Platform systems, planned maintenance windows, and incident history from the [Liferay Cloud Platform](https://status.liferay.cloud/) status page.

You can also *Subscribe to Updates* to receive the latest notifications of any service status changes.

![Figure 6: View the status of Liferay Cloud Platform systems.](./troubleshooting-tools-and-resources/images/06.png)

See [Liferay Cloud Platform Status](./liferay-cloud-platform-status) for more information.

## Liferay DXP Cloud Updates

Optimize your Liferay-based projects by getting the latest [Liferay DXP Cloud Updates](https://www.liferay.com/web/l/subscribe-to-liferay-dxp-cloud-updates) sent directly to your email.

These notifications include:

* New Platform Releases
* New Services Updates
* Security Alerts and Patches

Liferay DXP Cloud notifications are only distributed to customers with an active Liferay Enterprise Subscription.

## Help Center

If you have questions not answered by DXP Cloud [Documentation](https://learn.liferay.com/dxp-cloud-latest/) or would like to report an issue, sign in to the Liferay [Help Center](https://help.liferay.com/) to view subscription-only resources or submit a ticket.

![Figure 07: View subscription-only resources or submit a ticket via the Liferay Help Center page](./troubleshooting-tools-and-resources/images/07.png)

From here, you can access the DXP Cloud [Knowledge Base](https://help.liferay.com/hc/en-us/categories/360001132872), [Product Support](https://help.liferay.com/hc/en-us/articles/360030208451-DXP-Cloud-Support-Overview), and [Announcements](https://help.liferay.com/hc/en-us/categories/360001192512).

When submitting a ticket, please provide the build images currently in use, behavior or question you are facing, steps to reproduce the issue, and a description of both the actual behavior and the expected behavior.

Phone support is also provided from six Support Centers located across the globe. See [Contact Us](https://help.liferay.com/hc/en-us/articles/360017784212?_ga=2.254167624.1908736764.1562000563-1350017715.1560788053) for Support Region phone numbers.
