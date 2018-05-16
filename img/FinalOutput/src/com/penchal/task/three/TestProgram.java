package com.penchal.task.three;
import com.penchal.task.three.TextFileModification;
public class TestProgram{
	public static void main(String[] args) {
		
		TextFileModification.modifyFile("file.txt", "Hi User", "Hi User Sir");
        
        System.out.println("Done.");
	}

}
