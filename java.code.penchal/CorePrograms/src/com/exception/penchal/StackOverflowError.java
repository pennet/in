package com.exception.penchal;

public class StackOverflowError {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Main methosd Called .");
		main(new String[0]);

	}

}
