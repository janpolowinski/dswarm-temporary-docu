[![MABxml data resource configuration](https://avgl.mybalsamiq.com/mockups/2319383.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00)](https://avgl.mybalsamiq.com/mockups/2319383.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00 "MABxml Data Resource Configuration")

When you have [[selected the data resource to be configured|Select Data for Schema Configuration]] you can (currently) explicitly define a MABXML data resource be parsed as MABXML (so that a proper MABXML schema will be assigned to it that offers a better UX and other enhancement at certain points) by choosing the option “as MABXML”  from the “Configure ...” pop-up menu. In order to make adjustments easy, a preview of the first few rows of the XML file is generated dynamically (1).

## Configuration Workflow

* In the field “XML Record Tag” (2), state the XML element name that encloses each individual record set.
* Save the configuration by clicking on “Save”.
* You can discard any changes and go back to the “Data” tab by clicking on “Cancel”.

__Notes:__ 
* If you enter an XML record tag that does not exist in the data resource or does not denote records, the resource will be imported improperly. Currently, you won't receive a notification about any errors but you can check the result by means of [[graph exploration|Graph Exploration]].
* At the moment, all XML files are interpreted as UTF-8. In case you have a file with different encoding you need to convert it to UTF-8 before importing it to d:swarm.

-----------------------------------
### Alpha Release Help Step by Step

* next: [[Create and Edit Projects]]
* previous: [[Configure CSV Data Resources]]