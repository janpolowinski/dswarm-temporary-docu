## Universal Cypher Cheat Sheet

An universal cheat sheet is the [Neo4j Cypher Refcard 2.0](http://docs.neo4j.org/refcard/2.0/). This section provides some common Cypher queries that can be used to explore the graph via the [[Neo4j browser|Graph-Exploration]] that usually runs at *http://localhost:7474/browser/*. 

1. __extract all [[statements|Glossary#statement]] from the DB:__

        MATCH (n)-[r]->(m) RETURN DISTINCT n, n.__URI__,n.__NODETYPE__, r, r.__URI__, m, m.__URI__, m.__NODETYPE__, m.__VALUE__;

    __Note:__ you may run this query with a limit, e.g.,

        MATCH (n)-[r]->(m) RETURN DISTINCT n, n.__URI__,n.__NODETYPE__, r, r.__URI__, m, m.__URI__, m.__NODETYPE__, m.__VALUE__ LIMIT 100;

2. __delete statements:__

        MATCH (a)
        WITH a
        LIMIT 10000
        OPTIONAL MATCH (a)-[r]-()
        DELETE a,r
        RETURN COUNT(*);

    __Note:__ you may run this query multiple times until the result count of this query is 0, i.e., no statements are left in the DB, or you can run this query in the Neo4j shell with a higher limit or without a limit

3. __get all statements that have a MABxml [[record|Glossary#record]] as subject, i.e., which have the record [[class|Glossary#class]] `http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#recordType`:__

        MATCH (n`http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#recordType`)-[r]->(m) RETURN n, r, m;

4. __get all statements that have a OAI-PHM record as subject, i.e. which have the record class `http://www.openarchives.org/OAI/2.0/recordType`:__

        MATCH (n`http://www.openarchives.org/OAI/2.0/recordType`)-[r]->(m) RETURN n, r, m;

5. __get all resource types (classes) that are in the graph database:__

        MATCH (n:`http://www.w3.org/2000/01/rdf-schema#Class`) RETURN n.__URI__;

6. __get all statements (limited to 50) except those that have the property `http://www.w3.org/1999/02/22-rdf-syntax-ns#type`:__

        MATCH (a)-[r]-(b)
        WHERE type(r) <> "http://www.w3.org/1999/02/22-rdf-syntax-ns#type"
        RETURN DISTINCT a,b LIMIT 50;

7. __get all statements (current limit is 100) that belong to OAI-PMH records up to a depths of 4 except those that have the property `http://www.w3.org/1999/02/22-rdf-syntax-ns#type`:__

    (this query should have many OPTIONAL parts actually...)

        MATCH (n:`http://www.openarchives.org/OAI/2.0/recordType`)-[r]->(m)-[r1]->(l)-[r2]->(o)-[r3]->(p)
        WHERE type(r) <> "http://www.w3.org/1999/02/22-rdf-syntax-ns#type"
        AND type(r1) <> "http://www.w3.org/1999/02/22-rdf-syntax-ns#type"
        AND type(r2) <> "http://www.w3.org/1999/02/22-rdf-syntax-ns#type"
        AND type(r3) <> "http://www.w3.org/1999/02/22-rdf-syntax-ns#type"
        RETURN n,r,m,r1,l,r2,o,r3,p LIMIT 100;

8. __show all [[data model|Glossary#data-model]] identifier (current limit is 1000):__

        MATCH (n)-[r]->(m)
        RETURN DISTINCT r.__DATA_MODEL__ LIMIT 1000;

9. __show all statements (current limit is 1000) for the data model with the identifier `http://data.slub-dresden.de/datamodel/15/data`:__

        MATCH (n)-[r]->(m)
        WHERE r.__DATA_MODEL__ = "http://data.slub-dresden.de/datamodel/15/data"
        RETURN DISTINCT n,r,m LIMIT 1000;

    __Note:__ currently, the pre-initialized (internal) data models have the URIs "http://data.slub-dresden.de/datamodel/1/data", "http://data.slub-dresden.de/datamodel/2/data" and "http://data.slub-dresden.de/datamodel/3/data"

10. __get all second MABxml field values where the key is "077p":__

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

11. __get the second MABxml field value of the second occurrence of the field where the key is "077p":__

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

See also [[Graph Data Model]].