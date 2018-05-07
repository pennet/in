package com.oops.penchal;




class Student{
	int id;
	String name;
	
}

public class ObjectClass_Initilize_Reference {

	public static void main(String[] args) {
		Student s=new Student();
		Student s1=new Student();
		s.id=100;
		s.name="Penchal";
		System.out.println(s.id +"    "+s.name);
		
		
		/// Multiple Dta [printing

		s1.id=104;
		s1.name="Rajaja";
		System.out.println(s1.id +"    "+s1.name);
		
		
		
		

	}

}
