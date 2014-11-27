### Related Information
* input: 
  * MABxml: [[Dataset Zoologie]]
  * [[GDM|Graph Data Model]]: [[example_1.gdm.json]]
* [[task|Glossary#task]] (mappings + transformations):
  * [[example_1.task.json]]
  * Morph script: [[example_1.task.morph.xml]]
* output:
  * [[GDM|Graph Data Model]]: [[example_1.task.result.json]]

### Mappings overview table
The appending Table gives a detailed overview of the [[Mappings|Glossary#mapping]] and [[Transformations|Glossary#transformation]] which are used to prepare the first example [[Project|Glossary#project]] "[Example1](http://sdvdswarm01.slub-dresden.de/#/model/1)". 

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
<td colspan="3">"Zoologie"</td>
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
<td colspan="4" bgcolor="#D3D3D3"><center><h4>rda:publicationStatement</h4></center></td> <!-- Next Mapping \\-->
</tr>
<tr>
<td><b>MAB Source Tag(s)</b></td>
<td colspan="3">410, 412, 425</td>
</tr>
<tr>
<td rowspan="4"><b>Filter Parameter</b></td>
<tr><td colspan="3"><a href="https://avgl.mybalsamiq.com/mockups/2390983.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">feld/nr[410]/ind[_]</a></td></tr>
<tr><td colspan="3"><a href="https://avgl.mybalsamiq.com/projects/dmp/pubStatement_filter_parameter_412" target="_blank">feld/nr[412]/ind[_]</a></td></tr>
<tr><td colspan="3"><a href="https://avgl.mybalsamiq.com/mockups/2451111.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">feld/nr[425]/ind[_]</a></td></tr>
</tr>
<tr>
<td rowspan="4"><b>Transformation Input</b></b></td>
<tr><td colspan="3">"Frankfurt am Main"</td></tr>
<tr><td colspan="3">"Fischer-Taschenbuch-Verl."</td></tr>
<tr><td colspan="3">"1963"</td></tr>
</tr>
<tr>
<td rowspan="5"><b>used Transformations and Parameters</b></td>
<tr><td><b>Step</b></td><td><b>Transformation</b></td><td><b>Parameter</b></td></tr>
<tr><td>1</td><td><a href="https://avgl.mybalsamiq.com/mockups/2391130.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">compose</a></td><td>postfix: ":_"</td></tr>
<tr><td>2</td><td><a href="https://avgl.mybalsamiq.com/mockups/2391140.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">compose</a></td><td>postfix: "__"</td></tr>
<tr><td>3</td><td><a href="https://avgl.mybalsamiq.com/mockups/2391145.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">concat</a></td><td>delimiter: "__"</td></tr>
</tr>
<tr>
<td rowspan="4"><b>Transformation Output</b></td>
<tr><td>1</td><td colspan="3">"Frankfurt am Main: "</td></tr>
<tr><td>2</td><td colspan="3">"Fischer-Taschenbuch-Verl.  "</td></tr>
<tr><td>3</td><td colspan="3">"Frankfurt am Main: Fischer-Taschenbuch-Verl. 1963"</td></tr>
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
<td colspan="3">"Frankfurt am Main"</td>
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
<td colspan="3">"Fischer-Taschenbuch-Verl."</td>
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
<td colspan="3">425</td>
</tr>
<tr>
<td><b>Filter Parameter</b></td>
<td colspan="3"><a href="https://avgl.mybalsamiq.com/mockups/2451111.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">feld/nr[425]/ind[_]</a></td>
</tr>
<tr>
<td><b>Transformation Input</b></td>
<td colspan="3">"1963"</td>
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
<td colspan="3">"033314047"</td>
</tr>
<tr>
<td rowspan="3"><b>used Transformations and Parameters</b></td>
<tr><td><b>Step</b></td><td><b>Transformation</b></td><td><b>Parameter</b></td></tr>
<tr><td>1</td><td><a href="https://avgl.mybalsamiq.com/mockups/2395281.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">compose</a></td><td><p>prefix: "http://hub.culturegraph.org/about/BSZ-"</p><p>postfix: "/html"</p></td></tr>
</tr>
<tr>
<td><b>Transformation Output</b></td>
<td>1</td>
<td colspan="2"><a href="http://hub.culturegraph.org/about/BSZ-033314047/html" target="_blank">http://hub.culturegraph.org/about/BSZ-033314047/html</a></td>
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
<td colspan="3">"033314047"</td>
</tr>
<tr>
<td rowspan="3"><b>used Transformations and Parameters</b></td>
<tr><td><b>Step</b></td><td><b>Transformation</b></td><td><b>Parameter</b></td></tr>
<tr><td>1</td><td><a href="https://avgl.mybalsamiq.com/mockups/2395295.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">compose</a></td><td>prefix: "http://swb.bsz-bw.de/PRS=default/PPNSET?PPN="</td></tr>
</tr>
<tr>
<td><b>Transformation Output</b></td>
<td>1</td>
<td colspan="2"><a href="http://swb.bsz-bw.de/PRS=default/PPNSET?PPN=033314047" target="_blank">http://swb.bsz-bw.de/PRS=default/PPNSET?PPN=033314047</a></td>
</tr>
<tr>
<td><b>Target</b></td>
<td colspan="3">owl:sameAs</td>
</tr>
<tr>
<td colspan="4" bgcolor="#D3D3D3"><center><h4>bibo:isbn (10)</h4></center></td> <!-- Next Mapping \\-->
</tr>
<tr>
<td><b>MAB Source Tag(s)</b></td>
<td colspan="3">540a</td>
</tr>
<tr>
<td><b>Filter Parameter</b></td>
<td colspan="3"><a href=""><a href="https://avgl.mybalsamiq.com/mockups/2451119.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">feld/nr[540]/ind[a]</a></a></td>
</tr>
<tr>
<td><b>Transformation Input</b></td>
<td colspan="3">"ISBN 3-436-01421-4"</td>
</tr>
<tr>
<td rowspan="3"><b>used Transformations and Parameters</b></td>
<tr><td><b>Step</b></td><td><b>Transformation</b></td><td><b>Parameter</b></td></tr>
<tr><td>1</td><td><a href="https://avgl.mybalsamiq.com/mockups/2451128.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">isbn</a></td><td>"clean"</td></tr>
</tr>
<tr>
<td><b>Transformation Output</b></td>
<td>1</td>
<td colspan="2">"3436014214"</td>
</tr>
<tr>
<td><b>Target</b></td>
<td colspan="3">bibo:isbn</td>
</tr>
<tr>
<td colspan="4" bgcolor="#D3D3D3"><center><h4>bibo:isbn (13)</h4></center></td> <!-- Next Mapping \\-->
</tr>
<tr>
<td><b>MAB Source Tag(s)</b></td>
<td colspan="3">540a</td>
</tr>
<tr>
<td><b>Filter Parameter</b></td>
<td colspan="3"><a href=""><a href="https://avgl.mybalsamiq.com/mockups/2451119.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">feld/nr[540]/ind[a]</a></a></td>
</tr>
<tr>
<td><b>Transformation Input</b></td>
<td colspan="3">"ISBN 3-436-01421-4"</td>
</tr>
<tr>
<td rowspan="3"><b>used Transformations and Parameters</b></td>
<tr><td><b>Step</b></td><td><b>Transformation</b></td><td><b>Parameter</b></td></tr>
<tr><td>1</td><td><a href="https://avgl.mybalsamiq.com/mockups/2451136.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">isbn</a></td><td>"isbn13"</td></tr>
</tr>
<tr>
<td><b>Transformation Output</b></td>
<td>1</td>
<td colspan="2">"9783436014216"</td>
</tr>
<tr>
<td><b>Target</b></td>
<td colspan="3">bibo:isbn</td>
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
<td colspan="3">"ger"</td>
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
<td colspan="4" bgcolor="#D3D3D3"><center><h4>dcterms:isPartOf (1.GT)</h4></center></td> <!-- Next Mapping \\-->
</tr>
<tr>
<td><b>MAB Source Tag(s)</b></td>
<td colspan="3">453</td>
</tr>
<tr>
<td><b>Filter Parameter</b></td>
<td colspan="3"><a href="https://avgl.mybalsamiq.com/mockups/2451300.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">feld/nr[453]/ind[_]</a></td>
</tr>
<tr>
<td rowspan="2"><b>Transformation Input</b></td>
<tr><td colspan="3">"015724298"</td></tr>
</tr>
<tr>
<td rowspan="3"><b>used Transformations and Parameters</b></td>
<tr><td><b>Step</b></td><td><b>Transformation</b></td><td><b>Parameter</b></td></tr>
<tr><td>1</td><td><a href="https://avgl.mybalsamiq.com/mockups/2395593.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">compose</a></td><td>prefix: "http://swb.bsz-bw.de/PRS=default/PPNSET?PPN="</td></tr>
</tr>
<tr>
<td rowspan="2"><b>Transformation Output</b></td>
<tr><td>1</td><td colspan="2"><a href="http://swb.bsz-bw.de/PRS=default/PPNSET?PPN=015724298" target="_blank">http://swb.bsz-bw.de/PRS=default/PPNSET?PPN=015724298</a></td></tr>
</tr>
<tr>
<td><b>Target</b></td>
<td colspan="3">dcterms:isPartOf</td>
</tr>
<tr>
<td colspan="4" bgcolor="#D3D3D3"><center><h4>dcterms:isPartOf (Überordnung)</h4></center></td> <!-- Next Mapping \\-->
</tr>
<tr>
<td><b>MAB Source Tag(s)</b></td>
<td colspan="3">010</td>
</tr>
<tr>
<td><b>Filter Parameter</b></td>
<td colspan="3"><a href="https://avgl.mybalsamiq.com/mockups/2451309.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">feld/nr[010]/ind[_]</a></td>
</tr>
<tr>
<td rowspan="2"><b>Transformation Input</b></td>
<tr><td colspan="3">"011531142"</td></tr>
</tr>
<tr>
<td rowspan="3"><b>used Transformations and Parameters</b></td>
<tr><td><b>Step</b></td><td><b>Transformation</b></td><td><b>Parameter</b></td></tr>
<tr><td>1</td><td><a href="https://avgl.mybalsamiq.com/mockups/2395593.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00" target="_blank">compose</a></td><td>prefix: "http://swb.bsz-bw.de/PRS=default/PPNSET?PPN="</td></tr>
</tr>
<tr>
<td rowspan="2"><b>Transformation Output</b></td>
<tr><td>1</td><td colspan="2"><a href="http://swb.bsz-bw.de/PRS=default/PPNSET?PPN=011531142" target="_blank">http://swb.bsz-bw.de/PRS=default/PPNSET?PPN=011531142</a></td></tr>
</tr>
<tr>
<td><b>Target</b></td>
<td colspan="3">dcterms:isPartOf</td>
</tr>
</tbody>
</table>
-----------------------------------
### Alpha Release Help Step by Step

* next: [[Informationen zur Raumentwicklung]]
* previous: [[Mapping and Transformation Examples]]