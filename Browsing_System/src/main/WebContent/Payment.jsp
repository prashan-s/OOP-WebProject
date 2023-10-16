<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<a href = "PaymentServlet">SelectPayment Hyperlink</a>
	
	<form method = "post" action = "PaymentServlet">
		<label for = "paymentId">Payment Id</label>
		<input type = "text" name = "paymentId">
		<input type = "submit" name = "submit" value = "Click Here">
	</form>
	
	<h1>List of Payments</h1>
	<table>
		<thead>
			<tr>
				<th>User Name</th>
				<th>Amount</th>
				<th>Payment Date</th>
			</tr>
		</thead>
		<tbody>
			<c:foreach items = "${payments} + ${users }" var = "payment + users">
				<tr>
					<td>${user. name}</td>
					<td>${payment.amount}</td>
					<td>${payment.rowCreatedDatetime}</td>
				</tr>
			</c:foreach>
		</tbody>
	</table>

</body>
</html>