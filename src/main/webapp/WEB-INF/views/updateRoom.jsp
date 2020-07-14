<%--
  Created by IntelliJ IDEA.
  User: halyna
  Date: 10.07.20
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>UpdateRoom</title>
</head>
<body>
<a href="/">home</a><br>

<form action="/updateRoom/${oldRoom.id}" method="post">
    <input value="${oldRoom.roomNumber}" name="roomNumber" placeholder="room number">
    <select name="hotelId">
        <c:forEach var="hotel" items="${hotels}">
            <c:choose>
                <c:when test="${oldRoom.hotel.id == hotel.id}">
                    <option selected="selected" value="${hotel.id}">${hotel.name}</option>
                </c:when>
                <c:otherwise>
                    <option value="${hotel.id}">${hotel.name}</option>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </select>
    <button>save</button>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>
