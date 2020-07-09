<%--
  Created by IntelliJ IDEA.
  User: halyna
  Date: 08.07.20
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Hotel</title>
</head>
<a href="/createHotel">create hotel</a>
<a href="/updateHotel">update hotel</a>
<br>
<body>
<c:forEach var="hotel" items="${hotels}">
    ${hotel} <a href="/updateHotel/${hotel.id}">update</a> <a href="/deleteHotel/${hotel.id}">delete</a><br>
</c:forEach>
</body>
</html>
