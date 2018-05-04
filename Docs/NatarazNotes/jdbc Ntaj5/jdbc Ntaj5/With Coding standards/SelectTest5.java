//SeelctTest5.java
package com.nt.jdbc;
/* Application that gives student details based on the given
      city names
  * version : 1.0
  * author:   Team-S
  *  Date  : 16/09/2015 */
  import java.sql.DriverManager;
  import java.sql.Connection;
  import java.sql.Statement;
  import java.sql.ResultSet;
  import java.sql.SQLException;
  import  java.util.Scanner;

  public class SelectTest5
  {
	  public static void main(String args[]){
		  Connection con=null;
		  Statement st=null;
		  ResultSet rs=null;
		  Scanner sc=null;
		  try{
			  //read inputs
			  sc=new  Scanner(System.in);
			  String city1=null,city2=null,city3=null;
			  if(sc!=null){
				  System.out.println("Enter City1:");
				  city1=sc.next();  // hyd

				  System.out.println("Enter City2:");
				  city2=sc.next();  // vizag

				  System.out.println("Enter City3:");
				  city3=sc.next();  // mumbai
			  }//if

			  //prepare condition as required for the SQL Query
			           //  ('hyd','vizag','mumbai')
			 String cond="('"+city1+"','"+city2+"','"+city3+"')";

			 //register jdbc driver
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			 //Establish the connection
			 con=DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
			 // create STatement obj
			 if(con!=null){
				 st=con.createStatement();
			 }
			 //prepare SQL Query
			 String qry="select * from student where sadd in"+cond;
			 System.out.println(qry);
			 //send and execute SQL Query in DB s/w
			 if(st!=null)
				 rs=st.executeQuery(qry);
			 //Process the ResultSet
			 boolean flag=false;
			 if(rs!=null){
				 while(rs.next()){
					 flag=true;
					 System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
				 }//while
			 }//if
			 if(!flag){
				 System.out.println("Records not found");
			 }
		  }//try
		  catch(ClassNotFoundException cnf){   //for known Exception
			  cnf.printStackTrace();
		  }
		  catch(SQLException se){  //for known exception
			  se.printStackTrace();
		  }
		  catch(Exception e){  //for unknown exception
			  e.printStackTrace();
		  }
		  finally{
			  //clsoe jdbc objs
			  try{
				  if(rs!=null){
					  rs.close();
				  }
			  }//try
			  catch(SQLException se){
					  se.printStackTrace();
				  }

				  try{
				  if(st!=null){
					  st.close();
				  }
				  }
				  catch(SQLException se){
					  se.printStackTrace();
				  }

				  try{
				     if(con!=null){
						 con.close();
					 }
				  }
				  catch(SQLException se){
					  se.printStackTrace();
				  }

				  try{
					  if(sc!=null){
						  sc.close();
					  }
				  }
				  catch(Exception e){
					  e.printStackTrace();
				  }
			  }//finally
	  }//main
  }//class
  //>javac  -d   .   SelectTest5.java
  //>java  com.nt.jdbc.SelectTest5
