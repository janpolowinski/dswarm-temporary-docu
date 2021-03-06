[![xml data resource configuration](https://avgl.mybalsamiq.com/mockups/2319351.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00)](https://avgl.mybalsamiq.com/mockups/2319351.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00 "XML Data Resource Configuration")

When you have [[selected the data resource to be configured|Select Data for Schema Configuration]] you can adjust the parsing of an XML data resource by choosing the option “as XML”  from the “Configure ...” pop-up menu. The schema will be automatically derived from the structure of the XML data resource contained in the file. In order to make adjustments easy, a preview of the first few rows of the XML file is generated dynamically (1).

__Note:__ XSD schema parsing is not provided at this stage

## Configuration Workflow

* In the field “XML Record Tag” (2), state the XML element name that encloses each individual record set.
* Save the configuration by clicking on “Save”.
* You can discard any changes and go back to the “Data” tab by clicking on “Cancel”.

__Notes:__ 
* If you enter an XML record tag that does not exist in the data resource or does not denote records, the resource will be imported improperly. Currently, you won't receive a notification about any errors but you can check the result by means of [[graph exploration|Graph Exploration]].
* At the moment, all XML files are interpreted as UTF-8. In case you have a file with different encoding you need to convert it to UTF-8 before importing it to d:swarm.

-----------------------------------
### D:SWARM Help - Step by Step

* next: [[Configure MABXML Data Resources]]
* previous: [[Configure CSV Data Resources]]