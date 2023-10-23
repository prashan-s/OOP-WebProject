<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of TVSeries Details</title>
</head>
<body>

	<a:set var="showUserIdForm" scope="session" value="true" />

	<a:choose>
		<c:when test="${showTVSeriesDetailsIdForm == true}">
			<form method="post" action="MovieServlet">
				<label for="tvSeriesDetailsId">TVSeries Details Id</label> <input
					type="number" name="tvSeriesDetailsId"> <input
					type="submit" name="action" value="submit">
			</form>
		</c:when>

		<c:when test="${showDetails == true}">
			<h1>List of TVSeries Details</h1>
			<table border="1">
				<thead>
					<tr>
						<th>Season</th>
						<th>Episode</th>
						<th>Description</th>
						<th>Year</th>
						<th>Duration</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${seriesDetailsList}" var="tvSeriesDetails">
						<tr>
							<td>${tvSeriesDetails.season}</td>
							<td>${tvSeriesDetails.episode}</td>
							<td>${tvSeriesDetails.description}</td>
							<td>${tvSeriesDetails.year}</td>
							<td>${tvSeriesDetails.duration}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		
		<c:when test="${showEditForm == true}">
			<form method="post" action="TVSeriesDetailsServlet"></form>
		</c:when>
		
	</a:choose>
</body>
</html>
