package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class task2_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<style>\n");
      out.write("* {\n");
      out.write("  box-sizing: border-box;\n");
      out.write("}\n");
      out.write("\n");
      out.write("body {\n");
      out.write("  font-family: Arial, Helvetica, sans-serif;\n");
      out.write("}\n");
      out.write("\n");
      out.write("/* Float four columns side by side */\n");
      out.write(".column {\n");
      out.write("  float: left;\n");
      out.write("  width: 25%;\n");
      out.write("  padding: 0 10px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("/* Remove extra left and right margins, due to padding */\n");
      out.write(".row {margin: 0 -5px;}\n");
      out.write("\n");
      out.write("/* Clear floats after the columns */\n");
      out.write(".row:after {\n");
      out.write("  content: \"\";\n");
      out.write("  display: table;\n");
      out.write("  clear: both;\n");
      out.write("}\n");
      out.write("\n");
      out.write("/* Responsive columns */\n");
      out.write("@media screen and (max-width: 600px) {\n");
      out.write("  .column {\n");
      out.write("    width: 100%;\n");
      out.write("    display: block;\n");
      out.write("    margin-bottom: 20px;\n");
      out.write("  }\n");
      out.write("}\n");
      out.write("\n");
      out.write("/* Style the counter cards */\n");
      out.write(".card {\n");
      out.write("  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);\n");
      out.write("  padding: 16px;\n");
      out.write("  text-align: center;\n");
      out.write("  background-color: #f1f1f1;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<h2>Responsive Column Cards</h2>\n");
      out.write("<p>Resize the browser window to see the effect.</p>\n");
      out.write("\n");
      out.write("<div class=\"row\">\n");
      out.write("  <div class=\"column\">\n");
      out.write("    <div class=\"card\">\n");
      out.write("      <h3>Card 1</h3>\n");
      out.write("      <p>Some text</p>\n");
      out.write("      <p>Some text</p>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <div class=\"column\">\n");
      out.write("    <div class=\"card\">\n");
      out.write("      <h3>Card 2</h3>\n");
      out.write("      <p>Some text</p>\n");
      out.write("      <p>Some text</p>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  \n");
      out.write("  <div class=\"column\">\n");
      out.write("    <div class=\"card\">\n");
      out.write("      <h3>Card 3</h3>\n");
      out.write("      <p>Some text</p>\n");
      out.write("      <p>Some text</p>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  \n");
      out.write("  <div class=\"column\">\n");
      out.write("    <div class=\"card\">\n");
      out.write("      <h3>Card 4</h3>\n");
      out.write("      <p>Some text</p>\n");
      out.write("      <p>Some text</p>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</body>\n");
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
