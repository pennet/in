package com.pen.array;

public class Array1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*int a[]={20,30,40};
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		*/
		
		
		int[] a = { 2, 5, -2,10 ,6, -3, 8, 10, -7, -9, 4 ,0,8};
	      int target = 0;
	      
	      for (int i = 0; i < a.length; i++) {
	         if (a[i] == target) {
	            System.out.println("Element found at index " + i);
	            break;
	         } 
	      } 
	}

}
