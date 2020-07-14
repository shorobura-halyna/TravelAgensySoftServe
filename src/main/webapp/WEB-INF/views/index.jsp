<%--
  Created by IntelliJ IDEA.
  User: halyna
  Date: 03.07.20
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Hello</title>
</head>
<body>
<sec:authentication property="name"/>
<sec:authorize access="!isAuthenticated()">
    <a href="/registration">Registration</a>
    <a href="/login">Login</a><br>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')">
    <a href="/hotel">hotels</a>
    <a href="/country">country</a>
    <a href="/user">user</a>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <form action="logout" method="post">
        <button>logout</button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</sec:authorize>


<c:forEach var="hotel" items="${hotels}">
    ${hotel.name}
    <br>
</c:forEach>
</body>
</html>
