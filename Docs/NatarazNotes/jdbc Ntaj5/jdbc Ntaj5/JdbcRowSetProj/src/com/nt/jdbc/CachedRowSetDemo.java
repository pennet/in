package com.nt.jdbc;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class CachedRowSetDemo {
	public static void main(String[] args)throws Exception {
		//create CachedRowSet
		OracleCachedRowSet crowset =new OracleCachedRowSet();
		crowset.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		crowset.setUsername("scott");
		crowset.setPassword("tiger");
		crowset.setCommand("select * from student");
		//execute the Query
		crowset.execute();
		//Process the ResultSet
		while(crowset.next()){
			System.out.println(crowset.getInt(1)+" "+crowset.getString(2)+" "+crowset.getString(3));
		}
		
		Thread.sleep(20000); //Pause DB
		
		crowset.setReadOnly(false);
		crowset.absolute(3);
		crowset.updateString(2,"karan1");
		crowset.updateRow();
		
		Thread.sleep(20000); //Resume DB
	
		crowset.acceptChanges(); //Syncs the changes with DB
		System.out.println("Updated...");
		
		
		
		
	}

}
