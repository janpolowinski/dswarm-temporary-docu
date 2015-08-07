At [SLUB Dresden](http://www.slub-dresden.de), the *Streaming version* of d:swarm is used for normalising data retrieved from various sources before feeding it to a [Solr](http://lucene.apache.org/solr/) server.

The following data sources are currently processed:

* [deutsche FOTOTHEK](http://www.deutschefotothek.de)
  * OAI-PMH-XML (containing elements from the [DC-Elements](http://purl.org/dc/elements/1.1/) and [Europeana](http://europeana.eu/terms) namespace)
* DEG, EBL, WILEY (Electronic Resources)
  * [OAI-PMH-MARCXML](http://www.loc.gov/standards/marcxml/) - here we were able to use a content schema provided by d:swarm, which simplifies the handling of this format
* [Gemeinsamer Bibliotheksverbund](http://www.gbv.de/) (GBV)
  * MARCXML (currently wrapped as OAI-PMH-MARCXML as well, to avoid too many different source data formats)

[[img/use-case-slub.png]]

In case a source requires specific mappings, we set up a dedicated project per source and combine the mappings during the task execution. For example, for processing the GBV data, we use the general OAI-PMH-MARCXML mappings and those from an extra project "GBV extra", which serves for setting GBV-specific constants.

The target schema we map to is a schema describing the format [Finc](https://finc.info/de/) is using for feeding the Solr index. To be able to merge the data with other sources provided via Finc, we export the data as XML compliant to this schema and import it to Solr using Shell scripts.

Below you find an example of the source format (OAI-PMH + DC-elements and Europeana; on the left) and export (Finc Solr schema compliant XML; on the right) format.

[[img/example-use-case-fotothek-comparison-source-target-data.png]]

## Statistics ##
Processing all data sources takes XX seconds for XX records (containing XX statements at total) on a 8-cores, 64 GB RAM Linux (Ubuntu 12.04, 64-Bit) machine using 32GB RAM for the Task processing unit and 24GB RAM for the d:swarm backend.
Further hardware facts: 
* HD with SSD cache (but no SSD disk), 500GB, extra partition for all data and logs
* up to 4,5 GHz used
* up to 70% of the total RAM used

<!-- screenshot metrics view evtl. --> 