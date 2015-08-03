Our [[Graph Data Model (GDM)|Graph Data Model]] makes use of RDF concepts on top of the (more powerful) [[property graph model|Glossary#property-graph]], which allows relationships to have not only a type, but an arbitrary number of properties. Comparison by example:

<table">
<thead>
<tr>
<th> Feature </th>
<th> RDF </th>
<th> GDM </th>
</tr>
</thead>
<tr><td>resource (URI resource, bnode)</td><td>Node</td><td>Node</td></tr>
<tr><td>attribute</td><td>rdf:Property instance (predicate)</td><td>Relationship Type</td></tr>
<tr><td>statement (subject, predicate, object)</td><td>Triple </td><td>Relationship (= predicate) (incl. start node (= subject) + end node (= object))</td></tr>
<tr><td>resource identifier</td><td>URI</td><td>**uri** property of a Node + has a node label **RESOURCE** (or **TYPE_RESOURCE**)</td></tr>
<tr><td>value</td><td>Literal</td><td>**value** property of a Node + has a node label **LITERAL**</td></tr>
<tr><td>n-ary relationships/ qualified attributes of a statement</td><td>n.a. / reification</td><td>property of a Relationship, e.g. **order**, **index**, **data_model**</td></tr>
<tr><td>order (in a list, i.e., statements that have the same subject and predicate)</td><td>n.a. / reification</td><td>**order** property of a Relationship</td></tr>
<tr><td>index (absolut position of a statement in a container of statements that belong to a certain Resource (cf. CBD etc.))</td><td>n.a. / reification </td><td>**index** property of a Relationship</td></tr>
<tr><td>provenance</td><td>Named Graph</td><td>**data_model** property of a Relationship</td></tr>
</table>