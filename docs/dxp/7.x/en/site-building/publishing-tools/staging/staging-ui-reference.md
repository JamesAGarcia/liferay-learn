# Staging UI Reference

After enabling Local or Remote Live Staging for your Site, most Page configuration options are only accessible in your Staging environment. This prevents Users from directly editing Live Pages.

Also, once staging is enabled, you can access additional options in your Staging environment. These options are in the *Staging bar*, *Publish to Live* menu, and *Staging Page*.

* [Staging Bar](#staging-bar)
* [Publish to Live](#publish-to-live)
* [Staging Page](#staging-page)

## Staging Bar

When Staging is enabled for a Site, you can access additional options via the Staging bar on each of your Site's Pages. In this bar you can toggle between Staging and Live environments, as well as click on *Publish to Live* for your staged Pages.

![When Staging is enabled for a Site, you can access the Staging bar on each of your Site's Pages](./staging-ui-reference/images/02.png)

You can also access the following options for Widget Pages in your Staging environment via the Staging bar:

* **Site Pages Variation**: You can toggle between variations of Page sets in your staged Site using the drop-down menu. You can also manage and create Page set variations by clicking on the *Actions* button ( ![Actions button](../../../images/icon-actions.png) ) in the Staging bar and selecting *Site Pages Variation*. See [Page Versioning](./page-versioning.md) for more information.

* **Page Variations**: You can toggle between variations of a single Page in your staged Site using the drop-down menu. You can also manage and create Page variations by clicking on the *Actions* button ( ![Actions button](../../../images/icon-actions.png) ) in the Staging bar and selecting *Page Variations*. See [Page Versioning](./page-versioning.md) for more information.

* **Undo/Redo**: You can undo or redo recent changes to a Page by clicking on the *Actions* button (![Actions button](../../../images/icon-actions.png)) in the Staging bar and selecting *Undo*/*Redo*. Once you've marked a Page as *Ready for Publication*, you can't undo or redo recent changes.

* **History**: You can view and manage the Page revision history by clicking on the *Actions* button (![Actions button](../../../images/icon-actions.png)) in the Staging bar and selecting *History*. From here, you can also revert a Page to an earlier version by clicking on the *Actions* button (![Actions button](../../../images/icon-actions.png)) for the Page version you want to restore and selecting *Mark as Ready for Publication*.

* **Ready for Publication**: When you have finished making your changes, click on *Ready for Publication* to change the Page's status from *Draft* to *Ready for Publication*. You can then click *Publish to Live* to configure and initiate the publication process for your changes. When you publish a Page to Live, only the version marked as *Ready for Publication* is published.

## Publish to Live

When you click on *Publish to Live*, a modal window appears with additional options for configuring your publication. You can publish using *Simple* or *Advanced* settings.

![Click on Publish to Live to access the publishing modal window.](./staging-ui-reference/images/03.png)

## Simple Publication

**Name**: Enter a descriptive name for your publication into the *Name* field.

**Changes Since Last Publication**: View staged changes made since your last publication.

**Pages to Publish**: View the number of Pages included in your publication.

```note::
   This displays the number of Page deletions tracked by the Staging framework. Keep in mind that this number counts the Page deletions on the Staging Site, not how many Pages will be deleted on the on the Live Site. There could be an inconsistency between the number of Page deletions to be published and the actual number of Pages present on either of the Staging and Live Sites.
```

When ready, click on *Publish to Live* to initiate publishing.

![Click on Publish to Live to initiate publishing.](./staging-ui-reference/images/04.png)

## Advanced Publication

With Advanced Publication, you can choose to define custom publication settings or use a saved publishing template. To access advanced publication settings, click on *Switch to Advanced Publication* in the modal window.

Here, you can access information and settings that you can use to customize your publication. In the *Custom* tab, you can specify content, dates, Pages, and more for your publication. You can switch to the *Publish Template* tab and use a pre-configured template for your publication.

![Use advanced setting to customize your publication.](./staging-ui-reference/images/05.png)

Custom advanced publication settings are divided into the following sections:

**Name**: Enter a descriptive name for your publication into the *Name* field.

**Date**: Select whether to publish your changes immediately, or *schedule* your changes to be published at a later date and time. You can also determine whether and how frequently your publication is repeated.

![Select when to publish your changes.](./staging-ui-reference/images/06.png)

**Deletions**: Select whether you want to *Delete Application Data Before Importing*, and whether you want to *Replicate Individual Deletions*.

![Select whether you want to Delete Application Data Before Importing and whether you want to Replicate Individual Deletions.](./staging-ui-reference/images/07.png)

**Pages**: Select which Page set variation and individual Pages you want to publish, as well as the look and feel of your selected Pages. You can also select whether to *Delete Missing Pages*, which deletes all Pages from the Live Site that are not present on the Staging Site. If you choose a Page to be published from the Pages menu, the widgets and their references are always published.

![Select which Page set variation and individual Pages you want to publish, as well as the look and feel of your selected Pages.](./staging-ui-reference/images/08.png)

If you want to publish pages with a custom theme, you must check the Theme Settings option under the *Look and Feel* heading for your staging configuration. Otherwise, the default theme is applied.

**Content**: Select the content you want to include in your publication. You can publish *all* content of the selected types, or specify a date and time parameter to limit the content published. You can also click on *Change* for each content type to manage items and other settings included in each type, such as *version history*, *vocabularies*, and *previews and thumbnails*. See [Managing Data and Content Types in Staging](./managing-data-and-content-types-in-staging.md) for more information.

![Select the content you want to include in your publication.](./staging-ui-reference/images/09.png)

**Permissions**: Select whether to include permissions for the Pages and widgets when your changes are published.

![Select whether to include permissions for the Pages and widgets when your changes are published.](./staging-ui-reference/images/10.png)

Instead of manually configuring advanced options every time you publish a Page or content, you can save your staging configuration as a [*publication template*](#publish-templates) for future use. To view and select a saved template for your publication, click on the *Publish Templates* tab.

![To view and select a saved template for your publication, click on the Publish Templates tab.](./staging-ui-reference/images/11.png)

When ready, click on *Publish to Live* to initiate publishing.

## Staging Page

Once you've enabled Staging, the options available from the *Publishing* tab are modified. When in the Live environment, you can only access the *Export* feature. When in the Staging environment, you can only access the *Import* and *Staging* features.

You can also access new options in the Staging Page. You can now view publication *processes*, create and manage *publish templates*, and modify or disable Staging for your Site.

![You can also access new options in the Staging Page.](./staging-ui-reference/images/13.png)

### Previous and Future Publication Processes

When you publish with Staging, it's captured as a *process* and stored for future reference. To view and manage these processes, go to *Product Menu* &rarr; *Publishing* &rarr; *Staging*.

In the *Processes* tab is a list of staging processes that have been completed. From here, you can *relaunch*, *clear* or view a *summary* of any previous publications by clicking on a process's *Actions* button ( ![Actions button](../../../images/icon-actions.png) ).

![View and manage previous publication processes from the Staging Page.](./staging-ui-reference/images/14.png)

You can also click on the *Add* (![Add button](../../../images/icon-add.png)) button to create a new publication process using a custom configuration or pre-defined publishing template.

In the *Scheduled* tab, you can view all scheduled publication processes.

### Publish Templates

If you regularly create similar staging configurations, you can create your own *publish templates* to save time. To create a template, click on the *Actions* button ( ![Actions button](../../../images/icon-actions.png) ) in the *Application* bar of the *Staging* Page. Then, select *Publish Templates*.

![Click on the Actions button in the Application bar of the Staging Page.](./staging-ui-reference/images/15.png)

From here, you can create and manage templates for frequent publishing configurations. You can then use a template by clicking on its *Actions* button ( ![Actions button](../../../images/icon-actions.png) ) and selecting *Publish*.

![Create and manage templates for frequent publishing configurations.](./staging-ui-reference/images/16.png)

You can also use a template when publishing a Page or content using the *Publish to Live* button in the Staging bar. See [Advanced Publication](#advanced-publication) for more information.

### Staging Configuration

After setting up Staging, you can access the Staging Configuration Page by clicking on the *Actions* button ( ![Actions button](../../../images/icon-actions.png) ) in the *Application* bar of the *Staging* Page. Then, select *Staging Configuration*.

![Click on the Actions button in the Application bar of the Staging Page to access Staging Configuration.](./staging-ui-reference/images/17.png)

From here, you can disable Staging for your Site, or modify your [Page versioning](page-versioning.md) settings. However, *Staged Content* options cannot be modified after the initial setup.

## Additional Information

* [Staging Overview](./staging-overview.md)
* [Understanding the Publication Process](./understanding-the-publication-process.md)
* [Page Versioning](./page-versioning.md)
* [Managing Data and Content Types in Staging](./managing-data-and-content-types-in-staging.md)
