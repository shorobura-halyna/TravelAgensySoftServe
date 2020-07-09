<%--
  Created by IntelliJ IDEA.
  User: halyna
  Date: 08.07.20
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>User</title>
</head>
<body>
<a href="/createUser">create user</a>
<a href="/updateUser">update user</a>
<br>
<c:forEach var="user" items="${users}">
    ${user} <a href="/updateUser/${user.id}">update</a> <a href="/deleteUser/${user.id}">delete</a><br>
</c:forEach>
</body>
</html>
