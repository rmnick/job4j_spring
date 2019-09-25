<%--
  Created by IntelliJ IDEA.
  User: nick
  Date: 25.09.19
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>student registration form</title>
</head>
<body>
<form:form action="/student/processing-text-form" modelAttribute="student">
    First name: <form:input path="firstName" placeholder="input your first name"/>
    <br><br>
    Last name: <form:input path="lastName" placeholder="input your last name"/>
    <br><br>
    Country:
    <form:select path="country">
        <form:options items="${student.countries}"/>
    </form:select>
    <br><br>
    Programming language:
    <br>
    Java <form:radiobutton path="programmingLanguage" value="Java"/>
    C# <form:radiobutton path="programmingLanguage" value="C#"/>
    Python <form:radiobutton path="programmingLanguage" value="Python"/>
    <br><br>
    Operation system:
    <br>
    Windows <form:checkbox path="operationSystem" value="Windows" checked="true"/>
    Linux <form:checkbox path="operationSystem" value="Linux"/>
    Mac OS <form:checkbox path="operationSystem" value="Mac OS"/>
    <br><br>
    <input type="submit" value="confirm">
</form:form>

</body>
</html>
