A collection of tips for development.

### Explore communication between front end and back end

The communication between front end and back end's RESTful API is based on json objects. You may use the Chrome web browser and its Developer Tools. (hint: a Developer Tools window displays details on the particular tab that was in focus when opening the developer tools.) The network perspective is pretty useful to inspect the communication to the d:swarm back end server. 

The _Headers_ tab of the developer tools gives an overview which d:swarm API endpoint was requested, e.g. http://127.0.0.1:8087/dmp/resources on a local installation when opening the d:swarm [[Data Perspective|Glossary#data-perspective]].

The _Response_ tab of the developer tools contains data received from the d:swarm back end. Copy the JSON string, open http://jsbeautifier.org in a separate browser, paste the content and hit "Beautify ..." to get a human readable version of the response.


### Log files 

When playing around with the [[front end]], open a terminal and use `tail -f` on one of the log files written to `datamanagement-platform/log` to observe whats happening in the [[back end]].
