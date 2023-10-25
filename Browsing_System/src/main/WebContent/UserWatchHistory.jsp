<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User History Page</title>
</head>
<body>
	<form method="post" action="UserServlet">
    	<label for="userId" >User Id</label>
		<input type="number" name="userId"/>
		 <input type="submit" value="WatchHistory ">
   	</form>
        <table>
        	<c:forEach items="${history}" var="history">
            <tr>
                <td>Type:</td>
                <td>${history.type}</td>
            </tr>
            <tr>
                <td>Tv Series Id:</td>
                <td>${history.tvsId}</td>
            </tr>
            <tr>
                <td>Movie Id:</td>
                <td>${history.movieId}</td>
            </tr>
            </c:forEach>
        </table>
</body>
</html>