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

    <div id="content">

        <input type="button" value="add customer"
               onclick="window.location.href='addCustomer'; return false;"
               class="add-button">

        <table>
            <tr>
                <th>first name</th>
                <th>last name</th>
                <th>email</th>
                <th>action</th>
            </tr>
            <c:forEach var="tempCustomer" items="${customers}">

                <c:url var="urlUpdating" value="/customer/updateCustomer">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>

                <c:url var="urlDeleting" value="/customer/deleteCustomer">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>


                <tr>
                    <td>${tempCustomer.firstName}</td>
                    <td>${tempCustomer.lastName}</td>
                    <td>${tempCustomer.email}</td>
                    <td>
                        <a href="${urlUpdating}">update</a>
                    |
                        <a href="${urlDeleting}" onclick="if (!(confirm('are you sure?'))) return false;">delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>


</div>


<script src="${pageContext.request.contextPath}/resources/script/script.js"></script>

</body>
</html>
