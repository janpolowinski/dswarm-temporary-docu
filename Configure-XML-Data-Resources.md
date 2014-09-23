When you have [[selected the data resource to be configured|Select Data for Schema Configuration]] you can adjust the schema of an XML data resource by choosing the option “as XML”  from the “Edit configuration” pop-up menu. The XML schema will be automatically derived from the structure of the resource contained in the file.

__Note:__ XSD schema definitions of XML files will not be automatically extracted at this stage.

## Configuration Workflow

[[img/data-config-as-xml.png]]

* In the field “XML Record Tag”, state the XML element name that encloses each individual record set.
* Save the configuration by clicking on “Save”.
* You can discard any changes and go back to the “Data” tab by clicking on “Cancel”.

__Notes:__ 
* If you enter a denominator that does not exist in the data resource or does not denote records, the resource will be imported imporperly. You will receive no notification about any errors but you can check the result by means of [[graph exploration|Graph Exploration]].
* At the moment, all XML files are interpreted as UTF-8. In case you have a file with different encoding you need to convert it to UTF-8 before importing it to d:swarm

-----------------------------------
### Alpha Release Help Step by Step

* next: [[Create and Edit Projects]]
* previous: [[Configure CSV Data Resources]]