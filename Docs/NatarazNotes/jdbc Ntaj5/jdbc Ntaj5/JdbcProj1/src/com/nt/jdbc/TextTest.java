package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TextTest {
	public static void main(String[] args)throws Exception {
		
		//register jdbc driver
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:odbc:txtdsn");
		
		//create Statement obj
		Statement st=con.createStatement();
		
		//send and execute SQL Query in Db s/w
		ResultSet rs=st.executeQuery("select * from file1.csv");
		
		//process the ResultSet
		while(rs.next()){
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getString(3));
		}
		
		//close jdbc objs
		rs.close();
		st.close();
		con.close();
	}//main
}//class
