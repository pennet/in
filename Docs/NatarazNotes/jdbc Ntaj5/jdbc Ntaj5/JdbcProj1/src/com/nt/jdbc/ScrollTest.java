package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ScrollTest {
   public static void main(String[] args)throws Exception {
    //register jdbc drvier
	  Class.forName("oracle.jdbc.driver.OracleDriver");
    //Establish the connection
	  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
	//create PraredStatement obj
	  PreparedStatement ps=con.prepareStatement("select * from student",
			                                    ResultSet.TYPE_SCROLL_SENSITIVE,
			                                    ResultSet.CONCUR_READ_ONLY);
	
    //create Scrollable ResultSet obj
	  ResultSet rs=ps.executeQuery();
    //Display records (top-bottom)
	  System.out.println("Records (top-bottom)");
	  while(rs.next()){
		  System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
	  }
    //Display reords (Bottom-top)
	  System.out.println("Records (bottom-top)");
	  while(rs.previous()){
		  System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
	  }
	 //Access the records randomly or directly
	  rs.first();
	  System.out.println(rs.getRow()+"--->"+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
	  rs.last();
	  System.out.println(rs.getRow()+"--->"+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
	  rs.absolute(2);
	  System.out.println(rs.getRow()+"--->"+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
	  rs.absolute(-3);
	  System.out.println(rs.getRow()+"--->"+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
	  rs.relative(-2);
	  System.out.println(rs.getRow()+"--->"+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
	  rs.relative(4);
	  System.out.println(rs.getRow()+"--->"+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
	  //close jdbc objs
	  rs.close();
	  ps.close();
	  con.close();
  }
}
