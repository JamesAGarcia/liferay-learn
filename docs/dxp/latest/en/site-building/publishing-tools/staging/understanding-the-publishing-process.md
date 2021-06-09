# Understanding the Publishing Process

Publishing is the process whereby changes made in the Staging environment are transferred to the Live environment. Understanding this process can improve efficiency and help you plan ahead to achieve a seamless publishing experience.

* [The Staging Process](#the-staging-process)
* [Planning Ahead for Staging](#planning-ahead-for-staging)

## The Staging Process

From a low level perspective, staging is a relationship between two Sites or Asset Libraries where the same entities are mirrored between them. From a high level perspective, staging involves a publish process that is executed in three sequential phases: Export, Validation, and Import.

### Export Phase

During Export, your publish configuration is processed and necessary referenced entities are gathered. Then everything is processed into the instance's own file format, and it is either stored locally or transferred to the remote live DXP instance.

### Validation Phase

During Validation, everything is checked to determine whether it's possible to start the import process. This includes verifying the file versions and integrity, checking for additional system information (e.g., language settings), and ensuring that the files do not reference missing content.

If anything is not verified during the publish process, the transactional database reverts the Site or Asset Library back to its original state, discarding the current publish process. This is necessary to safeguard against publishing incomplete information.

However, if the Document Library's file system is not database-stored (e.g., [DBStore](../../../system-administration/file-storage/other-file-store-types/dbstore.md)), it's not transactional and isn't reverted if a staging failure occurs. This could cause a discrepancy between a file and its reference in the database. To preserve data integrity, ensure that regular backups of both the database and file system are maintained before staging the document library.

### Import Phase

During Import, any necessary updates or additions are made to the Site's content, layouts, and apps according to the publishing parameters. If everything is verified and correct, the staged content is published to your live Site. The same is true for Asset Libraries.

## Planning Ahead for Staging

Staging is a complex subsystem that's flexible and scalable. Before you begin using it for your Site or Asset Library, it's important to plan ahead and remember a few tips for a seamless process. There are several factors to evaluate.

### Content Types

Depending on the content in your Site and Asset Library, you can turn on Staging for only the necessary content types during your initial setup. You can also configure your publish process to only include certain types of content. Both of these measures can help to avoid unnecessary work.

### Hardware Environment

Plan your environment according to your content types. If your Site or Asset Library uses large images and video files, decide if a shared network drive is the best option. Storing many large images in the Document Library usually requires a faster network or local storage. If you're dealing with web content, however, these are usually smaller and take up very little disk space.

### Customizations and Custom Logic for Your Staging Environment

Your organization's business logic is most likely implemented in an app, and if you want to support Staging for that app, you must write some code to accomplish this. You can also consider changing default UI settings by writing new JSP code if you want to change your Staging environment's look and feel.

### Publishing Wait Times

Enable Staging at the beginning of Site or Asset Library creation to avoid huge publishing processes that can take a long time to execute. Small, incremental changes are far more performant than huge re-imaginings.

### JVM/Network Configuration

For Staging, JVMs/networks should be configured with a minimum of 4GB of memory and 20MB/s transfer rate (disk).

## Additional Information

* [Configuring Local Live Staging](./configuring-local-live-staging.md)
* [Configuring Remote Live Staging](./configuring-remote-live-staging.md)
