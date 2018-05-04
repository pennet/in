<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<c:set var="var1" value="Welcome" /> 

<c:if test="${!empty param.uname}">
    <c:out value="${var1}" />
    <c:out value="${param.uname}" />
</c:if> 
