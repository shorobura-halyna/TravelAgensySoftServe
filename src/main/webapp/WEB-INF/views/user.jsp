<%--
  Created by IntelliJ IDEA.
  User: halyna
  Date: 08.07.20
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>User</title>
</head>
<body>
<a href="/">home</a><br>

<br>
<c:forEach var="user" items="${users}">
   First name: ${user.firstName} Last name: ${user.lastName} Login: ${user.login}
    <br>
    <c:forEach var="bookings" items="${user.bookings}">
        Booking: room number: ${bookings.room.roomNumber}  from: ${bookings.dateFrom}  to: ${bookings.dateTo} <br>
    </c:forEach>
    <br>
</c:forEach>
</body>
</html>
