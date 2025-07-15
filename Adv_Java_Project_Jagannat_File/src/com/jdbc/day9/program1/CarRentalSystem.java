package com.jdbc.day9.program1;

import java.sql.Statement;
import java.util.Arrays;
import java.sql.Connection;
import java.sql.DriverManager;

public class CarRentalSystem {
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
				
				stmt.addBatch("INSERT INTO CAR_INFO VALUES(101,'MARUTI',8000,'AVAILABLE')");
				stmt.addBatch("INSERT INTO CAR_INFO VALUES(102,'BMW',15000,'AVAILABLE')");
				stmt.addBatch("INSERT INTO CAR_INFO VALUES(103,'AUDI',9000,'AVAILABLE')");
				stmt.addBatch("INSERT INTO CAR_INFO VALUES(104,'TATA',6550,'AVAILABLE')");
				stmt.addBatch("INSERT INTO CAR_INFO VALUES(105,'HONDAI',9500,'AVAILABLE')");
				
				
				stmt.addBatch("UPDATE CAR_INFO SET AVAILABILITY_STATUS='BOOKED' WHERE CAR_ID=101");
				stmt.addBatch("UPDATE CAR_INFO SET AVAILABILITY_STATUS='BOOKED' WHERE CAR_ID=105");
				stmt.addBatch("UPDATE CAR_INFO SET AVAILABILITY_STATUS='BOOKED' WHERE CAR_ID=103");
				
				//stmt.addBatch("SELECT * FROM CAR_INFO"); //invalid because batch perform only write operation not read operation 
				
				stmt.addBatch("DELETE CAR_INFO WHERE CAR_RENT_PER_DAY>10000");
				
				int result[]=stmt.executeBatch();
				System.out.println(Arrays.toString(result));
				
				con.commit();
				System.out.println("Batch Processing Successfully!!!");
				
			} catch (Exception e) {
				con.rollback();
				e.printStackTrace();
			}
			
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
