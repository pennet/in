package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySqlTest {
  public static void main(String[] args)throws Exception {
    //register jdbc driver
	  //Class.forName("org.gjt.mm.mysql.Driver");
	  Class.forName("com.mysql.jdbc.Driver");
	  
	//Establish the connection
	  //Connection con=DriverManager.getConnection("jdbc:mysql:///ntaj5db2","root","root");
	  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ntaj5db2","root","root");
	//create Statement obj
	  Statement st=con.createStatement();
	 //send and execute SQL Query in DB s/w
	  ResultSet rs=st.executeQuery("select * from product");
	  //process the ResultSet
	  while(rs.next()){
		  System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getFloat(3));
	  }
	  
	  System.out.println("con obj class name"+con.getClass());
	  System.out.println("st obj class name"+st.getClass());
	  System.out.println("rs obj class name"+rs.getClass());
	  
	  
	  
	  
	  //close jdbc objs
	  rs.close();
	  st.close();
	  con.close();
  }//main	
}//class

