<%--
  Created by IntelliJ IDEA.
  User: halyna
  Date: 13.07.20
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>Hotels</title>
</head>
<body>
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="/">Home</a></li>
        <sec:authorize access="hasRole('ROLE_MANAGER')">
            <li class="breadcrumb-item"><a href="/createHotel">Create hotel</a></li>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <div style="margin-left: 80%">
                <form action="logout" method="post">
                    <button class="btn btn-primary">logout</button>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </div>
        </sec:authorize>
    </ol>
</nav>
<div class="container">
    <p class="h4">Hotels</p>
    <br>
    <table class="table table-striped">
        <thead>
        <tr>
            <sec:authorize access="hasRole('ROLE_MANAGER')">
                <th scope="col">Id</th>
            </sec:authorize>
            <th scope="col">Name</th>
            <th scope="col">Address</th>
            <th scope="col">Country name</th>
            <sec:authorize access="hasRole('ROLE_MANAGER')">
                <th scope="col">Update</th>
                <th scope="col">Delete</th>
                <th scope="col">Room info</th>
            </sec:authorize>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="hotel" items="${hotels}">
            <tr>
                <th scope="row">${hotel.id}</th>
                <td>${hotel.name}</td>
                <td>${hotel.address}</td>
                <td>${hotel.country.name}</td>
                <td><a href="/updateHotel/${hotel.id}">update</a></td>
                <td><a href="/deleteHotel/${hotel.id}">delete</a></td>
                <td><a href="/roomInfo/${hotel.id}">room info</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
            integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
            crossorigin="anonymous"></script>
</div>
</body>
</html>
