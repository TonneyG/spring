<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Pizza Hut</title>
</head>
<body>
	<h2>Welcome to Pizza Hut</h2>
	<form:form>
		<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
		<input type="text" name="phoneNumber"/><br/>
		<input type="submit" name="_eventId_phoneEntered" value="Lookup Customer"/>
	</form:form>
</body>
</html>