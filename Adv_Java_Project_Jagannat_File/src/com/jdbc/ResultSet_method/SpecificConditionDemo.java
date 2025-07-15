package com.jdbc.ResultSet_method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SpecificConditionDemo {
	public static void main(String[] args) {

		try {
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ADV_JAVA_DB", "123");
			Statement smt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=smt.executeQuery("Select * from cars where Brand like 'T%'");
			rs.first();

			do {
				System.out.println("Brand: "+rs.getString(1)+"\tModel: "+rs.getString(2)+"\tYear: "+rs.getInt(3)+"\tType: "+rs.getString(4)+
						"\tMileage: "+rs.getInt(5));
			}while(rs.next());

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
