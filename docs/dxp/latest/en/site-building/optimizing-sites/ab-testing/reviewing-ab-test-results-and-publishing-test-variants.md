# Reviewing A/B Test Results and Publishing Test Variants

When the A/B Test finishes, you can find the test results in Analytics Cloud and Liferay DXP. Analytics Cloud declares a winning variant when the *Confidence Level Required* is achieved during the duration of the test. To understand how to configure the *Confidence Level Required* for your test, see [Creating A/B Tests](./creating-ab-tests.md).

```tip::
   You receive a `notification in Liferay <../../../collaboration-and-social/notifications-and-requests/user-guide/managing-notifications-and-requests.md>`_ when the A/B Test finishes.
```

To review the A/B Test results and publish your Variant,

1. Go to the Content Page where the A/B Test is running.
1. In the Control Menu, click the *A/B Testing* icon (![A/B Test icon](../../../images/icon-ab-testing.png)). Starting with Liferay DXP 7.3, you can also access the A/B Test panel and view the test status for an experience through the [experience selection dialog](../../personalizing-site-experience/experience-personalization/creating-and-managing-experiences.md).
1. If you have other Experiences for the Content Page, select the *Experience*.
1. Review the test results under the Active Test section:

    * *Winner Declared*: One of the test variants met the Confidence Level Required.
    * *No Winner*: None of the test variants met the Confidence Level Required for the duration of the test.

        ![Review A/B Test Results from the A/B Test panel](reviewing-ab-test-results-and-publishing-test-variants/images/01.png)

1. From the Variants section, you can

    - *Publish* the winning Variant, which is highlighted with the check mark.
    - *Publish* a non-winning variant.
    - *Discard Test*, to ignore the A/B Test recommendations and keep the current Content Page.

        ![You can publish the winning Variant or discard the A/B Test results.](reviewing-ab-test-results-and-publishing-test-variants/images/02.png)

        ```note::
           When you publish one of the A/B Test Variants, the Variant becomes active for all users visiting the Content Page.
        ```

You can click the *View Data in Analytics Cloud* button from the A/B Tests panel to go to the Analytics Cloud dashboard and view other test statistics. For more information, see [A/B Testing Analytics](https://learn.liferay.com/analytics-cloud/latest/en/optimization/a-b-testing.html).

## Related Information

- [A/B Testing](./ab-testing.md)
- [Creating A/B Tests](./creating-ab-tests.md)
- [Verifying A/B Test Requirements](./verifying-ab-test-requirements.md)
- [Running and Monitoring A/B Tests](./running-and-monitoring-ab-tests)
