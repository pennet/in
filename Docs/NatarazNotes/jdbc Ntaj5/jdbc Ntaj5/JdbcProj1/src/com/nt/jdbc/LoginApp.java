package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class LoginApp {

 public static void main(String[] args)throws Exception {
	   //read inputs
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter username");
	  String user=sc.nextLine(); // gives raja
	  
	  System.out.println("Enter Password");
	  String pass=sc.nextLine(); // gives rani
	  
	  //convert input values as required for SQL Query
	  user="'"+user+"'"; //gives 'raja'
	  pass="'"+pass+"'";// gives 'rani'
	  
	  //register oracle thin driver
	  Class.forName("oracle.jdbc.driver.OracleDriver");
	  //Establish the connection
	  Connection con=DriverManager.getConnection("jdbc:oracle:oci8:@xe","scott","tiger");
	  //create statement obj
	  Statement st=con.createStatement();
	  //prepare SQL Query
	     // select count(*) from userlist where pwd='hyd' and  uname='raja'";
	  String qry="select count(*) from userlist where pwd="+pass +"and uname="+user;
	  System.out.println(qry);
	  //send and execute SQL Query  in DB s/w
	  ResultSet rs=st.executeQuery(qry);
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
	  st.close();
	  con.close();

	}//main
}//clas

