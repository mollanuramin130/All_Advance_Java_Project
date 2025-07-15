package com.jdbc.day4.load_file_from_db;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class TestRetrieveMedia {
	public static void main(String[] args) {
		try {
			// set up connection
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ADV_JAVA_DB", "123");
			Scanner sc = new Scanner(System.in);
			System.out.println("Connection established");
			PreparedStatement ps = con.prepareStatement("select * from MULTIMEDIA_DB where MEDIA_ID = ?");
			System.out.println("Enter id to get the associated media");
			String id = sc.nextLine();
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Blob b = rs.getBlob(2);
				byte arr[] = b.getBytes(1, (int) (b.length()));// b.length() return long
				//byte arr2[]=b.getBytes(0, 0);
				System.out.println("Enter the path where you want to load the media:");
				///Users/mollanuramin130/Desktop/MyPic Desktop/load/myImage2.png (path)

				String path = sc.nextLine();
				File f = new File(path);
				FileOutputStream fos = new FileOutputStream(f);
				fos.write(arr);
				System.out.println("File loaded into driver successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

