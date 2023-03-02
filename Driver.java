package com.bjs.driverclass;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import com.bjs.Dto.DeleteData;
import com.bjs.Dto.InsertRecord;
import com.bjs.Dto.ShowData;
import com.bjs.Dto.UpdateData;
import com.project1.JdbcFactory;

public class Driver {
	
	private static Connection conn=null;
	private static Scanner scan=null;
	
	public static void main(String[] args) {
		
		
    conn=JdbcFactory.getMyConnection();
	
		if(conn!=null) {
			
			StartedMethod();
			menu();
		}else {
			System.out.println("Connection returned is null");
		}
	}

	private static void menu() {
		scan=new Scanner(System.in);
		
		do {
			System.out.println("Please choose the operation you would like to perform");
			System.out.println("1.select");
			System.out.println("2.insert");
			System.out.println("3.update");
			System.out.println("4.delete");
			System.out.println("5.exit");
			switch(scan.nextInt()) {
			case 1: {
				try {
					ShowData.showRecord();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			    break;
			case 2: {
				try {
					InsertRecord.insertData(scan);
				} catch (SQLException e) {
					e.printStackTrace();
				}
							
			}
			    break;
			case 3: {
				try {
					UpdateData.updateTableData();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			    break;
			case 4: {
				try {
					DeleteData.deleteAnyRecord();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			    break;
			case 5: {
				System.out.println("Good bye...");
				System.exit(0);
				
			}
			
			}
			System.out.println("Would you like to perform one more operation");
		}while(scan.next().equals("yes"));
		
	}

	private static void StartedMethod() {
		scan=new Scanner(System.in);
//		int n=4;
//		int m=40;
		System.out.println("Please enter Your Name:");
		String Name=scan.nextLine();
		LocalDate dt=LocalDate.now();
		
		
		System.out.println("-----------------------------------------");
		System.out.println("           Welcome: "+Name);
		System.out.println("    Library Management System "+dt);
		System.out.println("-----------------------------------------");
//		for(int i=1;i<=n;i++) {
//			for(int j=1;j<=m;j++) {
//				if(i==1 || i==n ) {
//					System.out.print("-");
//				}
//				else if(j==n/2 && i==(n/2)+1){
//					System.out.println("        Welcome: "+Name);
//					System.out.println(" Library Management System "+dt);
//				}
//			    else {
//					System.out.print(" ");
//				}	
//			}
//			System.out.println();
//		}
	}
}	
