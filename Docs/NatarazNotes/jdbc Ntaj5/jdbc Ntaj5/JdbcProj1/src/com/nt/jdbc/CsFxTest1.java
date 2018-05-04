package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class CsFxTest1 {
	public static void main(String[] args)throws Exception {
		//read input value
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no:");
		int no=sc.nextInt();
		//register  driver and establish the connection
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
        //prepare Query
		 String qry="{?= call Fx_Get_EmpDetails(?,?,?)}";
        //create CallableStatement obj
		  CallableStatement cs=con.prepareCall(qry);
        //register return,OUT params with JDBC types
		  cs.registerOutParameter(1,Types.VARCHAR);//return param
		  cs.registerOutParameter(3,Types.VARCHAR);//out param
		  cs.registerOutParameter(4,Types.INTEGER);// out param
		//set value to IN param
		  cs.setInt(2,no);
        //call pl/sql function
		  cs.execute();
		 //Gather results from OUT,return parameters
		  int salary=cs.getInt(4); //from OUT
		  String desg=cs.getString(1); //from return
		  String name=cs.getString(3); //from OUT
		  System.out.println("Name:"+name+"desg="+desg+"Salary="+salary);
		  //close jdbc objs
		  cs.close();
		  con.close();
	}//main
}//class
