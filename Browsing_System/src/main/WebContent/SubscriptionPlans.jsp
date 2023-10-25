<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subscription Plan List</title>
</head>
<body>

	<a href="SubscriptionPlan">Select Subscription Plan Hyperlink</a>
    
    <form method="post" action="SubscriptionPlanServlet">
        <label for="subId">Subscription Plan Id</label>
        <input type="number" name="subId">
        <input type="submit" name="submit" value="Click Here">
    </form>

	<h1>List of subscription plan</h1>
	<table border = 1>
	
		<thead>
			<tr>
			
				<th>Description</th>
				<th>Duration in months</th>
				<th>Amount</th>
			</tr>
		
		</thead>
		<tbody>
			<c:foreach items="${subPlanId}" var="subPlans">
				<tr>
					<td>${subPlans.description}</td>
					<td>${subPlans.duration}</td>
					<td>${subPlans.amount}</td>
				</tr>
			</c:foreach>
		</tbody>
	
	</table>
	
</body>
</html>