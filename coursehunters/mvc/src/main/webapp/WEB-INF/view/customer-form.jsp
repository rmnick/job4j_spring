<%--
  Created by IntelliJ IDEA.
  User: nick
  Date: 27.09.19
  Time: 4:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>customer</title>
    <style>
        .error{color:red}
    </style>
</head>
<body>
<form:form action="/customer/processing-form" modelAttribute="customer">
    First name: <form:input path="firstName" placeholder="input your first name"/>
    <br><br>
    Last name(*) : <form:input path="lastName" placeholder="input your last name"/>
    <form:errors path="lastName" cssClass="error"/>
    <br><br>
    Age(*): <form:input path="age"/>
    <form:errors path="age" cssClass="error"/>
    <br><br>
    Postal code(*): <form:input path="postalCode"/>
    <form:errors path="postalCode" cssClass="error"/>
    <br><br>
    <input type="submit" value="SUBMIT">
</form:form>
</body>
</html>
