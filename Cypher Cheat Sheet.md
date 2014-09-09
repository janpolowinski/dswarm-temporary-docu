## Universal Cypher Cheat Sheet

An universal cheat sheet is the [Neo4j Cypher Refcard 2.0](http://docs.neo4j.org/refcard/2.0/).


## d:swarm specific Cypher Queries

This section provides some common cypher queries that may be used programmatically or to explore the graph via the Neo4j browser that usually runs at *http://localhost:7474/browser/*. 

### extract all statements from the DB (re. currently graph model)

    MATCH n-[r]->m RETURN DISTINCT n, n.__URI__,n.__NODETYPE__, r, r.__URI__, m, m.__URI__, m.__NODETYPE__, m.__VALUE__

note: you may run this query with a limit, e.g.,

    MATCH n-[r]->m RETURN DISTINCT n, n.__URI__,n.__NODETYPE__, r, r.__URI__, m, m.__URI__, m.__NODETYPE__, m.__VALUE__ LIMIT 100


### delete statements in a batch process

    MATCH (a)
    WITH a
    LIMIT 10000
    OPTIONAL MATCH (a)-[r]-()
    DELETE a,r
    RETURN COUNT(*)

note: you may run this query multiple times until the result count of this query is 0, i.e., no statements are left in the DB, or you can run this query in the neo4j shell with a higher limit or without a limit


### get all nodes/resources (incl. it's directly outgoing relationships -> statements) for mabxml record type (http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#recordType)

    MATCH (n:`http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#recordType`) WITH n MATCH (n)-[r]->(m) RETURN n, r, m;


### get all nodes/resources (incl. it's directly outgoing relationships > statements) oai-pmh record type (http://www.openarchives.org/OAI/2.0/recordType)

    MATCH (n:`http://www.openarchives.org/OAI/2.0/recordType`) WITH n MATCH (n)-[r]->(m) RETURN n, r, m;


### get all types (classes) that are in the graph database
   MATCH (n:`http://www.w3.org/2000/01/rdf-schema#Class`) RETURN n.__URI__;


### all relations (limited to 50) except type-relations (these often lead to crossing edges)

    MATCH (a)-[r]-(b)
    WHERE type(r) <> "http://www.w3.org/1999/02/22-rdf-syntax-ns#type"
    RETURN DISTINCT a,b LIMIT 50


### display children of oai records to depth 4, except for type relations

(this query should have many OPTIONAL parts actually...)

    MATCH (n:`http://www.openarchives.org/OAI/2.0/recordType`)
    WITH n MATCH (n)-[r]->(m) , (m)-[r1]->(l), (l)-[r2]->(o), (o)-[r3]->(p)
    WHERE type(r) <> "http://www.w3.org/1999/02/22-rdf-syntax-ns#type"
    AND type(r1) <> "http://www.w3.org/1999/02/22-rdf-syntax-ns#type"
    AND type(r2) <> "http://www.w3.org/1999/02/22-rdf-syntax-ns#type"
    AND type(r3) <> "http://www.w3.org/1999/02/22-rdf-syntax-ns#type"
    RETURN n,r,m,r1,l,r2,o,r3,p LIMIT 100


### show all URIs used as provenance graphs

    MATCH (n)-[r]->(m)
    RETURN DISTINCT r.__PROVENANCE__ LIMIT 1000;


### show all relationships for a specific provenance graph URI

NOTE: the internal data models have the URIs "http://data.slub-dresden.de/datamodel/1/data", "http://data.slub-dresden.de/datamodel/2/data", "http://data.slub-dresden.de/datamodel/3/data"

    MATCH (n)-[r]->(m)
    WHERE r.__PROVENANCE__ = "http://data.slub-dresden.de/datamodel/15/data"
    RETURN DISTINCT n,r,m LIMIT 1000;


### get all second mabxml field values, where the key is "077p"

    MATCH 
      (mabxmlrecord:`http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#datensatzType`)- [:`http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld`]->(mabxmlfield),
      (mabxmlfield)-[:`http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr`]->(nr),  
      (mabxmlfield)-[:`http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#ind`]->(ind),
      (mabxmlfield)-[valueprop:`http://www.w3.org/1999/02/22-rdf-syntax-ns#value`]->(value)
    WHERE
      nr.__VALUE__ = "077" AND
      ind.__VALUE__ = "p"
    WITH 
      mabxmlrecord, mabxmlfield, value
    ORDER BY valueprop.__ORDER__
    RETURN
      mabxmlrecord.__URI__, id(mabxmlfield), collect(value.__VALUE__)[1];


### get the second mabxml field value of the second occurrence of the field where the key is "077p"

    MATCH 
      (mabxmlrecord:`http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#datensatzType`)-[feldprop:`http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld`]->(mabxmlfield),
      (mabxmlfield)-[:`http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr`]->(nr),  
      (mabxmlfield)-[:`http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#ind`]->(ind),
      (mabxmlfield)-[valueprop:`http://www.w3.org/1999/02/22-rdf-syntax-ns#value`]->(value)
    WHERE
      nr.__VALUE__ = "077" AND
      ind.__VALUE__ = "p"
    WITH 
      mabxmlrecord, feldprop, mabxmlfield, value
    ORDER BY feldprop.__INDEX__, valueprop.__ORDER__
    WITH
      mabxmlrecord, collect(id(feldprop))[1] AS secondfield, mabxmlfield, value
    RETURN
      mabxmlrecord.__URI__, collect(value.__VALUE__)[1];


See also [[Graph Data Model Overview]] 
<!--- original link to https://intranet.slub-dresden.de/pages/viewpage.action?pageId=45190236 --> 