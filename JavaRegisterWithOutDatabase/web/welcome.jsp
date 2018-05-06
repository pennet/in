<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display</title>

</head>
<body>  
    <center>
<% String name =  request.getParameter("fullname");
	 %>
    
     <h1>AreaTech IT Solutions </h1>
    <h2>Welcome <span style="color: blue;text-transform: uppercase"><%=name %></span></h2>
    
    
    
    
    <p>This application is example  <a href="registration.jsp">Register</a></p>
    
    
    

</center>
</body>
</html>