<%--
  Created by IntelliJ IDEA.
  User: halyna
  Date: 13.07.20
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<html>
<head>
    <title>Country</title>
</head>
<body>
<a href="/">home</a><br>
<a href="/createCountry">create country</a><br>
<c:forEach var="country" items="${country}">
    ${country.name}
    <a href="/updateCountry/${country.id}">update</a>
    <a href="/deleteCountry/${country.id}">delete</a>
    <br>
</c:forEach>
</body>
</html>
