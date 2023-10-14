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
				<th></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
	</table>

</body>
</html>