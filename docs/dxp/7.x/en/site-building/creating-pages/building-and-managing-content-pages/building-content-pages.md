# Building Content Pages

```note::
   Liferay DXP 7.3+. For previous Liferay DXP versions, see `Liferay DXP 7.1 and 7.2 <#liferay-dxp-7-1-and-7-2>`_.
```

Once you've [added a Content Page](../adding-pages/adding-a-page-to-a-site.md), you can build it by adding and configuring various [Content Page elements](./content-pages-overview.md).

1. Under the Site Menu, go to *Site Builder* &rarr; *Pages*.

1. Click the *Add Page* button (![Add Page](../../../images/icon-plus.png)) at the level where you want to add the new page, and select *Add Page*.

    ![Begin by adding your new Content Page.](building-content-pages/images/01.png)

1. Select the *Blank* template or one of the existing templates.

1. In the *Add Page* dialog, type your page's *Name*.

1. Alternatively, click the Actions Menu (![Actions](../../../images/icon-actions.png)) of an existing Content Page and select *Edit*.

    ![Edit an existing Content Page by dropping Fragments or Widgets in the edit area.](building-content-pages/images/02.png)

    When you enter the Site Builder view, you can add or edit your content in two ways:

    - *Page Design*: If you have permission to update the page and the page content, this mode is available.
    - *Content Edition*: If you only have permission to update the page but not the page content, you can use this mode.

    The editing options available in the Content Page sidebar depend on the editing mode you choose.

    ![Choose between Page Design or Content Edition editing modes.](building-content-pages/images/18.png)

1. From the Content Page sidebar, select the *Fragments and Widgets* button (![Fragments and Widgets](../../../images/icon-cards2.png)) and start adding the Fragments and Widgets for your content.

    ![Add Fragments and Widgets from the Content Page sidebar](building-content-pages/images/03.png)

    ```note::
       New Content Pages start empty and in a *Draft* status. The page is not visible until it is published.
    ```

1. Configure the look and content preferences of the Fragments and Widgets using the following configuration options:

    * [Setting the Layout Style](#setting-the-layout-style)
    * [Editing Text Inline](#editing-text-inline)
    * [Editing Hyperlinks](#editing-hyperlinks)
    * [Editing Images](#editing-images)
    * [Configuring the Grid Layout](#configuring-the-grid-layout)
    * [Copying a Fragment](#copying-a-fragment)
    * [Saving a Fragment Composition](#saving-a-fragment-composition)
    * [Mapping Content](#mapping-content)

    ![Modify the Fragments to display the content you want.](./building-content-pages/images/04.png)

    ```tip::
       In progress work on a Content Page is automatically saved.
    ```

1. You can revert any action using the *Undo* (![Preview](../../../images/icon-undo.png)) or *Redo* (![Preview](../../../images/icon-redo.png)) buttons, or you can return to a previous version of your edits using the *History* (![Preview](../../../images/icon-time.png)) button.

    ![Revert your changes using the Undo, Redo, and History buttons.](./building-content-pages/images/17.png)

1. To preview your Content Page, click the *Preview* button (![Preview](../../../images/icon-preview.png)).
1. Click the *Publish* button in the top right to make the updates available to the live page.

## Configuring Elements on a Content Page

Many elements you add can be configured and customized. When you click on an element, the Content Page sidebar shows configuration options for the element.

### Setting the Layout Style

You can set different style options for your Content Page layout like background color, background image, margins, and opacity.

1. Click the layout element you want to change.
1. In the Content Page sidebar, under the *Styles* tab, configure the style options for your content:

    * Content Display and Container Width
    * Margin
    * Padding
    * Background and Border color
    * Effects

      ![You can set different style options for your layout.](./building-content-pages/images/05.png)

```note::
   The available color palette can be configured by the Fragment developer. See `Fragment Configuration Types Reference <../../../site-building/developer-guide/reference/fragments/fragment-configuration-types-reference.md>`_ for more information.
