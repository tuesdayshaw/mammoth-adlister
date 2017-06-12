<%--
  Created by IntelliJ IDEA.
  User: canidmars
  Date: 6/10/17
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Add a new Employee" />
    </jsp:include>
</head>
<body>
<div class="container">
    <h1>Add a new Employee</h1>
    <form action="/employees/create" method="post">
        <div class="form-group">
            <label for="birth_date">Birth Date:</label>
            <input id="birth_date" name="birth_date" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="first_name" >First Name:</label>
            <textarea id="first_name" name="first_name" class="form-control" type="text"></textarea>
        </div>
        <div class="form-group">
            <label for="last_name" >Last Name:</label>
            <textarea id="last_name" name="last_name" class="form-control" type="text"></textarea>
        </div>
        <div class="form-group">
            <label for="gender" >Gender:</label>
            <textarea id="gender" name="gender" class="form-control" type="text"></textarea>
        </div>
        <div class="form-group">
            <label for="hire_date" >Hire Date:</label>
            <textarea id="hire_date" name="hire_date" class="form-control" type="text"></textarea>
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>
</body>
</html>
