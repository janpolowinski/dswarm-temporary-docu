* raw: [example_2.task.json](https://raw.githubusercontent.com/wiki/dswarm/dswarm-documentation/assets/example_2.task.json)

```json
{
    "name": "Transformations",
    "description": "Transformations",
    "job": {
        "mappings": [{
            "name": "dcterms:creator",
            "transformation": {
                "name": "transformation",
                "description": "transformation",
                "function": {
                    "type": "Transformation",
                    "name": "transformation",
                    "description": "transformation",
                    "id": 31,
                    "components": [{
                        "name": "component1416218489315",
                        "description": "{\"x\":\"feld_value__-1416218456933\",\"y\":0}",
                        "function": {
                            "type": "Function",
                            "name": "compose",
                            "description": "Add pre- or postfix to a string.",
                            "id": 3,
                            "function_description": {
                                "name": "compose",
                                "dsl": "metafacture",
                                "reference": "compose",
                                "description": "Add pre- or postfix to a string.",
                                "parameters": {
                                    "prefix": {
                                        "type": "text",
                                        "optional": true
                                    },
                                    "postfix": {
                                        "type": "text",
                                        "optional": true
                                    }
                                }
                            },
                            "parameters": ["prefix", "postfix"]
                        },
                        "id": 17,
                        "parameter_mappings": {
                            "inputString": "feld_value__-1416218456933__0__",
                            "prefix": "http://swb.bsz-bw.de/PRS=default/PPNSET?PPN="
                        }
                    }]
                },
                "id": 18,
                "input_components": null,
                "output_components": null,
                "parameter_mappings": {
                    "__TRANSFORMATION_OUTPUT_VARIABLE__1": "__OUTPUT_MAPPING_ATTRIBUTE_PATH_INSTANCE__1",
                    "feld_value__-1416218456933__0__": "feld_value__-1416218456933__0__"
                }
            },
            "id": 15,
            "input_attribute_paths": [{
                "type": "MappingAttributePathInstance",
                "name": "feld_value__-1416218456933__0__",
                "id": 31,
                "attribute_path": {
                    "id": 49,
                    "attributes": [{
                        "name": "feld",
                        "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                        "id": 40
                    }, {
                        "name": "value",
                        "uri": "http://www.w3.org/1999/02/22-rdf-syntax-ns#value",
                        "id": 43
                    }]
                },
                "filter": {
                    "name": null,
                    "expression": "[{\"http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld\\u001ehttp://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr\":\"202|206|210|214|218|222|226|230|234|238|242|246|250|254|258|262|266|270|274|278|282|286|290|294|298\",\"http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld\\u001ehttp://www.ddb.de/professionell/mabxml/mabxml-1.xsd#ind\":\"b\"}]",
                    "id": 17
                }
            }],
            "output_attribute_path": {
                "type": "MappingAttributePathInstance",
                "name": "__OUTPUT_MAPPING_ATTRIBUTE_PATH_INSTANCE__1",
                "id": 32,
                "attribute_path": {
                    "id": 9,
                    "attributes": [{
                        "name": "creator",
                        "uri": "http://purl.org/dc/elements/1.1/creator",
                        "id": 9
                    }]
                }
            }
        }, {
            "name": "bibo:shortTitle",
            "id": 13,
            "input_attribute_paths": [{
                "type": "MappingAttributePathInstance",
                "name": "feld_value__-1416218255978__1__",
                "id": 27,
                "attribute_path": {
                    "id": 49,
                    "attributes": [{
                        "name": "feld",
                        "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                        "id": 40
                    }, {
                        "name": "value",
                        "uri": "http://www.w3.org/1999/02/22-rdf-syntax-ns#value",
                        "id": 43
                    }]
                },
                "filter": {
                    "name": null,
                    "expression": "[{\"http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld\\u001ehttp://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr\":\"376\"}]",
                    "id": 15
                }
            }],
            "output_attribute_path": {
                "type": "MappingAttributePathInstance",
                "name": "__OUTPUT_MAPPING_ATTRIBUTE_PATH_INSTANCE__2",
                "id": 28,
                "attribute_path": {
                    "id": 7,
                    "attributes": [{
                        "name": "shortTitle",
                        "uri": "http://purl.org/ontology/bibo/shortTitle",
                        "id": 7
                    }]
                }
            },
            "transformation": {
                "name": "transformation",
                "description": "transformation",
                "function": {
                    "name": "transformation",
                    "description": "transformation",
                    "type": "Transformation"
                },
                "parameter_mappings": {
                    "__TRANSFORMATION_OUTPUT_VARIABLE__2": "__OUTPUT_MAPPING_ATTRIBUTE_PATH_INSTANCE__2",
                    "feld_value__-1416218255978__1__": "feld_value__-1416218255978__1__"
                }
            }
        }, {
            "name": "dc:title",
            "id": 14,
            "input_attribute_paths": [{
                "type": "MappingAttributePathInstance",
                "name": "feld_value__-1416218224591__2__",
                "id": 29,
                "attribute_path": {
                    "id": 49,
                    "attributes": [{
                        "name": "feld",
                        "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                        "id": 40
                    }, {
                        "name": "value",
                        "uri": "http://www.w3.org/1999/02/22-rdf-syntax-ns#value",
                        "id": 43
                    }]
                },
                "filter": {
                    "name": null,
                    "expression": "[{\"http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld\\u001ehttp://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr\":\"331\"}]",
                    "id": 16
                }
            }],
            "output_attribute_path": {
                "type": "MappingAttributePathInstance",
                "name": "__OUTPUT_MAPPING_ATTRIBUTE_PATH_INSTANCE__3",
                "id": 30,
                "attribute_path": {
                    "id": 3,
                    "attributes": [{
                        "name": "title",
                        "uri": "http://purl.org/dc/elements/1.1/title",
                        "id": 3
                    }]
                }
            },
            "transformation": {
                "name": "transformation",
                "description": "transformation",
                "function": {
                    "name": "transformation",
                    "description": "transformation",
                    "type": "Transformation"
                },
                "parameter_mappings": {
                    "__TRANSFORMATION_OUTPUT_VARIABLE__3": "__OUTPUT_MAPPING_ATTRIBUTE_PATH_INSTANCE__3",
                    "feld_value__-1416218224591__2__": "feld_value__-1416218224591__2__"
                }
            }
        }]
    },
    "input_data_model": {
        "name": "informationen zur raumentwicklung.xml",
        "description": "second example dataset",
        "configuration": {
            "name": "xml",
            "description": "xml with id 2",
            "id": 2,
            "resources": [{
                "id": 2
            }],
            "parameters": {
                "storage_type": "mabxml",
                "record_tag": "datensatz"
            }
        },
        "schema": {
            "name": "mabxml schema",
            "id": 3,
            "attribute_paths": [{
                "id": 1,
                "attributes": [{
                    "name": "type",
                    "uri": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type",
                    "id": 1
                }]
            }, {
                "id": 40,
                "attributes": [{
                    "name": "id",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#id",
                    "id": 36
                }]
            }, {
                "id": 41,
                "attributes": [{
                    "name": "typ",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#typ",
                    "id": 37
                }]
            }, {
                "id": 42,
                "attributes": [{
                    "name": "status",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#status",
                    "id": 38
                }]
            }, {
                "id": 43,
                "attributes": [{
                    "name": "mabVersion",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#mabVersion",
                    "id": 39
                }]
            }, {
                "id": 44,
                "attributes": [{
                    "name": "feld",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                    "id": 40
                }]
            }, {
                "id": 45,
                "attributes": [{
                    "name": "feld",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                    "id": 40
                }, {
                    "name": "type",
                    "uri": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type",
                    "id": 1
                }]
            }, {
                "id": 46,
                "attributes": [{
                    "name": "feld",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                    "id": 40
                }, {
                    "name": "id",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#id",
                    "id": 36
                }]
            }, {
                "id": 47,
                "attributes": [{
                    "name": "feld",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                    "id": 40
                }, {
                    "name": "nr",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr",
                    "id": 41
                }]
            }, {
                "id": 48,
                "attributes": [{
                    "name": "feld",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                    "id": 40
                }, {
                    "name": "ind",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#ind",
                    "id": 42
                }]
            }, {
                "id": 49,
                "attributes": [{
                    "name": "feld",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                    "id": 40
                }, {
                    "name": "value",
                    "uri": "http://www.w3.org/1999/02/22-rdf-syntax-ns#value",
                    "id": 43
                }]
            }, {
                "id": 50,
                "attributes": [{
                    "name": "feld",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                    "id": 40
                }, {
                    "name": "tf",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#tf",
                    "id": 44
                }]
            }, {
                "id": 51,
                "attributes": [{
                    "name": "feld",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                    "id": 40
                }, {
                    "name": "tf",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#tf",
                    "id": 44
                }, {
                    "name": "type",
                    "uri": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type",
                    "id": 1
                }]
            }, {
                "id": 52,
                "attributes": [{
                    "name": "feld",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                    "id": 40
                }, {
                    "name": "stw",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#stw",
                    "id": 45
                }]
            }, {
                "id": 53,
                "attributes": [{
                    "name": "feld",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                    "id": 40
                }, {
                    "name": "stw",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#stw",
                    "id": 45
                }, {
                    "name": "type",
                    "uri": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type",
                    "id": 1
                }]
            }, {
                "id": 54,
                "attributes": [{
                    "name": "feld",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                    "id": 40
                }, {
                    "name": "stw",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#stw",
                    "id": 45
                }, {
                    "name": "value",
                    "uri": "http://www.w3.org/1999/02/22-rdf-syntax-ns#value",
                    "id": 43
                }]
            }, {
                "id": 55,
                "attributes": [{
                    "name": "feld",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                    "id": 40
                }, {
                    "name": "ns",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#ns",
                    "id": 46
                }]
            }, {
                "id": 56,
                "attributes": [{
                    "name": "feld",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                    "id": 40
                }, {
                    "name": "ns",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#ns",
                    "id": 46
                }, {
                    "name": "type",
                    "uri": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type",
                    "id": 1
                }]
            }, {
                "id": 57,
                "attributes": [{
                    "name": "feld",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                    "id": 40
                }, {
                    "name": "ns",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#ns",
                    "id": 46
                }, {
                    "name": "value",
                    "uri": "http://www.w3.org/1999/02/22-rdf-syntax-ns#value",
                    "id": 43
                }]
            }, {
                "id": 58,
                "attributes": [{
                    "name": "feld",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                    "id": 40
                }, {
                    "name": "uf",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#uf",
                    "id": 47
                }]
            }, {
                "id": 59,
                "attributes": [{
                    "name": "feld",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                    "id": 40
                }, {
                    "name": "uf",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#uf",
                    "id": 47
                }, {
                    "name": "type",
                    "uri": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type",
                    "id": 1
                }]
            }, {
                "id": 60,
                "attributes": [{
                    "name": "feld",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                    "id": 40
                }, {
                    "name": "uf",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#uf",
                    "id": 47
                }, {
                    "name": "id",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#id",
                    "id": 36
                }]
            }, {
                "id": 61,
                "attributes": [{
                    "name": "feld",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                    "id": 40
                }, {
                    "name": "uf",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#uf",
                    "id": 47
                }, {
                    "name": "code",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#code",
                    "id": 48
                }]
            }, {
                "id": 62,
                "attributes": [{
                    "name": "feld",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                    "id": 40
                }, {
                    "name": "uf",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#uf",
                    "id": 47
                }, {
                    "name": "value",
                    "uri": "http://www.w3.org/1999/02/22-rdf-syntax-ns#value",
                    "id": 43
                }]
            }, {
                "id": 63,
                "attributes": [{
                    "name": "feld",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                    "id": 40
                }, {
                    "name": "uf",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#uf",
                    "id": 47
                }, {
                    "name": "tf",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#tf",
                    "id": 44
                }]
            }, {
                "id": 64,
                "attributes": [{
                    "name": "feld",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                    "id": 40
                }, {
                    "name": "uf",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#uf",
                    "id": 47
                }, {
                    "name": "tf",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#tf",
                    "id": 44
                }, {
                    "name": "type",
                    "uri": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type",
                    "id": 1
                }]
            }, {
                "id": 65,
                "attributes": [{
                    "name": "feld",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                    "id": 40
                }, {
                    "name": "uf",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#uf",
                    "id": 47
                }, {
                    "name": "stw",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#stw",
                    "id": 45
                }]
            }, {
                "id": 66,
                "attributes": [{
                    "name": "feld",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                    "id": 40
                }, {
                    "name": "uf",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#uf",
                    "id": 47
                }, {
                    "name": "stw",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#stw",
                    "id": 45
                }, {
                    "name": "type",
                    "uri": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type",
                    "id": 1
                }]
            }, {
                "id": 67,
                "attributes": [{
                    "name": "feld",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                    "id": 40
                }, {
                    "name": "uf",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#uf",
                    "id": 47
                }, {
                    "name": "stw",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#stw",
                    "id": 45
                }, {
                    "name": "value",
                    "uri": "http://www.w3.org/1999/02/22-rdf-syntax-ns#value",
                    "id": 43
                }]
            }, {
                "id": 68,
                "attributes": [{
                    "name": "feld",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                    "id": 40
                }, {
                    "name": "uf",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#uf",
                    "id": 47
                }, {
                    "name": "ns",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#ns",
                    "id": 46
                }]
            }, {
                "id": 69,
                "attributes": [{
                    "name": "feld",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                    "id": 40
                }, {
                    "name": "uf",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#uf",
                    "id": 47
                }, {
                    "name": "ns",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#ns",
                    "id": 46
                }, {
                    "name": "type",
                    "uri": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type",
                    "id": 1
                }]
            }, {
                "id": 70,
                "attributes": [{
                    "name": "feld",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                    "id": 40
                }, {
                    "name": "uf",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#uf",
                    "id": 47
                }, {
                    "name": "ns",
                    "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#ns",
                    "id": 46
                }, {
                    "name": "value",
                    "uri": "http://www.w3.org/1999/02/22-rdf-syntax-ns#value",
                    "id": 43
                }]
            }],
            "record_class": {
                "name": "datensatzType",
                "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#datensatzType",
                "id": 3
            },
            "content_schema": {
                "name": "mab content schema",
                "id": 1,
                "record_identifier_attribute_path": {
                    "id": 40,
                    "attributes": [{
                        "name": "id",
                        "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#id",
                        "id": 36
                    }]
                },
                "key_attribute_paths": [{
                    "id": 47,
                    "attributes": [{
                        "name": "feld",
                        "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                        "id": 40
                    }, {
                        "name": "nr",
                        "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr",
                        "id": 41
                    }]
                }, {
                    "id": 48,
                    "attributes": [{
                        "name": "feld",
                        "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                        "id": 40
                    }, {
                        "name": "ind",
                        "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#ind",
                        "id": 42
                    }]
                }],
                "value_attribute_path": {
                    "id": 49,
                    "attributes": [{
                        "name": "feld",
                        "uri": "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld",
                        "id": 40
                    }, {
                        "name": "value",
                        "uri": "http://www.w3.org/1999/02/22-rdf-syntax-ns#value",
                        "id": 43
                    }]
                }
            }
        },
        "id": 5,
        "data_resource": {
            "name": "informationen zur raumentwicklung.xml",
            "description": "second example dataset",
            "type": "FILE",
            "id": 2,
            "resource_attributes": {
                "path": "/home/dmp/tmp/tmp/resources/254877.xml",
                "filesize": -1,
                "filetype": "application/xml"
            },
            "configurations": [{
                "name": "xml",
                "description": "xml with id 2",
                "id": 2,
                "resources": [{
                    "id": 2
                }],
                "parameters": {
                    "storage_type": "mabxml",
                    "record_tag": "datensatz"
                }
            }]
        }
    },
    "output_data_model": {
        "name": "Internal Data Model BiboDocument",
        "description": "Internal Data Model BiboDocument",
        "schema": {
            "name": "bibo:Document-Schema (KIM-Titeldaten)",
            "id": 2,
            "attribute_paths": [{
                "id": 1,
                "attributes": [{
                    "name": "type",
                    "uri": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type",
                    "id": 1
                }]
            }, {
                "id": 3,
                "attributes": [{
                    "name": "title",
                    "uri": "http://purl.org/dc/elements/1.1/title",
                    "id": 3
                }]
            }, {
                "id": 5,
                "attributes": [{
                    "name": "otherTitleInformation",
                    "uri": "http://rdvocab.info/Elements/otherTitleInformation",
                    "id": 5
                }]
            }, {
                "id": 6,
                "attributes": [{
                    "name": "alternative",
                    "uri": "http://purl.org/dc/terms/alternative",
                    "id": 6
                }]
            }, {
                "id": 7,
                "attributes": [{
                    "name": "shortTitle",
                    "uri": "http://purl.org/ontology/bibo/shortTitle",
                    "id": 7
                }]
            }, {
                "id": 8,
                "attributes": [{
                    "name": "creator",
                    "uri": "http://purl.org/dc/terms/creator",
                    "id": 8
                }]
            }, {
                "id": 9,
                "attributes": [{
                    "name": "creator",
                    "uri": "http://purl.org/dc/elements/1.1/creator",
                    "id": 9
                }]
            }, {
                "id": 10,
                "attributes": [{
                    "name": "contributor",
                    "uri": "http://purl.org/dc/terms/contributor",
                    "id": 10
                }]
            }, {
                "id": 11,
                "attributes": [{
                    "name": "contributor",
                    "uri": "http://purl.org/dc/elements/1.1/contributor",
                    "id": 11
                }]
            }, {
                "id": 12,
                "attributes": [{
                    "name": "publicationStatement",
                    "uri": "http://rdvocab.info/Elements/publicationStatement",
                    "id": 12
                }]
            }, {
                "id": 13,
                "attributes": [{
                    "name": "placeOfPublication",
                    "uri": "http://rdvocab.info/Elements/placeOfPublication",
                    "id": 13
                }]
            }, {
                "id": 14,
                "attributes": [{
                    "name": "publisher",
                    "uri": "http://purl.org/dc/elements/1.1/publisher",
                    "id": 14
                }]
            }, {
                "id": 15,
                "attributes": [{
                    "name": "issued",
                    "uri": "http://purl.org/dc/terms/issued",
                    "id": 15
                }]
            }, {
                "id": 16,
                "attributes": [{
                    "name": "sameAs",
                    "uri": "http://www.w3.org/2002/07/owl#sameAs",
                    "id": 16
                }]
            }, {
                "id": 17,
                "attributes": [{
                    "name": "isLike",
                    "uri": "http://umbel.org/umbel#isLike",
                    "id": 17
                }]
            }, {
                "id": 18,
                "attributes": [{
                    "name": "issn",
                    "uri": "http://purl.org/ontology/bibo/issn",
                    "id": 18
                }]
            }, {
                "id": 19,
                "attributes": [{
                    "name": "eissn",
                    "uri": "http://purl.org/ontology/bibo/eissn",
                    "id": 19
                }]
            }, {
                "id": 20,
                "attributes": [{
                    "name": "lccn",
                    "uri": "http://purl.org/ontology/bibo/lccn",
                    "id": 20
                }]
            }, {
                "id": 21,
                "attributes": [{
                    "name": "oclcnum",
                    "uri": "http://purl.org/ontology/bibo/oclcnum",
                    "id": 21
                }]
            }, {
                "id": 22,
                "attributes": [{
                    "name": "isbn",
                    "uri": "http://purl.org/ontology/bibo/isbn",
                    "id": 22
                }]
            }, {
                "id": 23,
                "attributes": [{
                    "name": "medium",
                    "uri": "http://purl.org/dc/terms/medium",
                    "id": 23
                }]
            }, {
                "id": 24,
                "attributes": [{
                    "name": "hasPart",
                    "uri": "http://purl.org/dc/terms/hasPart",
                    "id": 24
                }]
            }, {
                "id": 25,
                "attributes": [{
                    "name": "isPartOf",
                    "uri": "http://purl.org/dc/terms/isPartOf",
                    "id": 25
                }]
            }, {
                "id": 26,
                "attributes": [{
                    "name": "hasVersion",
                    "uri": "http://purl.org/dc/terms/hasVersion",
                    "id": 26
                }]
            }, {
                "id": 27,
                "attributes": [{
                    "name": "isFormatOf",
                    "uri": "http://purl.org/dc/terms/isFormatOf",
                    "id": 27
                }]
            }, {
                "id": 28,
                "attributes": [{
                    "name": "precededBy",
                    "uri": "http://rdvocab.info/Elements/precededBy",
                    "id": 28
                }]
            }, {
                "id": 29,
                "attributes": [{
                    "name": "succeededBy",
                    "uri": "http://rdvocab.info/Elements/succeededBy",
                    "id": 29
                }]
            }, {
                "id": 30,
                "attributes": [{
                    "name": "language",
                    "uri": "http://purl.org/dc/terms/language",
                    "id": 30
                }]
            }, {
                "id": 31,
                "attributes": [{
                    "name": "1053",
                    "uri": "http://iflastandards.info/ns/isbd/elements/1053",
                    "id": 31
                }]
            }, {
                "id": 32,
                "attributes": [{
                    "name": "edition",
                    "uri": "http://purl.org/ontology/bibo/edition",
                    "id": 32
                }]
            }, {
                "id": 33,
                "attributes": [{
                    "name": "bibliographicCitation",
                    "uri": "http://purl.org/dc/terms/bibliographicCitation",
                    "id": 33
                }]
            }, {
                "id": 34,
                "attributes": [{
                    "name": "creator",
                    "uri": "http://purl.org/dc/terms/creator",
                    "id": 8
                }, {
                    "name": "type",
                    "uri": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type",
                    "id": 1
                }]
            }, {
                "id": 35,
                "attributes": [{
                    "name": "creator",
                    "uri": "http://purl.org/dc/terms/creator",
                    "id": 8
                }, {
                    "name": "familyName",
                    "uri": "http://xmlns.com/foaf/0.1/familyName",
                    "id": 34
                }]
            }, {
                "id": 36,
                "attributes": [{
                    "name": "creator",
                    "uri": "http://purl.org/dc/terms/creator",
                    "id": 8
                }, {
                    "name": "givenName",
                    "uri": "http://xmlns.com/foaf/0.1/givenName",
                    "id": 35
                }]
            }, {
                "id": 37,
                "attributes": [{
                    "name": "contributor",
                    "uri": "http://purl.org/dc/terms/contributor",
                    "id": 10
                }, {
                    "name": "type",
                    "uri": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type",
                    "id": 1
                }]
            }, {
                "id": 38,
                "attributes": [{
                    "name": "contributor",
                    "uri": "http://purl.org/dc/terms/contributor",
                    "id": 10
                }, {
                    "name": "familyName",
                    "uri": "http://xmlns.com/foaf/0.1/familyName",
                    "id": 34
                }]
            }, {
                "id": 39,
                "attributes": [{
                    "name": "contributor",
                    "uri": "http://purl.org/dc/terms/contributor",
                    "id": 10
                }, {
                    "name": "givenName",
                    "uri": "http://xmlns.com/foaf/0.1/givenName",
                    "id": 35
                }]
            }],
            "record_class": {
                "name": "Document",
                "uri": "http://purl.org/ontology/bibo/Document",
                "id": 2
            }
        },
        "id": 2
    }
}
```