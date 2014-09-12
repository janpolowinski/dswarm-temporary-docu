Short description of whole transformation:

1. take two parameters (http://example.com/attribute1 and http://example.com/attribute2)   
2. do clean-up on both of them
3. concat both

The two major parts are myTransformation:Transformation and clean-up:Transformation.

clean-up:Transformation does three steps: 

1. a replace (a by x)
2. a trim and 
3. a toLowerCase. 

Since the same 3 steps are applied to both input parameters, the whole clean-up transformation is reutilised in myTransformation:Transformation (wrapped as a function by component1 and component2).

<!--- update figure at https://intranet.slub-dresden.de/pages/viewpage.action?pageId=37071934 -->
[[enlarge figure|img/mapping-object-diagramm.png]]
[[img/mapping-object-diagramm.png]]