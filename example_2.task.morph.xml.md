* raw: [example_2.task.morph.xml](https://raw.githubusercontent.com/wiki/dswarm/dswarm-documentation/assets/example_2.task.morph.xml)

```xml
<?xml version="1.1" encoding="UTF-8" standalone="no"?>
<metamorph xmlns="http://www.culturegraph.org/metamorph" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" entityMarker="&#30;" version="1" xsi:schemaLocation="http://www.culturegraph.org/metamorph metamorph.xsd">
    <meta>
        <name>mapping15, mapping13, mapping14</name>
    </meta>
    <rules>
        <combine flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld" includeSubEntities="true" name="@feld_value__-1416218456933__0__" reset="true" sameEntity="true" value="${feld_value__-1416218456933__0__.filtered}">
            <if>
                <all flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#ind" includeSubEntities="true" name="CONDITION_ALL" reset="true">
                    <data source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr">
                        <regexp match="202|206|210|214|218|222|226|230|234|238|242|246|250|254|258|262|266|270|274|278|282|286|290|294|298"/>
                    </data>
                    <data source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#ind">
                        <regexp match="b"/>
                    </data>
                </all>
            </if>
            <data name="feld_value__-1416218456933__0__.filtered" source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.w3.org/1999/02/22-rdf-syntax-ns#value"/>
        </combine>
        <data name="http://purl.org/dc/elements/1.1/creator" source="@__TRANSFORMATION_OUTPUT_VARIABLE__1"/>
        <data name="@__TRANSFORMATION_OUTPUT_VARIABLE__1" source="@feld_value__-1416218456933__0__">
            <compose prefix="http://swb.bsz-bw.de/PRS=default/PPNSET?PPN="/>
        </data>
        <combine flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld" includeSubEntities="true" name="@feld_value__-1416218255978__1__" reset="true" sameEntity="true" value="${feld_value__-1416218255978__1__.filtered}">
            <if>
                <all flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr" includeSubEntities="true" name="CONDITION_ALL" reset="true">
                    <data source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr">
                        <regexp match="376"/>
                    </data>
                </all>
            </if>
            <data name="feld_value__-1416218255978__1__.filtered" source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.w3.org/1999/02/22-rdf-syntax-ns#value"/>
        </combine>
        <data name="http://purl.org/ontology/bibo/shortTitle" source="@__TRANSFORMATION_OUTPUT_VARIABLE__2"/>
        <data name="@__TRANSFORMATION_OUTPUT_VARIABLE__2" source="@feld_value__-1416218255978__1__"/>
        <combine flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld" includeSubEntities="true" name="@feld_value__-1416218224591__2__" reset="true" sameEntity="true" value="${feld_value__-1416218224591__2__.filtered}">
            <if>
                <all flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr" includeSubEntities="true" name="CONDITION_ALL" reset="true">
                    <data source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr">
                        <regexp match="331"/>
                    </data>
                </all>
            </if>
            <data name="feld_value__-1416218224591__2__.filtered" source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.w3.org/1999/02/22-rdf-syntax-ns#value"/>
        </combine>
        <data name="http://purl.org/dc/elements/1.1/title" source="@__TRANSFORMATION_OUTPUT_VARIABLE__3"/>
        <data name="@__TRANSFORMATION_OUTPUT_VARIABLE__3" source="@feld_value__-1416218224591__2__"/>
    </rules>
</metamorph>
```