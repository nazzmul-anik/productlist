# 📌 Project Purpose

**The main goal of this project is to maintain a standard, scalable, and secure backend architecture with JWT-based authentication and Spring Security integration:**

Proper layered structure

DTO pattern

Mapper layer

Service layer abstraction

Custom exception handling

Global exception management

Swagger API documentation

Stateless authentication and authorization using Spring Security and JWT

# 📦 Features
**Product Module**

Create Product

Get All Products

Get Product By ID

Update Product

Delete Product

**Category Module**

Create Category

Get All Categories

Get Category By ID

Update Category

Delete Category

# 🚀 Tech Stack

Java 25

Spring Boot 4

Spring Security

JWT (JSON Web Token)

Spring Data JPA

MySQL

Swagger / OpenAPI (springdoc)

Lombok

Maven

# 🔐 Security Implementation (Spring Security + JWT)

This project is secured using Spring Security with JWT (JSON Web Token) authentication to ensure stateless and secure API access.

✅ Security Features

Stateless Authentication (No Session)

JWT-based Login System

Secure Password Encoding (BCrypt)

Custom Authentication Filter

Role-based Authorization Ready Structure

Protected API Endpoints

Custom Authentication & Authorization Exception Handling

Future-ready for OAuth2 integration


# 🧾 Swagger API Documentation

Swagger UI is integrated for developer-friendly API testing and documentation.

http://localhost:8080/swagger-ui/index.html

# ⚙️ Database Configuration

Update application.properties:


spring.datasource.url=jdbc:mysql://localhost:3306/productlist


spring.datasource.username=root


spring.datasource.password=your_password


spring.jpa.hibernate.ddl-auto=update


spring.jpa.show-sql=true
