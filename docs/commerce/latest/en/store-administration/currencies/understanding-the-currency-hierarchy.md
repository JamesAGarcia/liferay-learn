# Understanding the Currency Hierarchy

With Liferay Commerce, you can use different currencies across Catalogs, Price Lists, and Channels. Each currency has its own role in the Commerce currency hierarchy.

The [Catalog's](../../managing-a-catalog/catalogs/creating-a-new-catalog.md) currency sets the initial currency for its Base Price List, which determines each product's base price. You can then use custom [Price Lists](../../managing-a-catalog/managing-prices/creating-a-price-list.md) with alternate currencies to override the Base Price List for specific Channels, Accounts, and Account Groups.

When products are added to a [Channel](../../starting-a-store/channels/managing-channels.md), their prices are converted to the Channel's currency using an [Exchange Rate Provider](./managing-exchange-rates.md). The converted price is then stored in the Channel and used for its display and order prices.

For example, consider a US-based business with two Channels, one for US customers and another for EU customers. This business's Catalog and Base Price List both use USD, while its Channels use different currencies, USD and EUR. When its products are made available to these Channels, Commerce's Exchange Rate Provider automatically converts the base USD prices to the Channel's currency.

In this example, the USD prices are converted to EUR prices and stored in the EU Channel. These stored prices are then used for the Channel's connected Site. This ensures that German customers see EUR prices when browsing the EU Channel's Site, while US customers accessing the US Channel's Site see USD prices. When orders are created, each Channel uses its stored prices in the appropriate currency.

```note::
   You can view available currencies via the *Currencies* page in the *Commerce* tab of the *Global Menu*. Here you can edit, prioritize, add/remove, and activate/deactivate currencies. See `Currencies Reference <./currencies-reference.md>`_ and `Adding a New Currency <./adding-a-new-currency.md>`_ for more information.
```

<!-- Update article once [COMMERCE-5171](https://issues.liferay.com/browse/COMMERCE-5171) is implemented. It removes Catalog Currency and uses the Base Price List currency alone as currency basis. -->

## Additional Information

* [Adding a New Currency](./adding-a-new-currency.md)
* [Managing Exchange Rates](./managing-exchange-rates.md)
* [Currencies Reference](./currencies-reference.md)
