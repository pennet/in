/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Retrieve extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String a=request.getParameter("eid");
        try{
            
             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("JDBC:ODBC:chandana","sa","sql@123");
            PreparedStatement pstmt=con.prepareStatement("select * from employee where eid='"+a+"'");
           
            
            
            
            
            ResultSet res=pstmt.executeQuery();
             out.print("<table border=2>");
                out.print("<tr><th>ENAME</th><th>EID</th><th>DEPT</th><th>ADDRESS</th></tr>");
            while(res.next())
            {
              out.print("<tr><td>" + res.getString(1) + "</td>");
                    out.print("<td>" + res.getString(2) + "</td>");
                    out.print("<td>" + res.getString(3) + "</td>");
                    out.print("<td>" + res.getString(4) + "</td>");  
            }
        }
        catch(Exception e)
        {
     out.println(e);
        }
        
    }

}
