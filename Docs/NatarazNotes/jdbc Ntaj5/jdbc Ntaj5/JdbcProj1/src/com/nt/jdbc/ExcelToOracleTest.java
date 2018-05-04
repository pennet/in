package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExcelToOracleTest {

	public static void main(String[] args)throws Exception {
     //register drivers
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Class.forName("oracle.jdbc.driver.OracleDriver");
	 //Establish the connections
	   Connection oracon=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
	   Connection xlscon=DriverManager.getConnection("jdbc:odbc:xlsdsn");
	 //Create Statement objs
	   Statement st=xlscon.createStatement();
	   PreparedStatement ps=oracon.prepareStatement("insert into student values(?,?,?)");
	 //get records from Excel sheet
	   ResultSet rs=st.executeQuery("select * from [sheet1$]");
	 // copy each record of Result to Oracle db table
	   while(rs.next()){
		   //get each record of excel sheet
		   int no=rs.getInt(1);
		   String name=rs.getString(2);
		   String addrs=rs.getString(3);
		   //set the above values to insert query params to insert record
		   ps.setInt(1,no);
		   ps.setString(2,name);
		   ps.setString(3,addrs);
		   ps.executeUpdate();
	   }//while
	   
	   System.out.println("Records are copiled Excel sheet to oracle db table");
		   
	   //close jdbc objs
	   st.close();
	   ps.close();
	   rs.close();
	   oracon.close();
	   xlscon.close();
	}
}
