# Expense Manager Backend

## Short Description
Spring Boot backend for managing personal expenses with a MySQL database.

## Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok
- Maven
- Postman (for API testing)

## Features
- User registration with encrypted passwords
- Add, view, update, and delete expenses
- Each expense linked to a specific user
- REST API endpoints for easy integration

## Database Schema

**Users Table**
| Column   | Type    |
|----------|---------|
| id       | BIGINT  |
| email    | VARCHAR |
| password | VARCHAR |

**Expenses Table**
| Column   | Type    |
|----------|---------|
| id       | BIGINT  |
| title    | VARCHAR |
| amount   | DECIMAL |
| category | VARCHAR |
| user_id  | BIGINT  |

## API Endpoints

**User Authentication**
- `POST /api/auth/register` → Register new user

**Expense Management**
- `POST /api/expenses` → Add a new expense
- `GET /api/expenses?email={userEmail}` → Get all expenses for a user
- `PUT /api/expenses/{id}` → Update an existing expense
- `DELETE /api/expenses/{id}` → Delete an expense

## How to Run the Project
1. Clone or download the repository.
2. Import the project into Eclipse or IntelliJ.
3. Configure MySQL in `application.properties`:
   **properties** - spring.datasource.url=jdbc:mysql://localhost:3306/expense_db
                spring.datasource.username=root
                spring.datasource.password=YOUR_PASSWORD_HERE
4. Run ExpenseManagerApplication.java.
5. Use Postman to test API endpoints.
**Postman Testing**
     Example JSON to add an expense:
_Json_
{
  "title": "Food",
  "amount": 500,
  "category": "Groceries",
  "user": {
    "id": 1
  }
}
**Notes**
Replace YOUR_PASSWORD_HERE with your MySQL password.
Make sure your MySQL server is running and the database expense_db exists.
You can extend this project by adding JWT authentication, categories, or reports.
