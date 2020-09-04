# Understanding The Publication Process

Publication is the process whereby your Site's Pages, content, and application configurations are transferred from Staging to Live. Understanding this process can improve efficiency and help you plan ahead to achieve a seamless publishing experience.

* [The Staging Process](#the-staging-process)
* [Planning Ahead for Staging](#planning-ahead-for-staging)

## The Staging Process

From a low level perspective, staging is an equivalence relation where entities are mirrored to a different location. From a high level perspective, the staging process is executed in three sequential phases: Export, Validation, and Import.

### Export Phase

During *Export*, your publication configuration is processed and necessary/obligatory<!--w/c--> referenced entities are gathered. Then everything is processed into the instance's own file format, per publication parameters, and is either stored locally or transferred to the remote live DXP instance.

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

## Additional