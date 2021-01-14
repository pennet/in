package com.oops.penchal;

public class Constructor_Overloading {
int id;
String name;
float sal;
 Constructor_Overloading(int i,String n) {
	id=i;
	name=n;
	
	
}
 
 Constructor_Overloading(int i,String n,float s) {
		id=i;
		name=n;
		sal=s;
		
	}void display(){
		System.out.println(id+"    "+name+"   "+sal);
	}
	public static void main(String[] args) {
		Constructor_Overloading c=new Constructor_Overloading(101, "Rama");
		Constructor_Overloading c1=new Constructor_Overloading(102, "Taga",102);
		c.display();
		c1.display();
	}

}
