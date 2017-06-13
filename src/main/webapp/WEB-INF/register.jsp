<%--
  Created by IntelliJ IDEA.
  User: canidmars
  Date: 6/12/17
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Register Your Account" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div>
    <h1>Sign up for an Account</h1>
    <form action="/register" method="post">
        <div class="form-group">
            <label for="username" >User Name:</label>
            <textarea id="username" name="username" class="form-control" type="text"></textarea>
        </div>
        <div class="form-group">
            <label for="email" >Email:</label>
            <textarea id="email" name="email" class="form-control" type="text"></textarea>
        </div>
        <div class="form-group">
            <label for="password" >Password:</label>
            <textarea id="password" name="password" class="form-control" type="password"></textarea>
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>
</body>
</html>
