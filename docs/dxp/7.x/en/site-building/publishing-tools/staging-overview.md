# Staging Overview

Liferay DXP's *Staging* tool can help you manage and publish your Site's Pages and content for a seamless publication experience. With it, you can make changes to your Site behind the scenes in a *Staging environment* and then publish your changes to a local or remote *Live environment*, while the Live environment handles incoming User traffic.

As part of Staging configuration, determine whether to host your environments on the same server, or separate servers connected by a network. You can also enable Page versioning and customize which Site content and application data is staged.

* [Configuration Options](#staging-configuration-options)
* [Understanding the Publication Process](#understanding-the-publication-process)

## Configuration Options

Liferay DXP provides two options for configuring Staging on your Site: *Local Live Staging* and *Remote Live Staging*.

**Local Live Staging**: With *Local Live Staging*, you host both your Staging and Live environments on the same Liferay server. When enabled, Liferay DXP creates a local clone of your Site that serves as the Staging environment, while your original DXP instance becomes your Live environment.

**Remote Live Staging**: With *Remote Live Staging*, you host your Staging and Live environments on separate Liferay servers. When enabled, the Site used to configure Staging becomes your Staging environment, while the configured <!--w/c--> remote server becomes your Live environment.

While both options use the same interface for managing and publishing staged Pages, applications, and content, they differ in their setup. Once you've chosen the configuration option that best suits your needs, see [Configuring Local Live Staging](./configuring-local-live-staging.md) and [Configuring Remote Live Staging](./configuring-remote-live-staging.md) for more information and setup instructions.

### Page Versioning

As part of Staging, you can enable the *Page versioning* feature. With this feature, you and your team can simultaneously develop and work in variations of both your Private and Public Pages. This feature also maintains a history of Page versions that you can use to revert Pages to an earlier version if needed. See [Page Versioning](./page-versioning.md) to learn how to create and manage variations, and [Managing Staging Permissions](./managing-staging-permissions.md) to learn about managing permissions for each variation.

```note::
   Page versioning is only supported for Widget Pages.
```

### Staged Data and Content Types

As part of Staging configuration, you can select which content groups and application data is staged. If staged, the selected data and content are managed by your Staging environment. Also, when an application or content group is selected, all contained entities (e.g., application folders) are staged as well. See [Managing Data and Content Types in Staging](./managing-data-and-content-types-in-staging.md) for more information.

## Understanding the Publication Process



## Additional Information

* [Understanding the Publication Process](./understanding-the-publication-process.md)
* [Configuring Local Live Staging](./configuring-local-live-staging.md)
* [Configuring Remote Live Staging](./configuring-remote-live-staging.md)
* [Page Versioning](./page-versioning.md)
* [Staging UI Reference](./staging-ui-reference.md)
