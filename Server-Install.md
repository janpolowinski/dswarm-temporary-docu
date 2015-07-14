_These are the installation instructions for a *server* and will add some steps that aim at a production environment, which are not described in the [Developer-Install](developer install)._

## Initial Installation

premise:
- currently, we've deployed the application only on Ubuntu Linux distributions
- empty trusty (14.04)
- three additional partitions (for easier increasing the sizes of the partitions separately):
-- /data/log, 1-5GB depending on usage
-- /data/mysql, up to 5GB
-- /data/neo4j, up to 20GB
- let the $HOME of the less privileged user be '/home/user'
- all commands boxes start as the less privileged user and in their $HOME.
- Requiring root is explicitly marked (with `su` rather than `sudo ...` ; note that using sudo before each line is not sufficient to yield the same results as with su. Using su may require you to set a password for root if not already done!)

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


### **2**. clone repositories (not as root!)

lookout for the correct path (/home/user)

```
cd /home/user

git clone --depth 1 --branch builds/unstable https://github.com/dswarm/dswarm.git
git clone --depth 1 --branch master https://github.com/dswarm/dswarm-graph-neo4j.git
git clone --depth 1 --branch builds/unstable https://github.com/dswarm/dswarm-backoffice-web.git
```

* * *

**These steps require root level access**


### **3**. install Java and Tomcat for the backend

