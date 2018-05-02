package tests;

import java.io.*;
public class Main {
	public static void main(String[] args) {
		File file = new File("Data.txt");
		
		
		try (FileInputStream fis = new FileInputStream(file)) {
 			int content;
			while ((content = fis.read()) != -1) {
				// convert to char and display it
				System.out.print((char) content);
			} 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}