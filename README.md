# Library-Project-Backend

# 📚 Library Backend API

A Spring Boot-based RESTful web service for managing a digital library system. This backend provides endpoints to **create**, **retrieve**, **update**, and **delete** books and authors using a MySQL database. Built with modular architecture and scalable patterns, it’s ideal for use in larger microservice-based ecosystems or as a backend for a library management system.

---

## 🚀 Features

- ✅ CRUD operations for **Books** and **Authors**
- 📘 Each book has:
  - Book ID (UUID)
  - Title
  - Description
  - Author ID (foreign key)

- 🧑‍💼 Each author has:
  - Author ID (UUID)
  - Name
  - Biography

- 🔗 Relational mapping (One-to-Many: Author → Books)
- 🌐 RESTful APIs using Spring Web
- 💾 MySQL database with JPA/Hibernate
- 📂 Layered architecture with Service and Repository separation
- 📦 JSON request/response body support
- 🔍 Exception handling with descriptive error responses

---

## 🛠️ Tech Stack

| Technology      | Usage                                 |
|------------------|----------------------------------------|
| **Spring Boot**  | Core application framework             |
| **Spring Web**   | Creating REST APIs                     |
| **Spring Data JPA** | ORM and data access layer           |
| **MySQL**        | Relational database                    |
| **Lombok**       | Reduces boilerplate code               |
| **Hibernate**    | JPA implementation                     |
| **Postman** / Swagger | API testing and documentation     |

---

## 📁 Project Structure

library-backend/
├── src/
│ ├── main/
│ │ ├── java/com/example/library/
│ │ │ ├── controller/
│ │ │ │ └── BookController.java
│ │ │ │ └── AuthorController.java
│ │ │ ├── service/
│ │ │ │ └── BookService.java
│ │ │ │ └── AuthorService.java
│ │ │ ├── repository/
│ │ │ │ └── BookRepository.java
│ │ │ │ └── AuthorRepository.java
│ │ │ ├── model/
│ │ │ │ └── Book.java
│ │ │ │ └── Author.java
│ │ │ └── LibraryApplication.java
│ └── resources/
│ └── application.properties
└── pom.xml

pgsql
Copy
Edit

---

## 📦 REST API Endpoints

### 🔹 Books

| Method | Endpoint              | Description            |
|--------|------------------------|------------------------|
| GET    | `/api/books`          | Get all books          |
| GET    | `/api/books/{id}`     | Get book by ID         |
| POST   | `/api/books`          | Create a new book      |
| PUT    | `/api/books/{id}`     | Update existing book   |
| DELETE | `/api/books/{id}`     | Delete book by ID      |

### 🔹 Authors

| Method | Endpoint              | Description              |
|--------|------------------------|--------------------------|
| GET    | `/api/authors`        | Get all authors          |
| GET    | `/api/authors/{id}`   | Get author by ID         |
| POST   | `/api/authors`        | Create a new author      |
| PUT    | `/api/authors/{id}`   | Update existing author   |
| DELETE | `/api/authors/{id}`   | Delete author by ID      |

---

## 🔧 Configuration

### `application.properties`


spring.datasource.url=jdbc:mysql://localhost:3306/library_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
🧪 Running the Application
Prerequisites
Java 17+

Maven 3.8+

MySQL Server

Steps
Clone the repository:

bash
Copy
Edit
git clone https://github.com/yourusername/library-backend.git
cd library-backend
Create a MySQL database:

sql
Copy
Edit
CREATE DATABASE library_db;
Update your application.properties file with your DB credentials.

Build and run the application:

bash
Copy
Edit
mvn spring-boot:run
Test the endpoints using Postman or Swagger.

📈 Future Enhancements
📚 Add genres, tags, and availability status

📅 Borrow/return tracking and due date logic

🔐 User roles (admin/librarian/reader) with Spring Security

📊 API documentation via Swagger UI

🧪 Unit and integration test coverage

🤝 Contributing
Contributions are welcome!

Fork the repo

Create your feature branch: git checkout -b feature/new-feature

Commit your changes: git commit -m "Add new feature"

Push to the branch: git push origin feature/new-feature

Open a Pull Request

