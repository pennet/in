import com.swathi.test.JdbcConnections;
import java.io.PrintWriter;
import java.sql.*; 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
   
 public class DeleteForm extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String sid = request.getParameter("studentid");
        System.out.println("===" + sid);
        Connection con = null;
        con = JdbcConnections.getconnect();
        int x=0;
        response.setContentType("text/html");
       
        try {
             PrintWriter out=response.getWriter();
            Statement stmt = con.createStatement();
            String saddress;

            String q1 = "DELETE FROM student WHERE sid ='" + sid +"'";
            x=stmt.executeUpdate(q1);
            System.out.println("x value"+x);
            String url="/WebApplication1/delete.jsp";
            if(x>0){
                out.println("<script>alert(\"record successfully deleted\"); window.open(\""+url + "\",\"_self\");</script>");
//                response.sendRedirect("./details.jsp");
//               
            }
            else{
                out.println("<script>alert(\"record failed\"); window.open(\""+url + "\",\"_self\");</script>");
//                response.sendRedirect("./details.jsp");
            }
        
 
        }
        catch(Exception e) 
        { 
            System.out.println(e.getMessage()); 
        } 
    } 
 }