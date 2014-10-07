## Initial Installation

premise:
- currently, we've deployed the application only on Ubuntu Linux distributions
- empty trusty (14.04)
- three additional partitions (for easier increasing the sizes of the partitions separately): 
-- /data/log, 1-5GB depending on usage
-- /data/mysql, up to 5GB
-- /data/neo4j, up to 20GB
- let the $HOME of the less privileged user be '/home/user'
- all commands boxes start as the less privileges user and in their $HOME.
- Requiring root is explicitly marked (with `su` rather than `sudo ...` ; note that using sudo before each line is not suffienct to yield the same results as with su. Using su may require you to set a password for root if not already done!)

_Note: some commands require user input, this is no unattended installation_

* * *
**This step requires root level access**

### **1**. install system packages required for building the software

```
su
apt-get install --no-install-recommends --yes git-core maven nodejs npm build-essential
```

* * *

**These steps require less privileged access**


### **2**. create ssh key 

```
ssh-keygen -t rsa -b 2048 -f ~/.ssh/id_rsa -N ''
```

### **3**. add ssh key to deployment hooks in gitlab 
(this is only necessary, if you want to integrate your server in certain CI deployment jobs; otherwise you only need to add the ssh key to your user profile)

- copy the contents of the public key at `~/.ssh/id_rsa.pub`
- open https://git.slub-dresden.de/dmp/datamanagement-platform/deploy_keys/new to add a new deploy key
  - enter a title (e.g. user@host)
  - paste the public key
- open https://git.slub-dresden.de/dmp/dmp-graph/deploy_keys and click on `Enable` next to the just added key
- repeat for https://git.slub-dresden.de/dmp/dmp-backoffice-web/deploy_keys

### **4**. clone repositories (not as root!)

lookout for the correct path (/home/user)

```
cd /home/user
git clone --depth 1 --branch builds/unstable git@git.slub-dresden.de:dmp/datamanagement-platform.git
git clone --depth 1 --branch master git@git.slub-dresden.de:dmp/dmp-graph.git
git clone --depth 1 --branch builds/unstable git@git.slub-dresden.de:dmp/dmp-backoffice-web.git
git clone --depth 1 --branch master git@git.slub-dresden.de:dmp/ci-tools.git
```

* * *

**These steps require root level access**


### **5**. install system packages required for running the software

```
su
apt-get install --no-install-recommends --yes mysql-server nginx tomcat7 openjdk-7-jdk curl
```

