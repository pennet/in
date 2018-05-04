package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdatableTest {
	public static void main(String[] args)throws Exception {
      //register jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
	  //create Jdbc Statement obj
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				                         ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=st.executeQuery("select sno,sname,sadd from student");
		//select operation
		while(rs.next()){
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getString(3));
		}
	/*	//insert operation
		rs.moveToInsertRow();
		rs.updateInt(1,9988);
		rs.updateString(2,"anil");
		rs.updateString(3,"vizag");
		rs.insertRow();
		System.out.println("Insert operation....."); */
	/*	//Update Row
		rs.absolute(4);
		rs.updateString(3,"new delhi");
		rs.updateRow();
		System.out.println("Update Operation......"); */

		//Delete Row
		rs.absolute(4);
		rs.deleteRow();
		System.out.println("Deleting Operation......");   
		
		
		
		//close jdbc objs
		rs.close();
		st.close();
		con.close();
		
	}//main
}//class

