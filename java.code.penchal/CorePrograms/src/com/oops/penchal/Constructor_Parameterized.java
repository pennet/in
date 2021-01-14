package com.oops.penchal;

public class Constructor_Parameterized {
int id;
String name;
 Constructor_Parameterized(int i,String n) {
	id=i;
	name=n;
	
}void display(){
	System.out.println(id+"   "+name);
}
	public static void main(String[] args) {
		Constructor_Parameterized c=new Constructor_Parameterized(101, "Rama");
		c.display();

	}

}
