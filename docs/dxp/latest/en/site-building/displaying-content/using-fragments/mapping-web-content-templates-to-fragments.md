# Mapping Web Content Templates to Fragments

By default, you can map [Web Content Structure](../../../content-authoring-and-management/web-content/web-content-structures/understanding-web-content-structures.md) fields holding a single value (such as Date, Numeric, Image, Number, or Text) to Fragments. For multi-value fields (such as Select from List, Radio Button, or HTML) you must first render the field using a [Web Content Template](../../../content-authoring-and-management/web-content/web-content-templates/creating-web-content-templates.md); then you can map the Template to a Fragment.

For example, the *Web Content with Audience* Structure on this image contains a Content field of *Text* type and an Audience field of *Select from List* type:

![You can map single-value Structure fields to Fragments by default.](./mapping-web-content-templates-to-fragments/images/02.png)

You can map the single-value Content field directly to a Fragment, but you need a Web Content Template to map the multi-value Audience field. The [Web Content Template](../../../content-authoring-and-management/web-content/web-content-templates/creating-web-content-templates.md) should use the same Structure as the Web Content Article containing the field you want to map. The following image shows this relationship:

![Create a Web Content Template that uses the Same Structure as the Web Content Article.](./mapping-web-content-templates-to-fragments/images/07.png)

```note::
  If you want to map several Structure field values to individual Fragments, you must create a separate Web Content Template that renders just one field for each field that uses that Structure. If you render all your fields in one Template, all their values map to the Fragment when you select the Template.
```

## Mapping a Web Content Template to a Fragment

1. [Create a Web Content Structure](/../content-authoring-and-management/web-content/web-content-structures/creating-structures.md) that contains the multi-value field you want to map.
1. [Create a Web Content Template](../../../content-authoring-and-management/web-content/web-content-templates/creating-web-content-templates.md) that uses the same Structure with the multi-value field (A).
1. In the Web Content Template, under Fields (B), select the _variable_ (C) with the multi-value field in the Structure.

    ![Create a Web Content Template based on the Structure with the multi-value field.](./mapping-web-content-templates-to-fragments/images/08.png)

1. [Create the Web Content](../../../content-authoring-and-management/web-content/web-content-articles/adding-a-basic-web-content-article.md) based on the previous Web Content Template.

    ![Create the Web Content based on the Template with the multi-value field.](./mapping-web-content-templates-to-fragments/images/01.png)

1. On the Fragment-supported page (Content Page, Display Page Template, etc.) [add the Fragment](../../creating-pages/building-and-managing-content-pages/adding-elements-to-content-pages.md).
1. On the sidebar panel, click the *Selection* (![Selection](../../../images/icon-pages-tree.png)) button and choose the element in the Fragment you want to map.
1. Under the *Mapping* section, [select and map](../../creating-pages/building-and-managing-content-pages/configuring-elements-on-content-pages.md#mapping-content) the Web Content Article that contains the value you want to map.
1. Click the *Field* dropdown menu and select the Web Content Template you created before.

    ![Map the field in the Web Content Template to your Fragment.](./mapping-web-content-templates-to-fragments/images/04.png)

1. Click *Publish* to save the changes.

## Additional Information

- [Using Page Fragments](../../displaying-content/using-fragments/using-page-fragments.md)
- [Understanding Web Content Structures](../../../content-authoring-and-management/web-content/web-content-structures/understanding-web-content-structures.md)
- [Creating Web Content Templates](../../../content-authoring-and-management/web-content/web-content-templates/creating-web-content-templates.md)
