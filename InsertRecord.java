package com.bjs.Dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.project1.JdbcFactory;


public class InsertRecord {

	private static Connection conn=null;
	private static PreparedStatement pstmnt=null;
	
	public static void insertData(Scanner scan) throws SQLException {
		
		conn=JdbcFactory.getMyConnection();
		if(conn!=null) {
		
			String sql="Insert into library (`SiNo`,`Book_name`,`Price`) values (?,?,?)";
			pstmnt=conn.prepareStatement(sql);
			System.out.println("Enter the SiNo:");
			int sino=scan.nextInt();
			System.out.println("Enter Book_name:");
			String book_name=scan.next();
			System.out.println("Enter the Price:");
			int price=scan.nextInt();
			
			pstmnt.setInt(1, sino);
			pstmnt.setString(2, book_name);
			pstmnt.setInt(3, price);
			
			int i=pstmnt.executeUpdate();
			if(i==1) {
				System.out.println("record has been inserted");
			}else
			{
				System.out.println("failed to insert record");
			}
	}else {
		System.out.println("Connection returned is null");
	}
	}	
}
