package com.nt.jdbc; 
import oracle.jdbc.rowset.OracleCachedRowSet;
import oracle.jdbc.rowset.OracleJoinRowSet;

 class JoinRowSetDemo {
 public static void main(String args[]) throws Exception{
	 
     //cached RowSet1
      OracleCachedRowSet crs1 = new OracleCachedRowSet();
      crs1.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
      crs1.setUsername("scott");
      crs1.setPassword("tiger");
      crs1.setCommand("select empno,ename,deptno from emp");
      crs1.setMatchColumn(3);
      crs1.execute();
//Cached RowSet2
      OracleCachedRowSet crs2 = new OracleCachedRowSet();
      crs2.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
      crs2.setUsername("scott");
      crs2.setPassword("tiger");
      crs2.setCommand("select deptno,dname,loc from dept");
      crs2.setMatchColumn(1);
      crs2.execute();
     
      //JoinRowSet
      OracleJoinRowSet joinRS=new OracleJoinRowSet();
      joinRS.addRowSet(crs2);
      joinRS.addRowSet(crs1);
   
      //Process JoinRowSet      
   while (joinRS.next()) {
	  System.out.println(joinRS.getString(1)+"  "+joinRS.getString(2)+"  "+joinRS.getString(3)+"  "+joinRS.getString(4));
      }
    
  
 }
} 
