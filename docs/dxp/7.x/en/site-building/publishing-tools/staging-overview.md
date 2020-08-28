# Staging Overview

Liferay DXP's *Staging* tool can help you manage and publish your Site's Pages and content for a seamless publication experience. With it, you can make changes to your Site behind the scenes in a *Staging environment* and then publish your changes to a local or remote *Live environment*, while the Live environment handles incoming User traffic.

As part of Staging configuration, determine whether to host your environments on the same server, or separate servers connected by a network. You can also enable Page versioning and customize which Site content and application data is staged.

* [Configuration Options](#staging-configuration-options)
* [Page Versioning](#page-versioning)
* [Staged Content](#staged-content)
* [Understanding the Publication Process](#understanding-the-publication-process)
* [Planning Ahead for Staging](#planning-ahead-for-staging)

## Configuration Options

Liferay DXP provides two options for configuring Staging on your Site: *Local Live Staging* and *Remote Live Staging*.

**Local Live Staging**: With *Local Live Staging*, you host both your Staging and Live environments on the same Liferay server. When enabled, Liferay DXP creates a local clone of your Site that serves as the Staging environment, while your original DXP instance becomes your Live environment.

**Remote Live Staging**: With *Remote Live Staging*, you host your Staging and Live environments on separate Liferay servers. When enabled, the Site used to configure Staging becomes your Staging environment, while the configured <!--w/c--> remote server becomes your Live environment.

While both options use the same interface for managing and publishing staged Pages, applications, and content, they differ in their setup. Once you've chosen the configuration option that best suits your needs, see [Configuring Local Live Staging](./configuring-local-live-staging.md) and [Configuring Remote Live Staging](./configuring-remote-live-staging.md) for more information and setup instructions.

## Page Versioning

As part of Staging, you can enable the *Page versioning* feature. With this feature, you and your team can simultaneously develop and work in variations of both your Private and Public Pages. This feature also maintains a history of Page versions that you can use to revert Pages to an earlier version if needed. See [Page Versioning](./page-versioning.md) to learn how to create and manage variations, and [Managing Staging Permissions](./managing-staging-permissions.md) to learn about managing permissions for each variation.

```note::
   Page versioning is only supported for Widget Pages.
```

## Staged Data and Content Types

As part of Staging configuration, you can select which content groups and application data is staged. If staged, the selected data and content are managed by your Staging environment. Also, when an application or content group is selected, all contained entities (e.g., application folders) are staged as well. See [Managing Data and Content Types in Staging](./managing-data-and-content-types-in-staging.md) for more information.

## Understanding The Publication Process

Publication is the process whereby your Site's Pages, content, and application configurations are transferred from Staging to Live. Understanding this process can improve efficiency and help you plan ahead to achieve a seamless publishing experience.

From a low level perspective, staging is an equivalence relation where entities are mirrored to a different location. From a high level perspective, the staging process is executed in three sequential phases: Export, Validation, and Import.

### Export Phase

During *Export*, your publication configuration is processed and necessary/obligatory<!--w/c--> referenced entities are gathered. Then everything is processed into the instance's own file format, per publication parameters,<!--necessary clause?--> which is either stored locally or transferred to the remote live DXP instance.

### Validation Phase

During *Validation*, everything is checked to determine whether it's possible to start the import process. This includes verifying the file's version and integrity, checking for additional system information (e.g., language settings), and ensuring there is no missing content referenced. <!--awk, necessary wording?-->

If anything is not verified during the publication process, the transactional database reverts the Site back to its original state, discarding the current publication. This is a necessary action to safeguard against publishing incomplete information, which could break an otherwise well-designed live Site.

However, if the file system is not database-stored (e.g., DBStore), it's not transactional and isn't reverted if a staging failure occurs. This could cause a discrepancy between a file and its reference in the database. So to preserve data integrity, ensure that regular backups of both the database and file system are maintained before staging the document library.

### Import Phase

During *Import*, any necessary updates or additions are made to the Site's content, layouts, and apps according to the publishing parameters. If everything is verified and correct, the staged content is published to your live Site.

## Planning Ahead for Staging

Staging is a complex subsystem that's flexible and scalable. Before advanced users and administrators begin using it for their Site, it's important to plan ahead and remember a few tips for a seamless process. There are several factors to evaluate.

### Content Types

Depending on the content in your Site, you can turn on Staging for only the necessary content types during your initial setup. You can also configure your publications to only include certain types of content. Both of these measures can help to avoid unnecessary work.

### Hardware Environment

You should plan your environment according to your content types. If your Site operates on large images and video files, decide if a shared network drive is the best option. Storing many large images in the Document Library usually requires a faster network or local storage. If you're dealing with web content, however, these are usually smaller and take up very little disk space.

### Customizations and Custom Logic for Your Staging Environment

Your organization's business logic is most likely implemented in an app, and if you want to support Staging for that app, you must write some code to accomplish this. You can also consider changing default UI settings by writing new JSP code if you want to change your Staging environment's look and feel.

### Publication Wait Times

It's recommended users enable Staging at the beginning of the Site creation process to avoid waiting for huge publications that can take long periods to execute. Taking smaller steps throughout the publication process forms an iterative creative process as the Site is built from the ground up, where content creators can publish their changes immediately.

### JVM/Network Configuration

For Staging, it's recommended JVMs/networks are configured with a minimum of 4GB of memory and 20MB/s transfer rate (disk).

## Additional Information

* [Configuring Local Live Staging](./configuring-local-live-staging.md)
* [Configuring Remote Live Staging](./configuring-remote-live-staging.md)
* [Page Versioning](./page-versioning.md)
* [Staging UI Reference](./staging-ui-reference.md)
