package com.nt.jdbc;

import java.io.FileWriter;
import java.io.StringWriter;

import oracle.jdbc.rowset.OracleWebRowSet;

public class WebRowSetDemo {
  public static void main(String[] args)throws Exception {
	OracleWebRowSet wrowset=new OracleWebRowSet();
	wrowset.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
	wrowset.setUsername("scott");
	wrowset.setPassword("tiger");
	wrowset.setCommand("select * from student");
	wrowset.execute();
	
	StringWriter sw=new StringWriter();
	wrowset.writeXml(sw);
	System.out.println(sw);
	
	//write Rowset obj data to xml file
	 FileWriter fw=new FileWriter("student.xml");
	 wrowset.writeXml(fw);
	 fw.flush();
	 fw.close();
	 
	 //close rowset
	 wrowset.close();
  }
}
