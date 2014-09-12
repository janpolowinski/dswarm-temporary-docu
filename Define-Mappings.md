## Mapping Workflow

([[enlarge figure|img/mapping-workflow.png]])
[[img/mapping-workflow.png]]

* Select the desired output [[schema|Glossary#schema]] by clicking on the button “Select output schema” or change the output schema by clicking on the gear wheel symbol on the upper right in the mapping panel (1).
* [[Mappings|Glossary#mapping]] are created by clicking first on a rectangle symbol in the input schema (2) and then on the respective symbol in the output schema (3).
* A dialog light box opens. Provide a name for the mapping relation (at least five characters). Confirm and close the box by clicking on the button “Name that mapping”.
* The new mapping will now be visualized by a red arrow (4).
* Repeat these steps for each mapping you want to create.

__Note:__ In the alpha release you can map to [[attributes|Glossary#attribute]] only on the first level. In the example above, you will not be able to map to “contributor/givenName” yet. You can, however, map on first-level attributes such as “title” or “shortTitle”.


## Complex Mappings

([[enlarge figure|img/complex-mappings.png]])	
[[img/complex-mappings.png]]

Complex mappings such as combining two input [[attribute paths|Glossary#attribute-path]] into one output attribute path (e.g. first name + family name) can be achieved by mapping a second input attribute path (1) to an output attribute path that has been used before (2). A light box will open:

([[enlarge figure|img/add-endpoint-to-mapping.png]])	
[[img/add-endpoint-to-mapping.png]]

* Select an existing output attribute path by clicking in the list (1).
* The button “Add to selected mapping” will be shown (2).
* Create an integrated mapping by clicking on “Add to selected mapping”.
* If multiple input attribute paths should not combined into one, you can achieve this by clicking on “New Mapping” (3). This will create two unconnected mappings.


-----------------------------------
### Alpha Release Help Step by Step

* next: [[Design and Execute Transformations]]
* previous: [[Create and Edit Projects]]
