<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>
<body>
<form action="/FirstWebApp/LoginController" method="post">
<table>
<tr><td>User Id</td><td><input type="text" name="userId"><td></tr>
<tr><td>Password</td><td><input type="text" name="password"></td></tr>
<tr><td><input type="submit" value="Submit"></td></tr>
</table>
</form>
</body>
</html>