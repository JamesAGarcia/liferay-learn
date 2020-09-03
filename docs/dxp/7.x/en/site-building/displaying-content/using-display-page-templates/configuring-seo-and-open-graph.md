# Configuring SEO and Open Graph

With *Display Page Templates*, you can create standard formats for displaying different content types, such as *Web Content Articles*, *Documents*, and *Blog Entries*. When configuring a template, you can define SEO and Open Graph fields that are dynamically filled for your displayed content.

To create or configure these setting for an existing Display Page template, go to *Design* &rarr; *Page Templates* in the Product menu, and click on the *Display Page Templates* tab.

![Click on the Display Page Templates tab.](./configuring-seo-and-open-graph/images/01.png)

Create a new template using the Add button (![Add button](./../../../images/icon-add.png)), or edit an existing template by clicking on its *Actions* button ( ![Actions button](./../../../images/icon-actions.png) ) and selecting *Configure*. Here, configuration options are organized into two tabs: *SEO* and *Open Graph*.

* [Configuring SEO Settings](#configuring-seo-settings)
* [Configuring Open Graph Settings](#configuring-open-graph-settings)

## Configuring SEO Settings

Search engine optimization (SEO) refers to the methods used to improve your Page's ranking in a search engine results page (SERP). With Liferay DXP, you can create Display Page templates that dynamically configure your displayed content for SEO.

### HTML Title

The *HTML Title* field defines a Display Page's title `<meta>` tag. This title is used by search engines to rank your Page and serves as the Page's heading in search engine results. By default, Display Page templates map this field to *Title*, but you can select any other Text field. Though keep in mind, the recommended length for an HTML title is under 60 characters.

![The HTML Title field defines a Display Page's title meta tag](./configuring-seo-and-open-graph/images/02.png)

### Description

The *Description* field defines a Display Page's description `<meta>` tag. This description is used by search engines to rank your Page and appears in search engine results as a preview of your Page. By default, Display Page templates map this field to *Description*, but you can select any other Text field. Though keep in mind, the recommended length for a Page's description is under 155 characters.

![The Description field defines a Display Page's description meta tag.](./configuring-seo-and-open-graph/images/03.png)

### Robots

The *Robots* field configures `robots.txt` rules for a Display Page. These rules provide instructions to search engines and other tools crawling and indexing your Site, either blocking or granting a crawler access to a specified path. You can also localize this field using the *Language Flag*.

![The Robots field configures robots.txt rules for a Display Page.](./configuring-seo-and-open-graph/images/04.png)

### Sitemap

Determine whether to include a Display Page in your `sitemap.xml` file, as well as set its *Priority* and *Change Frequency*. These fields inform search engines whether to crawl and index the Display Page, how it should be prioritized relative to other Site Pages, and how frequently it is updated.

![Determine whether to include a Display Page in your sitemap.xml file, as well as set its Priority and Change Frequency.](./configuring-seo-and-open-graph/images/05.png)

## Configuring Open Graph Settings

[Open Graph](https://ogp.me/) is an internet protocol that standardizes how a Site's metadata is displayed on social networks. With Liferay DXP, you can create Display Page templates that dynamically configure a Page's Open Graph `<meta>` tags.

```note::
   For your displayed content, values defined here override default values defined elsewhere in your Liferay instance.
```

### Title

The *Title* field defines a Display Page's `og:title` property, which determines the title displayed for your content in rich previews. By default, this field is mapped to *Title*, like the HTML title field for SEO. While you can select any other Text field, its best practice to update SEO and Open Graph titles together.

![The Title field defines a Display Page's og:title property.](./configuring-seo-and-open-graph/images/06.png)

### Description

The *Description* field defines a Display Page's `og:description` property, which determines the description displayed for your content in rich previews. By default, Display Page templates map this field to *Description*, like the description field for SEO. While you can select any other Text field, its best practice to update SEO and Open Graph descriptions together.

![The Description field defines a Display Page's og:description property.](./configuring-seo-and-open-graph/images/07.png)

### Image

The *Image* field defines a Display Page's `og:image` property, which determines the image displayed for your content in rich previews. By default, this field is unmapped in Display Page templates. This means the template defaults to the image set at Site level, unless you select a different Image field.

![The Image field defines a Display Page's og:image property.](./configuring-seo-and-open-graph/images/08.png)

### Image Alt Description

The *Image Alt Description* field defines a Display Page's `og:image:alt` property, which determines the alt text read by screen readers for your displayed content's `og:image` property. By default, this field is unmapped in Display Page templates. This means the template defaults to the alt text set at the Site level, unless you select a different Text field.

![The Image Alt Description field defines a Display Page's og:image:alt property](./configuring-seo-and-open-graph/images/09.png)

## Additional Information

* [Displaying Content with Display Page Templates](./displaying-content-with-display-page-templates.md)
* [Creating a Display Page Template](./creating-a-display-page-template.md)
* [Search Engine Optimization](./../../optimizing-sites/search_engine_optimization.html)
* [Open Graph](./../../site-settings/configuring-open-graph.md)
