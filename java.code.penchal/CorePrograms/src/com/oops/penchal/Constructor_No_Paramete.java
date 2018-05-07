package com.oops.penchal;

public class Constructor_No_Paramete {
 int id;
 String name;
 void display(){
	 System.out.println(id+"  "+name);
 }
	public static void main(String[] args) {
		Constructor_No_Paramete c=new Constructor_No_Paramete();
		c.display();
	}

}
