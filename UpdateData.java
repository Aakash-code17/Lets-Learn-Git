package com.bjs.Dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.project1.JdbcFactory;

public class UpdateData {
	
	private static Connection conn=null;
	private static PreparedStatement pstmnt=null;
	private static Scanner scan=null;

	public static void updateTableData() throws SQLException {

		scan=new Scanner(System.in);
		conn=JdbcFactory.getMyConnection();

		if(conn!=null) {
			System.out.println("Enter updated Book_name:");
			String book_name=scan.nextLine();
			System.out.println("Enter the updated price:");
			int price=scan.nextInt();
			System.out.println("Enter the sino:");
			int sino=scan.nextInt();
			String sql="update library set book_name=?,price=? where sino=?";
			pstmnt=conn.prepareStatement(sql);
			
			pstmnt.setString(1, book_name);
			pstmnt.setInt(2, price);
			pstmnt.setInt(3, sino);
			
			int i=pstmnt.executeUpdate();
			if(i==1) {
				System.out.println("Data has been updated");
			}else {
				System.out.println("failed to update");
			}
		}else {
			System.out.println("Connection returned is null");
		}
	}

}
