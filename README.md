# Board Project

The Board project is a Spring Boot application that implements basic CRUD (Create, Read, Update, Delete) operations for managing board entries. It includes a web interface for viewing, creating, updating, and deleting boards.

## Project Structure

### Controllers

#### `BoardApiController`

- RESTful API controller responsible for handling board-related API requests.
- Provides endpoints for creating, updating, deleting, and retrieving board entries.

#### `BoardPageController`

- Controller for handling requests related to the web interface.
- Includes endpoints for displaying the board list, creating new boards, and viewing individual board entries.

### DTOs (Data Transfer Objects)

#### `BoardRequestDto`

- DTO for transferring data when creating or updating a board entry.

#### `BoardResponseDto`

- DTO for transferring data when retrieving a board entry.

### Entity

#### `Board`

- JPA Entity representing a board entry.
- Includes fields such as title, content, writer, hits, deleteYn, createdDate, and modifiedDate.
- Provides methods for updating, increasing hits, and deleting a board entry.

### Repository

#### `BoardRepository`

- JPA repository interface for performing CRUD operations on the `Board` entity.

### Service

#### `BoardService`

- Service layer containing business logic for board-related operations.
- Handles the creation, updating, deletion, and retrieval of board entries.

### Mapper

#### `BoardMapper`

- MyBatis Mapper interface for performing custom queries on board entries.

### Pagination

#### `CommonParams` and `Pagination`

- Classes related to handling pagination for board entries.

## Test

#### `BoardTest`

- JUnit test class for testing the functionality of the `BoardRepository`.
- Includes test cases for saving, finding all, and deleting board entries.

## Database Configuration

#### `DatabaseConfig`

- Configuration class for setting up the database connection using HikariCP and MyBatis.

## Exception Handling

#### `GlobalExceptionHandler`

- Exception handler for handling custom exceptions and providing appropriate responses.

## Contributing

If you wish to contribute to the Board project:

1. Fork the repository.
2. Create a new branch for your changes.
3. Commit and push your changes.
4. Submit a pull request.

Thank you for contributing!
