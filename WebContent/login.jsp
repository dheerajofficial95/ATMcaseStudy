<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
	
	<form action="Servlet" method="post">
		<Br/> Account No: <input type="text" name="accno" value=""/>
		<Br/> Pin:  <input type="text" name="pwd" value=""/>
		<input type="hidden" name="why" value="login"/>
		<Br/> <input type="submit" value="Log In"/>
	</form>
	
	<Br/><c:out value="${message}"/>

</body>
</html>