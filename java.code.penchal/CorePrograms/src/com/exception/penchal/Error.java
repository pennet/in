package com.exception.penchal;

public class Error {

	
	public static void main(String[] args) {
	System.out.println("Main Method");
	m1();

	}

	private static void m1() {
		System.out.println("m1() Method Called.");
		main(new String[0]);
		
	}

}
