package com.oops.penchal;

class Animal{
	void eat(){
		System.out.println("Animal Eating.");
	}
}class Dog extends Animal{
	void eat(){
		System.out.println("Dog Called");
	}
}
class BabyDog extends Dog{
	void eat(){
		System.out.println("BabyDog Called");
	}
}


public class Inherit_Sample {

	
	public static void main(String[] args) {
		

Animal b=new Dog();
		b.eat();
		b.eat();
		b.eat();
		
	}

}
