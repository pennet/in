
class Parent{
	void display(){
		System.out.println("Parent Called");
	}
}

class Child extends Parent{
	void display(){
		System.out.println("Child Called");
	}
}


public class Test {

	
	public static void main (String args []){
		
		//Parent p=new Child();
		
		Parent p1=new Child();
		
		p1.display();
		//p.display();
		//System.out.println(p);
	}
}
