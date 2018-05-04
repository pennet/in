<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%!
String fileOutput;
%>

<%@ page
import="java.lang.*"
import="java.util.Scanner"
import="java.io.FileReader"
import="java.net.*"
%>

<%!
class DisplayLog {

void display(){
try {
String fileName;
String s2="/WEB-INF/Data.txt";
StringBuffer buffer = new StringBuffer();

Scanner scan = new Scanner(new FileReader(s2));


String readdata="";
while ((readdata=scan.nextLine())!=null){

buffer.append(readdata).append('\n');
}
fileOutput = buffer.toString();
}catch(Exception e)
{
}
}
}
%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body bgcolor="royalblue">

<tr>
<CENTER> <img width=100px; height="100px" style="border-radius:50px;" src="https://scontent.fhyd2-1.fna.fbcdn.net/v/t1.0-1/p160x160/24232856_930915223748973_7876935165776402928_n.jpg?_nc_cat=0&oh=cbcaa74c5a6b4b051c023bede6a5811c&oe=5B519078"  alt="logo"/></CENTER>
</tr>

<center><h2 style="color:#fff;">PENCHAL G</h2></center>
<HR WIDTH="100%" SIZE="3" NOSHADE style="color:black">
<FORM METHOD=post ACTION="/cgi-bin/example.cgi">
<textarea name="txtAreaLog" cols="30" rows="20" readonly="readonly" title="log area"> </textarea> 
<textarea rows="20" cols="62" readonly =" readonly" WRAP="off"><%= (fileOutput != null) ? fileOutput : "" %></textarea>
</FORM>

<FORM METHOD=post ACTION="/cgi-bin/example.cgi">
Enter file name:<BR>
<INPUT type="text" size="10" maxlength="30">
<INPUT type="Submit" VALUE="Submit">
</FORM>
<div align="right">[ <A href="logout.jsp" style=""><font style="font-family:verdana; font-size:70%;" color="blue"><b>L</b>ogout</font></A> ]</div>
</body>
</html>
