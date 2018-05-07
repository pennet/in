package com.oops.penchal;

public class Constructor_Static {

	int id;
	String name;
	static String college="NIST";
	
	 Constructor_Static(int i,String n) {
		id=i;
		name=n;
	}void display(){
		System.out.println(id+"    "+name+"   "+college);
	}
	public static void main(String[] args) {
		Constructor_Static c=new Constructor_Static(101, "Rama");
		c.display();

	}

}
