package com.jdbc.day9.program2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;

public class ProductDiscountCampaign {
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
				
				stmt.addBatch("INSERT INTO PRODUCT_INFO(P_ID,P_NAME,PRICE,DISCOUNT_PERCENTAGE) VALUES(1,'MOBILE',26000,'30')");
				stmt.addBatch("INSERT INTO PRODUCT_INFO(P_ID,P_NAME,PRICE,DISCOUNT_PERCENTAGE) VALUES(2,'T-SHIRT',300,'10')");
				stmt.addBatch("INSERT INTO PRODUCT_INFO(P_ID,P_NAME,PRICE,DISCOUNT_PERCENTAGE) VALUES(3,'SHAMPOO',200,'60')");
				stmt.addBatch("INSERT INTO PRODUCT_INFO(P_ID,P_NAME,PRICE,DISCOUNT_PERCENTAGE) VALUES(4,'LAPTOP',55000,'35')");
				stmt.addBatch("INSERT INTO PRODUCT_INFO(P_ID,P_NAME,PRICE,DISCOUNT_PERCENTAGE) VALUES(5,'JEANS',2000,'40')");
				
				
				
				stmt.addBatch("UPDATE PRODUCT_INFO SET PRICE=PRICE-(PRICE*DISCOUNT_PERCENTAGE)/100");
				
				//stmt.addBatch("SELECT * FROM PRODUCT_INFO"); //invalid because batch perform only write operation not read operation 
				
				stmt.addBatch("DELETE PRODUCT_INFO WHERE PRICE<100");
				
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
