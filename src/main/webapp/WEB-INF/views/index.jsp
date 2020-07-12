<%--
  Created by IntelliJ IDEA.
  User: halyna
  Date: 03.07.20
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Hello</title>
</head>
<body>
<a href="/adminPanel">Admin panel</a>
<a href="/registration">Registration</a>
<a href="/login">Login</a><br>

<c:forEach var="hotel" items="${hotels}">
    ${hotel.name}
    <br>
</c:forEach>
</body>
</html>
