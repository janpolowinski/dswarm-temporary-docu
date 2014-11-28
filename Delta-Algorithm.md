This is the delta algorithm part for [[versioning|Versioning]] the [[GDM|Graph Data Model]].

__note:__ this algorithm is probably incomplete, contains errors or doesn't reflect the current implementation state, which is available at [dswarm-graph-neo4j](https://github.com/dswarm/dswarm-graph-neo4j/tree/master/src/main/java/org/dswarm/graph/delta); so please, take this information with care ;)

## Presteps
1. calculate delta resource-wise
2. determine legacy resource identifier via content schema
    1. try to retrieve existing model via legacy record identifier
    2. otherwise try to retrieve existing model via resource uri
3. take new resource model, if there was no match in the provenance graph for this resource identifier then we don't need to calculate the delta, since everything is new

## Calculation

### Enrichment
1. enrich working graph data models of resources (i.e. add hierarchy level + leaf)
    * do delta calculation on enriched GDM models in graph

### Matching

* note: mark matches or modifications after every step
* note: we can also follow a different strategy, i.e., all most exact steps first and the reduce this level, i.e., do for each exact level all steps first and continue afterwards (?)
* note: maybe utilise confidence value for different matching approaches

1. identify exact matches for cs entities
   1. hash with key, value(s) + entity order + value(s) order => matches complete cs entities
       * keep attention to sub entities of CS entities matching as well, i.e., we need to be able to calc a hash from sub entities of the cs entities -> note: this needs to be done as part of the the exact cs entity => see step 7
       1. utilise matched CS entities for path marking in graph (utilise non-matched CS entities to continue matching)
   2. hash with key, value + entity order + value order => matches value entities
       1. utilise matched value entities for path marking in graph (utilise non-matched value entities to continue matching)
   3. hash with key, value + entity order => matches value entities
       * => TODO
   4. hash with key, value => matches value entities
       * => TODO
2. identify modifications for cs entities
    1. hash with key + entity order + value order => matches value entities
        * utilise matched value entities for path marking in graph (utilise non-matched value entities to continue matching)
        * non-matched value entities in new resource = cs value entity additions
        * non-matched value entities in existing resource = cs value entity removals
        * utilise non-matched value entities for path marking in graph
    2. hash with key + entity order => matches value entities
        * => TODO
    3. hash with key => matches value entities
        * => TODO
3. identify exact matches of resource node-based statements
    1. with key (predicate), value + value order => matches value entities
        * utilise matched value entities for path marking in graph (utilise non-matched value entities to continue matching)
4. identify modifications of resource node-based statements
    1. with key (predicate), value + value order => matches value entities
        * utilise matched value entities for path marking in graph
        * non-matched value entities in new resource = resource node gdm value entity additions
        * non-matched value entities in existing resource = resource node gdm value entity removals
        * utilise non-matched value entities for path marking in graph
5. identify additions in new model graph
    * => see above (4.i. + 2.i.)
6. identify removals in existing model graph
    * => see above (4.i. + 2.i.)
7. identify non-matched CS entity sub graphs
    1. identify exact matches of (non-hierarchical) CS entity sub graphs
        1. key + predicate + sub graph hash + order
            * utilise matched sub graph entities for path marking in graph (utilise non-matched sub graph  entities to continue matching)
    2. identify of partial matches (paths) of (non-hierarchical) CS entity sub graphs
        1. key + predicate + sub graph leaf path hash + order
            * utilise matched sub graph leaf entities for path marking in graph (utilise non-matched sub graph leaf entities to continue matching)
    3. identify modifications of (non-hierarchical) sub graphs
        * utilise matched sub graph leaf entities for path marking in graph
        * non-matched sub graph leaf entities in new resource = sub graph leaf entity additions
        * non-matched sub graph leaf entities in existing resource = sub graph leaf entity removals

### Changeset

1. traverse resource graphs to extract changeset
2. return a changeset model (i.e. with information for add, delete, update per statement)

## Poststeps

1. write modified resources resource-wise - instead of the whole model at once (see Versioning Algorithm)