package com.ds;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
import org.apache.log4j.*;

public class  DBSrv extends HttpServlet {

		Logger logger = Logger.getLogger(com.ds.DBSrv.class);

		public void init()
		{
		try 
		{
             String filepath=getServletContext().getRealPath("/")+"WEB-INF\\classes\\log.txt";
             System.out.println(filepath);
             
			PropertyConfigurator.configure(filepath);
			logger.debug("Proj1.Mod1.init() method of DBServlet");
		} 
		catch(Exception e) {
			logger.error("Proj1.Mod1.Exception in init() :"+e.getMessage());
		}
	}

	public void doGet(HttpServletRequest req,HttpServletResponse res) {
		try {
		    String	qry = req.getParameter("query");

			ServletConfig cg=getServletConfig();
			String s1=cg.getInitParameter("driver");
			String s2=cg.getInitParameter("url");

			// DB accessing
			Class.forName(s1);
			logger.info("Proj1.Mod1.DBServlet.Driver Loaded");
			Connection con;
			con = DriverManager.getConnection(s2,"system","manager");
			logger.info("Proj1.Mod1.DBServlet.Connection Established");
			Statement st;
			st = con.createStatement();
			logger.info("Proj1.mod1.DBServlet.service.Statement Created");
			ResultSet rs;
			rs = st.executeQuery(qry);
			logger.info("Proj1.mod1.DBServlet.service.ResultSet obj Created");


			// Sending table
			PrintWriter pw;
			pw = res.getWriter();

			pw.println("<html>");
			pw.println("<body>");
			pw.println("<table border=0 width=100%>");
			pw.println("<tr>");
			pw.println("<th> Number </th>");
			pw.println("<th> Name </th>");
			pw.println("<th> Designation </th>");
			pw.println("</tr>");
		
			while(rs.next())	{
				pw.println("<tr>");	
				pw.println("<td>" + rs.getInt(1) + "</td>");
				pw.println("<td>" + rs.getString(2) + "</td>");
				pw.println("<td>" + rs.getString(3) + "</td>");
				pw.println("</tr>");	
			} //while
			rs.close();
			st.close();
			con.close();
			pw.println("</table> </body> </html>");	
			logger.debug("Proj1.Mod1.Response generated");
		} //try
		catch(Exception e) {
			logger.error("Pro1.Mod1.DB Problem");
		}
	} // doGet()
} // class