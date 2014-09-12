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


([[enlarge figure|img/.png]])
[[img/.png]]

([[enlarge figure|img/.png]])
[[img/.png]]