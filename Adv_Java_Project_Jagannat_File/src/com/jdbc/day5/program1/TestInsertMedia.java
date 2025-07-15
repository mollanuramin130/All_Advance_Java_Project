package com.jdbc.day5.program1;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class TestInsertMedia {
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ADV_JAVA_DB", "123");

			PreparedStatement ps = con.prepareStatement("insert into MULTIMEDIA_DB values(?,?)");

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the id for the media: ");
			String id = sc.nextLine();
			System.out.println("Enter the path of media: ");
			String path = sc.nextLine();
			File f = new File(path);
			if (f.exists()) {
				FileInputStream fis = new FileInputStream(f);
				ps.setString(1, id);
				ps.setBinaryStream(2, fis, f.length());

				int result = ps.executeUpdate();
				System.out.println(result + " record(s) inserted.");

			} else {
				System.err.println("Invalid path or file name entered!!!Try Again");

			}
			sc.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}