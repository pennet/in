package com.nt.jdbc;
import java.io.*;
import java.sql.*;
import java.util.*;

public class SelectTest {
  public static void main(String[] args)throws Exception {
 //Locate properties file
	InputStream is=
	 new FileInputStream("src/com/nt/commons/DBDetails.properties");
 // Load properties file data into java.util.Properties class obj
	Properties props=new Properties();
	props.load(is);
 // register and establish the conenction
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=
		 DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",props);
 // create Statement obj
	Statement st=con.createStatement();
 //execute the Query
	ResultSet rs=st.executeQuery("select * from student");
	//Process the Result
  while(rs.next()){
	  System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
  }//while
  //close jdbc objs
  rs.close();
  st.close();
  con.close();
 }//main
}//class
