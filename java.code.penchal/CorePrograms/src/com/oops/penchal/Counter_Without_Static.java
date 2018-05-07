package com.oops.penchal;

public class Counter_Without_Static {

	int count=0;
	
	 Counter_Without_Static() {
		count++;
		System.out.println(count);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Counter_Without_Static c=new Counter_Without_Static();
		Counter_Without_Static c1=new Counter_Without_Static();
		Counter_Without_Static c2=new Counter_Without_Static();
		
		

	}

}
