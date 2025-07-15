package com.jdbc.day7.program2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class FetchEmpNameById {
	public static void main(String[] args) {
		callFunction();

	}

	public static void callFunction() {
		Scanner sc=new Scanner(System.in);
		try (Connection con = connect();) {
			CallableStatement cs = con.prepareCall("{? =call getTotalEmployees(?) }");
			cs.registerOutParameter(1, Types.NUMERIC);
			System.out.println("Enter your Employee Id");
			String emp_id=sc.nextLine();
			cs.setString(2, emp_id);
			cs.execute();
			String employeeName = cs.getString(1);
			System.out.println("Employee Name is : " + employeeName);
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
