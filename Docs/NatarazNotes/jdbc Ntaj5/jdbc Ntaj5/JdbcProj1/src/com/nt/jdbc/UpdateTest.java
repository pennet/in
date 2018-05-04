package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest {

	public static void main(String[] args)throws Exception {
      //read inputs
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Existing student no:");
		int no=sc.nextInt(); //gives 1009
		 sc.nextLine();
		
		System.out.println("Enter new name:");
		String name=sc.nextLine(); //gives new raja
		
		System.out.println("Enter  new address");
		String addrs=sc.nextLine(); //gives new hyd
		
		//convert input values as requied for SQL Query
		name="'"+name+"'"; //gives 'new raja'
		addrs="'"+addrs+"'"; //gives 'new hyd' 
		
		 //register jdbc driver
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 //Establish the connection
		 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		 //create Statement obj
		 Statement st=con.createStatement();
		 //prepare SQL Query
		    //update student set sname='new raja',sadd='new hyd' where sno=999
		 String qry="update student set sname="+name+",sadd="+addrs+" where sno="+no;
		 System.out.println(qry);
		 
		 //send and execute SQL Query in dB s/w
		 int result=st.executeUpdate(qry);
		 
		 //process the result
		 if(result==0)
			 System.out.println("Record not found for upldation");
		 else
			 System.out.println(result+" no.of records are updated");
		 //close jdbc objs
		 st.close();
		 con.close();
		 sc.close();
	}
}
