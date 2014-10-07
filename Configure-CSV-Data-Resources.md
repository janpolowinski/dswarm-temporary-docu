When you have [[selected the dataset to be configured|Select Data for Schema Configuration]] you can adjust the schema of a CSV dataset by choosing the option “as CSV”  from the “Edit configuration” pop-up menu. In order to make adjustments easy, a preview of the first few rows of the CSV file is generated dynamically.

## Configuration Options

The following properties can be adjusted:

PROPERTY 			| DESCRIPTION
:-------------------------------|:----------------------------------------
Name     			| Name of the configuration
Description  			|  Description of the configuration
Choose file format  		|  End-of-file type (Unix / Windows)
Encoding  			|  Character encoding used
Field separator character  	|  Field separator used
Escape character  		|  Escape character used for masking characters so as not to be interpreted as control characters
Text enclosure character  	|  Character used for enclosing text
Define column names  		|  Defines the names of the columns (not yet implemented in the alpha release)
Ignore first ... lines at beginning of file (Checkbox)  |  Defines the number of lines to be ignored at the beginning of the imported file (e.g. because they are empty or have a deviant structure)
Discard initial ... rows of data (Checkbox)  |  Defines the number of rows to be discarded at the beginning of the dataset proper after the header row
Load at most ... rows of data (Checkbox)  |  Defines the number of rows to be loaded as test data



## Configuration Workflow

[![CSV configuration dialogue](https://github.com/seventwenty/dswarm-documentation/wiki/img/data-config-as-csv.png)](https://github.com/seventwenty/dswarm-documentation/wiki/img/data-config-as-csv.png "CSV Configuration Dialogue")

* Configure the properties of the CSV schema as needed.
* Click on “Preview” if an adjustment does not take immediate effect in the preview box.
* Save the configuration by clicking on “Save”.
* Click on “Cancel” if you want to discard your adjustments and get back to the “Data” tab.


-----------------------------------
### Alpha Release Help Step by Step

* next: [[Configure XML Data Resources]]
* previous: [[Select Data for Schema Configuration]]