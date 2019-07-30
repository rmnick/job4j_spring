
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
    <title>messages</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link href="<c:url value="/resources/css/messages.css"/>" rel="stylesheet">
</head>
<body>

<!-- modal window -->

<div id="myModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- header -->
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <!--                <h4 class="modal-title">Sign in</h4>-->
            </div>
            <!-- body of modal window -->
            <div class="modal-body">
                <form id="form-enter" method='post' action='${pageContext.request.contextPath}/enter'>
                    <div class="form-group">
                        <label for="login">login</label>
                        <input type="text" class="form-control" maxlength="15" id="login" name="login" placeholder="enter your login">
                    </div>
                    <div class="form-group">
                        <label for="password">password</label>
                        <input type="password" class="form-control" maxlength="20" id="password" name="password" placeholder="enter your password" name="password">
                    </div>
                    <button type="submit" class="btn btn-primary">enter</button>
                </form>
            </div>
            <!-- footer -->
            <div class="modal-footer">
                <div class="row">
                    <form class="form-horizontal" id="form-reg" method='get' action='${pageContext.request.contextPath}/create'>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" id="reg" class="btn btn-primary">registration</button>                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<%--main part--%>
<c:if test="${text != ''}">
    <div style="min-font-size: 24">
        <c:out value="${text}"/>
    </div>
</c:if>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">N</th>
            <th scope="col">message</th>
            <th scope="col">author</th>
        </tr>
        </thead>
        <tbody>
<c:forEach items="${messages}" var="message">
        <tr>
            <td><c:out value="${message.id}"></c:out></td>
            <td><c:out value="${message.text}"></c:out></td>
            <td><c:out value="${message.user.name}"></c:out></td>
        </tr>
</c:forEach>
        </tbody>
    </table>
    <div class="row">
        <div>
            <div class="form-group" id="in">
                <a href="#myModal" id="signin" class="btn btn-primary" data-toggle="modal">sign in</a>
            </div>
            <div class="form-group" id="out">

            </div>
        </div>
    </div>
</div>
<%--</div>--%>
</body>
</html>
