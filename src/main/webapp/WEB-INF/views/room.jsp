<%--
  Created by IntelliJ IDEA.
  User: halyna
  Date: 09.07.20
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Room</title>
</head>
<body>
<a href="/createRoom">create room</a><br>
<a href="/adminPanel">back to admin panel</a>
<br>
<c:forEach var="room" items="${rooms}">
    ${room.id} ${room.roomNumber}
    <a href="/updateRoom/${room.id}">update</a>
    <a href="/deleteRoom/${room.hotel.id}/${room.id}">delete</a>
    <br>
</c:forEach>
</body>
</html>
