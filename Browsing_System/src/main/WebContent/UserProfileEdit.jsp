<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile Edit</title>
</head>
<body>
	<h1>H1</h1>
	<h1>H1</h1>
	<h1>H1</h1>
	
	<form method="post" action="UserServlet">
		<label for="userId">User Id</label> 
		<input type="number" name="userId" />
	    <input type="submit" name= "action" value="submit">
	</form>
	<c:if test="${showDetails == true}">
	<table>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>Name:</td>
				<td>${user.name}</td>
			</tr>
			<tr>
				<td>Email:</td>
				<td>${user.email}</td>
			</tr>
			<tr>
				<td>Mobile Number:</td>
				<td>${user.mobileNo}</td>
			</tr>
			<tr>
				<td>Date of Birth:</td>
				<td>${user.dob}</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
	
	<form method="post" action="UserServlet">
		 <input type="submit" name = "action" value="edit">
	</form>
	
	
	<c:if test="${showEditForm == true} " >
	<form method="put" action="UserServlet">	
		<c:forEach items="${users}" var="user">
			<label for="name">Name</label>
			<input type="text" name="name" value="${user.name}" /><br>
			<label for="email">Email</label>
			<input type="email" name="email" value="${user.email}" /><br>
			<label for="mobileNo">Mobile No</label>
			<input type="tel" name="mobileNo" value="${user.mobileNo}" /><br>
			<label for="dob">DOB</label>
			<input type="date" name="dob" value="${user.dob}" /><br>
			
			<input type="submit" name="action" value="edit">
		</c:forEach>
	</form>
	</c:if>
	

</body>
</html>