package com.jdbc.nur_query_class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public final class NurCreateTable {

	public static void createTable() {
		Scanner sc=new Scanner(System.in);

		System.out.println("Enter your table name: ");
		try(Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ADV_JAVA_DB", "123");
			Statement smt=conn.createStatement();sc) {
			boolean getPass=true;
			String tableName=sc.nextLine().toUpperCase();
			ResultSet tableNameSet=smt.executeQuery("select * from tab");
			while(tableNameSet.next()) {
				if(tableName.equalsIgnoreCase(tableNameSet.getString(1))) {
					System.out.println("Your Enter table name already exist Try Another name....\n\n");
					getPass=false;
					break;
				}
			}
			if(getPass) {

				System.out.print("\nEnter number of columns you want to add: ");
				int columnNumber=Integer.parseInt(sc.nextLine());
				StringBuilder query=new StringBuilder();
				query.append("create table ").append(tableName).append("(");
				for(int i=1;i<=columnNumber;i++) {

					System.out.print("For column "+i+" Enter Table column Name: ");
					String columnString=sc.nextLine().toUpperCase();
					System.out.print("Enter column DataType(like number(10)/varchar2(20): ");
					String columnDataType=sc.nextLine().toUpperCase();
					query.append(columnString).append(" ").append(columnDataType);
					if(i!=columnNumber) {
						query.append(", ");
					}else {
						query.append(")");
					}
				}
				int check=smt.executeUpdate(""+query);
				if (check==0) {
					System.out.println("\ntable Create successfully!!\n\n");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("\nEnter Valid Table name or Data type..!!!!\n\n");
		}
	}
}
