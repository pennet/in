package tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileSave {

    public static void main(String[] args) {

        try {
        	
        	Scanner sc=new Scanner(System.in);
        	System.out.println("Enter Input :");
        	System.out.println("------------");
        	String str=sc.nextLine();
        	
        	/*
            String str = "RAMU IS GOOD BOY ";
            */
            
            File newTextFile = new File("file.txt");
             
            System.out.println("Input Data Saved Into file.");
            FileWriter fw = new FileWriter(newTextFile);
            fw.write(str);
            fw.close();

        } catch (IOException iox) {
            //do stuff with exception
            iox.printStackTrace();
        }
    }
}






/*

https://stackoverflow.com/questions/1053467/how-do-i-save-a-string-to-a-text-file-using-java

*/