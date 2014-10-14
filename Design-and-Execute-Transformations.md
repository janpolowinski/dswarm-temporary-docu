Data [[transformations|Glossary#transformation]] can be defined for existing [[mappings|Glossary#mapping]] only. Every mapping in a [[project|Glossary#project]] is represented by a tab in the transformation logic [[widget|Glossary#widgets]] in the lower middle. The mapping whose transformation tab is currently activated is marked red in the mapping area.

## Design of a Transformation Workflow
### Simple Transformations

[![define simple transformation](https://avgl.mybalsamiq.com/mockups/1843685.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00)](https://avgl.mybalsamiq.com/mockups/1843685.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00 "Define Simple Transformation")

A transformation logic can be modelled the following way:

* Select the mapping whose transformation you want to design by clicking on the respective tab in the transformation logic widget (1).
* Initially every mapping has an empty transformation in which the input [[attribute path|Glossary#attribute-path]] and the output attribute path are directly linked with each other.
* In order to design a transformation logic, drag a [[function|Glossary#function]] (2) from the [[function list|Available Transformation Functions]] widget on the lower right into the grid of the transformation logic widget (3).
  * The transformation process is visualized by arrows between the [[components|Glossary#component]].
  * Drag more functions to the desired grid position in the transformation process.
  * Rearrange the order of the components in the grid as to modify the transformation process.
* You can configure a component by clicking on its representation in the transformation logic widget (4) and entering the required parameters in the configuration widget (5).
* Enter all parameters and (optionally) quit the configuration by clicking on the button “Close” (6).
* Repeat these steps for all mappings that have been defined.
* A component can be deleted by clicking the "x" (7) in the configuration widget.
* A mapping can be deleted by clicking the "x" (8) in the transformation logic widget.

### Complex Transformations

Additionally, you can design complex transformations in the alpha release, e.g. concatenate two input attribute paths to one output attribute path. Within the transformation process, two data sources can be individually transformed as is suitable and eventually combined using the ````concat```` function:

[![define complex transformation](https://avgl.mybalsamiq.com/mockups/1866963.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00)](https://avgl.mybalsamiq.com/mockups/1866963.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00 "Define Complex Transformation")

* Drag the ````concat```` function from the function list widget (lower right) to the grid in the transformation logic widget (lower middle).
* Clicking on the "+" symbol in the ````concat```` component will open a lightbox that lets you select the component that you want to add the attribute path:

[![add component to concat component](https://avgl.mybalsamiq.com/mockups/1866985.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00)](https://avgl.mybalsamiq.com/mockups/1866985.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00 "Add Component to Concat Component")

* Select the component that you want to add to the current component by clicking in the list (1).
* Click on the button “Add selected component” to quit and concat the two components to a single output attribute path (2).


### Execute Transformations

Any transformation is executable at all times:

[![transformation execution](https://github.com/seventwenty/dswarm-documentation/wiki/img/target-data.png)](https://github.com/seventwenty/dswarm-documentation/wiki/img/target-data.png "Transformation Execution")

* Click on “Run _this_ transformation” (1) in order to execute the transformation logic currently displayed and view the results of the transformation executed on the sample data in the target data widget on the upper right (2).
* Click on “Run _all_ Transformations” (3) in order to execute the transformations for all mappings in the project.
* Click on “Save all transformations” (4) in order to run all transformations for the entire data resource, and save the results in the [[data hub|Glossary#data-hub]]. You can access the results via the database GUI as described in [[Graph Data Model]].


-----------------------------------
### Alpha Release Help Step by Step

* next: [[Define Filters]]
* previous: [[Define Mappings]]
