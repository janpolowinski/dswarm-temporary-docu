A [[graph data model|Glossary#graph-data-model]] implies the notion of [[nodes|Glossary#node]] and [[edges|Glossary#relationship]]. In the graph data model, [[statements|Glossary#statement]] are represented as directed binary graphs – they always consist of a subject __node__, a predicate __edge__ and an object __node__.

## Nodes

Nodes can be

1. a resource or the entry point of a resource,
2. part of a resource ([[BNode|Glossary#blank-node]]), i.e. a subelement of a hierarchical description of a resources, e.g. a field in a MARCXML recordset ([[record|Glossary#record]]), or
3. simple value nodes, i.e. [[literals|Glossary#literal]].

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
<td><strong>__NODETYPE__</strong></td>
<td>Nodes always have a node type (<strong>__NODETYPE__</strong>). Node types are used for orientation in the graph data model. They can be any of these:</p>
<ul>
<li>__RESOURCE__</li>
<li>__BNODE__</li>
<li>__LITERAL__</li>
<li>__TYPE_RESOURCE__</li>
<li>__TYPE_BNODE__</li>
</ul>
</td>
</tr>
<tr>
<td><strong>__URI__</strong></td>
<td>if __NODETYPE__ == __RESOURCE__</td>
</tr>
<tr>
<td><strong>__VALUE__</strong></td>
<td>if __NODETYPE__ == __LITERAL__</td>
</tr>
<tr>
<td><strong>__DATATYPE__</strong></td>
<td>if __NODETYPE__ == __LITERAL__, the literal being a typified literal</td>
</tr>
<tr>
<td><strong>__PROVENANCE__</strong></td>
<td>if __NODETYPE__ == __RESOURCE__, the node type of the node not being __TYPE_RESOURCE__</td>
</tr>
<tr>
<td><strong>__RESOURCE__</strong></td>
<td>signifies the resource belonging to the node (in case it is a literal node or BNode)</td>
</tr>
</tbody>
</table>


### Explanation

A [[record|Glossary#record]] is always a resource so the node type of the record’s entry node is **\_\_RESOURCE\_\_**. Resources or parts of resources can be typified. The types of resources are used as node labels in the graph:

* a MABXML record, for instance, is of the type ‘Datensatz’ (record, http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#datensatzType) and
* a field within the MABXML record is of the type ‘Feld’ (field, http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feldType).

[[URIs|Glossary#uri]] are used as denominators for resource identifiers, types and attributes (predicates) of [[statements|Glossary#statement]]. All edges and resource nodes have a provenance attribute (**\_\_PROVENANCE\_\_**). It references the [[data model|Glossary#data-model]] the statement or resource belongs to. Resource identifiers are connected with resource nodes by the attribute **\_\_URI\_\_**. Values of literals are connected with literal nodes by the attribute **\_\_VALUE\_\_**.


## Edges

Edges are always attributes of resources or parts of resources, e.g. mabxml:nr (http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr).

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
<td><strong>__PROVENANCE__</strong></td>
<td></td>
</tr>
<tr>
<td><strong>__RESOURCE__</strong></td>
<td><span style="color: #000000;">Signifies the resource the node belongs to (if it is, for instance, a literal node or a BNode)</span></td>
</tr>
<tr>
<td><strong>__ORDER__</strong></td>
<td><span style="color: #000000;">Signifies the &#8220;In-Elements&#8221; order of values of a certain type, e.g. &#8220;mixed XML elements&#8221;<br />
</span></td>
</tr>
<tr>
<td><strong>__INDEX__</strong></td>
<td><span style="color: #000000;">Signifies the statement index of a resource (i.e. of the original element order as occurs in XML files)</span></td>
</tr>
</tbody>
</table>