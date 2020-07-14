<%--
  Created by IntelliJ IDEA.
  User: halyna
  Date: 12.07.20
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/login" method="post">
    <input name="login"  placeholder="login">
    <input name="password" placeholder="password">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button>login</button>
</form>
</body>
</html>
