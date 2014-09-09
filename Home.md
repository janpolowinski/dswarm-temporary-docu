# d:swarm documentation
____

## Introduction
d:swarm is a **data integration and data modelling tool** that is based on the concept of [community sharing](http://en.wikipedia.org/wiki/Sharing). It is used for the lossless transformation of data from heterogeneous sources into a flexible ([elastic](http://en.wikipedia.org/wiki/Elasticity_%28data_store%29)), graph-based data model that can be explicitly embedded in the (Linked) Open Data webgraph.

d:swarm is a **middle ware solution**. It forms the basis of all data management processes in a library or any other cultural institution dedicated to the handling of data and metadata.  Structurally, d:swarm goes in between **existing data management systems** (e.g. Integrated Library Systems) and **existing front end applications** (e.g. the library catalogue or discovery system).

d:swarm takes care of the **improvement** of the data quality facilitating the deduplication, merging and [FRBRization](http://en.wikipedia.org/wiki/Functional_Requirements_for_Bibliographic_Records) of bibliographic data, their semantic enrichment and publication as [LOD](http://en.wikipedia.org/wiki/Linked_data).

d:swarm channels all **institutional data flows** and creates a highly customized master record for every individual resource as a [Single Version of the Truth](http://en.wikipedia.org/wiki/Single_version_of_the_truth) (SVOT).

d:swarm is a web application that runs in all modern web browsers. An **alpha release** of our web application is available at [http://sdvdswarm01.slub-dresden.de](http://sdvdswarm01.slub-dresden.de). If you want to participate in the alpha tests, [drop us a note](http://dmp.slub-dresden.de/en/interesse/), and we will gladly add you to the group of testers. We are looking forward to your feedback, your ideas, your opinion and your contribution.


## Documentation

There are two documentation types: an **end user documentation** on how to use the web application and a **technical documentation** for software developers. As a base, the [d:swarm Prezi](http://prezi.com/0zh_ypsezu6i/) summarizes the motivation and goals on an abstract level.

### End User Documentation

The end user documentation contains a step-by-step tutorial on how to use our web application. Start with the [general overview](http://dmp.slub-dresden.de/en/) and carry on reading the [alpha release help](http://dmp.slub-dresden.de/en/datenmanagement/dswarm-hilfe/). You will learn the basic workflow depicted below, i.e., how to setup and configure data resources; create projects to define mappings, transformations and filters; explore the graph data model; and export data in [RDF](http://en.wikipedia.org/wiki/Resource_Description_Framework).

<!--- update image at https://intranet.slub-dresden.de/display/DAT/Technical+documentation+d%3Aswarm -->
[[img/simplified_linear_dmp_steps.png]]

### Technical documentation

As shown below, the overall architecture consists of two major parts: the Backoffice [[front end]] and the [[back end]]. The back end consists of 4 modules: a [[controller]] module that controls the program flow and provides a REST API, a [[converter]] that encapsulates [Metafacture](https://github.com/culturegraph/metafacture-core) to transform data and a [[persistence]] layer to access a MySQL database and a graph database ([Neo4j](http://www.neo4j.org)). 
There is an additional [[initialization|init]] module that is not shown in the figure.
The MySQL database is used as a metadata repository to store our [[domain model]], data is stored in the graph database. Our unmanaged extension *dmp-graph* extends the REST API of Neo4j and is accessed by the persistence module. End users, e.g., system librarians, usually interact with the Backoffice frontend and may use the Neo4j browser to inspect or visualize the data stored by d:swarm.

<!--- update image at https://intranet.slub-dresden.de/display/DAT/Architecture+d%3Aswarm -->
[[enlarge figure|img/dswarm-architecture.png]]
[[img/dswarm-architecture.png]]


## Requirements
anything that is needed to run the software. anything that is preventing the software from running.


## Installation and Configuration

It might be a good idea to run the [[front end ]] and [[back end]] locally to get full insight into, e.g., how data resources that are uploaded and configured via the front end are stored in the databases.
Installation instructions can be found in the [[Server Install]] guide,  [[d:swarm Configuration|dswarm Configuration]] provides details on how to configure the system.

## Running the System

Once installed, the local front end runs at *http://localhost:9999*, the local Neo4j browser may be accessed at *http://localhost:7474/browser/*. Hint: see [[Cypher Cheat Sheet]] for details on Neo4j. You may also want to have a look at the [[MySQL Cheat Sheet]] with our database schema and use a tool of your choice to explore the db.


## Contributing

You like to contribute? Awesome!

[[Code Repository Handling]]

coding guidelines, issue tracker

## License