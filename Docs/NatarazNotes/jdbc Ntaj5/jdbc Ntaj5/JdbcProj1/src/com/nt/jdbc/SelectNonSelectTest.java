package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SelectNonSelectTest {

	public static void main(String[] args)throws Exception {
		//read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Query");
		String qry=sc.nextLine();
		
		 //register jdbc driver
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		 //Establish the connection
		 Connection con=DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
		 //create Statement obj
		 Statement st=con.createStatement();
		 
		 //send and execute SQL Query
		 boolean flag=st.execute(qry);
		 if(flag==true){
			 System.out.println("Select Query is executed");
			 ResultSet rs=st.getResultSet();
			 while(rs.next()){
				 System.out.println(rs.getInt(1)+" "+rs.getString(2)+"  "+rs.getString(3));
			 }
			 rs.close();
		 }
		 else{
			 System.out.println("Non-select Query is executed");
			 int cnt=st.getUpdateCount();
			 System.out.println("No.of records that are effected"+cnt);
		 }
		
		 //close jdbc objs
		 st.close();
		 con.close();
	}

}
