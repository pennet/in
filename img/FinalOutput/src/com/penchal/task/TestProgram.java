package com.penchal.task;
import com.penchal.task.TextFileModification;
public class TestProgram{
	public static void main(String[] args) {
		
		TextFileModification.modifyFile("file.txt", "Hi PENCHAL boss", "Hello User");
        
        System.out.println("Done.");
	}

}
