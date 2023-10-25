<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subscription Plan List</title>
</head>
<body>
 	
 	<c:set var="showUserIdForm" scope="session" value="true" />


	<c:if test="${showUserIdForm == true}">
		<form method="post" action="SubscriptionPlanServlet">
			<label><input type="radio" name="role" value="user">User</label>
			<label><input type="radio" name="role" value="admin">Admin</label><br><br>
			<input type="submit" name="action" value="submit">
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
						 <td><input type="submit" name="action" value="activate"></td>		
					</tr>	
				</c:forEach>
	        </tbody>
	    </table>
	</c:if>
	
	<c:if test="${showPlansToAdmin == true}">
	 	<table border = 1>
	 		<thead>
				<tr>
					<th>Description</th>
					<th>Duration in months</th>
					<th>Amount</th>
					<th>Activation</th>
					<th> </th>
				</tr>
			</thead>
			<tbody>
	        	<c:forEach items="${subscriptionPlans}" var="subPlans">
	        		<tr>
						<td>${subPlans.description}</td>
						<td>${subPlans.duration}</td>
						<td>${subPlans.amount}</td>
						<td>${subPlans.isActive}</td>
						<td>
							<form method="post" action="SubscriptionPlanServlet">
								<input type="hidden" name="planId" value="${subPlans.planId}">
								<input type="submit" name="action" value="edit">	
								<input type="submit" name="action" value="remove">	
							</form>	
						</td>
					</tr>
				</c:forEach>
	        </tbody>
	    </table>
	    <form method="post" action="SubscriptionPlanServlet">
	    	<input type="submit" name="action" value="addPlan">
	    </form>
	</c:if>
	
	<c:if test="${editPlansByAdmin == true}">
		<form method="post" action="SubscriptionPlanServlet">
	
				<label for="description">Description</label>
				<input type="text" name="description" value="${subPlan.description}" />
				<br>
				<label for="duration">Duration in Months</label>
				<input type="number" name="duration" value="${subPlan.duration}" />
				<br>
				<label for="amount">amount</label>
				<input type="number" name="amount" value="${subPlan.amount}" />
				<br>
				<label for="isActive">Is Active </label>
				<label><input type="radio" name="active" value="active">activate</label>
				<label><input type="radio" name="active" value="deActive">de-activate</label>
				<br>
				<input type="submit" name="action" value="update">
		
		</form>		
	</c:if>
	<c:if test="${showUpdateStatus == true}">
		<div>
			<c:out value="${UpdateMessage}"></c:out>
		</div>
	</c:if>
	<c:if test="${showDeleteStatus == true}">
		<div>
			<c:out value="${deleteMessage}"></c:out>
		</div>
	</c:if>
	
	<c:if test="${insertPlansByAdmin == true}">
		<form method="post" action="SubscriptionPlanServlet" >
	        
		        <label for="description">description</label>
		        <input type="text" name="description" ><br>
		        
		        <label for="duration">duration in months:</label>
		        <input type="number"  name="duration" ><br>
		        
		        <label for="amount">amount:</label>
		        <input type="number"  name="amount" ><br>
		       
		        <label for="isActive">Is Active </label>
				<label><input type="radio" name="active" value="active">activate</label>
				<label><input type="radio" name="active" value="deActive">de-activate</label><br>
		        
		       <input type="submit" name = "action" value="insert"><br>
		   </form>
	</c:if>
	<c:if test="${showInsertedStatus == true}">
		<div>
			<c:out value="${insertMessage}"></c:out>
		</div>
	</c:if>
	
</body>
</html>