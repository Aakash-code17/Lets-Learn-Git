package com.bjs.Dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.project1.JdbcFactory;

public class DeleteData {

	private static Connection conn=null;
	private static PreparedStatement pstmnt=null;
	private static Scanner scan=null;
	
	public static void deleteAnyRecord() throws SQLException {
	 
		scan=new Scanner(System.in);
		conn=JdbcFactory.getMyConnection();
		if(conn!=null) {
	        System.out.println("Enter SiNo:");
			int sino=scan.nextInt();
			String sql="delete from library where sino=?";
			pstmnt=conn.prepareStatement(sql);
			
			pstmnt.setInt(1, sino);
			
			int i=pstmnt.executeUpdate();
			if(i==1) {
				System.out.println("Data has been deleted");
			}else
			{
				System.out.println("failed to delete");
			}
     	}else {
		System.out.println("Connection returned is null");
	   }
   }
}
