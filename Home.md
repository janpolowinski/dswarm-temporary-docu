## Introduction
[d:swarm](http://dswarm.org) is a **data management platform** that is based on the concept of [community sharing](http://en.wikipedia.org/wiki/Sharing). It is used for the lossless transformation of data from heterogeneous sources into a flexible ([elastic](http://en.wikipedia.org/wiki/Elasticity_%28data_store%29)), data model that can be explicitly made available as [(Linked) Open Data](http://en.wikipedia.org/wiki/Linked_data) (LOD).

d:swarm is a **middle ware solution**. It forms the basis of all data management processes in a library or any other (cultural) institution dedicated to the handling of data and metadata.  Structurally, d:swarm goes in between **existing data management systems** (e.g. Integrated Library Systems) and **existing front end applications** (e.g. the library catalogue or discovery system).

d:swarm (mainly) takes care of the **improvement** of the data quality facilitating the de-duplication, merging and [FRBRization](http://en.wikipedia.org/wiki/Functional_Requirements_for_Bibliographic_Records) of bibliographic data, their semantic enrichment and publication as LOD.

d:swarm channels all **institutional data flows** and is able to create a highly customized master record for every individual resource as a [Single Version of the Truth](http://en.wikipedia.org/wiki/Single_version_of_the_truth) (SVOT).

d:swarm is a web application that runs in all modern web browsers. The current release of our web application is available at [http://demo.dswarm.org](http://demo.dswarm.org). If you want to participate in the tests, [drop us a note](mailto:team@dswarm.org), and we will gladly add you to the group of testers. We are looking forward to your feedback, your ideas, your opinion and your contribution at our [mailing list](https://groups.google.com/forum/#!forum/dswarm) or [issue tracker](https://jira.slub-dresden.de).

## What can you do with d:swarm?

As a base, [this](http://prezi.com/0zh_ypsezu6i/) and [this](http://www.slideshare.net/JensMittelbach/dswarm-a-library-data-management-platform-based-on-a-linked-open-data-approach) presentations summarize the motivation and goals on an abstract level. Furthermore, our [user guide](https://github.com/dswarm/dswarm-documentation/wiki/Overview) provides a brief manual of how to utilise the [d:swarm Backoffice web application](http://demo.dswarm.org).

### d:swarm is an ETL tool

With the d:swarm ETL tool you can basically complete the following workflow: 
 * how to setup and configure [[data resources|Glossary#data-resource]]
 * create [[projects|Glossary#project]], to define [[mappings|Glossary#mapping]], [[transformations|Glossary#transformation]] and [[filters|Glossary#filter]]
 * explore the [[graph data model|Glossary#graph-data-model]]
 * and export data in [RDF](http://en.wikipedia.org/wiki/Resource_Description_Framework) or XML (e.g. for feeding [Solr](http://lucene.apache.org/solr/) indices).

<!--- source code for image currently stored by jan -->
[[https://raw.githubusercontent.com/wiki/dswarm/dswarm-documentation/img/dswarm_workflow_abstract.png]]

### ... and behind the scenes

As shown below, the overall architecture consists of two major parts: the Backoffice [[front end]] and the [[back end]]. The back end consists of 4 modules: 
 * a [[controller]] module that controls the program flow and provides a HTTP API
 * a [[converter]] that encapsulates [Metafacture](https://github.com/culturegraph/metafacture-core) to transform data
 * and a [[persistence]] layer to access the [[metadata repository|Glossary#metadata-repository]] (currently a relational database; MySQL) and the [[data hub|Glossary#data-hub]] (currently a graph database; [Neo4j](http://www.neo4j.org)).
 
End users, e.g., system librarians, usually interact with the [Backoffice we application](http://demo.dswarm.org) and may use the [[data hub browser|Graph-Exploration]] to inspect or visualize the data stored by d:swarm.

[![an image of the architecture overview](https://raw.githubusercontent.com/wiki/dswarm/dswarm-documentation/img/architecture.png)](https://raw.githubusercontent.com/wiki/dswarm/dswarm-documentation/img/architecture.png "Architecture Overview")

The HTTP API provides a documentation via [[Swagger|http://swagger.io/]] and hence can be explored via the [[Swagger UI|HTTP API Discovery]]. This is a very convenient way to explore the back end's functionality. 

## How to get started?

Just go to [http://demo.dswarm.org](http://demo.dswarm.org) and try it out or setup your own local installation and run it from there.

### Installation and Configuration

It might be a good idea to run d:swarm locally to get full insight into the processes of our application.
Installation instructions can be found in the [[Server Install]] or [[Developer Install]] guide, [[d:swarm Configuration|dswarm Configuration]] provides details on how to configure the system.

### Running the System

Once installed, the local front end (usually) runs at `http://localhost:9999` and the local data hub browser may be accessed at `http://localhost:7474/browser/`. Hint: see [[Cypher Cheat Sheet]] for details on Neo4j. You may also want to have a look at the [[MySQL Cheat Sheet]] for our metadata repository schema (see also our [[domain model|Domain Model]]) and use a tool of your choice to explore the database.

## Contributing

You like to contribute? Awesome!

* [[Code Repository Structure]]
* [[Code Repository Handling]]
* [Issue Tracker](https://jira.slub-dresden.de) (register [here](https://jira.slub-dresden.de/secure/ContactAdministrators!default.jspa))
* [Mailing List](https://groups.google.com/forum/#!forum/dswarm)
* [@dswarm at Twitter](https://twitter.com/dswarm)
* [D:SWARM at Google+](https://plus.google.com/u/0/b/113858333420496787463/113858333420496787463/posts)
* [team contact](mailto:team@dswarm.org)

## License

All code from the repositories that belong to our project (see [[here|Code Repository Structure]]) is published under [APL2](http://www.apache.org/licenses/LICENSE-2.0) license (except of the [d:swarm Neo4j unmanaged extension](https://github.com/dswarm/dswarm-graph-neo4j), which is published under [GPL3](http://www.gnu.org/copyleft/gpl.html) license).