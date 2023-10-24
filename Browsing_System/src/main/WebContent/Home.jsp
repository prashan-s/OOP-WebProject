<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<c:set var="showSignInForm" scope="session" value="true"/>
	<c:choose>
		<c:when test="${showSignInForm == true}">
		    <form method="post" action="UserServlet">
		        
		        <label for="userName">User Name:</label>
		        <input type="text" name="userName" ><br>
		       
		        <label for="password">Password:</label>
		        <input type="password"  name="password" ><br>
		        
		        <input type="submit" name = "action" value="signIn"><br>
		        <input type="submit" name = "action" value="signUp"><br>
		    </form>
	
		</c:when>
		<c:when test="${showSignUpForm == true}">
	    	<form method="post" action="UserServlet" >
	        
		        <label for="userName">User Name:</label>
		        <input type="text" name="userName" ><br>
		        
		        <label for="email">Email:</label>
		        <input type="email"  name="email" ><br>
		        
		        <label for="mobile">Mobile Number:</label>
		        <input type="tel"  name="mobile" ><br>
		       
		        <label for="dob">Date of Birth:</label>
		        <input type="date" name="dob" ><br>
		        
		        <label for="password">Password:</label>
		        <input type="password"  name="password" ><br>
		        
		        <label for="confirmPassword">Confirm Password:</label>
		        <input type="password" name="confirmPassword" ><br>
		        
		        <input type="submit" name = "action" value="register"><br>
		    </form>

		</c:when>
		
		<c:when test="${showSignUpStatus == true}">
			<div>
				<c:out value ="${SignUpMessage}"/>
			</div>
		</c:when>
		
		
	
	</c:choose>


</body>
</html>