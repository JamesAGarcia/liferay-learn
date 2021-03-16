# Understanding the Currency Hierarchy

With Liferay Commerce, you can use multiple currencies across Catalogs, Price Lists, and Channels. Each currency has its own role in the Commerce currency hierarchy.

The [Catalog's](../../managing-a-catalog/catalogs/creating-a-new-catalog.md) currency sets the initial currency for its Base Price List, which determines each product's default price. You can then use custom [Price Lists](../../managing-a-catalog/managing-price/creating-a-price-list.md) with alternate currencies to override the Base Price List in specific cases, according to your configuration.

When products are added to a store [Channel](../../starting-a-store/channels/managing-channels.md), their prices are converted to the Channel's currency using an [Exchange Rate Provider](./managing-exchange-rates.md). The resulting price is then stored in the Channel and used for all Channel orders.

For example, consider a US-based store with two Channels, one for US customers and another for EU customers. While the store's product Catalog and Base Price List use USD, each Channel has its own currency. Commerce's Exchange Rate Provider automatically converts the base prices from USD into EUR and stores them in the EU Channel. This ensures German customer orders in the EU Channel use Euros, while US customer orders use USD.

```note::
   You can view available currencies via the *Currencies* page in the *Commerce* tab of the *Global Menu*. Here you can edit, prioritize, add/remove, and activate/deactivate currencies. See `Currencies Reference <./currencies-reference.md>`_ and `Adding a New Currency <./adding-a-new-currency.md>`_ for more information.
```

<!-- Update article once [COMMERCE-5171](https://issues.liferay.com/browse/COMMERCE-5171) is implemented. It removes Catalog Currency and uses the Base Price List currency alone as currency basis. -->

## Additional Information

* [Adding a New Currency](./adding-a-new-currency.md)
* [Managing Exchange Rates](./managing-exchange-rates.md)
* [Currencies Reference](./currencies-reference.md)
