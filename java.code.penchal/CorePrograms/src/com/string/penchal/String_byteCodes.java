package com.string.penchal;

public class String_byteCodes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	 String s="ABCD";
	byte [] brr=s.getBytes();
	
			for (int i = 0; i < brr.length; i++) {
				System.out.println(brr[i]);
			} 

	}

}
