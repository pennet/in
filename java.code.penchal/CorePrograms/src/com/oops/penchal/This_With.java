package com.oops.penchal;





class Student10{
	int id;
	String name;
	float fee;
 Student10(int id,String name,float fee) {
		
	 this.id=id;
	 this.name=name;
this.fee=fee;
	}void display(){
		System.out.println(id+"   "+name+"   "+fee);
	}
}

public class This_With {

	public static void main(String[] args) {
	Student10 t=new Student10(101,"Rama",10000);
	t.display();
	}

}
