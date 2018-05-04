<html>
<!--
  Shows how to use standard tags (JSTL), We can use implict variables
like param,header,cookie,pageScope,requestScope,sessionScope,applicationScope,pageContext
-->
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 
<HTML>
<HEAD>
<TITLE>Example on JSTL Coretags</TITLE>
</HEAD>
<BODY BGCOLOR="#FFFFFF">
 List of students<br><br>
<c:set var="str" value="raja,ravi,jani,rakesh" scope="page" />

<c:forTokens var="sname" items="${str}" delims="," >
	<c:out value="${sname}" /> <br>
</c:forTokens>

</BODY>
</HTML>
