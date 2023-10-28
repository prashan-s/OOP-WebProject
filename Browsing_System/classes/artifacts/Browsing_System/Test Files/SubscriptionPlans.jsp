<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subscription Plan- user</title>
</head>
<body>
	<c:set var="showUserIdForm" scope="session" value="true" />

	<c:if test="${showUserIdForm == true}">
		<form method="post" action="SubscriptionPlanServlet">
			<label for="userId">User Id</label> 
			<input type="number" name="userId"> 
			<input type="submit" name="action" value="submit user Id">
		</form>
	</c:if>
		
	<c:if test="${showPlansToUser == true}">
	 	<table border = 1>
	 		<thead>
				<tr>
					<th>Description</th>
					<th>Duration in months</th>
					<th>Amount</th>
					<th> </th>
				</tr>
			</thead>
			<tbody>
			   	<c:forEach items="${subscriptionPlans}" var="subPlans">
			   		<tr>
						<td>${subPlans.description}</td>
						<td>${subPlans.duration}</td>
						<td>${subPlans.amount}</td>
						 <td>
						 	<form  method="post" action="SubscriptionPlanServlet">
								<input type="hidden" name="planId" value="${subPlans.planId}">
							 	<input type="submit" name="action" value="activate">
						 	</form>
						 </td>		
					</tr>	
				</c:forEach>
	        </tbody>
	    </table>
	</c:if>

</body>
</html>