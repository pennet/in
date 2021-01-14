package com.string.penchal;

import java.util.Scanner;

public class String_Reverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	//String s="RamaKrishna";
	/*for(int i=s.length()-1;i>=0;i--){
	
		System.out.print(s.charAt(i));
	
		}*/
		
		
/*StringBuffer sb=new StringBuffer("Raama");

System.out.println(sb.reverse());
*/
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String : ");
		String s=sc.next();
		for(int i=s.length()-1;i>=0;i--){
			
			System.out.print(s.charAt(i));
		
			}
		
		
	}

}
