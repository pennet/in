<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Data</title>
</head>
<style>
div.ex {
	text-align: left; width:300px;
	padding: 10px;
	border: 5px solid gainsboro;
	margin: 0px;
        border-radius: 4px;
}
</style>
<body>
<center>	
    <h1>AreaTech IT Solutions </h1>
    <h3>Bank Example </h3>
	<div class="ex">
		<form action="RegistrationController" method="post">			
                            
                    <table style="with: 50%">
				<tr>
					<td>Full Name</td>
					<td><input type="text" name="fullname" required="required" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="address" required="required"/></td>
				</tr>
				<tr>
					<td>Age</td>
					<td><input type="number" name="age" required="required"/></td>
				</tr>
				<tr>
					<td>Qualification</td>
					<td><input type="text" name="qual" required="required"/></td>
				</tr>
				<tr>
					<td>Percentage</td>
					<td><input type="number" name="percent" required="required" /></td>
				</tr>
				<tr>
					<td>Year Passed</td>
					<td><input type="number" name="yop" required="required" /></td>
				</tr>
                                
                                 <tr>
					<td></td>
					<td></td>
				</tr>
			
                       
                        <tr>
					<td></td>
					<td><input type="submit" value="Register" /></td>
				</tr>
			</table>
                    
		</form>
        </div>

</center>
</body>
</html>