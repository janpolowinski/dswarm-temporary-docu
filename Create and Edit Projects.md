After [[configuring the data schema|Select Data for Schema Configuration]] you can create a [[project|Glossary#project]] in which you can define [[mappings|Glossary#mapping]] and model data [[transformations|Glossary#transformation]].

## Create Projects – Workflow 

([[enlarge figure|img/available-for-projects.png]])
[[img/available-for-projects.png]]

* Click on the tab “Data”.
* Select a data resource from the list “Available for projects” (the resource contains a configured schema) (1).
* Two buttons “Show details” and “Use for new project” will be shown.
* You can view and edit the configuration by clicking on “Show details”.
* Click on “Use for new project”  in order to create a new project. Type telling name (obligatory) and a short description of your project (optional) in the pop-up box (2) and click on “Create” (3).
* The new project will appear in the list “All projects”.


## Edit a Project – the Modelling Perspective

([[enlarge figure|img/all-projects.png]])
[[img/all-projects.png]]

* Select your project by clicking in the list “All projects” (1).
* Click on the button “Load for modelling” (2) in order to load the project in the modelling perspective.

The modelling perspective is the central d:swarm tool for defining schema mappings and model data transformations. The modelling perspective is divided in six panels and a lightbox.

([[enlarge figure|img/modeling-perspective-labeled-widgets.png]])
[[img/modeling-perspective-labeled-widgets.png]]

<table >
<thead>
<tr>
<th> Panel </th>
<th> Position </th>
<th> Description / Purpose </th>
</tr>
</thead>
<tbody>
<tr>
<td>Source Data Widget</td>
<td>Upper left (1)</td>
<td>
<ul>
<li>In order to make the modelling of <a title="d:swarm Glossary" href="Glossary#mapping">mappings</a> and <a title="d:swarm Glossary" href="Glossary#transformation">data transformations</a> easy, sample records of the configured <a title="d:swarm Glossary" href="Glossary#data-resource">data resource</a> are presented.</li>
<li>If there is more than one <a title="d:swarm Glossary" href="Glossary#record">record</a> in the resource, the first few are presented in individual tabs.
<ul>
<li><em><strong>Note:</strong> The alpha release does not allow for selection of specific records other than the first few.</em></li>
</ul>
</li>
</ul>
</td>
</tr>
<tr>
<td>Mapping Area</td>
<td>Upper middle (2)</td>
<td>
<ul>
<li>On the left of the middle panel, the input <a title="d:swarm Glossary" href="Glossary#schema">schema</a> is presented, on the right, the output schema.</li>
<li>Create your desired mapping by linking input <a title="d:swarm Glossary" href="Glossary#attribute-path">attribute paths</a> with output attribute paths.</li>
</ul>
</td>
</tr>
<tr>
<td>Target Data Widget</td>
<td>Upper right (3)</td>
<td>
<ul>
<li>Mappings and transformations in a <a title="d:swarm Glossary" href="Glossary#project">project</a> can be run singly or collectively on the sample records so that the results can be evaluated right away.</li>
</ul>
</td>
</tr>
<tr>
<td>Transformation Logic Widget</td>
<td>Lower middle (4)</td>
<td>
<ul>
<li>After defining mappings, transformation workflows can be modelled in the transformation logic widget using a set of <a title="d:swarm Glossary" href="Glossary#function">functions</a>.</li>
</ul>
</td>
</tr>
<tr>
<td>Function List Widget</td>
<td>Lower right (5)</td>
<td>
<ul>
<li>The <a href="Available-Transformation-Functions">set of functions</a> available for data transformation is shown in the function list widget.
<ul>
<li><em><strong>Note:</strong> In the alpha release, only record-centered functions are available. Future versions of d:swarm will also provide functions for integrating records from different resources (e.g. look-up functions) or for nesting transformations recursively.</em></li>
</ul>
</li>
</ul>
</td>
</tr>
<tr>
<td>Configuration Widget</td>
<td>Lower left (6)</td>
<td>
<ul>
<li>Some transformation functions require parameters. They can be configured in the configuration widget.</li>
</ul>
</td>
</tr>
<tr>
<td>Filter Widget</td>
<td>Lightbox</td>
<td>
<ul>
<li><a title="d:swarm Glossary" href="Glossary#filter">Filters</a> can be used for restricting transformations to a given specific of the input <a title="d:swarm Glossary" href="Glossary#attribute-path">attribute path</a> so that complex conditions for the execution of a transformation logic can be constructed.</li>
</ul>
</td>
</tr>
</tbody>
</table>

You can save your work at any time by clicking on the button “Save project” (on the upper left in the source data widget). Additionally, all changes will be saved  automatically. If you happen to leave the modelling perspective without manually saving your project, you will be asked to save or discard your last modifications after reloading the project.

([[enlarge figure|img/save-or-discard.png]])
[[img/save-or-discard.png]]