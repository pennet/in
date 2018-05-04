
<%@page import="com.nt.*" %>

<jsp:useBean id="rotator" class="com.nt.Rotator" scope="session"/>

<% rotator.nextAdvertisement();
   response.setHeader("refresh","2");
%>

<a href="<jsp:getProperty name="rotator" property="link"/>">
  <img src="<jsp:getProperty name="rotator" property="image"/>"
    width="500" height="200"/>
</a>

