package com.oops.penchal;

public class Counter_With_Static {
 static int count=0;

	public Counter_With_Static() {
count++;
System.out.println(count);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Counter_With_Static c=new Counter_With_Static();
		Counter_With_Static c1=new Counter_With_Static();
		Counter_With_Static c2=new Counter_With_Static();

	}

}
