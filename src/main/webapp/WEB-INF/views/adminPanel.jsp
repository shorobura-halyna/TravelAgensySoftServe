<%--
  Created by IntelliJ IDEA.
  User: halyna
  Date: 09.07.20
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Admin Index</title>
</head>
<body>
<a href="/createHotel">create hotel</a><br>
<a href="/createRoom">create room</a>
<br>
<c:forEach var="hotel" items="${hotels}">
    ${hotel.id} ${hotel.name} ${hotel.address}
    <a href="/updateHotel/${hotel.id}">update</a>
    <a href="/deleteHotel/${hotel.id}">delete</a>
    <a href="/roomInfo/${hotel.id}">room info</a>
    <br>

</c:forEach>

</body>
</html>
