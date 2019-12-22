<%-- 
    Document   : welcome
    Created on : Dec 11, 2019, 1:14:19 PM
    Author     : HOME
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to <%= request.getParameter("uname") %></h1>
    <li><a href="task2.jsp">task2</a></li>
    <li><a href="accountsjsp1.jsp">accounts</a></li>
    <li><a href="test.jsp">test</a></li>
    <li><a href="list.jsp">list</a></li>
    <li><a href="sixboxes.jsp">six boxes</a></li>
    <li><a href="sixboxes.jsp">boxes</a><l</li>
    <li><a href="back.jsp">back</a></li>
    <li><a href="submit.jsp">submit</a></li>
    <li><a href="login.jsp">form</a></li>
    <li><a href="details.jsp">details</a></li>
    <li><a href="details.jsp">details2</a></li>
    
    
    </body>
</html>
