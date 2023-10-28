<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User History Page</title>
</head>
<body>
	<c:set var="showUserIdForm" scope="session" value="true" />


	<c:if test="${showUserIdForm == true}">
		<form method="post" action="UserWatchHistoryServlet">
			<label for="userId">User Id</label> <input type="number"
				name="userId" /> <input type="submit" name="action"
				value="WatchHistory">
		</form>
	</c:if>
	<c:if test="${showUserHistory == true}">
		<table>
			<tr>
				<th>Type</th>
				<th>Tv Series Id</th>
				<th>Movie Id</th>
				<th></th>
			</tr>
			<c:forEach items="${history}" var="history">
				<tr>
					<td>${history.type}</td>
					<td>${history.tvsId}</td>
					<td>${history.movieId}</td>
					<td>
						<form method="post" action="UserWatchHistoryServlet">
							<input type="hidden" name="watchId" value="${history.watchId}">
							<input type="submit" name="action" value="remove">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${showDeleteStatus == true}">
		<div>
			<c:out value="${deleteMessage}" />
		</div>
	</c:if>

</body>
</html>