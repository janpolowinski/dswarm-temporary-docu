TODO add content

* see also [[Cypher Cheat Sheet]]

## HTTP API Endpoints - DMP Graph (neo4j)

Here are some links for convenient testing

    http://localhost:7474/graph/maintain/ping 

(result should be "pong")

_Attention: links go to localhost and datamodel 4 is expected to exist! datamodels 1,2 and 3 are special datamodels, which will only contain data after storing transformation results_

 * return all data models as RDF

        http://localhost:7474/graph/rdf/getall

(default serialization is N-Quads)

 * return all data models as RDF (serialized as N-Quads)
    
        http://localhost:7474/graph/rdf/getall?format=application/n-quads

 * return all data models as RDF (serialized as TriG)

        http://localhost:7474/graph/rdf/getall?format=application/trig
  
 * return the data model with the URI ````http://data.slub-dresden.de/datamodel/4/data```` as RDF (serialized as N-Quads)

        http://localhost:7474/graph/rdf/export?format=application/n-quads&data_model_uri=http://data.slub-dresden.de/datamodel/4/data

 * return the data model with the URI ````http://data.slub-dresden.de/datamodel/4/data```` as RDF (serialized as Turtle)

        http://localhost:7474/graph/rdf/export?format=text/turtle&data_model_uri=http://data.slub-dresden.de/datamodel/4/data

 * return the data model with the URI ````http://data.slub-dresden.de/datamodel/4/data```` as RDF (serialized as N3)

        http://localhost:7474/graph/rdf/export?format=text/n3&data_model_uri=http://data.slub-dresden.de/datamodel/4/data

 * return the data model with the URI ````http://data.slub-dresden.de/datamodel/4/data```` as RDF (serialized as RDF/XML)

        http://localhost:7474/graph/rdf/export?format=application/rdf%2Bxml&data_model_uri=http://data.slub-dresden.de/datamodel/4/data