# Database Schema

The figure below is done with [[SchemaSpy|http://schemaspy.sourceforge.net/]] (that may be used to create interactive pages to visualize and explore the database schema). 

[[enlarge figure|img/mysql_database_schema.png]]
[[img/mysql_database_schema.png]]

#  Initialize/Reset DB

See [[Server Install|Server-Install#19-initializereset-database]] for initializing or resetting the database. 

# Backup DB

to create a data dump, run the command

    mysqldump -udmp -pdmp --no-create-info --no-create-db --skip-triggers --skip-create-options --skip-add-drop-table --skip-lock-tables --skip-add-locks -B dmp > dswarm_dump.sql

Hint: remember to use correct user name, password and database name (see also [[setup mysql|Server-Install#6-setup-mysql]]. 