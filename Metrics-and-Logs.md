ATTENTION: Upcoming feature, not yet in the main repo.

For configuring metrics logging and general logging see [dswarm Configuration].

Metrics will currently be reported to elastic search (1) and logged to the monitoring log file folder (default {$DSWARM-HOME}/controller/log/monitoring/info (2).

### 1. Logging to elastic search

### 2. Logging to the monitoring folder
The following files are created per task (?)
* executions-{TASK-NAME} -- one entry per transform task execution
* ingests-{TASK-NAME} -- one entry per ingest process (?)
* metrics-{TASK-NAME} -- detailed measures of the transfom task execution.

For the detailed monitoring of the transformation task, the following measures are logged. Cumulative means the sum of measures in the same block, e.g.: if we have gdm-triples.closes, gdm-triples.resets, and gdm-triples.process, then gdm-triples.cumulative is the combined metrics for those three.

* gdm-models.closes
* gdm-models.resets
* gdm-models.process
* gdm-models.cumulative

* org.dswarm.persistence.model.job.Mapping.{UUID}
* org.dswarm.persistence.model.resource.DataModel.{UUID}.source
* org.dswarm.persistence.model.resource.DataModel.{UUID}.target

* gdm-transformer
* metamorph

* stream-input.closes
* stream-input.resets
* stream-input.entities
* stream-input.literals
* stream-input.records
* stream-input.cumulative