//HeaderSrv.java
package com.nt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HeaderSrv extends HttpServlet {
	
  public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
	  //general settings
	  PrintWriter pw=res.getWriter();
	  //set response content type
	  res.setContentType("text/html");
	  //place header content
	  pw.println("<marquee><h1>The  H I N D U </h1></marquee>");
	  //do not close stream
	}//doGet(-,-)
  
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
	   doGet(req,res);
	}

}
