

<%@page import="com.nt.StudentBean" %>

  <jsp:useBean id="st" class="com.nt.StudentBean" scope="session"/>
  
  <!-- write values to bean properties  -->
  <jsp:setProperty name="st" property="*"/>
  
  <br>
  
  <b> Values are set to Bean properties</b>
  
  


