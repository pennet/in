package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LoginApp1 {
	private static final String AUTH_QRY="select count(*) from userlist where uname=? and pwd=?"; 

 public static void main(String[] args)throws Exception {
	   //read inputs
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter username");
	  String user=sc.nextLine(); // gives raja
	  
	  System.out.println("Enter Password");
	  String pass=sc.nextLine(); // gives rani
	  
	 
	  
	  //register oracle thin driver
	  Class.forName("oracle.jdbc.driver.OracleDriver");
	  //Establish the connection
	  Connection con=DriverManager.getConnection("jdbc:oracle:oci8:@xe","scott","tiger");
	  
	  //create PreparedStatement obj representing pre-compiled SQL Query
	  PreparedStatement ps=con.prepareStatement(AUTH_QRY);
	  //set Param(?) Values
	  ps.setString(1,user);
	  ps.setString(2,pass);
	  //execute pre-compiled SQL Query  in DB s/w
	  ResultSet rs=ps.executeQuery();
	  //process the ResultSet
	  int cnt=0;
	  if(rs.next()){
		  cnt=rs.getInt(1);
	  }
	  if(cnt==0)
		  System.out.println("InValid Credentials");
	  else
		  System.out.println("Valid Credentials");
	
	  //close jdbc objs
	  rs.close();
	  ps.close();
	  con.close();

	}//main
}//clas

