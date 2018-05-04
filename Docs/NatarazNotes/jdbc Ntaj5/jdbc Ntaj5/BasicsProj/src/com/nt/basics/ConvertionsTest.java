package com.nt.basics;

import java.text.SimpleDateFormat;

public class ConvertionsTest {
	public static void main(String[] args)throws Exception {
		
     //Converting String date value to java.util.Date class obj
		String d1="15-40-1990"; //MM-dd-yyyy
		SimpleDateFormat sdf1=new SimpleDateFormat("MM-dd-yyyy");
		java.util.Date ud1=sdf1.parse(d1);
		System.out.println("util date"+ud1);
   
		// Converting java.util.Date class obj to java.sql.Date class obj
	   long  ms=ud1.getTime();
       java.sql.Date sqd1=new java.sql.Date(ms);
	   System.out.println("sql date"+sqd1);
	
	   /*converting String date value directly to
	   java.sql.Date class obj with out converting it 
	   to java.util.Date class obj.For this String 
	   date value must be there yyyy-MM-dd pattern*/
	   String d2="2010-10-24"; //yyyy-MM-dd
	   java.sql.Date sqd2=java.sql.Date.valueOf(d2);
	   System.out.println("sql date"+sqd2);
	   
  //Converting java.sql.Date class obj to java.util.Date class obj
    java.util.Date ud2=(java.util.Date)sqd2; //typecasting
    System.out.println("util date"+ud2);
    
  // Converting java.util.Date class obj to String date value
  SimpleDateFormat sdf2=new SimpleDateFormat("MMM-yyyy-dd");
  String output=sdf2.format(ud2);
  System.out.println("String date"+output);
  
	   
	    
	   
		
		
		
		
	}

}
