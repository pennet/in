package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest1 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		Scanner sc=null;
		try{
		 //read inputs
		  sc=new Scanner(System.in);
		  int no=0;
		  String name=null,addrs=null;
		  if(sc!=null){
			  System.out.println("Enter no:");
			  no=sc.nextInt();
			  System.out.println("Enter name");
			  name=sc.next();
			  System.out.println("Enter Address");
			  addrs=sc.next();
		  }
		  //convert input values as required for the SQL Query
		  name="'"+name+"'";
		  addrs="'"+addrs+"'";
		  
		  //register jdbc driver
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		 //Establish the connection
		 con=DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
		 //create Statement obj
		 if(con!=null)
			 st=con.createStatement();
		 
		 //prepare SQL Query
	     // insert into student values(1001,'raja','hyd')
	 String qry="insert into student values("+no+","+name+","+addrs+")";
	 System.out.println(qry);
	 
	 //send and execute SQL Query in DB s/w
	 int result=0;
	 if(st!=null){
		 result=st.executeUpdate(qry);
	 }
	 if(result==0)
		 System.out.println("Record not inserted");
	 else
		 System.out.println("Record inserted");
	}//try
	catch(ClassNotFoundException cnf){
		cnf.printStackTrace();
	}
    catch(SQLException se){
    	se.printStackTrace();
    }
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		//close jdbc objs
		try{
		 if(st!=null)
			 st.close();
		}
		catch(SQLException se ){
			se.printStackTrace();
		}
		
		try{
			 if(con!=null)
				 con.close();
			}
			catch(SQLException se ){
				se.printStackTrace();
			}
		try{
			 if(sc!=null)
				 sc.close();
			}
			catch(Exception e ){
				e.printStackTrace();
			}
	}//finally
 }//main
}//class

