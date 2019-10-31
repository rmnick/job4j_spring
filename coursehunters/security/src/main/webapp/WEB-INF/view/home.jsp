<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: nick
  Date: 25.10.19
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>home</title>
</head>
<body>
<h2>Home security page</h2>
<hr>
hey, dude!
<hr>
<p>
    Username: <security:authentication property="principal.username"/>
    <br>
    <br>
    Role: <security:authentication property="principal.authorities"/>
</p>
<hr>
<form:form action="${pageContext.request.contextPath}/logout">
    <input type="submit" value="logout">
</form:form>
</body>
</html>
