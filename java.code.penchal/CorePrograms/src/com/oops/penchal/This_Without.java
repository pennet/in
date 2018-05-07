package com.oops.penchal;





class Studenta{
	int id;
	String name;
	float fee;
 Studenta(int id,String name,float fee) {
		
	 id=id;
	 name=name;
fee=fee;
	}void display(){
		System.out.println(id+"   "+name+"   "+fee);
	}
}

public class This_Without {

	public static void main(String[] args) {
	Studenta t=new Studenta(101,"Rama",10000);
	t.display();
	}

}
