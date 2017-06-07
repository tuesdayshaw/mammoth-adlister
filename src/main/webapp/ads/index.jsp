<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: canidmars
  Date: 6/7/17
  Time: 4:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/partials/head.jsp">
    <jsp:param name="title" value="List of Ads" />
</jsp:include>

<html>
<body>

    <jsp:include page="/partials/navbar.jsp" />
    
    <c:forEach var="ad" items="${ads}">
        <h1>${ad.id} ${ad.title}</h1>
        <p>${ad.description} ${ad.userId}</p>
    </c:forEach>

</body>
</html>
