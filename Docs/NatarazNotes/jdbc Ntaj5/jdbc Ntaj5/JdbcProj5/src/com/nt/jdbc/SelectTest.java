package com.nt.jdbc;

//SelectTest.java

import java.sql.*;

public class SelectTest
{
	public static void main(String args[])throws Exception
	{
		//register oracle thin driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the connection with Db s/w.
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		//create Jdbc Statement obj
		Statement st=con.createStatement();
		//send and execute SQL Query
		ResultSet rs=st.executeQuery("select * from student");
		System.out.println("pause DB");
		Thread.sleep(30000);
		//Process the ResultSet
		while(rs.next()){
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getString(3));
		}
		
		   //close jdbc objs
		   rs.close();
		   st.close();
		   con.close();
	}//main
}//class
//>javac  SelectTest.java
//>java SelectTest

