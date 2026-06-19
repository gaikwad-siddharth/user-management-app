# User Management Application

A Spring Boot REST API application for managing user registration, login, password reset, and location management (Country, State, City). The application also integrates Gmail SMTP to send registration emails and consumes a public Quote API.

---

## Features

- User Registration
- User Login
- Password Reset
- Country, State, City APIs
- Email Notification using Gmail SMTP
- Random Password Generation
- Quote API Integration
- Swagger API Documentation
- MySQL Database
- DTO & Entity Mapping using ModelMapper

---

## Technologies Used

- Java 17+
- Spring Boot
- Spring Data JPA
- Spring Web
- Spring Mail
- MySQL
- ModelMapper
- Lombok
- Swagger (OpenAPI)
- Maven

---

## Project Structure

```
src
├── main
│   ├── java
│   │   ├── config
│   │   ├── controller
│   │   ├── dto
│   │   ├── entity
│   │   ├── repo
│   │   ├── service
│   └── resources
│       └── application.properties
```

---

## REST APIs

### Get Countries

```
GET /countries
```

### Get States

```
GET /states/{countryId}
```

### Get Cities

```
GET /cities/{stateId}
```

### Register User

```
POST /user
```

Request Body

```json
{
  "name":"John",
  "email":"john@gmail.com",
  "phno":9876543210,
  "countryId":1,
  "stateId":2,
  "cityId":3
}
```

---

### Login

```
POST /login
```

Request

```json
{
  "email":"john@gmail.com",
  "pwd":"ABC12"
}
```

---

### Reset Password

```
POST /reset-pwd
```

Request

```json
{
  "email":"john@gmail.com",
  "newPwd":"welcome123",
  "confirmPwd":"welcome123"
}
```

---

### Get Random Quote

```
GET /quote
```

---

## Database

Database used:

```
MySQL
```

Tables

- country_master
- state_master
- city_master
- user_master

---

## Email Configuration

Configure Gmail SMTP in `application.properties`

```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your_email@gmail.com
spring.mail.password=your_app_password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

> Use a Gmail **App Password** instead of your Gmail account password.

---

## Swagger

After running the application

```
http://localhost:8080/swagger-ui/index.html
```

---

## Quote API

The application consumes

```
https://dummyjson.com/quotes/random
```

to fetch a random motivational quote.

---

## Running the Project

Clone the repository

```bash
git clone https://github.com/yourusername/user-management-app.git
```

Navigate to the project

```bash
cd user-management-app
```

Run

```bash
mvn spring-boot:run
```

or

Run the `main()` method from your IDE.

---

## Dependencies

- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- Spring Boot Starter Mail
- MySQL Connector
- Lombok
- ModelMapper
- Swagger OpenAPI

---

## Future Enhancements

- JWT Authentication
- Spring Security
- Forgot Password via OTP
- Email Verification
- Docker Support
- Unit Testing
- Role-Based Authorization

---

## Author

**Siddharth Gaikwad**

GitHub: https://github.com/gaikwad-siddharth

LinkedIn: https://www.linkedin.com/in/gaikwad-siddharth/

---
