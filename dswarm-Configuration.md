Configuration of the system
===========================

d:swarm is configured via
[typesafe config](https://github.com/typesafehub/config#readme).
The syntax — HOCON — is quite flexible and based on a mix between JSON and Java Properties (In fact, typesafe config can parse Json and properties files as well).
Please refer to the
[summary](https://github.com/typesafehub/config#using-hocon-the-json-superset) or
[documentation](https://github.com/typesafehub/config/blob/master/HOCON.md#hocon-human-optimized-config-object-notation) of
HOCON to get familiar with the format.


All keys for d:swarm are in the namespace `dswarm` and possibly further
sub-grouped by their module (e.g. `db` or `http`).

The modules `controller`, `init`, and `persistence` have a `reference.conf` and an `application.conf`
defined in their `src/main/resources` directory.
These files are merged together into a config tree, of which you can override any key.

## complete config

The following is the merged tree for all configurations, each value is the default setting.
Every part can be overridden, conveniently so by using the properties-like syntax.


    {
        "dswarm" : {

            # definitions related to swagger
            "api" : {

                # the reported base url, that is displayed in the swagger UI
                "base-url" : "http://127.0.0.1:8087/dmp",

                # the version for our API
                "version" : "1.0.1"
            },

            # settings for the persistence module
            "db" : {

                # settings for the RDBMS used for the metadata storage
                "metadata" : {

                    # the name of the JPA unit, matching the one in persistence.xml
                    "jpa-unit" : "DMPApp",

                    # if 'on', verbosely log every SQL statement
                    "log-sql" : "on",

                    "host" : "127.0.0.1",
                    "port" : 3306,
                    "schema" : "dmp",
                    "username" : "not set - override in your application.conf",
                    "password" : "not set - override in your application.conf",

                    # the JDBC URI
                    # Here you can add connection parameters, e.g. the character set to use
                    "uri" : "jdbc:mysql://127.0.0.1:3306/dmp?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true"
                },

                # settings for the GDBMS (Neo4j)
                "graph" : {

                    # URL to our Neo4j extension
                    "endpoint" : "http://localhost:7474/graph"
                }
            },

            # settings for the embedded web server
            "http" : {

                "context-path" : "/dmp",
                "host" : "127.0.0.1",
                "port" : 8087
            },

            logging {
                # log to console as well
                log-to-console = "off",

                # make a full dump of the configuration during startup (at INFO level)
                log-config-on-start = "off",

                # the application-wide log level (all dswarm logging activities)
                loglevel = "DEBUG",

                # the process-wide log level (all third-party logging activities)
                root-loglevel = "INFO
            },

            # settings for detailed montoring (ingest, execution)
            monitoring {

                # report rates (events per unit) in this unit. is a j.u.c.TimeUnit
                rate-unit = seconds,

                # report durations in this unit. is a j.u.c.TimeUnit
                duration-unit = milliseconds,

                # continuously log progress of a task every ...
                continuous-interval = 10s,
            },

            # paths to use in various places
            "paths" : {

                # the root path of the project
                "root" : ".",

                # the path for the log files
                "logging" : "./log",

                # the path for temporary files
                "tmp" : "./tmp"
            },

            # settings for metrics and statistics reporting
            "reporting" : {

                # settings for ES, the target for reporting
                "elasticsearch" : {

                    # this is the elasticsearch address, that will be used for the connection, will be generated from 'server' and 'port' below
                    "host" : "localhost:9200",

                    # the port of the HTTP endpoint of the target instance
                    "port" : 9200,

                    # the server of the target instance
                    "server" : "localhost"
                },

                # whether to actually do the reporting
                "enabled" : "on",

                # report every ...
                "interval" : "60s"
            }
        }
    }




Some of these settings are defined in terms of other settings; for example `dswarm.db.metadata.uri` is actually defined as
`"jdbc:metadata://"${dswarm.db.metadata.host}":"${dswarm.db.metadata.port}"/"${dswarm.db.metadata.schema}"?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true"`
which means, that you can either just override the setting `dswarm.db.metadata.schema` to use a different schema,
or you can override the full URI to tune the connection parameters.

The following values are such substitutions:

key  |  unresolved value
-----|--------
`dswarm.db.metadata.uri` | `"jdbc:metadata://"${dswarm.db.metadata.host}":"${dswarm.db.metadata.port}"/"${dswarm.db.metadata.schema}"?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true"`
`dswarm.reporting.elasticsearch.host` | `${dswarm.reporting.elasticsearch.server}":"${dswarm.reporting.elasticsearch.port}`
`dswarm.api.baseurl` | `"http://"${dswarm.http.host}":"${dswarm.http.port}${dswarm.http.context-path}`
`dswarm.paths.logging` | `${dswarm.paths.root}/log`
`dswarm.paths.tmp` | `${dswarm.paths.root}/tmp`


### override values

You can override any value in three ways (one of, or any of these combined — they're not mutually exclusive).

You can  put a `.conf` file anywhere and start d:swarm with the system property `config.file` pointing to this file.

You can override single keys with system properties of the same name (e.g. `-Ddswarm.db.metadata.log-sql=false`).

You can set the JNDI property `configFile` (accessible at `java:comp/env/configFile`) and point to a `.conf` file anywhere on the system.

There is actually a fourth way, where you place an `application.conf` file in your classpath, but this one is used by d:swarm itself to allow for staged resolving of substituted config values.
You can still do this, but you'll probably not be able to override any of the substituted values.

#### config.file system property

Place a file named `dswarm.conf` somewhere in your filesystem and put in the following content

    cat <<EOF>>dswarm.conf
    dswarm.db.metadata.username=foo
    dswarm.db.metadata.password=bar
    EOF

Username and password are used to access the MySQL database (hint: use same as in step `setup MySQL` in [server-insatll](server-insatll.md))
You should not put this file under version control. Name it either `dswarm.conf` or `dmp.conf`, and place it in the root directory (of project `datamanagement-platform`). These files are already ignored by git.

You can start d:swarm the following way

    datamanagement-platform/controller$ mvn exec:java

or, in case you did not place the file in the root directory, type

    datamanagement-platform/controller$ mvn exec:java -Dconfig.file=/path/to/dswarm.conf


#### single system properties

You can override any settings with the `-D` parameter to specify system properties. For example, the previous overrides could be achieved by starting d:swarm with this line as well

    mvn exec:java -Ddswarm.db.metadata.username=foo -Ddswarm.db.metadata.password=bar -Ddswarm.log-config-on-start=on

#### JNDI config

This one is the way to go when you use containers, such as tomcat, that would not allow system properties to be set.

For example, for tomcat: In your `$CATALINA_HOME`, create the file `conf/Catalina/localhost/dmp.xml`.
More general speaking, create the file `conf/<Engine>/<Host>/<App>.xml`.
`<Engine>` is likely `Catalina`, `<Host>` is likely `localhost` and d:swarm is deployed as a `dmp.war`, so `<App>` is `dmp`

Put the following content into the file

    cat <<EOF>> dmp.xml
    <Context>
      <Environment name="configFile" value="/path/to/dswarm.conf" type="java.lang.String" />
    </Context>
    EOF

`/path/to/dswarm.conf` should be the same as in the previous example, where it was specified using `-Dconfig.file`.

This is a one-time configuration for the container.

##### Notes for Tomcat

Tomcat has a [~~bug~~feature](https://issues.apache.org/bugzilla/show_bug.cgi?id=34840) where it would
remove custom configurations whenever an application is redeployed.
Unfortunately, this mean that the previous file would get deleted with every update of d:swarm.

To work around this, edit the `$CATALINA_HOME/conf/context.xml`, so that it contains the `<Environment/>` part within its `<Context/>` part.

This applies the settings for all deployed applications, though.


***

At any rate, any of these ways will override the specified values, and thus log the config on start and use foo:bar as credentials for the MySQL connection.



## Debugging your configuration

You can use the config settings `dswarm.log-config-on-start=on` when you start d:swarm.
If done so, d:swarm will log the complete configuration to the INFO loglevel stream.
The format is similar to a Json format with additional comments, how a config value was constructed and what its description is.

## Configurations for your IDE

These settings aren't strictly necessary, but will allow you to use the default run/test/debug executions as usual.

### Eclipse

Open `eclipse.ini`, go to `-vmargs` section and add the line `-Dconfig.file=/path/to/dswarm.conf`.
If this does not work for you (it didn't on Ubuntu 14.04 with neither Eclipse Kepler nor Luna) go to `Window` > `Preferences` > `Java` > `Installed JRE` edit the JRE you are currently using and enter as default VM arguments: `-Dconfig.file=/path/to/dswarm.conf`.

### Intellij IDEA

* When your project is opened, go to `Run` > `Edit Configurations...`.
* On the left hand side, open the `Defaults` sections and select `Application`, or `JUnit` for test configurations respectively.
* For the `VM Options` settings, add the config file paramter `-Dconfig.file=/path/to/dswarm.conf`

    __Note:__ The path is relative to the `Working Directory` which is probably the directory that contains your config file as well, so you can just write `-Dconfig.file=dswarm.conf`


## Migration from dmp.properties

As of datamanagement-platform commit 6d36b3bf1 (Thu Jul 24 19:12:23 2014 +0200), you need to migrate from the old configuration (dmp.properties file) to the new typesafe configuration system. Contributers starting development past commit 6d36b3bf1 can skip this section. To migrate, please perform the following steps.

1. create a `dswarm.conf` file

2. At least, specify the keys `dswarm.db.metadata.username` and `dswarm.db.metadata.password`

3. I'd advise, to also specify `db.paths.root` to point to an absolute directory. It is otherwise depending on the directory you started d:swarm from.

4. replace these old keys with their new keys, or remove them if you're OK with the defaults

    old key | new key | default value
    --------|---------|--------------
    `logging_root_path` | `dswarm.paths.logging` | `${dswarm.paths.root}/log`
    `backend_http_server_host` | `dswarm.http.host` | `"localhost"`
    `backend_http_server_port` | `dswarm.http.port` | `8087`
    `ehcache_disk_store_dir` | N/A | N/A
    `tmp_path` | `dswarm.paths.logging` | `${dswarm.paths.root}/log`
    `dmp_graph_endpoint` | `dswarm.db.graph.endpoint` | `"http://localhost:7474/graph"`
    `reporting_es_host` | `dswarm.reporting.elasticsearch` | `"localhost:9200"`
    `db.mysql.url` | `dswarm.db.metadata.uri` | `"jdbc:metadata://"${dswarm.db.metadata.host}":"${dswarm.db.metadata.port}"/"${dswarm.db.metadata.schema}"?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true"`
    `db.mysql.username` | `dswarm.db.metadata.username` | N/A
    `db.mysql.password` | `dswarm.db.metadata.password` | N/A

5. Remove all references to maven profiles in all start scripts/configurations of *backend modules* you might have. That is `mvn -PDEV ...` becomes `mvn ...`. Remember that this effects the backend only (`datamanagement-platform`), in other modules such as the unmanaged extension, maven profiles are still used.

6. At last, remove the dmp.properties file (Which might have been done already, as this step was committed via git)
