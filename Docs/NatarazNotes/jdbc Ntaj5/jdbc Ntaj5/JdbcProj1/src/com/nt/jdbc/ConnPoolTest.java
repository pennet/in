package com.nt.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class ConnPoolTest {
	public static void main(String[] args)throws Exception {
      //create DataSoruce obj pointing an empty jdbc con pool
		OracleConnectionPoolDataSource ds=new OracleConnectionPoolDataSource();
		ds.setDriverType("thin");
		ds.setURL("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUser("scott");
		ds.setPassword("tiger"); //By these details the con objs
		                         // will be created in jdbc con pool
		//get Connection obj from jdbc conppol
		Connection con=ds.getConnection();
		//create STatement obj
		Statement st=con.createStatement();
		//send and execute SQL Query in DB s/w
		ResultSet rs=st.executeQuery("select * from student");
		//process the ResultSet
		while(rs.next()){
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getString(3));
		}
		//close jdbc objs
		rs.close();
		st.close();
		con.close(); //releases the con obj back to con pool
	}

}
