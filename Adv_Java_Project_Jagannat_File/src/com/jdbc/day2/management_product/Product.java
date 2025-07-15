package com.jdbc.day2.management_product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbc.nur_query_class.NurInsert;

public class Product {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ADV_JAVA_DB",
				"123");) {
			while (flag) {
				System.out.print("Select your Option :\n" + "          1.Insert productdetails into product table.\n"
						+ "          2.Retrieve productdetails in forward direction.\n"
						+ "          3.Retrieve productdetails in reverse direction.\n"
						+ "          4.Retrieve 3rd record from top.\n"
						+ "          5.Retrieve 3rd record from bottom. \n" + "          6.Exit\n"
						+ "Enter your option: ");

				int option = Integer.parseInt(sc.nextLine());
				switch (option) {
				case 1: {
					NurInsert.insert();
					break;
				}
				case 2: {
					try (Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,
							ResultSet.CONCUR_READ_ONLY)) {
						System.out.print("Enter your table name: ");
						String tableName = sc.nextLine().toUpperCase();
						ResultSet rSet = stmt.executeQuery("SELECT * FROM " + tableName);
						if (rSet.next()) {
							ResultSetMetaData rsmd = rSet.getMetaData();
							for (int i = 1; i <= rsmd.getColumnCount(); i++) {
								System.out.print(rsmd.getColumnLabel(i) + "\t");
							}
							System.out.println("=".repeat(60));

							do {
								for(int i=1;i<=rsmd.getColumnCount();i++) {
									System.out.print(rSet.getString(i)+"\t");
								}
								System.out.println();

							} while (rSet.next());
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				}
				case 3: {
					try (Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY)) {
						System.out.print("Enter your table name: ");
						String tableName = sc.nextLine().toUpperCase();
						ResultSet rSet = stmt.executeQuery("SELECT * FROM " + tableName);
						//rSet.last();
						if (rSet.last()) {
							ResultSetMetaData rsmd = rSet.getMetaData();
							for (int i = 1; i <= rsmd.getColumnCount(); i++) {
								System.out.print(rsmd.getColumnLabel(i) + "\t");
							}
							System.out.println("=".repeat(60));

							do {
								for(int i=1;i<=rsmd.getColumnCount();i++) {
									System.out.print(rSet.getString(i)+"\t");
								}
								System.out.println();

							} while (rSet.previous());
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				}
				case 4: {
					try (Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY)) {
						System.out.print("Enter your table name: ");
						String tableName = sc.nextLine().toUpperCase();
						ResultSet rSet = stmt.executeQuery("SELECT * FROM " + tableName);
						System.out.print("Enter Starting Row Number: ");
						int startRow=Integer.parseInt(sc.nextLine());

						System.out.print("Enter Ending Row Number: ");
						int endRow=Integer.parseInt(sc.nextLine());

						if (rSet.absolute(startRow)) {
							ResultSetMetaData rsmd = rSet.getMetaData();
							for (int i = 1; i <= rsmd.getColumnCount(); i++) {
								System.out.print(rsmd.getColumnLabel(i) + "\t");
							}
							System.out.println("=".repeat(60));

							do {
								for(int i=1;i<=rsmd.getColumnCount();i++) {
									System.out.print(rSet.getString(i)+"\t");
								}
								System.out.println();
								rSet.next();

							} while (rSet.getRow()<=endRow);
						}else {
							System.err.println("Row Number Not Exist!!!");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + option);
				}

				flag = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
