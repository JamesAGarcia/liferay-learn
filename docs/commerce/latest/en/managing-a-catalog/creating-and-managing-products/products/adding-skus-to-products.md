# Adding SKUs to Products

In Liferay Commerce, stock-keeping units (SKUs) represent purchaseable versions of a Product. Each Product is created with a single default SKU, but you can use Product [Options](../products/using-product-options.md) to manually or automatically create multiple active SKUs for a Product. This provides a convenient way to inventory and price Product variants. Once created, these variants are displayed to customers in the Product Details widget.

![Product variants are displayed in the PRoduct Details widget.](./adding-skus-to-products/images/01.png)

```important::
   A Product must have at least one Option with SKU Contributor enabled to create and activate multiple SKUs for it. Otherwise, only one SKU can be active for a Product at a time.
   
   It’s highly recommended that Product Option values are finalized before using them to create SKUs. See `Using Product Options <./using-product-options.md`>_ for more information.
```

## Automatically Generating Multiple SKUs

Follow these steps to generate and activate multiple SKUs for a Product:

1. Open the *Global Menu* (![Global Menu](../../../images/icon-applications-menu.png)), click on the *Commerce* tab, and go to *Products*.

1. Click on a Product that has at least one Option with SKU Contributor enabled, and go to the *SKUs* tab.

1. Click the *Add* button (![Add Button](../../../images/icon-add.png)), and select *Generate All SKU Combinations*.

   ![Select Generate All SKU Combinations.](./adding-skus-to-products/images/02.png)

   SKUs are automatically generated for each Option value. These SKUs use the value's name and are created without Base Price or inventory. To configure an SKU, click its *Actions* button (![Actions Button](../../../images/icon-actions.png)), and select *Edit*. See [SKU Fields Reference](#sku-fields-reference) for more information.

   ![Edit the generated SKUs.](./adding-skus-to-products/images/03.png)

1. When finished, click on *Publish*.

## Manually Adding an SKU to a Product

Follow these steps to manually create a Product SKU for individual Option values:

   ```important::
      While SKU Contributor is enabled, each manually created SKU must be mapped to an Option value.
   ```

1. Open the *Global Menu* (![Global Menu](../../../images/icon-applications-menu.png)), click on the *Commerce* tab, and go to *Products*.

1. Click on a Product that has at least one Option with SKU Contributor enabled, and go to the *SKUs* tab.

1. Click the *Add* button (![Add Button](../../../images/icon-add.png)), and select *Add SKU*.

   ![Select Add SKU.](./adding-skus-to-products/images/04.png)

1. Configure the SKU fields. See [SKU Fields Reference](#sku-fields-reference) for more information.

   ![Configure the SKU.](./adding-skus-to-products/images/05.png)

1. When finished, click on *Publish*.

## Adding SKU Inventory

If Allow Back Orders is enabled for the Product, all published SKUs with a set base price are immediately available to Customers for purchase in the Product Details widget. However, if Allow Back Orders is disabled, you must first add inventory to the SKUs to make them available for purchase. See [Introduction to Managing Inventory](../../managing-inventory/introduction-to-managing-inventory.md) for more information.

![Add inventory for each Product SKU.](./adding-skus-to-products/images/06.png)

```note::
   If all SKU inventory is 0 and Allow Back Orders is disabled, then none of the Product variants are listed in the Product Details widget. However, if only one SKU reaches 0, then all variants are listed. 
   
   If *Allow Back Orders* is enabled, then all Options are listed in the Product Details widget, regardless of inventory. 
```

## SKU Fields Reference

### Details

| Field | Description |
| --- | --- |
| SKU (Required) | Enter an SKU for the Product variant |
| [Option Field] (Required) | Used to map the SKU to an Option value when SKU Contributor is enabled |
| Purchaseable | Determines whether the SKU can be purchased |
| Global Trade Item Number | Sets a GTIN for the SKU |
| Manufacturer Part Number | Sets an MPN for the SKU |
| UNSPSC | Sets a United Nations Standard Products and Services Code for the SKU |

### Pricing

| Field | Description |
| --- | --- |
| Base Price | Sets a Base Price entry for the SKU |
| Sale Price | Sets a sale price for the SKU's Base Price entry |
| Cost | Sets the SKU cost used for net calculations |

### Shipping Override

These fields override Product-level specifications for individual SKUs and are used for shipping.

| Field | Description |
| --- | --- |
| Width | Overrides Product width |
| Height | Overrides Product height |
| Depth | Overrides Product depth |
| Weight | Overrides Product weight |

### Schedule

| Field | Description |
| --- | --- |
| Published | Makes the SKU visible and available for purchase |
| Display Date | Determines when the SKU is first displayed in Site for purchase. |
| Expiration Date | Determines when the SKU is no longer available for purchase |
| Never Expire | Determines whether the SKU can be scheduled to automatically expire |

## Additional Information

* [Overriding Product Level Information](./overriding-product-level-information.md)
