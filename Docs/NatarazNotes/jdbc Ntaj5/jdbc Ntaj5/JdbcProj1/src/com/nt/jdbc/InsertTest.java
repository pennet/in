package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest {

 public static void main(String[] args)throws Exception {
	 //read inputs
	 Scanner sc=new Scanner(System.in);
	 
	 System.out.println("Enter no:");
	 int no=sc.nextInt(); //gives 1001
	 
	 System.out.println("Enter name:");
	 String name=sc.next(); //gives raja
	 
	 System.out.println("Enter Address");
	 String addrs=sc.next(); //gives hyd
	 //Convert input values as required for SQL Query
	 name="'"+name+"'"; //gives 'raja'
	 addrs="'"+addrs+"'"; //gives 'hyd'
	 
	 //register jdbc driver
	 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	 //Establish the connection
	 Connection con=DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
	 //create Statement obj
	 Statement st=con.createStatement();
	  //prepare SQL Query
	     // insert into student values(1001,'raja','hyd')
	 String qry="insert into student values("+no+","+name+","+addrs+")";
	 System.out.println(qry);
	 
	 //send and execute SQL Query in DB s/w
	 int result=st.executeUpdate(qry);
	 
	 //process the result
	 if(result==0)
		 System.out.println("record not inserted");
	 else
		 System.out.println("Record inserted");
		 
	 //close jdbc objs
	 st.close();
	 con.close();
	 sc.close();
	}//main
}//class

