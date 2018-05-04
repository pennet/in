

<% //read addiotnal req param (billAmt)
  float billAmt=Float.parseFloat(request.getParameter("billAmt"));
  //calculate discount
  float discount=billAmt*0.3f;
  //get final amt
  float finalAmount=billAmt-discount;
%>
 <!-- Display the details -->
 Item name: <%=request.getParameter("iname") %> <br>
 Bill Amt: <%=billAmt %> <br>
 Discount : <%=discount %><br>
 Final Amount : <%=finalAmount %>
 
 
