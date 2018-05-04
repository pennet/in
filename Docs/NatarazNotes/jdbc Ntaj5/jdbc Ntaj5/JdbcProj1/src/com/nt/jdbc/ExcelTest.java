//ExcelTest.java
package com.nt.jdbc;
import java.sql.*;
public class ExcelTest {
	public static void main(String[] args)throws Exception {
		//register jdbd driver
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:odbc:xlsdsn");
	/*	//create Staement obj
		Statement st=con.createStatement();
		// send and execute SQL Query in Db s/w
		ResultSet rs=st.executeQuery("select * from [Sheet1$]");
		// Process the ResultSet
		while(rs.next()){
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		}*/
        PreparedStatement ps=con.prepareStatement("insert into [sheet1$] values(?,?,?)");
		ps.setInt(1,300);
		ps.setString(2,"ramesh");
		ps.setString(3,"indore");
		int result=ps.executeUpdate();
		System.out.println( result+" no.of records are inserted");


	/*	//close jdbc objs
		rs.close();
		st.close();
		con.close(); */
	}
}
