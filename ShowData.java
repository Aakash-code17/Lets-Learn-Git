package com.bjs.Dto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.project1.JdbcFactory;

public class ShowData {

	private static Connection conn=null;
	private static Statement stmnt=null;
	private static ResultSet res=null;

	
	public static void showRecord() throws SQLException {
		conn=JdbcFactory.getMyConnection();
		
		if(conn!=null) {            
            	String sql="select * from library";
        		stmnt=conn.createStatement();
        		res=stmnt.executeQuery(sql);
        		
        		System.out.println(String.format("%-10s%-15s%-10s","SiNo","Book_Name","Price"));
        		while(res.next()) {
        			System.out.println(String.format("%-10s%-15s%-10s",res.getInt(1),res.getString(2),res.getInt(3)));
        		}
		
		}else
		{
			System.out.println("Connection returned is null");
		}	
	}
}
