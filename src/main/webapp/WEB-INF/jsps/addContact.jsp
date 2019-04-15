<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Contact</h1>
	<br>
	<c:url var="url" value="/savecontact" />

	<form:form modelAttribute="student" method="post" action="${url }">

	Id: <form:input path="id" />
		<br>
	Name: <form:input path="name" />
		<br>
	Email: <form:input path="email" />
		<br>
	Postal Code: <form:input path="postal" />
		<br>
		<input type="submit" value="Add Student" />

	</form:form>
	<c:forEach var="e" items="${errorList}">
	${e }<br>
	
	
	</c:forEach>
	
</body>
</html>