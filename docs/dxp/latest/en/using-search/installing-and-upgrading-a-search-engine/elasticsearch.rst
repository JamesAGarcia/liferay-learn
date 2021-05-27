Elasticsearch
=============

.. toctree::
   :maxdepth: 2

   elasticsearch/getting-started-with-elasticsearch.md
   elasticsearch/installing-elasticsearch.md
   elasticsearch/connecting-to-elasticsearch.md
   elasticsearch/securing-elasticsearch.md
   elasticsearch/exercise-run-liferay-and-elasticsearch-using-docker.md
   elasticsearch/troubleshooting-elasticsearch-installation.md
   elasticsearch/using-the-sidecar-or-embedded-elasticsearch.md
   elasticsearch/upgrading_elasticsearch.rst
   
Elasticsearch is the highly scalable, full-text search engine Liferay uses by default. Elasticsearch is bundled with Liferay for non-production purposes. In production, Liferay requires Elasticsearch running on a separate remote server.

.. important::
   Always check the `compatibility matrix <https://help.liferay.com/hc/en-us/sections/360002103292-Compatibility-Matrix>`__ for the Elasticsearch version and server configuration compatible with your Liferay version.


.. important::
   Liferay 7.2 and 7.3 include support for Elasticsearch 7 and securing authenticated, encrypted Elasticsearch connections. Securing the Elasticsearch 6 connector (available on Liferay 7.2) requires an additional module only available with a `Liferay Enterprise Search subscription <../liferay_enterprise_search.md>`__.

Installing
~~~~~~~~~~

-  :doc:`/using-search/installing-and-upgrading-a-search-engine/elasticsearch/getting-started-with-elasticsearch`
-  :doc:`/using-search/installing-and-upgrading-a-search-engine/elasticsearch/installing-elasticsearch`
-  :doc:`/using-search/installing-and-upgrading-a-search-engine/elasticsearch/connecting-to-elasticsearch`
-  :doc:`/using-search/installing-and-upgrading-a-search-engine/elasticsearch/exercise-run-liferay-and-elasticsearch-using-docker`
-  :doc:`/using-search/installing-and-upgrading-a-search-engine/elasticsearch/troubleshooting-elasticsearch-installation`
-  :doc:`/using-search/installing-and-upgrading-a-search-engine/elasticsearch/using-the-sidecar-or-embedded-elasticsearch`

- `[Clustering Liferay]` `Add a Search Engine to a Liferay Cluster <../../installation-and-upgrades/setting-up-liferay/clustering-for-high-availability/example-creating-a-simple-dxp-cluster.md#start-a-search-engine-server>`__

Upgrading
~~~~~~~~~

-  :doc:`/using-search/installing-and-upgrading-a-search-engine/elasticsearch/upgrading_elasticsearch`
-  :doc:`/using-search/installing-and-upgrading-a-search-engine/elasticsearch/upgrading-elasticsearch/upgrading-search-for-liferay-73`
-  :doc:`/using-search/installing-and-upgrading-a-search-engine/elasticsearch/upgrading-elasticsearch/backing-up-elasticsearch`
-  :doc:`/using-search/installing-and-upgrading-a-search-engine/elasticsearch/upgrading-elasticsearch/upgrading-to-elasticsearch-7`

Securing
~~~~~~~~

-  :doc:`/using-search/installing-and-upgrading-a-search-engine/elasticsearch/securing-elasticsearch`

Install an Older Elasticsearch Version
______________________________________

- Elasticsearch 6 for Liferay 7.2 (Coming Soon!)

Configuring
~~~~~~~~~~~

-  :doc:`/using-search/installing-and-upgrading-a-search-engine/elasticsearch/elasticsearch-connector-settings`
