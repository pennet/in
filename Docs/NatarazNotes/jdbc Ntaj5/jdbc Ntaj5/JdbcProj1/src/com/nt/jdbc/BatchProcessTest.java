package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchProcessTest {
	public static void main(String[] args)throws Exception {
     //register jdbc driver
	  Class.forName("oracle.jdbc.driver.OracleDriver");
	 //Establish the connection
	  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
	  //Disable autocommit mode
	  con.setAutoCommit(false);
	  //create Jdbc Statement obj
	  Statement st=con.createStatement();
	  //add Queries to the batch
	  st.addBatch("insert into student values(5980,'ramesh','vizag')");
	  st.addBatch("update student set sadd='new delhi2' where sno>=1000");
	  st.addBatch("delete from student where sno<=1000");
	  //execute the batch
	  int result[]=st.executeBatch();
/*	  //process the Result
	  int sum=0;
	  for(int i=0;i<result.length;++i){
		  sum=sum+result[i];
	  }
	  System.out.println("No.of records effected"+sum); */
	  boolean flag=false;
	  for(int i=0;i<result.length;++i){
		  if(result[i]==0){
			  flag=true;
			  break;
		  }
	  }
	  if(flag==false){
		  con.commit();
	  }
	  else{
		  con.rollback();
	  }
	  
	  
	  //close jdbc objs
	   st.close();
	   con.close();
	}//main
}//class
