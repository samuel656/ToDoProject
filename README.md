# 📝 ToDo Application (Spring Boot + Spring Security + MySQL)

## ✅ToDo Management:

      1. Add new tasks with descriptions and target dates.
      2. View the list of existing ToDos.
      3. Update the tasks as per user requirement.
      4. Mark tasks as completed (done).
      5. Built-in form validation (e.g., min character check for description).

## A simple and secure ToDo List Web Application built with Spring Boot
      - ✅ User authentication with Spring Security
      - 🛡️ Session-based login and role-based access control
      - 📄 Add, view, and delete ToDos with form validation
      - 🗓️ Target dates and completion status tracking
      - 💾 Data persistence using MySQL
      - 🔒 CSRF protection (configurable)
      - 📦 Layered architecture using MVC pattern

# 📌 Technologies Used
        1. Java 17+
        2. Spring Boot
        3. Spring MVC
        4. Spring Security
        5. Spring Data JPA
        6. Database - MySQL
        7. JSP + JSTL (for views)
        8. Bootstrap (for basic UI styling)

# ⚙️ Features
      - Login/Logout functionality
      - Add ToDo with description and target date
      - Form validation using @Valid and BindingResult
      - Protect routes with Spring Security
      - Connect to MySQL using Spring Data JPA

# 💡 Highlights:
      - @Valid and BindingResult used for server-side input validation.
      - HttpSession used to store logged-in user details.
      - Application gracefully handles form errors and redirects.
      - Configured to connect to a MySQL database using application.properties.
      - Supports schema auto-creation using spring.jpa.hibernate.ddl-auto=update.

# 🛠️ Setup Instructions
      - Clone this repository
      - Update application.properties with your MySQL credentials
      - Run the application with mvn spring-boot:run or through your IDE
      - Access at: http://localhost:8080/login