- note: neo4j suggest to install oracle-jdk instead of openjdk, to do so, please execute the following commands (see also http://community.linuxmint.com/tutorial/view/1414)

```
su
add-apt-repository ppa:webupd8team/java
apt-get update
apt-get install oracle-java7-installer
```

- you can check your java version with

```
java -version
```

- if it's not oracle-jdk, then

```
su
update-java-alternatives -s java-7-oracle
```

- optionally, you can also set the environment variables to oracle-jdk with

```
su
apt-get install oracle-java7-set-default
```

### **6**. install Neo4j 

currently, we rely on Neo4j version 2.0.3

```
su
wget -O - http://debian.neo4j.org/neotechnology.gpg.key | apt-key add -
echo 'deb http://debian.neo4j.org/repo stable/' > /etc/apt/sources.list.d/neo4j.list
apt-get update
apt-get install --no-install-recommends --yes neo4j=2.0.3
```

You can open the Neo4j Browser at `http://localhost:7474/browser/` to check that the correct version has been installed.

Make sure Neo4j does not get updated when updating packages. You can use apt-pinning to do so. As root, create a file

```
su
touch /etc/apt/preferences.d/neo4j.pref
```

and add the following lines to this file. 

``` 
Package: neo4j
Pin: version 2.0.3
Pin-Priority: 1000
```

### **7**. make sure, permissions are correctly

```
su
chown -R tomcat7:tomcat7 /data/log
chown -R mysql:mysql /data/mysql
chown -R neo4j:adm /data/neo4j
```

### **8**. install build environment for frontend

```
su
ln -s /usr/bin/nodejs /usr/bin/node
npm install -g grunt-cli karma bower
```

### **9**. setup MySQL

Create a database and a user for d:swarm. To customize the settings, edit `datamanagement-platform/persistence/src/main/resources/create_database.sql`. Do not check in this file in case you modify it. Hint: remember settings for step 13 (configure d:swarm). 

    mysql -uroot -p < persistence/src/main/resources/create_database.sql

Then, open `/etc/mysql/my.cnf` and add the following line to the section `[mysqld]` (around line 45)

```
wait_timeout = 1209600
```

in the same file, same sections, change `datadir` to `/data/mysql` (around line 40)

```
datadir         = /data/mysql
```

add this directory to AppArmor

```
su
echo "alias /var/lib/mysql/ -> /data/mysql/," >> /etc/apparmor.d/tunables/alias
/etc/init.d/apparmor reload
```

and copy whole MySQL data directory to new location

```
cp -pr /var/lib/mysql/ /data/mysql/
```


### **10.**  setup Nginx

edit `/etc/nginx/sites-available/default` and add this just below the `location /` block

```
location /dmp {
        client_max_body_size 100M;
        proxy_pass http://127.0.0.1:8080$uri$is_args$args;
}
```

move old content root and link the new one. lookout for the correct user path! (the directory will be created later on)

```
su
mv /usr/share/nginx/{html,-old}
ln -s /home/user/dmp-backoffice-web/yo/publish /usr/share/nginx/html
```

### **11**. setup tomcat

open /etc/tomcat7/server.xml at line 33 and add a `driverManagerProtection="false"` so that the line reads

```
<Listener className="org.apache.catalina.core.JreMemoryLeakPreventionListener" driverManagerProtection="false" />
```

at line 73, same file, add this option `maxPostSize="104857600"`, so that the Connector block reads

```
    <Connector port="8080" protocol="HTTP/1.1"
               connectionTimeout="20000"
               maxPostSize="104857600"
               URIEncoding="UTF-8"
               redirectPort="8443" />
```

then, give tomcat some more memory

```
su
echo 'CATALINA_OPTS="-Xms4G -Xmx4G -XX:+CMSClassUnloadingEnabled -XX:+UseConcMarkSweepGC -XX:MaxPermSize=512M"' >> /usr/share/tomcat7/bin/setenv.sh
```

### **12**. setup Neo4j

increase file handlers at `/etc/security/limits.conf`

```
root   soft    nofile  40000
root   hard    nofile  40000
```

plus add `ulimit -n 40000` into your neo4j service script (under `/etc/init.d', e.g., `/etc/init.d/neo4j-service`) before starting the daemon

edit `/etc/neo4j/neo4j.properties` and:

- insert some storage tweaks (from http://blog.bruggen.com/2014/02/some-neo4j-import-tweaks-what-and-where.html)

```
use_memory_mapped_buffers=true
neostore.nodestore.db.mapped_memory=1024M
neostore.relationshipstore.db.mapped_memory=4G
neostore.propertystore.db.mapped_memory=1024M
neostore.propertystore.db.strings.mapped_memory=1024M
cache_type=weak
```

edit `/etc/neo4j/neo4j-server.properties` and:

- at line 12, change the database location

```
org.neo4j.server.database.location=/data/neo4j/data/graph.db
```

- at line 53, change the database location

```
org.neo4j.server.webadmin.rrdb.location=/data/neo4j/data/rrd
```

- at line 75 and add our graph extension

```
org.neo4j.server.thirdparty_jaxrs_classes=org.dswarm.graph.resources=/graph
```

edit `/etc/neo4j/neo4j-wrapper.conf` and:

- insert an additional parameter (if your server is x64)

```
wrapper.java.additional.1=-d64
```

- tweak the java heap space size to an appropriate value according to your server ram memory, e.g.,

```
wrapper.java.initmemory=512
wrapper.java.maxmemory=8192
```

edit `/etc/neo4j/logging.properties` and change line 54 to be

```
java.util.logging.FileHandler.pattern=/data/neo4j/log/neo4j.%u.%g.log
```

then, create a symlink from the previous log location to the external partition

```
su
mv /var/lib/neo4j/data/log{,-old}
ln -s /data/neo4j/log /var/lib/neo4j/data/log
mkdir /data/neo4j/log
chown -R neo4j:adm /data/neo4j/log
```

By default, the Neo4j Server is bundled with a Web server that binds to host localhost on port 7474, answering only requests from the local machine. If you need remote access to Neo4j UI, see [Secure the port and remote client connection accepts](http://docs.neo4j.org/chunked/stable/security-server.html#_secure_the_port_and_remote_client_connection_accepts)

* * *

**These steps require less privileged access**

### **13**. configure d:swarm

Follow the instructions in [[d:swarm Configuration|dswarm Configuration]]. 


### **14**. build neo4j extension
(TODO: during the developer installation Jan had to configure maven to use the slub nexus server (add settings.xml (LINK to example file!) to  the ~/.m2 folder.)
```
pushd dmp-graph
mvn -U -PRELEASE -DskipTests clean package
popd
mv dmp-graph/target/graph-1.1-jar-with-dependencies.jar dmp-graph.jar
```


### **15**. build backend

```
pushd datamanagement-platform
mvn -U -DskipTests clean install
pushd controller
mvn -U -DskipTests war:war
popd; popd
mv datamanagement-platform/controller/target/dswarm-controller-0.1-SNAPSHOT.war dmp.war
```

### **16**. build frontend

```
pushd dmp-backoffice-web; pushd yo
npm install
bower install
STAGE=unstable DMP_HOME=../../datamanagement-platform grunt build
popd
rsync --delete --verbose --recursive yo/dist/ yo/publish
popd
```

* * *

**These steps require root level access**


### **17**. wire everything together

lookout for the correct path (/home/user)

```
su
rm /var/lib/tomcat7/webapps/dmp.war
rm -r /var/lib/tomcat7/webapps/dmp
cp /home/user/dmp.war /var/lib/tomcat7/webapps/
cp /home/user/dmp-graph.jar /usr/share/neo4j/plugins/
```


### **18**. restart everything, if needed

```
su
/etc/init.d/mysql restart
/etc/init.d/neo4j-service restart
/etc/init.d/nginx restart
/etc/init.d/tomcat7 restart
```

### **19**. initialize/reset database

**This step requires less privileged access**

When running the backend the first time, the MySQL database needs to be initialized. When updated, a reset is required in case the schema or initial data has changed.
lookout for the correct path (/home/user)

```
pushd ci-tools/scripts
python reset-dbs.py \
  --persistence-module=../../datamanagement-platform/persistence \
  --user=dmp \
  --password=dmp \
  --db=dmp \
  --neo4j=http://localhost:7474/graph
```

Or provide the credentials and values you configured.
Check `python reset-dbs.py --help` for additional information.

## Update the System

### **1**. update repository contents

```
pushd datamanagement-platform; git pull; popd
pushd dmp-graph; git pull; popd
pushd dmp-backoffice-web; git pull; popd
```

### **2**. repeat steps [[14|Server-Install#14-build-neo4j-extension]] to [[19|Server-Install#19-initializereset-database]] from installation as necessary


## Checklist on Errors

First of all it's a good idea to know which of the four components front end, back end, MySQL and Neo4j database does not run. If you already know, skip this list.

* [[front end]]: open `http://localhost:9999` in a browser. The front end should be displayed. 
* [[back end]]: open `http://localhost:8087/dmp/_ping` in a browser. The expected response is a page with the word _pong_.
* MySQL database: open a terminal and type `mysql -udmp -p dmp` to open a connection to MySQL and select the database _dmp_. Hint: check for correct user name, password and database name in case you did not use the default values. If you can log in, type `select * from data_model;`. At least three internal data models should be listed. 
* Neo4j database: open `http://localhost:7474/browser/` in a browser. The Neo4j browser should open.

Now that you know which component does not run, go through 

<!--- even though it is most likely that the databases contain corrupted data, this is not the first point on the list since previous steps are required to initialize the dbs. -->

* is _curl_ installed?
* when building the projects with maven, did you use the `-U` option to update project dependencies?
* Check your [[dswarm Configuration]]. Are database name and password correct, i.e. the ones used when installing MySQL (step [[Server-Install#6-setup-mysql]])? Compare _datamanagement-platform/persistence/src/main/resources/create_database.sql_ with _datamanagement-platform/dswarm.conf_ or any other configuration option you use.
* [[initialize the databases|Server-Install#19-initializereset-database]]. They may be empty or contain corrupted data caused by a failed unit tests.
* Did you miss an update of, e.g., the neo4j version? Compare your installed version with the required version (see [[step 6|Server-Install#6-install-neo4j]])