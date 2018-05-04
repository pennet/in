
<%@page import="com.nt.StudentBean" %>

<!--Locate the bean-->
  <jsp:useBean id="st" class="com.nt.StudentBean" scope="session"/>

<br><br>
 <b> Student Details are </b>
 <br>
 sno = <jsp:getProperty name="st" property="sno"/> <br>
 sname = <jsp:getProperty name="st" property="sname"/> <br>
 result = <jsp:getProperty name="st" property="result"/> <br>
 
  
 
