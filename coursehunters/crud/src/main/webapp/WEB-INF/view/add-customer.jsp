<%--
  Created by IntelliJ IDEA.
  User: nick
  Date: 16.10.19
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>adding</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>create</h2>
    </div>
    <br><br>
    <div id="container">
        <form:form action="saveCustomer" modelAttribute="customer" method="POST">

            <table>
                <tbody>
                <tr>
                    <td><label>First name: </label></td>
                    <td><form:input path="firstName" placeholder="input your first name"/></td>
                </tr>
                <tr>
                    <td><label>Last name: </label></td>
                    <td><form:input path="lastName" placeholder="input your last name"/></td>
                </tr>
                <tr>
                    <td><label>Email: </label></td>
                    <td><form:input path="email" placeholder="input your email"/></td>
                </tr>
                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="create" class="create-button"/></td>
                </tr>
                </tbody>
            </table>

        </form:form>

    </div>
</div>
</body>
</html>
