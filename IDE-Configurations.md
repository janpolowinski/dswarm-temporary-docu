D:SWARM can be imported in IntelliJ IDEA and Eclipse without any special precautions.

There are, however, some settings that can help with development.

## Configuration

The `dswarm.conf` is [automatically picked up](https://github.com/dswarm/dswarm/blob/29a86a05b5a97d153a1dcfa20dbee85c5b976141/pom.xml#L135) when using maven (e.g. `mvn test`), but this is not the case when using the IDE directly.

To have the configuration automatically included, apply the following:

### IDEA

Goto `Run` > `Edit Configurations...`.
For tests, navigate to `Defaults` > `JUnit` and add the config settings (`-Dconfig.file=/your/path/to/dswarm.conf`) to `VM options`
For running Java (e.g. `EmbeddedServer.java`), navigate to `Defaults` > `Application` and add the config settings (`-Dconfig.file=/your/path/to/dswarm.conf`) to `VM options`

### Eclipse

Todo...

## Running Tests during Refactoring sessions

### IDEA

To run some tests repeatedly while some other, unrelated code is not compiling right now, goto `Run` > `Edit Configurations...`, navigate to `Defaults` > `JUnit` and change to `Before launch` section to have only `make, no error check` and not `make`.

### Eclipse

Eclipse does this out-of-the-box.

## Weaving

Our JPA Provider, eclipselink, uses [Weaving](http://www.eclipse.org/eclipselink/documentation/2.6/concepts/app_dev005.htm#CCHJEDFH) to implement optimizations and features, such as lazy loading.
Maven is [configured to apply static weaving](https://github.com/dswarm/dswarm/blob/29a86a05b5a97d153a1dcfa20dbee85c5b976141/persistence/pom.xml#L90), but this is not the case when using the IDE directly.

Since we make use of lazy loading and have tests for this, these tests must be run with some form of weaving applied to be successful.

To make use of weaving outside of maven, the eclipselink jar can be added as a javaagent to your application.
First, you have to find an eclipselink jar in your system. You can use the .m2/repository, e.g. `$HOME/.m2/repository/org/eclipse/persistence/org.eclipse.persistence.core/2.6.0/org.eclipse.persistence.core-2.6.0.jar`

### IDEA

Goto `Run` > `Edit Configurations...`.
For tests, navigate to `Defaults` > `JUnit` and add the config settings (`-javaagent:/your/path/to/eclipselink-core.jar`) to `VM options`
For running Java (e.g. `EmbeddedServer.java`), navigate to `Defaults` > `Application` and add the config settings (`-javaagent:/your/path/to/eclipselink-core.jar`) to `VM options`

### Eclipse

Todo...

