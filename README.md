# CMS Test Application

A small application for client management.

Requires: 
- docker
- java 21
- mysql

Build tool:
- Maven

Uses:
- Spring Security
- Spring JPA
- Openapi
- Swagger UI

To execute locally, a docker-compose.yml file is provided. The file can be executed with the command:

```bash
docker compose up -d
```

The configuration exposes the app on port 8080

API can be accesed on [localhost](http://localhost:8080/actuator)
