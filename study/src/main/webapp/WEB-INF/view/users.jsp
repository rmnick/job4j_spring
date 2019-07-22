
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25.03.2019
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>users</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <style type="text/css">
        body {
            background-color:#C0C0C0;
        }
        .container { margin-top:20px; }
    </style>
</head>
<body>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Login</th>
            <th scope="col">Phone</th>
        </tr>
        </thead>
        <tbody>
<c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.key}"></c:out></td>
            <td><c:out value="${user.value.name}"></c:out></td>
            <td><c:out value="${user.value.login}"></c:out></td>
            <td><c:out value="${user.value.phone}"></c:out></td>
        </tr>
</c:forEach>
        </tbody>
    </table>
    <div class="row">
        <div class="col">
            <form method='get' action='${pageContext.request.contextPath}/create'>
                <button type='submit'>create user</button>
            </form>
        </div>
        <div class="col">
            <form method='get' action='${pageContext.request.contextPath}/authentication'>
                <button type='submit'>sign out</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
