package com.jdbc.day3.university_management;

public class UniversityApp {
	public static void main(String[] args) {

		Student nurStudent = new Student("j27", "Nur Amin", "Adv Java", 2, "nur@gmail.com", 8926627220L);


		nurStudent.insertStudent(nurStudent);
		//nurStudent.fetchStudentById("j27");
		//nurStudent.updateStudentEmail("j27", "nuramin@gmail.com");
		//nurStudent.fetchStudentById("j27");

		//nurStudent.deleteStudentById("j27");
	}
}
