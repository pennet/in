package tests;

import java.util.regex.*;
import java.io.*;

public class FindReplace {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter Line to search and replace");
		
		String inputLine = br.readLine();
		System.out.println("Enter String to search ");
		String searchStr = br.readLine();
		System.out.println("Enter String to replace");
		String repStr = br.readLine();

		System.out.println("Using Method1\n");
		method1(inputLine, searchStr, repStr);
		/*
		 * 
		 * System.out.println("Using Method2\n"); method2(inputLine, searchStr, repStr);
		 * System.out.println("Using Method3\n"); method3(inputLine, searchStr, repStr);
		 * 
		 */

	}

	// Using Matcher class and appendReplacement method

	private static void method1(String inputLine, String searchStr, String repStr)

	{
		Pattern p = Pattern.compile(searchStr);
		Matcher matcher = p.matcher(inputLine);
		boolean found = matcher.find();
		StringBuffer outputStrbuf = new StringBuffer();
		while (found) {
			matcher.appendReplacement(outputStrbuf, repStr);
			found = matcher.find();
		}
		matcher.appendTail(outputStrbuf); // Last portion after the last occurrence of the search string , is appended
											// to the string buffer.
		System.out.println(outputStrbuf.toString() + "\n");
	}

	// Using replaceAll() method of String Calss

	/*private static void method2(String inputLine, String searchStr, String repStr)

	{

		String outputLine = inputLine.replaceAll(searchStr, repStr);
		System.out.println(outputLine + "\n");
	}

	// Using replaceAll() method of Matcher Calss

	private static void method3(String inputLine, String searchStr, String repStr)

	{
		Pattern p = Pattern.compile(searchStr);
		Matcher matcher = p.matcher(inputLine);
		String output = matcher.replaceAll(repStr);
		System.out.println(output + "\n");
		// System.out.println(outputStrbuf.toString());
	}*/

}