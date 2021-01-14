package com.core.penchal;

import java.util.Scanner;

public class StringCharDuplicate { 
/*
public static void main(String[] args) { 

//String ip="navneet"; 
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter String : ");
	String ip=sc.next();
//String ip="aaaa"; 
int count=0; 
char [] input = ip.toCharArray(); 
System.out.println("Duplicate Characters are :  "); 
for(int i=0;i<ip.length();i++) 
{ 
for(int j=i+1;j<ip.length();j++) 
{ 
if(input[i]==input[j]) 
{ 
System.out.println(input[j]); 
count ++; 
break; 
} 
} 
} 


} */
	
	
	public static void main(String[] args) { 
		String str="kkttyyhjnu"; 
		int count=0; 
		for(int i=0;i<str.length();i++) 
		{ 
		for(int j=i+1;j<str.length();j++) 
		{ 
		if(str.charAt(i)==str.charAt(j)) 
		{ 
		System.out.println( "Duplicate Character : "+str.charAt(j)); 
		count++; 
		} 
		} 
		} 

	}}
