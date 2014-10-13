TODO add content

* see also [[Cypher Cheat Sheet]]

## HTTP API Endpoints - DMP Graph (neo4j)

Here are some links for convenient testing

    http://localhost:7474/graph/maintain/ping 

(result should be "pong")

_Attention: links go to localhost and datamodel 4 is expected to exist!_

 * return all data models as RDF

        curl -H "Accept:application/n-quads" http://localhost:7474/graph/rdf/getall

(default serialization is N-Quads)

 * return all data models as RDF (serialized as N-Quads)
    
        curl -H "Accept:application/n-quads" http://localhost:7474/graph/rdf/getall

 * return all data models as RDF (serialized as TriG)
  
        curl -H "Accept:application/trig" http://localhost:7474/graph/rdf/getall

 * return the data model with the URI ````http://data.slub-dresden.de/datamodel/4/data```` as RDF (serialized as N-Quads)

        curl -H "Accept:application/n-quads" http://localhost:7474/graph/rdf/export?data_model_uri=http://data.slub-dresden.de/datamodel/4/data

 * return the data model with the URI ````http://data.slub-dresden.de/datamodel/4/data```` as RDF (serialized as Turtle)

        curl -H "Accept:text/turtle" http://localhost:7474/graph/rdf/export?data_model_uri=http://data.slub-dresden.de/datamodel/4/data

 * return the data model with the URI ````http://data.slub-dresden.de/datamodel/4/data```` as RDF (serialized as N3)

        curl -H "Accept:text/n3" http://localhost:7474/graph/rdf/export?data_model_uri=http://data.slub-dresden.de/datamodel/4/data

 * return the data model with the URI ````http://data.slub-dresden.de/datamodel/4/data```` as RDF (serialized as RDF/XML)

        curl -H "Accept:application/rdf+xml" http://localhost:7474/graph/rdf/export?&data_model_uri=http://data.slub-dresden.de/datamodel/4/data