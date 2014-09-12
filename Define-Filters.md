[[Filters|Glossary#filter]] can be used for specifying the (complex) conditions of a [[transformation|Glossary#transformation]] of a [[mapping|Glossary#mapping]]

Filter Definition Workflow

A prerequisite for creating a filter is a mapping that can be selected in the transformation logic widget (lower middle).

([[enlarge figure|img/filter-definition-workflow.png]])
[[img/filter-definition-workflow.png]]

* In order to create a filter, select the mapping for which you want to define a filter rule (1).
* Click on the input [[attribute path|Glossary#attribute-path]] on the left in the transformation logic pipeline (2).

A light box will open:

([[enlarge figure|img/filter-lightbox.png]])
[[img/filter-lightbox.png]]

* In the light box on the left, a sample record set lets you test the filter rule you are going to define.
* Click on “add filter” (1) and enter your filter rule in the form next to the sample record.
* As you type (2) your rule is tested with the sample record set. If there is a match, the respective record is marked red (3).
* Add further filter rules as needed by clicking on “add filter”.
* The rules in one filter set are combined by a logical AND.
* Click on “OK” to save and quit the filter lightbox (5).

__Note:__ These restrictions apply in the alpha release:

* Filters can only be used for fields on the level as the field that is being mapped. In our example, you can map the elements _type_, _nr_, and _ind_, but not, for instance, _value_, which is on a sublevel (4).
* You can change filter rules, but you cannot delete a filter rule. You can, however, accomplish a ‘deletion’ of a rule by emptying all fields.
* You cannot select a specific record set from the sample data.
