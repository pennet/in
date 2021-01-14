package com.oops.penchal;

public class Constructor_Static_Variable {

	int id;
String name;
static String college="VBIT";
static void change(){
	college="NIST";
}

 Constructor_Static_Variable(int i,String n) {
id=i;
name=n;

	}
 void display(){
	 System.out.println(id+"  "+name+"  "+ college);
 }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
Constructor_Static_Variable.change();
Constructor_Static_Variable c=new Constructor_Static_Variable(100,"Rama");
c.display();

	}

}
