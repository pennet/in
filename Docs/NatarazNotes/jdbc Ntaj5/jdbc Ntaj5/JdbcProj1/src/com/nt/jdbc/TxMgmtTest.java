package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class TxMgmtTest {
	public static void main(String[] args)throws Exception {
		//read inputs
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter Source Account no:");
       int srcNo=sc.nextInt();
       System.out.println("Enter Dest Account no:");
       int destNo=sc.nextInt();
       System.out.println("Enter amount to transfer");
       int amt=sc.nextInt();
       
      //create jdbc con obj
       Class.forName("oracle.jdbc.driver.OracleDriver");
  	 //Establish the connection
  	  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
  	   //Begin the Tx
  	   con.setAutoCommit(false);
  	   //add withdraw,deposite queries to ghe batch
  	   Statement st=con.createStatement();
  	    //for withdraw operation
  	   st.addBatch("update jdbc_Account set balance=balance-"+amt+" where accno="+srcNo);
  	    //for deposite operation
  	   st.addBatch("update jdbc_Account set balance=balance+"+amt+" where accno="+destNo);
  	    // Execute the batch
  	   int result[]=st.executeBatch();
  	   
  	   //Perform Tx mgmt(commit or rollback)
  	   boolean flag=false;
  	   for(int i=0;i<result.length;++i){
  		   if(result[i]==0){
  			   flag=true;
  			   break;
  		   }//if
  	   }//for
  	   
  	   if(flag==false){
  		   con.commit();
  		   System.out.println("Money Transfered(Tx committed)");
  	   }
  	   else{
  		   con.rollback();
  		 System.out.println("Money Not Transfered(Tx rolledback)");
  	   }
  	   
  	   //close jdbc objs
		st.close();
		con.close();
	}

}
