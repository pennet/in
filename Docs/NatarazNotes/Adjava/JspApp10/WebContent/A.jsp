

 <% //create attributes diff scopes
  pageContext.setAttribute("attr1","val1",pageContext.REQUEST_SCOPE);
  pageContext.setAttribute("attr2","val2",pageContext.SESSION_SCOPE);
  pageContext.setAttribute("attr3","val3",pageContext.APPLICATION_SCOPE); %>
  
  <!--  forward the request to B.jsp -->
  <jsp:forward page="B.jsp"/>
  
  
   
 