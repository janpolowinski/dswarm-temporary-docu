Currently, MySQL is choosen for providing the [[metadata repository|Glossary#metadata-repository]].

* Metadata repository schema:

    [![an image of the metadata repository schema](https://github.com/dswarm/dswarm-documentation/wiki/img/mysql-database-schema.png)](https://github.com/dswarm/dswarm-documentation/wiki/img/mysql-database-schema.png "Metadata Repository Schema Overview")

    The figure above is produced with [[SchemaSpy|http://schemaspy.sourceforge.net/]]. 

* Initialize/reset metadata repository: see [[Server Install|Server-Install#19-initializereset-database]] for initializing or resetting the database. 

* Backup metadata repository: to create a data dump, run the command

        mysqldump -udmp -pdmp --no-create-info --no-create-db --skip-triggers --skip-create-options --skip-add-drop-table --skip-lock-tables --skip-add-locks -B dmp > dswarm_dump.sql

    Hint: remember to utilise the correct user name, password and database name (see also [[setup mysql|Server-Install#6-setup-mysql]]). 