# jktech Secured Doc Manager

A Java Spring Boot application that provides secure document management with JWT-based authentication, document upload and search capabilities, and integrated Swagger API documentation.

## 🚀 Features

- 🔐 JWT-based user authentication
- 📄 Upload and retrieve documents
- 🔍 Search documents by content or metadata
- 📘 Swagger UI for API testing and documentation
- 🛡️ CORS and security configurations

## 🛠️ Technologies Used

- Java 17
- Mysql 8
- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- Apache Tika (for document parsing)
- Swagger (Springfox)
- Maven
- PostMan Collection Added Project Root Directory

## 📁 Project Structure
src/
└── main/
    └── java/
        └── com/
            └── jk/
                └── jktech/
                    ├── JktechApplication.java               # Main Spring Boot application class
                    
                    ├── configs/                            # Configuration classes
                    │   ├── CorsConfig.java                 # CORS settings
                    │   ├── EncoderConfig.java              # Password encoder bean
                    │   ├── JwtUtil.java                    # JWT utility methods
                    │   ├── SecurityConfig.java             # Spring Security configuration
                    │   └── SwaggerConfig.java              # Swagger documentation setup
                    
                    ├── controllers/                        # REST controllers
                    │   ├── AuthController.java             # Handles login, logout, registration
                    │   ├── DocumentController.java         # Upload and retrieve documents
                    │   └── QAController.java               # Search documents
                    
                    ├── entities/                           # Entity classes
                    │   ├── Document.java                   # Document model with fields like id, title, content, etc.
                    │   └── User.java                       # User model with fields like id, username, password, role
                    
                    └── repositories/                       # Spring Data JPA repositories
                        └── DocumentRepository.java         # Interface for document queries
--------------------------------------------------------------------------------------------------------------------------------------
## ⚙️ Setup Instructions

1. **Clone the repository**
   git clone https://github.com//jktech.git](https://github.com/senshah06/doc-manager.git
   cd jktech

2. Build and run the application
    mvn clean install
    mvn spring-boot:run
---------------------------------------------------------------------------------------------------------------------------------------
Access Swagger UI : http://localhost:8080/swagger-ui/index.html

   

                        
                        
