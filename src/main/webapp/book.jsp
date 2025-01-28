<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List of Books</h1>
	<c:forEach items="${book}" var="book">
	<div style="color: brown; margin-bottom: 2px; padding: 20px">
		<p>Title: ${book.title}</p>
		<p>Author: ${book.author }</p>
		<p>Price: ${book.price }</p>
		<p>Description: ${book.desc }</p>
		<a href="edit?bookid=${book.bookid}">Edit</a>&nbsp;&nbsp;
		<a href="delete/${book.bookid}">Delete</a>
			<hr />
		<hr />
	</div>
	</c:forEach>
	<a href="add">Add</a>&nbsp;&nbsp;
	<form action="search" method="get">
	<div>Search by Author: <input type = "text" name = "author" required>
	<input type = "submit">
	</div>
	</form>
	
</body>
</html>