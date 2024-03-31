## Order control REST API 

### A full CRUD API for a model/entity Order, OrderItem, and Client

A fully functional API that controls order with the association with order items and clients. Made using:

* Java 11
* Maven
* JUnit
* Spring Boot
* Spring Data JPA
* Docker and Docker-compose
* PostgreSQL
* Lombok
* Swagger Documentation

### What this POC can do: 

How to structure a Spring Boot Java application using best practices and SOLID principles, using dependencies from Maven like Lombok to save time and create more readable and easy-to-maintain code, and associations (One to Many, Many to One, etc) using annotations.

### Swagger Documentation:

You can access it after the project runs in the /swagger-ui.html endpoint.

[![Click here for documentation](https://raw.githubusercontent.com/swagger-api/swagger.io/wordpress/images/assets/SW-logo-clr.png)](http://localhost:8080/swagger-ui.html)

### How to use:

You can use an API Test application, Postman or Insomnia, to test the endpoints you'll clone the project 
you'll need Java 11 and Maven 3.8.1 on your machine to run. The commands to clone and to run are the following:

Clone:
```shell script
git clone https://github.com/tranly8x/poc.git
```

Create a docker database:
To create and use the database, you'll need Docker and Docker Compose installed on your machine,
if that is the case you can enter the docker directory and run the command below.
```shell script
docker compose up -d
```
This command will automatically build de image for the postgres database, create the database and add a few
resources for you to test the endpoints.

Run: (in the root of project directory)
```shell script
mvn spring-boot:run
```
