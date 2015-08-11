Based on the *DataHub version* of d:swarm, the following features are planned to support the improvement of data quality and structure:

[[img/dswarm-workflow-complete.png]]

## Deduplication ##
Deduplication comprises two steps: (1) Finding duplicates (only in the easiest case this can be done via a common ID) and (2) applying an appropriate strategy for merging the duplicates.

## FRBRization ##
FRBRization is a process specific to the bibliographic context. It defines the conversion of flat bibliographic data structures to a model of related entities implementing the [FRBR](https://de.wikipedia.org/wiki/Functional_Requirements_for_Bibliographic_Records) standard, for example, to ensure a work is properly related to its manifestations.

[[img/datahub-dedup-frbr.png]]

Deduplication and FRBRization needs to happen on the DataHub, since we may want to refer to data from a specific version or with a specific provenance. The cleaned data will be stored back to the DataHub.

## Filtering Statements by Context ##
A prerequisite for the above mentioned data quality procedures is the ability to filter statements by additional context, such as provenance, version or time. For example, a mapping used in a data quality procedure may need to select data based on the resource it was imported from. Versioning is necessary to easily remove unintentionally created statements.

[[img/datahub-filter-by.png]]

## Community Sharing ###

While most artifacts in d:swarm are already modelled to support reuse and sharing, we are planning to make sharing a prominent feature, easily accessible from various views in the *d:swarm BackOffice*. Sharing and discussing projects, transformations and mappings with other users facing the same data management tasks should be possible. 


<!-- Further things to mention: semantic enrichment, publication as LOD (not only RDF) -->