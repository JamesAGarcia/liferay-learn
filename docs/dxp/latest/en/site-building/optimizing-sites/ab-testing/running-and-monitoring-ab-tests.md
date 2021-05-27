# Running and Monitoring A/B Tests

You can configure these parameters when you run the A/B Test:

- *Traffic Split*: The percentage of visitors randomly split between the variants when visiting the page. Visitors are randomly assigned to a variant and always see the same Variant until the A/B Test finishes.
- *Confidence Level Required*: Represents the accuracy of your test. The higher the required confidence level, the longer it takes to declare the winning Variant.

The *Estimated Time to Declare Winner* provides an estimation of the test duration. This estimation is based on the *Traffic Split* and *Confidence Level Required* configurations, as well as on the estimated page traffic (based on the traffic history provided by Analytics Cloud.)

![A/B Test Run Configurations are tunable to your requirements.](running-and-monitoring-ab-tests/images/01.png)

After you create the test, review the test status and the history of completed and terminated A/B Tests by clicking the *A/B Testing* button (![A/B Test icon](../../../images/icon-ab-testing.png)). Starting with Liferay DXP 7.3, you can also view the A/B Test status for an experience through the [experience selection dialog](../../personalizing-site-experience/experience-personalization/creating-and-managing-experiences.md).

Liferay DXP only shows your test's status and the winning Variant when the test finishes. You can manage the other aspects of your A/B Test in Analytics Cloud. For more information, see [A/B Testing Analytics](https://learn.liferay.com/analytics-cloud/latest/en/touchpoints/a-b-testing.html).

When the A/B Test finishes, you can review the test results and publish the preferred test Variant. For more information, read [Reviewing A/B Test Results and Publishing Test Variants](./reviewing-ab-test-results-and-publishing-test-variants.md).

## Running the A/B Test

```note::
   Before running the test, you must create the A/B Test and test Variant. For more information, read `Creating A/B Tests <./creating-ab-tests.md>`_.
```

1. Go to the Content Page where you want to run the A/B Test

1. In the Control Menu, click the *A/B Testing* button (![A/B Test icon](../../../images/icon-ab-testing.png)).

1. If you have other Experiences for the Content Page, select the Experience.

1. Under the Active Test section, click *Review and Run Test*.

1. Optionally, configure the *Traffic Split* and *Confidence Level Required* settings for your test.

1. Click *Run* and then click *OK*.

You can cancel a running test at any time by clicking *Terminate Test*. A record of the tests completed or canceled is available under the History tab. To delete an A/B Test, you must terminate the test first.

   ![You can cancel a running A/B Test using the Terminate Test button.](./running-and-monitoring-ab-tests/images/02.png)

## Related Information

- [A/B Testing](./ab-testing.md)
- [Verifying A/B Test Requirements](./verifying-ab-test-requirements.md)
- [Running and Monitoring A/B Tests](./running-and-monitoring-ab-tests)
- [Reviewing A/B Test Results and Publishing Test Variants](./reviewing-ab-test-results-and-publishing-test-variants.md)
