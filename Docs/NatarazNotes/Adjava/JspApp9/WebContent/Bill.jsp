
<% //read form data
  String iname=request.getParameter("iname");
  float price=Float.parseFloat(request.getParameter("iprice"));
  float qty=Float.parseFloat(request.getParameter("iqty"));
  //calculate Bill Amount
  float billAmt=price*qty;
  //forward request to Discount.jsp if billAmt>50000
  if(billAmt>=50000){ %>
     <jsp:forward page="Discount.jsp">
        <jsp:param name="billAmt" value="<%=billAmt%>"/>
     </jsp:forward>
  <%}
  else{
	  %>
	 
	 Item name : <%=iname %> <br>
	 Bill amount :<%=billAmt %> <br>  
 <% }
      %>

