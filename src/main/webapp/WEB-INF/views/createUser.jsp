<%--
  Created by IntelliJ IDEA.
  User: halyna
  Date: 08.07.20
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Create User</title>
</head>
<body>
<form action="/createUser" method="post">
    <input name="firstName" placeholder="first name">
    <input name="lastName" placeholder="last name">
    <button>save</button>
</form>
</body>
</html>
