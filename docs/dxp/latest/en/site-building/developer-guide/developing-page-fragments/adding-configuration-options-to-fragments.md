# Adding Configuration Options to Fragments

> Available: Liferay DXP 7.2 SP1+

Configurable options help make your Fragments flexible, so you don't have to maintain many similar Fragments. For example, instead of having one Fragment that has a heading with style A and another Fragment that has a heading with style B, you can create one Fragment that has a configurable style for the heading with options for style A and B. Here you'll learn how to add configuration options to a Fragment:

- [Deploy a Configurable Fragment](#deploy-a-configurable-fragment)
- [Examine the Configuration](#examine-the-configuration)
- [Escape Configuration Text Values](#escape-configuration-text-values)
- [Modify the Configuration](#modify-the-configuration)
- [Propagate the Changes and Test](#propagate-the-changes-and-test)
- [Related Information](#related-information)

## Deploy a Configurable Fragment

First, deploy an example to see how Fragment configuration options work:

1. Run the command below to start the Docker container:

    ```bash
    docker run -it -p 8080:8080 [$LIFERAY_LEARN_DXP_DOCKER_IMAGE$]
    ```

1. Download and unzip the [example Fragment Collection](https://learn.liferay.com/dxp/latest/en/site-building/developer-guide/developing-page-fragments/liferay-c7f8.zip):

    ```bash
    curl https://learn.liferay.com/dxp/latest/en/site-building/developer-guide/developing-page-fragments/liferay-c7f8.zip -O
    ```

    ```bash
    unzip liferay-c7f8.zip
    ```

1. Set up the Fragments Toolkit:

    ```bash
    cd liferay-c7f8
    ```

    ```bash
    ./setup_tutorial.sh 
    ```

1. Import the Fragment Collection to the Docker container using the Fragments Toolkit. Alternatively, you can [import the Fragment manually](../../displaying-content/using-fragments/managing-page-fragments.md).

    ```bash
    yarn run import

    > yo liferay-fragments:import

    ? Liferay host & port http://localhost:8080
    ? Username test@liferay.com
    ? Password [hidden]
    Checking connection...
    Connection successful

    ? Company ID liferay.com
    ? Group ID Liferay
    Building project...
    Importing project...
    ✔ Fragment C7F8 Card imported
    Project imported
    ```

1. Verify that the Fragment Collection is available. Point your browser to `https://localhost:8080`, and under the Site Menu on the left side of the screen, go to *Design* &rarr; *Fragments*. The Collection appears in the Collection list.

    ![The Collection is available.](./adding-configuration-options-to-fragments/images/01.png)

    ```note::
       For Liferay DXP 7.1 and 7.2, instead navigate to *Site* → *Site Builder* → *Page Fragments* under the Product Menu to get to the Fragments page.
    ```

1. Go to the Home Page and click the (![Edit icon](../../../images/icon-edit-pencil.png)) icon to edit the Content Page.

1. Expand the *Configurable Marketing Collection* heading in the [Fragments panel](../../creating-pages/building-and-managing-content-pages/content-page-editor-user-interface-reference.md#fragments-and-widgets) and drag the *Configurable Marketing Card* Fragment onto the page.

1. Select the Configurable Marketing Card. Open the Fragment Configuration Menu by clicking the (![Gear icon](../../../images/icon-control-menu-gear.png)) icon in the context menu that appears. From here, you can choose a configuration option for the text style to change the text from dark to light.

1. Go to a [Content Page](../../creating-pages/understanding-pages/understanding-pages.md#content-pages) (such as the default Home Page) and click the (![Edit icon](../../../images/icon-edit-pencil.png)) icon to edit the page.

1. Expand the *C7F8 Collection* heading in the [Fragments and Widgets panel](../../creating-pages/building-and-managing-content-pages/content-pages-overview.md#fragments) and drag the *C7F8 Card* Fragment onto the page.

1. Select the *C7F8 Card* on the page. The Selection panel appears on the right. In the *General* tab, set the component's text style to dark or light.

    ![Configurable Fragments provide options to modify the Fragment's look and feel.](./adding-configuration-options-to-fragments/images/02.png)

Great! You successfully imported and configured a configurable Fragment.

## Examine the Configuration

You can edit a Fragment's configuration options in Liferay's built-in [Fragments Editor](./using-the-fragments-editor.md) or in a text file.

**Using the Fragments Editor:** In the UI, edit the Fragment with the [Fragments Editor](./using-the-fragments-editor.md) and click *Configuration* tab. The Fragment's configuration appears in the editor.

**Editing a Fragment Configuration File:** If you don't have the Fragment files, export them from the Fragment by opening the Fragment's actions menu and clicking *Export*. The `configurationPath` field (optional) in a Fragment's `fragment.json` file specifies the configuration `.json` file. If it doesn't have a configuration file, create one and set the `configurationPath` field to the configuration file name.

Open the example's `fragment.json` file to determine the Fragment's configuration file.

```json 
{
    "configurationPath": "index.json",
    "cssPath": "index.css",
    "htmlPath": "index.html",
    "jsPath": "index.js",
    "name": "C7F8 Card",
    "type": "component"
}
```

The `"configurationPath": "index.json"` property indicates this Fragment's configuration file is `index.json`.

Open the configuration file.

```json
{
    "fieldSets": [
        {
            "fields": [
                {
                    "dataType": "string",
                    "defaultValue": "dark",
                    "label": "Text Style",
                    "name": "c7f8TextStyle",
                    "type": "select",
                    "typeOptions": {
                        "validValues": [
                            {
                                "value": "dark"
                            },
                            {
                                "value": "light"
                            }
                        ]
                    }
                }
            ],
            "label": "C7F8"
        }
    ]
}
```

The configuration file above, specifies a selector for applying a *dark* or *light* text style to the Fragment. The configuration has a field named `c7f8TextStyle`. The field's `type` is `select`, which makes it a selector component. See [Fragment Configuration Types](../reference/fragments/fragment-configuration-types-reference.md) for details. The selector's valid values are `dark` or `light`. The `"dataType": "string"` property means that the selector operates on string data. 

This selector is a part of a field set labeled *C7F8* (the label is optional). In the UI, this selector is found in the Fragment's configuration section labeled *C7F8*. The selector is labeled `Text Style` per the field's `label` property. The figure below shows the selector.

![Here is the selector for the C7F8 Card Fragment](./adding-configuration-options-to-fragments/images/03.png)

```warning::
   The Fragments Editor won't save the configuration until it's valid. Make sure your JSON configuration is valid before previewing it.
```

The configuration values selected by the user are made available to the HTML through the FreeMarker context. They are referenced in the HTML with the notation `${configuration.fieldName}`. The example  (`${configuration.textAppliedStyle}`) returns `dark` or `light` depending on the configuration value selected by the user, setting the CSS class to `text-light` or `text-dark`:

```html
<div class="component-c7f8-card">
    <div class="card">
        <img
            class="card-img-top"
            data-lfr-editable-id="01-image"
            data-lfr-editable-type="image"
            src="https://clayui.com/images/home/lexicon_symbol.svg"
        />

        <div class="card-body">
            <h5
                class="card-title text-${configuration.c7f8TextStyle}"
                data-lfr-editable-id="02-title"
                data-lfr-editable-type="rich-text"
            >
                Editable Card Title
            </h5>

            <p
                class="card-text text-${configuration.c7f8TextStyle}"
                data-lfr-editable-id="03-text"
                data-lfr-editable-type="rich-text"
            >
                Here is some editable text.
            </p>

            <a
                class="btn btn-primary"
                data-lfr-editable-id="04-label"
                data-lfr-editable-type="link"
                href="#"
            >
                Editable Link
            </a>
        </div>
    </div>
</div>
```

The example demonstrates a select configuration. See the [Configuration Types Reference](../reference/fragments/fragment-configuration-types-reference.md) for a complete list of the available Fragment configuration types.

### Escape Configuration Text Values

Malicious code can be inserted into the text field, wreaking havoc for other Fragment users. You must escape Fragment text values to guard against cross-site scripting (XSS) attacks.

For generic cases, an HTML `escape()` method is available. See the [`HtmlUtil`](https://docs.liferay.com/dxp/portal/7.3-latest/javadocs/portal-kernel/com/liferay/portal/kernel/util/HtmlUtil.html) class for more information.

```html
<div class="fragment_38816">
    "${htmlUtil.escape(configuration.text)}"
</div>
```

To prevent JavaScript attacks, such as setting an attribute or appending HTML children, use the `Liferay.Util.escapeHTML()` function:

```javascript
function (fragmentElement, configuration) {
    const escapedValue = Liferay.Util.escapeHTML(configuration.text)
}
```

## Modify the Configuration

Now that you know how the configuration works, you can modify it.

1. Under the Site Menu on the left side of the screen, go to *Design* &rarr; *Fragments*. The Collection appears in the Collection list.

    ```note::
       For Liferay DXP 7.1 and 7.2, instead navigate to *Site* → *Site Builder* → *Page Fragments* under the Product Menu to get to the Fragments page.
    ```

1. Select the *C7F8 Collection*, click *Actions* (![Actions Icon](../../../images/icon-actions.png)) for the C7F8 Card and select *Edit*. The Fragments Editor appears.

1. Click the *Configuration* tab and update the configuration with a checkbox field to hide/show the card's description. Insert this code on a new line after the `c7f8TextStyle` field's closing brace and comma (`},`)

    ```json
    {
        "name": "showDescription",
        "label": "Show Description",
        "description": "show-description",
        "type": "checkbox",
        "defaultValue": true
    }
    ```

1. Go back to the *HTML* pane in the *Code* tab and wrap the paragraph element with a conditional statement to check for the checkbox's value. Click *Publish* to apply the changes.

    ```html
    [#if configuration.showDescription]
      <p data-lfr-editable-id="03-card-text" data-lfr-editable-type="rich-text" 
      class="card-text text-${configuration.textAppliedStyle}">
        Here is some editable text.
      </p>
    [/#if]
    ```

```note::
  You can also access the configuration's value through the JavaScript with the syntax ``const configurationValue = configuration.textAppliedStyle;``.
```

## Propagate the Changes and Test

Now you can test the updates.

1. Propagate the changes so they're reflected on the Content Page. Click *Actions* (![Action Icon](../../../images/icon-actions.png)) for the C7F8 Card and select  *View Usages*. 
1. Check the box for the Content Page and click the (![propagate button](../../../images/icon-propagate.png)) button.

    ![Configurable Fragments provide options to modify the Fragment's look and feel.](./adding-configuration-options-to-fragments/images/04.png)

1. Go back to the Content Page and once again click the (![Edit icon](../../../images/icon-edit-pencil.png)) icon to edit the Content Page.
1. Select the *C7F8 Card* again to show Selection panel on the right.
1. In the *General* tab, check/uncheck the *Show Description* checkbox to show/hide the card's text.

    ![You can have as many configuration options as you want for your Fragments.](./adding-configuration-options-to-fragments/images/05.png)

Great! Now you know how to add configuration options to your Fragments. For more configuration examples, please see Please see [Fragment Configuration Types](../reference/fragments/fragment-configuration-types-reference.md).

## Related Information

* [Auto-deploying Fragments](./auto-deploying-fragments.md)
* [Including Default Resources with Fragments](./including-default-resources-with-fragments.md)
* [Fragment Configuration Types Reference](../reference/fragments/fragment-configuration-types-reference.md)
