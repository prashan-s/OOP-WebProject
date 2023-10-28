<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User Favourite List</title>
</head>
<body>

    <c:set var="showUserFavIdForm" scope="session" value="true" />
    <c:set var="showAddForm" scope="session" value="false" />
    <c:set var="showEditForm" scope="session" value="false" />

    <c:if test="${showUserFavIdForm == true}">
        <h1>List of User Favourites</h1>
        <form method="post" action="UserFavouritesServlet">
            <label for="favId">UserFavourite Id</label>
            <input type="number" name="favId">
            <input type="submit" name="action" value="submit">
        </form>
        <br>
        <br>

        <form method="post" action="UserFavouritesServlet">
            <input type="submit" name="action" value="add">
        </form>
    </c:if>

    <c:if test="${showDetails == true}">
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
        <br>
        <br>

        <form method="post" action="UserFavouritesServlet">
            <input type="submit" name="action" value="edit">
        </form>
    </c:if>

    <c:if test="${showAddForm == true}">
        <h1>Add User Favourite</h1>
        <form method="post" action="UserFavouritesServlet">
            <label for="userId">User ID</label>
            <input type="text" name="userId">
            <br>
            <br>

            <label for="type">Type</label>
            <input type="text" name="type">
            <br>
            <br>

            <label for="tvsId">TVSeries ID</label>
            <input type="text" name="tvsId">
            <br>
            <br>

            <label for="movieId">Movie ID</label>
            <input type="text" name="movieId">
            <br>
            <br>

            <input type="submit" name="action" value="add">
        </form>
    </c:if>

    <c:if test="${showEditForm == true}">
        <form method="post" action="UserFavouritesServlet">
            <c:forEach items="${userFavouritesList}" var="userFavourites">
                <label for="favId">UserFavourite ID</label>
                <input type="text" name="favId" value="${userFavourites.favId}">
                <br>
                <br>

                <label for="userId">User ID</label>
                <input type="text" name="userId" value="${userFavourites.userId}">
                <br>
                <br>

                <label for="type">Type</label>
                <input type="text" name="type" value="${userFavourites.type}">
                <br>
                <br>

                <label for="tvsId">TVSeries ID</label>
                <input type="text" name="tvsId" value="${userFavourites.tvsId}">
                <br>
                <br>

                <label for="movieId">Movie ID</label>
                <input type="text" name="movieId" value="${userFavourites.movieId}">
                <br>
                <br>

                <input type="submit" name="action" value="update">
            </c:forEach>
        </form>
    </c:if>

</body>
</html>
