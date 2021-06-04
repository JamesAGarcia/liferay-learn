# Editing Images

Liferay's Documents and Media includes a built-in image editor for cropping and rotating images without switching contexts.

To use the image editor, open the Documents and Media application in a Site of Asset Library, click on the *Actions* button (![Actions Button](../../../images/icon-actions.png)) for the desired image, and select *Edit Image*.

![Click Edit Image to use Documents and Media's image editor.](./editing-images/images/01.png)

When editing an image in Documents and Media, the following options are available.

![Crop and rotate images.](./editing-images/images/02.png)

**Crop**: Manually adust the cropping frame; click and drag the image to reposition it within the cropping frame.

**Ratio**: Select a fixed preset ratio for cropping the image (i.e., 16:10, 16:9, 4:3, 1:1, 2:3), or select *Free* to create a custom image ratio.

**Rotate**: Rotate image counter clockwise.

**Zoom**: Adjust image zoom within the cropped area; maximum zoom is 200% and minimum is 12.5%.

**Cancel**: Undo all unsaved changes and exit image edit mode.

**Save**: Save all changes made to the image; this overwrites the existing image file.

![All saved changes overwrite the existing image file](./editing-images/images/03.png)

## For Liferay 7.3.x and Earlier

The Documents and Media application comes with a built-in image editor. Edit images right from your browser and apply filters, adjust contrast, or crop.

In the Documents and Media application, locate the image. Click the Options icon (![Options icon](../../../images/icon-options.png)) and select *Edit With Image Editor*. 

![The Options icon contains functions for sharing, editing, checking out, or changing permissions for images.](editing-images/images/04.png)

The image editor offers a minimal, user-friendly UI with the following tools.

![There are different editing tools below the image.](editing-images/images/05.png)

### Effects Tool (Filters)

Select from and apply predefined filters to your image.

![The Effects tool brings up predefined filters you can apply to your image.](editing-images/images/06.png)

### Transform Tools (Transform Option)

**Rotate**: Rotates the image to the left or right, in 90 degree increments.

**Resize**: Resizes the image in pixels. If the lock is closed, the aspect ratio remains locked, and changing either width or height automatically adjust the other dimension to maintain the aspect ratio. When the lock is opened, the width and height can be changed individually, allowing the aspect ratio to be altered.

**Crop**: Reframes the image by removing the outer portions.

### Adjustment Tools (Color Adjustment)

**Saturation**: Adjusts the color saturation in the image. The default value of 50 is the current saturation. The slider values range from 0 (completely desaturated) to 100 (completely saturated).

**Contrast**: Adjusts the difference between highlights and shadows. The default value of 50 is the current contrast. The slider values range from 0 (no contrast) to 100 (full contrast).

**Brightness**: Adjusts the amount of light in the image. The default value of 50 is the current brightness. The slider ranges from 0 (completely black) to 100 (completely white).

Once you have made changes to the image in the editor, you can click *Apply* to make the changes to the image. Click the *Cancel* button to cancel the changes. 

There is also history bar at the top of the image:

![The history bar at the top of your image can be used to undo or redo changes.](editing-images/images/07.png)

The history bar can undo, redo, or reset changes that have been made to the image in the editor. Use the reset button with caution: once it has been pressed the image is reset to its original state, causing all changes made within the editor to be lost.
