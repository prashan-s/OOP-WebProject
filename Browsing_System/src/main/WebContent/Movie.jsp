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
					<label for="movie_id">Movie ID</label>
					<input type="text" name="movie_id" value="${movie.movie_id}">
					<br>
					<br>

					<label for="title">Title</label>
					<input type="text" name="title" value="${movie.title}">
					<br>
					<br>

					<label for="description">Description</label>
					<input type="text" name="description" value="${movie.description}">
					<br>
					<br>

					<label for="year">Release Year</label>
					<input type="text" name="year" value="${movie.year}">
					<br>
					<br>

					<label for="duration">Duration</label>
					<input type="text" name="duration" value="${movie.duration}">
					<br>
					<br>

					<label for="quality">Quality</label>
					<input type="text" name="quality" value="${movie.quality}">
					<br>
					<br>

					<label for="watch_count">Watch Count</label>
					<input type="text" name="watch_count" value="${movie.watch_count}">
					<br>
					<br>

					<label for="movie_img_url">Movie Image URL</label>
					<input type="text" name="movie_img_url"
						value="${movie.movie_img_url}">
					<br>
					<br>

					<label for="movie_stream_url">Movie Stream URL</label>
					<input type="text" name="movie_stream_url"
						value="${movie.movie_stream_url}">
					<br>
					<br>

					<label for="action_category">Action Category</label>
					<input type="checkbox" name="action_category"
						${movie.action_category ? 'checked' : ''}>
					<br>
					<br>

					<label for="adventure_category">Adventure Category</label>
					<input type="checkbox" name="adventure_category"
						${movie.adventure_category ? 'checked' : ''}>
					<br>
					<br>

					<label for="comedy_category">Comedy Category</label>
					<input type="checkbox" name="comedy_category"
						${movie.comedy_category ? 'checked' : ''}>
					<br>
					<br>

					<label for="scify_category">Science Fiction Category</label>
					<input type="checkbox" name="scify_category"
						${movie.scify_category ? 'checked' : ''}>
					<br>
					<br>

					<label for="horror_category">Horror Category</label>
					<input type="checkbox" name="horror_category"
						${movie.horror_category ? 'checked' : ''}>
					<br>
					<br>

					<label for="romance_category">Romance Category</label>
					<input type="checkbox" name="romance_category"
						${movie.romance_category ? 'checked' : ''}>
					<br>
					<br>

					<label for="science_category">Science Category</label>
					<input type="checkbox" name="science_category"
						${movie.science_category ? 'checked' : ''}>
					<br>
					<br>

					<label for="crime_category">Crime Category</label>
					<input type="checkbox" name="crime_category"
						${movie.crime_category ? 'checked' : ''}>
					<br>
					<br>

					<label for="thriller_category">Thriller Category</label>
					<input type="checkbox" name="thriller_category"
						${movie.thriller_category ? 'checked' : ''}>
					<br>
					<br>


					<label for="created_admin_name">Created Admin Name</label>
					<input type="text" name="created_admin_name"
						value="${movie.created_admin_name}">
					<br>
					<br>



					<br>
					<br>
					<input type="submit" name="action" value="update">
				</c:forEach>
			</form>
		</c:when>

		<c:when test="${showAddForm == true}">
			<form method="post" action="MovieServlet">

				<label for="movie_id">Movie ID</label> <input type="text"
					name="movie_id"> <br> <br> <label for="title">Title</label>
				<input type="text" name="title"> <br> <br> <label
					for="description">Description</label> <input type="text"
					name="description"> <br> <br> <label for="year">Release
					Year</label> <input type="text" name="year"> <br> <br> <label
					for="duration">Duration</label> <input type="text" name="duration">
				<br> <br> <label for="quality">Quality</label> <input
					type="text" name="quality"> <br> <br> <label
					for="watch_count">Watch Count</label> <input type="text"
					name="watch_count"> <br> <br> <label
					for="movie_img_url">Movie Image URL</label> <input type="text"
					name="movie_img_url"> <br> <br> <label
					for="movie_stream_url">Movie Stream URL</label> <input type="text"
					name="movie_stream_url"> <br> <br> <label
					for="action_category">Action Category</label> <input
					type="checkbox" name="action_category"> <br> <br>
				<label for="adventure_category">Adventure Category</label> <input
					type="checkbox" name="adventure_category"> <br> <br>
				<label for="comedy_category">Comedy Category</label> <input
					type="checkbox" name="comedy_category"> <br> <br>
				<label for="scify_category">Science Fiction Category</label> <input
					type="checkbox" name="scify_category"> <br> <br>
				<label for="horror_category">Horror Category</label> <input
					type="checkbox" name="horror_category"> <br> <br>
				<label for="romance_category">Romance Category</label> <input
					type="checkbox" name="romance_category"> <br> <br>
				<label for="science_category">Science Category</label> <input
					type="checkbox" name="science_category"> <br> <br>
				<label for="crime_category">Crime Category</label> <input
					type="checkbox" name="crime_category"> <br> <br>
				<label for="thriller_category">Thriller Category</label> <input
					type="checkbox" name="thriller_category"> <br> <br>
				<label for="created_admin_name">Created Admin Name</label> <input
					type="text" name="created_admin_name"> <br> <br>


				<br> <br> <input type="submit" name="action"
					Value="insert">

			</form>
		</c:when>

		<c:when test="${showUpdateStatus == true}">
			<h1>${xmessage}</h1>
			<c:out value="${xmessage}" />
		</c:when>

		<c:when test="${showInsertStatus == true} ">
			<h1>"${xmessage}"</h1>
			<c:out value="${xmessage}" />
		</c:when>

		<c:when test="${showDeletetStatus == true} ">
			<h1>"${xmessage}"</h1>
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
