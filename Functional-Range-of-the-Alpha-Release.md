The alpha release version of d:swarm serves purposes of demonstration and testing and is meant to validate the working principles of the web-based graphical user interface (GUI).

## Modelling Features

At the stage of the alpha release you can model these [ETL processes](http://en.wikipedia.org/wiki/Extract,_transform,_load):

1. [[Import sample data|Import Sample Data]] (of small size up to 1,000 records) in CSV and XML formats to d:swarm.
2. [[Configure the schema|Select Data for Schema Configuration]] of the imported sample data.
3. [[Create projects|Create and Edit Projects]] for bundling all transformation processes necessary for converting [[data resources|Glossary#data-resource]] into target data based on a [[graph model|Glossary#data-model]].
4. [[Map|Define Mappings]] a configured input [[schema|Glossary#schema]] of a sample data resource to an output schema.
5. Define [[data transformation routines|Design and Execute Transformations]] for each [[mapping|Glossary#mapping]] using a basic set of [[transformation functions|Available Transformation Functions]].
6. [[Configure filters|Define Filters]] that define the conditions for transformation processes.
7. Execute data transformations on the imported sample data while modelling and save the results in a central [[data hub|Glossary#data-hub]] in a [[property graph|Graph Data Model]].
8. [[View and explore|Graph Exploration]] the results within the graphical user interface of the graph database.
9. [[Export all data|Export Data in RDF]] of the central data hub in RDF for further use.

## Functional Restriction of the Alpha Release

* Our design ideas for the GUI are not yet realized in the alpha release.
* A user or rights management model is not implemented yet. Consequently, all users are allowed to do everything. All users have access to all data resources imported to d:swarm and can manipulate and overwrite [[projects|Glossary#project]] of other all other users. The data in the central [[data hub|Glossary#data-hub]] is the result of the work of all users.
* There are further functional restrictions that will be resolved in due time according to our [[roadmap]].


-----------------------------------
### Alpha Release Help Step by Step

* next: [[Import Sample Data]]
* previous: [[Alpha Release Help]]