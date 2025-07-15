package com.jdbc.day9.program3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

public class EmployeeSalaryUpdate {
	public static void main(String[] args) {
		final String url="jdbc:oracle:thin:@localhost:1521:XE";
		final String username="ADV_JAVA_DB";
		final String password="123";
		try(
				Connection con=DriverManager.getConnection(url,username,password);
				Statement stmt=con.createStatement();
				
				){
			try {
				System.out.println("Connection Establish...");
				
				con.setAutoCommit(false);
				
				stmt.addBatch("INSERT INTO EMPLOYEES(EMP_ID,EMP_NAME,SALARY) VALUES(1,'MICHAEL',45000.00)");
				stmt.addBatch("INSERT INTO EMPLOYEES(EMP_ID,EMP_NAME,SALARY) VALUES(2,'SARAH',52000.00)");
				//stmt.addBatch("INSERT INTO EMPLOYEES(EMP_ID,EMP_NAME,SALARY) VALUES(2,'SARAH',55000.00)");
				
				//stmt.addBatch("SELECT * FROM CAR_INFO"); //invalid because batch perform only write operation not read operation 
				
				stmt.addBatch("UPDATE EMPLOYEES SET SALARY=SALARY+5000");
				
				int result[]=stmt.executeBatch();
				System.out.println(Arrays.toString(result));
				
				ResultSet rSet=stmt.executeQuery("SELECT SALARY FROM EMPLOYEES");
				
				boolean flag=true;
				
				while(rSet.next()) {
					if(rSet.getDouble(1)>60000) {
						con.rollback();
						System.out.println("Salary cap exceeded! Transaction rolled back.");
						flag=false;
						break;
					}
				}
				if(flag) {
					
					con.commit();
					System.out.println("Salary updates committed successfully.");
				}
				
				
			} catch (Exception e) {
				con.rollback();
				e.printStackTrace();
			}
			
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
