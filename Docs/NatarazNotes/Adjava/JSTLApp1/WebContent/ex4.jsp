<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 List of students<br><br>

<c:set var="str" value="raja,ravi,jani,rakesh" scope="page" />

<c:forTokens var="sname" items="${str}" delims="a" >
	<c:out value="${sname}" /> <br>
</c:forTokens>

</BODY>
</HTML>
