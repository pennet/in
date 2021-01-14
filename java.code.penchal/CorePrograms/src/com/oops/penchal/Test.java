package com.oops.penchal;
class Parent{
	void display(){
		System.out.println("Parent Called.");
	}	
}class Child extends Parent{
	void display(){
		System.out.println("Child Called.");
	}
}
public class Test {
	public static void main(String[] args) {			
		Parent p=new Child();
		
		//Parent p=new Parent();
		
		p.display();
		
	}

}
