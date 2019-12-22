<%-- 
    Document   : details
    Created on : Dec 19, 2019, 4:29:33 PM
    Author     : HOME
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Details</title>
        
    </head>
    <body>
        <h1>Student Details</h1>
        <style>
            table,th,td{
                width: 50%;
                border: 1px solid black;
                border-collapse: collapse;
            }
            th, td {
            padding: 10px;
        }
        
            *{ box-sizing :border-box} 
        </style>
        <form action="Insertion" method="post" >
            <table align="center">
            <tr>
                <td><label for="sname">Student name</label></td>
                <td> <input type="text" placeholder="Enter name" name="name" required>
                    </td>
            </tr>
        <tr>
                <td><label for="sid">Student id</label></td>
                <td> <input type="int" placeholder="Enter id" name="id" required>
                    </td>
            </tr>
            <tr>
                <td><label for="sbranch">Student branch</label></td>
                <td> <input type="text" placeholder="Enter branch" name="branch" required>
                    </td>
                    
                    
                   
            </tr>
            <tr>
                <td><label for="snum">Student number</label></td>
                <td> <input type="int" placeholder="Enter num" name="num" required>
                    </td>
            </tr>
            <tr>
               
                <td><label for="address">Address</label></td>
                <td><textarea name="address" rows="10" cols="20">
                    </textarea></td>
            </tr>
            <td colspan="2" align="center"><input type="submit" value="Save">
                <input type="Reset" value="Reset"></td>
            </table>
        </form>
    <center><a href="ViewServlet">view employees</a></center><br>
    <center><a href="./delete.jsp">Delete </a></center>
    
</body>
</html>
