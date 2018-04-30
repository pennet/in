package com.penchal.april30.task1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SaveText {
	public static void main(String[] args) throws Exception {

		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		*/
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
		

	}
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

	
}
