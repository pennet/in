package com.oops.penchal;

class SuperOverride{
	void run(){
		System.out.println("Vehical is Running.");
	}
}
public class Overridding extends SuperOverride{
public static void main(String[] args) {
	Overridding v=new Overridding();
	v.run();
}
}
