import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;

public class TextFileReadAndSend extends HttpServlet   
{
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  
  {
    res.setContentType("text/html");
    PrintWriter pw = res.getWriter();

    String name = req.getParameter("filename");

    BufferedReader br = new BufferedReader(new FileReader(/*"/home/penchal/Desktop/"+*/name));
		
    String str;
    while( (str = br.readLine()) != null )
    {
    	
     pw.println(str + "<BR>");
    }

    br.close();
    pw.close();
  }
}



/*


https://way2java.com/servlets/servlet-read-text-file-return-contents-client-example/

*/