```

### Editing Text Inline

1. Double-click the page element containing your text to enter into edit mode.
1. Select the text that you want to edit.
1. Use the inline text editor to update the text styles, typographical emphasis, alignment, and other text formatting options.

    ![You can modify editable text.](./building-content-pages/images/07.png)

### Editing Hyperlinks

1. Click on the link, button, or image that you want to edit.
1. On the Content Page sidebar, under the *Link* tab, choose the options for your link:

    * *Link:* defines a manual link or maps it to an existing content field
    * *URL:* set the link's URL
    * *Target:* set the link's behavior

   ![You can modify editable links.](./building-content-pages/images/08.png)

   When you choose the *From Content Field* option for your link, you can configure the following options:

   * *Content:* Set the content type.
   * *Field:* Set the field to display for the selected content. Some of the available content fields are:

       * Categories
       * Tags
       * Display Page URL
       * Description
       * Publish Date
       * Summary
       * Title
       * Last Editor Name
       * Author Name
       * Basic Web Content

   * *Target*: Set where to open the linked content.

### Editing Images

1. Click the image you want to edit.
1. In the Content Page sidebar, you can configure the image using three different options:

    * *Link*: enter the URL for your image.
    * *Image*: select an image from your computer or from the Documents and Media library.
    * *Mapping*: select an image by [mapping content](#mapping-content).

    ![When editing an image, you can enter a URL, select an image from Documents and Media, or set a link for the image.](./building-content-pages/images/09.png)

You can also specify a background image for a layout by [setting the layout style](#setting-the-layout-style) or provide a link for your image by [editing hyperlinks](#editing-hyperlinks).

### Configuring the Grid Layout

1. Click the Grid element you want to configure.
1. In the Content Page sidebar, under the *Styles* tab, select the style options for your content.
1. Under the *Configuration* tab, select the *Number of Modules* (from 1 to 6) to specify the number of columns for the grid.
1. Click *Show Gutter* to show the spacing between modules.

You can adjust the columns' width to create a more custom layout:

1. Click on the Row to select it. A blue dot appears between each of the columns, indicating that they can be resized.
1. Click one of the blue dots and drag to the left or right to adjust the size of the column.

    ![You can adjust the spacing of columns in a Layout.](./building-content-pages/images/16.gif)

### Copying a Fragment

To save time, you can duplicate a Fragment (Component, Section, Row, etc.):

1. Click the Fragment you want to copy.
1. Click the Options Menu (![Image Properties](../../../images/icon-app-options.png)) for the container and select *Duplicate*.

    ![You can duplicate Fragments on the page.](./building-content-pages/images/10.png)

```note::
  When you duplicate a Fragment, you also ducplicate the mappings and customizations.
```

```warning::
  Layouts (Sections or Rows) containing instanceable Widgets cannot be duplicated. In this case, a message appears indicating the Widget preventing the duplication.
```

### Saving a Fragment Composition

You can save customized Fragment compositions (Section or Row layout Fragments) as new Fragments, so you can reuse them in your other Fragment-based pages:

1. Click the Row or Section composition you want to save.
1. Click the Options Menu (![Image Properties](../../../images/icon-app-options.png)) for the container and select *Save Composition*.

      ![Click the Row or Section to save your composition.](./building-content-pages/images/11.png)

1. In the Save as Fragment dialog that appears, provide a name and other optional information:

    * Fragment *Description* and *Thumbnail*.
    * *Save Inline Content* option, for including inline content such as fragment entries (links, images, text, etc.)
    * *Save Mapping Configuration* option, for including [mapped content](#mapping-content).
    * *Collection* to save the Fragment.

      ![Provide the information for the Fragment composition in the dialog that appears.](./building-content-pages/images/12.png)

```note::
   If no Site-specific Fragment Collection exists, the saved Fragment composition is saved automatically to a new Fragment Collection called Saved Fragments.
```

You can use the saved Fragment composition immediately using the Fragments sidebar or through the Page Fragments administrative application.

![The saved Fragment composition can be used immediately.](./building-content-pages/images/13.png)

Compositions can be exported or imported between Sites just as any other Fragment.

```note::
  The latest version of the `Liferay Fragments Toolkit <../../developer-guide/developing-page-fragments/using-the-fragments-editor.md>`_ supports creation, export/import, and preview of Fragment compositions.
