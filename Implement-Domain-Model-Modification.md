If you would like to implement modifications (incl. additions) of the [[domain model|domain-model]] in the [backend](https://github.com/dswarm/dswarm), you first need to identify, which parts are affected from these changes, i.e., e.g. whether they are located in the [model](https://github.com/dswarm/dswarm/tree/builds/unstable/persistence/src/main/java/org/dswarm/persistence/model) package (which is valid for the majority) or somewhere else. If the entities are located or should be located in the model package, then you need to create a POJO class for them or modify an existing one. 

### POJO Classes

Since we make use of [JPA](http://en.wikibooks.org/wiki/Java_Persistence) as abstraction for persistence, you need to ensure the appropriate utilisation of the JPA annotations (you can also have a look at existing POJO classes, i.e., how they are utilised there). Furthermore, since we also make use of [Jackson](https://github.com/FasterXML/jackson) for data exchange (de-/serialisation), which can also handle [JAXB](http://wiki.fasterxml.com/JacksonJAXBAnnotations) annotations, you also need to ensure the appropriate utilisation of the Jackson/JAXB annotations (here you can also have a look at the existing POJO classes, i.e., how they are utilised there).

### Metadata Repository Schema Generation

When you've finished creating and/or modifying your POJOs in the model package, then you can re-create the schema of the [[metadata repository|Glossary#metadata-repository]] (see also [[here|mysql-cheat-sheet]]). You can simply make use of the following Maven command to generate schema script automatically (you need to call this command within the `persistence` module (directory)):

    mvn hibernate4:export

The result should be a `schema.sql` script in the `target` directory of the `persistence` module.

Afterwards, you can utilise a diff tool of your choice to compare the new schema script with the existing on in [src/main/resources](https://github.com/dswarm/dswarm/blob/builds/unstable/persistence/src/main/resources/schema.sql). Now it's getting a bit complicated (right now). You should only change (insert, remove, ...) necessary parts of the script.

1. You can skip the "alter table" part (at the beginning!) of the new script (since we make use of `SET foreign_key_checks = 0;` at the beginning of the script to unlock foreign key constraints, when processing the script (they will be enabled at the end of the script))
2. At the "drop table" part the relevant changes should be easily visible in your diff tool (i.e. often it's just the case that a new table should be dropped as well or that existing one was renamed)
3. At the following "create table" and "alter table" parts the relevant changes should also be easily visible in your diff tool (note: sometimes it's the case that the generated foreign key identifier change over the whole script - then it might be a bit difficult to just cherry pick only the new ones)

It's recommended to change smaller parts step-by-step and compare the result with the diff tool again. Generally, it's also recommended to apply all these changes to the schema script with care, since it's an essential part of the application.
