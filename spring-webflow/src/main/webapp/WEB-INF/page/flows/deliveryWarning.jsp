<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pizza Hut</title>
</head>
<body>
	<h2>Delivery Unavailable</h2>
	<p>The address is outside of our delivery area. you may still place the order, 
	but you will need to pick it up yourself.</p>
	<a href="${flowExecutionUrl}&_eventId=accept">Continue, I will pick up the order</a>
	<a href="${flowExecutionUrl}&_eventId=cancel">Never mind</a>
</body>
</html>