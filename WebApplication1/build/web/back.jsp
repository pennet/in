<html>
    <head>
    <h2 align="center" style=" color:#000080">Account Reports</h2>



    <style>
        *{ box-sizing :border-box} 
        .row{

            height:50%;
            width:100% ;
            float: left;

        }
        .column {
            width:33% ;
            display: block;
            padding: 0 10px;
            float: left;

        }
        .card {
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
            /*padding: 16px;*/
            height:auto;
            text-align: center;
            background-color: #f1f1f1;
        }
        .list{
            padding: 10px;
            padding-left: 20px;
            cursor: pointer;
            font-size: 18px;
            display: block;
            background-color: #CFD8E2;
            width: 90%;
            margin-bottom: 10px;
            border-radius: 10%;

        }
        .list a{
            text-decoration: none;
        }
        .box_card {
            display: flex;
            flex-direction: column;
            border: 2px solid #000000;
        }
        .box_card .card ul {
            display: flex;
            flex-direction: column;
            padding-bottom: 1rem;
        }
        .box_card .card {
            min-height: 314px;
        }
/*        .sixbox {
            background: lavenderblush url("./img/indian-rupee.png") no-repeat;
            background-size: 100% 100%;
            opacity: 0.9;
        }*/
        .row_bottom {
            margin: 0 0 2rem 0;
            margin-bottom: 10px
        }
    </style>

</head>

<body class="sixbox">
    <a href="welcome.jsp"><img src="./img/back img.png" heigt="3%" width="3%"></a>
    <div class="box_card">
        <div class="row row_top">
            <div class="column">
                <div class="card">
                    <h3 align="center" style="background-color: #CFD8E2;font-size: 20px ">Receipts</h3>
                    <ul align="left">
                        <li class="list"> <a href="demograph_hh_report_neww.jsp">List of cash receipt</a></li>                                                                                                    
                        <li class="list"> <a href="sof_pp_report_neww.jsp">List of Bank Receipt</a></li>
                        <!--<li class="list"> <a href="age_hh_report_neww.jsp">List Of Cash Payments</a></li>-->
                        <li class="list"> <a href="age_hh_report_neww.jsp">List of Bank Posting Cash Receipts</a></li>
                        <!--<li class="list"> <a href="age_hh_report_neww.jsp">Month-Wise Receipts</a></li>-->
                        <li class="list">  <a href="AbstractsGisDashboard.jsp">Cash receipt</a> </li> 
                        <li class="list"> <a href="sri_nic_gis1.jsp">Bank receipt</a></li>
    <!--                    <li class="list"> <a href="UserCreationModule.jsp">Cheque/DD/FC Receipts without ealisation</a></li>
                        <li class="list" > <a href="UserCreationModule.jsp">Cheque/DD/FC Receipts With Realisation</a></li>
                        <li class="list"> <a href="UserCreationModule.jsp">kanuka receipt without valuation</a></li>
                        <li class="list"> <a href="UserCreationModule.jsp">kanuka receipt with valuation</a></li>
                        <li class="list"> <a href="UserCreationModule.jsp">provision receipt</a></li>-->
                    </ul>
                </div>
            </div>

        <div class="column" style="float:right">
            <div class="card">
                <h3 align="center" style="background-color: #CFD8E2;font-size: 20px ">Ledgers</h3> 
                <ul align="left">
                    <li class="list" > <a href="JogulambaALLFields.jsp">Credit Ledger</a> </li>
                    <li class="list">   <a href="OccupationDetails_report_neww.jsp">Debit Ledger</a> </li>
                </ul>                                        
            </div>
        </div>

        <div class="column" style="float:left">
            <div class="card">
                <h3 align="center" style="background-color: #CFD8E2;font-size: 20px" >Others</h3>
                <ul align="left">
                    <li class="list"> <a href="Houseless_R_Urban_Report.jsp">Expenditure Report</a> </li>
                    <li class="list"> <a href="FamilyDonthaveBankAcc.jsp">Status Of Funds</a> </li>
                    <li class="list"> <a href="FamilyhaveBankAcc.jsp">Bank Balance Abstract Report</a> </li>
                    <!--<li class="list"> <a href="ISL_Report.jsp">OB Advances Report</a> </li>-->
                    <!--<li class="list"> <a href="MaritualStatus_Report.jsp">OB Deposit Report</a></li>-->
                    <li class="list"> <a href="yadavas_padma_fisherman_Report.jsp">Deposit Register</a></li>
                    <li class="list"> <a href="singleWomen_Report.jsp">Dynamic Expenditure Report</a></li>
                </ul>                                  
            </div>
        </div>
    </div>
    <div class="row row_bottom">
            <div class="column" style="float:left">
            <div class="card">
                <h3 align="center" style="background-color: #CFD8E2;font-size: 20px ">Expenditure</h3> 
                <ul align="left">
                    <li class="list" > <a href="JogulambaALLFields.jsp">Credit Ledger</a> </li>
                    <li class="list">   <a href="OccupationDetails_report_neww.jsp">Debit Ledger</a> </li>
                </ul>                                        
            </div>
        </div>
            <div class="column" style="float:left">
            <div class="card">
                <h3 align="center" style="background-color: #CFD8E2;font-size: 20px ">Pay Bills</h3> 
                <ul align="left">
                    <li class="list" > <a href="JogulambaALLFields.jsp">Credit Ledger</a> </li>
                    <li class="list">   <a href="OccupationDetails_report_neww.jsp">Debit Ledger</a> </li>
                </ul>                                        
                <br>
            </div>
        </div>
            <div class="column" style="float:left">
            <div class="card">
                <h3 align="center" style="background-color: #CFD8E2;font-size: 20px ">Accounts</h3> 
                <ul align="left">
                    <li class="list" > <a href="JogulambaALLFields.jsp">Credit Ledger</a> </li>
                    <li class="list">   <a href="OccupationDetails_report_neww.jsp">Debit Ledger</a> </li>
                </ul>                                        
                <br>
            </div>
        </div>
    </div>
      </div>
    <!--<img src="rupee1.jpg" alt="rupee" style="width:100%;">-->
            </body>
            </html>



