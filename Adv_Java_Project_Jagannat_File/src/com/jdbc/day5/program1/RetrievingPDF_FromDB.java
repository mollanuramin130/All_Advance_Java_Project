package com.jdbc.day5.program1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

public class RetrievingPDF_FromDB {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		Properties props=new Properties();
		try {
			props.load(new FileReader("nur_driverinfo.properties"));
			
			final String URL=props.getProperty("URL");
			final String USN=props.getProperty("USN");
			final String PWD=props.getProperty("PWD");
			
			try(Connection con=DriverManager.getConnection(URL,USN,PWD)){
				System.out.println("Connection Establish...");
				PreparedStatement pStatement=con.prepareStatement("SELECT * FROM MULTIMEDIA_DB WHERE MEDIA_ID=?");
				System.out.print("Enter your media Id: ");
				String mediaId=sc.nextLine();
				pStatement.setString(1, mediaId);
				
				ResultSet rSet=pStatement.executeQuery();
				if(rSet.next()) {
					Blob blob=rSet.getBlob(2);
					byte arr[]=blob.getBytes(1, (int) blob.length());
					
					System.out.print("Enter your path where you want to download file: ");
					String path=sc.nextLine();
					File file=new File(path);
					FileOutputStream fileOutputStream=new FileOutputStream(file);
					fileOutputStream.write(arr);
					System.out.println("Downloaded Successfully....");
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
