# Using the Fragments Editor

Liferay DXP includes a built-in [editor](../reference/fragments/page-fragment-editor-interface-reference.md) for developing Content Page Fragments. To access the editor, go to *Design* &rarr; *Fragments* in the *Site Menu*. From here, you can view and manage existing Fragments and Collections, as well as create new ones.

* [Creating a Fragment Collection](#creating-a-fragment-collection)
* [Creating a New Fragment](#creating-a-new-fragment)

## Creating a Fragment Collection

Before creating new Fragments, Users must first create a new Collection to put them in. To do so, follow these steps:

1. Open the *Site Menu*, and go to *Design* &rarr; *Fragments*

    ```note::
       In Liferay DXP 7.1 and 7.2, open the *Product Menu*, and go to *Site* → *Site Builder* → *Page Fragments*.
    ```

1. Click the *Add* button (![Add Button](../../../images/icon-duplicate.png)), and enter a *name* and *description* for the new Collection. The Collection's name is displayed in the *Fragments and Widgets* panel of the Content Page sidebar.

```tip::
   Create Collections that group Fragments by functionality, or by teams and departments.
```

1. Click *Save*.

![Collections help you organize Fragments.](./using-the-fragments-editor/images/01.png)

Once you've made your first Collection, you can begin creating new Fragments.

## Creating a New Fragment

Follow these steps to create a new Fragment:

1. Go to the desired Collection, and click on Add (![Add Button](../../../images/icon-add.png)) to create a new Fragment.

   ```note::
      Prior to Liferay DXP 7.3, a Fragment could either be a Section or a Component. In Liferay DXP 7.3+, all Page Fragments are Components.
   ```

1. Enter a *name* for the Fragment, and click *Save*.

    ![Enter a name for the new Component.](./using-the-fragments-editor/images/02.png)

1. In the *Code* tab, use the CSS, HTML, and Javascript fields to add your Fragment's resources. Here, you can also see a live preview of your Fragment's appearance in different device contexts.
    
    The example below adds a Card component with editable text:

    ```html
    <div class="marketing-card-fragment-01">
      <div class="card">
        <lfr-editable id="01-card-image" type="image">
          <img src="https://cdn.dribbble.com/users/1408464/screenshots/9323535/media/a5b9a76256562e878ecc6dc5cd0fadf0.png" class="card-img-top" alt="2020 - Try New Things">
        </lfr-editable>
        <div class="card-body">
          <lfr-editable id="02-card-title" type="rich-text">
            <h5 class="card-title">Editable Card title</h5>
          </lfr-editable>
          <lfr-editable id="03-card-text" type="rich-text">
            <p class="card-text">Here is some editable text.</p>
          </lfr-editable>
          <lfr-editable id="04-card-link" type="link">
            <a href="#" class="btn btn-primary">Editable link</a>
          </lfr-editable>
        </div>
      </div>
    </div>
    ```

    ```css
    .marketing-card-fragment-01 .card img {
      max-width: 100%;
    }
    ```

    ![Add CSS, HTML, and Javascript resources to the Fragment, and see a live preview.](./using-the-fragments-editor/images/03.png)

1. In the *Configuration* tab, use the `JSON` field to add [configuration options](./adding-configuration-options-to-fragments.md)) to a Page Fragment.

   ![Add configuration options to a Page Fragment.](./using-the-fragments-editor/images/04.png)

1. Click *Publish* to save your Fragment and make it available for use in [Content Pages](../../creating-pages/understanding-pages/understanding-pages.md#content-pages).

    ![The Fragment can be used on a Content Page.](./using-the-fragments-editor/images/05.png)

While developing a Fragment, all changes are automatically saved as a draft until your Fragment is published. Once added to a collection, you can copy, export, edit, and remove a Fragment at any time in the Fragments editor. See [Managing Page Fragments](../../displaying-content/using-fragments/managing-page-fragments.md) for more information on available actions for Page Fragments.

```note::
   Since Liferay DXP 7.2 SP1+ and Liferay Portal CE 7.2 GA2+, you can create Page Fragments on the *Global* Site to make them available for all Sites. To expose this feature in the initial releases of these versions, you must create a ``.config`` file named ``com.liferay.fragment.web.internal.configuration.FragmentGlobalPanelAppConfiguration.config`` and add the ``enabled=B"true"`` property. Then copy it to your Liferay DXP instance's ``osgi/configs`` folder. Global Page Fragments are inherited by child Sites and can only be edited from the Global Site. Any resources the Global Page Fragment references from the Global Site are copied to a Site that leverages the Page Fragment.
```

## Additional Information

* [Using the Fragments Toolkit](./using-the-fragments-toolkit.md)
* [Adding Configuration Options to Fragments](./adding-configuration-options-to-fragments.md)
