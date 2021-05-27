# Backing Up Elasticsearch

[Elasticsearch replicas](https://www.elastic.co/guide/en/elasticsearch/reference/7.x/index-modules.html#index-modules-settings) protect against a node going down, but they won't help you with a catastrophic failure. Only good backup practices can help you then.

One good occasion to back up and test restoring your Elasticsearch indexes is before you [upgrade](./upgrading-search-for-liferay-73.md). In fact, taking a [snapshot of your app-specific indexes (like Liferay's Search Tuning indexes)](#backing-up-and-restoring-indexes-used-for-primary-storage) is essential if your data is stored only in the search index. The snapshot can be used to reindex your previous data (e.g., Synonym Sets and Result Rankings) when you set up a new Elasticsearch server. Make sure to read the Elasticsearch documentation on [snapshot and restore version compatibility](https://www.elastic.co/guide/en/elasticsearch/reference/7.x/snapshot-restore.html#snapshot-restore-version-compatibility) before attempting this approach.

```tip::
   It's convenient to create and manage snapshots via the `Kibana 7.x UI <https://www.elastic.co/guide/en/kibana/7.x/snapshot-repositories.html>`__.
```

Back up your Elasticsearch cluster and test restoring the backup in three steps: 

1. Create a repository

1. Take a snapshot of the Elasticsearch cluster

1. Restore from the snapshot

```note::
   For more detailed information, refer to Elastic's `Elasticsearch administration guide <https://www.elastic.co/guide/en/elasticsearch/guide/master/administration.html>`_, and in particular to the `Snapshot and Restore module <https://www.elastic.co/guide/en/elasticsearch/reference/7.x/snapshot-restore.html>`_.
```

## Create a Repository

First [create a repository](https://www.elastic.co/guide/en/elasticsearch/reference/7.x/snapshots-register-repository.html) to store your snapshots. Here are the supported repository types:

* Shared file system, such as a Network File System or NAS
* Amazon S3
* HDFS (Hadoop Distributed File System)
* Azure Cloud

If you want to store snapshots on a shared file system, first register the path to the shared file system in each node's `elasticsearch.yml` using the [`path.repo` setting](https://www.elastic.co/guide/en/elasticsearch/reference/7.x/snapshots-register-repository.html#snapshots-filesystem-repository). For example,

```yaml
path.repo: ["path/to/shared/file/system/"]
```

After registering the path to the folder hosting the repository (make sure the folder exists), create the repository with a `PUT` command. For example,

```bash
PUT /_snapshot/test_backup
{
  "type": "fs",
  "settings": {
    "location": "/path/to/shared/file/system/"
  }
}'
```

Replace `localhost:9200` with your system's `hostname:port`, replace `test_backup` with the name of the repository to create, and replace the `location` setting value with the absolute path to your shared file system.

If you created the repository correctly, the command returns this result:

```json
{"acknowledged":true}
```

Now that the repository exists, create a snapshot.

## Take a Snapshot of the Cluster

The easiest snapshot approach is to create a [snapshot of all the indexes in your cluster](https://www.elastic.co/guide/en/elasticsearch/reference/7.x/snapshots-take-snapshot.html). For example,

```bash
PUT /_snapshot/test_backup/snapshot_1
```

A successful snapshot command returns this result:

```json
{"accepted":true}
```

You can limit snapshots to specific indexes too. For example, you may have Liferay Enterprise Search Monitoring but want to exclude monitoring indexes from the snapshot. You can explicitly declare the indexes to include in the snapshot. For example,

```bash
PUT /_snapshot/test_backup/snapshot_2
{ "indices": "liferay-0,liferay-20116" }
```

To list all indexes and index metrics, execute this command:

```bash
GET /_cat/indices?v
```

Example index metrics,

```bash
health status index                                              uuid                   pri rep docs.count docs.deleted store.size pri.store.size
green  open   liferay-20101-search-tuning-rankings               ykbNqPjkRkq7aCYnc7G20w   1   0          7            0      7.7kb          7.7kb
green  open   liferay-20101-workflow-metrics-tokens              DF-1vq8IRDmFAqUy4MHHPQ   1   0          4            0       26kb           26kb
green  open   liferay-20101                                      QKXQZeV5RHKfCsZ-TYU-iA   1   0     253015          392     43.1mb         43.1mb
green  open   liferay-20101-workflow-metrics-sla-task-results    SrWzmeLuSKGaIvKrv4WmuA   1   0          4           72     30.6kb         30.6kb
green  open   liferay-20101-workflow-metrics-processes           Ras8CH0PSDGgWSyO3zEBhg   1   0          1            0     49.3kb         49.3kb
green  open   liferay-20101-workflow-metrics-nodes               bcdKKgDySeWf4BJnmMzk6A   1   0          4            0     10.5kb         10.5kb
green  open   liferay-20101-workflow-metrics-sla-process-results VJrNOpJWRoeTaJ-sBGs_vA   1   0          3           91     47.4kb         47.4kb
green  open   liferay-20101-workflow-metrics-instances           OgJMyD5ZQIi2h0xUTSjezg   1   0          3            0     62.4kb         62.4kb
green  open   liferay-0                                          jPIEOfZhSCKZSWnY0L65RQ   1   0     253114          491     50.1mb         50.1mb
green  open   liferay-20101-search-tuning-synonyms               pAUN8st1RmaV1NxXtj-Sig   1   0          1            0      4.1kb          4.1kb
```

```note::
   Elasticsearch uses a *smart snapshots* approach. To understand what that means, consider a single index. The first snapshot includes a copy of the entire index, while subsequent snapshots only include the delta between the first, complete index snapshot and the current state of the index.
```

Eventually you'll end up with a lot of snapshots in your repository, and no matter how cleverly you name the snapshots, you may forget what some snapshots contain. You can get a description using the Elasticsearch API. For example,

```bash
GET /_snapshot/test_backup/snapshot_1
```

returns

```json
{"snapshots":[
    {"snapshot":"snapshot_1",
    "uuid":"WlSjvJwHRh-xlAny7zeW3w",
    "version_id":6.80399,
    "version":"6.8.2",
    "indices":["liferay-20099","liferay-0","liferay-47206"],
    "state":"SUCCESS",
    "start_time":"2018-08-15T21:40:17.261Z",
    "start_time_in_millis":1534369217261,
    "end_time":"2018-08-15T21:40:17.482Z",
    "end_time_in_millis":1534369217482,
    "duration_in_millis":221,
    "failures":[],
    "shards":{
        "total":3,
        "failed":0,
        "successful":3
        
        }
    }
]}
```

The snapshot information includes the time range of the indexes.

If you want to discard a snapshot, use the `DELETE` command.

```bash
DELETE /_snapshot/test_backup/snapshot_1
```

Including all indexes in a snapshot can consume a lot of time and storage. If you start creating a snapshot by mistake (for example, wanted to filter on specific indexes but included all indexes) you can cancel snapshot processing using a `DELETE` command. By deleting the snapshot by name, the snapshot process terminates and the partial snapshot is removed from the repository.

## Test Restoring from the Snapshot

If a catastrophic failure occurs, what good is a snapshot if you can't [restore your search indexes](https://www.elastic.co/guide/en/elasticsearch/reference/7.x/snapshots-restore-snapshot.html) from it? Use the `_restore` API to restore all the snapshot's indexes:

```bash
POST /_snapshot/test_backup/snapshot_1/_restore
```

If you need to restore the data from a snapshot index into an existing index, restore the index with a different name, then reindex the data into the existing index. To limit the restore command to specific indexes, use the `indices` option. Rename the restored index using the `rename_pattern` and `rename_replacement` options:

```bash
POST /_snapshot/test_backup/snapshot_1/_restore
{
    "indices": "liferay-20116",
    "rename_pattern": "(.+)",
    "rename_replacement": "restored-$1"
}
```

This restores only the index named `liferay-20116` from the snapshot, and renames it to `restored_liferay-20116`. Once restored to the cluster, it can be used to perform a `_reindex` API call that restores the backed up data into an existing `liferay-20116` index.

```bash
POST _reindex/
{
    "dest": {
      "index": "liferay-20116"
    },
    "source": {
      "index": "restored_liferay-201116"
    }
}
```

As with canceling a snapshot process, you can use the `DELETE` command to cancel an errant restore process:

```bash
DELETE /restored_liferay-20116index_3
```

Nobody likes catastrophic failure on a production system, but Elasticsearch's API for taking snapshots and restoring indexes can help you rest easy knowing that your search cluster can be restored if disaster strikes. For more details and options, read Elastic's [Snapshot and Restore documentation](https://www.elastic.co/guide/en/elasticsearch/reference/7.x/snapshot-restore.html).

## Backing Up and Restoring Indexes Used for Primary Storage

Creating a snapshot of your Elasticsearch indexes is highly recommended, especially for indexes that act as the primary storage format: for example, [Synonym Sets](../../../search-administration-and-tuning/synonym-sets.md) and [Result Rankings](../../../search-administration-and-tuning/result-rankings.md). There are no records for these applications in the database.

You can use Elasticsearch's [snapshot and restore](https://www.elastic.co/guide/en/elasticsearch/reference/7.x/snapshot-restore.html) feature to back up and restore the Search Tuning indexes.

1. Create a folder called `elasticsearch_local_backup` somewhere in the system. Make sure Elasticsearch has read and write access to the folder (e.g., `/path/to/elasticsearch_local_backup`).

1. Add 

    ```yaml
    path.repo: [ "/path/to/elasticsearch_local_backup" ]
    ```

   to the `elasticsearch.yml` for [all master and data nodes](https://www.elastic.co/guide/en/elasticsearch/reference/7.x/snapshots-register-repository.html#snapshots-filesystem-repository) in the Elasticsearch cluster. If you're upgrading Elasticsearch, make sure the path to the snapshot repository is the same in the pre-upgrade and post-upgrade Elasticsearch configurations.

1. Restart all Elasticsearch nodes.

1. [Register the snapshot repository](https://www.elastic.co/guide/en/elasticsearch/reference/7.x/snapshots-register-repository.html). You can run the following `snapshot` API request (for example through the Dev Tools console in Kibana):

    ```json
    PUT /_snapshot/elasticsearch_local_backup
    {
      "type": "fs",
      "settings": {
        "location": "/path/to/elasticsearch_local_backup"
      }
    }

    ```

   If you're upgrading to a new Elasticsearch version, you can use this same command on the post-upgrade Elasticsearch to register the snapshot repository.

1. [Create a snapshot](https://www.elastic.co/guide/en/elasticsearch/reference/7.x/snapshots-take-snapshot.html):

    ```json
    PUT /_snapshot/elasticsearch_local_backup/snapshot1?wait_for_completion=true
    {
      "indices": "liferay-20101-search-tuning*",
      "ignore_unavailable": true,
      "include_global_state": false
    }
    ```

   If you want to create a snapshot for all Liferay indexes, you can use `"indices": "liferay*,workflow-metrics*"` instead. If you're in an upgrade scenario, it can make sense to take a snapshot of just the indexes that can't be recreated from the database, like the Synonym Sets and Result Rankings indexes.

1. To [restore](https://www.elastic.co/guide/en/elasticsearch/reference/7.x/snapshots-restore-snapshot.html) specific indexes from a snapshot using a different name, run a `restore` API call similar to this:

    ```json
    POST /_snapshot/elasticsearch_local_backup/snapshot1/_restore
    {
      "indices": "liferay-20101-search-tuning-synonyms,liferay-20101-search-tuning-rankings",
      "ignore_unavailable": true,
      "include_global_state": false,
      "rename_pattern": "(.+)",
      "rename_replacement": "restored_$1",
      "include_aliases": false
    }
    ```

   where `indices` sets the snapshotted index names to restore from. The indexes from the above call would be restored as `restored_liferay-20101-search-tuning-rankings` and `restored_liferay-20101-search-tuning-synonyms`, following the `rename_pattern` and `rename_replacement` regular expressions.

If you've added Synonym Sets or Results Rankings while running in Sidecar/Embedded mode, you'll see these search tunings disappear once you configure a Remote mode connection to Elasticsearch 7 and perform a full re-index.

To restore your existing _Search Tuning_ index documents, you can use the [Reindex API](https://www.elastic.co/guide/en/elasticsearch/reference/current/docs-reindex.html#docs-reindex) of Elasticsearch, like this:

```json
POST _reindex/
{
 "dest": {
   "index": "liferay-20101-search-tuning-synonyms"
 },
 "source": {
   "index": "restored_liferay-20101-search-tuning-synonyms"
 }
}
```

Run the same command for the `liferay-20101-search-tuning-rankings` index. If you run both requests in a post-upgrade Elasticsearch installation, the Synonym Sets and Result Rankings data from the pre-upgrade system are now restored.

### Search Tuning Index Names

The out-of-the-box Search Tuning index names depend on your Liferay version and patch level:

| Liferay Version and Patch | Search Tuning Indexes |
| ------------------------- | --------------------- |
| Liferay DXP 7.2 SP2/FP5 and below| `liferay-search-tuning-rankings`<br />`liferay-search-tuning-synonyms-liferay-<companyId>` |
| Liferay DXP 7.2 SP3/FP8 and above | `liferay-<companyId>-search-tuning-rankings`<br />`liferay-<companyId>-search-tuning-synonyms` |
| Liferay DXP 7.3, all patches  | `liferay-<companyId>-search-tuning-rankings`<br />`liferay-<companyId>-search-tuning-synonyms` |

The `<companyId>` (e.g., `20101`) belongs to a given `Company` record in the database. It is displayed as _Instance ID_ in the UI and represents a [Virtual Instance](../../../../system-administration/configuring-liferay/virtual-instances/understanding-virtual-instances.md).

## What's Next

If you are [upgrading Elasticsearch](./upgrading-to-elasticsearch-7.md), you can do that now. 

## Additional Information

[Search Administration and Tuning](../../../search_administration_and_tuning.md)
