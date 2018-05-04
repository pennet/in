package com.nt.jdbc;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class FlexTest {
	public static void main(String[] args)throws Exception {
		//locate properties file
		InputStream is=new FileInputStream("src/com/nt/commons/DBDetails.properties");
		//Load the content properties file java.util.Properties obj
		Properties props=new Properties();
		props.load(is);
		
		//get values form properties file
		String driver=props.getProperty("my.driver");
		String url=props.getProperty("my.url");
		String user=props.getProperty("my.dbuser");
		String pwd=props.getProperty("my.dbpwd");
		//registr jdbc driver
		Class.forName(driver);
		//Establish the connection
		Connection con=DriverManager.getConnection(url,user,pwd);
		//create Statement obj
		Statement st=con.createStatement();
		//Send and execute SQL Query in DB s/w
		ResultSet rs=st.executeQuery("select * from student");
		//process the ResultSet
		while(rs.next()){
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
		//close jdbc objs
		rs.close();
		st.close();
		con.close();
	}//main
}//class

