<%--
  Created by IntelliJ IDEA.
  User: halyna
  Date: 14.07.20
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>User Profile</title>
</head>
<body>
<a href="/">home</a><br>
${user.firstName} ${user.lastName} ${user.login}
<br>
<c:forEach var="booking" items="${user.bookings}">
    ${booking.room.hotel.name} ${booking.room.roomNumber} ${booking.dateFrom} ${booking.dateTo} <br>
</c:forEach>

</body>
</html>
