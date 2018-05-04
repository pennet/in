<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<sql:setDataSource var="ds" driver="oracle.jdbc.driver.OracleDriver"
		url="jdbc:oracle:thin:@localhost:1521:xe" user="scott" password="tiger" />

<sql:transaction dataSource="${ds}">
 <sql:update> 
	update emp SET comm =comm + ? WHERE empno = ? 
	<sql:param value="1000"/>
	<sql:param value="7499"/>
 </sql:update> 
</sql:transaction> 
Record updated.

</BODY>
</HTML>
