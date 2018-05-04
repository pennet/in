
 


<%! public String generateWishMsg(String uname){
    // get Sys Date
    java.util.Calendar cl=java.util.Calendar.getInstance();
    // get current hour of the day (24 hrs format)
    int h=cl.get(java.util.Calendar.HOUR_OF_DAY);
    // generate wish msg
    if(h<=12)
    	return "Good morning"+uname;
    else if(h<=16)
    	return "Good Afternoon:"+uname;
    else if(h<=20)
    	return "Good Evening:"+uname;
    else
    	return "Good Night:"+uname;
  }
%>
  <h1> Welcome to Jsp </h1> <br>
Date and time is : <%=new java.util.Date() %> <br>

<%
   String name=request.getParameter("uname");
%>
<br>
Wish message : <%=generateWishMsg(name) %>
  
  



