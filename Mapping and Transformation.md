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

[![mapping and transformation](https://avgl.mybalsamiq.com/mockups/1662706.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00)](https://avgl.mybalsamiq.com/mockups/1662706.png?key=27106ea66faf01c9ad98a275eac48683ac53bf00 "Mapping and Transformation")