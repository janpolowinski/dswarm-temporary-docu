* [[GDM Domain Model|Graph-Data-Model#gdm-domain-model]]
* [[GDM in a Property Graph|Graph-Data-Model#gdm-in-a-property-graph]]
  * [[Nodes|Graph-Data-Model#nodes]]
     * [[Attributes of Nodes|Graph-Data-Model#attributes-of-nodes]]
     * [[Explanation|Graph-Data-Model#explanation]]
  * [[Edges|Graph-Data-Model#edges]]
     * [[Attributes of Edges|Graph-Data-Model#attributes-of-edges]]
  * [[See Also|Graph-Data-Model#see-also]]

# GDM Domain Model
[![gdm domain model](http://www.gliffy.com/go/publish/image/6315806/L.png)](http://www.gliffy.com/go/publish/image/6315806/L.png "GDM Domain Model")

A [[graph data model|Glossary#graph-data-model]] consists of a set of [[resources|Glossary#record]]. A resource has an identifier, e.g., an [[URI|Glossary#uri]], and is a bunch of [[statements|Glossary#statement]] that describe this resource. A statement follows the simple sentence structure: subject - predicate - object. Whereby, 
* a subject can be a reference (by identifier, i.e., URI) to a resource, i.e., it is a resource node, or a [[blank node|Glossary#blank-node]]
* a predicate is a reference (by identifier, i.e., URI) to a property
* an object can be a reference (by identifier, i.e., URI) to a resource, or a blank node or a [[literal|Glossary#literal]].

So a [[node|Glossary#node]] can be of the following types: resource, blank node or literal. A Statement can have an arbitrary number of qualified attributes, e.g., order, evidence or confidence. A resource node can refer to an arbitrary resource in a specific [[data model|Glossary#data-model]]. This opens the possibility to connect to resources between different data models.

For those familiar to RDF, we offer a [[comparison table | Comparison RDF and GDM model]] for RDF and the GDM model.

# GDM in a Property Graph

A graph data model implies the notion of nodes and [[edges|Glossary#relationship]]. In the graph data model, statements are represented as directed binary graphs – they always consist of a subject __node__, a predicate __edge__ and an object __node__.

## Nodes

Nodes can be

1. a resource or the entry point of a resource,
2. part of a resource (blank node), i.e. a subelement of a hierarchical description of a resources, e.g. a field in a MARCXML recordset (record), or
3. simple value nodes, i.e. literals.

### Attributes of Nodes

<table>
<thead>
<tr>
<th> Attribute </th>
<th> Definition </th>
</tr>
</thead>
<tbody>
<tr>
<td><strong>uri</strong></td>
<td>if node has label RESOURCE</td>
</tr>
<tr>
<td><strong>value</strong></td>
<td>if node has label LITERAL</td>
</tr>
<tr>
<td><strong>datatype</strong></td>
<td>if node has label LITERAL and the literal is a typed literal, i.e., of a certain data type, e.g., integer</td>
</tr>
<tr>
<td><strong>datamodel</strong></td>
<td>if node has label RESOURCE; indicates the data model the resource belongs to</td>
</tr>
<tr>
<td><strong>resource</strong></td>
<td>indicates the resource the node belongs to (in case it is a literal node or a blank node)</td>
</tr>
</tbody>
</table>


### Explanation

A record is always a resource so one of the labels of the record’s entry node is **RESOURCE**. Resources or parts of resources can be typed. The types of resources are used as node labels in the graph:

* a MABXML record, for instance, is of the type ‘Datensatz’ (record, http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#datensatzType) and
* a field within the MABXML record is of the type ‘Feld’ (field, http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feldType).

URIs are utilised as identifiers for resources, types and attributes (predicates) of statements. All resource nodes have a data model attribute (**datamodel**). It refers to the data model the resource belongs to. All edges hava a resource attribute (**resource**). It refers to the resource the statement belongs to. Resource identifiers are assigned to resource nodes by the attribute **uri**. Values of literals are assigned to literal nodes by the attribute **value**.


## Edges

Edges are always attributes of resources or resource parts, e.g. mabxml:nr (http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr).

### Attributes of Edges

<table>
<thead>
<tr>
<th> Attribute </th>
<th> Definition </th>
</tr>
</thead>
<tbody>
<tr>
<td><strong>resource</strong></td>
<td><span style="color: #000000;">Indicates the resource the edge belongs to</span></td>
</tr>
<tr>
<td><strong>order</strong></td>
<td><span style="color: #000000;">Signifies the &#8220;element&#8221; order of values of a certain type, e.g. &#8220;mixed XML elements&#8221;<br />
</span></td>
</tr>
<tr>
<td><strong>index</strong></td>
<td><span style="color: #000000;">Signifies the statement index of a resource (i.e. of the original element order as occurs in XML files)</span></td>
</tr>
<tr>
<td><strong>uuid</strong></td>
<td><span style="color: #000000;">Identifies a statement uniquely (in a data model)</span></td>
</tr>
<tr>
<td><strong>valid_from</strong></td>
<td><span style="color: #000000;">The version number upon this statement is valid</span></td>
</tr>
<tr>
<td><strong>valid_to</strong></td>
<td><span style="color: #000000;">The version number until this statement was valid (i.e. upon this version number the statement is invalid)</span></td>
</tr>
</tbody>
</table>

# See Also
* [[GDM Serialization Proposals|Graph Data Model Serialization]]
* [[Versioning]]