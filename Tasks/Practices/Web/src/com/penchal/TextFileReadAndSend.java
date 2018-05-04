package com.penchal;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.util.Scanner;

public class TextFileReadAndSend extends HttpServlet   
{
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  
  {
    res.setContentType("text/html");
    PrintWriter pw = res.getWriter();

    /*String name = req.getParameter("filename");

    BufferedReader br = new BufferedReader(new FileReader("/home/penchal/Desktop/"+name));
		
    String str;
    while( (str = br.readLine()) != null )
    {
    	
     pw.println(str + "<BR>");
    }

    br.close();*/
    
    
    try {
		
		String line = "", oldText = ""; int content;
		
		/*Scanner sc = new Scanner(System.in);*/
		
		 String name = req.getParameter("filename");
		 File file = new File(name);
		 
	/*	
		//open the file on local machine
		String localMachineFile = sc.nextLine();
		File file = new File(localMachineFile);*/
		
		BufferedReader reader = new BufferedReader(new FileReader(file)); //FileReader connection open
		
	/*	// File content displaying--Start
		System.out.println("Existing text file content is :");
		System.out.println("------------------------------");*/
		try (FileInputStream fis = new FileInputStream(file)) {
			
			while ((content = fis.read()) != -1) {
				// convert to char and display it
				/*System.out.print((char) content);*/
				
				pw.println(content + "<BR>");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		// File content displayed--End
		
		
		/*//search the word 		
		System.out.println("Search word in the above file content :");
		System.out.println("---------------------------------------");
		String existWord = sc.nextLine();
		String name = req.getParameter("filename");
		//replace the word 
		System.out.println("'" + existWord + "'" + " is replace to -->");
		System.out.println("------------------------------------------");
		String replaceWord = sc.nextLine();*/
		
		String existWord = req.getParameter("existString");
		
		String replaceWord = req.getParameter("replaceString");
		
		while ((line = reader.readLine()) != null) {
			oldText += line + "\r\n";
		}
		reader.close();     //FileReader connection closed
		
		
		//business logic for replace a word in a file
		String newText = oldText.replaceAll(existWord, replaceWord);

		//uncomment the below line the replaced content will be saved on same location and same file
		FileWriter writer = new FileWriter(name);
		
	/*	// Different file name and different file location (that's your wish)
		System.out.println("Create your own file to save the replaced content --> :");
		System.out.println("------------------------------------------------------ ");
		
		
		
		String createNewTextFile = sc.nextLine();
		String createNewTextFile = req.getParameter("createNewFile");
		
		
		
		File newFileGenerate = new File(createNewTextFile);
		FileWriter writer = new FileWriter(newFileGenerate);  // FileWriter connection is open
		*/
		writer.write(newText);
		
		pw.println("'" + existWord + "'" + " is replaced to " + "'" + replaceWord + "'"
				+ " into the file.The updated content of the file is : ");
		/*System.out.println("-----------------------------------------------------------------");*/
		
		//replaced content display			
		pw.println(newText);
		
		writer.close(); // FileWriter connection is closed
		reader.close();
	} catch (IOException ioe) {
		ioe.printStackTrace();
	}
    
    
    
    
    
    pw.close();
  
  
  
  
  
  
  }
}





/*


https://way2java.com/servlets/servlet-read-text-file-return-contents-client-example/

*/