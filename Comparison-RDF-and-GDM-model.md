The Graph Data Model (GDM) utilises RDF concepts on top of the (more powerful) property graph model, which allows relationships to have not only a type, but an arbitrary number of properties. Comparison by Example:

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
<tr><td>statement (subject, predicate, object)</td><td>Triple </td><td>Relationship (= predicate) (incl. start node (= subject) + end node (= object))</td></tr>
<tr><td>resource identifier</td><td>URI</td><td>__URI__ property of a Node + NODETYPE = __RESOURCE__ (or __TYPE_RESOURCE__)</td></tr>
<tr><td>value</td><td>Literal</td><td>__VALUE__ property of a Node + __NODETYPE = __LITERAL__</td></tr>
<tr><td>n-ary relationships/ qualified attributes of a statement</td><td>n.a. / reification</td><td>property of a Relationship, e.g. __ORDER__, __INDEX__, __PROVENANCE__</td></tr>
<tr><td>order (in a list, i.e., statements that have the same subject and predicate)</td><td>n.a. / reification</td><td>__ORDER__ property of a Relationship</td></tr>
<tr><td>index (absolut position of a statement in a container of statements that belong to a certain Resource (cf. CBD etc.))</td><td>n.a. / reification </td><td>__INDEX__ property of a Relationship</td></tr>
<tr><td>provenance</td><td>Named Graph</td><td>__PROVENANCE__ property of a Relationship</td></tr>
</table>