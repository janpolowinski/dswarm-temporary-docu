[![CSV configuration dialogue](https://avgl.mybalsamiq.com/mockups/2319198.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00)](https://avgl.mybalsamiq.com/mockups/2319198.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00 "CSV Configuration Dialogue")

When you have [[selected the data resource to be configured|Select Data for Schema Configuration]] you can adjust the parsing of the CSV data resource by choosing the option “as CSV”  from the “Configure ...” pop-up menu. In order to make adjustments easy, a preview of the first few rows of the CSV file is generated dynamically (1).

## Configuration Options

The following properties can be adjusted:

PROPERTY 			| DESCRIPTION
:-------------------------------|:----------------------------------------
Name (2)     	       	        |  Name of the configuration
Description (3)  		|  Description of the configuration
Choose file format (4)  	|  End-of-file type (Unix / Windows)
Encoding (5)  			|  Character encoding used
Field separator character (6)  	|  Field separator used
Escape character (7)  		|  Escape character used for masking characters so as not to be interpreted as control characters
Text enclosure character (8)  	|  Character used for enclosing text
Define column names     	|  Defines the names of the columns (not yet implemented)
Ignore first ... lines at beginning of file (Checkbox) (9) |  Defines the number of lines to be ignored at the beginning of the imported file (e.g. because they are empty or have a deviant structure)
Discard initial ... rows of data (Checkbox) (10) |  Defines the number of rows to be discarded at the beginning of the dataset proper after the header row
Load at most ... rows of data (Checkbox)  (11) |  Defines the number of rows to be loaded as test data
The first row contains column headings (Checkbox) (12) |  Can be utilised, when the header should be generated automatically (i.e., if unchecked, the header will be generated (otherwise, the first row will be interpreted as header, i.e., the schema will be derived from it))


## Configuration Workflow

* Configure the properties of the CSV schema as needed.
* Click on “Preview” (13) if an adjustment does not take immediate effect in the preview box.
* Save the configuration by clicking on “Save” (14).
* Click on “Cancel” (15) if you want to discard your adjustments and get back to the “Data” tab.


-----------------------------------
### Alpha Release Help Step by Step

* next: [[Configure XML Data Resources]]
* previous: [[Select Data for Schema Configuration]]