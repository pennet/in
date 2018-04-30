package com.penchal.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SaveFile {

    public static void main(String[] args) {

        try {
        	
        	Scanner sc=new Scanner(System.in);
        	System.out.println("Enter Input :");
        	System.out.println("------------");
        	String str=sc.nextLine();
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

