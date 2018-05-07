package com.oops.penchal;

class Student1{
	int id;
	String name;
	
	
	void insertRecord(int a, String n){
	id=a;
	name=n;
	}
	void display(){
		System.out.println(id+"   "+name);
	}
}



public class ObjectClass_Innitilize_Method {


	public static void main(String[] args) {
		
		Student1 s=new Student1();
		
		Student1 s1=new Student1();
		s.insertRecord(101,"RAMA");
		s1.insertRecord(102,"RAhgMA");
		s.display();
		s1.display();
		
	}

}
