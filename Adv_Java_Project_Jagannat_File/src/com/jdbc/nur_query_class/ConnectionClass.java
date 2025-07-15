package com.jdbc.nur_query_class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
	private static Connection connection = null;

	public final static Connection getConnectionByNur() {

		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String username= "ADV_JAVA_DB";
		String password="123";

		if(connection==null) {
			try {
				connection=DriverManager.getConnection(url, username, password);
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return connection;
	}
}
