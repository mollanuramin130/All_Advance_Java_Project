<%--
Question:
Design and implement a Java application that manages employee records in a company using a relational database. The application should provide the following functionalities:
•	Add a new employee with fields: id, name, department, and salary.
•	Update the salary of an existing employee by their id.
•	Retrieve a list of all employees in a specific department, sorted by salary in descending order.
•	Delete an employee record by id.
Requirements:
•	Use JDBC for database connectivity and operations.
•	Use PreparedStatement for all SQL queries to prevent SQL injection.
•	Handle SQL exceptions gracefully and display user-friendly error messages.
•	Write a class EmployeeDAO that encapsulates all database operations.
•	Demonstrate usage of your DAO class in a main method with sample data.


 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- Employee delete jsp page -->
<h1>Employee Management System</h1>
<form action="EmployeeServlet" method="post">
    <h2>Delete Employee</h2>
    <label for="id">Employee Name:</label>
    <input type="text" id="id" name="name" required><br><br>
    
    <input type="submit" value="deleteEmployee" name="button">
    </form>
    <!-- Back to home index.jsp page button	 -->
    <br><br>
    <a href="index.jsp">Back to Home</a>
</body>
</html>