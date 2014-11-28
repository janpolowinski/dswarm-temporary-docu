This is the versioning algorithm part for [[versioning|Versioning]] the [[GDM|Graph Data Model]].

__note:__ this algorithm is probably incomplete, contains errors or doesn't reflect the current implementation state, which is available at [dswarm-graph-neo4j](https://github.com/dswarm/dswarm-graph-neo4j/tree/master/src/main/java/org/dswarm/graph/delta); so please, take this information with care ;)

1. fetch latest version from data model node (+ increase this value + update resource node (maybe at the end))
2. compare existing resource DB statements with new resource DB statements, i.e. write/follow statements ordered by index property (it might be good to also have the relationship in the permanent DB that is related to this index available)
    1. if a statement was added or deleted or the printed version doesn't equal, rewrite all following statement afterwards and deprecated the existing ones (i.e. update their valid to value) for added + modified statements utilise the current version for valid from

__TODO:__ enhance this algo description ;)
