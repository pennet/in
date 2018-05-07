package com.oops.penchal;

class Vehical{
	void run(){
		System.out.println("Vehical Running");
	}
}
public class Override1 extends Vehical{

	void run(){
		System.out.println("Override 1 running");
	}
	public static void main(String[] args) {
		
		Vehical o=new Override1();
		o.run();
	}
}
