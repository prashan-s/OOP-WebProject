<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TV Series List</title>
</head>
<body>

	<script>
		function confirmDelete() {
			if (confirm("Are you sure you want to delete this TV series details?")) {
				return true;
			}
			return false;
		}
	</script>

	<c:set var="showTVSeriesIdForm" scope="session" value="true" />

	<c:choose>
		<c:when test="${showTVSeriesIdForm  == true}">
			<h1>List of TV Series</h1>
			<form method="post" action="TVSeriesServlet">
				<label for="tvsId">TV Series Id</label> <input type="number"
					name="tvsId"> <input type="submit" name="action"
					value="submit">
			</form>
			<br>
			<br>

			<form method="post" action="TVSeriesServlet">
				<input type="submit" name="action" value="add">
			</form>
		</c:when>

		<c:when test="${showDetails == true}">
			<table border="1">
				<thead>
					<tr>
						<th>Title</th>
						<th>Image</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${seriesList}" var="tvSeries">
						<tr>
							<td>${tvSeries.title}</td>
							<td>${tvSeries.tvs_img_url}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<form method="post" action="TVSeriesServlet">
				<br> <br> <input type="submit" name="action" value="edit">
				<br> <br> <input type="submit" name="action"
					value="delete" onclick="return confirmDelete();">
			</form>
		</c:when>

		<c:when test="${showEditForm == true}">
			<form method="post" action="TVSeriesServlet">
				<c:forEach items="${seriesList}" var="tvSeries">

					<label for="tvSeireTitle">Title</label>
					<input type="text" name="tvSeriesTitle" value="${tvSeries.title}">
					<br>
					<br>
					<label for="tvSeriesUrl">Enter an tvSeries Image URL:</label>
					<input type="text" name="tvSeriesUrl"
						value="${tvSeries.tvs_img_url}" placeholder="https://example.com"
						required />
					<br>
					<br>
					<label for="tvSeriesCategory">Select Category</label>
					<br>
					<br>
					<label for="action_category">Action</label>
					<input type="checkbox" id="action_category"
						value="${tvSeries.action_category}" name="action_category">
					<br>

					<label for="adventure_category">Adventure</label>
					<input type="checkbox" id="adventure_category"
						value="${tvSeries.adventure_category}" name="adventure_category">
					<br>

					<label for="comedy_category">Comedy</label>
					<input type="checkbox" id="comedy_category"
						value="${tvSeries.comedy_category}" name="comedy_category">
					<br>

					<label for="scify_category">Science Fiction</label>
					<input type="checkbox" id="scify_category"
						value="${tvSeries.scify_category}" name="scify_category">
					<br>

					<label for="horror_category">Horror</label>
					<input type="checkbox" id="horror_category"
						value="${tvSeries.horror_category}" name="horror_category">
					<br>

					<label for="romance_category">Romance</label>
					<input type="checkbox" id="romance_category"
						value="${tvSeries.romance_category}" name="romance_category">
					<br>

					<label for="science_category">Science</label>
					<input type="checkbox" id="science_category"
						value="${tvSeries.science_category}" name="science_category">
					<br>

					<label for="crime_category">Crime</label>
					<input type="checkbox" id="crime_category"
						value="${tvSeries.crime_category}" name="crime_category">
					<br>

					<label for="thriller_category">Thriller</label>
					<input type="checkbox" id="thriller_category"
						value="${tvSeries.thriller_category}" name="thriller_category">
					<br>

					<input type="submit" name="action" Value="update">

				</c:forEach>
			</form>
		</c:when>

		<c:when test="${showAddForm == true}">
			<form method="post" action="TVSeriesServlet">

				<label for="tvSeriesTitle_i">Title</label> <input type="text"
					name="tvSeriesTitle_i"> <br> <br> <label
					for="tvSeriesUrl_i">Enter a TVSeries Image URL:</label> <input
					type="text" name="tvSeriesUrl_i" placeholder="https://example.com"
					required /> <br> <br> <label for="tvSeriesCategory_i">Select
					Category</label> <br> <br> <label for="action_category_i">Action</label>
				<input type="checkbox" id="action_category_i"
					name="action_category_i"> <br> <label
					for="adventure_category_i">Adventure</label> <input type="checkbox"
					id="adventure_category_i" name="adventure_category_i"> <br>

				<label for="comedy_category_i">Comedy</label> <input type="checkbox"
					id="comedy_category_i" name="comedy_category_i"> <br>

				<label for="scify_category_i">Science Fiction</label> <input
					type="checkbox" id="scify_category_i" name="scify_category_i">
				<br> <label for="horror_category_i">Horror</label> <input
					type="checkbox" id="horror_category_i" name="horror_category_i">
				<br> <label for="romance_category_i">Romance</label> <input
					type="checkbox" id="romance_category_i" name="romance_category_i">
				<br> <label for="science_category_i">Science</label> <input
					type="checkbox" id="science_category_i" name="science_category_i">
				<br> <label for="crime_category_i">Crime</label> <input
					type="checkbox" id="crime_category_i" name="crime_category_i">
				<br> <label for="thriller_category">Thriller</label> <input
					type="checkbox" id="thriller_category_i" name="thriller_category_i">
				<br> <br> <input type="submit" name="action"
					Value="insert">

			</form>
		</c:when>

		<c:when test="${showUpdateStatus == true} ">
			<h1>"${xmessage}"</h1>
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
			<c:if test="${1==1}">
				<h1>error</h1>

			</c:if>
		</c:otherwise>

	</c:choose>

</body>
</html>
