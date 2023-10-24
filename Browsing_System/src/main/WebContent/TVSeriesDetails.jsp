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

	<c:set var="showTVSeriesDetailsIdForm" scope="session" value="true" />

	<c:choose>
		<c:when test="${showTVSeriesDetailsIdForm == true}">
			<form method="post" action="TVSeriesDetailsServlet">
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

			<form method="post" action="TVSeriesDetailsServlet">
				<input type="submit" name="action" value="edit">
			</form>

		</c:when>

		<c:when test="${showEditForm == true}">
			<form method="post" action="TVSeriesDetailsServlet">
				<c:forEach items="${seriesDetailsList}" var="tvSeriesDetails">
					<label for="season">Season</label>
					<input type="number" name="season"
						value="${tvSeriesDetails.season}">
					<br>
					<br>
					<label for="episode">Episode</label>
					<input type="number" name="episode"
						value="${tvSeriesDetails.episode}">
					<br>
					<br>
					<label for="description">Description</label>
					<input type="text" name="description"
						value="${tvSeriesDetails.description}">
					<br>
					<br>
					<label for="year">Year</label>
					<input type="number" name="year" value="${tvSeriesDetails.year}">
					<br>
					<br>
					<label for="duration">Duration</label>
					<input type="number" name="duration"
						value="${tvSeriesDetails.duration}">
					<br>
					<br>
					<label for="quality">Quality</label>
					<input type="text" name="quality"
						value="${tvSeriesDetails.quality}">
					<br>
					<br>
					
					<label for="watchCount">Watch Count</label>
					<input type="number" name="watchCount" value="${tvSeriesDetails.watchCount}">
					<br>
					<br>
					<label for="streamUrl">TVSeries Stream URl</label>
					<input type="text" name="streamUrl" value="${tvSeriesDetails.tvsStreamUrl}">
					<br>
					<br>
					<label for="adminName">Created Admin Name</label>
					<input type="text" name="adminName"  value="${tvSeriesDetails.createdAdminName}">
					<br>
					<br>
									
					<input type="submit" name="action" Value="update">
				</c:forEach>
			</form>
		</c:when>

		<c:when test="${showUpdateStatus == true} ">
			<h1>"${xmessage}"</h1>
			<c:out value="${xmessage}" />
		</c:when>

		<c:otherwise>
			<c:if test="${1==1}">
				<h1>error</h1>

			</c:if>
		</c:otherwise>

	</c:choose>
</body>
</html>
