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
	<c:set var="showUserIdForm" scope="session" value="true" />


	<h1>H1</h1>
	<h1>H1</h1>
	<h1>H1</h1>
	<c:choose>
		<c:when test="${showUserIdForm == true}">
			<form method="post" action="UserServlet">
				<label for="userId">User Id</label> <input type="number"
					name="userId"> <input type="submit" name="action"
					value="submit">
			</form>
		</c:when>
		<c:when test="${showDetails == true}">
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

			<form method="post" action="UserServlet">
				<input type="submit" name="action" value="edit">
			</form>
		</c:when>
		<c:when test="${showEditForm == true}">
			<form method="post" action="UserServlet">
				<c:forEach items="${users}" var="user">
					<label for="name">Name</label>
					<input type="text" name="name" value="${user.name}" />
					<br>
					<label for="email">Email</label>
					<input type="email" name="email" value="${user.email}" />
					<br>
					<label for="mobileNo">Mobile No</label>
					<input type="tel" name="mobileNo" value="${user.mobileNo}" />
					<br>
					<label for="dob">DOB</label>
					<input type="date" name="dob" value="${user.dob}" />
					<br>

					<input type="submit" name="action" value="update">
				</c:forEach>
			</form>
		</c:when>
	
		<c:when test="${showUpdateStatus == true} ">
			<h1>"${xmessage}"</h1>
			<c:out value="${xmessage}"/>
		</c:when>
		
		
		<c:otherwise>
			<c:if test="${1==1}">
				<h1>error</h1>
				
			</c:if>
		</c:otherwise>
	
	</c:choose>
</body>
</html>