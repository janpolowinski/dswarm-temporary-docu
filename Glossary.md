### Attribute

An attribute is a property or a type of a relationship, e.g., “name”, “knows”. Attributes can be chained into an [[#Attribute Path]]. Attributes can be part of a Vocabulary. In a simple (natural language) sentence that consists of three parts (subject, predicate, objects), e.g., “Walter knows Claire.”, attributes are predicates. In a property graph model attributes are properties or edges of a node.

Hint: In non-hierarchical data structures like CSV files, the attribute corresponds to the attribute path
alternative names: property, relationship type, edge type, edge label, predicate

### Attribute Path

An attribute path is an identifier or way to a certain element(s) or value(s) of a Record in a Data Model. Attribute paths are an ordered lists of Attributes. A bunch of attribute paths can be composed to a Schema. A Mapping can refer to certain attribute paths.

This might be a column header in a CSV file or a certain node in a nested XML structure
Examples: /dc:creator/foaf:family_name (to adresse attributes in an RDF graph), /autor/name (to address attributes in an XML file) or /name (to address “flat” attributes – the column headers – in a CSV file)
Note: attribute paths are not always a unique identifier or way to certain element(s) or value(s); sometimes more complex Filters need to be defined to address element(s) or value(s) uniquely (or more precise).
alternative names: property path

### Blank Node

A blank node or bnode is an anonymous resource that belongs to another resource and has no own identifier, e.g., a MABXML ‘Datensatz’ consists of parts that are called ‘Feld’ – those parts can be represented as blank nodes.

### Class

A class is a type or universal to specify or categorize a concrete object or particular, e.g., a Record class (as part of a Schema) can be book or document. Classes can be part of a Vocabulary.

### Component

A component is a mechanism to describe the instantiation/utilisation of a Function or Transformation, i.e., a mapping of variables or static values to the parameters of the utilised function or transformation. A can be part of a Transformation or Mapping that make use of existing functions or transformation in a concrete context.

### Configuration

A configuration is a bunch of settings or parameters that are necessary to interpret the data of a Data Resource. A CSV file, for example, can be parsed by a given column delimiter, row delimiter, the encoding of the content, etc.. Those settings are required to interpret the dumb plain data into useful bits of information. The result of the application of a configuration to a data resource is a Data Model.

### Datahub

The data hub is the central database within the DMP storing all available/registered data, ie. no metadata from the domain model

hint: The data used in the domain model is stored in the Metadata Repository, the data is represented in a Graph
alternatives: internal data storage

### Data Model

A data model is an interpretation of a Data Resource through its Configuration (e.g. a csv file can be parsed by a given column delimiter, row delimiter, the encoding of the content, etc.). A data model consists of a bunch of Records. Each input data resource is processed/loaded via a configuration into the internal data storage of the Data Management Platform. The result is a data model that refers to its data resource, configuration and the Schema of the data (records).

note: data model is sometimes utilised as replacement for Meta Data Model (which has a different meaning)

### Data Perspective

In the web-based UI the data perspective enables the user to perform all data ingestion and configuration in order to produce the correct data model which can be used for modelling puposes.

alternative names : data view

### Data Resource

A data resource refers to or denotes the actual data (“bits and bytes”) that is contained in a source or a target without any interpretation. A data resource (the data of a data resource) can be interpreted by a configuration. The result of this interpretation/processing is a Data Model. A data resource can have a certain type.

alternative names : raw data, Datenquelle, data source (for input data resource), resource, data
note: a data resource can be on both ends, i.e., there are input data resources and output data resource

### Data Resource Type

A data resource type refers to or denotes a certain type of data source system (eg. csv, xml, mysql…). It can be compare to media type/content type (see Internet media type @ Wikipedia or RFC 2046: MIME type), e.g., text/xml (as example for a generic media type) or application/vnd.openxmlformats-officedocument.presentationml.presentation (as example for a rather specific media type (on top of a more generic type)).

### Data Type

A data type specifies the value type of a literal (a simple value of an Attribute/[[#Attribute Path]]), e.g., xsd:string, xsd:dateTime.

### DMP

Acronym for Data Management Plattfrom.

### Domain Model

An application or data has a domain model that describes all entities and relationships of this application or data. In a data processing tool (e.g. DMP) the domain model of the application is not the domain model of the data that can be processed with this application, i.e., the domain model of the application is on another higher (meta) level. The DMP, for example, is designed for primarily working with bibliographic records, i.e., the data domain model is library (with Entities such as resource (document, book), person (author, contributor), etc.), however, the application domain model of the DMP is data processing (with entities such as Mapping, Job, [[#Attribute Path]]).

see: domain model (@ Wikipedia), domain-driven design (@ Wikipedia)

### Draft (Mode)

While creating, updating, deleting mappings, filter or transformations in the Modelling Perspective and not yet saving the work, it is locally stored in the browser.

### Edge

See Relationship.

### Entity

An entity is the hypernym for describing all terms, parts, classes or types of a Domain Model. These are in our application domain model for example, [[#Attribute Path]]s, Mappings, Transformations etc.

alternative names: resource

### Execution Environment

The execution environment is the server infrastructure where the Tasks are executed, i.e. where the modeled business logics are applied on the ingested data and the Graph is generated/updated.

alternative names : runtime environment, execution engine, execution system, runtime architecture

### Filter

A business logic (graph pattern, e.g., a Cypher query) that reduces or specify the amount/candidates of Records that should be addressed/processed via a Mapping. Filters can be defined on both endings of a mapping, i.e., there can be input filters and output filters.

### Function

A function is a data processing method or operation. It consists of a bunch of (input) parameters, an output (parameter) and a certain transformation logic that will be applied to the data in a data stream of a data processing workflow. A simple function is a kind of atomar operation. Extended or composed functions are Transformations. Functions (or transformations) can be (re-)utilised in transformations or Mappings (via Components).

Example : A replacement function replaces a certain value <a> with a defined value <b>.

### Graph

The data of the Data Models of the DMP is stored in a graph. This graph relies on a Property Graph based representation.

### Graph Data Model

A graph data model is a data model or Meta Data Model to describe the knowledge representation structure in a Graph. An example of an abstract graph data model is the Property Graph. (Graph) data model can be layered, e.g., the property graph data model can act as a meta data model for another data model, e.g., RDF.

### Job

A job is a collection of Mappings that can be executed with an input Data Model that contains data that make use of the utilised input [[#Attribute Path]]s of the mappings. Mappings from a job are independent from an input data model and an output data model. A job can be configured to a concrete Task with an input data model and an output data model, i.e., a job can be instantiated/utilised by a bunch of tasks.

alternative names: data processing workflow, data transformation workflow
note: job is also used in more abstract descriptions (context), where a job refers to both the job and the task(s) that utilise the job

### Literal

A literal represents a value of an attribute of an entity, e.g., in “The book has been published in 2011″ the value of the attribute ‘published (in)’ is ’2011′. A value can have a datatype, e.g., string or integer.

### Mapping

A mapping can refer to multiple input [[#Attribute Path]]s (that should be part of the input Data Model), an output attribute path (that should be part of the output data model) and is an instantation or utilisation of a Function or Transformation, i.e., the input attribute paths of a mapping are mapped to the parameters of the function or transformation and the output attribute path is mapped/connected to the output of the function or transformation. This instantiation/utilisation is realized by that same mechanism as applied by transformations – Components, i.e., each mapping can have a (transformation) component that describes the parameter mappings and refers to the utilised function or tranformation. Additionally, a mapping can have an input Filter, to reduce or specify the amount of Records that should be processed via this mapping from the input data model, and an output filter, to specify the way where the result of this mapping should be written to in the output data model.

### Metadata Repository

Some physical data storage system that contains all available metadata for each Entity used in the DMP.

### Meta Data Model

A meta data model or simply data model is knowledge representation structure to describe something, e.g., graphs.

### Node

A node or vertex is a fundamental part in a Graph Data Model of a graph data base. A node can have attributes (key-value pairs), i.e., properties. A node can have labels or types to categorise the node.

### Perspectives

Perspectives are individual sites in the web-based UI which serve a certain scope.
alternative name : view

### Modelling Pespective

The modelling perspective is the central working space for the system librarian for designing, testing and debugging transformation logics.

### Project

A project refers to all related parts that are relevant to design a whole data processing workflow, i.e., especially an (sample) input Data Model, a bunch of Mappings (that can selectively export as a Job) and optionally self-defined Functions (or Transformations).

### Property Graph

A property graph is a Graph Data Model that consists of Nodes and Relationships. Whereby, the relationships are directed and binary, i.e., each relationship has always one source and one target node.

### RDF

The resource description framework is a (meta) data model that consists of Statement that are simple sentences of the structure: subject, predicate, object. Whereby, subjects can be resources with a URI as identifier or Blank Nodes. Predicates are usually represented by a URI. And objects can be a resource with a URI, a blank node or a Literal.

A similar (meta) data model is EAV (entity-attribute-value).

See also entity-attribute-value model @ Wikipedia

### Record

A record is a resource description or object that describes a certain thing, e.g., a book. A book, for example, has an author, a publishing date, a publisher, etc. Records are the main unit of work of the Data Management Platform. A Data Model consists of a bunch of records (of a certain record Class).

alternative names : bibliographic record, Datensatz
see : Bibliographic Record @ Wikipedia

### Relationship

A relationship or Edge is a fundamental part in a graph data model of a graph data base. A relationship can connect two or more Nodes to each other. A relationship can be directed or undirected. A relationship can have a type or label to categorise it. A relationship can have properties to qualify it.

### Schema

A schema is a collection of [[#Attribute Path]]s and a (generic) Class for Records. Each Data Model refers to a schema. All pieces of information in a data model should be addressable via the attribute paths of its schema. The schema of a CSV file (Data Resource), for example, consists of the names (or positions) of the headers, i.e., each header is an Attribute (thereby, the Attribute Paths are equal to those attributes, since CSV files have a flat hierarchy). A schema can refer to certain sub-schemas or make use of other existing schemas to describe records (resources) at specific attribute paths, .e.g., a <strongdcterms:creator attribute (path) can refer to a specific schema for describing persons etc. Hence, a schema can be a composition of schemas.

### Statement

A statement – a simple sentence with the structure: subject, predicate, object – is the fundamental knowledge representation structure of the graph data model in our Datahub. Whereby, each subject and object is represented by a Node and the predicate is always a Relationship (Edge). Hence, a statement made of subject, predicate, object is represented by a node, edge, node structure. This enables the ability to add fine-grained external context information, e.g., provenance, version or evidence, at the level of statements or to qualify a statement more precise, e.g., weighting etc.

### Subject

The subject denotes the resource.

### Task

A task is a concrete execution unit of a Job, i.e., besides the Mappings from a job, a task defines an input Data Model and an output data model on which the job can be executed, i.e., it refers to the concrete data source and target of the data processing workflow.

### Transformation

A transformation is an extended Function, i.e., it is a composition of existing functions or transformations that are utilised/instantiated by Components of the transformation. The data processing workflow of a transformation is the ordered list or sequence of its components, i.e., components can be connected to each other and describe thereby the processing pipeline of the workflow. The detailed workflow of a transformation can be viewed and manipulated in the transformation logic widget. Transformations or functions can be instantiated/utilised by a Mapping, i.e., the (transformation) component of the mapping instantiates a transformation or functions by its parameter mapping.

alternative names : transformation process, transformation pipeline, transformation logic
note: transformation is also used in more abstract descriptions (context), where transformation refers to the transformation pipeline or logic of a mapping

### URI

A URI is a uniform resource identifier for denoting something, e.g., resources, properties or resource types.

See also URI @ Wikipedia

### Vocabulary

A vocabulary or ontology is a set of terms (universals). Terms can be Attributes (properties) or Classes (types).

### Widgets

Every box in the modelling perspective in the web-based UI is called a widget

The following widgets are available
source data
source schema
target schema
target data
transformation
function component