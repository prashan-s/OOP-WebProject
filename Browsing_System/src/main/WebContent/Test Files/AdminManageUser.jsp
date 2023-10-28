<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin- Manage Users</title>
</head>
<body>
	<c:set var="showAdminIdForm" scope="session" value="true" />
	
	<c:if test="${showAdminIdForm == true}">
		<form method="post" action="UserServlet">
			<label for="adminName">Admin Name</label> 
			<input type="text" name="cookieAdmin"> 
			<input type="submit" name="action" value="submit Admin Name">
		</form>
	</c:if>
	
	
	<c:if test="${showUserList == true}">
    <table border="1">
        <tr>
            <th> Name </th>
            <th> Email </th>
            <th> Mobile No </th>
            <th> DOB </th>
            <th> Premium user </th>
            <th>  </th>
        </tr>
        
       <c:forEach items="${user}" var="user">
	       <tr>
	            <td>${user.name}</td>
	            <td>${user.email}</td>
	            <td>${user.email}</td>
	            <td>${user.dob}</td>
	            <td>${user.premiumUser}</td>
	            <td>
	            	<form method="post" action="UserServlet">
	            		<input type= "hidden" name="userId" value="${user.userId}">
		            	<input type="submit" name="action" value="editUser">
		            	<input type="submit" name="action" value="deleteUser">
					</form>
				</td>
	        </tr>
        </c:forEach>
    </table>
    </c:if>
    <c:if test="${showEditUserForm == true}">
			<form method="post" action="UserServlet">
			
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
					<label for="premium">Premium user</label>
					<input type="radio" name="premium" value=true> yes
					<input type="radio" name="premium" value=false> no
					<br>
					<input type="submit" name="action" value="updateUser">
			
			</form>
		</c:if>
		<c:if test="${showUpdateUserStatus == true}">
			<div>
				<c:out value="${editUserMessage}"></c:out>
			</div>
		</c:if>
		<c:if test="${showDeleteUserStatus == true}">
			<div>
				<c:out value="${deleteUserMessage}"></c:out>
			</div>
		</c:if>
</body>
</html>
	

</body>
</html>