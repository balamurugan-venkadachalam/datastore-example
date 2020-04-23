## Set GOOGLE_APPLICATION_CREDENTIALS=
There a few ways to "activate" application default credentials:

Use your user account
``` 
Run gcloud auth application-default login
```
- [x] Use service account (preferred), create service account assign required privilege 
and download key file.

set environment variable 
```
GOOGLE_APPLICATION_CREDENTIALS=path/to/your/service_accont_key_file.json
copy path/to/your/service_accont_key_file.json to ~/.config/gcloud/application_default_credentials.json`
```
now below command should work. 
```
gcloud auth application-default print-access-token
```


## Installing the emulator
The Datastore emulator is a component of the Google Cloud SDK's gcloud tool. Use the gcloud components install command to install the Datastore emulator:
```
gcloud components install cloud-datastore-emulator
```
Starting the emulator
Start the emulator by executing datastore start from a command prompt:
```
gcloud beta emulators datastore start [flags]
```
### Automatically setting the variables

Run env-init using command substitution:
```
$(gcloud beta emulators datastore env-init)
```

### Datastore Emulator viewer

https://www.npmjs.com/package/google-cloud-gui


### Reference 


- [x] https://github.com/googleapis/google-cloud-java/blob/master/google-cloud-examples/src/main/java/com/google/cloud/examples/datastore/DatastoreExample.java
- [x] https://github.com/GoogleCloudPlatform/java-docs-samples/blob/2e5996c68440134a79f1511c57529fa5cf987628/appengine-java8/datastore/src/test/java/com/example/appengine/EntitiesTest.java
- [x] https://cloud.google.com/datastore/docs/concepts/indexes
- [x] https://cloud.google.com/datastore/docs/tools/indexconfig
- [x] https://cloud.google.com/appengine/docs/standard/java/datastore/creating-entities
- [x] https://cloud.google.com/datastore/docs/concepts/queries#datastore-datastore-basic-query-gql
- [x] https://cloud.google.com/datastore/docs/reference/gql_reference#how_to_form_literals
- [x] https://cloud.google.com/datastore/docs/concepts/limits
- [x] https://stackoverflow.com/questions/37602604/is-google-cloud-datastore-a-column-oriented-nosql-database



## BigTable

This is a necessary base for Datastore. Maps row key, column key and timestamp (three-dimensional mapping) to an array of bytes. Data is stored in lexicographic order by row key.

High scalability and availability
Strong consistency for single row
Eventual consistency for multi-row level
Megastore

This layer adds transactions on top of the BigTable.

## Datastore

A layer above Megastore. Enables to run queries as index scans on BigTable. Here index is not used for performance improvement but is required for queries to return results.

Furthermore, it optionally adds strong consistency for multi-row level via ancestor queries. Such queries force the respective indexes to update before executing actual scan.

- [x] Cloud Datastore does not include support for join operations, inequality filtering on multiple properties, or filtering on data based on results of a subquery. 

- [x] Cloud Datastore doesn't require entities of the same kind to have a consistent property set

## Index
```
gcloud datastore indexes create index.yaml
gcloud datastore indexes cleanup index.yaml
```
## Import and Export
```
gcloud datastore export gs://bucket-name --async
gcloud datastore export --kinds="KIND1,KIND2" --namespaces="(default),NAMESPACE2" gs://bucket-name --async

```
## Useful cmds

```
gcloud datastore operations COMMAND [GCLOUD_WIDE_FLAG …]
```

