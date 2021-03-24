# Creating a Grouped Product

In Liferay Commerce, a Grouped Product consists of two or more Products from a Catalog that are sold together as a pre-defined set, either for customer convenience or to offer a special price. Grouped Products are tracked in inventory and can include any type of Products (i.e., Simple, Grouped, Virtual). <!--Clarify how inventory works for Grouped Products--> For example, consider a wholesale furniture distributor. While furniture items can be purchased separately, the distributor can group related products together into a furniture set, either for ease, or for offering a special, discounted price.

To get started, [create](#create-a-grouped-product) a Grouped Product and [add](#adding-product-entries) new Product entries to it. Then, configure the Grouped Product and SKU.

<!-- Insert admonition delineating the difference between Grouped Products and Product bundles. -->

## Prerequisites

Before creating a Grouped Product, ensure that the following conditions have been met:

1. All Products you want to add to the Grouped Product have been created in the Catalog.

    * All SKUs have been generated.
    * All prices have been set.

1. Each Product has sufficient inventory.

## Create a Grouped Product

Follow these steps to create a Grouped Product:

1. Open the *Global Menu*, click on the *Commerce* tab, and go to *Product Management* &rarr; *Products*.

1. Click the *Add* button (![Add icon](../../../images/icon-add.png)), and select *Grouped*.

1. Enter a *name*, and select the desired *Catalog*.

1. Click *Submit*.

This creates a new Grouped Product entity in the selected Catalog with a single SKU, *default*. Grouped Products can be configured in the same way as other Product types (e.g., SEO, Options, Inventory Rules). See [Product Configuration Reference](../products/product-configuration-reference.md) for more information about general Product settings.

![Configure the Grouped Product, and add individual Products to it](./creating-a-grouped-product/images/01.png)

## Adding Product Entries

Follow these steps to add entries to the Grouped Product:

1. Click on the *Grouped* tab.

1. Click the Add button (![Add Button](../../../images/icon-add.png)), and select the desired Product entries.

1. When finished, click *Add*.

The selected Product entries are immediately associated with the Grouped Product and are listed in the *Grouped* tab. You can edit each entry to determine its *quantity* and *priority*.

![View associated Product entries in the Grouped tab, and determine their quantity and priority.](./creating-a-grouped-product/images/02.png)

Once you've created the Grouped Product and associated other Products with it, set a base price for the default [SKU](./../products/adding-skus-to-your-products.md) to make it available for purchase. This price is used in place of each Product's individual price. As long as each individual product has enough stock in the inventory, buyers can select the Grouped Product for purchase.

![Each Product's inventory determines the availability of the Grouped Product](./creating-a-grouped-product/images/05.png)

## Commerce 2.1 and Below

1. Navigate to _Control Panel_ → _Commerce_ → _Products_.
1. Click the Add (![Add icon](../../../images/icon-add.png)) button then _Grouped_.
1. Enter the following:
    * **Catalog**: Sahara.com
    * **Name**: Brakes Set Combo Kit
    * **Short Description**: Brakes Set Combo Kit
    * **Friendly URL**: (auto-generated)
    * **Meta Title**: Brakes Set Combo Kit
1. Click _Publish_.

Once the Grouped Product entity has been initially created, store administrators will need to associate the individual products to the grouped product entry.

### Associate Products in Group

1. Click the _Grouped_ sub-tab.

   ![Grouped Sub-Tab](./creating-a-grouped-product/images/01.png)

1. Click the (![Add icon](../../../images/icon-add.png)) button to add a Grouped Entry.
1. Select the following products: _Brake Fluid_, _Brake Pads_, and _Brake Rotors_.
1. Click _Add_.

    ![Grouped Sub-Tab](./creating-a-grouped-product/images/02.png)

Next, specify the priority (the order in which they are displayed), and the quantity sold in each package. Click the _3-dot_ icon then _Edit_ next to any of the products.

![Adding a Product to a Grouped Product](./creating-a-grouped-product/images/03.png)

In the image above, the product has been given priority 1.0 which means it will be listed first. Assign incremental values to the other products.

![Grouped Product Priority](./creating-a-grouped-product/images/04.png)

Once the products have been grouped, follow the sections above to add Product Options, Generate SKUs, and set the prices. In addition, see the above sections on how to add Product Options, Specifications or upload Product Images.

### Setting Prices and Quantities on Liferay Commerce 2.0 and Below

To set product prices and quantities for a Grouped product:

1. Click the _SKU_ tab.
1. Click the _3-dot_ icon then _Edit_ next to _default_. (At this point, you can rename the SKU to something more descriptive like _Brakes Set Combo Kit_ on the _Details_ menu.)
1. Click _Pricing_ on the left menu.
1. Enter the following:
    * **Price**: 89.99
    * **Promo Price**: 0.00
    * **Cost**: 0.00

        ![Grouped Product Pricing](./creating-a-grouped-product/images/06.png)

1. Click _Save_. (If Promo Price and Cost fields are left as 0.00, no discounts or promotions are applied at this point.)
1. Click _Price List_ to apply this product to any existing [Price Lists](../../managing-price/adding-products-to-a-price-list.md).

## Additional Information

* [Introduction to Product Types](./introduction-to-product-types.md)
* [Creating a Simple Product](./creating-a-simple-product.md)
* [Creating a Virtual Product](./creating-a-virtual-product.md)
