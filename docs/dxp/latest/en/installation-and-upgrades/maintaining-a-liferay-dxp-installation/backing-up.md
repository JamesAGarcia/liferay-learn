# Backing Up

Once you have your DXP installation running, you should implement a comprehensive backup plan that accounts for unforeseen events. Backup copies are also valuable for testing updates (e.g., DXP upgrades, new plugins, and more).

When considering a back up plan for Liferay DXP, we recommend backing up the following areas:

* [Liferay Home directory](#liferay-home)
* [Application Server](#application-server)
* [Database](#database)
* [Search Indexes](#search-indexes)
* [Source Code](#source-code)

```note::
   DXP Cloud automates and simplifies the process of creating and managing backups of the Document Library and Liferay DXP database. Because DXP Cloud uses a Git-based DevOps pipeline, all configurations for Liferay are also automatically backed up as well. To learn more, see `DXP Cloud Backup Service <https://learn.liferay.com/dxp-cloud/latest/en/platform-services/backup-service/backup-service-overview.html>`_ for more information.
```

## Liferay Home

The Liferay Home folder is important to back up because it contains the following files:

* **Portal properties and system properties:** The Liferay Home folder stores DXP [portal properties files](../reference/portal-properties.md) (e.g., `portal-ext.properties`, `portal-setup-wizard.properties`, etc.) and DXP [system properties files](../reference/system-properties.md) (e.g., `system-ext.properties`).

* **`/data` folder:** DXP stores configuration files, search indexes, and cache information in Liferay Home's `/data` folder. Note, the `/data/document_library` folder is the default storage configuration location for the [Simple File System Store](../../system-administration/file-storage/other-file-store-types/simple-file-system-store.md). The [Advanced File System Store](../../system-administration/file-storage/configuring-file-storage.md) requires setting the storage location explicitly.

* **`/license` folder (Subscription):** Holds the activation key for the Liferay Enterprise Subscription.

* **`/osgi` folder:** The files that comprise DXP's OSGi runtime are stored in Liferay Home's `/osgi` folder. It contains all of the app and module JAR files deployed to DXP. The `/osgi` folder also contains other required JAR files, [configuration files](https://help.liferay.com/hc/en-us/articles/360029131651-Understanding-System-Configuration-Files), and log files.

* **`/logs` folder:** Contains DXP's log files. If a problem occurs on DXP, the log files provide information for determining what went wrong.

```note::
   If you are using a Liferay Docker image and are using custom Liferay and application server configuration files via a bind mount, back up those files (e.g., files in your ``[host folder]/files`` folder).
```

Using a source control repository such as Git, BitBucket, Subversion, or CVS, is a great way to back up your Liferay Home folder.

```important::
   If you configured your File Store (Document Library) to a location other than a ``[Liferay Home]/data`` subfolder, back up that location.
```

## Application Server

The application server has the DXP descriptors, deployments, and dependencies you might have customized. If you've customized DXP's `web.xml` file, for example, you should back it up because a DXP patch's `web.xml` always overwrites the existing one. Backing up your entire application server is suggested.

## Database

DXP's database is the central repository for all of the portal's information. It's the most important component to back up. You can back up the database live (if your database allows this) or by exporting (dumping) the database into a file and then backing up the exported file.

For example, [MySQL's `mysqldump`](https://dev.mysql.com/doc/refman/5.7/en/using-mysqldump.html) utility exports the entire database and data into a large SQL file:

```bash
mysqldump --databases my-liferay-database > my-liferay-database-backup.sql
```

This file can then be backed up. On restoring the database you can import this file into the database to recreate the database state to that of the time you exported the database.

## File Store

Back up your [file store (Document Library)](../../system-administration/file-storage/configuring-file-storage.md). When you upgrade to a new version of DXP, you must either refer to your existing Document Library or copy the Document Library to your new DXP environment.

## Search Indexes

Always [back up your search indexes](./../../using-search/installing-and-upgrading-a-search-engine/elasticsearch/upgrading-elasticsearch/backing-up-elasticsearch.md). Although most Liferay data can be restored from the database by a full re-index, search indexes are used as [primary storage by some applications](../../using-search/installing-and-upgrading-a-search-engine/elasticsearch/upgrading-elasticsearch/backing-up-elasticsearch.md#backing-up-and-restoring-indexes-used-for-primary-storage). A failure to back up indexes can result in total data loss for these applications.

In addition, users with large data sets can avoid re-indexing all of their content and assets when restoring from a backup. Backing up search data is easiest to do if you have a separate [Elasticsearch or Solr](../../using-search/installing-and-upgrading-a-search-engine/installing-a-search-engine.md) environment storing the search indexes. Follow the search engine's backup/restore documentation for the details (for example, see Elasticsearch's [Snapshot and Restore documentation](https://www.elastic.co/guide/en/elasticsearch/reference/7.x/snapshot-restore.html)).

## Source Code

If you have extended DXP or have written any plugins, they should be stored in a source code repository such as Git or BitBucket. You should back up your source code repository on a regular basis to preserve ongoing work.

## Conclusion

Backing up and restoring Liferay's data is essential to reviving an installation, whether you're recovering from unexpected system failure or performing a routine upgrade. Exercising good, consistent backup procedures on the areas covered here ensures that you can recover the important data your installation requires.
