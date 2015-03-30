ATTENTION: Upcoming feature, not yet in the main repo.

For configuring metrics logging and general logging see [dswarm Configuration].

Metrics will currently be reported to elastic search (1) and logged to the monitoring log file folder (default {$DSWARM-HOME}/controller/log/monitoring/info (2).

### 1. Logging to elastic search

### 2. Logging to the monitoring folder
The following files are created per task (?)
* **ingests-{DATAMODEL-NAME}.log** -- one entry per ingest process to a specific data model
* **executions-{TASK-NAME}.log** -- one entry per transform task execution (count always 1, min, mean irrelevant)
* **metrics-{TASK-NAME}.log** -- detailed measures of the transform task execution.
* **metrics-{DATAMODEL-NAME}.log** -- detailed measures of the ingest. (Why metamorph again?)
* **ingests-{TASK-NAME}.log** -- (will be removed ?)
* **executions-{DATAMODEL-NAME}.log** -- (will be removed ?)

For the detailed monitoring of the transformation task, the following measures are logged. Cumulative means the sum of measures in the same block, e.g.: if we have gdm-triples.closes, gdm-triples.resets, and gdm-triples.process, then gdm-triples.cumulative is the combined metrics for those three.

* **gdm-models.closes** -- number of succesfully closed streams (?)
* **gdm-models.resets** -- ?
* **gdm-models.process** -- count = number of transformed records successfully written (?) to the gdm model
* **gdm-models.cumulative** -- count = number of all gdm-models.* events ; ignore other values

* **org.dswarm.persistence.model.job.Mapping.{UUID}** -- (wasn't created everytime, just the first time)
* **org.dswarm.persistence.model.resource.DataModel.{UUID}.source** (interesting value is (only?) the model ID)
* **org.dswarm.persistence.model.resource.DataModel.{UUID}.target** (interesting value is (only?) the model ID)

* **metamorph** -- min = time to transfom with metamorph
* **gdm-transformer** -- min = time to write the transfomed records to our GDM model

* **stream-input.closes** -- number of succesfully closed streams (?)
* **stream-input.resets** -- ?
* **stream-input.entities** -- count = number of transformed entities
* **stream-input.literals** -- count = number of transformed literals
* **stream-input.records** -- count = number of transformed records
* **stream-input.cumulative** -- count = number of all stream-input.* events ; ignore other values