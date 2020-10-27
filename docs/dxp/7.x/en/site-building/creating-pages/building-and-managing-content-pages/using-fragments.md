# Using Fragments

Page *Fragments* are extensible, reusable, drag-and-drop elements that serve as the primary building blocks for Content Pages. Each Fragment is built using CSS, HTML, and JavaScript and together define your Page's design and provide functionality along with widgets. Though you can [create your own](../../developer-guide/developing-Page-fragments/developing-fragments-intro.md), Liferay DXP includes a number of Fragments out-of-the-box.

To access available Fragments, go to a Content Page, and click on the *Edit* icon (![Edit](../../../images/icon-edit.png)) in the Application Bar. Ensure your edit mode is set to *Page Design*, and click on *Fragment and Widgets* (![Fragments and Widgets](../../../images/icon-cards2.png)) in the editing Sidebar Menu.

* [Adding Fragments](#adding-fragments)
* [Configuring Fragments](#configuring-fragments)
* [Using Layout Elements](#layout-elements)
* [Using Basic Components](#basic-components)
* [Using Content Display Fragments](#content-display)
* [Using Featured Content Components](#featured-content)
* [Using Footers](#footers)
* [Using Navigation Bars](#navigation-bars)

## Adding Fragments

Follow these steps to add a Fragment to a Content Page:

1. While editing a Content Page, open the *Fragment and Widgets* (![Fragments and Widgets](../../../images/icon-cards2.png)) panel in the editing Sidebar Menu.

1. Drag and drop a Fragment to the desired location in your Page layout.

Once added, you can change its placement at any time. Also, you can view its placement in your Page's structure as well as access its configuration options in the *Selection* panel (![Selection](../../../images/icon-pages-tree.png)) of the editing Sidebar Menu.

## Configuring Fragments

DXP provides options for configuring individual Fragments as well as their sub-elements. These options can vary, though some are common to all. You can view available configuration options in the *Selection* panel (![Selection](../../../images/icon-pages-tree.png)) of the Sidebar Menu. Simply click on a Fragment or element, and select which options you'd like to configure from the available tabs.

### General

In the *General* tab, you can configure Fragment specific options (e.g., heading level, video URL, button type).

### Styles

In the *Styles* tab, you can configure standard Fragment options (e.g., dimensions, background, borders), as well as Fragment specific options on occasion. With DXP's Responsive Layout Editor, you can also configure these settings for different devices. See [Configuring Fragment Styles](./configuring-fragment-styles.md) and [Fragment Styles Reference](./fragment-styles-reference.md) for more information.

### Image

In the *Image* tab, you can select an element's image, view its resolution, and provide its alt text.

### Link

In the *Link* tab, you can either manually add a URL to a Page element, or select from an available content field. You can also specify the desired target (e.g., self, parent).

### Mapping

In the *Mapping* tab, you can map Page elements to available assets by selecting the desired item (e.g., web content article, document, blog) and specifying which of its fields to display in the element (e.g., title, author, name).

## Layout Elements

> Available: Liferay Portal CE 7.3 GA2+; previously called Layouts with *panels* and *rows*.

*Layout Elements* define drop zones and can be used to create the desired Page structure. DXP's default layout Fragments include *Containers* and *Grids*. Once configured, you can drag and drop widgets or other Fragments into the defined areas, including additional containers or grids to create even more complex structures.

![Use Layout Elements to define drop zones and page structure.](./using-fragments/images/02.png)

### Container

Use *container* Fragments to add drop zones to a Content Page. In addition to standard style options, this field can be configured to maintain a fixed width or to adapt to fill the width of its page section. You can also set a container's *Link* field to add either internal or external links. Once published, clicking on the name of the fragment redirects users to your specified destination.

### Grid

Use *grid* Fragments to add multiple drop zone modules to a Content Page. These modules can be arranged into rows and columns. In addition to standard style options, you can determine the number of modules for each grid, the number of modules per row, and the vertical alignment of each module's content. You can also manually [adjust the width](./building-content-pages.md#configuring-a-row-s-columns) of each module.

## Basic Components

*Basic Components* are simple design elements that add basic functionality to a page. Examples include buttons, headings, and tabs. With these Components, you can build your Page piece by piece. DXP includes the following Basic Components.

### Button

Use *button* Fragments to add link elements to a Content Page. As part of configuration, choose from one of four available button styles.

![Add a link element to a Content Page.](./using-fragments/images/03.png)

### Card

Use *card* Fragments to add an image with title, paragraph, and link elements to a Content Page.

![Add an image with title, paragraph, and link elements to a Content Page.](./using-fragments/images/04.png)

### Heading

Use *heading* Fragments to add H1-H6 text to a Content Page.

![Add headings to a Content Page.](./using-fragments/images/05.png)

### HTML

Use *HTML* Fragments to add an editable HTML element to a Content Page. Double-clicking on it opens a modal window where you can edit its content using HTML syntax.

![Add editable HTML elements to a Content Page.](./using-fragments/images/06.png)

### Image

Use *image* Fragments to add a configurable `image-square` element to a Content Page. As part of configuration, determine whether to use the image's original size, or if you want it to adjust to fit its context. To select an image, determine its resolution, and set its alt text, go to the `image-square` element's *Image* tab.

### Paragraph

Use *paragraph* Fragments to add a simple text element to a Content Page, which can be configured using standard style options and mapped to available content.

### Separator

Use *separator* Fragments to add a horizontal line between Fragments on a Page. As part of configuration, you can determine its spacing and color.

### Slider

Use *slider* Fragments to add image slides with text overlay to a Content Page. Each slide consists of image, title, and subtitle elements.

![Add image slides with text overlay to a Content Page.](./using-fragments/images/07.png)

### Social

Use the *social* Fragment to add Facebook, Twitter, and LinkedIn icons for linking to pages on each platform. You can also change each icon for different social media platforms.

![Add icon links for Facebook, Twitter, and LinkedIn to a Content Page.](./using-fragments/images/08.png)

### Spacer

Use *spacer* Fragments to add horizontal blank space between Fragments on a Page. As part of configuration, you can adjust its height.

### Tabs

Use the *tabs* Fragment to add multiple tabs with individual drop zones for widgets and other Fragments. Determine number of tabs, as well as standard style options.

![Add multiple tabs with individual drop zones for widgets and other Fragments.](./using-fragments/images/09.png)

### Video

Use *video* Fragments to embed videos in your Content Page. To select a video, enter a valid URL, either to YouTube or video file. As part of configuration, you can set the video to autoplay, loop, or mute. You can also determine whether video controls are hidden from users.

## Content Display

> Available: Liferay DXP 7.3+

Use *Content Display* Fragments to display Site content individually or as part of a collection. Examples include web content, blog entires, and documents. You can also add Page elements for rating or flagging Page content. DXP includes the following Content Display Fragments.

### Content Display

Use the *content display* Fragment to display a single content item on a Content Page. As part of configuration, determine whether it displays your selected content using the *Abstract* or *Title* template.

### Content Flags

Use the *content flag* Fragment to add a Page element for flagging inappropriate content. As part of configuration, map it to content and determine its message.

### Content Ratings

Use the *content ratings* Fragment to add a Page element for rating content. As part of configuration, link it with the desired content item.

### Collection Display

Use the *collection display* Fragment to display asset collections on Content Pages. With it, you can choose from both manually and dynamically defined collections, as well as those defined by a Collection Provider. You can then choose whether a collection is displayed in a *grid* or with a list *template* (i.e., bordered, bulleted, inline, numbered, and unstyled).

## Featured Content

*Featured Content* Fragments are complex Page elements composed of multiple components. To preview a Fragment's layout, hover over its *Information* icon (![Information](../../../images/icon-information.png)). DXP includes the following Featured Content Fragments.

### Banners

Use *banner* Fragments to add text and link elements to a Content Page for creating CTA (Call to Action) banners. DXP includes the following layouts.

![Add text and link elements to a Content Page for creating Call to Action banners.](./using-fragments/images/10.png)

### Features

Use the *features* Fragment to add text, image, and link elements to a Content Page for promoting key features. DXP includes the following layout.

![Add text, image, and link elements to a Content Page for promoting key features](./using-fragments/images/11.png)

### Highlights

Use the *highlights* Fragment to add image, text, and link elements to a Content Page for highlighting. DXP provides the following layouts.

![Add image, text, and link elements to a Content Page for highlighting.](./using-fragments/images/12.png)

## Footers

> Available: Liferay DXP 7.3+; previously included in the *Sections* panel.

Use *Footer* Fragments to add a custom footer to [Master Page Templates](../defining-headers-and-footers/master-page-templates.md) for Content Pages. Each footer includes a navigation menu, sign-in link, image element, and copyright text. DXP includes the following layouts for Footer Fragments.

![Add a custom footer to Master Page Templates for Content Page.](./using-fragments/images/13.png)

## Navigation Bars

> Available: Liferay DXP 7.3+; previously included in the *Sections* panel.

Use *Navigation Bar* Fragments to add a custom header to [Master Page Templates](../defining-headers-and-footers/master-page-templates.md) for Content Pages. Each navigation bar includes a navigation menu, sign-in link, and image element for your logo. DXP includes the following layouts for Navigation Bar Fragments

![Add a custom header to Master Page Templates for Content Page.](./using-fragments/images/14.png)

## Additional Information

* [Content Page Overview](./content-page-overview.md)
* [Building Content Pages](./building-content-pages.md)
* [Editing Content Pages](./editing-content-pages.md)
