# Counter Retrieval Service

This microservice provides functionalities to retrieve usage data in a basic COUNTER-like format from SUSHI interfaces or from uploaded files.
Data are stored in flattened database tables.

Currently implemented are journal report 1, book reports 1 and 2 and database reports 


## Structure
The service comprises of a Spring Batch service and several repositories. It can be deployed in a microservice architecture. 
It uses three databases:
 
- The default datasource stores the SUSHI-Profiles, log-data and Spring Batch data. 
- The second one ("data") is used to store the retrieved usage data.
- The third one (Redis) is used by Spring Session, if the application is integrated into a microservice architecture.

the first two can be configured via the .properties file, either directly in the resources-folder or provided via a config server.
The properties need to contain the following lines:

```
spring.data.datasource.jdbc-url=<url default database>
spring.data.datasource.data-username=<username default database>
spring.data.datasource.password=<password default database

spring.datasource.jdbc-url=<url data database>
spring.datasource.data-username=<username data database>
spring.datasource.password=<password data database>
```
