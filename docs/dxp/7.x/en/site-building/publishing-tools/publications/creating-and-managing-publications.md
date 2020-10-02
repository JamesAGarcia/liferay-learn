# Creating and Managing Publications

With the Publications tool, you and your team can create and manage multiple publications at the same time or group changes across multiple Sites into a single publication. Each publication is instance-scoped and can include changes to Pages, web content, and documents across multiple Sites.

Because they are instance-scoped, the same publications are visible and accessible anywhere in your instance. However, changes made within those publications are scoped according to the context in which they're made. For example, Site-scoped changes are only applied to the Site in which they're made, while instance-scoped changes are applied to all Sites when published.

Once Publications is enabled, you can create, edit, publish, or remove a publication via the *Publications* bar drop-down menu and *Publications* overview Page.

To access this Page, open the *Global Menu*, and go to *Publications* in the Applications tab.

```tip::
   Quickly access the Global Menu anywhere in your DXP instance using the following shortcut:

   **Mac OS**: Cmd+Shift+M

   **Windows**: Ctrl+Shift+M
```

![Access the Publications overview Page in the Applications tab of the Global Menu.](./creating-and-managing-publications/images/01.png)

* [Creating a New Publication](#creating-a-new-publication)
* [Managing Ongoing Publications](#managing-ongoing-publications)
* [Managing Scheduled Publications](#managing-scheduled-publications)
* [Managing History of Publications](#managing-history-of-publications)

## Creating a New Publication

Follow these steps to create a new publication for your instance.

1. Click *Create New Publication* in the drop-down Publications bar menu. This redirects you to the *Create New Publication* Page.

   ![Click Create New Publication in the drop-down Publications bar menu.](./creating-and-managing-publications/images/02.png)

   Alternatively, you can create a new publication by going to the *Ongoing* tab in the Publications overview page and clicking on the *Add* button ( ![Add button](../../../images/icon-add.png) ).

1. Enter a *name* for your new publication.

   ```tip::
      A publication's name doesn't need to be unique, though using unique names can be helpful for organization.
   ```

1. Optionally, enter a *description* of your new publication.

1. Click *Create*.

![Enter a name and description for your publication, and click Create.](./creating-and-managing-publications/images/03.png)

Publications created in this way use the current production environment as their baseline, without adding any changes. All changes made in your publication are tracked as deviations from the production environment at the time it is created.

After creating a new publication, you can begin adding changes to it. See [Making and Publishing Changes](./making-and-publishing-changes.md) to learn more about the editing and publishing process.

## Managing Ongoing Publications

The *Ongoing* tab lists all active, unpublished publications for your DXP instance. By default, these publications are ordered by *Modified Date*, though you can also order them by *Name*. Each entry includes the publication's name, description, time of last modification, time of creation, and owner.

![The Ongoing tab lists all active, unpublished publications for your DXP instance and their information.](./creating-and-managing-publications/images/04.png)

By clicking on a publication's *Actions* button ( ![Actions button](../../../images/icon-actions.png) ), you can select a publication to perform any of the tasks listed below.

### Work on Publication

Select *Work on Publication* for the publication you want to add tracked changes to. Once you've selected a publication to work on, you can easily toggle between production and your selected publication via the drop-down Publications bar menu.

### Edit

Select *Edit* to modify a publication's name or description any time after its creation.

### Review Changes

Select *Review Changes* to see all changes included in your selected publication. By default, DXP displays a simple summary of the publication's tracked changes, but you can set the toggle switch to *Show all Items* to view all processes related to your changes. You can also switch between list and context display styles. See [Reviewing Publication Changes](./making-and-publishing-changes.md#reviewing-publication-changes) for more information.

### Publish

Select *Publish* to immediately publish your publication's changes. When selected, DXP performs a conflicts detection and notifies you if your publication includes any conflicting changes. If there are no conflicts, click *Publish* to make your changes live. See [Making and Publishing Changes](./making-and-publishing-changes.md) and [Resolving Conflicts](./resolving-conflicts.md) for more information on this process.

### Schedule

Select *Schedule* to determine a future date and time when your publication's changes are applied to production. When selected, DXP performs a conflicts detection and notifies you if there are any conflicting changes. If there are no conflicts, click *Next*, and set a *Date and Time* using UTC to publish your changes. When finished, click *Schedule*. See [Making and Publishing Changes](./making-and-publishing-changes.md) and [Resolving Conflicts](./resolving-conflicts.md) for more information on this process.

### Permissions

Select *Permissions* to assign publication specific permissions to User roles in your instance. Permissions configured in this way are scoped to the individual publication. By default, most Users cannot create or access Publications, though you can manually configure Users roles to grant wider accessibility.

### Delete

Select *Delete* to remove a publication from your instance. When selected, you will be prompted to confirm your choice.

```important::
   Deleting a publication permanently removes all of its changes from your database and cannot be undone. Before deleting a publication, ensure you've saved any data you want to preserve.
```

## Managing Scheduled Publications

The *Schedule* tab lists all scheduled publications for your instance. By default, these publications are ordered by *Name*, though you can order them by *Modified Date* or when each publication is scheduled for *Publishing*.

![The Schedule tab lists all scheduled publications for your instance.](./creating-and-managing-publications/images/05.png)

By clicking on the *Actions* button ( ![Actions button](../../../images/icon-actions.png) ) for a scheduled publication, you can *Unschedule* or *Reschedule* its publication, as well as *Review Changes*. When a publication is unscheduled, it becomes active again and is listed in the Ongoing tab.

## Managing History of Publications

The *History* tab lists all previously published publications for your instance. By default, these publications are ordered by *Published Date*, though you can order them by *Name*.

![The History tab lists all previously published publications for your instance.](./creating-and-managing-publications/images/06.png)

Click *Revert* to easily create publications that revert previously published changes to your instance. You can also make additional changes to your DXP instance as part of your Revert publication. See [Reverting Changes](./reverting-changes.md) for more information about this process.

```tip::
   Its recommended Users enable Publications early on in your development process to achieve a more complete audit of your instance's changes.
```

## Additional Information

* [Publications Overview](./publications-overview.md)
* [Enabling Publications](./enabling-publications.md)
* [Making and Publishing Changes](./making-and-publishing-changes.md)
