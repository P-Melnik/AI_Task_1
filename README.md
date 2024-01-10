# Social Media Application

## App Description

RESTful API for a simple social media application using Spring Boot, Hibernate, and PostgreSQL. The application allows users to create and view posts, follow other users, and like posts. Each post should have a title, body, and author. Hibernate is used to persist the post and user data in the PostgreSQL database.

## Endpoints and Examples

### UserController

- **Create User**
  - Endpoint: `POST /users`
  - JSON Example:
    ```json
    {
      "username": "john_doe"
    }
    ```
  
- **Get User by ID**
  - Endpoint: `GET /users/{userId}`
  - JSON Response Example:
    ```json
    {
      "id": 1,
      "username": "john_doe",
      "followedBy": [2, 3]
    }
    ```
  
- **Follow User**
  - Endpoint: `POST /users/{userId}/follow?followerId={followerId}`
  - JSON Response Example:
    ```json
    {
      "id": 1,
      "username": "john_doe",
      "followedBy": [2, 3, 4]
    }
    ```

### PostController

- **Create Post**
  - Endpoint: `POST /posts`
  - JSON Example:
    ```json
    {
      "title": "Spring Boot Rocks!",
      "body": "Building a social media app with Spring Boot.",
      "authorId": 1
    }
    ```
  
- **Get Posts by User**
  - Endpoint: `GET /posts/user/{userId}`
  - JSON Response Example:
    ```json
    [
      {
        "id": 1,
        "title": "Spring Boot Rocks!",
        "body": "Building a social media app with Spring Boot.",
        "authorId": 1,
        "likes": 10
      },
      {
        "id": 2,
        "title": "RESTful API Tutorial",
        "body": "Learn how to create a RESTful API.",
        "authorId": 1,
        "likes": 5
      }
    ]
    ```
  
- **Get Specific Post by User**
  - Endpoint: `GET /posts/user/{userId}/{postId}`
  - JSON Response Example:
    ```json
    {
      "id": 1,
      "title": "Spring Boot Rocks!",
      "body": "Building a social media app with Spring Boot.",
      "authorId": 1,
      "likes": 10
    }
    ```
  
- **Like Post**
  - Endpoint: `POST /posts/user/{userId}/{postId}/like`
  - JSON Response Example:
    ```json
    {
      "id": 1,
      "title": "Spring Boot Rocks!",
      "body": "Building a social media app with Spring Boot.",
      "authorId": 1,
      "likes": 11
    }
    ```

## Application Properties Configuration

Configure the `application.properties` file in your project with the following settings:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/{your_DB_name}
spring.datasource.username=your_database_username
spring.datasource.password=your_database_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format_sql=true



