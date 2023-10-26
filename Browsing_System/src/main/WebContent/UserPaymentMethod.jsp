<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Payment Methods</title>
</head>
<body>
	<c:set var="showUserIdForm" scope="session" value="true" />

	<c:if test="${showUserIdForm == true}">
		<form method="post" action="UserPaymentMethodServlet">
			<label for="userId">User Id</label> 
			<input type="number" name="userId">
			<input type="submit" name="action"value="submit">
		</form>
	</c:if>

	<c:if test="${listPaymentMethod == true}">
		<table border = 1>
			<thead>
				<tr>
					<td>Card Number</td>
					<td>Expire Date  </td>
					<td> </td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${methods}" var="method">
					<tr>
						<td>${method.cardNumber}</td>
						<td>${method.cardExpiryDate}</td>
						<td>
							<form  method="post" action="UserPaymentMethodServlet">
								<input type="hidden" name="paymentMethodId" value="${method.paymentMethodId}">
								<input type="submit" name="action"value="remove">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	
	<c:if test="${showDeleteStatus == true}">
		<div>
			<c:out value="${deleteMessage}"></c:out>
		</div>
	</c:if>
	
	<c:if test="${addPaymentMethod == true}">
		<form method="post" action="UserPaymentMethodServlet">

			<label for="cardNo">Card Number : </label> 
			<input type="text" name="cardNo"><br> 
			<label for="expDate">Expire Date :</label>
			<input type="date" name="expDate"><br> 
			<label for="cvv">CVV :</label> <input type="number" name="cvv"><br>

			<input type="submit" name="action" value="add"><br>
			
		</form>
	</c:if>
	
	<c:if test="${showInsertStatus == true}">
		<div>
			<c:out value="${insertMessage}"/>
		</div>
	</c:if>
</body>
</html>