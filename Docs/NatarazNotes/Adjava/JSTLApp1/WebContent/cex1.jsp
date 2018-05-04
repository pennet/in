<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
            prefix="c" %>

<c:set var="var1"  value="hello" scope="request"/>
  First:    <c:out value="${var1}"/>
 <br>
  <c:remove var="var1" scope="request"/>
    Second <c:out value="${var1}"/>    
