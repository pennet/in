package com.nt.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PhotoInsert {
	public static void main(String[] args)throws Exception {
		//read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter emp no:");
		int no=sc.nextInt();
		System.out.println("Enter emp name:");
		String name=sc.next();
		System.out.println("Enter emp salary:");
		float salary=sc.nextFloat();
		System.out.println("Enter Emp photo path");
		String imgPath=sc.next();

       //register jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott","tiger"); 
	
	/*	//register jdbc driver
		Class.forName("org.gjt.mm.mysql.Driver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:mysql:///ntaj5db2","root","root"); */
		
		//Create PreaparedStatement obj
		PreparedStatement ps=con.prepareStatement("insert into empall values(?,?,?,?)");
		//Locate the file
		File file=new File(imgPath);
		//create InputStream
		InputStream is=new FileInputStream(file);
		//set the values to Query params
		ps.setInt(1,no);
		ps.setString(2,name);
		ps.setFloat(3,salary);
		ps.setBinaryStream(4,is,(int)file.length());
		//execute the Query
		int result=ps.executeUpdate();
		//process the Result
		if(result==0)
			System.out.println("Record not inserted");
		else
			System.out.println("Record inserted");
		//close jdbc objs
		ps.close();
		con.close();
	}//main
}//class

