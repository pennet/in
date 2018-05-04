

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File String Replace </title>
</head>
<body>


<form method="get" action="http://localhost:8080/Dy/fileOnlocalMachine">

 <table>
 <tr><td>Enter File Name </td><td><input type="text" name="filename"></td>
 
</tr>
 <tr><td>Search Word </td><td><input type="text" name="existString"></td></tr>
 <tr><td>Replace Word </td><td><input type="text" name="replaceString"></td></tr>
 <!-- <tr><td>Create own file </td><td><input type="text" name="createNewFile"></td></tr> -->
 <tr><td><input type="reset" value="Clear"></td><td> <input type="submit" value="Submit"></td></tr>


 </table>
 
</form>

<br><br>
<div id= "log" style="">
<FORM action="logfile" METHOD="GET">
<input type=submit name=showLog id=txtSubmit 
value=ViewContent />
</FORM>
</div>


</body>
</html>