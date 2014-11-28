(... a little bit of history ...)

## Introduction

Here is a small collection of sketches of different views of the [web GUI](https://github.com/dswarm/dswarm-backoffice-web) to feed and utilise the data management platform (d:swarm).

__note:__ these wireframes may differ from the current design of the backoffice web application ;)

## Overview
application layout v2:
* left-hand side: source example [[records|Glossary#record]] widget
* center: [[data mapping (overview) widget|]]
* right-hand side: target (example) records widget (which are generated via applying the [[mappings|Glossary#mapping]] and [[transformations|Glossary#transformation]])
* lower left: details of a transformation [[component|Glossary#component]] (in a transformation workflow)
* lower center: transformation workflow detail widget
* lower right: [[function|Glossary#function]]/transformation widget or list of pre-loaded mappings (e.g. filter lists)

[![backoffice - web gui - overview wireframe](https://raw.githubusercontent.com/wiki/dswarm/dswarm-documentation/assets/wireframeGUI.png)](https://raw.githubusercontent.com/wiki/dswarm/dswarm-documentation/assets/wireframeGUI.png "Backoffice - Web GUI - Overview Wireframe")
[application layout v2 as poster print](https://raw.githubusercontent.com/wiki/dswarm/dswarm-documentation/assets/application_layout_03.pdf)

### Overview with Overlay Dialogue for Filter Definition

* You can open the (overlay) [[filter|Glossary#filter]] definition dialogue via pushing the "Define filter ..." button in the detail widget of a selected filter component in the transformation workflow widget
* see also [[Filter (Facet) Definition Dialogue|]]

[![overview with overlay dialogue for filter definition](https://avgl.mybalsamiq.com/mockups/1118467.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00)](https://avgl.mybalsamiq.com/mockups/1118467.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00 "Overview with Overlay Dialogue for Filter Definition")
[application layout v2 with filter definition overlay dialogue as poster print](https://raw.githubusercontent.com/wiki/dswarm/dswarm-documentation/assets/application_layout_04.pdf)

## Data Mapping Widget

* This is the central dialogue to handle source-to-target [[schema|Glossary#schema]] mappings
* a single mapping (with its transformation), e.g. [[mapping output|Glossary#mapping-output]] is `ex:url`, can be explored and edited in a separate widget (transformation logic widget)
* each component in the transformation logic widget can bear an own dialogue, e.g., a wizard for complex filters (facets)
* figuratively you can also inspect the source code of each component (in the example below: a combination of SPARQL + SPARQL functions + SPIN + SPARQLMotion) => however, this is currently not so important for the intented target group ;)

### Example 1: 2 Complex Transformations in Detail

[![example 1: 2 complex transformations in detail](https://avgl.mybalsamiq.com/mockups/1118470.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00)](https://avgl.mybalsamiq.com/mockups/1118470.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00 "Example 1: 2 Complex Transformations in Detail")
[example 1 as poster print](https://raw.githubusercontent.com/wiki/dswarm/dswarm-documentation/assets/data_mapping_view_03.pdf)

### Example 2: One Complex Transformation with 2 Sources in Detail

[![example 2: one complex transformation with 2 sources in detail](https://avgl.mybalsamiq.com/mockups/1118471.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00)](https://avgl.mybalsamiq.com/mockups/1118471.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00 "Example 2: One Complex Transformation with 2 Sources in Detail")
[example 2 as poster print](https://raw.githubusercontent.com/wiki/dswarm/dswarm-documentation/assets/data_mapping_view_04.pdf)


### Filter (Facet) Definition Dialogue

* one can imagine a dialogue to create complex filters (facets) in the detail widget of the "graph pattern" component
* the filters will be created on the source schema
* various matching criteria can be defined on different [[attribute paths|Glossary#attribute-path]] per filter facet
* multiple filter facets can be logically combined with each other

__TODO:__ how shall we define (logical) combine operators ('AND' and 'OR' could be misleading, e.g., a 'datafield' with a 'tag' = '029' and '050' is not existing, however, different 'datafield's in a record fulfil this requirement)

#### Example 1: Filter with 2 Facets

[![filter (facet) definition dialogue](https://avgl.mybalsamiq.com/mockups/1118475.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00)](https://avgl.mybalsamiq.com/mockups/1118475.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00 "Filter (Facet) Definition Dialogue")
[filter definition dialogue as poster print](https://raw.githubusercontent.com/wiki/dswarm/dswarm-documentation/assets/facet_creation_02.pdf)

#### Example 2: Filter with 2 Facets incl. Changes in the Source Data Widget

[![example 2: filter with 2 facets pt. 1](https://avgl.mybalsamiq.com/mockups/1118472.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00)](https://avgl.mybalsamiq.com/mockups/1118472.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00 "Example 2: Filter with 2 Facets pt. 1")

[![example 2: filter with 2 facets pt. 2](https://avgl.mybalsamiq.com/mockups/1118473.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00)](https://avgl.mybalsamiq.com/mockups/1118473.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00 "Example 2: Filter with 2 Facets pt. 2")

[filter definition dialogue with source data widget pt. 1 as poster print](https://raw.githubusercontent.com/wiki/dswarm/dswarm-documentation/assets/https://raw.githubusercontent.com/wiki/dswarm/dswarm-documentation/assets/example_tree_view_pt1.pdf)

[filter definition dialogue with source data widget pt. 2 as poster print](https://raw.githubusercontent.com/wiki/dswarm/dswarm-documentation/assets/https://raw.githubusercontent.com/wiki/dswarm/dswarm-documentation/assets/example_tree_view_pt2.pdf)

## Backlog
* here all old sketches can be placed that are already dismissed (they'll just be collected for completeness)

### Overview

* application layout v1

[![application layout v1](https://avgl.mybalsamiq.com/mockups/1118464.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00)](https://avgl.mybalsamiq.com/mockups/1118464.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00 "Application Layout v1")

[application layout v1 as poster print](https://raw.githubusercontent.com/wiki/dswarm/dswarm-documentation/assets/https://raw.githubusercontent.com/wiki/dswarm/dswarm-documentation/assets/application_layout.pdf)

### Data Mapping Widget

[Data Mapping Widget with Source Data Widget](https://raw.githubusercontent.com/wiki/dswarm/dswarm-documentation/assets/https://raw.githubusercontent.com/wiki/dswarm/dswarm-documentation/assets/data_mapping_view.pdf)

[Data Mapping Widget with Source Data Widget and Transformation after Target Schema Mapping](https://raw.githubusercontent.com/wiki/dswarm/dswarm-documentation/assets/https://raw.githubusercontent.com/wiki/dswarm/dswarm-documentation/assets/data_mapping_view_02.pdf)