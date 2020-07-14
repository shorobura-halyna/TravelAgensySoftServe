<%--
  Created by IntelliJ IDEA.
  User: halyna
  Date: 13.07.20
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Create Country</title>
</head>
<body>
<a href="/">home</a><br>

<form action="/createCountry" method="post">
    <input name="name" placeholder="name">
    <button>save</button>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>
