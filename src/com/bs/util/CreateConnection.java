package com.bs.util;

import java.sql.Connection;
import java.sql.DriverManager;



public class CreateConnection {
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mydata";
			String name = "root";
			String mima = "root";
			Connection connection = DriverManager.getConnection(url,name,mima);
			return connection;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public static void close(Connection connection){
		try {
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
