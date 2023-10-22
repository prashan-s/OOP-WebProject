<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User Favourite List</title>
</head>
<body>

    <a href="UserFavouritesList">Select User Favourites Hyperlink</a>

    <form method="post" action="UserFavouritesServlet">
        <label for="favId">UserFavourite Id</label>
        <input type="number" name="favId">
        <input type="submit" name="submit" value="Click Here">
    </form>

    <h1>List of User Favourites</h1>
    <table border="1">
        <thead>
            <tr>
                <th>User ID</th>
                <th>Type</th>
                <th>TVSeries ID</th>
                <th>Movie ID</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${userFavouritesList}" var="userFavourites">
                <tr>
                    <td>${userFavourites.userId}</td>
                    <td>${userFavourites.type}</td>
                    <td>${userFavourites.tvsId}</td>
                    <td>${userFavourites.movieId}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
