package com.string.penchal;

public class String_getChar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s="Hello how are you";
		char[] b=new char[5];
		try {
			
			s.getChars(5,10, b,0);
			System.out.println(b);
		} catch (Exception e) {
		System.out.println(e);
		}
		
	}

}
