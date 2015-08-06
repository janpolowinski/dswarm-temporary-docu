At [SLUB Dresden](http://www.slub-dresden.de), the *Streaming version* of d:swarm is used for normalising data retrieved from various sources before feeding it to a Solr server.

# The following data sources are currently processed:

* [deutsche FOTOTHEK](http://www.deutschefotothek.de)
  * XML (containing DC and Europeana elements)
* DEG, EBL, WILEY (Electronische Resourcen)
  * OAI-PMH-MARC-XML - here we were able to use a content schema provided by d:swarm, which simplifies the handling of this format
* [Gemeinsamer Bibliotheksverbund](http://www.gbv.de/)(GBV)
  * MARC-XML (currently wrapped as OAI-PMH-MARC-XML as well, to avoid too many different source data formats)

In case a source requires specific mappings, we set up a dedicated project per source and combine the mappings during the task execution. For example, for processing the GBV data, we use the general OAI-PMH-MARC-XML mappings and those from an extra project "GBV extra", which serves for setting GBV-specific constants.

The target schema we map to is a schema describing the format [Finc](https://finc.info/de/) is using for feeding the Solr index. To be able to merge the data with other sources provided via Finc, we export the data as XML compliant to this schema and import it to Solr using Shell scripts.

# Statistics
Processing all data sources takes XX seconds for XX records (containing XX statements at total) on a 8-cores ... machine using XX GB RAM for the Task processing unit and ... GB RAM for the d:swarm backend.
... Further hardware facts ...

<!-- screenshot quell-daten ? --> 

<!-- screenshot komplexe transformation --> 

<!-- screenshot export solr xml --> 

<!-- screenshot solr import results --> 

<!-- screenshot metrics view evtl. --> 