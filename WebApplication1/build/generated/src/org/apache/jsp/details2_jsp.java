package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class details2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>  \n");
      out.write("<head>  \n");
      out.write("<meta charset=\"ISO-8859-1\">  \n");
      out.write("<title>Insert title here</title>  \n");
      out.write("</head>  \n");
      out.write("<body>  \n");
      out.write("  \n");
      out.write("<h1>Add New Employee</h1>  \n");
      out.write("<form action=\"./welcome.jsp\" method=\"post\">  \n");
      out.write("<table>  \n");
      out.write("<tr><td>Name:</td><td><input type=\"text\" name=\"name\"/></td></tr>  \n");
      out.write("<tr><td>Password:</td><td><input type=\"password\" name=\"password\"/></td></tr>  \n");
      out.write("<tr><td>Email:</td><td><input type=\"email\" name=\"email\"/></td></tr>  \n");
      out.write("<tr><td>Country:</td><td>  \n");
      out.write("<select name=\"country\" style=\"width:150px\">  \n");
      out.write("<option>India</option>  \n");
      out.write("<option>USA</option>  \n");
      out.write("<option>UK</option>  \n");
      out.write("<option>Other</option>  \n");
      out.write("</select>  \n");
      out.write("</td></tr>  \n");
      out.write("<tr><td colspan=\"2\"><input type=\"submit\" value=\"Save Employee\"/></td></tr>  \n");
      out.write("</table>  \n");
      out.write("</form>  \n");
      out.write("  \n");
      out.write("<br/>  \n");
      out.write("<a href=\"ViewServlet\">view employees</a>  \n");
      out.write("  \n");
      out.write("</body>  \n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
