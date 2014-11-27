* raw: [example_1.task.morph.xml](https://raw.githubusercontent.com/wiki/dswarm/dswarm-documentation/assets/example_1.task.morph.xml)

```xml
<?xml version="1.1" encoding="UTF-8" standalone="no"?>
<metamorph xmlns="http://www.culturegraph.org/metamorph" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" entityMarker="&#30;" version="1" xsi:schemaLocation="http://www.culturegraph.org/metamorph metamorph.xsd">
    <meta>
        <name>mapping3, mapping4, mapping1, mapping2, mapping7, mapping8, mapping5, mapping6, mapping11, mapping12, mapping9, mapping10</name>
    </meta>
    <rules>
        <combine flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld" includeSubEntities="true" name="@feld_value__-1416217037905__0__" reset="true" sameEntity="true" value="${feld_value__-1416217037905__0__.filtered}">
            <if>
                <all flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#ind" includeSubEntities="true" name="CONDITION_ALL" reset="true">
                    <data source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr">
                        <regexp match="540"/>
                    </data>
                    <data source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#ind">
                        <regexp match="a"/>
                    </data>
                </all>
            </if>
            <data name="feld_value__-1416217037905__0__.filtered" source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.w3.org/1999/02/22-rdf-syntax-ns#value"/>
        </combine>
        <data name="http://purl.org/ontology/bibo/isbn" source="@__TRANSFORMATION_OUTPUT_VARIABLE__1"/>
        <data name="@__TRANSFORMATION_OUTPUT_VARIABLE__1" source="@feld_value__-1416217037905__0__">
            <isbn to="clean"/>
        </data>
        <combine flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld" includeSubEntities="true" name="@feld_value__-1416216434045__1__" reset="true" sameEntity="true" value="${feld_value__-1416216434045__1__.filtered}">
            <if>
                <all flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr" includeSubEntities="true" name="CONDITION_ALL" reset="true">
                    <data source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr">
                        <regexp match="331"/>
                    </data>
                </all>
            </if>
            <data name="feld_value__-1416216434045__1__.filtered" source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.w3.org/1999/02/22-rdf-syntax-ns#value"/>
        </combine>
        <data name="http://purl.org/dc/elements/1.1/title" source="@__TRANSFORMATION_OUTPUT_VARIABLE__2"/>
        <data name="@__TRANSFORMATION_OUTPUT_VARIABLE__2" source="@feld_value__-1416216434045__1__"/>
        <combine flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld" includeSubEntities="true" name="@feld_value__-1416217209299__2__" reset="true" sameEntity="true" value="${feld_value__-1416217209299__2__.filtered}">
            <if>
                <all flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr" includeSubEntities="true" name="CONDITION_ALL" reset="true">
                    <data source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr">
                        <regexp match="453"/>
                    </data>
                </all>
            </if>
            <data name="feld_value__-1416217209299__2__.filtered" source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.w3.org/1999/02/22-rdf-syntax-ns#value"/>
        </combine>
        <data name="http://purl.org/dc/terms/isPartOf" source="@__TRANSFORMATION_OUTPUT_VARIABLE__3"/>
        <data name="@__TRANSFORMATION_OUTPUT_VARIABLE__3" source="@feld_value__-1416217209299__2__">
            <compose prefix="http://swb.bsz-bw.de/PRS=default/PPNSET?PPN="/>
        </data>
        <combine flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld" includeSubEntities="true" name="@feld_value__-1416217156924__3__" reset="true" sameEntity="true" value="${feld_value__-1416217156924__3__.filtered}">
            <if>
                <all flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#ind" includeSubEntities="true" name="CONDITION_ALL" reset="true">
                    <data source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr">
                        <regexp match="037"/>
                    </data>
                    <data source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#ind">
                        <regexp match="b"/>
                    </data>
                </all>
            </if>
            <data name="feld_value__-1416217156924__3__.filtered" source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.w3.org/1999/02/22-rdf-syntax-ns#value"/>
        </combine>
        <data name="http://purl.org/dc/terms/language" source="@__TRANSFORMATION_OUTPUT_VARIABLE__4"/>
        <data name="@__TRANSFORMATION_OUTPUT_VARIABLE__4" source="@feld_value__-1416217156924__3__"/>
        <combine flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld" includeSubEntities="true" name="@feld_value__-1416217297264__4__" reset="true" sameEntity="true" value="${feld_value__-1416217297264__4__.filtered}">
            <if>
                <all flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr" includeSubEntities="true" name="CONDITION_ALL" reset="true">
                    <data source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr">
                        <regexp match="010"/>
                    </data>
                </all>
            </if>
            <data name="feld_value__-1416217297264__4__.filtered" source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.w3.org/1999/02/22-rdf-syntax-ns#value"/>
        </combine>
        <data name="http://purl.org/dc/terms/isPartOf" source="@__TRANSFORMATION_OUTPUT_VARIABLE__5"/>
        <data name="@__TRANSFORMATION_OUTPUT_VARIABLE__5" source="@feld_value__-1416217297264__4__">
            <compose prefix="http://swb.bsz-bw.de/PRS=default/PPNSET?PPN="/>
        </data>
        <combine flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld" includeSubEntities="true" name="@feld_value__-1416217088559__5__" reset="true" sameEntity="true" value="${feld_value__-1416217088559__5__.filtered}">
            <if>
                <all flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#ind" includeSubEntities="true" name="CONDITION_ALL" reset="true">
                    <data source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr">
                        <regexp match="540"/>
                    </data>
                    <data source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#ind">
                        <regexp match="a"/>
                    </data>
                </all>
            </if>
            <data name="feld_value__-1416217088559__5__.filtered" source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.w3.org/1999/02/22-rdf-syntax-ns#value"/>
        </combine>
        <data name="http://purl.org/ontology/bibo/isbn" source="@__TRANSFORMATION_OUTPUT_VARIABLE__6"/>
        <data name="@__TRANSFORMATION_OUTPUT_VARIABLE__6" source="@feld_value__-1416217088559__5__">
            <isbn to="isbn13"/>
        </data>
        <combine flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld" includeSubEntities="true" name="@feld_value__-1416216528352__6__" reset="true" sameEntity="true" value="${feld_value__-1416216528352__6__.filtered}">
            <if>
                <all flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr" includeSubEntities="true" name="CONDITION_ALL" reset="true">
                    <data source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr">
                        <regexp match="410"/>
                    </data>
                </all>
            </if>
            <data name="feld_value__-1416216528352__6__.filtered" source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.w3.org/1999/02/22-rdf-syntax-ns#value"/>
        </combine>
        <combine flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld" includeSubEntities="true" name="@feld_value__-1416216528393__6__" reset="true" sameEntity="true" value="${feld_value__-1416216528393__6__.filtered}">
            <if>
                <all flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr" includeSubEntities="true" name="CONDITION_ALL" reset="true">
                    <data source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr">
                        <regexp match="412"/>
                    </data>
                </all>
            </if>
            <data name="feld_value__-1416216528393__6__.filtered" source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.w3.org/1999/02/22-rdf-syntax-ns#value"/>
        </combine>
        <combine flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld" includeSubEntities="true" name="@feld_value__-1416216528406__6__" reset="true" sameEntity="true" value="${feld_value__-1416216528406__6__.filtered}">
            <if>
                <all flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr" includeSubEntities="true" name="CONDITION_ALL" reset="true">
                    <data source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr">
                        <regexp match="425"/>
                    </data>
                </all>
            </if>
            <data name="feld_value__-1416216528406__6__.filtered" source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.w3.org/1999/02/22-rdf-syntax-ns#value"/>
        </combine>
        <data name="http://rdvocab.info/Elements/publicationStatement" source="@__TRANSFORMATION_OUTPUT_VARIABLE__7"/>
        <data name="@component1416216539545" source="@feld_value__-1416216528352__6__">
            <compose postfix=":  "/>
        </data>
        <data name="@component1416216545251" source="@feld_value__-1416216528393__6__">
            <compose postfix="  "/>
        </data>
        <combine name="@__TRANSFORMATION_OUTPUT_VARIABLE__7" reset="true" value="${component1416216539545}  ${component1416216545251}  ${feld_value__-1416216528406__6__}">
            <data name="component1416216539545" source="@component1416216539545"/>
            <data name="component1416216545251" source="@component1416216545251"/>
            <data name="feld_value__-1416216528406__6__" source="@feld_value__-1416216528406__6__"/>
        </combine>
        <combine flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld" includeSubEntities="true" name="@feld_value__-1416216781347__7__" reset="true" sameEntity="true" value="${feld_value__-1416216781347__7__.filtered}">
            <if>
                <all flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr" includeSubEntities="true" name="CONDITION_ALL" reset="true">
                    <data source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr">
                        <regexp match="412"/>
                    </data>
                </all>
            </if>
            <data name="feld_value__-1416216781347__7__.filtered" source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.w3.org/1999/02/22-rdf-syntax-ns#value"/>
        </combine>
        <data name="http://purl.org/dc/elements/1.1/publisher" source="@__TRANSFORMATION_OUTPUT_VARIABLE__8"/>
        <data name="@__TRANSFORMATION_OUTPUT_VARIABLE__8" source="@feld_value__-1416216781347__7__"/>
        <combine flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld" includeSubEntities="true" name="@feld_value__-1416216743699__8__" reset="true" sameEntity="true" value="${feld_value__-1416216743699__8__.filtered}">
            <if>
                <all flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr" includeSubEntities="true" name="CONDITION_ALL" reset="true">
                    <data source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr">
                        <regexp match="410"/>
                    </data>
                </all>
            </if>
            <data name="feld_value__-1416216743699__8__.filtered" source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.w3.org/1999/02/22-rdf-syntax-ns#value"/>
        </combine>
        <data name="http://rdvocab.info/Elements/placeOfPublication" source="@__TRANSFORMATION_OUTPUT_VARIABLE__9"/>
        <data name="@__TRANSFORMATION_OUTPUT_VARIABLE__9" source="@feld_value__-1416216743699__8__"/>
        <combine flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld" includeSubEntities="true" name="@feld_value__-1416216966447__9__" reset="true" sameEntity="true" value="${feld_value__-1416216966447__9__.filtered}">
            <if>
                <all flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr" includeSubEntities="true" name="CONDITION_ALL" reset="true">
                    <data source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr">
                        <regexp match="001"/>
                    </data>
                </all>
            </if>
            <data name="feld_value__-1416216966447__9__.filtered" source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.w3.org/1999/02/22-rdf-syntax-ns#value"/>
        </combine>
        <data name="http://www.w3.org/2002/07/owl#sameAs" source="@__TRANSFORMATION_OUTPUT_VARIABLE__10"/>
        <data name="@__TRANSFORMATION_OUTPUT_VARIABLE__10" source="@feld_value__-1416216966447__9__">
            <compose prefix="http://swb.bsz-bw.de/PRS=default/PPNSET?PPN="/>
        </data>
        <combine flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld" includeSubEntities="true" name="@feld_value__-1416216878072__10__" reset="true" sameEntity="true" value="${feld_value__-1416216878072__10__.filtered}">
            <if>
                <all flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr" includeSubEntities="true" name="CONDITION_ALL" reset="true">
                    <data source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr">
                        <regexp match="001"/>
                    </data>
                </all>
            </if>
            <data name="feld_value__-1416216878072__10__.filtered" source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.w3.org/1999/02/22-rdf-syntax-ns#value"/>
        </combine>
        <data name="http://www.w3.org/2002/07/owl#sameAs" source="@__TRANSFORMATION_OUTPUT_VARIABLE__11"/>
        <data name="@__TRANSFORMATION_OUTPUT_VARIABLE__11" source="@feld_value__-1416216878072__10__">
            <compose postfix="/html" prefix="http://hub.culturegraph.org/about/BSZ-"/>
        </data>
        <combine flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld" includeSubEntities="true" name="@feld_value__-1416216816197__11__" reset="true" sameEntity="true" value="${feld_value__-1416216816197__11__.filtered}">
            <if>
                <all flushWith="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr" includeSubEntities="true" name="CONDITION_ALL" reset="true">
                    <data source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr">
                        <regexp match="425"/>
                    </data>
                </all>
            </if>
            <data name="feld_value__-1416216816197__11__.filtered" source="http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld&#30;http://www.w3.org/1999/02/22-rdf-syntax-ns#value"/>
        </combine>
        <data name="http://purl.org/dc/terms/issued" source="@__TRANSFORMATION_OUTPUT_VARIABLE__12"/>
        <data name="@__TRANSFORMATION_OUTPUT_VARIABLE__12" source="@feld_value__-1416216816197__11__"/>
    </rules>
</metamorph>
```