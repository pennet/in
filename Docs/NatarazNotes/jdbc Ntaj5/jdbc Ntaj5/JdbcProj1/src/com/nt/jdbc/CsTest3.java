package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class CsTest3 {
	public static void main(String[] args)throws Exception {
     //read inputs
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter inintial chars of emp name");
	  String initchars=sc.next(); //gives A
	  initchars=initchars+"%";  // gives 'A%'
	 //register jdbc driver
	  Class.forName("oracle.jdbc.driver.OracleDriver");
	  //establish the connection
	 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott", "tiger");
	  //prepare Query to call pl/sql procedure
	  String qry="{ call fetch_AllEmpDetails(?,?)}";
	  // create CallableStatment obj
	  CallableStatement cs=con.prepareCall(qry); 
      //register OUT param with JDbc type
	  cs.registerOutParameter(2,OracleTypes.CURSOR);
	  //set values in IN param
	  cs.setString(1,initchars);
	  //call pl/sql procedure
	  cs.execute();
	  //Gather results from Out param 
	  ResultSet rs=(ResultSet)cs.getObject(2);
	  //Process the ResultSet
	  System.out.println("Emp Details whose begins with"+ initchars);
	  while(rs.next()){
		  System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getString(3)+"  "+rs.getString(4));
	  }
	  //close jdbc objs
	  rs.close();
	  cs.close();
	  con.close();
	}//main
}//class

