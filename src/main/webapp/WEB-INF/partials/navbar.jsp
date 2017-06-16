<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav id="backDrop" class="navbar navbar-default">
    <%--<div class="container-fluid">--%>
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a  class="navbar-brand" href="/ads">ListSpot</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <form action="/ads" method="post">
                <div class="form-inline">
                    <label for="search"></label>
                    <input id="search" name="search" class="form-control" type="text">
                    <input type="submit" value="Search" id="submit">
                </div>
            </form>
            <c:if test="${!sessionScope.isLoggedIn}">
                <li id="welcomeNav"><a href="/ads">Listings</a></li>
                <li id="welcomeNav"><a href="/login">Login</a></li>
            </c:if>
            <c:if test="${sessionScope.isLoggedIn}">
                <li id="welcomeNav"><a href="/ads">Listings</a></li>
                <li id="welcomeNav"><a href="/ads/create">Create Listing</a></li>
                <li id="welcomeNav"><a href="/profile">Profile</a></li>
                <li id="welcomeNav"><a href="/logout">Logout</a></li>
            </c:if>
        </ul>
    </div><!-- /.navbar-collapse -->
    <%--</div><!-- /.container-fluid -->--%>
</nav>
