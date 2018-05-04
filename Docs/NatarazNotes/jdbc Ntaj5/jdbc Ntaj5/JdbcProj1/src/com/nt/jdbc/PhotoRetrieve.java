package com.nt.jdbc;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PhotoRetrieve {
  public static void main(String[] args)throws Exception {
  //read inputs
  Scanner sc=new Scanner(System.in);
   System.out.println("Enter student no:");
   int no=sc.nextInt();
/*  //create jdbc con 
   Class.forName("oracle.jdbc.driver.OracleDriver");
   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger"); */
   Class.forName("org.gjt.mm.mysql.Driver");
   Connection con=DriverManager.getConnection("jdbc:mysql:///ntaj5db2", "root", "root");
   
  //create PreparedStatement obj
   PreparedStatement ps=con.prepareStatement("select * from empall where eno=?");
  //set values query params
   ps.setInt(1,no);
   //execute the Query
   ResultSet rs=ps.executeQuery();
   // get Inputstream pointing to the Source
   InputStream is=null;
   if(rs.next()){
	   is=rs.getBinaryStream(4);
   }
   // get OutputStream pointing to the Dest
   OutputStream os=new FileOutputStream("newpitct.png");
   //complete content transfer
   byte[] buffer=new byte[4096];
   int bytesRead=0;
   while((bytesRead=is.read(buffer))!=-1){
	   os.write(buffer,0,bytesRead);
   }
   
   //close objs
   os.close();
   is.close();
   rs.close();
   ps.close();
   con.close();
	}
}
