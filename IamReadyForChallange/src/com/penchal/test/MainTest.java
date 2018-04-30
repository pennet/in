package com.penchal.test;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
 

public class MainTest {
 
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("Data.txt", true);
            Scanner sc=new Scanner(System.in);
            System.out.println("Add New Data : ");
            String str=sc.nextLine();
            writer.write(str);
            writer.write("\r\n");   // write new line
            System.out.println("Add New Update Data : ");
            String update =sc.nextLine();
            writer.write(update);
            writer.close();
            
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
 
}