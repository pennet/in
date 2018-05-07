package com.string.penchal;

public class String_equals_Ignore {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	String s1="java";
	String s2="Dotnet";
String s3="Python";
String s4="java";
	System.out.println(s1.equals(s2));
	System.out.println(s1.equalsIgnoreCase("Java"));
	System.out.println(s1.equals(s3));
	System.out.println(s1.equals(s4));
	
	}

}
