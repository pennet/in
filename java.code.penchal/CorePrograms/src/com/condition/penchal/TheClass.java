package com.condition.penchal;
public class TheClass {
    public TheClass(){
        return;
        
        
    }
  public void TheClass(){ //confusing, but this is void method not constructor
   	System.out.println("Constuctor void ");
   	return;
    	
    }

    public static void main(String[]a){
        TheClass n = new TheClass();
        n.TheClass();//void method invocation
    }
}