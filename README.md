# Gitto API

This project uses **Java 17** with *Spring* and *Postgres* to produce a **RESTful API** for **gitto**.

![Spring Badge](https://img.shields.io/badge/Spring-6DB33F?logo=spring&logoColor=fff&style=for-the-badge)
![Spring Security Badge](https://img.shields.io/badge/Spring%20Security-6DB33F?logo=springsecurity&logoColor=fff&style=for-the-badge)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Postman Badge](https://img.shields.io/badge/Postman-FF6C37?logo=postman&logoColor=fff&style=for-the-badge)

## How to run

1. **RECOMMENDED** Run with Docker:

    1. First Ensure that the following properties are set in application.properties:
       ```properties
       spring.datasource.url=jdbc:postgresql://dbpostgresql:5432/gitto
       spring.datasource.username=postgres
       spring.datasource.password=password
        ```
   
    2. Then run the following:
       ```bash
       mvn clean package -DskipTests
       docker-compose up --build
       ```
   
2. Run locally:
    
    1. Setup a table **gitto** in postgres
       ```postgresql
       CREATE DATABASE gitto;
       ```
    2. Create a user **gitto** with password **gitto** and give them full permission over the **gitto** table
       ```postgresql
       CREATE USER gitto WITH PASSWORD 'gitto';
       GRANT ALL PRIVILEGES ON DATABASE gitto TO gitto;
       ``` 
    3. Ensure the following properties are set in appllication.properties:
       ```properties
       spring.datasource.url=jdbc:postgresql://psql:5432/gitto
       spring.datasource.username=gitto
       spring.datasource.password=gitto
       ```
    4. Run the following:
       ```bash
       mvn spring-boot:run
       ```