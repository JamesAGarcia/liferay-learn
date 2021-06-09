# Configuring Local Live Staging

With Local Live Staging, both your Staging and Live environments are hosted on the same Liferay server. When enabled, Liferay DXP creates a local clone of your Site or Asset Library that serves as the Staging environment, while the original becomes your Live environment. Both environments share the same JVM, database, selected application data, and configurations (e.g., portal properties).

* [Setting Up Local Live Staging](#setting-up-local-live-staging)
* [Disabling Local Live Staging](#disabling-local-live-staging)

## Setting Up Local Live Staging for Sites

Follow these steps to set up Local Live Staging for a Site:

1. Go to *Site Menu* &rarr; *Publishing* &rarr; *Staging*.

   ![Go to Staging in the Site Menu.](./configuring-local-live-staging/images/01.png)

1. Select *Local Live*, which reveals additional fields for *Page Versioning* and *Staged Content*.

   ![Select Local Live.](./configuring-local-live-staging/images/02.png)

1. Select whether you want *Page Versioning* enabled on Public and/or Private Page sets.

   ![Enable Page Versioning for your Private and Public Page sets.](./configuring-local-live-staging/images/03.png)

1. Select the data and content types you want to stage.

   ![Select the data and content types you want to stage.](./configuring-local-live-staging/images/04.png)

   ```warning::
      When applications are checked, their data is copied to Staging, and it may not be possible to edit them directly in Live. When unchecking an application, first make sure that any changes in Staging are published, since they may be lost. See `Managing Data and Content Types in Staging <./managing-data-and-content-types-in-staging.md>`_ for more information.
   ```

1. Click on *Save* to initiate the cloning process. The duration of this process depends on the size of your Site.

   ```tip::
      Stage your Site early on to reduce cloning time and record a more complete history of your Site's update history, since updates are only recorded once you enable Page Versioning.
   ```

Once the process is complete, you are ready to use Local Live Staging. See [Site Staging UI Reference](./site-staging-ui-reference.md) for information about navigating the Staging environment's publishing features.

## Setting Up Staging for Asset Libraries

Follow these steps to set up Local Live Staging for an Asset Library:

1. Open the *Global Menu* (![Global Menu](../../../images/icon-applications-menu.png)), and click on *Asset Libraries* in the Applications tab.

1. Open the desired Asset Library, and click on *Staging* under Publishing.

1. Select *Local Live*.

   ![Select Local Live.](./configuring-local-live-staging/images/05.png)

1. Select the application data you want to stage.

   For Asset Libraries, you can stage data for *Documents and Media* and *Web Content*.

   ![Select the application data you want to stage.](./configuring-local-live-staging/images/06.png)

1. Click on *Save* to initiate the cloning process. The duration of this process depends on the size of the Asset Library.

   Once the process is complete, you are ready to use Local Live Staging in your Asset Library.

## Disabling Local Live Staging

If for any reason you must disable Staging for your Site or Asset Library, you can do that from your staging environment. However, be aware that disabling Local Live Staging deletes the Staging environment, along with all unpublished content. For this reason, ensure all necessary information is published or preserved elsewhere before disabling Staging.

```tip::
   This process may take some time, depending on the size of your Staging environment. It's best not to disable staging when your DXP instance is busy.
```

Follow these steps to disable Local Live Staging:

1. Open the Staging application in your Site or Asset Library.

1. Click the *Actions* button ( ![Actions button](../../../images/icon-actions.png) ) located in the Application bar, and select *Staging Configuration*.

   ![Click the Actions button in the Application bar, and select Staging Configuration](./configuring-local-live-staging/images/07.png)

1. Select *None* for your Staging configuration, and click *Save*.

## Additional Information

* [Staging Overview](./staging-overview.md)
* [Site Staging UI Reference](./site-staging-ui-reference.md)
* [Managing Data and Content Types in Staging](./managing-data-and-content-types-in-staging.md)
* [Managing Staging Permissions](./managing-staging-permissions.md)
