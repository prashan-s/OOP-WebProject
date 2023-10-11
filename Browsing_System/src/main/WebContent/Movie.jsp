<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<a href="MovieServlet">SelectMovie HyperLink</a>

	<form method="post" action="MovieServlet">
		<label for="movieId" >Movie Id</label>
		<input type="text" name="movieId"/>
		<input type="submit" name="submit" value="Click Here" />
	</form>
	
	<h1>List of Movies</h1>
    <table>
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
	
</body>
</html>