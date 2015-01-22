_These are the installation instructions for *developers* and will skip some steps described in the [Server-Install](server install) that are not required for development._

## Initial Installation

premise:
- currently, we've developed the application only on Ubuntu Linux distributions (empty trusty, 14.04) and OS X. If you experience problems developing on Windows, please contact us.
- let the $HOME of the less privileged user be '/home/user'
- all commands boxes start as the less privileged user and in their $HOME.
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

### **3**. add ssh key to to your github user profile
see https://help.github.com/articles/generating-ssh-keys/

### **4**. clone repositories (not as root!)

lookout for the correct path (/home/user)

```
cd /home/user

git clone --depth 1 --branch builds/unstable git@github.com:dswarm/dswarm.git
git clone --depth 1 --branch master git@github.com:dswarm/dswarm-graph-neo4j.git
git clone --depth 1 --branch builds/unstable git@github.com:dswarm/dswarm-backoffice-web.git

```

* * *

**These steps require root level access**

### **5**. install Java for the backend

- D:SWARM requires Java 8, which is no longer available in the default package sources. Follow [these steps](http://www.webupd8.org/2012/09/install-oracle-java-8-in-ubuntu-via-ppa.html)

```
su
add-apt-repository ppa:webupd8team/java
apt-get update
apt-get install oracle-java8-installer oracle-java8-set-default
```

You can verify your java version with (empty output means)

```
java -version 2>&1 | grep -q "1.8" && echo "OK, Java 8 is available" || echo "Uh oh, Java 8 is not available"
```


### **6**. install system packages required for running the software

```
su
apt-get install --no-install-recommends --yes mysql-server curl
```


### **7**. install Neo4j

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

### **8**. make sure, permissions are correctly
_If you didn't change the default places where mysql and neo4j store their data, this step should not be necessary._ If you still think you need to set the rights, the default places should be "/var/lib/mysql" and "/var/lib/neo4j/data" )

```
su
chown -R mysql:mysql <mysql-data-directory>
chown -R neo4j:adm <neo4j-data-directory>
```


### **9**. install build environment for frontend

```
su
ln -s /usr/bin/nodejs /usr/bin/node
npm install -g grunt-cli karma bower
```

### **10**. setup MySQL

Create a database and a user for d:swarm. To customize the settings, edit `dswarm/persistence/src/main/resources/create_database.sql`. Do not check in this file in case you modify it. Hint: remember settings for step 13 (configure d:swarm).

    mysql -uroot -p < persistence/src/main/resources/create_database.sql

Then, open `/etc/mysql/my.cnf` and add the following line to the section `[mysqld]` (around line 45)

```
wait_timeout = 1209600
```

### **11**. setup Neo4j

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
neostore.nodestore.db.mapped_memory=512M
neostore.relationshipstore.db.mapped_memory=2G
neostore.propertystore.db.mapped_memory=512M
neostore.propertystore.db.strings.mapped_memory=512M
cache_type=weak
```

edit `/etc/neo4j/neo4j-server.properties` and at line 75 and add our graph extension

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
wrapper.java.maxmemory=4096
```

By default, the Neo4j Server is bundled with a Web server that binds to host localhost on port 7474, answering only requests from the local machine.

* * *

**These steps require less privileged access**

### **12**. configure d:swarm
Place a file named `dswarm.conf` somewhere in your filesystem and put in the following content

    cat <<EOF>>dswarm.conf
    dswarm.db.metadata.username=foo
    dswarm.db.metadata.password=bar
    EOF

Username and password are used to access the MySQL database (hint: use same as in step `setup MySQL` in [server-insatll](server-insatll.md))
You should not put this file under version control. Name it either `dswarm.conf` or `dmp.conf`, and place it in the root directory (of project `dswarm`). These files are already ignored by git.

More information about configuration you get here: [[d:swarm Configuration|dswarm Configuration]].


### **13**. build neo4j extension
Add our [Nexus server](http://nexus.slub-dresden.de:8081/nexus) to your maven settings.xml. The file should be located in the folder "~/.m2". If the file doesn't exist, create it simply using this [template](templates/settings.xml).

```
pushd dswarm-graph-neo4j
mvn -U -PRELEASE -DskipTests clean package
popd
mv dswarm-graph-neo4j/target/graph-1.1-jar-with-dependencies.jar dswarm-graph-neo4j.jar
```


### **14**. build backend

```
pushd dswarm
mvn -U -DskipTests clean install
popd
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
cp /home/user/dswarm-graph-neo4j.jar /usr/share/neo4j/plugins/
```


### **17**. restart everything, if needed

```
su
/etc/init.d/mysql restart
/etc/init.d/neo4j-service restart
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

For now , please refer to the [[Server-Install|Server-Install#update-the-system]] for updating the system.


## Checklist on Errors

For now , please use the checklist from the [[Server-Install|Server-Install#checklist-on-errors]]. Please keep in mind that the links used there will take you to the server install not to the developer version!
