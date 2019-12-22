package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class accountsjsp1_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <title>Welcome to offical website of Telangana Samagra Kutumba Survey, Administrator\n");
      out.write("            Dashboard</title>\n");
      out.write("        <link href=\"acc.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body >\n");
      out.write("        <div align=\"center\">\n");
      out.write("\n");
      out.write("            <div class=\"Content\" style=\"background-image: url(images/c6.jpg);\">\n");
      out.write("\n");
      out.write("                <div class=\"\" style=\" background-color: #727B0D; font-size: 15px; color:black;\n");
      out.write("                     height: 15px; width: 100%; margin-left: -5px; margin-top: -5px; padding: 5px; text-align: center\" >\n");
      out.write("\n");
      out.write("                    <marquee behavior=\"alternate\"><font size=\"3\">Accounts Reports</font></marquee> \n");
      out.write("                </div>\n");
      out.write("                <div class=\"babubattu_layout\">\n");
      out.write("                    <div class=\"babubattu_layout \">\n");
      out.write("                        <div class=\"babubattu_layout_row\">\n");
      out.write("                            <div style=\"width: 30%; float: left\" > \n");
      out.write("                                <div id=\"report1\" class=\"box1\">\n");
      out.write("                                    <div width=\"100%\" class=\"newsItem\">\n");
      out.write("\n");
      out.write("                                        List of Receipt</div>\n");
      out.write("                                    <div class=\"menuBg\">\n");
      out.write("                                        <div style=\"margin-left:20px; margin-top: 20px; line-height: 250%; font-size: 12px\"> \n");
      out.write("\n");
      out.write("                                            <li><a href=\"demograph_hh_report_neww.jsp\">List of cash receipt</a></li>                                                                                                    \n");
      out.write("                                            <li><a href=\"sof_pp_report_neww.jsp\">List of Bank Receipt</a></li>\n");
      out.write("                                            <li><a href=\"age_hh_report_neww.jsp\">List Of Cash Payments</a></li>\n");
      out.write("                                            <li><a href=\"age_hh_report_neww.jsp\">List of Bank Posting Cash Receipts</a></li>\n");
      out.write("                                            <li><a href=\"age_hh_report_neww.jsp\">Month-Wise Receipts</a></li>\n");
      out.write("                                          \n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div id=\"Div1\" class=\"box1\" >\n");
      out.write("                                    <div width=\"100%\" class=\"newsItem\" >\n");
      out.write("\n");
      out.write("                                        List of Payments \n");
      out.write("                                    </div> <div class=\"menuBg\">\n");
      out.write("                                        <div style=\"margin-left:20px; margin-top: 20px; line-height: 250%; font-size: 12px\"> \n");
      out.write("\n");
      out.write("                                            <!--                                            <font color=\"blue\"> ->Please Select your Conditions  to generate Exel<br>                                               \n");
      out.write("                                                                                                ->Which Fileds You need in Exel Choose and Select<br>\n");
      out.write("                                                                                                    ->Select the Status of Dynamic Report Download and Enjoy  \n");
      out.write("                                                                                                    </font>-->\n");
      out.write("\n");
      out.write("                                            <!--                                            <li>   <a href=\"dynamic_new_report.jsp\">A1.1.Dynamic Reports</a> </li> -->\n");
      out.write("                                            <!--                                                        <li>   <a href=\"dynamic_exel_new_dist_report.jsp\">A1.1 Dynamic District Exel Generation(Few Fields)</a> </li> -->\n");
      out.write("                                            <li>   <a href=\"dynamic_exel_dist_max_new_report.jsp\"> Multi Reports </a> </li> \n");
      out.write("                                            <!--                                            <li>   <a href=\"dynamic_exel_dist_max_report.jsp\">A1.1 Dynamic District Exel Generation(Few Fields)</a> </li> -->\n");
      out.write("                                            <!--                                            <li>   <a href=\"dynamic_exel_new_report.jsp\">A1.2 Dynamic Exel Generation(Selection/AllFields)</a> </li> -->\n");
      out.write("                                            <li>   <a href=\"dynamic_exel_newReport.jsp\">Draft Voucher Report)</a> </li> \n");
      out.write("                                            <!--                                            <li>   <a href=\"dynmic_dist_exel_gen.jsp\">A1.3 District Wise Subcaste Excel  Generation</a> </li> -->\n");
      out.write("                                            <li>   <a href=\"dynmic_dist_exel_newgen.jsp\">Draft Voucher Approved Report</a> </li> \n");
      out.write("                                            <!--                                            <li>   <a href=\"StatusofDynamicEXelReport.jsp\">A1.4 Status of Dynamic Reports</a> </li> -->\n");
      out.write("                                            <li>   <a href=\"dynmic_dist_exel_newgen.jsp\">Payment Voucher Approved Report</a></li>\n");
      out.write("                                            <li>   <a href=\"dynmic_dist_exel_newgen.jsp\">GSTTDS-TDS Approved Report</a> </li>  \n");
      out.write("                                            <li>   <a href=\"dynmic_dist_exel_newgen.jsp\"> Fines Report</a> </li> \n");
      out.write("                                            <!--  <li>  <a href=\"StatusOfAllReportTsks.jsp\">A1.1.Status of Tsks All Reports(Departments)</a> </li> -->\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div style=\"width: 40%; float: left\" > \n");
      out.write("\n");
      out.write("                                <div id=\"Div3\" class=\"box1\">\n");
      out.write("\n");
      out.write("                                    <div width=\"100%\" class=\"newsItem\">\n");
      out.write("                                       \n");
      out.write("                                        Receipt Vouchers </div>\n");
      out.write("                                    <div class=\"menuBg\">\n");
      out.write("                                        <div style=\"margin-left:20px; margin-top: 20px; line-height: 250%; font-size: 12px\"> \n");
      out.write("\n");
      out.write("                                            \n");
      out.write("                                            <li>  <a href=\"AbstractsGisDashboard.jsp\">Cash receipt</a> </li> \n");
      out.write("                                            <!--                                            <li>   <a href=\"Urban_Allfields.jsp\">M1.1. Ghmc wards  Wise </a> </li>-->\n");
      out.write("                                            <li> <a href=\"sri_nic_gis1.jsp\">Bank receipt</a></li>\n");
      out.write("                                            <li> <a href=\"UserCreationModule.jsp\">Cheque/DD/FC Receipts without ealisation</a></li>\n");
      out.write("                                            <li> <a href=\"UserCreationModule.jsp\">Cheque/DD/FC Receipts With Realisation</a></li>\n");
      out.write("                                            <li> <a href=\"UserCreationModule.jsp\">kanuka receipt without valuation</a></li>\n");
      out.write("                                            <li> <a href=\"UserCreationModule.jsp\">kanuka receipt with valuation</a></li>\n");
      out.write("                                            <li> <a href=\"UserCreationModule.jsp\">provision receipt</a></li>\n");
      out.write("\n");
      out.write("                                            \n");
      out.write("                                           \n");
      out.write("\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div style=\"width:100%\" >\n");
      out.write("\n");
      out.write("                                    <div id=\"Div3\" style=\"width:43%\" class=\"box2\" style=\"float: left\">\n");
      out.write("\n");
      out.write("                                        <div width=\"100%\" class=\"newsItem\">\n");
      out.write("\n");
      out.write("                                            Ledger  </div>\n");
      out.write("                                        <div class=\"menuBg\">\n");
      out.write("                                            <div style=\"margin-left:20px; margin-top: 20px; line-height: 200%; font-size: 12px\"> \n");
      out.write("\n");
      out.write("                                                <li> <a href=\"JogulambaALLFields.jsp\">Credit Ledger</a> </li>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                                <li>   <a href=\"OccupationDetails_report_neww.jsp\">Debit Ledger</a> </li>\n");
      out.write("                <!--                                                                                                 <li><a href=\"Fsc_Nizamabad.jsp\">FSC Nizambad Abstract Report</a></li>\n");
      out.write("                                                                                                                    <li><a href=\"Pension_Nizamabad.jsp\">Pension Nizambad Abstract Report</a></li>-->\n");
      out.write("                                                <!--                                                                                                               <li><a href=\"abstract_pension_report.jsp\">C1.2 Pension Abstract Report</a></li> -->\n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div style=\"width: 28%;float: right\" > \n");
      out.write("\n");
      out.write("                                <div id=\"Div2\" class=\"box1\">\n");
      out.write("                                    <div width=\"100%\" class=\"newsItem\" >\n");
      out.write("                                       malicious files\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"menuBg\">\n");
      out.write("\n");
      out.write("                                        <div style=\"margin-left:20px; margin-top: 20px; line-height: 250%; font-size: 12px\"> \n");
      out.write("\n");
      out.write("\n");
      out.write("                                            <li> <a href=\"Houseless_R_Urban_Report.jsp\">Expenditure Report</a> </li>\n");
      out.write("                                            <li> <a href=\"FamilyDonthaveBankAcc.jsp\">Status Of Funds</a> </li>\n");
      out.write("                                            <li> <a href=\"FamilyhaveBankAcc.jsp\">Bank Balance Abstract Report</a> </li>\n");
      out.write("                                            <li> <a href=\"ISL_Report.jsp\">OB Advances Report</a> </li>\n");
      out.write("                                            <li><a href=\"MaritualStatus_Report.jsp\">OB Deposit Report</a></li>\n");
      out.write("                                            <li><a href=\"yadavas_padma_fisherman_Report.jsp\">Deposit Register</a></li>\n");
      out.write("                                            <li><a href=\"singleWomen_Report.jsp\">Dynamic Expenditure Report</a></li>\n");
      out.write("                                          \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("<!--            <div class=\"footer\">\n");
      out.write("                <img src=\"images/logo.png\" align=\"left\" width=\"115px\" style=\"margin-right: 15px;\n");
      out.write("                     vertical-align: middle\" />\n");
      out.write("                Designed and Hosted by : National Informatics Centre, Telangana State Centre, Hyderabad.<br />\n");
      out.write("                Content Provided by: Panchayat Raj & Rural Development Department, Government of\n");
      out.write("                Telangana\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>-->\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
