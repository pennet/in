package com.nt.jdbc;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class CLOBInsert {
	public static void main(String[] args)throws Exception {
     //read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter sno");
		int no=sc.nextInt();
		System.out.println("Enter sname");
		String sname=sc.next();
		System.out.println("Enter address");
		String sadd=sc.next();
		System.out.println("Enter resume path");
		String resumePath=sc.next();
		
	  //register jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
	   //Establish the connection
	   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott","tiger");
	   //create PrpearedStatement obj
	   PreparedStatement ps=con.prepareStatement("insert into studentAll values(?,?,?,?)");
	   // Create java.io.File obj
	   File file=new File(resumePath);
	   long length=file.length();
	   //Create Reader obj pointing resume
	   Reader reader=new FileReader(file);
	   //set param values(?) to Query
	   ps.setInt(1,no);
	   ps.setString(2,sname);
	   ps.setString(3,sadd);
	   ps.setCharacterStream(4,reader,(int)length);
	   //ps.setClob(4,reader,length);
	   //execute the Query
	   int result=ps.executeUpdate();
	   // process the Result
	   if(result==0)
		   System.out.println("Record not inserted");
	   else
		   System.out.println("Record inserted");
	   
	   //close jdbc objs
	   reader.close();
	   ps.close();
	   con.close();
	}

}
