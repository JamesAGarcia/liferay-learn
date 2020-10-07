# Using Fragments

Here you'll learn how to use some of the common Fragments. These Fragments are covered here:

## Using the Content Fragment

> Available: Liferay DXP 7.3+.

You can display a single existing web content, blog entry, or document by adding a Content Fragment from the *Content Display* panel. Follow these steps to use it:

1. Edit an existing Fragment-supported page (i.e. Content Page, Master Page, or Display Page).
1. Open the *Fragments* Panel and expand the *Content Display* heading and drag the *Content* Fragment onto the page.
1. With the *Content* Fragment selected, click the (![Cog icon](../../../images/icon-control-menu-gear.png)) icon to open the Fragment Configuration Menu.

    ![The Content Fragment lets you display a single piece of content.](./using-fragments/images/01.png)

1. Click the plus button next to the *Content* input and select an existing web content, blog entry, or document to display.

## Using the Container Fragment

You can deploy a single *Container* fragment or multiple *Container* fragments on a page. In addition to having multiple *Container* fragments on a page, these fragments can be nested.

Follow these steps:

1. Edit an existing Fragment-supported page (i.e. Content Page, Master Page, or Display Page).
1. Click the *Fragments and Widgets* button.

    ![The Container fragment is located in the Fragments and Widgets menu.](./using-fragments/images/02.png)

1. Click the *Fragments* tab.
1. Drag and drop the *Container* fragment onto the page.
1. Drag and drop your desired fragments or content into the *Container*.
1. Add any additional *Container* fragments  to the page.

   ![Drag additional Container fragments on the page.](./using-fragments/images/03.png)

1. Click *Publish* when finished.

The Page has been published with several *Container* fragments.

### Adding Links in a Container Fragment

Lastly, *Container* fragments contain a *Link* field where you can add either internal or external links. To add a link to a *Container* fragment:

1. In the *Site Builder* &rarr; *Pages* menu, navigate to the Content Page where the *Container* fragments have been published (for example, *Page 3* in the steps above) .
1. Click *Edit*.
1. Click the *Selection* ![Selection icon](../../../images/icon-page-tree.png) icon.
1. Click on the desired *Container*.
1. Click the *Link* tab.
1. Enter the following:

    * **Link**: Manual
    * **URL**: the desired URL
    * **Target**: Self

    ![You can add external or internal links to a Container.](./using-fragments/images/04.png)

1. Click *Publish* when finished.

The link has been added to the *Container*. Once published, clicking on the name of the fragment redirects the user to the link's page (Google's home page from this example).

## Additional Information

* [Using Fragment Comments](./using-fragment-comments.md)
* [Using Widgets on a Content Page](./using-widgets-on-a-content-page.md)
