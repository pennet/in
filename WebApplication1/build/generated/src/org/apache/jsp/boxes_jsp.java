package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class boxes_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <head>\n");
      out.write("    <h2 align=\"center\" style=\" color:#000080\">Account Reports</h2>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <style>\n");
      out.write("        *{ box-sizing :border-box} \n");
      out.write("        .row{\n");
      out.write("\n");
      out.write("            height:50%;\n");
      out.write("            width:100% ;\n");
      out.write("            float: left;\n");
      out.write("\n");
      out.write("        }\n");
      out.write("        .column {\n");
      out.write("            width:33% ;\n");
      out.write("            display: block;\n");
      out.write("            padding: 0 10px;\n");
      out.write("            float: left;\n");
      out.write("\n");
      out.write("        }\n");
      out.write("        .card {\n");
      out.write("            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);\n");
      out.write("            /*padding: 16px;*/\n");
      out.write("            height:auto;\n");
      out.write("            text-align: center;\n");
      out.write("            background-color: #f1f1f1;\n");
      out.write("        }\n");
      out.write("        .list{\n");
      out.write("            padding: 10px;\n");
      out.write("            padding-left: 20px;\n");
      out.write("            cursor: pointer;\n");
      out.write("            font-size: 18px;\n");
      out.write("            display: block;\n");
      out.write("            background-color: #CFD8E2;\n");
      out.write("            width: 90%;\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("            border-radius: 10%;\n");
      out.write("\n");
      out.write("        }\n");
      out.write("        .list a{\n");
      out.write("            text-decoration: none;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("    </style>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body style=\"background-color: lavenderblush\">\n");
      out.write("      <a href=\"welcome.jsp\">Back</a> \n");
      out.write("    \n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"column\">\n");
      out.write("            <div class=\"card\">\n");
      out.write("                <h3 align=\"center\" style=\"background-color: #CFD8E2;font-size: 20px \">Receipts</h3>\n");
      out.write("                <ul align=\"left\" style=\"display: block\">\n");
      out.write("                    <li class=\"list\"> <a href=\"demograph_hh_report_neww.jsp\">List of cash receipt</a></li>                                                                                                    \n");
      out.write("                    <li class=\"list\"> <a href=\"sof_pp_report_neww.jsp\">List of Bank Receipt</a></li>\n");
      out.write("                    <li class=\"list\"> <a href=\"age_hh_report_neww.jsp\">List Of Cash Payments</a></li>\n");
      out.write("                    <li class=\"list\"> <a href=\"age_hh_report_neww.jsp\">List of Bank Posting Cash Receipts</a></li>\n");
      out.write("                    <li class=\"list\"> <a href=\"age_hh_report_neww.jsp\">Month-Wise Receipts</a></li>\n");
      out.write("                    <li class=\"list\">  <a href=\"AbstractsGisDashboard.jsp\">Cash receipt</a> </li> \n");
      out.write("                    <li class=\"list\"> <a href=\"sri_nic_gis1.jsp\">Bank receipt</a></li>\n");
      out.write("                    <li class=\"list\"> <a href=\"UserCreationModule.jsp\">Cheque/DD/FC Receipts without ealisation</a></li>\n");
      out.write("                    <li class=\"list\" > <a href=\"UserCreationModule.jsp\">Cheque/DD/FC Receipts With Realisation</a></li>\n");
      out.write("                    <li class=\"list\"> <a href=\"UserCreationModule.jsp\">kanuka receipt without valuation</a></li>\n");
      out.write("                    <li class=\"list\"> <a href=\"UserCreationModule.jsp\">kanuka receipt with valuation</a></li>\n");
      out.write("                    <li class=\"list\"> <a href=\"UserCreationModule.jsp\">provision receipt</a></li>\n");
      out.write("\n");
      out.write("                </ul>\n");
      out.write("                <br>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"column\" style=\"float:right\">\n");
      out.write("            <div class=\"card\">\n");
      out.write("                <h3 align=\"center\" style=\"background-color: #CFD8E2;font-size: 20px \">Ledgers</h3> \n");
      out.write("                <ul align=\"left\" style=\"display: block\">\n");
      out.write("\n");
      out.write("                    <li class=\"list\" > <a href=\"JogulambaALLFields.jsp\">Credit Ledger</a> </li>\n");
      out.write("\n");
      out.write("                    <li class=\"list\">   <a href=\"OccupationDetails_report_neww.jsp\">Debit Ledger</a> </li>\n");
      out.write("                </ul>                                        \n");
      out.write("\n");
      out.write("                <br>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"column\" style=\"float:left\">\n");
      out.write("            <div class=\"card\">\n");
      out.write("                <h3 align=\"center\" style=\"background-color: #CFD8E2;font-size: 20px\" >Others</h3>\n");
      out.write("                <ul align=\"left\" style=\"display: block\">\n");
      out.write("                    <li class=\"list\"> <a href=\"Houseless_R_Urban_Report.jsp\">Expenditure Report</a> </li>\n");
      out.write("                    <li class=\"list\"> <a href=\"FamilyDonthaveBankAcc.jsp\">Status Of Funds</a> </li>\n");
      out.write("                    <li class=\"list\"> <a href=\"FamilyhaveBankAcc.jsp\">Bank Balance Abstract Report</a> </li>\n");
      out.write("                    <li class=\"list\"> <a href=\"ISL_Report.jsp\">OB Advances Report</a> </li>\n");
      out.write("                    <li class=\"list\"> <a href=\"MaritualStatus_Report.jsp\">OB Deposit Report</a></li>\n");
      out.write("                    <li class=\"list\"> <a href=\"yadavas_padma_fisherman_Report.jsp\">Deposit Register</a></li>\n");
      out.write("                    <li class=\"list\"> <a href=\"singleWomen_Report.jsp\">Dynamic Expenditure Report</a></li>\n");
      out.write("                </ul>                                  \n");
      out.write("                <br>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <br>\n");
      out.write("    <div class=\"row\">\n");
      out.write("            <div class=\"column\" style=\"float:left\">\n");
      out.write("            <div class=\"card\">\n");
      out.write("                <h3 align=\"center\" style=\"background-color: #CFD8E2;font-size: 20px \">Expenditure</h3> \n");
      out.write("                <ul align=\"left\" style=\"display: block\">\n");
      out.write("\n");
      out.write("                    <li class=\"list\" > <a href=\"JogulambaALLFields.jsp\">Credit Ledger</a> </li>\n");
      out.write("\n");
      out.write("                    <li class=\"list\">   <a href=\"OccupationDetails_report_neww.jsp\">Debit Ledger</a> </li>\n");
      out.write("                </ul>                                        \n");
      out.write("\n");
      out.write("                <br>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("            <div class=\"column\" style=\"float:left\">\n");
      out.write("            <div class=\"card\">\n");
      out.write("                <h3 align=\"center\" style=\"background-color: #CFD8E2;font-size: 20px \">Pay Bills</h3> \n");
      out.write("                <ul align=\"left\" style=\"display: block\">\n");
      out.write("\n");
      out.write("                    <li class=\"list\" > <a href=\"JogulambaALLFields.jsp\">Credit Ledger</a> </li>\n");
      out.write("\n");
      out.write("                    <li class=\"list\">   <a href=\"OccupationDetails_report_neww.jsp\">Debit Ledger</a> </li>\n");
      out.write("                </ul>                                        \n");
      out.write("\n");
      out.write("                <br>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("            <div class=\"column\" style=\"float:left\">\n");
      out.write("            <div class=\"card\">\n");
      out.write("                <h3 align=\"center\" style=\"background-color: #CFD8E2;font-size: 20px \">Accounts</h3> \n");
      out.write("                <ul align=\"left\" style=\"display: block\">\n");
      out.write("\n");
      out.write("                    <li class=\"list\" > <a href=\"JogulambaALLFields.jsp\">Credit Ledger</a> </li>\n");
      out.write("\n");
      out.write("                    <li class=\"list\">   <a href=\"OccupationDetails_report_neww.jsp\">Debit Ledger</a> </li>\n");
      out.write("                </ul>                                        \n");
      out.write("\n");
      out.write("                <br>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("            </body>\n");
      out.write("            </html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
