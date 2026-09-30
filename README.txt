FULL STACK STUDENT CRUD PROJECT
HTML + CSS + JavaScript + Spring Boot + JDBC + MySQL

Architecture:
HTML/CSS/JavaScript -> Spring Boot REST API -> JDBC -> MySQL

REQUIREMENTS
1. JDK 17 or newer
2. Maven 3.9+
3. MySQL 8+
4. Browser

STEP 1 - DATABASE
Run database.sql in MySQL Workbench or MySQL command line.

STEP 2 - MYSQL PASSWORD
Open:
backend/src/main/resources/application.properties

Change:
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD

STEP 3 - START JAVA BACKEND
Open terminal inside the backend folder:
mvn spring-boot:run

Backend URL:
http://localhost:8080

STEP 4 - START FRONTEND
For easiest use, open frontend/index.html through a local server.
For example, in the frontend folder:
python -m http.server 5500

Then open:
http://localhost:5500

The frontend uses JavaScript fetch() to call:
http://localhost:8080/api/students

FEATURES
- Add student
- Display all students
- Edit student
- Delete student
- JDBC PreparedStatement through JdbcTemplate
- MySQL database
