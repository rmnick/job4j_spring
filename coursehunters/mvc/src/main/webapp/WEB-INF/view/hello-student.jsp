<%--
  Created by IntelliJ IDEA.
  User: nick
  Date: 25.09.19
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>hello student</title>
</head>
<body>
Hello ${student.firstName} ${student.lastName} from ${student.country}
<br><br>
your favorite programming language is ${student.programmingLanguage}
<br><br>
your using operation systems are:
<ul>
    <c:forEach var="system" items="${student.operationSystem}">
    <li>${system}</li>
    </c:forEach>
</ul>
</body>
</html>
