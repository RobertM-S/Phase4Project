<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Add New Book</h1>
<form action = "add" method = "post">
	<div>Title: <input type = "text" name = "title" required></div>
	<div>Author: <input type = "text" name = "author" required></div>
	<div>Price: <input type = "text" name = "price" required></div>
	<div>Description: <input type = "text" name = "desc" required></div>
	<div><input type = "submit"></div>
</form>
</body>
</html>
