<%--
  Created by IntelliJ IDEA.
  User: nick
  Date: 14.10.19
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>customers</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>Customers</h2>
    </div>
</div>

<div id="container">

    <table>
        <tr>
            <th>first name</th>
            <th>last name</th>
            <th>email</th>
        </tr>
        <c:forEach var="tempCustomer" items="${customers}">
            <tr>
                <td>${tempCustomer.firstName}</td>
                <td>${tempCustomer.lastName}</td>
                <td>${tempCustomer.email}</td>
            </tr>
        </c:forEach>
    </table>

</div>

</body>
</html>
