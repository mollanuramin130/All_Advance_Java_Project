package com.jdbc.day2.management_customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Customer {

	public void insertCustomer() {
		Scanner sc = new Scanner(System.in);
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ADV_JAVA_DB",
				"123");) {

			System.out.print("Enter your Table Name: ");
			String tableName = sc.nextLine().toUpperCase();
			try (PreparedStatement pStatement = con
					.prepareStatement("select * from tab where tname=?")) {
				pStatement.setString(1, tableName);
				try (ResultSet rSet = pStatement.executeQuery()) {
					Statement rs=con.createStatement();
					ResultSet rSet2=rs.executeQuery("select * from "+tableName);

					if (rSet.next()) {
						StringBuilder queryBuilder = new StringBuilder();
						queryBuilder.append("insert into " + tableName + " values( ");
						try {

							ResultSetMetaData rSetMetaData = rSet2.getMetaData();
							for (int i = 1; i <= rSetMetaData.getColumnCount(); i++) {
								System.out.print("Enter value for " + rSetMetaData.getColumnLabel(i) + " of Type "
										+ rSetMetaData.getColumnTypeName(i) + ": ");
								if (rSetMetaData.getColumnTypeName(i).equalsIgnoreCase("VARCHAR2")) {

									queryBuilder.append("'").append(sc.nextLine().toUpperCase()).append("'");
								} else if (rSetMetaData.getColumnTypeName(i).equalsIgnoreCase("NUMBER")) {
									queryBuilder.append(Integer.parseInt(sc.nextLine()));
								}
								if(i != rSetMetaData.getColumnCount()) {
									queryBuilder.append(" ,");
								}else {
									queryBuilder.append(" )");

								}
							}
							PreparedStatement pStatement2 = con.prepareStatement("" + queryBuilder);
							int insertStatus=pStatement2.executeUpdate();
							if(insertStatus>0) {
								System.out.println("Insert successfully");
							}
						}catch (SQLException e) {
							e.printStackTrace();
						}

					} else {
						System.err.println("You Enter Invalid Table Name!!!");
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
