<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	  	<div>
  		<a href="/dashboard">Dashboard</a><br>
  		<p>Title: <i><c:out value="${song.title}"/></i></p>
  		<p>Artist: <i><c:out value="${song.artist}"/></i></p>
  		<p>Rating: <i><c:out value="${song.rating}"/></i></p>
  		<a href="/delete/${song.id}">Delete</a>
  	</div>
</body>
</html>