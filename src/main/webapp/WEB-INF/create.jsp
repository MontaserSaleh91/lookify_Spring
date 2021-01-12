<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    		<form:form method="POST" action="/create" modelAttribute="song">
    			<h4>Add a Song</h4>
    			<a href="/dashboard">Back</a><br>
    			<form:label path="title">Title:
		    <form:errors path="title"/><br>
		    <form:input type = "text" path="title"/></form:label><br>
		    
		    <form:label path="artist">Artist:
		    <form:errors path="artist"/><br>
		    <form:input type="text" path="artist"/></form:label><br>
		    
		    <form:label path="rating">Rating:
		    <form:errors path="rating"/>
		    <form:select path="rating">
		    		<% for(int i = 1; i <= 10; i++) { %>
		    			<form:option value="<%=i %>"><%= i %></form:option>
		    		<% } %>
		    </form:select></form:label><br>
		    
		    <button type="submit">Add</button>
    		</form:form>
  		<% if(request.getAttribute("errs") != null) { %>
	  	<fieldset>
	  		<legend>Errors</legend>
	  		<c:forEach items="${errs}" var="err">
				<p><c:out value="${err.getDefaultMessage()}"/></p>
			</c:forEach>
	  	</fieldset>
	  	<% } %>
</body>
</html>