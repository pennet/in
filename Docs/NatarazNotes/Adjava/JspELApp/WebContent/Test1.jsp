<%@page isELIgnored="false"%>

Sum  is : ${4+5} <br>
4>5 ?   ${4>5}  <br>
request param uname value : ${param.uname} <br>
Current browser name : ${header['user-agent']} <br>
<%
 request.setAttribute("course","java");
%>
Request attribute vlaue :  ${requestScope.course} <br>
Cookie name ${cookie.JSESSIONID.name} <br>
Cookie value ${cookie.JSESSIONID.value} <br>



