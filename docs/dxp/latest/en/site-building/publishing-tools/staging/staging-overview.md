# Staging Overview

You can use Liferay DXP's *Staging* tool to make changes to your Site or Asset Library behind the scenes in a *Staging environment* and then publish your changes to a local or remote *Live environment*, while the Live environment handles incoming User traffic.

```note::
   Asset Libraries support Staging as of Liferay DXP 7.3.10 FP1 and 7.4.
```

When setting up Staging, determine whether to host your Site or Asset Library locally (i.e., on the same server) or remotely (i.e., on separate servers connected by a network). Then customize which application data is staged. For Sites, you can also enable Page versioning for Widget Pages and Content Pages.

* [Configuration Options](#staging-configuration-options)
* [Understanding the Publishing Process](#understanding-the-publishing-process)

## Configuration Options

There are two options for configuring Staging : *Local Live Staging* and *Remote Live Staging*.

**Local Live Staging**: You can host both your Staging and Live environments on the same Liferay server. When enabled, Liferay DXP creates a local clone of your Site or Asset Library that serves as the Staging environment, while your original Site or Asset Library becomes your Live environment.

**Remote Live Staging**: You can host your Staging and Live environments on separate Liferay servers. When enabled, the Site or Asset Library used to configure Staging becomes your Staging environment, while the configured remote server becomes your Live environment.

While both options use the same interface for managing and publishing staged Pages, applications, and content, they differ in their setup. Once you've chosen the configuration option that best suits your needs, see [Configuring Local Live Staging](./configuring-local-live-staging.md) or [Configuring Remote Live Staging](./configuring-remote-live-staging.md) for more information and setup instructions.

### Staged Data and Content Types

As part of Staging configuration, you can select which content groups and application data is staged. If staged, the selected data and content are managed by your Staging environment. Also, when an application or content group is selected, all contained entities (e.g., application folders) are staged as well. See [Managing Data and Content Types in Staging](./managing-data-and-content-types-in-staging.md) for more information.


### Page Versioning

When configuring Staging for Sites, you can enable the *Page versioning* feature. With this feature, you and your team can simultaneously develop variations of a Site's Content Pages and Widget Pages, whether public or private. You can see the complete history of Page versions and revert Pages to an earlier version if needed. See [Page Versioning](./page-versioning.md) to learn how to create and manage variations and [Managing Staging Permissions](./managing-staging-permissions.md) to learn about managing permissions for each variation.

```note::
   Starting with Liferay DXP 7.4, 7.3 Fix Pack 1, and 7.2 Fix Pack 11, you can use page versioning in Widget Pages and Content Pages. In previous versions, you could only create variations for Widget Pages. To learn more about variations for each type of Page, see `Types of Variations <./page-versioning.md#types-of-variations>`_.
```

## Understanding the Publishing Process

From a low level perspective, staging is an equivalence relation where entities are mirrored to a different location. From a high level perspective, the staging process is executed in three sequential phases: Export, Validation, and Import.

Understanding this process can improve efficiency and help you plan ahead to achieve a seamless publishing experience. See [Understanding the Publishing Process](./understanding-the-publishing-process.md) for more information.

## Additional Information

* [Understanding the Publishing Process](./understanding-the-publishing-process.md)
* [Configuring Local Live Staging](./configuring-local-live-staging.md)
* [Configuring Remote Live Staging](./configuring-remote-live-staging.md)
* [Site Staging UI Reference](./site-staging-ui-reference.md)
