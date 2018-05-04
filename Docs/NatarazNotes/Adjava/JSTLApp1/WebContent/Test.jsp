<%@taglib uri="http://java.sun.com/jsp/jstl/core"
          prefix="c" %>

 <c:set var="msg" value="hello" scope="session"/>
 
 Message : <c:out value="${msg}" />
 
 <c:remove var="msg" scope="session"/>
 
 Message : <c:out value="${msg}" />
 
