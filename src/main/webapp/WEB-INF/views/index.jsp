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
<a href="/">home</a><br>
<sec:authentication property="name"/>
<sec:authorize access="!isAuthenticated()">
    <a href="/registration">Registration</a>
    <a href="/login">Login</a><br>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_MANAGER')">
    <a href="/country">country</a>
    <a href="/hotel">hotels</a>
    <a href="/user">user</a>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_USER')">
    <a href="/profile">profile</a>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <form action="logout" method="post">
        <button>logout</button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</sec:authorize>
<form action="/showCountryHotels" method="get">
    <select name="countryId">
        <option value="1">choose country</option>
        <c:forEach var="country" items="${countries}">
            <option value="${country.id}">${country.name}</option>
        </c:forEach>
    </select>
    <button>submit</button>
</form>


<form action="/booking" method="get">
    <select name="hotelId">
        <option value="1">choose hotel</option>
        <c:forEach var="hotel" items="${hotels}">
            <option value="${hotel.id}">${hotel.country.name} ${hotel.name}</option>
        </c:forEach>
    </select>
    <input name="dateFrom" type="date">
    <input name="dateTo" type="date">
    <button>submit</button>
</form>

<script>

</script>

</body>
</html>
