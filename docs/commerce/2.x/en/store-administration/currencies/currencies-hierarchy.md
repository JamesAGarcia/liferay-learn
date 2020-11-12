# Currencies Hierarchy

Liferay Commerce has implemented a currency hierarchy which governs the currency settings in the store's [catalog](../../managing-a-catalog/catalogs/creating-a-new-catalog.md), [Channels](../../starting-a-store/channels/introduction-to-channels.md), and [Price Lists](../../managing-a-catalog/managing-price/creating-a-price-list.md). This hierarchy is necessary because Liferay Commerce supports multiple currencies.

The hierarchy is as follows: the base Catalog currency is modified by the applicable Price List then converted using the Exchange Rate provider to display the price based on the channel's currency settings.

For example, a US-based store has one channel for US-based customers that display its prices in USD and another channel for European customers that display its prices in Euros. Liferay Commerce's Exchange Rate Provider automatically converts the prices from USD into Euros. Depending on the customer, the channel displays the product's prices in either USD or Euros.

Lastly, the currency displayed on the order invoice uses the *channel's* currency. Continuing the example above, a German customer who bought items from the European channel will see Euros on his invoice.

If the store needs to update its prices, users must modify the base Catalog's prices first. Once the catalog has been updated, all Price Lists and the channels are automatically updated with the new prices. See [Introduction to Product Pricing Methods](../../managing-a-catalog/managing-price/introduction-to-product-pricing-methods.md) and [Setting a Product's Base Price](../../managing-a-catalog/managing-price/setting-a-products-base-price.md) to learn how more.

If there are multiple price lists, Liferay Commerce applies the price list based on the priority. See [Creating a Price List](../../managing-a-catalog/managing-price/creating-a-price-list.md) to learn more.

```important::
   Priority is based on the lowest number. If a price list has a priority value of 1.0, this price list is considered the most relevant compared to a price list with a priority of 2.0.
```

<!-- We need to update this article once https://issues.liferay.com/browse/COMMERCE-5171 is implemented. This removes Catalog Currency as the base and uses with the default Price List instead. -->

## Additional Information

* [Managing Channels](../../starting-a-store/channels/managing-channels.md)
* [Managing Exchange Rates](./managing-exchange-rates.md)
* [Currencies Reference](./currencies-reference.md)
