<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>

    <a href="PaymentServlet">SelectPayment Hyperlink</a>

    <form method="post" action="PaymentServlet">
        <label for="paymentId">Payment Id</label>
        <input type="text" name="paymentId">
        <input type="submit" name="submit" value="Click Here">
    </form>

    <h1>List of Payments</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Amount</th>
                <th>Payment Date</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${payments}" var="payment">
                <tr>
                    <td>${payment.amount}</td>
                    <td>${payment.rowCreatedDatetime}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
