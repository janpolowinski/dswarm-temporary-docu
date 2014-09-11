* [[Attribute|Glossary#attribute]]
* [[Attribute Path|Glossary#attribute-path]]
* [[Blank Node|Glossary#blank-node]]
* [[Class|Glossary#class]]
* [[Component|Glossary#component]]
* [[Configuration|Glossary#configuration]]
* [[Data Hub|Glossary#data-hub]]
* [[Data Model|Glossary#data-model]]
* [[Data Perspective|Glossary#data-perspective]]
* [[Data Resource|Glossary#data-resource]]
* [[Data Resource Type|Glossary#data-resource-type]]
* [[Data Type|Glossary#data-type]]
* [[DMP|Glossary#dmp]]
* [[Domain Model|Glossary#domain-model]]
* [[Draft (Mode)|Glossary#draft-(mode)]]
* [[Edge|Glossary#edge]]
* [[Entity|Glossary#entity]]
* [[Execution Environment|Glossary#execution-environment]]
* [[Filter|Glossary#filter]]
* [[Function|Glossary#function]]
* [[Graph|Glossary#graph]]
* [[Graph Data Model|Glossary#graph-data-model]]
* [[Job|Glossary#job]]
* [[Literal|Glossary#literal]]
* [[Mapping|Glossary#mapping]]
* [[Metadata Repository|Glossary#metadata-repository]]
* [[Meta Data Model|Glossary#meta-data-model]]
* [[Modelling Perspective|Glossary#modelling-perspective]]
* [[Node|Glossary#node]]
* [[Perspectives|Glossary#perspectives]]
* [[Project|Glossary#project]]
* [[Property Graph|Glossary#property-graph]]
* [[RDF|Glossary#rdf]]
* [[Record|Glossary#record]]
* [[Relationship|Glossary#relationship]]
* [[Schema|Glossary#schema]]
* [[Statement|Glossary#statement]]
* [[Subject|Glossary#subject]]
* [[Task|Glossary#task]]
* [[Transformation|Glossary#transformation]]
* [[URI|Glossary#uri]]
* [[Vocabulary|Glossary#vocabulary]]
* [[Widgets|Glossary#widgets]]

---

### Attribute

An attribute is a property or a type of a relationship, e.g., “name”, “knows”. Attributes can be chained into an [[Attribute Path|Glossary#attribute-path]]. Attributes can be part of a Vocabulary. In a simple (natural language) sentence that consists of three parts (subject, predicate, objects), e.g., “Walter knows Claire.”, attributes are predicates. In a property graph model attributes are properties or edges of a node.

* Hint: In non-hierarchical data structures like CSV files, the attribute corresponds to the attribute path
* alternative names: property, relationship type, edge type, edge label, predicate

### Attribute Path

An attribute path is an identifier or way to a certain element(s) or value(s) of a [[Record|Glossary#record]] in a [[Data Model|Glossary#data-mpdel]]. Attribute paths are an ordered lists of [[Attribute|Glossary#attribute]]s. A bunch of attribute paths can be composed to a [[Schema|Glossary#schema]]. A [[Mapping|Glossary#mapping]] can refer to certain attribute paths.

* This might be a column header in a CSV file or a certain node in a nested XML structure
* Examples: _/dc:creator/foaf:family_name_ (to adresse attributes in an RDF graph), _/autor/name_ (to address attributes in an XML file) or _/name_ (to address “flat” attributes – the column headers – in a CSV file)
* Note: attribute paths are not always a unique identifier or way to certain element(s) or value(s); sometimes more complex [[Filters|Glossary#filter]] need to be defined to address element(s) or value(s) uniquely (or more precise).
* alternative names: property path

### Blank Node

A blank node or bnode is an anonymous resource that belongs to another resource and has no own identifier, e.g., a MABXML ‘Datensatz’ consists of parts that are called ‘Feld’ – those parts can be represented as blank nodes.

### Class

A class is a type or universal to specify or categorize a concrete object or particular, e.g., a [[Record|Glossary#record]] class (as part of a [[Schema|Glossary#schema]]) can be book or document. Classes can be part of a [[Vocabulary|Glossary#vocabulary]].

* see also: [universal @ Wikipedia](http://en.wikipedia.org/wiki/Universal_%28metaphysics%29) and [particular @ Wikipedia](http://en.wikipedia.org/wiki/Particular)

### Component

A component is a mechanism to describe the instantiation/utilisation of a [[Function|Glossary#function]] or [[Transformation|Glossary#transformation]], i.e., a mapping of variables or static values to the parameters of the utilised function or transformation. A component can be part of a Transformation or [[Mapping|Glossary#mapping]] that make use of existing functions or transformation in a concrete context.

### Configuration

A configuration is a bunch of settings or parameters that are necessary to interpret the data of a [[Data Resource|Glossary#data-resuorce]]. A CSV file, for example, can be parsed by a given column delimiter, row delimiter, the encoding of the content, etc.. Those settings are required to interpret the dumb plain data into useful bits of information. The result of the application of a configuration to a data resource is a [[Data Model|Glossary#data-model]].

### Data Hub

The data hub is the central database within the DMP storing all available/registered data, ie. no metadata from the domain model

* hint: The data used in the domain model is stored in the [[Metadata Repository|Glossary#metadata-repository]], the data is represented in a [[Graph|Glossary#graph]]
* alternative name: internal data storage

### Data Model

A data model is an interpretation of a [[Data Resource|Glossary#data-resource]] through its [[Configuration|Glossary#configuration]] (e.g. a csv file can be parsed by a given column delimiter, row delimiter, the encoding of the content, etc.). A data model consists of a bunch of [[Records|Glossary#record]]. Each input data resource is processed/loaded via a configuration into the [[internal data storage|Glossary#data-hub]] of the Data Management Platform. The result is a data model that refers to its data resource, configuration and the [[Schema|Glossary#schema]] of the data (records).

* note: data model is sometimes utilised as replacement for [[Meta Data Model|Glossary#meta-data-model]] (which has a different meaning)

### Data Perspective

In the web-based UI the data perspective enables the user to perform all data ingestion and configuration in order to produce the correct data model which can be used for modelling purposes.

* alternative name: data view

### Data Resource

A data resource refers to or denotes the actual data (“bits and bytes”) that is contained in a source or a target without any interpretation. A data resource (the data of a data resource) can be interpreted by a [[Configuration|Glossary#configuration]]. The result of this interpretation/processing is a [[Data Model|Glossary#data-model]]. A data resource can have a certain [[type|Glossary#data-resource-type]].

* alternative names : raw data, data source (for input data resource), resource, data
* note: a data resource can be on both ends, i.e., there are input data resources and output data resource

### Data Resource Type

A data resource type refers to or denotes a certain type of data source system (eg. csv, xml, mysql…). It can be compare to media type/content type (see [Internet media type @ Wikipedia](http://en.wikipedia.org/wiki/Internet_media_type) or [RFC 2046: MIME type](http://tools.ietf.org/html/rfc2046)), e.g., _text/xml_ (as example for a generic media type) or _application/vnd.openxmlformats-officedocument.presentationml.presentation_ (as example for a rather specific media type (on top of a more generic type)).

### Data Type

A data type specifies the value type of a literal (a simple value of an [[Attribute|Glossary#attribute]]/[[Attribute Path|Glossary#attribute-path]]), e.g., _xsd:string_, _xsd:dateTime_.

### DMP

Acronym for Data Management Plattfrom.

### Domain Model

An application or data has a domain model that describes all entities and relationships of this application or data. In a data processing tool (e.g. d:swarm) the domain model of the application is not the domain model of the data that can be processed with this application, i.e., the domain model of the application is on another higher (meta) level. d:swarm, for example, is designed for primarily working with bibliographic records, i.e., the data domain model is library (with [[Entities|Glossary#entity]] such as resource (document, book), person (author, contributor), etc.), however, the application domain model of the DMP is data processing (with entities such as [[Mapping|Glossary#mapping]], [[Job|Glossary#job]], [[Attribute Path|Glossary#attribute-path]]).

* see: [domain model (@ Wikipedia)](http://en.wikipedia.org/wiki/Domain_model), [domain-driven design (@ Wikipedia)](http://en.wikipedia.org/wiki/Domain-driven_design)

### Draft (Mode)

While creating, updating, deleting mappings, filter or transformations in the [[Modelling Perspective|Glossary#modelling-perspective]] and not yet saving the work, it is locally stored in the browser.

### Edge

See [[Relationship|Glossary#relationship]].

### Entity

An entity is the hypernym for describing all terms, parts, classes or types of a [[Domain Model|Glossary#domain-model]]. In our application domain model, these are for example [[Attribute Path|Glossary#attribute-path]]s, [[Mappings|Glossary#mapping]], [[Transformations|Glossary#transformation]].

* alternative name: resource

### Execution Environment

The execution environment is the server infrastructure where the [[Tasks|Glossary#task]] are executed, i.e. where the modeled business logics are applied on the ingested data and the [[Graph|Glossary#graph]] is generated/updated.

* alternative names : runtime environment, execution engine, execution system, runtime architecture

### Filter

A business logic (graph pattern, e.g., a Cypher query) that reduces or specify the amount/candidates of [[Records|Glossary#record]] that should be addressed/processed via a [[Mapping|Glossary#mapping]]. Filters can be defined on both endings of a mapping, i.e., there can be input filters and output filters.

### Function

A function is a data processing method or operation. It consists of a bunch of (input) parameters, an output (parameter) and a certain transformation logic that will be applied to the data in a data stream of a data processing workflow ([[Job|Glossary#job]]). A simple function is a kind of atomic operation. Extended or composed functions are [[Transformations|Glossary#transformation]]. Functions (or transformations) can be (re-)utilised in transformations or [[Mappings|Glossary#mapping]] (via [[Components|Glossary#component]]).

* Example : A replacement function replaces a certain value _\<a\>_ with a defined value _\<b\>_.

### Graph

The data of the [[Data Models|Glossary#data-model]] of d:swarm is stored in a graph. This graph relies on a [[Property Graph|Glossary#property-graph]] based representation.

### Graph Data Model

A graph data model is a data model or [[Meta Data Model|Glossary#meta-data-model]] to describe the knowledge representation structure in a [[Graph|Glossary#graph]]. An example of an abstract graph data model is the [[Property Graph|Glossary#property-graph]]. (Graph) data model can be layered, e.g., the property graph data model can act as a meta data model for another data model, e.g., [[RDF|Glossary#rdf]].

### Job

A job is a collection of [[Mappings|Glossary#mapping]] that can be executed with an input [[Data Model|Glossary#data-model]] that contains data that make use of the utilised input [[Attribute Path|Glossary#attribute-path]]s of the mappings. Mappings from a job are independent from an input data model and an output data model. A job can be configured to a concrete [[Task|Glossary#task]] with an input data model and an output data model, i.e., a job can be instantiated/utilised by a bunch of tasks.

* alternative names: data processing workflow, data transformation workflow
* note: job is also used in more abstract descriptions (context), where a job refers to both the job and the task(s) that utilise the job

### Literal

A literal represents a value of an attribute of an entity, e.g., in “The book has been published in 2011″ the value of the attribute ‘published (in)’ is ’2011′. A value can have a datatype, e.g., string or integer.

### Mapping

A mapping encapsulates a [[Function|Glossary#function]] (or [[Transformation|Glossary#transformation]], since we handle them as specific functions). It can refer to __multiple__ input [[Attribute Paths|Glossary#attribute-path]] and __one__ output attribute path. (Input and output attribute paths must be part of the input data model respectively output data model.) The input attribute paths are mapped to the parameters of the function and the output attribute path is mapped to the output of the function. The instantiation/utilisation of transformations by mappings is realized in the same way transformations utilise (other) functions - by means of [[Components|Glossary#components]]: Each mapping can have a (transformation) component that describes the parameter mappings and refers to the utilised function. Additionally, a mapping can have an input [[Filter|Glossary#filter]], to reduce or specify the amount of [[Records|Glossary#record]] that should be processed via this mapping from the input data model, and an output filter, to specify the way the result of this mapping should be written to the output data model.

### Metadata Repository

Some physical data storage system that contains all available metadata for each [[Entity|Glossary#entity]] used in d:swarm.

### Meta Data Model

A meta data model or simply data model is knowledge representation structure to describe something, e.g., graphs.

### Modelling Perspective

The modelling perspective is the central working space for the system librarian for designing, testing and debugging transformation logics.

### Node

A node or vertex is a fundamental part in a [[Graph Data Model|Glossary#graph-data-model]] of a graph data base. A node can have attributes (key-value pairs), i.e., properties. A node can have labels or types to categorise the node.

### Perspectives

Perspectives are individual sites in the web-based UI which serve a certain scope.
* Examples for perspectives are [[Data Perspective|Glossary#data-perspective]], Administration Perspective and [[Modelling Perspective|Glossary#modelling-perspective]]
* alternative name : view

### Project

A project refers to all related parts that are relevant to design a whole [[data processing workflow|Glossary#job]], i.e., especially an (sample) input [[Data Model|Glossary#data-model]], a bunch of [[Mappings|Glossary#mapping]] (that can selectively export as a [[Job|Glossary#job]]) and optionally self-defined [[Functions|Glossary#function]] (or [[Transformations|Glossary#transformation]]).

### Property Graph

A property graph is a [[Graph Data Model|Glossary#graph-data-model]] that consists of [[Nodes|Glossary#node]] and [[Relationships|Glossary#relationship]]. Whereby, the relationships are directed and binary, i.e., each relationship has always one source and one target node.

### RDF

The resource description framework is a (meta) data model that consists of [[Statements|Glossary#statement]] that are simple sentences of the structure: subject, predicate, object. Whereby, subjects can be resources with a [[URI|Glossary#uri]] as identifier or [[Blank Nodes|Glossary#blank-node]]. Predicates are usually represented by a URI. And objects can be a resource with a URI, a blank node or a [[Literal|Glossary#literal]].

A similar (meta) data model is EAV (entity-attribute-value).

* See also [entity-attribute-value model @ Wikipedia](http://en.wikipedia.org/wiki/Entity-attribute-value_model)

### Record

A record is a resource description or object that describes a certain thing, e.g., a book. A book, for example, has an author, a publishing date, a publisher, etc. Records are the main unit of work of the Data Management Platform. A Data Model consists of a bunch of records (of a certain record Class).

alternative names : bibliographic record, Datensatz
see : Bibliographic Record @ Wikipedia

### Relationship

A relationship or [[Edge|Glossary#edge]] is a fundamental part in a [[Graph Data Model|Glossary#graph-data-model]] of a graph data base. A relationship can connect two or more [[Nodes|Glossary#node]] to each other. A relationship can be directed or undirected. A relationship can have a type or label to categorise it. A relationship can have properties to qualify it.

### Schema

A schema is a collection of [[Attribute Path|Glossary#attribute-path]]s and a (generic) [[Class|Glossary#class]] for [[Records|Glossary#record]]. Each [[Data Model|Glossary#data-model]] refers to a schema. All pieces of information in a data model should be addressable via the attribute paths of its schema. The schema of a CSV file ([[Data Resource|Glossary#data-resource]]), for example, consists of the names (or positions) of the headers, i.e., each header is an [[Attribute|Glossary#attribute]] (thereby, the Attribute Paths are equal to those attributes, since CSV files have a flat hierarchy). A schema can refer to certain sub-schemas or make use of other existing schemas to describe records (resources) at specific attribute paths, .e.g., a _dcterms:creator_ attribute (path) can refer to a specific schema for describing persons etc. Hence, a schema can be a composition of schemas.

### Statement

A statement – a simple sentence with the structure: subject, predicate, object – is the fundamental knowledge representation structure of the graph data model in our [[Data Hub|Glossary#data-hub]]. Whereby, each subject and object is represented by a [[Node|Glossary#node]] and the predicate is always a [[Relationship|Glossary#relationship]] ([[Edge|Glossary#edge]]). Hence, a statement made of subject, predicate, object is represented by a node, edge, node structure. This enables the ability to add fine-grained external context information, e.g., provenance, version or evidence, at the level of statements or to qualify a statement more precise, e.g., weighting etc.

### Subject

The subject denotes the resource.

### Task

A task is a concrete execution unit of a [[Job|Glossary#job]], i.e., besides the [[Mappings|Glossary#mapping]] from a job, a task defines an input [[Data Model|Glossary#data-model]] and an output data model on which the job can be executed, i.e., it refers to the concrete data source and target of the [[data processing workflow|Glossary#job]].

### Transformation

A transformation is an extended [[Function|Glossary#function]], i.e., it is a composition of existing functions or transformations that are utilised/instantiated by [[Components|Glossary#component]] of the transformation. The data processing workflow of a transformation is the ordered list or sequence of its components, i.e., components can be connected to each other and describe thereby the processing pipeline of the workflow. The detailed workflow of a transformation can be viewed and manipulated in the [[transformation logic widget|Glossary#widgets]]. Transformations or functions can be instantiated/utilised by a [[Mapping|Glossary#mapping]], i.e., the (transformation) component of the mapping instantiates a transformation or functions by its parameter mapping.

* alternative names: -transformation process, transformation pipeline, transformation logic-
* note: transformation is also used in more abstract descriptions (context), where transformation refers to the transformation pipeline or logic of a mapping

### URI

A URI is a uniform resource identifier for denoting something, e.g., resources, properties or resource types.

See also [URI @ Wikipedia](http://en.wikipedia.org/wiki/URI)

### Vocabulary

A vocabulary or ontology is a set of terms (universals). Terms can be [[Attribute|Glossary#attribute]]s (properties) or [[Classes|Glossary#class]] (types).

### Widgets

Every box in the modelling perspective in the web-based UI is called a widget. The following widgets are available:
* source data
* source schema
* target schema
* target data
* transformation
* function component