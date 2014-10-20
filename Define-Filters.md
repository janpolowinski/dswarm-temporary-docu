[[Filters|Glossary#filter]] can be used for specifying the (complex) conditions of a [[transformation|Glossary#transformation]] of a [[mapping|Glossary#mapping]].

# Generic Filter Definition Workflow

A prerequisite for creating a filter is a mapping that can be selected in the transformation logic widget (lower middle).

[![open filter definition dialogue](https://avgl.mybalsamiq.com/mockups/1894561.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00)](https://avgl.mybalsamiq.com/mockups/1894561.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00 "Open Filter Definition Dialogue")

* In order to create a filter, select the mapping for which you want to define a filter rule (1).
* Click on the [[mapping input|Glossary#mapping-input]] on the left in the transformation logic pipeline (2).

A filter definition dialogue will be opened:

[![filter definition dialogue - add filter](https://avgl.mybalsamiq.com/mockups/2365646.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00)](https://avgl.mybalsamiq.com/mockups/2365646.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00 "Filter Definition Dialogue - Add Filter")

* On the left, a sample [[record|Glossary#record]] lets you test the filter rule you are going to define.
* Click on “add filter” (1) and enter your filter rule in the form next to the sample record.

[![filter definition dialogue](https://avgl.mybalsamiq.com/mockups/1838911.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00)](https://avgl.mybalsamiq.com/mockups/1838911.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00 "Filter Definition Dialogue")

* As you type (2) your rule is tested with the sample record set. If there is a match, the respective record is marked red (3).
* Click on “OK” to save and quit the filter definition dialogue (4).

__Note:__ These restrictions apply in the alpha release:

* You can change filter rules, but you cannot delete a filter rule. You can, however, accomplish a ‘deletion’ of a rule by emptying all fields.
* You cannot select a specific record set from the sample data.


-----------------------------------
### Alpha Release Help Step by Step

* next: [[Available Transformation Functions]]
* previous: [[Design and Execute Transformations]]
