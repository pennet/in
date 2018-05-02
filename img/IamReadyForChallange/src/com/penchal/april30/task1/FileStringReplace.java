
package com.penchal.april30.task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;

public class FileStringReplace {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter File Name and Location :");
		System.out.println("----------------------");
		String filename = sc.next();

		try {
			File file = new File(filename);
			BufferedReader reader = new BufferedReader(new FileReader(file));

			String line = "", oldtext = "";

			// File content displaying--Start
			System.out.println("Existing text file content is :");
			System.out.println("------------------------------");

			try (FileInputStream fis = new FileInputStream(file)) {
				int content;
				while ((content = fis.read()) != -1) {

					// convert to char and display it
					System.out.print((char) content);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

			// File content displayed--End
			System.out.println("--------------------------------------------------------------------------");
			// read the word into the file
			Scanner scc = new Scanner(System.in);
			System.out.println("Search word in the above file content :");
			System.out.println("---------------------------------------");
			String existWord = scc.nextLine();
			System.out.println("---------------------------------------");
			System.out.println("'" + existWord + "'" + " is replace to -->");
			System.out.println("----------------------------------------");
			String replaceWord = scc.nextLine();

			while ((line = reader.readLine()) != null) {
				oldtext += line + "\r\n";
			}
			reader.close();
			// replace a word in a file
			String newtext = oldtext.replaceAll(existWord, replaceWord);

			// new update file
			FileWriter writer = new FileWriter("/home/penchal/Desktop/updateFile.txt");
			writer.write(newtext);
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("'" + existWord + "'" + " is replaced to " + "'" + replaceWord + "'"
					+ " into the file.The updated content of the file is : ");
			System.out.println(
					"------------------------------------------------------------------------------");
			System.out.println(newtext);
			writer.close();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
