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
		<input type="text" name="rateId">
		<input type="submit" name="submit" value="Click Here">
	</form>
	
	<h1>List of User Favourite List</h1>

</body>
</html>