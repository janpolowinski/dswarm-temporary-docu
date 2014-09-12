Data in the [[data hub|Glossary#data-hub]] can be exported to a file in the [[N-Quads format|http://sw.deri.org/2008/07/n-quads/]].

## Export Workflow

The export function can be accessed on the tab “Data”.

([[enlarge figure|img/export-workflow.png]])
[[img/export-workflow.png]]

* Click on the drop-down button “Export All Data” at the bottom of the data tab.
  * __Note__: The alpha release supports exporting data in the N-Quads format. Further formats will be added in future releases.
* Click on “N-Quads” to open the browser’s save dialogue and specify a location and a filename for the export.

__Note:__
* In the alpha release, all data in the data hub will be exported. An export generator for specifying a selection of data to be exported will be available in future releases (cf. [[d:swarm Roadmap|Roadmap]]).
* URI-use in exported RDF data: New URIs will not yet be generated for transformed resources in the alpha release. If source records have a URI already, it will reappear in the exported data.