# Using Staging in Asset Libraries

With Liferay, you can enable [Local Live](./configuring-local-live-staging.md) or [Remote Live](./configuring-remote-live-staging.md) Staging for individual Asset Libraries. This provides a working environment for adding, removing, and editing assets in Web Content or Documents and Media applications before making those changes live.

```note::
   Asset Libraries support Staging as of Liferay DXP 7.3.10 FP1 and 7.4.
```

Once Staging is enabled for an Asset Library, you can toggle between Live and Staging environments within it via the Staging bar at the top of the page. While in the Staging environment, you can also access *Publish to Live* to initiate a new publishing process.

![Navigate to the Asset Library to access the Staging bar.](./using-staging-in-asset-libraries/images/01.png)

Many editing options can only be accessed in the Staging environment. This is to maintain a clear development process and avoid data conflicts due to edits in the Live environment.

When changes are made in the Staging environment, they can then be published all at once, or one at a time. As with [Sites](./site-staging-ui-reference.md#publish-to-live), you can use [simple](./site-staging-ui-reference.md#simple-publishing) or [advanced](./site-staging-ui-reference.md#advanced-publishing) publishing options.

```important::
   Asset Libraries with Staging enabled can only be linked with Sites that also have Staging enabled. When Staging is enabled for an Asset Library, existing Site connections are automatically removed if the Site doesn't also have Staging enabled. 
```

## Additional Information

* [Staging Overview](./staging-overview.md)
* [Configuring Local Live Staging](./configuring-local-live-staging.md)
* [Configuring Remote Live Staging](./configuring-remote-live-staging.md)
