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
  <c:choose>
       <c:when test="${param.p>0}">
	         p is +ve
        </c:when>
	<c:when test="${param.p<0}">
	         p is -ve
        </c:when>
     <c:otherwise>
	        p is zero
       </c:otherwise>
</c:choose>


</BODY>
</HTML>
