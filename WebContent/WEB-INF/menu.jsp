<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ATM Menu</title>
</head>
<body>
	<Br/><c:out value="Welcome ${user} !!"/>
	
	<form action="Servlet" method="post">
		<Br/> <input type="submit" value="View Balance "/> <c:out value="${bal}"/>
		<input type="hidden" name="why" value="viewBal"/>
		<Br/> 
	</form>
	
	<form action="Servlet" method="post">
		<Br/>Amount: <input type="text" name="amount" value=""/><input type="submit" value="Withdraw Cash"/> <c:out value="${result}"/>
		<input type="hidden" name="why" value="withdraw"/>
		<Br/> 
	</form>
	
	<form action="Servlet" method="post">
		<Br/> Amount: <input type="text" name="amount" value=""/><input type="submit" value="Deposit Cash"/> <c:out value="${deposit}"/>
		<input type="hidden" name="why" value="deposit"/>
		<Br/> 
	</form>
</body>
</html>