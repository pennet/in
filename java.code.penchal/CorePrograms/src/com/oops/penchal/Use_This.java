package com.oops.penchal;

class A{
	void m(){
		System.out.println("M called");
	}
	void n(){
		
		System.out.println("N called");
		m();
		//this.m();
	}
}

public class Use_This {

	
	public static void main(String[] args) {
		A a=new A();
		a.n();

	}

}
