<!--<meta http-equiv="refresh" content="30;url=\fasendm\fasmenu\fasmenu.jsp">  -->
<meta http-equiv="page-enter" content="revealtrans(duration=0.5,transition=23)">
<meta http-equiv="pragma" content="no-cache">
<%@ page import="java.sql.*,faspackage.FasDebug,faspackage.Fasconnect,faspackage.Indian,faspackage.ConnectionHolder,java.text.SimpleDateFormat"%>
<%!
    ResultSet rs = null, rs1 = null, rspayee = null;
    ConnectionHolder holder = null;
    Connection con = null;
    FasDebug Debug = null;
    Statement stmt = null;
    PreparedStatement stmt1 = null;
    CallableStatement cstmt = null;
    String bcode = null, mcode = null, mscode = null, micode = null, gcode = null, role = null;
    String scode = null, dcode = null, sdcode = null, userid = null, userrole = null, rolename = null;
    String statename = null, qry1 = null, distname = null, status = "", status_role = "", btype = "";
    SimpleDateFormat df = null;
    int rCount1 = 0, cnt1 = 0;
%>
<%

    try {
        holder = (ConnectionHolder) session.getValue("fas.connection");
        if (holder == null) {
            Debug.println("Holder is null");
        } else {
            con = holder.getConnection();
            if (con == null) {
                Debug.println("Connection Object is null");
            }
        }
        userid = holder.getUser();
        statename = holder.getStateName();
        scode = holder.getState();
        dcode = holder.getDistrict();
        distname = holder.getDistrictName();
        userrole = holder.getRole();
        role = holder.getRole().trim();
        rolename = holder.getRolename().trim();
        if (Integer.parseInt(scode) > 80 && Integer.parseInt(scode) != 83) {%>
<script>
    window.open("/fasendm/fasmenu/fasmenusu.jsp", '_self');
</script>
<%}%>
<html>
    <style type="text/css">
        h1 {text-outline :2px 2px #FF0000;}
    </style>
    <style type="text/css">._css3m{display:none}</style>
    <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/css/headerfooter.css">
    <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/css/style1.css">
</head>
<head>
    <title>
        Financial Accounting System (FAS)
    </title>

    <style>
        @media (min-width:600px) and  (max-width: 800px)  {                        
            .menu ul li a {
                display: block; 
                padding: 9px 3px;
                color: #FFFFFF; 
                text-decoration: none;
                font-family: 'Times New Roman';
                font-size: 18px;
                z-index: 1;


            }                        
        }    
        @media (min-width: 801px) and  (max-width: 1000px)  {
            .responsive{
                padding-left: 2%;
            }
        }
        @media (min-width: 801px) and  (max-width: 1000px)  {                       
            .menu ul li a {
                display: block; 
                padding: 9px 13px;
                color: #FFFFFF; 
                text-decoration: none;
                font-family: 'Times New Roman';
                font-size: 18px;
                z-index: 1;


            }

        }
        @media (min-width:1001px) and  (max-width: 1200px)  {        
            .responsive{
                padding-left: 2%;
            }
        }
        @media (min-width: 1001px) and  (max-width: 1200px)  {                       
            .menu ul li a {
                display: block; 
                padding: 9px 17px;
                color: #FFFFFF; 
                text-decoration: none;
                font-family: 'Times New Roman';
                font-size: 18px;
                z-index: 1;


            }

        }  
        @media (min-width:1200px) and  (max-width: 1600px)  {        
            .responsive{
                padding-left: 17%;
            }
        }
        @media (min-height: 1200px) and  (max-height: 2000px){
            .responsive{
                width:100%;
                height:48%;
                padding-top: 35%;
            }
        }
        @media (min-height: 900px) and  (max-height: 1199px){
            .responsive{
                width:100%;
                height:48%;
                padding-top: 35%;
            }
        }

        @media (min-height: 800px) and  (max-height: 899px){
            .responsive{
                width:100%;
                height:50%;
                padding-top: 30%;
            }
        }
        @media (min-height: 700px) and  (max-height: 799px){
            .responsive{
                width:85%;
                height:48%;
                padding-top: 25%;
            }
        }
        @media (min-height: 600px) and  (max-height: 699px){
            .responsive{
                width:65%;
                height:45%;
                padding-top: 25%;
            }
        }

        @media (min-height: 550px) and  (max-height: 599px){
            .responsive{
                width:60%;
                height:40%;
                padding-top: 20%;
            }
        }
        @media (min-height: 450px) and  (max-height: 549px){
            .responsive{
                width:50%;
                height:40%;
                padding-top: 20%;
            }
        }

        @media (min-height: 350px) and  (max-height: 449px){
            .responsive{
                width:30%;
                height:20%;
                padding-top: 18%;
            }
        }
        @media (min-height: 250px) and  (max-height: 349px){
            .responsive{
                width:25%;
                height:15%;
                padding-top: 15%;
            }
        }
    </style>
</head>
<style>
    fieldset {width: 150px; border: 1px solid #000;}</style>
<body bgcolor=lavenderblush oncontextmenu="return false" onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="">
    <br>
<center>
    <strong><font color = maroon size=2><%=statename%> -- <%=distname%></font></strong>
</center>
<center><strong><font color = darkgreen size=2> FAS &nbsp; version 1.0</strong></center>
<center><font size=1 color=navy><b>CURRENT USER LOGGED ON    --    </b></font>
    <font color=darkgreen size=2><b><%=rolename%></b></font></center>

<div class="menu"> 
    <ul>
        <li><a href="#">Masters</a>
            <ul>
                <li><a href="#">Initialisation</a>
                    <ul>
                        <li><a href="/fasendm/jsp/FasBankBranch.jsp">Bank Branch</a></li> 
                        <li><a href="/fasendm/jsp/FasPayee.jsp">Payee </a></li> 
                    </ul>
                </li>
                <li><a href="/fasendm/jsp/faschangepwd.jsp?menutype=normal">Change Password</a></li> 
                <li><a href="#">Opening Balance</a>
                    <ul>
                        <li><a href="/fasendm/jsp/FasCashMaster.jsp">Cash-In-Hand</a></li> 
                        <li><a href="/fasendm/jsp/FasBankBalMaster.jsp">Cash At Bank</a></li> 
                        <li><a href="/fasendm/jsp/FasObAdvEntry.jsp">OB of Advances</a></li> 
                        <li><a href="/fasendm/jsp/FasObDeposits.jsp">OB of Deposits</a></li> 
                    </ul>
                </li>
            </ul>
        </li> 
        <li><a href="#">Accounts</a>
            <ul>
                <li><a href="#">Receipts</a>
                    <ul>
                        <li><a href="#">Kanuka Receipts</a>
                            <ul>
                                <li><a href="/fasendm/jsp/FasKanukaEntry.jsp">Entry</a></li> 
                                <li><a href="#">Valuator Details</a>
                                    <ul>
                                        <li><a href="/fasendm/jsp/FasKanukaValuation_Sel.jsp?mod=New">Entry</a></li> 
                                        <li><a href="/fasendm/jsp/FasKanukaValuation_Sel.jsp?mod=Modify">Modify</a></li> 
                                        <li><a href="/fasendm/jsp/FasKanukaValuation_Sel.jsp?mod=Deletion">Delete</a></li> 
                                    </ul></li> 
                            </ul>
                        </li> 
                        <li><a href="/fasendm/jsp/FasProvisionsEntry.jsp">Provisions</a></li> 
                        <li><a href="#">Cash Receipts</a>
                            <ul>
                                <li><a href="/fasendm/jsp/FasDaybook_receipts_cash.jsp">Single Receipt</a></li> 
                                <li><a href="/fasendm/jsp/FasDaybook_grpreceipts_sel_cash.jsp">Group Receipt</a></li> 
                            </ul>
                        </li> 
                        <li><a href="#">Bank Receipts</a>
                            <ul>
                                <li><a href="/fasendm/jsp/FasDaybook_receipts.jsp">Single Receipt</a></li> 
                                <li><a href="/fasendm/jsp/FasDaybook_grpreceipts_sel.jsp">Group Receipt</a></li> 
                            </ul></li> 
                        <li><a href="#">Bank Posting</a>
                            <ul>
                                <li><a href="/fasendm/jsp/BankPostingReceipts_Sel.jsp">Entry</a></li> 
                                <li><a href="/fasendm/jsp/FasBankPostingUpdSel.jsp">Update</a></li> 
                            </ul>
                        </li> 
                        <li><a href="#">Cheque/DD/FC</a>
                            <ul>
                                <li><a href="/fasendm/jsp/FasChequeDDEntry.jsp">Entry</a></li> 
                                <li><a href="#">Realisation</a>
                                    <ul>
                                        <li><a href="/fasendm/jsp/FasChequeDDReal_Sel.jsp?mod=New">Entry</a></li> 
                                        <li><a href="/fasendm/jsp/FasChequeDDReal_Sel.jsp?mod=Modify">Modify</a></li> 
                                        <li><a href="/fasendm/jsp/FasChequeDDReal_Sel.jsp?mod=Deletion">Delete</a></li> 
                                    </ul>
                                </li> 
                            </ul></li> 
                        <li><a href="#">FDR Maturity</a>
                            <ul>
                                <li><a href="/fasendm/jsp/FDRCash_receipts_sel.jsp">FDR Maturity Cash Receipt Entry</a></li> 
                                <li><a href="/fasendm/jsp/FDRBank_receipts_sel.jsp">FDR Maturity Bank Receipt Entry</a></li> 
                                <li><a href="/fasendm/jsp/FasFdrBankPosting.jsp">FDR Bank Posting</a></li> 
                            </ul></li> 
                    </ul>
                </li> 
                <li><a href="#">Payments </a>

                    <ul>
                        <li><a href="#">Draft Voucher</a>
                            <ul>
                                <li><a href="/fasendm/jsp/Fasdraftvoucher_single.jsp">Entry</a></li> 
                                <li><a href="/fasendm/jsp/Fasdraftvoucher_singleReport.jsp">Pending Voucher for Approval</a></li> 
                            </ul>
                        </li> 
                        <!--                        <li><a href="/fasendm/jsp/FasDaybook_Payment.jsp">Direct Payment Voucher</a></li> 
                                                <li><a href="/fasendm/jsp/FasDaybook_Payment.jsp">with Tax Particulars</a></li>-->

                        <!--                        <li><a href="/fasendm/jsp/FasDaybook_voucherentry_new.jsp">New Payment Format</a> 
                                                <li><a href="/fasendm/jsp/FasDaybook_voucherentry_newrcm.jsp">RCM Format</a> -->
                        <li><a href="/fasendm/jsp/FasDaybook_voucherentry.jsp">Payment Voucher</a> 
                        <li><a href="/fasendm/jsp/FasDaybook_rcm_voucherentry.jsp">RCM Voucher</a> 
                        <li><a href="/fasendm/jsp/FasDaybook_grppayments_sel.jsp">Group Payments</a></li>
                        <!--<li><a href="/fasendm/jsp/FasDaybook_Payment_rcm.jsp">RCM Payment voucher</a> </li>-->

                    </ul>


                    <!--                        <li><a href="/fasendm/jsp/FasDaybook_Payment.jsp">with Tax Particulars</a></li> 
                                            <li><a href="/fasendm/jsp/FasDaybook_Payment_rcm.jsp">with RCM</a></li> -->
                    <!--                      <li><a href="/fasendm/jsp/FasDaybook_Payment.jsp">with WorkBills</a></li> 
                                          <li><a href="/fasendm/jsp/FasDaybook_Payment.jsp">Salary Voucher</a></li> 
                                          <li><a href="#">Voucher with Tax Remittances</a> 
                                              <ul><li><a href="/fasendm/jsp/Fasrcmvoucher_partA.jsp">PART-A sarath</a></li> 
                                                  <li><a href="/fasendm/jsp/Fasrcmvoucher_partB.jsp">PART B</a></li> 
                                              </ul>
                                          </li>
                                          <li><a href="/fasendm/jsp/rcmvoucher.jsp">Tax Remittances</a> 
                    <li><a href="/fasendm/jsp/FasDaybook_rcm_payment.jsp">RCM Payment voucher</a> -->

                </li> 
                <li><a href="#">Adjustments</a>
                    <ul>
                        <li><a href="/fasendm/jsp/FasDaybookAdjustments.jsp">Fresh Advance</a></li> 
                        <li><a href="/fasendm/jsp/FasDaybookOBAdjustments.jsp">OB of Advance</a></li> 
                        <li><a href="/fasendm/jsp/FasObadvSettementEntry.jsp">OB of Deposits</a></li> 
                        <li><a href="/fasendm/jsp/WithHoldSettementEntry.jsp">Withholds Settlement</a></li> 
                    </ul>
                </li> 
                <li><a href="/fasendm/jsp/FasPerCashBook_Rep.jsp">CashBook </a></li>
                <li><a href="#">Work Bill Entry</a>
                    <ul>
                        <li><a href="/fasendm/jsp/FasWorkBill_New.jsp">New Work</a></li> 
                        <li><a href="/fasendm/jsp/FasWorkBill_ExistSel.jsp">Existing Work</a></li> 
                        <li><a href="/fasendm/jsp/FasWorkBill_UpdSel.jsp">Updation Work</a></li> 
                    </ul>
                </li> 
                <li><a href="/fasendm/jsp/FasBankTransfer.jsp">Bank To Bank Transfer</a></li>
            </ul>
        </li>    

        <li><a href="#">Accounts Reports</a>
            <ul>
                <li><a href="#">CheckLists</a>
                    <ul>
                        <li><a href="#">List of Receipts</a>
                            <ul>
                                <li><a href="/fasendm/jsp/FasDaybookCashReceipts_Rep_Sel.jsp">List of Cash Receipts</a></li> 
                                <li><a href="/fasendm/jsp/FasDaybookReceipts_Rep_Sel.jsp">List of Bank Receipts</a></li> 
                                <li><a href="/fasendm/jsp/FasDaybookPayments_Rep_Sel.jsp">List Of Cash Payments</a></li> 
                                <li><a href="/fasendm/jsp/FasDaybookBankPostCashReceipts_Rep_Sel.jsp">List of Bank Posting Cash Receipts</a></li> 
                                <li><a href="/fasendm/jsp/ReceiptsMonthWise.jsp">Month-Wise Receipts</a></li> 
                            </ul>
                        </li> 
                        <li><a href="#">List of Payments</a>
                            <ul>
                                <li><a href="/fasendm/jsp/AllVouvcherPayment_selReport.jsp">Multi Reports</a></li> 
                                <li><a href="/fasendm/jsp/Fasdraftvoucher_singleReports.jsp">Draft Voucher Report</a></li> 
                                <li><a href="/fasendm/jsp/SingleVoucherApprovedReport.jsp">Draft Voucher Approved Report</a></li> 
                                <li><a href="/fasendm/jsp/PaymentVoucherApprovedReport.jsp">Payment Voucher Approved Report</a></li> 
                                <li><a href="/fasendm/jsp/Gst_tds_PaymentVoucherApprovedReport.jsp">GSTTDS-TDS  Approved Report</a></li> 
                                <li><a href="/fasendm/jsp/Fines_PaymentVoucherApprovedReport.jsp">Fines Report</a></li> 
                            </ul>
                        </li> 
                    </ul>
                </li>
                <li><a href="#">Receipt Vouchers</a>
                    <ul>
                        <li><a href="/fasendm/jsp/FasReceiptVoucherCash_Sel.jsp">Cash receipt</a></li> 
                        <li><a href="/fasendm/jsp/FasReceiptVoucher_Sel.jsp">Bank receipt</a></li> 
                        <li><a href="/fasendm/jsp/FasChqDDEntry_VoucherSel.jsp">Cheque/DD/FC Receipts without ealisation</a></li> 
                        <li><a href="/fasendm/jsp/FasChqDDReal_VoucherSel.jsp">Cheque/DD/FC Receipts With Realisation</a></li> 
                        <li><a href="/fasendm/jsp/FasKanukaEntry_VoucherSel.jsp">kanuka receipt without valuation</a></li> 
                        <li><a href="/fasendm/jsp/FasKanukaVal_VoucherSel.jsp">kanuka receipt with valuation</a></li> 
                        <li><a href="/fasendm/jsp/FasProv_VoucherSel.jsp">provision receipt</a></li> 
                    </ul>
                </li> 
                <li><a href="#">Payment Vouchers</a>
                    <ul>
                        <li><a href="/fasendm/jsp/FasPaymentVoucher_Sel.jsp">Payment Voucher</a></li> 
                        <li><a href="/fasendm/jsp/FasPaymentVoucher_Sel_new.jsp">New Payment Voucher receipt</a></li> 
                    </ul>
                </li> 
                <li><a href="#">Ledger</a>
                    <ul>
                        <li><a href="/fasendm/jsp/FasLedger_RepSel.jsp?vtype=D">Credit Ledger</a></li> 
                        <li><a href="/fasendm/jsp/FasLedger_RepSel.jsp?vtype=C">Debit Ledger</a></li> 
                    </ul>
                </li> 
                <li><a href="/fasendm/jsp/BudgetBalView.jsp">Expenditure Report</a></li> 
                <li><a href="/fasendm/jsp/StatusOfFunds.jsp">Status Of Funds</a></li> 
                <li><a href="/fasendm/jsp/BankBalanceRep.jsp">Bank Balance Abstract Report</a></li> 
                <li><a href="/fasendm/jsp/FasOutstandingAdv_Report.jsp">OB Advances Report</a></li> 
                <li><a href="/fasendm/jsp/FasObDepositReport.jsp">OB Deposit Report</a></li> 
                <li><a href="/fasendm/jsp/Deposit_Register.jsp">Deposit Register</a></li> 
                <li><a href="/fasendm/jsp/Fas_Dynamic_Report.jsp">Dynamic Expenditure Report</a></li> 

            </ul>
        </li>
        <!--        <li><a href="#">Pay Bill</a>
                    <ul>
                        <li><a href="<%=request.getContextPath()%>/payact.do?mode=DraftPayBill">Draft Pay Bill</a></li>
                        <li><a href="<%=request.getContextPath()%>/payact.do?mode=PayBillProcess">Pay Bill Process</a></li> 
                    </ul>
                </li>
                <li><a href="#">Reports</a> 
                    <ul>
                        <li><a href="<%=request.getContextPath()%>/PayRep.do?mode=EmpSalReg">Monthly Salary Register</a></li>
                        <li><a href="<%=request.getContextPath()%>/payact.do?mode=Payslip">Monthly Pay Slip</a></li> 
                        <li><a href="<%=request.getContextPath()%>/PayRep.do?mode=EmpPayRep">Employee Pay Reports</a></li>
                    </ul>
                </li>-->

        <li><a href="<%=request.getContextPath()%>/logout.do">Logout</a></li>
    </ul>

</div>



<br><br><br><br><br><br>

<%
    try {
        //to cal date
        df = new SimpleDateFormat("dd-MM-yyyy");
        Date systemdate = new Date(System.currentTimeMillis());
        String sysdate = df.format(systemdate) + "";
        String mycurrdate = sysdate;

        String currfinyear = "2019-2020";
        status = "";
        status_role = "";
        btype = "";
        stmt1 = con.prepareStatement("select stat.status_desc,link.role_id,link.budget_type from fbudget_status_link link,fbudget_status stat WITH (NOLOCK),fas_roles role WITH (NOLOCK) where link.state_code=? and link.district_code=? and link.financial_year=? and link.role_id=role.role_id and role.role_categ=stat.role_categ and role.role_seq=stat.role_seq and link.budget_type=stat.budget_type");
        stmt1.setString(1, scode);
        stmt1.setString(2, dcode);
        stmt1.setString(3, currfinyear);
        rs1 = stmt1.executeQuery();
        while (rs1.next()) {
            status = rs1.getString("status_desc");
            status_role = rs1.getString("role_id");
            btype = rs1.getString("budget_type");

        }
        if (status_role.equals("15") && (btype.equals("FR") || btype.equals("RB"))) {
            stmt1 = con.prepareStatement("select * from fbudget_role_assign where state_code=? and district_code=? and financial_year=? and budget_type=?");
            stmt1.setString(1, scode);
            stmt1.setString(2, dcode);
            stmt1.setString(3, currfinyear);
            stmt1.setString(4, btype);
            rs1 = stmt1.executeQuery();
            cnt1 = 0;
            while (rs1.next()) {
                cnt1++;
            }
            if (cnt1 == 0) {
                if (btype.equals("FR")) {
                    status = "The Budget Estimation for this financial year is finalized by the Executive    Officer and sent to the Head office";
                } else if (btype.equals("RB")) {
                    status = "The Revised Budget Estimation for this financial year is fianalised by the Executive Officer of the concerned temple and sent to the Head Office";
                }

            }
        }


%>
<!--<marquee direction="left" behavior="alternate" ><font color=green size=3><%=status%></font></marquee>-->

<%} catch (Exception e) {
            Debug.println("It Seems There Is Some Temporary Problem,Please Try Again");
        }

    } catch (Exception e) {
        Debug.println("It Seems There Is Some Temporary Problem,Please Try Again");
    } finally {
        try {

            if (rspayee != null) {
                rspayee.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (cstmt != null) {
                cstmt.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                Debug.println("con is closed");
                con.close();
            }
        } catch (Exception e) {
            Debug.println("It Seems There Is Some Temporary Problem,Please Try Again");
        }
    }
%>
<br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br>
<table width=100% border=1 bgcolor=#94C9C9 bordercolor=#0080C0>
    <tr><td><center><font color=black >National Informatics Centre , Andhra Pradesh  State Unit </font></td></tr>
</table></center>
</body>
</HTML>