- D:SWARM requires Java 8, which is no longer available in the default package sources. Follow [these steps](http://www.webupd8.org/2012/09/install-oracle-java-8-in-ubuntu-via-ppa.html)

```
su
add-apt-repository ppa:webupd8team/java
apt-get update
apt-get install oracle-java8-installer oracle-java8-set-default
```

You can verify your java version with

```
java -version 2>&1 | grep -q "1.8" && echo "OK, Java 8 is available" || echo "Uh oh, Java 8 is not available"
```

Earlier versions of Tomcat (< 7.0.30) do not run with Java 8 albeit being advertised to do so (related to [this bug](https://issues.apache.org/bugzilla/show_bug.cgi?id=53735)).
Ubuntu 12.04 Precise includes Tomcat in version 7.0.26, which therefore must be updated. If you run precise, execute these steps:

```
wget https://launchpad.net/ubuntu/+archive/primary/+files/libservlet3.0-java_7.0.52-1ubuntu0.1_all.deb
wget https://launchpad.net/ubuntu/+archive/primary/+files/libtomcat7-java_7.0.52-1ubuntu0.1_all.deb
wget https://launchpad.net/ubuntu/+archive/primary/+files/tomcat7-admin_7.0.52-1ubuntu0.1_all.deb
wget https://launchpad.net/ubuntu/+archive/primary/+files/tomcat7-common_7.0.52-1ubuntu0.1_all.deb
wget https://launchpad.net/ubuntu/+archive/primary/+files/tomcat7_7.0.52-1ubuntu0.1_all.deb
```

```
su
dpkg -i libservlet3.0-java_7.0.52-1ubuntu0.1_all.deb
dpkg -i libtomcat7-java_7.0.52-1ubuntu0.1_all.deb
dpkg -i tomcat7-common_7.0.52-1ubuntu0.1_all.deb
dpkg -i tomcat7-admin_7.0.52-1ubuntu0.1_all.deb
dpkg -i tomcat7_7.0.52-1ubuntu0.1_all.deb
```

If you run a more recent version, just install tomcat from the official sources:

```
su
apt-get install tomcat7
```

### **4**. install system packages required for running the software

```
su
apt-get install --no-install-recommends --yes mysql-server nginx curl
```

### **5**. install Neo4j

currently, we rely on Neo4j version 2.2.2

```
su
wget -O - http://debian.neo4j.org/neotechnology.gpg.key | apt-key add -
echo 'deb http://debian.neo4j.org/repo stable/' > /etc/apt/sources.list.d/neo4j.list
apt-get update
apt-get install --no-install-recommends --yes neo4j=2.2.2
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
Pin: version 2.2.2
Pin-Priority: 1000
```

### **6**. make sure, permissions are correctly

```
su
chown -R tomcat7:tomcat7 /data/log
chown -R mysql:mysql /data/mysql
chown -R neo4j:adm /data/neo4j
```

### **7**. install build environment for frontend

```
su
ln -s /usr/bin/nodejs /usr/bin/node
npm install -g grunt-cli karma bower
```

### **8**. setup MySQL

Create a database and a user for d:swarm. To customize the settings, edit `dswarm/persistence/src/main/resources/create_database.sql`. Do not check in this file in case you modify it. Hint: remember settings for step 13 (configure d:swarm).

    mysql -uroot -p < dswarm/persistence/src/main/resources/create_database.sql

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
cp -pr /var/lib/mysql/* /data/mysql/
```


### **9**.  setup Nginx

edit `/etc/nginx/sites-available/default` and add this just below the `location /` block

```
location /dmp {
        client_max_body_size 100M;
        proxy_pass http://127.0.0.1:8080$uri$is_args$args;
}
```
for very long running processes, add appropriate settings for timeouts such as the `proxy_read_timeout`, see http://nginx.org/en/docs/http/ngx_http_proxy_module.html.

move old content root and link the new one. lookout for the correct user path! (the directory will be created later on)

```
su
mv /usr/share/nginx/{html,-old}
ln -s /home/user/dswarm-backoffice-web/yo/publish /usr/share/nginx/html
```

### **10**. setup tomcat

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
echo 'export CATALINA_OPTS="-Xms4G -Xmx4G -XX:+CMSClassUnloadingEnabled -XX:+UseConcMarkSweepGC -XX:MaxPermSize=512M"' >> /usr/share/tomcat7/bin/setenv.sh
```

And finally, you have to tell Tomcat about Java 8. Open the file `/etc/default/tomcat7` and around line 12, add this setting

```
# The home directory of the Java development kit (JDK). You need at least
# JDK version 1.5. If JAVA_HOME is not set, some common directories for
# OpenJDK, the Sun JDK, and various J2SE 1.5 versions are tried.
JAVA_HOME=/usr/lib/jvm/java-8-oracle
```

### **11**. setup Neo4j

increase file handlers at `/etc/security/limits.conf`

```
root   soft    nofile  40000
root   hard    nofile  40000
```

plus add `ulimit -n 40000` into your neo4j service script (under `/etc/init.d', e.g., `/etc/init.d/neo4j-service`) before starting the daemon

edit `/etc/neo4j/neo4j.properties` and:

- insert some storage tweaks

```
dbms.pagecache.memory=8g
cache_type=weak
```

edit `/etc/neo4j/neo4j-server.properties` and:

- change the database location

```
org.neo4j.server.database.location=/data/neo4j/data/graph.db
```

- disable authentication

```
dbms.security.auth_enabled=false
```

- change the rrd database location

```
org.neo4j.server.webadmin.rrdb.location=/data/neo4j/data/rrd
```

- add our graph extension

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

### **12**. configure d:swarm

Follow the instructions in [[d:swarm Configuration|dswarm Configuration]] and make sure Tomcat has read access to the configuration file.


### **13**. build neo4j extension
Add our [Nexus server](http://nexus.slub-dresden.de:8081/nexus) to your maven settings.xml. The file should be located in the folder "~/.m2". If the file doesn't exist, create it simply using this [template](templates/settings.xml).

```
pushd dmp-graph
mvn -U -PRELEASE -DskipTests clean package
popd
mv dswarm-graph-neo4j/target/graph-1.2-jar-with-dependencies.jar dswarm-graph-neo4j.jar
```


### **14**. build backend

```
pushd dswarm
mvn -U -DskipTests clean install
pushd controller
mvn -U -DskipTests war:war
popd; popd
mv dswarm/controller/target/dswarm-controller-0.1-SNAPSHOT.war dmp.war
```

### **15**. build frontend

```
pushd dswarm-backoffice-web; pushd yo
npm install
bower install
STAGE=unstable DMP_HOME=../../dswarm grunt build
popd
rsync --delete --verbose --recursive yo/dist/ yo/publish
popd
```

* * *

**These steps require root level access**


### **16**. wire everything together

lookout for the correct path (/home/user)

```
su
rm /var/lib/tomcat7/webapps/dmp.war
rm -r /var/lib/tomcat7/webapps/dmp
cp /home/user/dmp.war /var/lib/tomcat7/webapps/
cp /home/user/dswarm-graph-neo4j.jar /usr/share/neo4j/plugins/
```


### **17**. restart everything, if needed

```
su
/etc/init.d/mysql restart
/etc/init.d/neo4j-service restart
/etc/init.d/nginx restart
/etc/init.d/tomcat7 restart
```

### **18**. initialize/reset database

**This step requires less privileged access**

When running the backend the first time, the MySQL database needs to be initialized. When updated, a reset is required in case the schema or initial data has changed.
lookout for the correct path (/home/user)

```
pushd dswarm/dev-tools
python reset-dbs.py \
  --persistence-module=../persistence \
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
pushd dswarm; git pull; popd
pushd dswarm-graph-neo4j; git pull; popd
pushd dswarm-backoffice-web; git pull; popd
```

### **2**. repeat steps [[13|Server-Install#13-build-neo4j-extension]] (Building neo4j-extension) to [[18|Server-Install#18-initializereset-database]] (Init DB) from the installation as necessary


## Checklist on Errors

First of all it's a good idea to know which of the four components front end, back end, MySQL and Neo4j database does not run. If you already know, skip this list.

* [[front end]]: open `http://localhost:9999` in a browser. The front end should be displayed.
* [[back end]]: open `http://localhost:8087/dmp/_ping` in a browser. The expected response is a page with the word _pong_.
* MySQL database: open a terminal and type `mysql -udmp -p dmp` to open a connection to MySQL and select the database _dmp_. Hint: check for correct user name, password and database name in case you did not use the default values. If you can log in, type `select * from DATA_MODEL;`. At least three internal data models should be listed.
* Neo4j database: open `http://localhost:7474/browser/` in a browser. The Neo4j browser should open.

Now that you know which component does not run, go through

<!--- even though it is most likely that the databases contain corrupted data, this is not the first point on the list since previous steps are required to initialize the dbs. -->

* is _curl_ installed?
* Did you choose a database name other than the default? If yes, you currently have to modify the `init_internal_schema.sql`, which is internally used by the script `reset-dbs.py` and change the `USE` database statement (this should be improved).
* when building the projects with maven, did you use the `-U` option to update project dependencies?
* Check your [[dswarm Configuration]]. Are database name and password correct, i.e., the ones used when installing MySQL (step [[Server-Install#8-setup-mysql]])? Compare _dswarm/persistence/src/main/resources/create_database.sql_ with _dswarm/dswarm.conf_ or any other configuration option you use.
* Can Tomcat read the configuration file?
* [[initialize the databases|Server-Install#18-initializereset-database]]. They may be empty or contain corrupted data caused by a failed unit tests.
* Did you miss an update of, e.g., the neo4j version? Compare your installed version with the required version (see [[step 5|Server-Install#5-install-neo4j]])
* Are the tmp folders and log folders existent and are they writeable (also for Tomcat)?
  * If you specified a tmp folder in the config, make sure it contains a tmp/resources and log folder
* Did you set the maximum file-size for uploads (see Step 9) to a sufficient value for your scenario? 