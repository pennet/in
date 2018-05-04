package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTableTest {

	public static void main(String[] args)throws Exception {
		
		 //register jdbc driver
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		 //Establish the connection
		 Connection con=DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
		 //create Statement obj
		 Statement st=con.createStatement();
		 //send and execute SQL Query in DB s/w
		 int result=st.executeUpdate("create table temp(col1 number(5))");
		 //process the result
		 if(result==0)
			 System.out.println("Table not created");
		 else
			 System.out.println("Table created");
		 //close jdbc objs
		 st.close();
		 con.close();
	}//main
}//class

