# Publishing Single Assets and Widgets

With Liferay DXP, you can publish single assets and widgets when needed, without going through the entire publication process. You can also schedule when web content is published.

## Publishing Single Assets

To publish assets in this way, Users must have the following permissions: *Export/Import Application Info* and *Publish Staging*. See [Managing Staging Permissions](./managing-staging-permissions.md) for more information.

Follow these steps to publish a single asset:

1. Go to *Content & Data* in the *Product* menu, and select the content or data type you would like to publish.

1. Click on the *Actions* button ( ![Actions button](../../../images/icon-actions.png) ) for the asset you want to publish, and select *Publish to Live*.

   ![Click on the Actions button for the asset you want to publish, and select Publish to Live.](./publishing-single-assets-and-widgets/images/01.png)

Once you confirm your publication, you'll be directed to a process page where you can see the status of your publication.

Similar to the standard publication process, single asset publications include associated dependencies, whether images, custom templates, or folders.

```note::
   Single asset publication is not supported for page-scoped content.
```

## Publishing Single Widgets

Although Staging is typically used to publish content, you can also publish widgets. For example, you can modify a widget's title and publish the change to live. This is possible because widget configurations are always staged. To publish a widget that is on a Page, you must publish the Page first.

After changing a widget, you can publish the widget by clicking on the *Actions* button ( ![Actions button](../../../images/icon-actions.png) ) for the widget and selecting *Staging*.

![Click on a widget's Action button, and select Staging.](./publishing-single-assets-and-widgets/images/04.png)

## Additional Information

* [Staging Overview](./staging-overview.md)
* [Managing Staging Permissions](./managing-staging-permissions.md)
* [Page Versioning](./page-versioning.md)
* [Staging UI Reference](./staging-ui-reference.md)
