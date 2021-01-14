package com.string.penchal;

public class String_charAt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String name="Jabva Tpoint";
		//char ch=name.charAt(8);// output o
		char ch=name.charAt(41);//java,lang.StringIndexOutOfBoundsException
		System.out.println(ch);
	}

}
