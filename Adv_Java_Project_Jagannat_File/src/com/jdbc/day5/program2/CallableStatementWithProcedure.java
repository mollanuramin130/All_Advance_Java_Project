/*
 First Table:
 ============
 SQL> CREATE TABLE STUDATA (STU_ID NUMBER(4) NOT NULL UNIQUE,STU_ROLL VARCHAR2(10) PRIMARY KEY,STU_NAME VARCHAR2(30),STU_BRANCH VARCHAR2(15));
 
 Second Table:
 =============
 
 SQL> CREATE TABLE STU_ADDRESS (STU_ID NUMBER(4) REFERENCES STUDATA(STU_ID),STU_HN
O VARCHAR2(5),CITY VARCHAR2(20),PINCODE NUMBER(6));

Table STU_ADDRESS created.

Second Table:
=============
SQL> CREATE TABLE STU_CONTACT (STU_ID NUMBER(4) REFERENCES STUDATA(STU_ID),MAIL V
ARCHAR2(30),PHONE NUMBER(10));

Table STU_CONTACT created.

Procedure Create:
=================
SQL> CREATE OR REPLACE PROCEDURE STUDATA_TBL_INSERT_PROC(STU_ID OUT NUMBER
,STU_ROLL VARCHAR2,STU_NAME VARCHAR2,STU_BRANCH VARCHAR2,STU_HNO VARCHAR2,
CITY VARCHAR2,PINCODE NUMBER,MAIL VARCHAR2,PHONE NUMBER)
     IS
     SQN_ID STUDATA.STU_ID%TYPE;
     BEGIN
     SQN_ID:=STU_ID_SQN.NEXTVAL;
     STU_ID:=SQN_ID;
     INSERT INTO STUDATA VALUES(SQN_ID,STU_ROLL,STU_NAME,STU_BRANCH);
     INSERT INTO STU_ADDRESS VALUES(SQN_ID,STU_HNO,CITY,PINCODE);
     INSERT INTO STU_CONTACT VALUES(SQN_ID,MAIL,PHONE);
     
     END;
     /
 Procedure STUDATA_TBL_INSERT_PROC compiled
 */

package com.jdbc.day5.program2;

import java.io.FileReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;
import java.util.Scanner;

public class CallableStatementWithProcedure {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Properties props = new Properties();
		try {
			props.load(new FileReader("nur_driverinfo.properties"));

			final String URL = props.getProperty("URL");
			final String USN = props.getProperty("USN");
			final String PWD = props.getProperty("PWD");

			try (Connection con = DriverManager.getConnection(URL, USN, PWD)) {
				System.out.println("Connection Establish...");

				CallableStatement callStmt = con.prepareCall("{ call STUDATA_TBL_INSERT_PROC(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
				
				callStmt.registerOutParameter(1, Types.NUMERIC);
				
				System.out.print("Enter Student Roll: ");
				String roll=sc.nextLine().toUpperCase();
				callStmt.setString(2, roll);
				
				System.out.print("Enter Student Name: ");
				String name=sc.nextLine().toUpperCase();
				callStmt.setString(3, name);
				
				System.out.print("Enter Student Branch: ");
				String branch=sc.nextLine().toUpperCase();
				callStmt.setString(4, branch);
				
				System.out.print("Enter Student Home Number: ");
				String homeNo=sc.nextLine().toUpperCase();
				callStmt.setString(5, homeNo);
				
				System.out.print("Enter Student City: ");
				String city=sc.nextLine().toUpperCase();
				callStmt.setString(6, city);
				
				System.out.print("Enter Student Pincode: ");
				Integer pincode=Integer.valueOf(sc.nextLine());
				callStmt.setInt(7, pincode);
				
				System.out.print("Enter Student Email ID: ");
				String mail=sc.nextLine().toLowerCase();
				callStmt.setString(8, mail);
				
				System.out.print("Enter Student Phone No: ");
				Long phone=Long.valueOf(sc.nextLine());
				callStmt.setLong(9, phone);
				
				callStmt.execute();
				Integer studentId=callStmt.getInt(1);
				System.out.println("\n\nStudent Record Insert successfull!!!!\nYour Student ID: "+studentId+" Remembet it!!!!!\n");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
