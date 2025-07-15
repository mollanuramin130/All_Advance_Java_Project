package com.jdbc.day7.program1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallableStatementExample {
	public static void main(String[] args) {
		callFunction();

	}

	public static void callFunction() {
		try (Connection con = connect();) {
			CallableStatement cs = con.prepareCall("{? =call getTotalEmployees() }");
			cs.registerOutParameter(1, Types.NUMERIC);
			cs.execute();
			int total_emp = cs.getInt(1);
			System.out.println("Total Number of Employee is : " + total_emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection connect() throws SQLException {
		final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		final String username = "ADV_JAVA_DB";
		final String password = "123";
		Connection connection = DriverManager.getConnection(url, username, password);

		return connection;
	}
}
