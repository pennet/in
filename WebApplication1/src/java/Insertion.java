/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.swathi.test.JdbcConnections;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HOME
 */
@WebServlet(urlPatterns = {"/Insertion"})
public class Insertion extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String sname = request.getParameter("name");
        System.out.println("===" + sname);
        String sid = request.getParameter("id");
        System.out.println("===" + sid);
        String sbranch = request.getParameter("branch");
        System.out.println("===" + sbranch);
        String sphonenum = request.getParameter("num");
        System.out.println("===" + sphonenum);
        String saddress = request.getParameter("address");
        System.out.println("===" + saddress);
        Connection con = null;
        con = JdbcConnections.getconnect();
        int x=0;
        response.setContentType("text/html");
       
        try {
             PrintWriter out=response.getWriter();
            Statement stmt = con.createStatement();

            String q1 = "insert into student values('"+sid+"','"+sname+"','"+sbranch+"','"+sphonenum+"','"+saddress+"')";
            x=stmt.executeUpdate(q1);
            System.out.println("x value"+x);
            String url="/WebApplication1/details.jsp";
            if(x>0){
                out.println("<script>alert(\"record successfully inserted\"); window.open(\""+url + "\",\"_self\");</script>");
//                response.sendRedirect("./details.jsp");
//               
            }
            else{
                out.println("<script>alert(\"record failed\"); window.open(\""+url + "\",\"_self\");</script>");
//                response.sendRedirect("./details.jsp");
            }
         
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
