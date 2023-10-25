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

	
		<c:if test="${showUserIdForm == true}">
			<form method="post" action="UserServlet">
				<label for="userId">User Id</label> 
				<input type="number" name="userId"> 
				<input type="submit" name="action" value="submitIdToChangePW">
			</form>
			
		</c:if>
		
		<c:if test="${showPwEditForm == true}">
			
			<form method ="post"  action="UserServlet">	
					<label for="currentPw">Current Password</label>
					<input type="password" name="currentPw"/>
					<br>
					<label for="newPw">New Password</label>
					<input type="password" name="newPw" />
					<br>
					<label for="ConfirmPw">Confirm Password</label>
					<input type="password" name="confirmPw"/>
					<br>
					<input type="submit" name="action" value="changePassword">
			</form>
		</c:if>
		
		<c:if test="${showDeleteForm == true}">
			<form method="post" action="UserServlet">
					<label for="userId">delete account description</label>  
					<input type="submit" name="action" value="deleteAccount">
			</form>
		</c:if>	
		
		<c:if test="${showPwChangeStatus == true}">
			<div>	
				<c:out value="${pwChangeMessage}"/>
			</div>
		</c:if>
		<c:if test="${showDeleteStatus == true}">
			<div>	
				<c:out value="${deletionMessage}"/>
			</div>
		</c:if>
	
</body>
</html>