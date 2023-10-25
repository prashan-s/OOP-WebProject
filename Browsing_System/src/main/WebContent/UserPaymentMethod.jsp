<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="jakarta.tags.core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Payment Methods</title>
</head>
<body>
	 <form method="post" action="UserPaymentMethodServlet">
    	<label for="userId" >User Id</label>
		<input type="number" name="userId"/>
		<input type="submit" value="Submit">
   	</form>
        <table>
        	<c:forEach items="${methods}" var="method">
            <tr>
                <td>Card Number:</td>
                <td>${method.cardNumber}</td>
            </tr>
            <tr>
                <td>Expiry Date:</td>
                <td>${method.cardExpiryDate}</td>
            </tr>
            </c:forEach>
        </table>
</body>
</html>