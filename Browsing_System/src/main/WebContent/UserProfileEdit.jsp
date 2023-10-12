<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile Edit</title>
</head>
<body>
	
    <form method="post" action="UserServlet">
    	<label for="userId" >User Id</label>
		<input type="number" name="userId"/>
		 <input type="submit" value="Submit">
   	</form>
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
       
   
</body>
</html>