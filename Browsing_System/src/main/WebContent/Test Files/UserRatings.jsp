<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Ratings List</title>
</head>
<body>
	<c:set var="showRateIdForm" scope="session" value="true" />

	<c:if test="${showRateIdForm == true}">
		<h1>List of User Ratings</h1>
		<form method="post" action="UserRatingsServlet">
			<label for="rateId">User Ratings Id</label> <input type="number"
				name="rateId"> <input type="submit" name="action"
				value="submit">
		</form>
		<br>
		<br>


		<form method="post" action="TVSeriesDetailsServlet">
			<input type="submit" name="action" value="add">
		</form>
	</c:if>

	<c:if test="${showDetails == true}">
		<table border="1">
			<thead>
				<tr>
					<th>User ID</th>
					<th>Type</th>
					<th>TVSeries ID</th>
					<th>Movie ID</th>
					<th>Rates</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userRatingsList}" var="rate">
					<tr>
						<td>${rate.userId}</td>
						<td>${rate.type}</td>
						<td>${rate.tvsId}</td>
						<td>${rate.movieId}</td>
						<td>${rate.rating}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
<!-- 		<br> -->
<!-- 		<br> -->
<!-- 		<form method="post" action="UserRatingsServlet"> -->
<!-- 			<input type="submit" name="action" value="edit"> -->
<!-- 		</form> -->
	</c:if>

<%-- 	<c:if test="${showEditForm == true}"> --%>
<!-- 		<form method="post" action="UserRatingsServlet"> -->
<%-- 			<c:forEach items="${userRatingsList}" var="rate"> --%>
<!-- 				<label for="userId">User ID</label> -->
<%-- 				<input type="number" name="userId" value="${rate.userId}"> --%>
<!-- 				<br> -->
<!-- 				<br> -->

<!-- 				<label for="type">Type</label> -->
<%-- 				<input type="text" name="type" value="${rate.type}"> --%>
<!-- 				<br> -->
<!-- 				<br> -->

<!-- 				<label for="tvsId">TVSeries ID</label> -->
<%-- 				<input type="number" name="tvsId" value="${rate.tvsId}"> --%>
<!-- 				<br> -->
<!-- 				<br> -->

<!-- 				<label for="movieId">Movie ID</label> -->
<%-- 				<input type="number" name="movieId" value="${rate.movieId}"> --%>
<!-- 				<br> -->
<!-- 				<br> -->

<!-- 				<label for="rating">Rating</label> -->
<%-- 				<input type="number" name="rating" value="${rate.rating}"> --%>
<!-- 				<br> -->
<!-- 				<br> -->

<!-- 				<input type="submit" name="action" value="update"> -->
<%-- 			</c:forEach> --%>
<!-- 		</form> -->
<%-- 	</c:if> --%>

	<c:if test="${showAddForm == true}">
		<form method="post" action="UserRatingsServlet">
			<label for="userId">User ID</label> <input type="number" name="userId">
			<br> <br> <label for="type">Type</label> <input type="text"
				name="type"> <br> <br> <label for="tvsId">TVSeries
				ID</label> <input type="number" name="tvsId"> <br> <br> <label
				for="movieId">Movie ID</label> <input type="number" name="movieId">
			<br> <br> <label for="rating">Rating</label> <input
				type="number" name="rating"> <br> <br> <input
				type="submit" name="action" value="insert">
		</form>
	</c:if>

	<c:if test="${showUpdateStatus == true}">
		<h1>${xmessage}</h1>
		<c:out value="${xmessage}" />
	</c:if>

	<c:if test="${showInsertStatus == true}">
		<h1>${xmessage}</h1>
		<c:out value="${xmessage}" />
	</c:if>

	<c:if test="${showDeleteStatus == true}">
		<h1>${xmessage}</h1>
		<c:out value="${xmessage}" />
	</c:if>

</body>
</html>
