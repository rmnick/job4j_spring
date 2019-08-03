<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 29.07.2019
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>create</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <script src="<c:url value="/resources/js/create.js" />"></script>
    <link href="<c:url value="/resources/css/create.css" />" rel="stylesheet">
</head>
<body>
<c:if test="${text != ''}">
    <div style="min-font-size: 24">
        <c:out value="${text}"/>
    </div>
</c:if>
<div class="container">
    <form class="form-horizontal" id="mainform" method='post' action='${pageContext.request.contextPath}/create' onsubmit="return validate()">
        <div class="form-group">
            <label class="control-label col-sm-2" for="name">Name:</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" id="name" placeholder="Enter your name" name="name">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="login">Login:</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" id="login" placeholder="Enter your login" name="login">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="password">Password:</label>
            <div class="col-sm-5">
                <input type="password" class="form-control" id="password" placeholder="Enter your password" name="password">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="phone">Phone:</label>
            <div class="col-sm-2">
                <input type="text" class="form-control" id="phone" placeholder="Enter your phone" name="phone">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default" id="button">create</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>