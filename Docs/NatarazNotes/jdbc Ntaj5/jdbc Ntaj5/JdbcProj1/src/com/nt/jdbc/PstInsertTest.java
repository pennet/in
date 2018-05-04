package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PstInsertTest {

	public static void main(String[] args)throws Exception {
        //read Student count
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter students count:");
		int no=sc.nextInt();
		//register jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establisht the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
        //prepare SQL query with paramers
		String qry="insert into student values(?,?,?)";
		//Create pre-compiled SQL Query and get PreparedStatement obj
		PreparedStatement ps=con.prepareStatement(qry);
		//read multiple Student Details
		for(int i=1;i<=no;++i){
			System.out.println("Enter "+i+" student details");
			System.out.println("Enter no");
			int sno=sc.nextInt();
			
			System.out.println("Enter name");
			String name=sc.next();
			
			System.out.println("Enter address");
			String addrs=sc.next();
			
			//set each student details to pre-compiled sQL Query params
			ps.setInt(1,sno); ps.setString(2,name);
			ps.setString(3,addrs);
			
			//execute pre-compiled SQL query
			int result=ps.executeUpdate();
			//process the Result
			if(result==0)
				System.out.println(i+" student not inserted");
			else
				System.out.println(i+" student inserted");
		}//for
		
		//close jdbc obj
		ps.close();
		con.close();
	}//main
}//class

