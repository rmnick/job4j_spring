<%--
  Created by IntelliJ IDEA.
  User: nick
  Date: 16.10.19
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>updating</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>update</h2>
    </div>
    <br><br>
    <div id="container">
        <form:form action="saveCustomer" modelAttribute="customer" method="POST">

            <!-- for creating full model with all fields  -->
            <form:hidden path="id"/>

            <table>
                <tbody>
                <tr>
                    <td><label>First name: </label></td>
                    <td><form:input path="firstName"/></td>
                </tr>
                <tr>
                    <td><label>Last name: </label></td>
                    <td><form:input path="lastName"/></td>
                </tr>
                <tr>
                    <td><label>Email: </label></td>
                    <td><form:input path="email"/></td>
                </tr>
                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="update" class="save-button"/></td>
                </tr>
                </tbody>
            </table>

        </form:form>

    </div>
</div>
</body>
</html>
