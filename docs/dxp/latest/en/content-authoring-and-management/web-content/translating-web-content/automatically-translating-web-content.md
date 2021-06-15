# Automatically Translating Web Content

Liferay provides integration with the Google Cloud Translation API for generating automatic translations of Web Content. To enable this feature, you must have an active Google Cloud project with Cloud Translation API enabled. This project must also have a service account with a JSON account key. See official [Google Cloud Translation documentation](https://cloud.google.com/translate/docs/setup) for more information.

## Enabling Automatic Translation

Follow these steps to enable automatic translation for a Liferay instance.

1. Open the *Global Menu*(![Global Menu]()), click on the *Control Panel* tab, and go to *System Settings* &rarr; *Translation*.

   ![Go to Translation under System Settings.](./automatically-translating-web-content/images/01.png)

1. Check *Enabled*.

1. Enter a valid Google Cloud service account key in JSON format.

1. Click on *Save*.

## Using Automatic Translation

Once Google Cloud Translation is enabled, auto translate buttons are added to the translation interface for Web Content.

Follow these steps to automatically translate all or only individual Web Content fields.

1. Open the Web Content application in a Site or Asset Library.

1. Click the *Actions* button (![Actions Button]()) for the content you want to translate, and select *Translate*.

   ![Open the Web Content translation interface.](./automatically-translating-web-content/images/02.png)

1. Click the top left *Auto Translate* button to translate all Web Content fields into the selected language.

   ![Click the top left Auto Translate button to translate all Web Content fields.](./automatically-translating-web-content/images/03.png)

   Alternatively, click a field's individual *Auto Translate* button (![Auto Translate Button]()) to only translate its text.

   ![Click a field's individual Auto Translate button to only translate its text.](./automatically-translating-web-content/images/04.png)

1. Click *Save as Draft* or *Publish* when finished.

## Additional Information

* [Manually Translating Web Content](./manually-translating-web-content.md)
* [Exporting and Importing Translations](./exporting-and-importing-translations.md)
