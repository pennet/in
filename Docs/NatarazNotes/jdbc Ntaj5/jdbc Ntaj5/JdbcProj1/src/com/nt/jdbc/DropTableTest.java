package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DropTableTest {

	public static void main(String[] args)throws Exception {
		//read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter db talbe");
		String tab=sc.next();
		
		 //register jdbc driver
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		 //Establish the connection
		 Connection con=DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
		 //create Statement obj
		 Statement st=con.createStatement();
		 //send execute SQL Query in DB s/w
		 int result=st.executeUpdate("drop table "+tab);
		 //process the result
		 if(result==0)
			 System.out.println("Table not found");
		 else
			 System.out.println("Talbe dropped");
		 
		 //close jdbc objs
		 st.close();
		 con.close();
	}//main
}//class

