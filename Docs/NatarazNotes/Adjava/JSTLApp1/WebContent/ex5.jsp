<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table> 
<c:forEach var="x" begin="1" end="10" step="1">
 <tr>
 <td><c:out value="2 * ${x}  = "/></td> 
<td><c:out value="${2 * x}"/></td>
</tr> 
</c:forEach>
 </table> 
