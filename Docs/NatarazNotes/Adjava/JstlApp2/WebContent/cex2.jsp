<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

  <c:catch var="e">
    <jsp:scriptlet>
      int a=Integer.parseInt("10a");
    </jsp:scriptlet>
  </c:catch>
 <c:out value="${e}"/>
