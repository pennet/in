package com.nt.jdbc;

import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CLOBRetrieve {
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
   		Reader reader=null;
   		if(rs.next()){
   			reader=rs.getCharacterStream(4);
   		}
   		//create Writer
   		Writer writer=new FileWriter("myResume.txt");
   		//use Buffer based logic to write CLOB value to Dest file
   		char buffer[]=new char[2048];
   		int charsRead=0;
   		while((charsRead=reader.read(buffer))!=-1){
   			writer.write(buffer,0,charsRead);
   		}
   		
   		System.out.println("File has been Retrieved");
   		
   		//close jdbc objs
   		reader.close();
   		writer.close();
   		rs.close();
   		ps.close();
   		con.close();
	}//main
}//class

