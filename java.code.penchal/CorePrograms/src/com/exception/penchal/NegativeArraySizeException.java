package com.exception.penchal;


class A{
	public static void main(String[] args) {
		System.out.println("A Main Method Called ");
	}
}
class B{
	public static void main(String[] args) {
		System.out.println("B Main Method Called ");
	}
}
class C{
	public static void main(String[] args) {
		System.out.println("C Main Method Called ");
	}
}




public class NegativeArraySizeException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("NASE Main Method Called ");
		C.main(new String [-3]);
		/*try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/


	}

}
