package com;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	final static String URL="localhost:3306/";
	final static String DATABASE="pagination";
	final static String USER="root";
	final static String PASS="root";
	
	final static String DATA_TABLE="data";
	final static String ID_COL="id";
	final static String NAME_COL="name";
	
	public static Connection getCon(){
		Connection con=null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pagination","root","root");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return con;
	}
}
