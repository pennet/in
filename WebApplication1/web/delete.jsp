<%-- 
    Document   : delete
    Created on : Dec 21, 2019, 1:21:08 PM
    Author     : HOME
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Form</title>
    </head>
    <body>
        <h1>Delete Form</h1>
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
         <form action="DeleteForm" method="post" >
        <table align="center">
            <tr>
                <td><label for="sid">Enter Student id</label></td>
                <td> <input type="text" placeholder="Enter Student id" name="studentid" required>
                    </td>
            </tr>
            <td colspan="2" align="center"><input type="submit" value="OK">
        </table>
    
</html>
