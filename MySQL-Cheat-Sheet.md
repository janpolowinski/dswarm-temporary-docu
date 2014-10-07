Currently, MySQL is choosen for providing the [[metadata repository|Glossary#metadata-repository]].

## Metadata Repository Schema

The figure below is produced with [[SchemaSpy|http://schemaspy.sourceforge.net/]] (that may be used to create interactive pages to visualize and explore the database schema). 

[![an image of the metadata repository schema](https://github.com/seventwenty/dswarm-documentation/wiki/img/mysql-database-schema.png)](https://github.com/seventwenty/dswarm-documentation/wiki/img/mysql-database-schema.png "Metadata Repository Schema Overview")

##  Initialize/Reset Metadata Repository DB

See [[Server Install|Server-Install#19-initializereset-database]] for initializing or resetting the database. 

## Backup Metadata Repository DB

to create a data dump, run the command

    mysqldump -udmp -pdmp --no-create-info --no-create-db --skip-triggers --skip-create-options --skip-add-drop-table --skip-lock-tables --skip-add-locks -B dmp > dswarm_dump.sql

Hint: remember to use correct user name, password and database name (see also [[setup mysql|Server-Install#6-setup-mysql]]). 