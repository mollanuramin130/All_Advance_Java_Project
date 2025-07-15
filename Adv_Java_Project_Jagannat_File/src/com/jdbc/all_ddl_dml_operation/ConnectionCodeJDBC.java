package com.jdbc.all_ddl_dml_operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConnectionCodeJDBC {
	public static void main(String[] args) {
		boolean flag=true;
		Scanner sc=new Scanner(System.in);
		

		try(sc) {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			System.out.println("Driver loaded");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ADV_JAVA_DB", "123");
			Statement smt=conn.createStatement();

			while (flag) {
				System.out.print("Choose Database Operation Type\n===================================\n"+
			"1. Create Table\n2. Insert Data\n3. Delete Data\n4. Show All Table\n5. Show Table Records\n6. Exit Operation\nEnter Your Choice: ");
				try {
					int choose=Integer.parseInt(sc.nextLine());
					switch (choose){
					case 1: {
						System.out.println("Enter your table name: ");
						try {
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
							System.out.println("\nEnter Valid Table name or Data type..!!!!\n\n");
						}
						break;
					}
					case 2:{
						System.out.println("Enter your Table name: ");
						try {

							String tableName=sc.nextLine().toUpperCase();

							ResultSet tableNameSet=smt.executeQuery("select * from tab");
							while(tableNameSet.next()) {
								if(tableName.equalsIgnoreCase(tableNameSet.getString(1))) {
									PreparedStatement pstm= conn.prepareStatement("SELECT COLUMN_NAME, DATA_TYPE FROM ALL_TAB_COLUMNS WHERE TABLE_NAME = ? AND OWNER = 'ADV_JAVA_DB'");
									pstm.setString(1, tableName);
									ResultSet rSet=pstm.executeQuery();
									List<String> columnNameList=new ArrayList<>();
									List<String> columnDataTypeList=new ArrayList<>();
									while(rSet.next()) {
										columnNameList.add(rSet.getString(1));
										columnDataTypeList.add(rSet.getString(2));
									}
									StringBuilder insertBuilder=new StringBuilder();
									insertBuilder.append("insert into "+tableName+" values( ");

									for(int i=1;i<=columnDataTypeList.size();i++) {
										insertBuilder.append("? ");
										if(i!= columnDataTypeList.size()) {
											insertBuilder.append(", ");

										}else {
											insertBuilder.append(")");

										}
									}
									PreparedStatement pstm2=conn.prepareStatement(insertBuilder.toString());
									for(int i=1;i<=columnNameList.size();i++) {
										System.out.print("Enter value for "+columnNameList.get(i-1)+" of Data type "+columnDataTypeList.get(i-1)+": ");
										String value=sc.nextLine();
										switch(columnDataTypeList.get(i-1)) {
										case "varchar2":
										case "nvarchar2":
										case "char":
											pstm2.setString(i, value);
											break;
										case "number":
											pstm2.setInt(i, Integer.parseInt(value));
											break;
										case "DATE":
						                    pstm2.setDate(i, java.sql.Date.valueOf(value)); // format: YYYY-MM-DD
						                    break;
						                default:
						                    pstm2.setString(i, value); // fallback
						                    break;
										}
									}
									int insertStatus=pstm2.executeUpdate();
									if(insertStatus>0) {
										System.out.println("Insert data Successfull into Table: "+tableName.toUpperCase()+"\n");
									}
									break;
								}
							}

						}catch (Exception e) {
							//System.out.println("Input Miss match...\n");
							System.out.println(e.getMessage());
						}

						break;
					}
					case 3:{
						System.out.print("Enter your Table Name: ");
						String dTableName=sc.nextLine().toUpperCase();
						PreparedStatement dpsmt=conn.prepareStatement("DROP TABLE "+dTableName+" PURGE");
						//dpsmt.setString(1, dTableName);
						int dStatus=dpsmt.executeUpdate();
						if(dStatus==0) {
							System.out.println("Your Table: "+dTableName+" Successfully deleted!!!\n");
						}else {
							System.out.println("You Table not Exist!!");
						}
						break;
					}
					case 4:{
						ResultSet tableNameSet=smt.executeQuery("select * from tab");
						System.out.println("\nTABLE NAME\t\tTABLE TYPE\n==========\t\t==========");
						while(tableNameSet.next()) {
							System.out.println(tableNameSet.getString(1)+"\t\t\t"+tableNameSet.getString(2));
						}
						System.out.println("===================================\n");
						break;
					}
					case 5:{
						try {
							System.out.println("Enter your Table name: ");

							String tableName=sc.nextLine().toUpperCase();
							System.out.println(tableName+" Table Record:"+"\n"+"-".repeat(20));
							ResultSet rSet=smt.executeQuery("select * from "+tableName);
							ResultSetMetaData rmd=rSet.getMetaData();
							int columnCount=rmd.getColumnCount();
							for(int i=1;i<=columnCount;i++) {
								System.out.print(rmd.getColumnName(i)+"\t");
							}
							System.out.println();
							for(int i=1;i<=columnCount;i++) {
								System.out.print("=".repeat(7)+"\t");

							}
							System.out.println();
							while(rSet.next()) {
								for(int i=1;i<=columnCount;i++) {
									System.out.print(rSet.getString(i)+"\t");
								}
								System.out.println();
							}
							System.out.println();
						}catch (Exception e) {
							System.out.println(e.getMessage());
						}
						break;

					}
					case 6:{
						flag=false;
						System.out.println("\nExit Process successfully!!!!\n\n");
						break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + choose+"\n");
					}
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
