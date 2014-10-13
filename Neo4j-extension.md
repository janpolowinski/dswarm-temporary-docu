TODO add content

* see also [[Cypher Cheat Sheet]]

## HTTP API Endpoints - DMP Graph (neo4j)

Here are some links for convenient testing

* http://localhost:7474/graph/maintain/ping (result should be "pong")

_Attention: links go to localhost and datamodel 4 is expected to exist! datamodels 1,2 and 3 are special datamodels, which will only contain data after storing transformation results_

  * http://localhost:7474/graph/rdf/getall
  * http://localhost:7474/graph/rdf/getall?format=application/n-quads
  * http://localhost:7474/graph/rdf/getall?format=application/trig
  * http://localhost:7474/graph/rdf/export?format=application/n-quads&provenanceuri=http://data.slub-dresden.de/datamodel/4/data
  * http://localhost:7474/graph/rdf/export?format=text/turtle&provenanceuri=http://data.slub-dresden.de/datamodel/4/data 
  * http://localhost:7474/graph/rdf/export?format=text/n3&provenanceuri=http://data.slub-dresden.de/datamodel/4/data
  * http://localhost:7474/graph/rdf/export?format=application/rdf%2Bxml&provenanceuri=http://data.slub-dresden.de/datamodel/4/data