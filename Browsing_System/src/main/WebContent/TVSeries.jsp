<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>TV Series List</title>
</head>
<body>

    <a href="TVSeries">Select TV Series Hyperlink</a>
    
    <form method="post" action="TVSeriesServlet">
        <label for="tvSeriesId">TV Series Id</label>
        <input type="text" name="tvSeriesId">
        <input type="submit" name="submit" value="Click Here">
    </form>

    <h1>List of TV Series</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Title</th>
                <th>Director</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${seriesList}" var="tvSeries">
                <tr>
                    <td>${tvSeries.title}</td>
                    <td>${tvSeries.description}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
</body>
</html>
