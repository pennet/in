package com.operator.penchal;

public class RightShiftOperator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int a=12;
		int b=10;
		int c=5;
		System.out.println(10>>2);
		System.out.println(20>>4);
		
		
		System.out.println(a<b&&a++<c);//false && true = false  
		System.out.println(a);//10 because second condition is not checked  
		System.out.println(a<b&a++<c);//false && true = false  
		System.out.println(a);//11 because second condition is checked  

	}

}
