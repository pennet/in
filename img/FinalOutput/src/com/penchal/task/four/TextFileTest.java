package com.penchal.task.four;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
 
public class TextFileTest
{    
    static void modifyFile(String filePath, String oldString, String newString,String createNewFile)
    {
        File fileToBeModified = new File(filePath);
        File newFileGenerate = new File(createNewFile);//not working
        String oldContent = "";
         
        BufferedReader reader = null;
         
        FileWriter writer = null;
         
        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
             
            //Reading all the lines of input text file into oldContent
             
            String line = reader.readLine();
             
            while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                 
                line = reader.readLine();
            }
             
            //Replacing oldString with newString in the oldContent
             
            String newContent = oldContent.replaceAll(oldString, newString);
             
            //Rewriting the input text file with newContent
             
            writer = new FileWriter(newFileGenerate);
           
            //writer = new FileWriter(newFileGenerate);
             
            writer.write(newContent);
            
          
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources
                 
                reader.close();
                 
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }
     
   /* public static void main(String[] args)
    {
    	
        modifyFile(args[0], args[1], args[2],args[3]);
         
        System.out.println("Done.....");
    }*/
}




	