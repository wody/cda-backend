# Backend component of CDA Demo App

## REST API Backend of CDA Demo App

### Download Artifact
You can find the binary artifact on the releases page. 

[Current Artifact Download](https://github.com/wody/cda-backend/releases/latest/download/cdapp-api.jar)

### Configuration needed
Provide an application.properties file with the following configuration values:

```
spring.datasource.url=jdbc:postgresql://<DATABASE_IP>:<DATABASE_PORT>/<DATABASE_NAME>
spring.datasource.username=<USER_NAME>
spring.datasource.password=<USER_PASSWORD>
```

### Start as UNIX service
The provided **jar**File is a executable JAR File containing a service wrapper script.

You can directely use it to run as a service:

**init.d:**

Just symlink to the JAR-File:
```
sudo ln -s /opt/cda/cdapp-api.jar /etc/init.d/cdapp
service cdapp start
```

**Systemd:**

Create a system service file under `/etc/systemd/system` as follows:
```
[Unit]
Description=cdapp
After=syslog.target

[Service]
User=cda
ExecStart=/opt/cda/cdapp-api.jar
SuccessExitStatus=143

[Install]
WantedBy=multi-user.target
```
This assumes you have installed the jar in `/opt/cda` with owner set to user `cda`!

Enable the service
```
systemctl enable cdapp.service
```

**Securing:**

Make sure you set minimal rights and make the file immutable!

```
chown cda:cda cdapp-api.jar
chmod 500 cdapp-api.jar
sudo chattr +i cdapp-api.jar
```

## Database

A **PostgreSQL** Database is needed.

Execute all SQL Files provided in the `sql` folder on the database used in the `application.properties` settings file above!
