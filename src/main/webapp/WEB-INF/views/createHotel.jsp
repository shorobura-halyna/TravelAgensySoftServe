<%--
  Created by IntelliJ IDEA.
  User: halyna
  Date: 08.07.20
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Create Hotel</title>
</head>
<body>
<form action="/createHotel" method="post">
    <input name="name" placeholder="name">
    <input name="address" placeholder="address">
    <button>save</button>
</form>
</body>
</html>
