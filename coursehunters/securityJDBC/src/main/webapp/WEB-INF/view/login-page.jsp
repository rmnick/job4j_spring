<%--
  Created by IntelliJ IDEA.
  User: nick
  Date: 29.10.19
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>login</title>

    <style>
        .failed {
            color: red;
        }
    </style>
</head>
<body>

<h3>My custom login form</h3>

<form:form action="${pageContext.request.contextPath}/successWay" method="POST">
    <c:if test="${param.error != null}">
        <i class="failed">Sorry! You entered invalid name or password</i>
    </c:if>
    <c:if test="${param.logout != null}">
        <i>You've been logout</i>
    </c:if>
    <p>
        User:<input type="text" name="username" placeholder="your name"/>
    </p>

    <p>
        Password:<input type="password" name="password" placeholder="your password"/>
    </p>

    <%--
    manualy adding token csrf
    <input type="hidden" value="${_csrf.token}"
    name="${_csrf.parametrName}"/>
    --%>

    <input type="submit" value="login"/>
</form:form>

</body>
</html>
