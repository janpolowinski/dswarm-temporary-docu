The [d:swarm](https://github.com/dswarm) organization at GitHub currently consists of a bunch of repositories that make the d:swarm application or that are utilised by it. Here is a brief overview about all project repositories that belong to the d:swarm application:

1. All [[front end]] code of the d:swarm Backoffice web application is currently hosted in the [dswarm-backoffice-web](https://github.com/dswarm/dswarm-backoffice-web) repository
2. The [[back end]] code that provides the HTTP API and orchestrates the communication with persistence layer etc. is currently hosted in the [dswarm](https://github.com/dswarm/dswarm) repository
3. The d:swarm Neo4j unmanaged extension that operates at server side of the Neo4j graph database (that acts as [[data hub|Glossary#data-hub]]) is currently hosted in the [dswarm-graph-neo4j](https://github.com/dswarm/dswarm-graph-neo4j) repository
4. The [[Graph Data Model]] (Java) object structure and (JSON) de-/serialization is currently hosted in the [dswarm-gdm-java](https://github.com/dswarm/dswarm-gdm-java) repository (so that the GDM can be utilised as exchange format and utilise on both sides, i.e., the back end and the d:swarm Neo4j unmanaged extension)
5. The Graph Data Model (GDM) identifiers are currently hosted in the [dswarm-gdm](https://github.com/dswarm/dswarm-gdm) repository (to allow further graph database implementations of our GDM)
6. We established a d:swarm commons library that is currently hosted in the [dswarm-commons](https://github.com/dswarm/dswarm-commons) repository to collect common procedures that can be utilises in all parts of the d:swarm application
7. The XSD 2 JSON Schema parser that is utilised in the [[converter]] of the d:swarm application is currently hosted in the [dswarm-xsd2jsonschema](https://github.com/dswarm/dswarm-xsd2jsonschema) repository

The following repositories are forks from existing tools and frameworks that are utilised in the d:swarm application:

1. [Metafacture](https://github.com/dswarm/metafacture-core) (utilised in the [[converter]])
2. [Siphash (Java implementation)](https://github.com/dswarm/siphash-java) (utilised in the d:swarm Neo4j unmanaged extension)
3. [xsom](https://github.com/dswarm/xsom) (utilised in the XSD 2 JSON Schema parser)