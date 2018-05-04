//SelectTest6.java
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest6 {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try{
		 //register driver
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         //Establish the connection
			con=DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
		 //create Statement obj
			if(con!=null)
				st=con.createStatement();
         //send and execute SQL Query in DB s/w
			if(st!=null)
				rs=st.executeQuery("select count(*) from emp");
		// process the ResultSet
		if(rs!=null){	
			if(rs.next()){
			  System.out.println("Records count"+rs.getInt(1));	
			}
		}//if
	}//try
    catch(ClassNotFoundException cnf){
    	cnf.printStackTrace();
    }
	catch(SQLException se){
		se.printStackTrace();
	}
	catch(Exception e){
		e.printStackTrace();
	}
   finally{
	   //close jdbc objs
	   try{
		  if(rs!=null)
			  rs.close();
	   }
	   catch(SQLException se){
		   se.printStackTrace();
	   }
	   
	   try{
		   if(st!=null)
			   st.close();
	   }
	   catch(SQLException se){
		   se.printStackTrace();
	   }
	   try{
		   if(con!=null)
			   con.close();
	   }
	   catch(SQLException se ){
		   se.printStackTrace();
	   }
   }//finally
		
  }//main
}//class

