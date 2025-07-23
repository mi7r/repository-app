# Repository App

A simple application that provides listener for Kafka Topic `words.processed`. Retrieved messages are stored in PostgreSQL database.

Application exposes an endpoint ```GET /betvictor/history``` to retrieve last 10 computation results. Endpoint does not accept any parameters.


## Running the Application

Before running the application please run PostgreSQL locally to do so `docker` command can be used:

we can also use direct run command and image will be pulled automatically if does not exist:
```docker run -d -p 5432:5432 -e POSTGRES_USER=bvuser -e POSTGRES_PASSWORD=bvsecret -e POSTGRES_DB=computation_result --name computation-result-db postgres:17.5```

### Docker command description:
- `-d` - run container in detached mode
- `-p 5432:5432` - map port 5432 of the container to port 5432 of the host machine
- `-e POSTGRES_USER=bvuser` - set the PostgreSQL user to `bvuser`
- `-e POSTGRES_PASSWORD=bvsecret` - set the PostgreSQL password
- `-e POSTGRES_DB=computation_result` - set the PostgreSQL database name to `computation_result`
- `--name computation-result-db` - name the container `computation-result-db`
- `postgres:17.5` - use the PostgreSQL image version 17.5

Database and tables will be created automatically on application startup.

Database settings ```spring.jpa.hibernate.ddl-auto``` are set to ```create-drop``` it means that after application is
stopped, database will be dropped. To change this behavior, set it to ```update``` or ```none```
