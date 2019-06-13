<%@ page import="java.util.List" %>
<%@ page import="ru.javawebinar.topjava.model.MealTo" %><%--
  Created by IntelliJ IDEA.
  User: Marat Metoff
  Date: 6/12/2019
  Time: 6:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   <%--lets us use core jstl - Java Standard Tag Library--%>
<jsp:useBean id="list" scope="request" type="java.util.ArrayList"/> <%--lets IDE know how to supply autocomplete suggestions for the variable--%>


<html>
<head>
    <title>Meals</title>
    <style type="text/css">
        td,th {border: 1px solid black}
        table{border-collapse: collapse}
    </style>
</head>
<body>
    <h3><a href="index.html">Home</a></h3>
    <table align="center" title="My meals">
        <tr>
            <th>Date/Time</th>
            <th>Description</th>
            <th>Calories</th>
        </tr>

        <c:forEach items="${list}" var="mealTO">
            <jsp:useBean id="mealTO" scope="page" type="ru.javawebinar.topjava.model.MealTo"/> <%--lets IDE know how to supply autocomplete suggestions for the variable--%>
            <tr>
                <td>${mealTO.dateTime.toLocalDate()} ${mealTO.dateTime.toLocalTime()}</td>
                <td>${mealTO.description}</td>
                <td>${mealTO.calories}</td>
            </tr>
        </c:forEach>
    </table>



</body>
</html>
