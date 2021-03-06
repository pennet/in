package tests;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ProgramTest {
	public static void main(String[] args) {
		InputStream istream;
		OutputStream ostream;
		int c;
		final int EOF = -1;
		ostream = System.out;
		try {
			
			
			File inputFile = new File("Data.txt");
			istream = new FileInputStream(inputFile);
			try {
				while ((c = istream.read()) != EOF)
					ostream.write(c);
				System.out.println("\n Data Printed ");
				
				/*start*/
				
				Scanner br=new Scanner(System.in);		
				System.out.println("Enter text into text file is :");
				System.out.println("-----------------------------");
				String inputLine = br.nextLine();
				System.out.println("Enter String to search :");
				System.out.println("-----------------------");
				String searchStr = br.nextLine();	
				System.out.println("Enter String to replace :");
				System.out.println("------------------------");
				String repStr = br.nextLine();

				System.out.println("After Replacing :");
				System.out.println("----------------");
				fileSave(inputLine, searchStr, repStr);
				
/*				end*/
				
				
			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			} finally {
				try {
					istream.close();
					ostream.close();
			} catch (IOException e) {
					System.out.println("File did not close");
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	/*start*/
	
	private static void fileSave(String inputLine, String searchStr, String repStr)

	{
		Pattern p = Pattern.compile(searchStr);
		Matcher matcher = p.matcher(inputLine);
		boolean found = matcher.find();
		StringBuffer outputStrbuf = new StringBuffer();
		while (found) {
			matcher.appendReplacement(outputStrbuf, repStr);
			found = matcher.find();
		}
		matcher.appendTail(outputStrbuf);	
		System.out.println("'"+outputStrbuf.toString()+"'" + "\n");
	}

	
	/*END*/
	
}


/*
 
Reference Links:

https://www.w3resource.com/java-tutorial/reading-the-file.php

*
*/