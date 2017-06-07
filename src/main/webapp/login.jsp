<%--
  Created by IntelliJ IDEA.
  User: canidmars
  Date: 6/7/17
  Time: 9:09 AM
  To change this template use File | Settings | File Templates.

  Assignment:
When a user visits /login.jsp, they should see a form for logging in

This form should have a 'username' and 'password' field.

This form should submit a POST request to /login

If the username submitted is "admin", and the password is "password", redirect the user to the profile page, otherwise,
redirect back to the login form.

We will give our site's login page much more robust functionality in future lessons.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%!
    String username = "admin";
    String password = "password";
%>

<% request.setAttribute("username", username); %>
<% request.setAttribute("password", password); %>

<c:if test="${param.username == username && param.password == password}">
    <c:redirect url="/profile.jsp"></c:redirect>
</c:if>

<html>
<head>
    <title>Login</title>
</head>
<body>

    <h2 class="fancy-header">User Login</h2>

    <form class="form-control" method="POST" action="/login.jsp">

        <label for="username">Username</label>
        <input id="username" type="text" name="username" placeholder="username">
        <br>

        <label for="password">Password</label>
        <input id="password" type="password" name="password" placeholder="password">
        <br>

        <input type="submit" name="submit" value="Login">
    </form>

</body>
</html>
