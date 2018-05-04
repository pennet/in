package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class CsFxTest2 {

	public static void main(String[] args)throws Exception {
		//read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter studnet no");
		int no=sc.nextInt();
		//register  driver and establish the connection
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
       //prpeare Query to call pl/sql function
		String qry="{?=call Fx_View_Delete_Student(?,?)}";
		//create Callable Statement obj
		CallableStatement cs=con.prepareCall(qry);
		//register return,OUT params with JDBC types
		cs.registerOutParameter(1,OracleTypes.CURSOR);
		cs.registerOutParameter(3,Types.INTEGER);
		//set values to IN params
		cs.setInt(2,no);
		//call pl/sql function
		cs.execute();
		//gather results from return ,OUT params
		ResultSet rs=(ResultSet)cs.getObject(1);//return param
		System.out.println(no+" student details are");
		while(rs.next()){
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getString(3));
		}
        //close ResultSet
		rs.close();
		int cnt=cs.getInt(3);
		if(cnt==0)
			System.out.println("Record not deleted");
		else
			System.out.println("Record deleted");
		
		//close jdbc objs
		cs.close();
		con.close();
	}//main
}//class

