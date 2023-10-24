<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile Privacy & Security</title>
</head>
<body>
	<c:set var="showUserIdForm" scope="session" value="true" />

	<c:choose>
		<c:when test="${showUserIdForm == true}">
			<form method="post" action="UserServlet">
				<label for="userId">User Id</label> 
				<input type="number" name="userId"> 
				<input type="submit" name="action" value="submitIdToChangePW">
			</form>
			
		</c:when>
		
		<c:when test="${showDeleteForm == true}">
			<form method="post" action="UserServlet">
					<label for="userId">delete account description</label>  
					<input type="submit" name="action" value="deleteAccount">
			</form>
		</c:when>	
		
		<c:when test="${showPwEditForm == true}">
			
			<form method ="post"  action="UserServlet">	
					<label for="currentPw">Current Password</label>
					<input type="password" name="currentPw"/>
					<br>
					<label for="newPw">New Password</label>
					<input type="password" name="newPw" />
					<br>
					<label for="ConfirmPw">Confirm Password</label>
					<input type="password" name="ConfirmPw"/>
					<br>
					<input type="submit" name="action" value="changePassword">
			</form>
		</c:when>
		
		<c:when test="${showPwChangeStatus == true}">
			<div>	
				<c:out value="${pwChangeMessage}"/>
			</div>
		</c:when>
		<c:when test="${showDeleteStatus == true}">
			<div>	
				<c:out value="${deletionMessage}"/>
			</div>
		</c:when>
		
		
	</c:choose>
</body>
</html>