```

### Mapping Content

You can also map these elements to existing content. You can set the *Content* for the element (web content article, document, or blog) and choose its applicable *Field* to display (e.g., title, author name, tags, etc.).

To map your elements to existing content,

1. Click the Grid element you want to map.
1. In the Content Page sidebar, under the *Mapping* tab, click the *Add* button (![Map](../../../images/icon-plus.png)).
1. Select the content you want to map to your Content Page element.
1. Select the *Field* of your content that you want to map.

   ![You can map Content Page elements to existing content using the Mapping option](./building-content-pages/images/17.gif)

## Liferay DXP 7.1 and 7.2

Content Pages, like Widget Pages, are built by dragging and dropping elements onto the page and then configuring the way those elements appear. There are three kinds of elements: 

**Sections** are fragments that define a space to place other elements. A section fills the entire width of the page. Sections can be thought of as *complete* Fragments that serve a purpose by themselves. A large banner image with a text overlay is an example of something you might build as a section.

![A Section named Banner being displayed while editing a Content Page.](./building-content-pages/images/20.png)

**Layouts** are special Sections that define spaces where you can add fragments or widgets. Each layout you add fills the width of the page. You can add any number of layouts to the page.

![A 3 Column and 1 Column layout stacked on top of each other.](./building-content-pages/images/21.png)

**Components** are small design elements or pieces that add functionality to the page. A component might be an image with formatting or a block of text with styling pre-applied. Components must be added to the page inside a Layout. If you add a component outside an existing Layout, a one column layout is automatically added to contain the Component. While Sections should be complete by themselves, Components work together to build pages piece by piece. 

![Here are several of Liferay's out of the box components arranged in the layout you saw previously.](./building-content-pages/images/22.png)

Liferay DXP ships with a plethora of Layouts, Sections, and Components to use to build pages, and a [web developer can create their own Fragments](../..//developer-guide/developing_page_fragments.md) to add to these. 

## Editable Elements

Fragments can have editable elements. After a Fragment has been added to a page, you can click on an editable area to provide your own text, image, or links in place of the default defined in the Fragment.

You can also map these elements to content. You can set the *Content* for the element (web content article, document, or blog) and choose its applicable *Field* to display (e.g., title, author name, tags, etc.). You can configure this by selecting the element's *Map* button (![Map](../../../images/icon-map.png)).

```note::
   Many mapping improvements were released in Liferay DXP 7.2 SP1+ and Liferay Portal 7.2 GA2+. For example, mapping editables to text/URL fields of existing content and mapping Fragment background images to image fields of existing content. You can also map [custom fields](https://help.liferay.com/hc/en-us/articles/360028818872-Custom-Fields). To ensure you leverage the latest editable element mapping features, upgrade to these versions.
```

For more information on developing these elements, see 
[Fragment Specific Tags](../../developer-guide/reference/fragments/fragment-specific-tags-reference.md).

Now you'll learn about each editable type.

### Editable Text

Editable text can be plain or rich text. Plain text has no special styling. Rich
text enables text styles, typographical emphasis, alignment, and list
formatting.

![The rich text editor provides a simple WYSIWYG interface with a number of formatting options.](./building-content-pages/images/23.png)

### Editable Images

Editable image elements allow replacing the image URL or an image from your Documents and Media library. You can provide a link target for the image.

To edit an image from the Content Page editor,

1.  Click on the image you want to replace.

2.  Click ![Image Properties](../../../images/icon-edit.png).

![Editing an image allows you to enter a URL, select an image from Documents and Media or set a link for the image.](./building-content-pages/images/24.png)

From here, you can click *Select* to upload an image from Docs and Media or define an image URL. Click *Clear* to reset the image. You can also specify an image description.

You can also specify a background image for a layout from Section Builder. Click the Layout, select *Layout Background Image*, and define the image to display.

```note::
   Mapping a Layout background image is available in Liferay DXP 7.2 SP1+ and Liferay Portal 7.2 GA2+.
```

For more information on developing editable images, see 
[Making Images Editable](../../developer-guide/reference/fragments/fragment-specific-tags-reference#making-images-editable).

You can also define a link for your image. You'll learn about this next.

### Editable Links

Editable links can be associated with entities that redirect you to a content type or Page (e.g., buttons).

To edit a link from the content page editor,

1.  Click on the link or button that you want to edit.

2.  Click on ![Edit](../../../images/icon-edit.png) to edit the link text.

3.  Click on ![Link](../../../images/icon-link.png) to edit the link properties.

4.  Click on ![Map](../../../images/icon-map.png) to edit the link mapping (described earlier).

From the Link Properties pop-up, you can define the following link options:

*Manual:* defines a manual link or map it to an existing content field.

- *URL:* sets the link's URL.
- *Target:* set the link's behavior.

*From Content Field:* 

- *Content:* sets the content type.
- *Field:* sets the field to display for the selected content.

Some of the content fields include

- Categories
- Tags
- Display Page URL
- Description
- Publish Date
- Summary
- Title
- Last Editor Name
- Author Name
- Basic Web Content

For more information on developing editable links, see 
[Creating Editable Links](../../developer-guide/reference/fragments/fragment-specific-tags-reference.md#creating-editable-links).

Next you'll learn about the Content Page Editing Interface.

## Related Information

* [Developing a Page Fragment](../../developer-guide/developing-page-fragments/developing-fragments-intro.md)
* [Using Master Pages](../defining-headers-and-footers/master-page-templates.md)
* [Changing Content Pages Look and Feel](./editing-content-pages.md#look-and-feel)
* [Content Page Personalization guide](../../personalizing-site-experience/personalizing-site-experience.md)
