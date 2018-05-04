package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class CsTest2 {

	public static void main(String[] args)throws Exception {
		//read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Emp no:");
		int no=sc.nextInt();
		//register jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		//prepare Query calling pl/sql procedure
		String qry="{ call get_EmpDetails(?,?,?)}";
		//create CallableStatement obj
		CallableStatement cs=con.prepareCall(qry);
		//register OUT params with Jdbc types
		cs.registerOutParameter(2,Types.VARCHAR);
		cs.registerOutParameter(3,Types.INTEGER);
		//set values to IN params
		cs.setInt(1,no);
		//call pl/sql procedure
		cs.execute();
		//Gather results from OUT params
		String name=cs.getString(2);
		int salary=cs.getInt(3);
		System.out.println("Emp name"+name);
		System.out.println("Emp Salary"+salary);
		//close jdbc objs
		cs.close();
		con.close();
	}//main
}//class

