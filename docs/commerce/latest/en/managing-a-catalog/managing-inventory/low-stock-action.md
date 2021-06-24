# Low Stock Action

With Liferay Commerce, you can set up automated actions for when a Product's inventory falls below a specified threshold. While Commerce only includes the *Set as Unpublished* low stock action out of the box, you can create [custom low stock actions](../../developer-guide/implementing-a-custom-low-stock-activity.md) if desired.

Follow these steps to set up a low stock action for a Product:

1. Open the *Global Menu* (![Global Menu](../../images/icon-applications-menu.png)), click on the *Commerce* tab, and go to *Products*.

1. Click on the desired Product.

1. Click on the *Configurations* tab.

1. Select a *Low Stock Action* using the dropdown menu.

1. Enter a *Low Stock Threshold* to determine when the action is automatically triggered.

1. Click on *Publish*.

Once configured, the selected Low Stock Action is triggered whenever the Product's inventory falls below the set threshold.

## Commerce 2.1 and Below

Access to the Products are found in the _Control Panel_. To configure a Low Stock Action:

1. Navigate to the _Control Panel_ → _Commerce_ → _Products_.
1. Click on a product (for example, _U-Joint_)
1. Click the _Configurations_ sub-tab.
1. Enter the following:
    * **Inventory Engine**: Default
    * **Availability Estimate**: 5-7 Days
    * **Display Availability**: YES
    * **Display Stock Quantity**: YES
    * **Low Stock Threshold**: 5
    * **Low Stock Action**: Set as Unpublished
    * **Allow Back Orders**: Yes
    * **Minimum Order Quantity**: 1
    * **Maximum Order Quantity**: 5
    * **Allowed Order Quantities**: 1
    * **Multiple Order Quantity**: 1

    ![Product Configuration for Low Stock Action](./low-stock-action/images/01.png)

1. Click _Publish_.

The Low Stock Action for this product has been configured. In the future, should the number of stock fall below _5_, the "U-Joint" product will be unpublished.

## Additional Information

* [Product Inventory Configuration Reference](./product-inventory-configuration-reference.md)
* [Implementing a Custom Low Stock Action](../../developer-guide/implementing-a-custom-low-stock-activity.md)
