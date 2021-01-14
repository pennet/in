package com.oops.penchal;

class A1{
	A1(){
	//this(10);
		System.out.println("Constructor Called");
	}
	A1(int x){
		this();
		System.out.println("Parameterized Constructor Called.");
		System.out.println(x);
	}
}
public class Call_Default_Constructor_Parameterized {

	
	public static void main(String[] args) {
		A1 a =new A1(45);
		//A1 a =new A1();
	}

}
