<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25.09.2019
  Time: 0:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>input</title>
</head>
<body>
<form action="/processing/processing-name" method="get">
    <input type="text" name="fieldname" placeholder="what's your name one"/>
    <input type="submit"/>
</form>
<br><br>
<form action="/processing/processing-caps-name" method="get">
    <input type="text" name="capsName" placeholder="what's your name two"/>
    <input type="submit"/>
</form>
<br><br>
<form action="/processing/processing-lower-name" method="get">
    <input type="text" name="lowerName" placeholder="what's your name three"/>
    <input type="submit"/>
</form>
</body>
</html>
