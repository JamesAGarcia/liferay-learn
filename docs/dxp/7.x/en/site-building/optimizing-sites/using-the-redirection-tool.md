# Using the Redirection Tool

Maintaining URL integrity is important for any Site. Liferay DXP's *Redirection* tool provides a convenient and integrated way to manage HTTP redirects and track 404 errors. With this tool, you can easily avoid and fix broken links, improving both user experience and SEO.

To access it, open the Product menu, and go to *Configuration* &rarr; *Redirection*.

![Go to the Redirection page in the Product menu.](./using-the-redirection-tool/images/01.png)

Here, the Redirection tool's functionalities are organized into two tabs: *Redirects* and *404 URLs*.

* [Redirects](#redirects)
* [404 URLs](#404-urls)

## Redirects

In the *Redirects* tab, you can create and manage both *Permanent* (301) and *Temporary* (302) URL redirects.

![You can create and manage Permanent and Temporary URL redirects from the Redirects tab.](./using-the-redirection-tool/images/02.png)

While both automatically direct users to a specified destination, they each have unique implications for your Site. Before creating a redirect, consider which type is best for your situation.

* **Permanent**: Use a 301 code to inform search engines and other tools accessing your Site that the requested resource has been permanently relocated. Search engines will replace the old URL with the new destination in search results, and browsers will cache the new destination for an indeterminate amount of time. A 301 should only be used when you intend to use the destination URL indefinitely. This improves SEO and helps avoid unintended caching.
* **Temporary**: Use a 302 code to inform search engines and other tools accessing your Site that the requested resource is temporarily moved. A 302 is useful when you want to conduct A/B testing or redirect traffic while fixing a problem, without impacting your Site ranking. DXP uses 302 codes by default.

See [Search Engine Optimization](./search_engine_optimization.html) to learn more about the implications of each redirect type for SEO. Also, see [A/B Testing](./ab_testing.html) to learn about using 302s when testing.

### Creating a Redirect

Follow these steps to create a redirect:

1. Click on the *Add* button (![Add button](./../../images/icon-add.png)). This leads to the *New Redirect* screen.

   ![Click on the Add button to create a new redirect.](./using-the-redirection-tool/images/03.png)

1. Enter a unique relative URL into the *Source URL* field to specify the link that triggers the redirect. The entered value is added to the base URL displayed above it.

   ![Enter a unique relative URL into the Source URL field.](./using-the-redirection-tool/images/04.png)

1. Enter an absolute URL into the *Destination URL* field to specify the link for your desired destination.

   This destination can be internal or external, but must always be entered as an absolute URL. You can also click on the *Shortcut* icon (![Shortcut icon](./../../images/icon-shortcut.png)) to check the entered URL.

   ![Enter an absolute URL into the Destination URL field.](./using-the-redirection-tool/images/05.png)

1. Use the *Type* drop-down menu to determine whether the redirect is permanent (301) or temporary (302).

   ![Determine whether the redirect is permanent or temporary.](./using-the-redirection-tool/images/06.png)

1. You can optionally set an automatic *Expiration Date* for the redirect. Leave this field empty to avoid expiration.

   ![Determine whether the redirect expires.](./using-the-redirection-tool/images/07.png)

1. When finished, click on *Create* to save the redirect.

Once saved, Liferay DXP validates your configuration. If other redirects point to your specified source URL, DXP notifies you and asks whether you want to update the existing redirect to avoid a redirect chain.

![DXP helps you avoid creating redirect chains.](./using-the-redirection-tool/images/08.png)

DXP also returns an error if you attempt to create multiple redirects for the same source URL, or if your specified source and destination URLs would result in a redirect loop.

### Editing and Removing Redirects

Once you've successfully added a URL redirect, you can edit or remove it at any time by clicking on its *Actions* button ( ![Actions button](./../../images/icon-actions.png) ) and selecting *Edit* or *Delete*.

![You can edit or remove a redirect at any time.](./using-the-redirection-tool/images/09.png)

```note::
   Changes made to a redirect may not be immediately seen for users whose browsers have cached the old redirect configuration.
```

## 404 URLs

In the *404 URLs* tab, you can view and manage Site requests leading to 404 errors. DXP catalogs each error, so you can assess the cause of the errors and quickly resolve any issues.

![You can view and manage 404 URLs.](./using-the-redirection-tool/images/10.png)

Here, you can search, filter, and order cataloged 404 URLs, as well as conveniently create redirects for them when desired. These URLs are preserved in your database according to your Redirection configurations in the Control Panel, where you can configure both how many and how long 404s are cataloged.

### Viewing 404 URLs

You can filter cataloged requests by both *type* and *date*. When filtering by type, you can choose to display *Active*, *Ignored*, or *All* 404 URLs. When filtering by date, you can determine whether to view all URLs, or only those that have been requested within the last day, week, or month. You can also order cataloged requests by their *modified date* or *number of requests*.

By default, this page displays all Active URLs by number in descending order.

![You can filter and order cataloged 404 URLs.](./using-the-redirection-tool/images/11.png)

### Ignoring/Unignoring 404 URLs

You can determine whether a URL is active or ignored by clicking on its *Actions* button ( ![Actions button](./../../images/icon-actions.png) ) and selecting *Ignore*/*Unignore*. When ignored, the URL is hidden in the default *Active* view, though you can change its status at any time.

![You can determine whether a URL is active or ignored.](./using-the-redirection-tool/images/12.png)

### Creating Redirects for 404 URLs

You can easily create a redirect for a 404 URL by clicking on its *Actions* button ( ![Actions button](./../../images/icon-actions.png) ) and selecting *Create Redirect*. This directs you to a *New Redirect* screen where the source URL is prefilled with the selected 404. Simply finish filling out the form, and click on *Create* to save the new redirect.

![Create redirects for 404 URLs.](./using-the-redirection-tool/images/13.png)

### Configuring 404 Settings

You can determine how long 404 URLs are retained between requests, as well as the maximum number of 404 URLs stored in your database.

To do so, open the Control Panel and go to *System Settings* (or *Instance Settings*) &rarr; *Pages* &rarr; *Redirection*, under Virtual Instance Scope.

By default, the *404 URL Maximum Age* is set to 30 days, while the *Maximum Number of 404 URLs* is set to 1000 entries.

![Determine how long and how many 404 URLs are retained](./using-the-redirection-tool/images/14.png)

## Additional Information

* [Search Engine Optimization](./search_engine_optimization.html)
* [A/B Testing](./ab_testing.html)
* [Configuring Your Site's Friendly URL](./../site-settings/managing-site-urls/configuring-your-sites-friendly-url.md)
* [Configuring Virtual Hosts Site URLs](./../site-settings/managing-site-urls/configuring-virtual-hosts-site-urls.md)
