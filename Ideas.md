This is a place for dumping ideas and improvements.

## [Backend](https://github.com/dswarm/dswarm)

- replace guice-H2K-bridge with:
  - new jersey-guice adapter (von Squarespace)
- replace guice persistence module:
  - new guice JPA module (Onami-Persist)
- eclipselink + connection pooling/provider? - e.g.
  - c3P0
    - -> possible via c3p0 DataSource, see here, here and here
  - eclipselink has an own connection pool (which will be utilised per default (maybe the configuration can be improved))
- upgrade:
  - jersey
  - guice ((question) - 4.x is "only" beta right (since month and the next stable release is far away))

## [knutwalker](https://github.com/knutwalker)'s Performance Analysis Conclusion ([DD-976](https://jira.slub-dresden.de/browse/DD-976))

- remove reflection for Jackson: https://github.com/FasterXML/jackson-module-afterburner =>
- remove reflection based trace logging =>
- beefier CPU
- investigate caching opportunities =>
- use (more) handwritten JSON sers/desers (with performance in mind) =>
- investigate in (likely advanced) JPA, precisely discovering ways to have it run JOIN statements (maybe we hold it wrong) =>
- use handwritten SQL/JQL queries =>
- change database (radically, like using a NoSQL/Graph store with Kundera) => 

