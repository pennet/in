package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sathya.dao.EmpDao;
import com.sathya.dao.EmpDaoImpl;
import com.sathya.entity.Employee;


public class PaginationServlet extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter   out  =  response.getWriter();
		int   pageNo= Integer.parseInt(request.getParameter("pageNo"));
		int   startIndex = pageNo*3 - 3;
		EmpDao    dao = new   EmpDaoImpl();
		List    list = dao.readEmps(startIndex);
		out.println("<center><table  border=2>");
		out.println("<tr>");
		out.println("<b><th>EMPNO</th> <th>ENAME</th>  <th>SAL</th>  <th>DEPTNO</th> </b>");
		out.println("</tr>");
		Iterator   it = list.iterator();
		while(it.hasNext())
		{
			Employee   e =(Employee)it.next();
			out.println("<tr>");
			out.println("<td>" + e.getEmpNo() + "</td>");
			out.println("<td>" + e.getEmpName() + "</td>");
			out.println("<td>" + e.getEmpSal() + "</td>");
			out.println("<td>" + e.getDeptNumber() + "</td>");
			out.println("</tr>");
		} // end  of  while  loop
		out.println("</table>");
		
		long   noOfRows = dao.noOfRows();
		long  noOfPages = noOfRows/3;
		if(noOfRows % 3 != 0)
		{
			noOfPages++;
		}
		for(int  i=1;  i<=noOfPages;  i++)
		{
			out.println("<b>");
			out.println("<a   href=./pagination?pageNo="+i+">" +  i  + "</a>");
			out.println("&nbsp;&nbsp;&nbsp;&nbsp;");
			out.println("</b>");
		}
		out.println("</center>");
		out.close();
	}
}
