<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Ratings List</title>
</head>
<body>

	<a href="UserRatings"> Select User Ratings Hyperlink</a>
	
	<form method="post" action="UserRatingsServlet">
		<label for="rateId">User Ratings Id</label>
		<input type="number" name="rateId">
		<input type="submit" name="submit" value="Click Here">
	</form>
	
	<h1>List of User Ratings List</h1>
	  <table>
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
                    <td>${rate.tvsId }</td>
					<td>${rate.movieId}</td>
                    <td>${rate.rating }</td>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>