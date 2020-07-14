<%--
  Created by IntelliJ IDEA.
  User: halyna
  Date: 12.07.20
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="/registration" method="post">
    <input name="firstName" placeholder="first name">
    <input name="lastName" placeholder="last name">
    <input name="login" placeholder="login">
    <input name="password" placeholder="password">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button>sign up</button>
</form>
</body>
</html>
