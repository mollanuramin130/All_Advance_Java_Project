package com.jdbc.day1.student_register_login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentApplication {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ADV_JAVA_DB", "123");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			System.out.print("Choose Your Option:\n" + "=".repeat(30) + "\n1. Register\n2. Login\nEnter your Option: ");
			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1: {
				PreparedStatement pstmt = conn.prepareStatement("insert into student1 values(?,?,?,?,?,?)");

				System.out.print("Enter your Roll: ");
				String roll = sc.nextLine().toUpperCase();
				System.out.print("Enter your First Name: ");
				String firstName = sc.nextLine().toUpperCase();
				System.out.print("Enter your Last Name: ");
				String lastName = sc.nextLine().toUpperCase();
				System.out.print("Enter your Mail ID: ");
				String mailId = sc.nextLine().toLowerCase();

				System.out.print("Enter your Phone Number: ");
				long phoneNo = Long.parseLong(sc.nextLine());
				System.out.print("Enter your Percentage: ");
				double percentage = Double.parseDouble(sc.nextLine());

				pstmt.setString(1, roll);
				pstmt.setString(2, firstName);
				pstmt.setString(3, lastName);
				pstmt.setString(4, mailId);
				pstmt.setLong(5, phoneNo);
				pstmt.setDouble(6, percentage);

				int eStatus = pstmt.executeUpdate();
				if (eStatus >= 0) {
					System.out.println("Student Registration Successfully!!!");
				}

				break;
			}
			case 2: {
				System.out.println("\nLogIn Interface:\n" + "=".repeat(20));
				System.out.print("\nEnter Student Roll Number: ");
				String roll = sc.nextLine().toUpperCase();
				System.out.print("Enter Student First Name: ");
				String firstName = sc.nextLine().toUpperCase();

				rs = stmt.executeQuery(
						"Select * from student1 where roll= '" + roll + "' and first_name= '" + firstName + "'");
				if (rs.next()) {
					System.out.println("\nHello " + rs.getString("first_name") + " " + rs.getString("LAST_NAMe")
							+ " Login Successfully!!!");
					System.out.print(
							"1. Show 60% Above Student Details\n2. Update Mail ID & Phone NO Based on Roll No.\n3. Delete Below 30% Student\n4. Find Number of Student get 80% above\n5. Logout\nEnter Your Choose: ");

					int choose2 = Integer.parseInt(sc.nextLine());
					switch (choose2) {
					case 1: {
						rs = stmt.executeQuery("select * from student1 where percentage>=60");
						int count = 0;
						if (rs.next()) {
							ResultSetMetaData rsmd = rs.getMetaData();
							for (int i = 1; i <= rsmd.getColumnCount(); i++) {
								System.out.print(rsmd.getColumnName(i) + "\t");
							}
							System.out.println("\n" + "=".repeat(60));
							do {
								System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3)
										+ "\t" + rs.getString(4) + "\t" + rs.getString(5) + "\t" + rs.getString(6));
								count++;
							} while (rs.next());
							System.out.println(count + " rows Selected");
						} else {
							System.out.println(count + " rows Selected");
						}
						break;
					}
					case 2: {
						System.out.print("Enter Roll Number: ");
						String findRoll = sc.nextLine().toUpperCase();
						PreparedStatement ps = conn.prepareStatement("select * from student1 where roll=?");
						ps.setString(1, findRoll);
						ResultSet validRoll = ps.executeQuery();

						if (validRoll.next()) {

							System.out.print("Old Phone Number: " + validRoll.getString("phone_no")
									+ "\nEnter New Phone Number: ");
							long phone = Long.parseLong(sc.nextLine());
							System.out
									.print("Old Mail ID: " + validRoll.getString("mail_id") + "\nEnter New Mail ID: ");
							String mailId = sc.nextLine().toLowerCase();
							PreparedStatement ps2 = conn
									.prepareStatement("update student1 set mail_id=?,phone_no=? where roll=?");
							ps2.setString(1, mailId);
							ps2.setLong(2, phone);
							ps2.setString(3, findRoll);
							int updateVal = ps2.executeUpdate();
							if (updateVal > 0) {
								System.out.println("Phone Number & Mail ID updated Successfully!!!");
							} else {
								System.err.println("Phone Number & Mail ID updated Fail!!");
							}

						} else {
							System.out.println("Not found..");
						}
						break;
					}
					case 3: {
						PreparedStatement ps = conn
								.prepareStatement("delete student1 where percentage between 30 and 60");
						int deleteRow = ps.executeUpdate();
						System.out.println(deleteRow + " rows deleted!!");
						break;
					}
					case 4: {
						ResultSet rs2 = stmt.executeQuery("select * from student1 where percentage >=80");
						rs2.last();
						int studentCount = rs2.getRow();
						System.out.println("Total " + studentCount + " Students got more than 80% Marks!!!");
						break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + 2);
					}

				} else {
					System.err.println("You Enter Invalid Roll OR First Name please check it!!!");
				}

				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choose);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
