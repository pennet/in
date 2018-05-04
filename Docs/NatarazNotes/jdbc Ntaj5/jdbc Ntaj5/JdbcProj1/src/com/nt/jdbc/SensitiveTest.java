package com.nt.jdbc;

//SelectTest.java

import java.sql.*;

public class SensitiveTest
{
	public static void main(String args[])throws Exception
	{
		//register oracle thin driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the connection with Db s/w.
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		//create Jdbc Statement obj
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				                        ResultSet.CONCUR_UPDATABLE);
		
		//send and execute SQL Query in DB s/w
		ResultSet rs=st.executeQuery("select sno,sname,sadd from student");
		 //process the ResultSet
		   int cnt=0;
		   while(rs.next()){
			   rs.refreshRow();
			   if(cnt==0){
				   System.out.println("sleep state...");
				   Thread.sleep(30000);
			   }
			   System.out.println(rs.getInt("sno")+"   "+rs.getString("sname")+"   "+rs.getString("sadd"));
			   cnt++;
		   }
		   
		 
		   //close jdbc objs
		   rs.close();
		   st.close();
		   con.close();
	}//main
}//class
//>javac  SelectTest.java
//>java SelectTest

