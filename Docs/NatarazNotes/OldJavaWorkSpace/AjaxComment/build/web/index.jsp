<!DOCTYPE html>
<html>
<head>
<style>
    hr{
        color: orange;
    }
div.box{margin:15px;border:1px  black;padding:10px;background-color:ghostwhite;box-shadow: 2px 5px 5px gainsboro;width: 90%;}
</style>
</head>
<body>

<%@ page import="java.sql.*" %>
<%
String comment=request.getParameter("comment");
String email=request.getParameter("email");
if(comment==null||email==null||comment.trim().equals("")||email.trim().equals("")){
out.print("<p>Please write comment</p>");
}else{

try{
    /*
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","sysdba");

*/
Class.forName("com.mysql.jdbc.Driver");
//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ajax","root","root");
Connection con=DriverManager.getConnection("jdbc:mysql://node157059-natexp.j.layershift.co.uk/ajax","root","HPQiac29956");

PreparedStatement ps=con.prepareStatement("insert into usercomment(comment1,email) values(?,?)");
ps.setString(1,comment);
ps.setString(2,email);
int i=ps.executeUpdate();

PreparedStatement ps2=con.prepareStatement("select * from usercomment order by id desc");
ResultSet rs=ps2.executeQuery();

out.print("<hr/><h2>Comments:</h2>");
while(rs.next()){
out.print("<div class='box'>");
out.print("<p>"+rs.getString(2)+"</p>");
out.print("<p><strong>By: "+rs.getString(3)+"</strong></p>");
out.print("</div>");
}

con.close();
}catch(Exception e){out.print(e);}

}//end of else
%>
</body>
</html>