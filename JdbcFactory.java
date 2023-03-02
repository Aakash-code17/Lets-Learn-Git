package com.project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;



public class JdbcFactory {
	
	private static ResourceBundle bundle=null;
	private static Connection conn=null;
	
	
	static {
		bundle=ResourceBundle.getBundle("com.bjs.utilities.mysqlinfo");
	}
	
	public static Connection getMyConnection(){
	   try {
		conn=DriverManager.getConnection(bundle.getString("url"),bundle.getString("user"),bundle.getString("password"));
	} catch (SQLException e) {
		e.printStackTrace();
	}
	   return conn;
	}
	
	public static void close() throws SQLException {
		if(conn!=null) {
			conn.close();
		}
}
	
	}  
