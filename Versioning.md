## Graph Matching
Graph matching algorithms and related topics are an issue that is analysed, evaluated and handled since ages in research and industry. [This mendeley group](http://www.mendeley.com/groups/4592311/graph-matching/papers/) gives the current state overview about our research re. (RDF) graph matching (and related topics). The following papers build (especially) the foundation of our graph delta algorithm:
* [Matching RDF Graphs (J. J. Carroll, 2001)](http://www.mendeley.com/c/6903521084/g/4592311/carroll-2001-matching-rdf-graphs/) (1)
* [Signing RDF Graphs (J. J. Carroll, 2003)](http://www.mendeley.com/c/6903521144/g/4592311/carroll-2003-signing-rdf-graphs/) (2)
* [A Scale-Out RDF Molecule Store for Improved Co-Identification, Querying and Inferencing (Newman et. al, 2008)](http://www.mendeley.com/c/6905388344/g/4592311/newman-a-scale-out-rdf-molecule-store-for-improved-co-identification--querying-and-inferencing/) (3)
* [Blank Node Matching and RDF/S Comparison Functions (Lantzaki et. al, 2012)](http://www.mendeley.com/c/6903521094/g/4592311/tzitzikas-2012-blank-node-matching-and-rdfs-comparison-functions/) (4)

__Here are our pre-conditions:__
* a [[GDM|Graph Data Model]] graph consists of a set of [Concise Bounded Description](http://www.w3.org/Submission/CBD/) ([RDF Molecules](http://ebiquity.umbc.edu/paper/html/id/240/), etc.) - these are our resources (i.e. records etc.)
* a CBD of resource consists of a set of statements, i.e., all statements belong to this resource (however, the subject of the statement doesn't always need to be the resource node, i.e., this is only the case for non-hierarchical resources) and this CBD belongs to certain provenance (i.e. sub graph)
* each resource is identified by an URI (i.e. there are no root nodes in a CBD that are bnodes)
* each CBD of a resource is a tree (not a graph)
* some structure information is already available explicitly, e.g., `__ORDER__` property at each statement or `__NODE_TYPE__` property at each node

__General approach:__
* we should compute the delta on basis of an abstract model (instead of a concrete representation (serialisation))
* we should primarily choose a structure-based approach (to be able to identify matching bnodes (sub graphs) in a deeper hierarchy of the CBD)
* we could utilise graph signatures (digests, hashes, ...) as pre-computing step to avoid unnecessary calculations
* we could utilise object identifier information (or other schema information) to address sub objects (i.e. requires the implementation of the 'key definition' feature)
* we could utilise hierarchy level information from the nodes

__Concrete proposal:__
* we can implement a graph delta algorithm that is based on the signature-based algorithm of (4) (see also [BNodeLand](http://83.212.169.44/bnodeland/)) and improve and adapt this algorithm to our GDM and conditions
   * the bnode signature algorithm builds the core component
   * we can add a property for the hierarchy of a statement in a CBD to reduce the size of the comparison set
   * we only need to compare resource by resource disc(i.e. retrieve the existing resource for a concrete provenance from GDBMS and compare it with the new one)

__Versioning handling (simplified):__
* add new statements
* mark removed statement as deleted
* re-assign versioning pointer (e.g. HEAD)

## Implementation

Currently, versioning is divided into 2 parts:
* one algorithm deals with calculating the delta between two [[resources|Glossary#resource]] in our GDM (see [[Delta Algorithm]])
* and the other algorithm deals with writing these deltas back to the graph, i.e., do the versioning handling (see [[Versioning Algorithm]])