The central [[data hub|Glossary#data-hub]] of d:swarm is powered by the graph database [[Neo4j|http://neo4j.com]]. The web-based Neo4j Graph Browser offers the exploration of the content of the data hub. The web application can be accessed at http://sdvdswarm01.slub-dresden.de/neo/.

## The Neo4j Graph Browser

### Overview

These are the basic functions directly accessible from the starting page:

[![an image of the Neo4j browser](https://avgl.mybalsamiq.com/mockups/1798342.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00)](https://avgl.mybalsamiq.com/mockups/1798342.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00 "Neo4j Browser")

* (1) shows an overview of the [[node|Glossary#node]] labels ([[classes|Glossary#class]]), [[edge|Glossary#relationship]] types (relationship types), [[attributes|Glossary#attribute]] (property keys) that can be used as entry points into the graph.
* (2) lets you manipulate the graph; contains sample queries and shows details of the graph configuration.
* (3) lets you browse Neo4j’s documentation, help, tutorials etc.
* (4) input field for [[Cypher queries|http://en.wikipedia.org/wiki/Cypher_Query_Language]]. There is also an [[overview and short introduction to Cypher|http://docs.neo4j.org/refcard/2.0/]].


### Graph Exploration

[![an image of a graph exploration](https://avgl.mybalsamiq.com/mockups/1799060.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00)](https://avgl.mybalsamiq.com/mockups/1799060.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00 "Graph Exploration")

* (1) an overview of all node labels (i.e. resource types or classes, cf. [[graph data model|Glossary#graph-data-model]]) in the graph.
  * __Note:__ Node labels cannot be deleted from the graph database, i.e. node labels of deleted nodes will still show up in this overview.
* (2) an overview of all relationship types (i.e. attributes or predicates) in the graph.
  * __Note:__ Relationship types cannot be deleted from the graph database, i.e. relationship types of deleted edges (relationships) will still show up in this overview.
* (3) an overview of all property keys (attributes of nodes and edges) in the graph.
* (4) a currently selected node label (`http://data.slub-dresden.de/resources/1/schema#RecordType`). Selecting a node label sends a Cypher query. The result is presented visually or in a grid.
* (5) sample Cypher query for retrieving a node with the node label `http://data.slub-dresden.de/resources/1/schema#RecordType` limited to 25 results maximum:
    
    ``MATCH (n:`http://data.slub-dresden.de/resources/1/schema#RecordType`) RETURN n LIMIT 25``
* (6) the visual representation of the results showing nodes and their identifiers (e.g. `http://data.slub-dresden.de/datamodels/2/records/788e0248-f417-4e72-a6ed-e8cf0baa4546`)
  * __Note:__  Double clicking a node will show all in-coming and out-going edges (and their starting or ending nodes) of the node.


#### Example

This is an example of a [[record|Glossary#record]] imported from a CSV file and its mapping result (in the output data model). It can be retrieved with this query:

    MATCH (n)-[r]->(m) WHERE n.__URI__ = "http://data.slub-dresden.de/datamodels/8/records/716d7486-1fa7-41f6-a490-f210051f5ffa" RETURN n, r, m;

[![an image of an example graph](https://avgl.mybalsamiq.com/mockups/1802011.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00)](https://avgl.mybalsamiq.com/mockups/1802011.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00 "an example graph")

* (1) The record with the identifier `http://data.slub-dresden.de/datamodels/8/records/716d7486-1fa7-41f6-a490-f210051f5ffa` in the input [[data model|Glossary#data-model]]
* (2) The detail view of the selected [[statement|Glossary#statement]] with the property (relationship type) `http://data.slub-dresden.de/resources/2/schema#isbn` and the following relationship attributes:
  * \_\_DATA\_MODEL\_\_ = `http://data.slub-dresden.de/datamodel/8/data`
  * \_\_INDEX\_\_ = 5
  * \_\_UUID\_\_ = 92fa7ad5-7582-4da6-b1a0-4589cbc52664
  * \_\_VALID\_FROM\_\_ = 1
  * \_\_VALID_TO\_\_ = 2147483647
  * \_\_RESOURCE\_\_ = `http://data.slub-dresden.de/datamodels/8/records/716d7486-1fa7-41f6-a490-f210051f5ffa`
i.e. the statement with the uuid `92fa7ad5-7582-4da6-b1a0-4589cbc52664` of the data model with the identifier `http://data.slub-dresden.de/datamodel/8/data` belongs to the resource with the identifier `http://data.slub-dresden.de/datamodels/8/records/716d7486-1fa7-41f6-a490-f210051f5ffa` and is valid from the first version of the data model until now (2147483647 is the upper limit of the integer range)
* (3) A resource type (class) node for `http://purl.org/ontology/bibo/Document` of the record in the output data model
  * __Note:__ Double clicking a resource type node will show all resource nodes that are categorized with this type.
* (4) visualization of a statement (node – edge – node)
  * This example shows the resource node of the record `http://data.slub-dresden.de/datamodels/8/records/716d7486-1fa7-41f6-a490-f210051f5ffa` in the output data model with the attribute (relationship type) `http://data.slub-dresden.de/resources/2/schema#isbn` and the value ([[literal|Glossary#literal]]) “66633344455”. 

__Note:__ If a node is selected, the detail view shows all property keys of the node (node attributes and (optionally) label (if the node is a resource node)).


### Useful Cypher Queries

This overview can provide only a brief glance at Cypher queries. There are more d:swarm related queries in the [[Cypher Cheat Sheet]]. For a detailed explanation of the capabilities of Cypher, please refer to [[Cypher Reference Card|http://docs.neo4j.org/refcard/2.0/]].

* Retrieval (recursively) of all statements that belong to records of the record type `http://www.openarchives.org/OAI/2.0/recordType`, i.e. “show me all (hierarchically structured) records of this resource type in the graph”:

    ``MATCH (n:`http://www.openarchives.org/OAI/2.0/recordType`)-[r*]->(m) RETURN n, r, m;``

* Retrieval of all statements with the attribute `http://data.slub-dresden.de/resources/1/schema#description`

    ``MATCH (n)-[r:`http://data.slub-dresden.de/resources/1/schema#description`]->(m) RETURN n, r, m;``

* Retrieval of all resource types used in the graph, i.e. “show me all resource type nodes of the resource type rdfs:Class” :

    ``MATCH (n:`http://www.w3.org/2000/01/rdf-schema#Class`) RETURN n;``

__Note:__ In the graph exploration tab, all resource types in the graph will be shown. A possible difference of this Cypher query is the fact that it will show all resource types currently existent in the graph, while the exploration tab lists also those types that used to be existent but have been deleted.


### Use of Indices

Apart from the built-in indices for node labels and relationship types you should make use of further indices in order to achieve fast runtimes for your queries. At this stage, node indices are implemented as [[schema indices|http://docs.neo4j.org/chunked/milestone/query-schema-index.html]] and edge indices are implemented as [[Neo4j legacy indices|http://docs.neo4j.org/chunked/milestone/indexing.html]].

* Legacy index usage example: retrieval of the statement with the statement identifier `788e0248-f417-4e72-a6ed-e8cf0baa4546`:

    ``START r=relationship:statement_uuids(uuid="788e0248-f417-4e72-a6ed-e8cf0baa4546") MATCH (n)-[r]->(m) RETURN n, r, m;``


#### Available Indices

There are different indices for nodes and edges.

##### Node Indices

Node indices are schema indices and don't need specific query statements, since they are utilised automatically by the query engine at query evaluation time. The following node indices are currently provided for nodes with the following labels:

* **RESOURCE**: contains all resource identifiers
  * **uri**
  * **hash** (**note**: this index is useful for efficient access to resources of a certain data model)
* **LITERAL**: contains all values of literals
  * **value**
* **RESOURCE_TYPE**: contains all resource type identifier (class names)
  * **uri**

##### Edge Indices

Edge indices always have the prefix ‘relationship’. The following edge indices are currently provided

* **statement_uuids**: contains all statement uuids
  * Index attribute: **uuid**

**Note**: Index attributes have no direct relation to edge attributes, even if they have the same label.