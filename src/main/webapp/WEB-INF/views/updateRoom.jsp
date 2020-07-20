<%--
  Created by IntelliJ IDEA.
  User: halyna
  Date: 10.07.20
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>UpdateRoom</title>
</head>
<body>
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="/">Home</a></li>
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
<div class="container" style="margin-top: 10%">
    <p class="h4">Update room</p>
    <br>
    <form action="/updateRoom/${oldRoom.id}" method="post">
        <div class="form-group">
            <input value="${oldRoom.roomNumber}" name="roomNumber" class="form-control" id="roomNumber"
                   placeholder="room number">
        </div>
        <div class="form-group">
            <select name="hotelId" class="form-control">
                <c:forEach var="hotel" items="${hotels}">
                    <c:choose>
                        <c:when test="${oldRoom.hotel.id == hotel.id}">
                            <option selected="selected" value="${hotel.id}">${hotel.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${hotel.id}">${hotel.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
    </form>

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
