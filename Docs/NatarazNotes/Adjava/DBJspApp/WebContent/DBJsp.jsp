<%@page import="java.sql.*" %>
<%!
  Connection con;
  PreparedStatement ps1,ps2;
   ResultSet rs;
  public void jspInit(){
	
	try{
     //Access ServletConfig obj
     ServletConfig cg=getServletConfig();
     String s1=cg.getInitParameter("driver");
     String s2=cg.getInitParameter("url");
     String s3=cg.getInitParameter("user");
     String s4=cg.getInitParameter("pwd");
     //register jdbc driver
     Class.forName(s1);
     con=DriverManager.getConnection(s2,s3,s4);
     ps1=con.prepareStatement("insert into  student values(?,?,?)");
     ps2=con.prepareStatement("select * from student");
	}//try
	catch(SQLException se){
		se.printStackTrace();
	}
	catch(ClassNotFoundException cnf ){
		cnf.printStackTrace();
	}
	catch(Exception e){
		e.printStackTrace();
	}
}//jspInit
%>

<% //read s1 req param value
   String pval=request.getParameter("s1");
   if(pval.equals("register")){
	     //read form data
	   int no=Integer.parseInt(request.getParameter("tsno"));
	   String name=request.getParameter("tsname");
	   String addrs=request.getParameter("tsadd");
	   //set form data as the values to query params
	   ps1.setInt(1,no);
	   ps1.setString(2,name);
	   ps1.setString(3,addrs);
	   // execute the Query
	   int result=ps1.executeUpdate();
	   if(result==0){%>
	    <b> Registration Failed</b>
	   <%}
	   else{%>
	   <b> Registration Success</b>
	   <%}//else
   }//outer if
   else{
	   //execute the Query
	   ResultSet rs=ps2.executeQuery();
	   //get ResultSetMetaData
	   ResultSetMetaData rsmd=rs.getMetaData();
  %>
    <table border='1'>
      <tr>
       <%for(int i=1;i<=rsmd.getColumnCount();++i){ %>
    	   <td><%=rsmd.getColumnLabel(i) %></td>
    	  <% } %>
       </tr>
       <% 
        while(rs.next()){ %>
        <tr>
         <% for(int i=1;i<=rsmd.getColumnCount();++i){ %>
        	 <td><%=rs.getString(i) %></td> 
       <% }//for %>
         </tr>
       <% }//while
          %>
       	</table>
   <%}//else %>
   <a href='Form.html'>Back</a>       	  
    
	   
  <%! public void jspDestroy(){
	  try{
		  if(rs!=null)
		  rs.close();
	  }
	  catch(Exception e){
		  e.printStackTrace();
	  }
	  
	  try{
	   if(ps1!=null)
		   ps1.close();
	  }
	  catch(Exception e){
		  e.printStackTrace();
	  }
	  
	  try{
		   if(ps2!=null)
			   ps2.close();
		  }
		  catch(Exception e){
			  e.printStackTrace();
		  }
		  
	  
	  try{
		if(con!=null)
			con.close();
	  }
	  catch(Exception e){
		  e.printStackTrace();
	  }
  }
  
  %>
     
     
     
   