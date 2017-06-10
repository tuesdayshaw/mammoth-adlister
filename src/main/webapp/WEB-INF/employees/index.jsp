<%--
  Created by IntelliJ IDEA.
  User: canidmars
  Date: 6/10/17
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Employees" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here Are all the employees!</h1>

    <c:forEach var="employee" items="${employees}">
        <div class="col-sm-3">
            <p>${employee.emp_no} ${employee.first_name} ${employee.last_name}</p>
        </div>
    </c:forEach>
</div>

</body>
</html>
