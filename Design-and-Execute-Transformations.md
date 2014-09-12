Data [[transformations|Glossary#transformation]] can be defined for existing [[mappings|Glossary#mapping]] only. Every mapping in a [[project|Glossary#project]] is represented by a tab in the transformation logic [[widget|Glossary#widgets]] in the lower middle. The mapping whose transformation tab is currently activated is marked red in the mapping area.

## Design of a Transformation Workflow
### Simple Transformations

([[enlarge figure|img/simple-transformations.png]])	
[[img/simple-transformations.png]]

A transformation logic can be modelled the following way:

* Select the mapping whose transformation you want to design by clicking on the respective tab in the transformation logic widget (1).
* Initially every mapping has an empty transformation in which the input [[attribute path|Glossary#attribute-path]] and the output attribute path are directly linked with each other.
* In order to design a transformation logic, drag a [[function|Glossary#function]] (2) from the  function list widget on the lower right into the grid of the transformation logic widget (3).
  * A list of [[transformation functions|Available Transformation Functions]] available in the alpha release.
  * The transformation process is visualized by arrows.
  * Drag more functions to the desired grid position in the transformation process.
  * Rearrange the order of the functions in the grid as to modify the transformation process.
* You can configure a function by clicking on its representation in the transformation logic widget (4) and entering the required parameters in the configuration widget (5).
* Enter all parameters and quit the configuration by clicking on the button “Save” (6).
* Repeat these steps for all mappings that have been defined.

__Note:__ It is not possible in the alpha release, yet, to delete a function from the transformation process once it has been added.


### Complex Transformations

Additionally, you can design complex transformations in the alpha release, e.g. concatenate two input attribute paths to one output attribute path. Within the transformation process, two data sources can be individually transformed as is suitable and eventually combined using the concat function:

([[enlarge figure|img/complex-transformations.png]])	
[[img/complex-transformations.png]]

* Drag the concat function from the function list widget (lower right) to the grid in the transformation logic widget  (lower middle).
* Clicking on the + symbol in the concat function box will open a lightbox that lets you select the component that you want to add the the attribute path ([[enlarge figure|img/add-component-to-component.png]]):

[[img/add-component-to-component.png]]
* Select the component that you want to add to the current component by clicking in the list (1).
* Click on the button “Add selected component” to quit and concat the two components to a single output attribute path (2).


### Execute Transformations

Any transformation is executable at all times:

([[enlarge figure|img/target-data.png]])

[[img/target-data.png]]

* Click on “Run _this_ transformation” (1) in order to execute the transformation logic currently displayed and view the results of the transformation executed on the sample data in the target data widget on the upper right (2).
* Click on “Run _all_ Transformations” (3) in order to execute the transformations for all mappings in the project.
* Click on “Save all transformations” (4) in order to run all transformations for the entire data resource, and save the results in the [[data hub|Glossary#data-hub]]. You can access the results via the database GUI as described in [[Graph Data Model]].