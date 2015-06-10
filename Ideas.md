This is a place for dumping ideas and improvements.

## [Backend](https://github.com/dswarm/dswarm)

### In General

- replace guice-H2K-bridge with:
  - new jersey-guice adapter (by [Squarespace](https://github.com/Squarespace/jersey2-guice))
- replace guice persistence module:
  - new guice JPA module ([Onami-Persist](http://onami.apache.org/persist/))
- eclipselink (**done**) + connection pooling/provider? - e.g.
  - c3P0
    - -> possible via c3p0 DataSource, see [here](http://stackoverflow.com/questions/17828377/eclipselink-pooling-equivalent-to-c3po), [here](http://www.javatips.net/blog/2013/12/c3p0-connection-pooling-example?page=1) and [here](http://www.mchange.com/projects/c3p0/#using_combopooleddatasource)
  - eclipselink has an [own connection pool](http://eclipse.org/eclipselink/documentation/2.4/concepts/data_access006.htm) (which will be utilised per default (maybe the [configuration](http://eclipse.org/eclipselink/documentation/2.4/jpa/extensions/p_connection_pool.htm) can be improved))
- upgrade:
  - jersey (**done**; v2.17)
  - guice (??? - 4.x is "only" beta right (since months and [the next stable release is far away](https://groups.google.com/d/msg/google-guice/1YVpk_AXgvk/wpWRCvX86goJ))) (**done**; v4.01-dswarm)

### [knutwalker](https://github.com/knutwalker)'s Performance Analysis Conclusion ([DD-976](https://jira.slub-dresden.de/browse/DD-976))

- remove reflection for Jackson: https://github.com/FasterXML/jackson-module-afterburner => [DD-990](https://jira.slub-dresden.de/browse/DD-990)
- replace common CSV parser with [Jackson](https://github.com/FasterXML/jackson-dataformat-csv)
- remove reflection based trace logging => [DD-991](https://jira.slub-dresden.de/browse/DD-991)
- beefier CPU
- investigate caching opportunities => [DD-992](https://jira.slub-dresden.de/browse/DD-992)
- use (more) handwritten JSON sers/desers (with performance in mind) => [DD-993](https://jira.slub-dresden.de/browse/DD-993) (**done** for GDM (via Jackson Streaming API))
- investigate in (likely advanced) JPA, precisely discovering ways to have it run JOIN statements (maybe [we hold it wrong](http://www.engadget.com/2010/06/24/apple-responds-over-iphone-4-reception-issues-youre-holding-th/)) => [DD-994](https://jira.slub-dresden.de/browse/DD-994)
- use handwritten SQL/JQL queries => [DD-994](https://jira.slub-dresden.de/browse/DD-994)
- change database (radically, like using a NoSQL/Graph store with Kundera) => [DD-995](https://jira.slub-dresden.de/browse/DD-995)

