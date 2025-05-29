# Spring Boot API: Person & Hobby Management

This is a RESTful API built with Spring Boot, JPA, and PostgreSQL to manage people and their hobbies.

## Features

- CRUD operations for **Person**
- CRUD operations for **Hobby** (linked to a Person)
- Search API: Find people by hobby
- PostgreSQL integration with Hibernate
- JPA repositories and clean controller structure

## Tech Stack

- Java 17+
- Spring Boot 3.5
- Spring Data JPA
- PostgreSQL
- Maven

## API Endpoints

### Person
- `POST /persons`
- `GET /persons`
- `PUT /persons/{id}`
- `DELETE /persons/{id}`

### Hobby
- `POST /hobbies/person/{personId}`
- `GET /hobbies/person/{personId}`
- `PUT /hobbies/{id}`
- `DELETE /hobbies/{id}`

### Search
- `GET /persons/hobby/{hobbyName}`
## 🛠️ Setup

1. Install PostgreSQL and create a DB (e.g., `persondb`)
2. Configure `src/main/resources/application.properties` with your DB credentials
3. Run the following line of code in your terminal:

```bash
./mvnw spring-boot:run
