/*
 * Question:
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


 */


/*
 * Create table employee(id number(4) primary key, name varchar2(20), department varchar2(10), salary number(8,2));

Table EMPLOYEE created.
 * SQL> create Sequence employee_id_seq start with 1 increment by 1;

	Sequence EMPLOYEE_ID_SEQ created.
 */

package com.ssn.employee_servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	// This class will handle database operations related to employees.
	// It will include methods for adding, updating, listing, and deleting employees.
	
	// Example method to add an employee
	public void addEmployee(Employee employee) {
		// Code to add employee to the database
		// Use PreparedStatement to prevent SQL injection
		String name = employee.getName();
		String department = employee.getDepartment();
		double salary = employee.getSalary();
		// Code to insert employee into the database using JDBC
		// Example: String sql = "INSERT INTO employee (id,name, department, salary) VALUES (employee_id_seq.nextval,?, ?, ?)";
		String sql = "INSERT INTO employee (id,name, department, salary) VALUES (employee_id_seq.nextval, ?, ?, ?)";
		// Use PreparedStatement to execute the SQL query
		
		// Handle SQL exceptions and display user-friendly error messages
		// Example: catch (SQLException e) { e.printStackTrace(); }	
		// Ensure to close the PreparedStatement and Connection objects after use
		// Example: finally { if (preparedStatement != null) preparedStatement.close(); if (connection != null) connection.close(); }
		System.out.println("Employee added: " + name + ", Department: " + department + ", Salary: " + salary);
		Connection connection;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ADV_JAVA_DB", "123");
			java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);	
			
			preparedStatement.setString(2, department);
			
			preparedStatement.setDouble(3, salary);
			
			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Employee added successfully.");
			} else {
				System.out.println("Failed to add employee.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Replace with actual DB credentials
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	// Example method to update an employee's salary
	public void updateEmployeeSalary(String name, double newSalary) {
		// Code to update employee's salary in the database
		String sql = "UPDATE employee SET salary = ? WHERE name = ?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ADV_JAVA_DB", "123");
				java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setDouble(1, newSalary);
			preparedStatement.setString(2, name);
			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Employee salary updated successfully.");
			} else {
				System.out.println("No employee found with the given id.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Example method to list employees in a specific department
	public List<Employee> listEmployeesByDepartment(String department) {
		// Code to retrieve employees from the database by department
		return new ArrayList<>();
	}

	// Example method to delete an employee by id
	public void deleteEmployee(String name) {
		// Code to delete employee from the database
		String sql = "DELETE FROM employee WHERE name = ?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ADV_JAVA_DB", "123");
				java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, name);
			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Employee deleted successfully.");
			} else {
				System.out.println("No employee found with the given Name.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}