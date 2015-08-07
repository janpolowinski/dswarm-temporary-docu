At [SLUB Dresden](http://www.slub-dresden.de), the *Streaming version* of d:swarm is used for normalising data retrieved from various sources before feeding it to a [Solr](http://lucene.apache.org/solr/) server. Clients such as the new [SLUB Katalog (beta)](http://katalogbeta.slub-dresden.de/) can then request data from Solr and present it to library users.

[[img/use-case-slub.png]]

## Data Sources and Formats

The following data sources are currently processed with d:swarm at SLUB Dresden:

* [deutsche FOTOTHEK](http://www.deutschefotothek.de)
  * OAI-PMH-XML (containing elements from the [DC-Elements](http://purl.org/dc/elements/1.1/) and [Europeana](http://europeana.eu/terms) namespace)
* DEG, EBL, WILEY (Electronic Resources)
  * [OAI-PMH-MARCXML](http://www.loc.gov/standards/marcxml/)
* [Gemeinsamer Bibliotheksverbund](http://www.gbv.de/) (GBV)
  * MARCXML (currently wrapped as OAI-PMH-MARCXML as well, to avoid too many different source data formats)

The target schema we map to, is a schema describing the format that [Finc](https://finc.info/de/) is using for feeding the Solr index. To be able to merge the data with other sources provided via Finc, we export the data as XML compliant to this schema. Below, you find an example of a source format (OAI-PMH + DC-elements and Europeana) on the left and the export format (Finc Solr schema compliant XML) on the right hand side.

[[img/example-use-case-fotothek-comparison-source-target-data.png]]

## The Mapping Process ##

For each source, we defined one or multiple mapping projects, all mapping to the same target schema (the Finc Solr schema). 
In case a source requires specific mappings, we set up a dedicated project for this source and combined the mappings during the task execution. For example, for processing the GBV data, we use the general OAI-PMH-MARCXML mappings and those from an extra project "GBV extra", which serves for setting GBV-specific constants.  A preview of the transformation defined by our mapping project for data from the "deutsche FOTOTHEK" is shown below.

[[img/screenshot-fotothek-mapping-project.png]]

## Transforming Data with the D:SWARM Task Processing Unit
We use the Task Processing Unit for d:swarm (TPU) to batch process all data, separated by the data source. For each source, a TPU configuration has been written, which states where the source data folder is located, what mapping projects to employ, which processing mode to use and, finally, where to store the exported data.

We used the following configuration of the TPU (here an example for "deutsche FOTOTHEK"), which results in a streaming behavior, not persisting the transformed data, but directly exporting it as XML (some properties not shown for clarity, use this [full example](https://github.com/dswarm/task-processing-unit-for-dswarm) as a template):

```
service.name=fotothek-on-the-fly
resource.watchfolder=/data/source-data/productive/fotothek
configuration.name=/home/dmp/config/xml-configuration.json
prototype.projectID=a6c53e2f-6b59-87b7-ca78-08f96cb6c6a7
prototype.outputDataModelID=5fddf2c5-916b-49dc-a07d-af04020c17f7
...
init.multiple_data_models=true
transform.do=true
task.do_ingest_on_the_fly=true
results.persistInDMP=false
task.do_export_on_the_fly=true
...
results.folder=/data/target-data/productive/fotothek
engine.threads=8
engine.dswarm.api=http://localhost/dmp/
...
```

## Statistics ##

Processing all data sources takes XX seconds for XX records (containing XX statements at total) on a 8-cores, 64 GB RAM Linux (Ubuntu 12.04, 64-Bit) machine using 32GB RAM for the TPU and 24GB RAM for the d:swarm backend.
Further hardware facts: 
* HD with SSD cache (but no SSD disk), 500GB, extra partition for all data and logs
* up to 4,5 GHz used
* up to 70% of the total RAM used

<!-- screenshot metrics view evtl. --> 