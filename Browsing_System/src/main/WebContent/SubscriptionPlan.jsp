<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subscription Plan List</title>
</head>
<body>

	<a href="SubscriptionPlan">Select TV Series Hyperlink</a>
    
    <form method="post" action="SubscriptionPlanServlet">
        <label for="subId">Subscription Plan Id</label>
        <input type="text" name="subId">
        <input type="submit" name="submit" value="Click Here">
    </form>

</body>
</html>