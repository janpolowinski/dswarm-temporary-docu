### Related Information
* source: 
  * MABxml: [[Dataset Informationen zur Raumentwicklung]]
* [[GDM|Graph Data Model]]: [[example_2.gdm.json]]
  * RDF: [[example_2.source.ttl]]
[![example 2 - source graph data model](https://raw.githubusercontent.com/wiki/dswarm/dswarm-documentation/assets/example_2.source.gdm.png)](https://raw.githubusercontent.com/wiki/dswarm/dswarm-documentation/assets/example_2.source.gdm.png "Example 2 - Source GDM")
  * Cypher: 
```cypher
START n=node:resources(__URI__="http://data.slub-dresden.de/datamodels/5/records/911c43ff-df20-4938-803c-2a7514900751")
MATCH (n)-[r*]->(m)
WHERE n.__DATA_MODEL__="http://data.slub-dresden.de/datamodel/5/data"
RETURN n, r, m;
```
* [[task|Glossary#task]] (mappings + transformations):
  * [[example_2.task.json]]
  * Morph script: [[example_2.task.morph.xml]]
* output:
  * [[GDM|Graph Data Model]]: [[example_2.task.result.json]]
[![example 2 - target graph data model](https://raw.githubusercontent.com/wiki/dswarm/dswarm-documentation/assets/example_2.target.gdm.png)](https://raw.githubusercontent.com/wiki/dswarm/dswarm-documentation/assets/example_2.target.gdm.png "Example 2 - Target GDM")
  * Cypher:
```cypher
START n=node:resources(__URI__="http://data.slub-dresden.de/datamodels/5/records/911c43ff-df20-4938-803c-2a7514900751")
MATCH (n)-[r*]->(m)
WHERE n.__DATA_MODEL__="http://data.slub-dresden.de/datamodel/2/data"
RETURN n, r, m;
```
* export:
  * RDF: [[example_1_and_2.target.ttl]] (includes records of both examples in target [[data model|Glossary#data-model]])

### Mappings Overview
The appending Table gives a detailed overview of the [[Mappings|Glossary#mapping]] and [[Transformations|Glossary#transformation]] which are used to prepare the first example [[Project|Glossary#project]] "[Example2](http://sdvdswarm01.slub-dresden.de/#/model/2)". 

<table>
<tbody>
<tr>
<td colspan="4" bgcolor="#D3D3D3"><center><h4>dc:title</h4></center></td> <!-- Next Mapping \\-->
</tr>
<tr>
<td><b>MAB Source Tag(s)</b></td>
<td colspan="3">331</td>
</tr>
<tr>
<td><b>Filter Parameter</b></td>
<td colspan="3"><a href="https://avgl.mybalsamiq.com/mockups/2390583.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">feld/nr[331]/ind[_]</a></td>
</tr>
<tr>
<td><b>Transformation Input</b></td>
<td colspan="3">Informationen zur Raumentwicklung</td>
</tr>
<tr>
<td rowspan="3"><b>used Transformations and Parameters</b></td>
<tr><td><b>Step</b></td><td><b>Transformation</b></td><td><b>Parameter</b></td></tr>
<tr><td>-</td><td>-</td><td>-</td></tr>
</tr>
<tr>
<td><b>Transformation Output</b></td>
<td>-</td>
<td colspan="2">-</td>
</tr>
<tr>
<td><b>Target</b></td>
<td colspan="3">dc:title</td>
</tr>
<tr>
<td colspan="4" bgcolor="#D3D3D3"><center><h4>bibo:shortTitle</h4></center></td> <!-- Next Mapping \\-->
</tr>
<tr>
<td><b>MAB Source Tag(s)</b></td>
<td colspan="3">376</td>
</tr>
<tr>
<td><b>Filter Parameter</b></td>
<td colspan="3"><a href="https://avgl.mybalsamiq.com/mockups/2390629.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">feld/nr[376]/ind[_]</a></td>
</tr>
<tr>
<td><b>Transformation Input</b></td>
<td colspan="3"><p>Inf. Raumentwickl.</p><p>Inform.Raumentwickl., Bonn</p><p>INRAD</p></td>
</tr>
<tr>
<td rowspan="3"><b>used Transformations and Parameters</b></td>
<tr><td><b>Step</b></td><td><b>Transformation</b></td><td><b>Parameter</b></td></tr>
<tr><td>-</td><td>-</td><td>-</td></tr>
</tr>
<tr>
<td><b>Transformation Output</b></td>
<td>-</td>
<td colspan="2">-</td>
</tr>
<tr>
<td><b>Target</b></td>
<td colspan="3">bibo:shortTitle</td>
</tr>
<tr>
<td colspan="4" bgcolor="#D3D3D3"><center><h4>dcterms:creator</h4></center></td> <!-- Next Mapping \\-->
</tr>
<tr>
<td><b>MAB Source Tag(s)</b></td>
<td colspan="3">202b, 206b, 210b, ...</td>
</tr>
<tr>
<td><b>Filter Parameter</b></td>
<td colspan="3"><a href="https://avgl.mybalsamiq.com/mockups/2390954.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">feld/nr[202|206|208]/ind[b]</a></td>
</tr>
<tr>
<td><b>Transformation Input</b></td>
<td colspan="3"><p>191147060</p><p>196824524</p><p>303505982</p></td>
</tr>
<tr>
<td rowspan="3"><b>used Transformations and Parameters</b></td>
<tr><td><b>Step</b></td><td><b>Transformation</b></td><td><b>Parameter</b></td></tr>
<tr><td>1</td><td><a href="https://avgl.mybalsamiq.com/mockups/2391305.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">compose</a></td><td>prefix: "http://swb.bsz-bw.de/PRS=default/PPNSET?PPN="</td></tr>
</tr>
<tr>
<td><b>Transformation Output</b></td>
<td>1</td>
<td colspan="2"><p><a href="http://swb.bsz-bw.de/PRS=default/PPNSET?PPN=191147060" target="_blank">http://swb.bsz-bw.de/PRS=default/PPNSET?PPN=191147060</a></p><p><a href="http://swb.bsz-bw.de/PRS=default/PPNSET?PPN=196824524" target="_blank">http://swb.bsz-bw.de/PRS=default/PPNSET?PPN=196824524</a></p><p><a href="http://swb.bsz-bw.de/PRS=default/PPNSET?PPN=303505982" target="_blank">http://swb.bsz-bw.de/PRS=default/PPNSET?PPN=303505982</a></p></td>
</tr>
<tr>
<td><b>Target</b></td>
<td colspan="3">dcterms:creator</td>
</tr>
<tr>
<td colspan="4" bgcolor="#D3D3D3"><center><h4>rda:publicationStatement</h4></center></td> <!-- Next Mapping \\-->
</tr>
<tr>
<td><b>MAB Source Tag(s)</b></td>
<td colspan="3">410, 412, 405</td>
</tr>
<tr>
<td rowspan="4"><b>Filter Parameter</b></td>
<tr><td colspan="3"><a href="https://avgl.mybalsamiq.com/mockups/2390983.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">feld/nr[410]/ind[_]</a></td></tr>
<tr><td colspan="3"><a href="https://avgl.mybalsamiq.com/projects/dmp/pubStatement_filter_parameter_412" target="_blank">feld/nr[412]/ind[_]</a></td></tr>
<tr><td colspan="3"><a href="https://avgl.mybalsamiq.com/mockups/2391110.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">feld/nr[405]/ind[_]</a></td></tr>
</tr>
<tr>
<td rowspan="4"><b>Transformation Input</b></b></td>
<tr><td colspan="3">Stuttgart</td></tr>
<tr><td colspan="3">Steiner</td></tr>
<tr><td colspan="3">1974 -</td></tr>
</tr>
<tr>
<td rowspan="5"><b>used Transformations and Parameters</b></td>
<tr><td><b>Step</b></td><td><b>Transformation</b></td><td><b>Parameter</b></td></tr>
<tr><td>1</td><td><a href="https://avgl.mybalsamiq.com/mockups/2391130.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">compose</a></td><td>postfix: ":_"</td></tr>
<tr><td>2</td><td><a href="https://avgl.mybalsamiq.com/mockups/2391140.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">compose</a></td><td>postfix: "__"</td></tr>
<tr><td>3</td><td><a href="https://avgl.mybalsamiq.com/mockups/2391145.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">concat</a></td><td>-</td></tr>
</tr>
<tr>
<td rowspan="4"><b>Transformation Output</b></td>
<tr><td>1</td><td colspan="3">Stuttgart: </td></tr>
<tr><td>2</td><td colspan="3">Steiner  </td></tr>
<tr><td>3</td><td colspan="3">Stuttgart: Steiner 1974-</td></tr>
</tr>
<tr>
<td><b>Target</b></td>
<td colspan="3">rda:publicationStatement</td>
</tr>
<tr>
<td colspan="4" bgcolor="#D3D3D3"><center><h4>rda:placeOfPublication</h4></center></td> <!-- Next Mapping \\-->
</tr>
<tr>
<td><b>MAB Source Tag(s)</b></td>
<td colspan="3">410</td>
</tr>
<tr>
<td><b>Filter Parameter</b></td>
<td colspan="3"><a href="https://avgl.mybalsamiq.com/mockups/2391196.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">feld/nr[410]/ind[_]</a></td>
</tr>
<tr>
<td><b>Transformation Input</b></td>
<td colspan="3">Stuttgart</td>
</tr>
<tr>
<td rowspan="3"><b>used Transformations and Parameters</b></td>
<tr><td><b>Step</b></td><td><b>Transformation</b></td><td><b>Parameter</b></td></tr>
<tr><td>-</td><td>-</td><td>-</td></tr>
</tr>
<tr>
<td><b>Transformation Output</b></td>
<td>-</td>
<td colspan="2">-</td>
</tr>
<tr>
<td><b>Target</b></td>
<td colspan="3">rda:placeOfPublication</td>
</tr>
<tr>
<td colspan="4" bgcolor="#D3D3D3"><center><h4>dc:publisher</h4></center></td> <!-- Next Mapping \\-->
</tr>
<tr>
<td><b>MAB Source Tag(s)</b></td>
<td colspan="3">412</td>
</tr>
<tr>
<td><b>Filter Parameter</b></td>
<td colspan="3"><a href="https://avgl.mybalsamiq.com/mockups/2391227.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">feld/nr[412]/ind[_]</a></td>
</tr>
<tr>
<td><b>Transformation Input</b></td>
<td colspan="3">Steiner</td>
</tr>
<tr>
<td rowspan="3"><b>used Transformations and Parameters</b></td>
<tr><td><b>Step</b></td><td><b>Transformation</b></td><td><b>Parameter</b></td></tr>
<tr><td>-</td><td>-</td><td>-</td></tr>
</tr>
<tr>
<td><b>Transformation Output</b></td>
<td>-</td>
<td colspan="2">-</td>
</tr>
<tr>
<td><b>Target</b></td>
<td colspan="3">dc:publisher</td>
</tr>
<tr>
<td colspan="4" bgcolor="#D3D3D3"><center><h4>dcterms:issued</h4></center></td> <!-- Next Mapping \\-->
</tr>
<tr>
<td><b>MAB Source Tag(s)</b></td>
<td colspan="3">405</td>
</tr>
<tr>
<td><b>Filter Parameter</b></td>
<td colspan="3"><a href="https://avgl.mybalsamiq.com/mockups/2391239.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">feld/nr[405]/ind[_]</a></td>
</tr>
<tr>
<td><b>Transformation Input</b></td>
<td colspan="3">1974-</td>
</tr>
<tr>
<td rowspan="3"><b>used Transformations and Parameters</b></td>
<tr><td><b>Step</b></td><td><b>Transformation</b></td><td><b>Parameter</b></td></tr>
<tr><td>-</td><td>-</td><td>-</td></tr>
</tr>
<tr>
<td><b>Transformation Output</b></td>
<td>-</td>
<td colspan="2">-</td>
</tr>
<tr>
<td><b>Target</b></td>
<td colspan="3">dcterms:issued</td>
</tr>
<tr>
<td colspan="4" bgcolor="#D3D3D3"><center><h4>owl:sameAs (culturegraph)</h4></center></td> <!-- Next Mapping \\-->
</tr>
<tr>
<td><b>MAB Source Tag(s)</b></td>
<td colspan="3">001</td>
</tr>
<tr>
<td><b>Filter Parameter</b></td>
<td colspan="3"><a href="https://avgl.mybalsamiq.com/mockups/2395233.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">feld/nr[001]/ind[_]</a></td>
</tr>
<tr>
<td><b>Transformation Input</b></td>
<td colspan="3">"014788373"</td>
</tr>
<tr>
<td rowspan="3"><b>used Transformations and Parameters</b></td>
<tr><td><b>Step</b></td><td><b>Transformation</b></td><td><b>Parameter</b></td></tr>
<tr><td>1</td><td><a href="https://avgl.mybalsamiq.com/mockups/2395281.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">compose</a></td><td><p>prefix: "http://hub.culturegraph.org/about/BSZ-"</p><p>postfix: "/html"</p></td></tr>
</tr>
<tr>
<td><b>Transformation Output</b></td>
<td>1</td>
<td colspan="2"><a href="http://hub.culturegraph.org/about/BSZ-014788373/html" target="_blank">http://hub.culturegraph.org/about/BSZ-014788373/html</a></td>
</tr>
<tr>
<td><b>Target</b></td>
<td colspan="3">owl:sameAs</td>
</tr>
<tr>
<td colspan="4" bgcolor="#D3D3D3"><center><h4>owl:sameAs (SWB)</h4></center></td> <!-- Next Mapping \\-->
</tr>
<tr>
<td><b>MAB Source Tag(s)</b></td>
<td colspan="3">001</td>
</tr>
<tr>
<td><b>Filter Parameter</b></td>
<td colspan="3"><a href="https://avgl.mybalsamiq.com/mockups/2395233.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">feld/nr[001]/ind[_]</a></td>
</tr>
<tr>
<td><b>Transformation Input</b></td>
<td colspan="3">"014788373"</td>
</tr>
<tr>
<td rowspan="3"><b>used Transformations and Parameters</b></td>
<tr><td><b>Step</b></td><td><b>Transformation</b></td><td><b>Parameter</b></td></tr>
<tr><td>1</td><td><a href="https://avgl.mybalsamiq.com/mockups/2395295.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">compose</a></td><td>prefix: "http://swb.bsz-bw.de/PRS=default/PPNSET?PPN="</td></tr>
</tr>
<tr>
<td><b>Transformation Output</b></td>
<td>1</td>
<td colspan="2"><a href="http://swb.bsz-bw.de/PRS=default/PPNSET?PPN=014788373" target="_blank">http://swb.bsz-bw.de/PRS=default/PPNSET?PPN=014788373</a></td>
</tr>
<tr>
<td><b>Target</b></td>
<td colspan="3">owl:sameAs</td>
</tr>
<tr>
<td colspan="4" bgcolor="#D3D3D3"><center><h4>owl:sameAs (ZDB)</h4></center></td> <!-- Next Mapping \\-->
</tr>
<tr>
<td><b>MAB Source Tag(s)</b></td>
<td colspan="3">025z</td>
</tr>
<tr>
<td><b>Filter Parameter</b></td>
<td colspan="3"><a href="https://avgl.mybalsamiq.com/mockups/2395310.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">feld/nr[025]/ind[z]</a></td>
</tr>
<tr>
<td><b>Transformation Input</b></td>
<td colspan="3">"187730-6"</td>
</tr>
<tr>
<td rowspan="3"><b>used Transformations and Parameters</b></td>
<tr><td><b>Step</b></td><td><b>Transformation</b></td><td><b>Parameter</b></td></tr>
<tr><td>1</td><td><a href="https://avgl.mybalsamiq.com/mockups/2395312.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">compose</a></td><td><p>prefix: "http://lobid.org/resource/ZDB"</p><p>postfix: "/about"</p></td></tr>
</tr>
<tr>
<td><b>Transformation Output</b></td>
<td>1</td>
<td colspan="2"><a href="http://lobid.org/resource/ZDB187730-6/about" target="_blank">http://lobid.org/resource/ZDB187730-6/about</a></td>
</tr>
<tr>
<td><b>Target</b></td>
<td colspan="3">owl:sameAs</td>
</tr>
<tr>
<td colspan="4" bgcolor="#D3D3D3"><center><h4>bibo:issn</h4></center></td> <!-- Next Mapping \\-->
</tr>
<tr>
<td><b>MAB Source Tag(s)</b></td>
<td colspan="3">542a</td>
</tr>
<tr>
<td><b>Filter Parameter</b></td>
<td colspan="3"><a href=""><a href="https://avgl.mybalsamiq.com/mockups/2395381.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">feld/nr[542]/ind[a]</a></a></td>
</tr>
<tr>
<td><b>Transformation Input</b></td>
<td colspan="3"><p>ISSN 0303-2493</p><p>ISSN 0303-2493 = Informationen zur Raumentwicklung</p></td>
</tr>
<tr>
<td rowspan="3"><b>used Transformations and Parameters</b></td>
<tr><td><b>Step</b></td><td><b>Transformation</b></td><td><b>Parameter</b></td></tr>
<tr><td>-</td><td>-</td><td>-</td></tr>
</tr>
<tr>
<td><b>Transformation Output</b></td>
<td>-</td>
<td colspan="2">-</td>
</tr>
<tr>
<td><b>Target</b></td>
<td colspan="3">bibo:issn</td>
</tr>
<tr>
<td colspan="4" bgcolor="#D3D3D3"><center><h4>dcterms:language</h4></center></td> <!-- Next Mapping \\-->
</tr>
<tr>
<td><b>MAB Source Tag(s)</b></td>
<td colspan="3">037b</td>
</tr>
<tr>
<td><b>Filter Parameter</b></td>
<td colspan="3"><a href="https://avgl.mybalsamiq.com/mockups/2395383.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">feld/nr[037]/ind[b]</a></td>
</tr>
<tr>
<td><b>Transformation Input</b></td>
<td colspan="3">ger</td>
</tr>
<tr>
<td rowspan="3"><b>used Transformations and Parameters</b></td>
<tr><td><b>Step</b></td><td><b>Transformation</b></td><td><b>Parameter</b></td></tr>
<tr><td>-</td><td>-</td><td>-</td></tr>
</tr>
<tr>
<td><b>Transformation Output</b></td>
<td>-</td>
<td colspan="2">-</td>
</tr>
<tr>
<td><b>Target</b></td>
<td colspan="3">dcterms:language</td>
</tr>
<tr>
<td colspan="4" bgcolor="#D3D3D3"><center><h4>dcterms:isFormatOf (ZDB)</h4></center></td> <!-- Next Mapping \\-->
</tr>
<tr>
<td><b>MAB Source Tag(s)</b></td>
<td colspan="3">527y</td>
</tr>
<tr>
<td><b>Filter Parameter</b></td>
<td colspan="3"><a href="https://avgl.mybalsamiq.com/mockups/2395465.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">feld/nr[527]/ind[y]</a></td>
</tr>
<tr>
<td rowspan="2"><b>Transformation Input</b></td>
<tr><td colspan="3">"24407033            Online-Ausg.: ‡Informationen zur Raumentwicklung"</td></tr>
</tr>
<tr>
<td rowspan="5"><b>used Transformations and Parameters</b></td>
<tr><td><b>Step</b></td><td><b>Transformation</b></td><td><b>Parameter</b></td></tr>
<tr><td>1</td><td><a href="https://avgl.mybalsamiq.com/mockups/2395472.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">replace</a></td><td><p>pattern: "^([^\s]+)\s.+"</p><p>with: "$1"</p></td></tr>
<tr><td>2</td><td><a href="https://avgl.mybalsamiq.com/mockups/2395474.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">replace</a></td><td><p>pattern: "^(.+)(\d)$"</p><p>with: "$1\-$2"</p></td></tr>
<tr><td>3</td><td><a href="https://avgl.mybalsamiq.com/mockups/2395478.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">compose</a></td><td><p>prefix: "http://ld.zdb-services.de/data/"</p><p>postfix: ".html"</p></td></tr>
</tr>
<tr>
<td rowspan="4"><b>Transformation Output</b></td>
<tr><td>1</td><td colspan="2">"24407033"</td></tr>
<tr><td>2</td><td colspan="2">"2440703-3"</td></tr>
<tr><td>3</td><td colspan="2"><a href="http://ld.zdb-services.de/data/2440703-3.html" target="_blank">http://ld.zdb-services.de/data/2440703-3.html</a></td></tr>
</tr>
<tr>
<td><b>Target</b></td>
<td colspan="3">dcterms:isFormatOf</td>
</tr>
<tr>
<td colspan="4" bgcolor="#D3D3D3"><center><h4>dcterms:isFormatOf (SWB)</h4></center></td> <!-- Next Mapping \\-->
</tr>
<tr>
<td><b>MAB Source Tag(s)</b></td>
<td colspan="3">077a</td>
</tr>
<tr>
<td><b>Filter Parameter</b></td>
<td colspan="3"><a href="https://avgl.mybalsamiq.com/mockups/2395580.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">feld/nr[077]/ind[a]</a></td>
</tr>
<tr>
<td rowspan="2"><b>Transformation Input</b></td>
<tr><td colspan="3">"284749591           Online-Ausg.: ‡Informationen zur Raumentwicklung"</td></tr>
</tr>
<tr>
<td rowspan="4"><b>used Transformations and Parameters</b></td>
<tr><td><b>Step</b></td><td><b>Transformation</b></td><td><b>Parameter</b></td></tr>
<tr><td>1</td><td><a href="https://avgl.mybalsamiq.com/mockups/2395472.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">replace</a></td><td><p>pattern: "^([^\s]+)\s.+"</p><p>with: "$1"</p></td></tr>
<tr><td>2</td><td><a href="https://avgl.mybalsamiq.com/mockups/2395593.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">compose</a></td><td>prefix: "http://swb.bsz-bw.de/PRS=default/PPNSET?PPN="</td></tr>
</tr>
<tr>
<td rowspan="3"><b>Transformation Output</b></td>
<tr><td>1</td><td colspan="2">"284749591"</td></tr>
<tr><td>2</td><td colspan="2"><a href="http://swb.bsz-bw.de/PRS=default/PPNSET?PPN=284749591" target="_blank">http://swb.bsz-bw.de/PRS=default/PPNSET?PPN=284749591</a></td></tr>
</tr>
<tr>
<td><b>Target</b></td>
<td colspan="3">dcterms:isFormatOf</td>
</tr>
<tr>
<td colspan="4" bgcolor="#D3D3D3"><center><h4>rda:precededBy (ZDB)</h4></center></td> <!-- Next Mapping \\-->
</tr>
<tr>
<td><b>MAB Source Tag(s)</b></td>
<td colspan="3">531z</td>
</tr>
<tr>
<td><b>Filter Parameter</b></td>
<td colspan="3"><a href="https://avgl.mybalsamiq.com/mockups/2395671.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">feld/nr[531]/ind[z]</a></td>
</tr>
<tr>
<td rowspan="2"><b>Transformation Input</b></td>
<tr><td colspan="3"><p>"9592489             Vorg.: ‡Institut für Raumordnung <Bonn>: Informationen / Institut für Raumordnung, Bonn"</p><p>"9593779             Vorg.: ‡Institut für Landeskunde <Bonn>: Rundbrief / Institut für Landeskunde"</p></td></tr>
</tr>
<tr>
<td rowspan="4"><b>used Transformations and Parameters</b></td>
<tr><td><b>Step</b></td><td><b>Transformation</b></td><td><b>Parameter</b></td></tr>
<tr><td>1</td><td><a href="https://avgl.mybalsamiq.com/mockups/2395472.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">replace</a></td><td><p>pattern: "^([^\s]+)\s.+"</p><p>with: "$1"</p></td></tr>
<tr><td>2</td><td><a href="https://avgl.mybalsamiq.com/mockups/2395675.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">compose</a></td><td><p>prefix: "http://ld.zdb-services.de/data/"</p><p>postfix: ".html"</p></td></tr>
</tr>
<tr>
<td rowspan="3"><b>Transformation Output</b></td>
<tr><td>1</td><td colspan="2"><p>"9592489"</p><p>"9593779"</p></td></tr>
<tr><td>2</td><td colspan="2"><p><a href="http://ld.zdb-services.de/data/9592489.html" target="_blank">http://ld.zdb-services.de/data/9592489.html</a></p><p><a href="http://ld.zdb-services.de/data/9593779.html" target="_blank">http://ld.zdb-services.de/data/9593779.html</a></p></td></tr>
</tr>
<tr>
<td><b>Target</b></td>
<td colspan="3">rda:precededBy</td>
</tr>
</tbody>
</table>


-----------------------------------
### Alpha Release Help Step by Step

* next: [[Zoologie]]
* previous: [[Mapping and Transformation Examples]]