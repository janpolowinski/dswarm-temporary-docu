The HTTP API endpoints are annotated with [Swagger](http://swagger.io/) descriptions that allow every client to discover and test the API. You can feed every (open) [Swagger UI](https://github.com/swagger-api/swagger-ui)  with the d:swarm-API specification. This also works when you are using your local API specification (which should usually be available at http://127.0.0.1:8087/dmp/api-docs/).

#### Examples #####

Call the d:swarm Swagger UI with your local API specification:
* http://194.95.145.12/docs/?url=http://127.0.0.1:8087/dmp/api-docs/

Call the d:swarm Swagger UI with the API specification from our server:
* http://194.95.145.12/docs/?url=http://194.95.145.12/dmp/api-docs/

You may also utilise any other open public Swagger UI such as http://petstore.swagger.wordnik.com and make it point to you API.