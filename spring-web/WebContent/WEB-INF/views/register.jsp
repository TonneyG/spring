<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spitter</title>
</head>
<style>
	/* span.error{
		color:red;
	} */
	label.error{
		color:red;
	}
	div.error{
		background-color:#ffcccc;
		border:2px solid red;
	}
</style>
<body>
	<h1>Register</h1>
	
	<!-- <form method="POST">
		First Name:<input type="text" name="firstName"/><br/>
		Last Name:<input type="text" name="lastName"/><br/>
		UserName:<input type="text" name="userName"/><br/>
		Password:<input type="password" name="password"/><br/>
		<input type="submit" value="Register"/>
	</form>	 -->
	
	<sf:form method="POST" commandName="spitter">
		<sf:errors path="*" element="div" cssClass="errors" />
		First Name:<sf:input path="firstName"/><sf:errors path="firstName" cssClass="error"/><br/>
		Last Name:<sf:input path="lastName"/><br/>
		Email:<sf:input path="email" /><br/>
		UserName:<sf:input path="firstName"/><br/>
		Password:<sf:password path="firstName"/><br/>
		<input type="submit" value="Register">
	</sf:form>
</body>
</html>