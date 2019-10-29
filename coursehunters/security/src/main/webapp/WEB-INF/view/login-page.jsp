<%--
  Created by IntelliJ IDEA.
  User: nick
  Date: 29.10.19
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>login</title>
</head>
<body>

<h3>My custom login form</h3>

<form:form action="${pageContext.request.contextPath}/successWay" method="POST">
    <p>
        User:<input type="text" name="username" placeholder="your name"/>
    </p>

    <p>
        Password:<input type="password" name="password" placeholder="your password"/>
    </p>
    <input type="submit" value="login"/>
</form:form>

</body>
</html>
