//SelectTest5.java
package com.nt.jdbc;

import java.sql.*;

public class SelectTest5 {
  public static void main(String[] args)throws Exception {
    //register jdbc driver
	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//Establish the connection
	  Connection con=DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
	//create Statement obj
	  Statement st=con.createStatement();
	//Send and exceute SQL Query in DB s/w
	  ResultSet rs=
		  st.executeQuery("select * from emp where sal=(select max(sal) from emp)");
	//Process the Resultset
	  boolean flag=false;
	  while(rs.next()){
		  flag=true;
	  System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));	  
	  }
	  if(flag==false)
		  System.out.println("Record not found");
	  //close jdbc objs
	  rs.close();
	  st.close();
	  con.close();
  }//main
}//class

