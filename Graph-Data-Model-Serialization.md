## Serialization Proposals
These are various serialization format proposal for the [[GDM|Graph Data Model]].
<!-- TODO note: for proposal 1-8 please also have a look at the examples at the related github repo: dmp-graph graph data model -->
__note:__ "statement" can often be seen as synonym for "relationship", e.g., "statement id" = "relationship id"

* [[Proposal 1|Graph-Data-Model-Serialization#proposal-1]]
* [[Proposal 2|Graph-Data-Model-Serialization#proposal-2]]
* [[Proposal 3|Graph-Data-Model-Serialization#proposal-3]]
* [[Proposal 4|Graph-Data-Model-Serialization#proposal-4]]
* [[Proposal 5|Graph-Data-Model-Serialization#proposal-5]]
* [[Proposal 6|Graph-Data-Model-Serialization#proposal-6]]
* [[Proposal 7|Graph-Data-Model-Serialization#proposal-7]]
* [[Proposal 8|Graph-Data-Model-Serialization#proposal-8]]

### Proposal 1
(by [zazi](https://github.com/zazi))

derived JSON slang (but not JSON):
* grammar:
```
[
    {"[resource uri]":[
            {
                "[node id]": [<resource uri> | __BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__],
                "[relationship id]": <property uri>,
                "[node id]": [<resource uri> | __BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__ | "literal value"]
            },
        ....
        ]
    },
 ...
]
```  
* description:
  * a JSON array of JSON objects with the resource URI as key and a content blob as value
  * content structure:
     * JSON array of statements
     * JSON object with 3 key/value pairs for a statement (relationship) = subject, predicate, object (node, edge, node)
     * keys for subject and object (nodes) are bode ids
     * keys for predicate (relationships) are relationship ids
     * values for subjects are: URIs (covered in angle brackets) or just a bnode identifier (to have a value)
     * values for predicates are: the property URI (covered in angle brackets)
     * values for objects are: URIs (covered in angle brackets), just a bnode identifier (to have a value) or a literal value (covered in quotation marks)
* example:
```
[
    {"http://data.slub-dresden.de/datamodels/22/records/18d68601-0623-42b4-ad89-f8954cc25912":[
            {
                "1": <http://data.slub-dresden.de/datamodels/22/records/18d68601-0623-42b4-ad89-f8954cc25912>,
                "1": <http://www.openarchives.org/OAI/2.0/header>,
                "2": __BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__
            },{
                "264": __BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__,
                "1234": <http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#subfield>,
                "265": __BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__
            },{
                "266": __BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__,
                "1235": <http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#tag>,
                "267": "907"
            },{
                "268": __BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__,
                "1236": <http://www.w3.org/1999/02/22-rdf-syntax-ns#type>,
                "269": <http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#subfieldType>
            },
        ....
        ]
    },
 ...
]
```

### Proposal 2
(by [zazi](https://github.com/zazi))

derived N-Triples slang (that's why, G-Triples):
* grammar:
```
[node id]:[resource uri | bnode identifier] [relationship id]:[property uri] [node id]:[resource uri | bnode identifier | "literal value" ] .
```
* description:
  * each line represents a statement (relationship) = subject, predicate, object (node, edge, node)
  * the structure for each part of the triple is (more or less) the same - key/value pairs: a node or relationship id is followed by a colon and afterwards the value of the part is followed, e.g., a uri
  * values for subjects are: URIs or just a bnode identifier
  * values for predicates are: predicate URIs
  * values for objects are: URIs, just a bnode identifier or a literal value (covered in qutation marks)
* example:
```
1:http://data.slub-dresden.de/datamodels/22/records/18d68601-0623-42b4-ad89-f8954cc25912 1:http://www.openarchives.org/OAI/2.0/header 2:__BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__ .
264:__BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__ 1234:http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#subfield 265:__BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__ .
266:__BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__ 1235:http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#tag 267:"907" .
268:__BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__ 1236:http://www.w3.org/1999/02/22-rdf-syntax-ns#type 269:http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#subfieldType .
```

### Proposal 3
(by [zazi](https://github.com/zazi))

(yet another) derived N-Triples slang (that's why, G-Statements):
* grammar:
```
[statement id]: [node id]:[resource uri | bnode identifier] [property uri] [node id]:[resource uri | bnode identifier | "literal value" ] .
```
* description:
  * each line represents a statement (relationship) = subject, predicate, object (node, edge, node): started by the statement (relationship) id followed by a colon and afterwards the statement is followed
  * the structure for node parts of the triple is (more or less) the same - key/value pairs: a node is followed by a colon and afterwards the value of the part is followed, e.g., a uri
  * the structure for relationship parts is just the value, i.e., the property uri
  * values for subjects are: URIs or just a bnode identifier
  * values for objects are: URIs, just a bnode identifier or a literal value (covered in qutation marks)
* example:
```
1: 1:http://data.slub-dresden.de/datamodels/22/records/18d68601-0623-42b4-ad89-f8954cc25912 http://www.openarchives.org/OAI/2.0/header 2:__BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__ .
1234: 264:__BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__ http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#subfield 265:__BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__ .
1235: 266:__BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__ http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#tag 267:"907" .
1236: 268:__BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__ http://www.w3.org/1999/02/22-rdf-syntax-ns#type 269:http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#subfieldType .
```

### Proposal 4
(by [zazi](https://github.com/zazi))

(yet another) derived JSON slang:
* grammar:
```
[
    {"[resource uri]":"[content -> g-triples format]"
    },
 ...
] 
```
* description:
  * a JSON array of JSON objects with the resource URI as key and a content blob as value
  * content structure: see G-Triples proposal
* example:
```
[
    {"http://data.slub-dresden.de/datamodels/22/records/18d68601-0623-42b4-ad89-f8954cc25912":
        "1:http://data.slub-dresden.de/datamodels/22/records/18d68601-0623-42b4-ad89-f8954cc25912 1:http://www.openarchives.org/OAI/2.0/header 2:__BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__ .
264:__BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__ 1234:http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#subfield 265:__BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__ .
266:__BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__ 1235:http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#tag 267:\"907\" .
268:__BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__ 1236:http://www.w3.org/1999/02/22-rdf-syntax-ns#type 269:http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#subfieldType ."
    },
 ...
]
```

### Proposal 5
(by [zazi](https://github.com/zazi))

(yet another) derived JSON slang:
* grammar:
```
[
    {"[resource uri]":"[content -> g-statements format]"
    },
 ...
] 
```
* description:
  * a JSON array of JSON objects with the resource URI as key and a content blob as value
  * content structure: see G-Statements proposal
* example:
```
[
    {"http://data.slub-dresden.de/datamodels/22/records/18d68601-0623-42b4-ad89-f8954cc25912":
        "1: 1:http://data.slub-dresden.de/datamodels/22/records/18d68601-0623-42b4-ad89-f8954cc25912 http://www.openarchives.org/OAI/2.0/header 2:__BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__ .
1234: 264:__BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__ http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#subfield 265:__BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__ .
1235: 266:__BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__ http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#tag 267:\"907\" .
1236: 268:__BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__ http://www.w3.org/1999/02/22-rdf-syntax-ns#type 269:http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#subfieldType ."
    },
 ...
]
```

### Proposal 6
(by [zazi](https://github.com/zazi))

(yet another) derived JSON slang:
* grammar:
```
[
    {"[resource uri]":[
            {"[statement id]": "[g-statements value format]"},
            ...
        ]
    },
 ...
]
```
* description:
  * a JSON array of JSON objects with the resource URI as key and a content blob as value
  * content structure:
     * JSON array of statements
     * JSON object with 1 key/value pair for a statement (relationship):
        * key = statement (relationship) id
        * value = value format as described by G-Statements
* example:
```
[
    {"http://data.slub-dresden.de/datamodels/22/records/18d68601-0623-42b4-ad89-f8954cc25912":[
            {"1": "1:http://data.slub-dresden.de/datamodels/22/records/18d68601-0623-42b4-ad89-f8954cc25912 http://www.openarchives.org/OAI/2.0/header 2:__BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__ ."},
            {"1234": "264:__BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__ http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#subfield 265:__BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__ ."},
            {"1235": "266:__BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__ http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#tag 267:\"907\" ."},
            {"1236": "268:__BNODE_TYPE_IDENTIFIER_(JUST_TO_HAVE_A_VALUE)__ http://www.w3.org/1999/02/22-rdf-syntax-ns#type 269:http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#subfieldType ."},
            ...
        ]
    },
 ...
]
```

### Proposal 7
(by [zazi](https://github.com/zazi))

a JSON slang (which is (HELLO frontend developer ;) ) pure, valid JSON and nothing else):
* grammar:
```
[
    {"[resource uri]":[
            {"[statement id]": {
                    "s": {
                        "id": [subject node id],
                        [ "uri": "[subject uri]" ]
                    },
                    "p": "[predicate uri]",
                    "o": {
                        "id": [object node id],
                        [ "uri": "[object uri]" | "v": "literal value" ]
                    }
                }
            },
            ...
        ]
    },
 ...
]
```
* description:
  * a JSON array of JSON objects with the resource URI as key and a content blob as value
  * content structure:
     * JSON array of statements
     * JSON object with 1 key/value pair for a statement (relationship):
        * key = statement (relationship) id
        * value = JSON object with 3 key/value pairs for describing the single parts of a statement, i.e., subject ('s'), predicate ('p'), object ('o')
           * values for subjects are: JSON object with 'id' key/value pair that address the subject node id + (optional) 'uri' key/value pair for addressing the URI of the subject
           * values for predicates are: predicate URIs
           * values for objects are: JSON object with 'id' key/value pair that address the object node id + (optional) 'uri' key/value pair for addressing the URI of the object or 'v' ( = value) key/value for addressing literal values
* example:
```
[{
        "http://data.slub-dresden.de/datamodels/22/records/18d68601-0623-42b4-ad89-f8954cc25912": [{
                "1": {
                    "s": {
                        "id": 1,
                        "uri": "http://data.slub-dresden.de/datamodels/22/records/18d68601-0623-42b4-ad89-f8954cc25912"
                    },
                    "p": "http://www.openarchives.org/OAI/2.0/header",
                    "o": {
                        "id": 2
                    }
                }
            }, {
                "1234": {
                    "s": {
                        "id": 264
                    },
                    "p": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#subfield",
                    "o": {
                        "id": 265
                    }
                }
            }, {
                "1235": {
                    "s": {
                        "id": 265
                    },
                    "p": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#tag",
                    "o": {
                        "id": 267,
                        "v": "907"
                    }
                }
            }, {
                "1236": {
                    "s": {
                        "id": 268
                    },
                    "p": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type",
                    "o": {
                        "id": 269,
                        "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#subfieldType"
                    }
                }
            },
            ...
        ]
    },
    ...
]
```

### Proposal 8
(by [zazi](https://github.com/zazi))

a JSON slang (which is (HELLO frontend developer (wink) ) pure, valid JSON and nothing else):
* grammar:
```
[{
        "[resource uri]": [{
                "id": [statement id],
                "s": {
                    "id": [subject node id],
                    ["uri": "[subject uri]"]
                },
                "p": "[predicate uri]",
                "o": {
                    "id": [object node id],
                    ["uri": "[object uri]" | "v": "literal value"]
                }
            },
            ...
        ]
    },
    ...
]
```
* description:
  * a JSON array of JSON objects with the resource URI as key and a content blob as value
  * content structure:
     * JSON array of statements
     * JSON object with 1 key/value pair for a statement id (relationship id) + 3 key/value pairs for describing the single parts of a statement, i.e., subject ('s'), predicate ('p'), object ('o')
        * values for subjects are: JSON object with 'id' key/value pair that address the subject node id + (optional) 'uri' key/value pair for addressing the URI of the subject
        * values for predicates are: predicate URIs
        * values for objects are: JSON object with 'id' key/value pair that address the object node id + (optional) 'uri' key/value pair for addressing the URI of the object or 'v' ( = value) key/value for addressing literal values
* example:
```
[{
        "http://data.slub-dresden.de/datamodels/22/records/18d68601-0623-42b4-ad89-f8954cc25912": [{
                "id": 1,
                "s": {
                    "id": 1,
                    "uri": "http://data.slub-dresden.de/datamodels/22/records/18d68601-0623-42b4-ad89-f8954cc25912"
                },
                "p": "http://www.openarchives.org/OAI/2.0/header",
                "o": {
                    "id": 2
                }
            }, {
                "id": 1234,
                "s": {
                    "id": 264
                },
                "p": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#subfield",
                "o": {
                    "id": 265
                }
            }, {
                "id": 1235,
                "s": {
                    "id": 265
                },
                "p": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#tag",
                "o": {
                    "id": 267,
                    "v": "907"
                }
            }, {
                "id": 1236,
                "s": {
                    "id": 268
                },
                "p": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type",
                "o": {
                    "id": 269,
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#subfieldType"
                }
            },
            ...
        ]
    },
    ...
]
```
* __note:__ this proposal is the basis for the current implementation of the JSON serialization of the [[GDM|Graph Data Model]], see [dswarm-gdm-java](https://github.com/dswarm/dswarm-gdm-java)