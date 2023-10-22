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
        <input type="number" name="tvSeriesId">
        <input type="submit" name="submit" value="Click Here">
    </form>

    <h1>List of TV Series</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Title</th>
                <th>url</th>
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
    
    <br><br>
    
    <hr>
    
    <form method="post" action="TVSeriesServlet">
    <h1>Add TV Series</h1> 
  	<label for="tvSeireTitle">Title</label>
    <input type="text" name="tvSeriesTitle"><br><br>
    <label for="tvSeriesUrl">Enter an tvSeries Image URL:</label>
	<input type="url" name="tvSeriesUrl"  placeholder="https://example.com" pattern="https://.*" size="30" required /><br><br>
	<label for="tvSeriesCategory">Select Category</label><br><br>
	  	<label for="action_category">Action</label>
        <input type="checkbox" id="action_category" name="action_category"><br>

        <label for="adventure_category">Adventure</label>
        <input type="checkbox" id="adventure_category" name="adventure_category"><br>

        <label for="comedy_category">Comedy</label>
        <input type="checkbox" id="comedy_category" name="comedy_category"><br>

        <label for="scify_category">Science Fiction</label>
        <input type="checkbox" id="scify_category" name="scify_category"><br>

        <label for="horror_category">Horror</label>
        <input type="checkbox" id="horror_category" name="horror_category"><br>

        <label for="romance_category">Romance</label>
        <input type="checkbox" id="romance_category" name="romance_category"><br>

        <label for="science_category">Science</label>
        <input type="checkbox" id="science_category" name="science_category"><br>

        <label for="crime_category">Crime</label>
        <input type="checkbox" id="crime_category" name="crime_category"><br>

        <label for="thriller_category">Thriller</label>
        <input type="checkbox" id="thriller_category" name="thriller_category"><br>
        
        <input type="submit"  name="Add" Value="Add TV Series"><hr>
	</form>
	
	
	<h1>Delete TV Series</h1>
	
</body>
</html>
