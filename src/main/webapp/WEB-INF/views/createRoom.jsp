<%--
  Created by IntelliJ IDEA.
  User: halyna
  Date: 09.07.20
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Create Room</title>
</head>
<body>
<form action="/createRoom" method="post">
    <input name="roomNumber" placeholder="room number">
    <select name="hotelId">
        <c:forEach var="hotel" items="${hotels}">
            <option value="${hotel.id}">${hotel.name}</option>
        </c:forEach>
    </select>
    <button>save</button>
</form>
</body>
</html>
