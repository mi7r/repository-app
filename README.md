# Repository App

Provides Listener for Kafka Topic `words.processed`

Expose endpoint to retrieve last 10 processed results.

Run PostgreSQL locally via Docker:
```docker pull postgres:17.5```

we can also use direct run command and image will be pulled automatically if does not exist:
```docker run -d -p 5432:5432 -e POSTGRES_USER=bvuser -e POSTGRES_PASSWORD=bvsecret -e POSTGRES_DB=computation_result --name computation-result-db postgres:17.5```

Database and tables will be created automatically on application startup.

Database settings ```spring.jpa.hibernate.ddl-auto``` are set to ```create-drop``` it means that after application is
stopped, database will be dropped. To change this behavior, set it to ```update``` or ```none```
