package com.condition.penchal;

public class IfElseIf_MarksPassFail {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		
		 int mar=10;
		 
		 
		 if(mar<=35){
			System.out.println("Fail"); 
			 
		 }else if(mar>=35&mar<=55){
			 
			 System.out.println("Third Class");
		 }else if(mar>=55&mar<=85){
			 
			 System.out.println("Second  Class");
		 }
else if(mar>=85&mar<=100){
			 
			 System.out.println("First Class");
		 }else{
			 System.out.println("Invalid");
		 }
	}

}
