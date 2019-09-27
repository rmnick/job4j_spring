<%--
  Created by IntelliJ IDEA.
  User: nick
  Date: 27.09.19
  Time: 4:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Hello</title>
</head>
<body>
Hello ${customer.firstName} ${customer.lastName} your age is ${customer.age}
<br><br>
your postal code is ${customer.postalCode}
</body>
</html>
