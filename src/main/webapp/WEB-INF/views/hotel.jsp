<%--
  Created by IntelliJ IDEA.
  User: halyna
  Date: 13.07.20
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<html>
<head>
    <title>Hotels</title>
</head>
<body>
<a href="/">home</a><br>
<sec:authorize access="hasRole('ROLE_MANAGER')">
    <a href="/createHotel">create hotel</a><br>
</sec:authorize>

<br>
<c:forEach var="hotel" items="${hotels}">
    ${hotel.id} ${hotel.name} ${hotel.address} ${hotel.country.name}
    <a href="/updateHotel/${hotel.id}">update</a>
    <a href="/deleteHotel/${hotel.id}">delete</a>
    <a href="/roomInfo/${hotel.id}">room info</a>
    <br>
</c:forEach>
</body>
</html>
