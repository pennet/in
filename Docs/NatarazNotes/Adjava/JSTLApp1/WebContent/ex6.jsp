<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<sql:setDataSource var="ds" 
                   driver="oracle.jdbc.driver.OracleDriver"
		           url="jdbc:oracle:thin:@localhost:1521:xe"
		           user="scott" password="tiger" />

<sql:query var="rs" dataSource="${ds}" 
                    sql="select * FROM emp" />

<c:forEach var="row" items="${rs.rows}"> 
   <c:out value="${row.ename}" />
  <c:out value="${row.job}" />
<br><br>
</c:forEach> 

</BODY>
</HTML>
