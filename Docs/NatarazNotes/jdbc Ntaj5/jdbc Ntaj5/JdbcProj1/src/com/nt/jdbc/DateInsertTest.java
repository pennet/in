package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateInsertTest {

	public static void main(String[] args)throws Exception {
		//read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter person id");
		int pid=sc.nextInt();
		System.out.println("Enter person name");
		String pname=sc.next();
		System.out.println("Enter DOB(dd-MM-yyyy)");
		String dob=sc.next();
		System.out.println("Enter DOJ(yyyy-MM-dd)");
		String doj=sc.next();
		
	/*	//register jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger"); */
		
		//register jdbc driver
		Class.forName("com.mysql.jdbc.Driver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:mysql:///ntaj5db2","root","root");
		
		//create PreparedStatement obj
		PreparedStatement ps=con.prepareStatement("insert into person_tab values(?,?,?,?)");
		//Convert String date values to java.sql.Date class objs
	   //For DOB
	    SimpleDateFormat sdf1=new SimpleDateFormat("dd-MM-yyyy");
	    java.util.Date udob=sdf1.parse(dob);//gives java.util.Date obj
	    long ms=udob.getTime();
	    java.sql.Date sdob=new java.sql.Date(ms);//gives java.sql.Date obj
	   //For DOJ
	    java.sql.Date sdoj=java.sql.Date.valueOf(doj);
	    
	    //set values to SQL Query params(?)
	    ps.setInt(1,pid);
	    ps.setString(2,pname);
	    ps.setDate(3,sdob);
	    ps.setDate(4,sdoj);
	    
	    //execute the Query
	    int result=ps.executeUpdate();
	    
	    //process the result
	    if(result==0)
	    	System.out.println("Record not inserted");
	    else
	    	System.out.println("Record inserted");
	    
	    //close
	    ps.close();
	    con.close();
	}//main
}//class

