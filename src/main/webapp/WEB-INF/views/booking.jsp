<%--
  Created by IntelliJ IDEA.
  User: halyna
  Date: 16.07.20
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Rooms</title>
</head>
<body>
<c:forEach var="room" items="${rooms}">
    ${room}
    <sec:authorize access="isAuthenticated()">
        <a href="/bookRoom/${room.id}/${dateFrom}/${dateTo}">book room</a>
    </sec:authorize>
    <br>
</c:forEach>
</body>
</html>
