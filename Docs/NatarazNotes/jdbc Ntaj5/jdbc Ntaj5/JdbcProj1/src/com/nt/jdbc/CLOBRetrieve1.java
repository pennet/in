package com.nt.jdbc;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CLOBRetrieve1 {
	public static void main(String[] args)throws Exception {
		//read inputs
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter  student no");
       int no=sc.nextInt();
       //Establish the connection
   		Class.forName("oracle.jdbc.driver.OracleDriver");
   		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott","tiger");
       //create PrpeareedStaement obj
   		PreparedStatement ps=con.prepareStatement("select * from StudentAll where sno=?");
   		//set Query param values
   		ps.setInt(1,no);
   		//execute the Query
   		ResultSet rs=ps.executeQuery();
   		//process the ResultSet
   		Clob clb=null;
   		if(rs.next()){
   			clb=rs.getClob(4);
   		}
   		//get InputStream
   		InputStream is=clb.getAsciiStream();
   		//create Writer
   		OutputStream os=new FileOutputStream("newResume.txt");
   		//use Buffer logic
   		byte buffer[]=new byte[4096];
   		int bytesRead=0;
   		while((bytesRead=(is.read(buffer)))!=-1){
   			os.write(buffer,0,bytesRead);
   		}
   		System.out.println("file has been retrived");
   		//close jdbc objs
   		os.close();
   		is.close();
   		rs.close();
   		ps.close();
   		con.close();
	}//main
}//class

