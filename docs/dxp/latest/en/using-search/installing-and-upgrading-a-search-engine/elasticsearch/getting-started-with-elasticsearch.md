# Getting Started with Elasticsearch

> **Compatibility:** See the [Search Engine Compatibility Matrix](https://help.liferay.com/hc/en-us/articles/360016511651) for details on the compatible Elasticsearch versions, available Liferay connectors, and required Liferay patch levels.

A typical Liferay system's search infrastructure comprises

* Liferay servers configured in a cluster or a single node (on-premises or Docker containers)
* Elasticsearch server(s) (on-premises or Docker containers)
* An Elasticsearch connector application deployed onto Liferay and configured to fit your deployment.

```tip::
   Additional features and intergrations are available with a `Liferay Enterprise Search <../../liferay_enterprise_search.rst>`__ subscription.
```

Assuming your Liferay servers are in place already, the remaining steps include

1. Determining the Elasticsearch server and connector version to use

1. Setting up your Elasticsearch server(s)

1. Connecting Liferay to Elasticsearch

## Finding Compatible Elasticsearch and Connector Versions 

Each Liferay CE/DXP version is bundled with a connector to Elasticsearch that is compatible with a specific Elasticsearch major version (e.g., 6.x or 7.x). To add support for newer major Elasticsearch versions, Liferay releases additional connectors through [Marketplace](https://web.liferay.com/marketplace). These can be used as drop-in replacements for the out-of-the-box (bundled) connector.

The [Search Engine Compatibility Matrix](https://help.liferay.com/hc/en-us/articles/360016511651) shows the latest supported Elasticsearch component versions for each Liferay version. The Elasticsearch server and the connector to Elasticsearch are required components.

```warning::
   The Liferay Connector to Elasticsearch that your Liferay installation includes may not be the latest connector. Make sure to use the latest connector for the Elasticsearch version you're using. The connectors are available on `Liferay Marketplace <https://web.liferay.com/marketplace>`_.
```

## Installing Elasticsearch 

Elasticsearch can be installed using an Elasticsearch archive or Docker image. It can be configured on a cluster of servers too. Here are some different Elasticsearch hosting examples:

* [Installing Elasticsearch from an archive](./installing-elasticsearch.md)
* [Installing Elasticsearch using Docker](./exercise-run-liferay-and-elasticsearch-using-docker.md)

Also the [Liferay clustering example](../../../installation-and-upgrades/setting-up-liferay/clustering-for-high-availability/example-creating-a-simple-dxp-cluster.md) demonstrates using a Liferay cluster with Elasticsearch.

## Connecting Liferay to Elasticsearch 

A connector to Elasticsearch is bundled with Liferay. The latest Liferay Connector to Elasticsearch application is also available on Liferay Marketplace. See [Connecting to Elasticsearch](./connecting-to-elasticsearch.md) for details.

## Securing Elasticsearch 

In production, you should secure Liferay's communication with Elasticsearch. [Securing Elasticsearch](./securing-elasticsearch.md) explains how to configure authentication and encryption and demonstrates using PEM certificates, required for Liferay Enterprise Search Monitoring.

## What's Next 

[Installing Elasticsearch](./installing-elasticsearch.md) explains each manual installation and configuration step. These steps are helpful to understand, even if you're running on Docker. If you'd rather start with running Elasticsearch and Liferay on Docker, visit [Exercise: Run Liferay and Elasticsearch Using Docker](./exercise-run-liferay-and-elasticsearch-using-docker.md).
