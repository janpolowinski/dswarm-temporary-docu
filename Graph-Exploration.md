The central [[data hub|Glossary#data-hub]] of d:swarm is powered by the graph database [[Neo4j|http://neo4j.com]]. The web-based Neo4j Graph Browser lets you explore the contents of the data hub. The web application can be accessed at this URL http://sdvdswarm01.slub-dresden.de/neo/.

## The Neo4j Graph Browser

### Overview

These are the basic functions directly accessible from the starting page:

([[enlarge figure|img/neo4j-overview.png]])
[[img/neo4j-overview.png]]

* (1) shows an overview or the [[node|Glossary#node]] labels, [[edges|Glossary#relationship]] (relationship types), [[attributes|Glossary#attribute]] (property keys) that can be used as entry points into the graph.
* (2) lets you manipulate the graph; contains sample queries and shows details of the graph configuration.
* (3) lets you browse Neo4j’s documentation, help, tutorials etc.
* (4) input field for [[Cypher queries|http://en.wikipedia.org/wiki/Cypher_Query_Language]]. There is also an [[overview and short introduction to Cypher|http://docs.neo4j.org/refcard/2.0/]].


### Graph Exploration

([[enlarge figure|img/graph-exploration.png]])
[[img/graph-exploration.png]]

* (1) an overview of all node labels (i.e. resource types, cf. [[graph data model|Glossary#graph-data-model]]) in the graph.
  * __Note:__ Node labels cannot be deleted from the graph database, i.e. node labels of deleted nodes will still show up in this overview.
* (2) an overview of all relationship types (i.e. attributes or predicates) in the graph.
  * __Note:__ Relationship types cannot be deleted from the graph database, i.e. relationship types of deleted edges (relationships) will still show up in this overview.
* (3) an overview of all property keys (attributes of nodes and edges) in the graph.
* (4) a currently selected node label (http://data.slub-dresden.de/resources/1/schema#RecordType). Selecting a node label sends a Cypher query. The result is presented visually or in a grid.
* (5) sample Cypher query for retrieving a node with the node label ‘http://data.slub-dresden.de/resources/1/schema#RecordType‘ limited to 25 results maximum:
    
    ``MATCH (n:`http://data.slub-dresden.de/resources/1/schema#RecordType`) RETURN n LIMIT 25``
* (6) the visual representation of the results showing nodes and their identifiers (e.g. http://data.slub-dresden.de/datamodels/2/records/788e0248-f417-4e72-a6ed-e8cf0baa4546)
  * __Note:__  Double clicking a node will show all in-coming and out-going edges (and their starting or ending nodes) of the node.


#### Example

This is an example of a record imported from a CSV file an its mapping. It can be retrieved with this query:

    MATCH (n)-[r]->(m) WHERE n.__URI__ = "http://data.slub-dresden.de/datamodels/2/records/788e0248-f417-4e72-a6ed-e8cf0baa4546" RETURN n, r, m;

([[enlarge figure|img/graph-example.png]])
[[img/graph-example.png]]

* (1) the record selected in the input data model (resource node) http://data.slub-dresden.de/datamodels/2/records/788e0248-f417-4e72-a6ed-e8cf0baa4546
* (2)The detail view of the selected resource node with the following node attributes:
  * \_\_URI\_\_ = http://data.slub-dresden.de/datamodels/2/records/788e0248-f417-4e72-a6ed-e8cf0baa4546
  * \_\_PROVENANCE\_\_ = http://data.slub-dresden.de/datamodel/2/data
  * \_\_NODETYPE\_\_ = \_\_RESOURCE\_\_
  * the node label (as resource type): http://data.slub-dresden.de/resources/1/schema#RecordType
* (3) the correlating resource type node
  * __Note:__ Double clicking a resource type node will show all resource nodes that are categorized with this type.
* (4) visualization of a statement (node – edge – node)
  * This example shows the resource node of the record http://data.slub-dresden.de/datamodels/2/records/788e0248-f417-4e72-a6ed-e8cf0baa4546 in the output data model with the attribute  http://data.slub-dresden.de/resources/1/schema#description and the value (literal) “muh muh”. 

__Note:__ If a relationship (edge) is selected, the detail view shows all property keys of the relationship (edge attributes and edge type, i.e. attribute or predicate of the statement).


### Useful Cypher Queries

This overview can provide only a brief glance at Cypher queries. There are more d:swarm related queries in the [[Cypher Cheat Sheet]]. For a detailed explanation of the capabilities of Cypher, please refer to [[Cypher Reference Card|http://docs.neo4j.org/refcard/2.0/]].

* Retrival (recursive) of all statements that belong to record of the record type ‘http://www.openarchives.org/OAI/2.0/recordType‘, i.e. “show me all (hierarchically structured) records of this resource type in the graph”:

    ``MATCH (n:`http://www.openarchives.org/OAI/2.0/recordType`)-[r*]->(m) RETURN n, r, m;``

* Retrieval of all statements with the following attributes: ‘http://data.slub-dresden.de/resources/1/schema#description‘

    ``MATCH (n)-[r:`http://data.slub-dresden.de/resources/1/schema#description`]->(m) RETURN n, r, m;``

* Retrieval of all resource types used in the graph, i.e. “show me all resource type nodes of the resource type rdfs:Class” :

    ``MATCH (n:`http://www.w3.org/2000/01/rdf-schema#Class`) RETURN n;``

__Note:__ In the graph exploration tab, all resource types in the graph will be shown. A possible difference of this Cyber query is the fact that it will show all resource types currently existent in the graph, while the exploration tab lists also those types that used to be existent but have been deleted.


### Use of Indices

Apart from the built-in indices for node labels and relationship types you should use further indices (which, at this stage, are implemented as [[Neo4j legacy indices|http://docs.neo4j.org/chunked/milestone/indexing.html]] that differ from the [[schema indices|http://docs.neo4j.org/chunked/milestone/query-schema-index.html]]) in order to achieve fast runtimes for your queries.

* Retrieval of all statements connected with nodes with the node identifier ‘http://data.slub-dresden.de/datamodels/2/records/788e0248-f417-4e72-a6ed-e8cf0baa4546‘, i.e. statements whose subject has this identifier:

    ``START n=node:resources(__URI__="http://data.slub-dresden.de/datamodels/2/records/788e0248-f417-4e72-a6ed-e8cf0baa4546") MATCH (n)-[r]->(m) RETURN n, r, m;``


#### Available Indices

At this stage, there are only node indices. You can, however, create edge indices. Node indices always have the prefix ‘node’. The following indices are currently provided:

* **resources**: contains all resource identifiers
  * Index attribute: \_\_URI\_\_
* **resources_w_provenance**: contains all resource identifiers + provenance identifiers , e.g. ‘http://data.slub-dresden.de/datamodels/2/records/788e0248-f417-4e72-a6ed-e8cf0baa4546 http://data.slub-dresden.de/datamodel/2/data‘ where the resource identifier is separated from the provenance identifier by a space within the key.
  * Index attribute: \_\_URI_W_PROVENANCE\_\_
  * **Note**: this index is useful for efficient access to resources of a certain provenance.
* **values**: contains all values of literals
  * Index attribute: \_\_VALUE\_\_

**Note**: Index attributes have no direct relation to node attributes or edge attributes, even if they have the same label.