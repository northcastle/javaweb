<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>first page</title>
</head>
<body>
<form action="loginservlet" method="post">
	user :<input type="text" name="username">
	password :<input type="password" name="password">
	<br><br>
	instrestings :<br>
	<input type="checkbox" name="instrestring" value="reading">reading  <br>
	<input type="checkbox" name="instrestring" value="writing">"writing"  <br>
	<input type="checkbox" name="instrestring" value="running">running  <br>
	<input type="checkbox" name="instrestring" value="sport">sport  <br>
	
	<input type="submit" value="Submit">
</form>


</body>
</html>