package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteTest {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		Scanner sc=null;
		try{
		 //read inputs
		 sc=new Scanner(System.in);
		 int no=0;
		 if(sc!=null){
			 System.out.println("enter student no:");
			 no=sc.nextInt(); //gives 801
		 }
		 //register jdbc driver
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		 //Establish the connection
		 con=DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
		 //create Statement obj
		 if(con!=null)
			 st=con.createStatement();
		 //send and execute SQL Query in DB s/w
		 int result=0;
		 if(st!=null)
			 result=st.executeUpdate("delete from student where sno="+no);
		 //process the result
		 if(result==0)
			 System.out.println("Record not found to delete");
		 else
			 System.out.println(result+" no.of records are deleted");
		}///try
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
			try{
			 if(st!=null)
				 st.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			
			try{
			  if(con!=null)
				  con.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
		}//finally
	}//main
}//class

