package com.core.string;

import java.util.Scanner;

public class EmptyTest {

	public static void main(String[] args) {
	String s1="";
	String s2="";
	String s3="a";
	String s4=new String ();
	String s5=new String ("");
	String s6=new String("");
	String s7=new String ("a");
	System.out.println("Is S1 Empty "+s1.isEmpty());
	System.out.println("Is S2 Empty "+s2.isEmpty());
	System.out.println("Is S3 Empty "+s3.isEmpty());
	System.out.println("Is S4 Empty "+s4.isEmpty());
	System.out.println("Is S5 Empty "+s5.isEmpty());
	System.out.println("Is S6 Empty "+s6.isEmpty());
	System.out.println("Is S7 Empty "+s7.isEmpty());
	/*String s8=null;
	System.out.println("Is S8 is "+s8.isEmpty()); 
	String s9;
	System.out.println("Is s9 Empty "s9.isEmpty());*/
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter A String : ");
	System.out.println(sc.nextLine().isEmpty());	System.out.println("Enter B String : ");
	System.out.println(sc.nextLine().isEmpty());
	}

}
