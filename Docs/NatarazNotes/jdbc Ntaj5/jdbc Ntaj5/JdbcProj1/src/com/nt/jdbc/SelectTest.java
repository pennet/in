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
		ResultSet rs=st.executeQuery("select * from "+args[0]);
		//get ResultSetMetaData  obj
		ResultSetMetaData rsmd=rs.getMetaData();
		// get col count
		int colcnt=rsmd.getColumnCount();
		//Display col names
		for(int i=1;i<=colcnt;++i){
			System.out.print(rsmd.getColumnLabel(i)+"\t");
		}
		System.out.println();
		//display col data types
		for(int i=1;i<=colcnt;++i){
			System.out.print(rsmd.getColumnTypeName(i)+"\t");
		}
		System.out.println();
        //col values
		while(rs.next()){
			
			for(int i=1;i<=colcnt;++i){
				System.out.print(rs.getString(i)+"\t");
			}
			System.out.println();
			
		}
		
		   //close jdbc objs
		   rs.close();
		   st.close();
		   con.close();
	}//main
}//class
//>javac  SelectTest.java
//>java SelectTest

