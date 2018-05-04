package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

 

public class CsTest1 {
  public static void main(String[] args)throws Exception {
	  //read inputs
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter input value");
	  int no=sc.nextInt();
	  //register driver
	  Class.forName("oracle.jdbc.driver.OracleDriver");
	  //establish the connection
	  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott","tiger");
      //prepare Query calling pl/sql procedure
	  String qry="{ call first_pro1(?,?)}";
	  //create CallableStatement .
	  CallableStatement cs=con.prepareCall(qry);

	// Register Out Parameters with JDBC Types
	cs.registerOutParameter(2,Types.INTEGER);

	// set Values to IN parameter
	   cs.setInt(1,no);

	// call pl/sql procedure
	     cs.execute();

	// Gather the generated results from OUT params
	    int result=cs.getInt(2);
	    System.out.println("Square "+result);

	// Close  jdbc objs
	   cs.close();
	   con.close();
	}//main
}//class

