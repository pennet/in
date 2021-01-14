package com.oops.penchal;

class Employee{
	int id;
	String name;
	float salary;
	void insert(int i,String n,float f){
		
		id=i;
		name=n;
		salary=f;
	}
	void dislplay(){
		System.out.println(id+"   "+ name+"  "+salary);
	}
	
}


public class ObjectClass_Initilize_Constructor {

	public static void main(String[] args) {
		Employee e =new Employee();
	e.insert(101,"Rama",1200);
	e.dislplay();
		
	}

}
