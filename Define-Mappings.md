## Mapping Workflow

[![an image of mapping widget](https://avgl.mybalsamiq.com/mockups/1839138.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00)](https://avgl.mybalsamiq.com/mockups/1839138.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00 "Mapping Widget")

* Select the desired output [[schema|Glossary#schema]] by clicking on the button “Select output schema” or change the output schema by clicking on the gear wheel symbol on the upper right in the mapping panel (1).
* [[Mappings|Glossary#mapping]] are created by clicking first on a rectangle symbol in the input schema (2) and then on the respective symbol in the output schema (3).

[![create simple mapping](https://avgl.mybalsamiq.com/mockups/2365936.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00)](https://avgl.mybalsamiq.com/mockups/2365936.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00 "Create Simple Mapping")

* A dialogue will be opened. Provide a name for the mapping (5). 
* Confirm and close the dialogue by clicking on the button “Name that mapping” (6).
* The new mapping will now be visualized by a red arrow (4).
* Repeat these steps for each mapping you want to create.

__Note:__ In the alpha release you can map to [[attributes|Glossary#attribute]] only on the first level. For example, you will not be able to map to “contributor/givenName” yet. You can, however, map on first-level attributes such as “title” or “shortTitle”.

## Complex Mappings

[![complex mapping definition pt. 1](https://avgl.mybalsamiq.com/mockups/1839281.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00)](https://avgl.mybalsamiq.com/mockups/1839281.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00 "Complex Mapping Definition pt. 1")

Complex mappings such as combining two [[mapping inputs|Glossary#mapping-input]] into one [[mapping output|Glossary#mapping-output]] (e.g. first name + family name) can be achieved by mapping a second mapping input (1) to a mapping output that has been used before (2). A dialogue will be opened:

[![complex mapping definition pt. 2](https://avgl.mybalsamiq.com/mockups/1839246.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00)](https://avgl.mybalsamiq.com/mockups/1839246.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00 "Complex Mapping Definition pt. 2")

* Select an existing mapping output by clicking in the list (1).
* The button “Add to selected mapping” will be shown (2).
* Create an integrated mapping by clicking on “Add to selected mapping”.
* If multiple mapping inputs should not be combined into one, you can achieve this by clicking on “New Mapping” (3). This will create two unconnected mappings.

## Mappings with Key Definitions

Schemata that contain a [[content schema|Glossary#content-schema]] (e.g. MABxml) can be utilised to create a mapping with a [[key definition|Glossary#key-definition]] (that acts as a filter on the mapping input). When you create a mapping starting from the value [[attribute path|Glossary#attribute-path]], e.g., 'feld > value' for MABxml, an extended mapping creation dialogue will be opened:

[![key definition dialogue](https://avgl.mybalsamiq.com/mockups/2365911.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00)](https://avgl.mybalsamiq.com/mockups/2365911.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00 "Key Definition Dialogue")

* Provide a name for the mapping as usual (1).
* Push the "+" ("Add a key definition") button (2) to add a key (that should be utilised to restrict the range of the values of the mapping input).
* Enter the values for the specific key attribute paths (3).
* Confirm and close the dialogue by clicking on the button “Name that mapping” (4).

__Note:__ You can view and/or modify the key definitions as described in [[Define Filters|Glossary#define-filters]].

-----------------------------------
### Alpha Release Help Step by Step

* next: [[Design and Execute Transformations]]
* previous: [[Create and Edit Projects]]
