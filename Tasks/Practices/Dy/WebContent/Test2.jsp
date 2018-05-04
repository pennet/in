<%@ page import="myfirst.SearchLink" %>
<%

String filevar=request.getParameter("file");
String result="";
myfirst.SearchLink z=new myfirst.SearchLink();
result=z.addmultiple(filevar);
System.out.println(result);
out.println(result);

%>