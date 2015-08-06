Based on the *DataHub version* of d:swarm, the following features are planned to support the improvement of data quality and structure:

[[img/dswarm-workflow-complete.png]]

## FRBRization ##
Means the conversion of flat data structures to a model of related entities implementing the FRBR standard, for example, to ensure a work is properly related to its manifestations.

## Deduplication ##
Deduplication comprises two steps: (1) Finding duplicates (only in the easiest case this can be done via a common ID) and (2) applying an appropriate strategy for merging the duplicates.

[[img/datahub-dedup-frbr.png]]

Deduplication and FRBRization needs to happen on the DataHub, since we may want to refer to data from a specific version or with a specific provenance. The cleaned data will be stored back to the DataHub.

## Filtering Statements by Context ##
A prerequisite for the above mentioned data quality procedures is the ability to filter statements by additional context, such as provenance, version or time. For example, a mapping used in a data quality procedure may need to select data based on the resource it was imported from. Versioning is necessary to easily remove unintentionally created statements.

[[img/datahub-filter-by.png]]