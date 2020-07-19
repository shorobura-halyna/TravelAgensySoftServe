<%--
  Created by IntelliJ IDEA.
  User: halyna
  Date: 14.07.20
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Country hotels</title>
</head>
<body>
<c:forEach var="hotel" items="${hotels}">
    ${hotel.name} ${hotel.address}
    <a href="/roomInfo/${hotel.id}">room info</a>
    <br>
</c:forEach>
</body>
</html>
