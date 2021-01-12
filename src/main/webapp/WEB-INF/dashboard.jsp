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
	  		<h4>
	  		<a href="/create">Add New</a>     
	  		<a href="/top">Top Songs</a>  
	  		<form method="POST" action="/search">
	  		Search: <input type="text" name="search"> <button type="submit">Search</button>
	  		</form>
	  		
	  		</h4>

  		<div>
  			<table>
  				<tr>
  					<th>Title</th>
  					<th>Rating</th>
  					<th>Actions</th>
  				</tr>
  				<c:forEach items="${songs}" var="song">
			    		<tr>    
			    			<td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
			    			<td><c:out value="${song.rating}"/></td>
			    			<td><a href="/delete/${song.id}">Delete</a></td>
			    		</tr>
				</c:forEach>
  			</table>
  		</div>
</body>
</html>