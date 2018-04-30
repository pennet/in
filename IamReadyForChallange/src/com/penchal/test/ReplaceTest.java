package com.penchal.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;


public class ReplaceTest
    {
     public static void main(String args[])  {
     
   
    	 Scanner sc=new Scanner(System.in);
    	 System.out.println("Enter word");
    	 String originalWord=sc.nextLine();
    	 System.out.println("rEplace word");
    	 String updateWord=sc.nextLine();
    	 try
             {
             File file = new File("Bfile.txt");
             BufferedReader reader = new BufferedReader(new FileReader(file));
             String line = "", oldtext = "";
             while((line = reader.readLine()) != null)
                 {
                 oldtext += line + "\r\n";
                
             }
             reader.close();
             // replace a word in a file
             String newtext = oldtext.replaceAll(originalWord, updateWord);
            
             //To replace a line in a file
             //String newtext = oldtext.replaceAll("This is test string 20000", "blah blah blah");
            
             FileWriter writer = new FileWriter("Bfile.txt");
             writer.write(newtext);writer.close();
         }
         catch (IOException ioe)
             {
             ioe.printStackTrace();
         }
     }
}


/*

http://java.happycodings.com/core-java/code69.html*/