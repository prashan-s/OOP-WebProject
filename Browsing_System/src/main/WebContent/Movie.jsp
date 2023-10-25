<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movie List</title>
</head>
<body>
	<c:set var="showMovieIdForm" scope="session" value="true" />

	<c:choose>
		<c:when test="${showMovieIdForm  == true}">
			<h1>List of Movies</h1>
			<form method="post" action="MovieServlet">
				<label for="movieId">Movie Id</label> <input type="number"
					name="movieId"> <input type="submit" name="action"
					value="submit">
			</form>
		</c:when>

		<c:when test="${showDetails == true}">
			<table border="1">
				<thead>
					<tr>
						<th>Title</th>
						<th>Director</th>
						<th>Release Year</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${movies}" var="movie">
						<tr>
							<td>${movie.title}</td>
							<td>${movie.director}</td>
							<td>${movie.releaseYear}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<form method="post" action="MovieServlet">
				<input type="submit" name="action" value="edit">
			</form>
		</c:when>

		<c:when test="${showEditForm == true}">
			<form method="post" action="MovieServlet">
				<c:forEach items="${movies}" var="movie">
					<label for="movieTitle">Title</label>
					<input type="text" name="movieTitle" value="${movie.title}">
					<br>
					<br>
					<label for="movieDirector">Director</label>
					<input type="text" name="movieDirector" value="${movie.director}">
					<br>
					<br>
					<label for="movieReleaseYear">Release Year</label>
					<input type="text" name="movieReleaseYear"
						value="${movie.releaseYear}">
					<br>
					<br>
					<input type="submit" name="action" value="update">
				</c:forEach>
			</form>
		</c:when>

		<c:when test="${showAddForm == true}">
			<form method="post" action="MovieServlet">

				<label for="movieTitle_i">Title</label> <input type="text"
					name="movieTitle_i"> <br> <br>
				<label for="movieDirector_i">Director</label> <input type="text"
					name="movieDirector_i" > <br> <br>
				<label for="movieReleaseYear_i">Release Year</label> <input
					type="text" name="movieReleaseYear_i" >
				<br> <br> <input type="submit" name="action"
					Value="insert">

			</form>
		</c:when>

		<c:when test="${showUpdateStatus == true}">
			<h1>${xmessage}</h1>
			<c:out value="${xmessage}" />
		</c:when>

		<c:otherwise>
			<c:if test="${1 == 1}">
				<h1>error</h1>
			</c:if>
		</c:otherwise>

	</c:choose>
</body>
</html>
