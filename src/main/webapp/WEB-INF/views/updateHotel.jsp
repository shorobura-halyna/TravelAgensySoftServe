<%--
  Created by IntelliJ IDEA.
  User: halyna
  Date: 10.07.20
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Update Hotel</title>
</head>
<body>
<form action="/updateHotel/${oldHotel.id}" method="post">
    <input value="${oldHotel.name}" name="name">
    <input value="${oldHotel.address}" name="address">
    <button>save</button>
</form>
</body>
</html>
