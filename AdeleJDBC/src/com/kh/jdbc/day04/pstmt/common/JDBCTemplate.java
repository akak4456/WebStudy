package com.kh.jdbc.day04.pstmt.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCTemplate {
	private static final String FILE_NAME = "resources/dev.properties";
	private static Properties prop;
	private static Connection conn;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if(prop == null) {
			initProp();
		}
		String driverName 	= prop.getProperty("driverName");
		String url 			= prop.getProperty("url");
		String user 		= prop.getProperty("user");
		String password 	= prop.getProperty("password");
		if(conn == null || conn.isClosed()) {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, password);
		}
		return conn;
	}
	
	private static void initProp() {
		prop = new Properties();
		Reader reader = null;
		try {
			reader = new FileReader(FILE_NAME);
			prop.load(reader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
