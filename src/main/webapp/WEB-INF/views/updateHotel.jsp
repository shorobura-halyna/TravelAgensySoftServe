<%--
  Created by IntelliJ IDEA.
  User: halyna
  Date: 10.07.20
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Update Hotel</title>
</head>
<body>
<a href="/">home</a><br>

<form action="/updateHotel/${oldHotel.id}" method="post">
    <input value="${oldHotel.name}" name="name">
    <input value="${oldHotel.address}" name="address">
    <select name="countryId">
        <c:forEach var="country" items="${country}">
            <c:choose>
                <c:when test="${oldHotel.country.id == country.id}">
                    <option selected="selected" value="${country.id}">${country.name}</option>
                </c:when>
                <c:otherwise>
                    <option value="${country.id}">${country.name}</option>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </select>
    <button>save</button>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>
