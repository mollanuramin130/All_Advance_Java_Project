package com.ssn.login_register;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class ExecuteProcedure {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ADV_JAVA_DB", "123");
			System.out.println("Success");
			CallableStatement callStmt = conn.prepareCall("{ call STUDENT_DETAILS(?, ?, ?)}");
			
			callStmt.registerOutParameter(2, Types.VARCHAR);
			callStmt.registerOutParameter(3, Types.VARCHAR);
			
			System.out.println("Enter your roll Number(varchar2)");
			String roll=sc.nextLine().toUpperCase();
			callStmt.setString(1, roll);
			
			callStmt.execute();
			
			String name=callStmt.getString(2);
			String address=callStmt.getString(3);
			
			System.out.println("Given Roll No :"+roll);
			System.out.println("Corresponding Student Result:\nName: "+name+"\nAddress: "+address);
			

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
}
