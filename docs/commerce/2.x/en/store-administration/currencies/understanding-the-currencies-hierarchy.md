# Understanding the Currencies Hierarchy

Liferay Commerce supports the use of multiple currencies and implements a hierarchy to govern currency settings across store Catalogs, Price Lists, and Channels.

```note::
   You can view available currencies via the *Currencies* page in the *Commerce* tab of the *Global Menu*. Here you can edit, prioritize, add/remove, and activate/deactivate currencies.
```

In this hierarchy, a [Catalog's](../../managing-a-catalog/catalogs/creating-a-new-catalog.md) currency is set at creation and determines the initial currency for its Base Price List. However, after creation, they are set independently. You can also create custom [Price Lists](../../managing-a-catalog/managing-price/creating-a-price-list.md) with their own currencies that take precedent over the Base Price currency under specified circumstances (e.g., Accounts, Account Groups). Currencies set at this level determine the value used for Commerce's exchange rate calculations, which determine the prices stored in store Channels and used for orders.  

[Channel](../../starting-a-store/channels/managing-channels.md) currencies are also set at creation and determine the currency stored in specific store Channels and are used for all orders generated in it. Commerce's [Exchange Rate Provider](./managing-exchange-rates.md) takes the appropriate Price List price with it's currency and converts it to the Channel's currency. The result is then displayed for all Channel products and order invoices.

For example, consider a US-based store with two Channels, one for US customers and another for EU customers. While the store's product Catalog and Base Price List use USD, each Channel has its own currency. Commerce's Exchange Rate Provider automatically converts the base prices from USD into EUR and stores them in the EU Channel. This ensures German customers accessing the EU Channel see Euros on their invoices, while US customers see the original USD price.

<!-- Update article once [COMMERCE-5171](https://issues.liferay.com/browse/COMMERCE-5171) is implemented. It removes Catalog Currency and uses the Base Price List currency alone as currency basis. -->

## Additional Information

* [Adding a New Currency](./adding-a-new-currency.md)
* [Managing Exchange Rates](./managing-exchange-rates.md)
* [Currencies Reference](./currencies-reference.md)
