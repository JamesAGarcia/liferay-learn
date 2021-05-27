# About Collections and Collection Pages

```note::
   This information applies to Liferay DXP 7.3+. In previous Liferay versions, Collections were called Content Sets. For information on Content Sets, see `Liferay DXP 7.2 <#liferay-dxp-7-2>`_.
```

Collections are sets of content items that you can use to group and filter information. Consider the following example. You plan to create a new section in your product web page with customer success stories. You want this section to show new success stories automatically as these stories are published. In this case, you can create a Collection that groups all your success stories, with a Collection Page that shows the Collection's content. In addition to Collection Pages, you can show this Collection in other Content Pages using a Collection Display Fragment (for more information, see [Displaying Collections](../../site-building/displaying-content/additional-content-display-options/displaying-collections.md).)

There are two types of Collections in Liferay:

- **Manual Collection**

    You select and maintain the items that are part of the Collection manually. The items in a Manual Collection do not change automatically.

    For example, you create a Manual Collection named *Promotions*, which includes several promotional web content on your public website. After you select the items in the Collection, you must add new promotional content manually to keep the Collection up-to-date.

- **Dynamic Collection**

    You define the type of items in the collection, along with criteria for these items. The Collection's items can change based on the criteria you define. A Dynamic Collection is useful when you want to make sure the content is up-to-date with new items matching the criteria.

    For example, for your Kitchenware Store, you create a Collection including all blog posts with the *porcelain* tag (this tag represents your criteria). The Dynamic Collection includes all the new blog posts with the *porcelain* tag automatically.

For information about how to create Manual or Dynamic Collections, see [Creating Collections](./creating-collections.md).

## Displaying Collections

You can display Collections using a [Collection Page](../../site-building/displaying-content/additional-content-display-options/displaying-collections.md#displaying-collections-on-a-collection-page) or a [Collection Display Fragment](../../site-building/displaying-content/additional-content-display-options/displaying-collections.md#adding-a-collection-display-fragment-to-a-page).

A Collection Page is a type of page linked to a Collection. Collection Pages ease the task of showing and customizing Collections. For example, you can quickly add new items to your Collection using a Collection page.

![You can display your Collection using a Collection Page](./about-collections-and-collection-pages/images/01.png)

A Collection Display Fragment is a type of Fragment that shows a Collection. You can use this Fragment to show your Collection on any Content Page, Page Template, or Display Page.

![You can show the Collection's content using a Collection Display Fragment](./about-collections-and-collection-pages/images/02.png)

For more information, see [Displaying Collections](../../site-building/displaying-content/additional-content-display-options/displaying-collections.md).

## Customizing Collections

You can associate a Liferay Segment with your Collection to display different Collection items based on the [Segment configuration](../../site-building/personalizing-site-experience/segmentation/creating-and-managing-user-segments.md).

Consider the following example. You want to increase sales in your Kitchenware Store by offering exclusive promotions to registered users. You create a Collection including promotions for registered users and news about your products. You want everyone to see the news about your products, but you want to restrict the promotions to registered users. You can create a new Segment for registered users and link the Segment to a new *Personalized Variation* that filters the promotional content.

For information, read [Personalizing Collections](../../site-building/personalizing-site-experience/experience-personalization/personalizing-collections.md).

## Converting Asset Publisher Configurations to Collections

In addition to creating Collections directly, you can create Collections from an [Asset Publisher Widget](../../site-building/displaying-content/using-the-asset-publisher-widget/displaying-assets-intro.md). This option is useful when you have an Asset Publisher customization that you want to use as a Collection in other pages. For more information, read [Creating Collections](./creating-collections.md#creating-a-collection-from-an-asset-publisher).

## Liferay DXP 7.2

### Managing Content Sets

A Content Set is exactly what it sounds like: a set of content items. In short, an administrator can defines a list of content, and then that list can be displayed. The way that the Content Set is displayed is determined by the method that is used to display it. For example, if the Content Set is being used by a smartwatch app, it could be displayed as a simple list of titles, and selecting a title would cause the full article to display on a connected mobile device. The same Content Set could be displayed in a web browser with the full content of each article.

```note::
    In previous versions of Liferay DXP, you used the Asset Publisher to define and display either static lists of assets or dynamic lists based on criteria like tags, categories, or asset type. In Liferay DXP Content Sets take the core idea of defining different types of asset lists and expands it. Content Lists are created outside of the context of a specific application or widget and can be used and re-used across different channels and applications.
```

### Creating and Displaying Content Sets

Content Sets are created through the Site Administration interface. All the features for creating and managing Content Sets are contained here. They are displayed using Liferay's widgets or your own custom applications. Read our
guides for information on [Creating Content Sets](./creating-collections.md#creating-content-sets) and
[Displaying Content Sets](../../site-building/displaying-content/additional-content-display-options/displaying-collections.md#displaying-content-sets).

### Content Set Personalization

Content Sets can have variations driven by Liferay DXP's Personalization engine. After you create a Content Set, if you have at least one User Segment created, you can create a personalized experience of the Content Set for that Segment. To learn to harness the power of experience personalization for Content Sets, see [Content Set Personalization](../../site-building/personalizing-site-experience/experience-personalization/personalizing-collections.md#content-set-personalization).

### Converting Asset Publisher Configurations to Content Sets

You may have already gone through a great deal of work to create a perfect, curated list of content through the Asset Publisher, but now you want to display that list elsewhere without duplicating your work. You can do that with Content Sets. Read the [Converting Asset Publisher Configuration to Content Sets guide](./creating-collections.md#converting-asset-publisher-configurations-to-content-sets) article to learn more.

## Related Information

- [Creating Collections](./creating-collections.md)
- [Displaying Collections](../../site-building/displaying-content/additional-content-display-options/displaying-collections.md)
- [Personalizing Collections](../../site-building/personalizing-site-experience/experience-personalization/personalizing-collections.md)
