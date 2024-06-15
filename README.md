### Objective

Create a RESTful API for managing a bookstore. The API should allow users to perform CRUD operations (Create, Read, Update, Delete) on books and authors.

### Requirements

1. **Setup and Project Initialization**
    - Create a new Spring Boot project using Spring Initializr with the following dependencies:
        - Spring Web
        - Spring Data JPA
        - H2 Database (or any other database of your choice)
        - Spring Boot DevTools
        - Lombok (optional but recommended for reducing boilerplate code)
2. **Entities and Database Schema**
    - Define two entities: `Book` and `Author`.
        - `Book` should have the following fields:
            - `id` (Long, primary key)
            - `title` (String)
            - `isbn` (String)
            - `publishedDate` (Date)
            - `author` (Many-to-One relationship with `Author`)
        - `Author` should have the following fields:
            - `id` (Long, primary key)
            - `name` (String)
            - `biography` (String)
    - Use JPA annotations to map these entities to the database tables.
3. **Repository Layer**
    - Create repository interfaces for `Book` and `Author` by extending `JpaRepository`.
4. **Service Layer**
    - Create service classes for `Book` and `Author` to handle business logic.
    - Implement methods for CRUD operations in the service classes.
5. **Controller Layer**
    - Create REST controllers for `Book` and `Author`.
    - Implement the following endpoints:
        - `GET /api/books` - Retrieve all books
        - `GET /api/books/{id}` - Retrieve a book by ID
        - `POST /api/books` - Create a new book
        - `PUT /api/books/{id}` - Update a book by ID
        - `DELETE /api/books/{id}` - Delete a book by ID
        - `GET /api/authors` - Retrieve all authors
        - `GET /api/authors/{id}` - Retrieve an author by ID
        - `POST /api/authors` - Create a new author
        - `PUT /api/authors/{id}` - Update an author by ID
        - `DELETE /api/authors/{id}` - Delete an author by ID
6. **Validation and Exception Handling**
    - Add validation to ensure that the required fields are provided and valid.
    - Implement global exception handling to manage errors gracefully.
7. **Testing**
    - Write unit tests for service classes.
    - Write integration tests for controller endpoints.
8. **Documentation**
    - Use Swagger/OpenAPI to document your API.
    - Include the necessary annotations to generate API documentation.

### Instructions

1. **Project Setup**
    - Initialize your project using Spring Initializr or your preferred IDE.
2. **Create Entities**
    - Define `Book` and `Author` entities with appropriate JPA annotations.
3. **Repository Interfaces**
    - Create repository interfaces for `Book` and `Author`.
4. **Service Implementation**
    - Implement service classes with methods for CRUD operations.
5. **Controller Implementation**
    - Create REST controllers with endpoints for managing books and authors.
6. **Add Validation**
    - Use `@Valid` and `@Validated` annotations to add validation to your request payloads.
7. **Exception Handling**
    - Implement a global exception handler using `@ControllerAdvice`.
8. **Testing**
    - Write unit and integration tests to ensure your API works correctly.
9. **API Documentation**
    - Configure Swagger to generate API documentation.

### Bonus

- Implement pagination and sorting for the `GET /api/books` and `GET /api/authors` endpoints.
- Add a search endpoint to filter books by title, author, or publication date.
- Secure your API using Spring Security.