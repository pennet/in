package com.oops.penchal;

class Employe{
	float sal=5000;
	
	
	
}class Programmer extends Employe{
	float inc=1000;
	
}


public class Inheritance {


	public static void main(String[] args) {
	Programmer p=new Programmer();
	
		//p.display();	
		System.out.println("Employe Salary: "+p.sal);
		System.out.println("Programmer Increment : "+p.inc);
		

	}

}
