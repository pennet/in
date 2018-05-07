package com.osair.penchal;

public class Student {
	String name;
	public Student(String name){
		this.name=name;
	}
	public static void main(String[] args) {
	Student s1=new Student("john");
	Student s2=new Student("smith");
	Student s3=new Student("john");
	Student s4=s1;
	System.out.println(s1.equals(s2));
	System.out.println(s1.equals(s3));
	System.out.println(s1.equals(s4));

	}

}
