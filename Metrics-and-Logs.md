For configuring metrics logging and general logging see [dswarm Configuration].

Metrics will currently be reported to Elasticsearch and logged to the monitoring log file folder (default to ${dwarm.paths.logging}/monitoring/info).

### General Metrics

Almost every HTTP request is timed and these measurements are made available
at a dedicated endpoint. These request are grouped by their verb and
their path. Also, each return code and possible thrown Exception is
metered to get a distribution of such events.
Additionally, calls to logger methods and various JVM metrics are measured.
This is provided by a custom implementation of `metrics-anotations`.
The Endpoint to fetch these metrics is `/_stats`.


#### Logging to Elasticsearch

Using the configuration `dwarm.reporting`, the aforementioned metrics
can be reported to an Elasticsearch instance, possibly running Kibana.
(Setting up Kibana is out of scope for this documentation)

Relevant settings are (see [dswarm Configuration] for details):

- dswarm.reporting.elasticsearch.host
- dswarm.reporting.enabled
- dswarm.reporting.interval

### Detailed Metrics / Monitoring

Two events are equipped with detailed monitoring and special-purpose logging.
These two events are [_Data Ingest_](Select-Data-for-Schema-Configuration) and
[_Task Execution_](Design-and-Execute-Transformations#execute-transformations).
They are logged to a collection of files at `${dwarm.paths.logging}/monitoring/info`, which can be tweaked using the keys in `dswarm.monitoring`.

#### Logfiles

The logfile are split in three different categories.

1. executions
2. ingests
3. metrics

Furthermore, each logfile is identified by its type (DataModel or Task for Ingest or Ecxecution, resp.), its UUID and name and description, as far as they're available.
This means that isolated tasks are logged to different logfiles which eases human inspection.

##### Executions

Executions are general information about task executions.
The logfile contains a timestamp and a status message when
- an execution is started
- an execution is finished
- an in-progress status every x timeunits, depending on the configuration (`dswarm.monitoring.continuous-interval`)
- after every execution, a timer metric is logged that has measured how long this particular execution took place


##### Ingests

Ingests are general information about data ingests.
The logfile contains a timestamp and a status message when
- an ingest is started
- an ingest is finished
- an in-progress status every x timeunits, depending on the configuration (`dswarm.monitoring.continuous-interval`)
- after every ingest, a timer metric is logged that has measured how long this particular ingest took place

##### Metrics

Metrics hold detailed information about an either execution:
- when an ingest is started on which DataModel is involved
- an in-progress status every x timeunits, depending on the configuration (`dswarm.monitoring.continuous-interval`)
- detailed metrics at the end of the exection, depending on the DataModel type.


General information (ingest based):


| name                                                   | description                                      |
|--------------------------------------------------------|--------------------------------------------------|
| org.dswarm.persistence.model.resource.DataModel.ingest | Overall ingest process of a DataModel            |
| org.dswarm.persistence.model.resource.Resource.XXX     | Resources that were involved                     |
| org.dswarm.persistence.model.schema.Schema.XXX         | Schemas that were involved                       |
| Input Resource Files.process                           | How many input files were processed              |
| Input Resource Files.cumulative                        | All events regarding input files                 |


For CSV ingests, these metrics are logged (exemplary):


| name                                                   | description                                      |
|--------------------------------------------------------|--------------------------------------------------|
| CSV Records (Lines).records                            | How many input lines produces records            |
| CSV Records (Lines).literals                           | How many input lines produced literals           |
| CSV Records (Lines).cumulative                         | All events regarding input lines                 |
| CSV Triples.process                                    | How many triples were created in the process     |
| CSV Triples.cumulative                                 | All events regarding created triples             |


For XML-based ingests, these metrics are logged (exemplary):


| name                                                   | description                                      |
|--------------------------------------------------------|--------------------------------------------------|
| Parsed XML Records.process                             | How many XML records were parsed                 |
| Parsed XML Records.cumulative                          | All events regarding XML inpur parsing           |
| XML Events.document                                    | How many XML documents were processed            |
| XML Events.element                                     | How many XML elements were processed             |
| XML Events.characters                                  | How many XML characters were processed           |
| XML Events.cumulative                                  | All events regarding XML events                  |


For Task executions, these metrics are loggen (exemplary):


| name                                                   | description                                      |
|--------------------------------------------------------|--------------------------------------------------|
| org.dswarm.persistence.model.job.Mapping.XXX           | Mappings that were involved                      |
| org.dswarm.persistence.model.resource.DataModel.XXX    | DataModels that were involved                    |
| metamorph                                              | How long took the complete Metamorph pipeline    |
| gdm-transformer                                        | How long to the complete GDM transformer         |
| stream-input.records                                   | How many records were processed                  |
| stream-input.entities                                  | How many entities were processed                 |
| stream-input.literals                                  | How many literals were processed                 |
| stream-input.cumulative                                | All events regarding metamorph processing        |
| gdm-models.process                                     | How many GDM models were processed               |
| gdm-models.cumulative                                  | All events regarding GDM models                  |

