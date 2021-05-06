# Maintenance Mode and Deprecations in 7.4

With each new DXP release, a feature may not warrant continued enhancements or may become obsolete. Stopping enhancements for a feature puts it in *Maintenance Mode*.

**Maintenance Mode:** The feature is supported but no longer being enhanced.

Obsolete features are eventually removed or replaced with newer, better features. Before dropping support for an obsolete feature, Liferay marks it *Deprecated*.

**Deprecated:** The feature will be unsupported as early as the next minor version release. For example, support for a feature deprecated in 7.4 can be dropped as early as 7.5.

```important::
   Plan to stop using deprecated features because their support may cease as early as the next minor release.
```

```important::
   Please see `Maintenance Mode and Deprecation Policies <https://help.liferay.com/hc/en-us/articles/360015767952-Maintenance-Mode-and-Deprecation>`_ for details.
```

## Deprecated Feature Availability

Deprecated features have different availability:

**Bundled:** The feature is included in the Liferay product.

**Marketplace:** The feature is included in a Marketplace app final version.

**Final:** The final version of the Marketplace app is released for this Liferay version.

**Archived:** The feature is unavailable, but its code is available in a sources artifact on Liferay's repository at <https://repository.liferay.com/nexus/index.html#welcome>.

**Removed:** The feature and its code are unavailable.

## Features Deprecated in 7.4

Here are the features deprecated in 7.4:

| Feature | Availability | Notes |
| :------ | :----------- | :---- |
| EXT Plugin Support | Removed | Replaced by configuration settings and standard [extension points](../../../liferay-internals/extending_liferay.html). |

Features deprecated in earlier Liferay versions may also need to be considered, if you are upgrading from an earlier version.

* [7.3 Deprecations and Features Moved to Maintenance Mode](./maintenance-mode-and-deprecations-in-7-3.md)
* [7.2 Deprecations and Features Moved to Maintenance Mode](./maintenance-mode-and-deprecations-in-7-2.md)
* [7.1 Deprecations](https://help.liferay.com/hc/en-us/articles/360018403151-Digital-Experience-Platform-7-1-Deprecated-and-Removed-Items)
* [7.0 Deprecations](https://help.liferay.com/hc/en-us/articles/360018123832-Digital-Experience-Platform-7-0-Deprecated-and-Removed-Items)

## Features Moved to Maintenance Mode in 7.4

Here are the features moved to Maintenance Mode in 7.4:

* TBD

## Additional Information

* [7.4 Breaking Changes](../../../liferay-internals/reference/7-4-breaking-changes.md)
* [7.4 Default Setting Changes](./default-setting-changes-in-7-4.md)