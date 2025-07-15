package com.jdbc.day3.university_management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.jdbc.nur_query_class.ConnectionClass;

public class Student {
	private String studentId;
	private String studentName;
	private String course;
	private int semester;
	private String email;
	private long phoneNumber;

	private final String insertStudentQuery = """
			INSERT INTO STUDENT2 (STUDENT_ID,STUDENT_NAME,COURSE,SEMESTER,EMAIL,PHONE_NUMBER) VALUES(?,?,?,?,?,?)
			""";

	private final String fetchAllStudentQuery = """
			SELECT * FROM STUDENT2
			""";

	private final String fetchStudentByIdQuery = """
			SELECT * FROM STUDENT2 WHERE STUDENT_ID=?
			""";
	private final String updateStudentEmailQuery = """
			UPDATE STUDENT2 SET EMAIL=? WHERE STUDENT_ID=?
			""";
	private final String deleteStudentByIdQuery = """
			DELETE STUDENT2 WHERE STUDENT_ID=?
			""";


	public Student(String studentId, String studentName, String course, int semester, String email,
			long phoneNumber) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.course = course;
		this.semester = semester;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}


	public void insertStudent(Student student) {
		int insertCount=0;

		try(Connection conn= ConnectionClass.getConnectionByNur();
				PreparedStatement insertStudentPS=conn.prepareStatement(insertStudentQuery);
				){

			insertStudentPS.setString(1,student.getStudentId().toUpperCase() );
			insertStudentPS.setString(2,student.getStudentName().toUpperCase() );
			insertStudentPS.setString(3,student.getCourse().toUpperCase() );
			insertStudentPS.setInt(4,student.getSemester() );
			insertStudentPS.setString(5,student.getEmail().toLowerCase() );
			insertStudentPS.setLong(6,student.getPhoneNumber() );

			insertCount=insertStudentPS.executeUpdate();
			if(insertCount==1) {

				System.out.println("Insert Successfully!!!");
			}else {

				System.out.println("Insert Fail!!!");
			}

		}catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void fetchAllStudents() {
		try(Connection conn= ConnectionClass.getConnectionByNur();
				PreparedStatement fetchAllStudentPS=conn.prepareStatement(fetchAllStudentQuery);
				){
			try(		ResultSet fetchAllRS= fetchAllStudentPS.executeQuery();
					){

				ResultSetMetaData fetchAllMetaData=fetchAllRS.getMetaData();

				if(fetchAllRS.next()) {
					for(int i=1;i<=fetchAllMetaData.getColumnCount();i++) {
						System.out.printf("%-25s",fetchAllMetaData.getColumnLabel(i));
					}
					System.out.println("\n"+"=".repeat(150));

					do {
						for(int i=1;i<=fetchAllMetaData.getColumnCount();i++) {
							System.out.printf("%-25s",fetchAllRS.getString(i));
						}
						System.out.println();
					}while(fetchAllRS.next());
				}else {
					System.out.println("No Record found in your Table!!");
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}


		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void fetchStudentById(String studentId) {
		try(Connection conn= ConnectionClass.getConnectionByNur();
				PreparedStatement fetchStudentByIdPS=conn.prepareStatement(fetchStudentByIdQuery);
				){
			fetchStudentByIdPS.setString(1, studentId.toUpperCase());
			try(	ResultSet fetchAllRS= fetchStudentByIdPS.executeQuery();
					){

				ResultSetMetaData fetchAllMetaData=fetchAllRS.getMetaData();

				if(fetchAllRS.next()) {
					for(int i=1;i<=fetchAllMetaData.getColumnCount();i++) {
						System.out.printf("%-25s",fetchAllMetaData.getColumnLabel(i));
					}
					System.out.println("\n"+"=".repeat(150));

					do {
						for(int i=1;i<=fetchAllMetaData.getColumnCount();i++) {
							System.out.printf("%-25s",fetchAllRS.getString(i));
						}
						System.out.println();
					}while(fetchAllRS.next());
				}else {
					System.out.println("No Record found in your Table!!");
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}


		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateStudentEmail(String studentId, String newEmail) {
		try(Connection conn= ConnectionClass.getConnectionByNur();
				PreparedStatement updateStudentEmailPS=conn.prepareStatement(updateStudentEmailQuery);
				){
			updateStudentEmailPS.setString(1, newEmail.toLowerCase());
			updateStudentEmailPS.setString(2, studentId.toUpperCase());

			int updateCount=updateStudentEmailPS.executeUpdate();
			if(updateCount==1) {

				System.out.println("Update Successfully!!!");
			}else {

				System.out.println("update Fail!!!");
			}


		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteStudentById(String studentId) {
		try(Connection conn= ConnectionClass.getConnectionByNur();
				PreparedStatement updateStudentPS=conn.prepareStatement(deleteStudentByIdQuery);
				){
			updateStudentPS.setString(1, studentId.toUpperCase());

			int deleteCount=updateStudentPS.executeUpdate();
			if(deleteCount==1) {

				System.out.println("Delete Successfully!!!");
			}else {

				System.out.println("Delete Fail!!!");
			}


		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getStudentId() {
		return studentId;
	}


	public String getStudentName() {
		return studentName;
	}


	public String getCourse() {
		return course;
	}


	public int getSemester() {
		return semester;
	}


	public String getEmail() {
		return email;
	}


	public long getPhoneNumber() {
		return phoneNumber;
	}


}
