package com.nt.jdbc;

import oracle.jdbc.rowset.OracleJDBCRowSet;

public class JdbcRowSetDemo {
	
	public static void main(String[] args)throws Exception {
		OracleJDBCRowSet jrowset=new OracleJDBCRowSet();
		jrowset.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		jrowset.setUsername("scott");
		jrowset.setPassword("tiger");
		jrowset.setCommand("select sno,sname,sadd from student");
		//execute Query
		jrowset.execute();
		//process the RowSet
		while(jrowset.next()){
			System.out.println(jrowset.getInt(1)+"  "+jrowset.getString(2)+" "+jrowset.getString(3));
		}
		 		
		//close jdbc objs
		jrowset.close();
	}//main
}//class

