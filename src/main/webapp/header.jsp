<%--
  Created by IntelliJ IDEA.
  User: gab
  Date: 12.03.18
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="resources/css/index.css" rel="stylesheet" type="text/css">
<header class="header">
    <h1 class="header_info">Welcome to the Diary service!</h1>
    <nav>
        <ul class="top_menu">
            <li><a class="active" href="/index.jsp">HOME</a></li>
            <li><a href="https://github.com/meg0man/project-diary-spring">ABOUT US</a></li>
            <li><a href="#">PARTNERS</a></li>
            <li><a href="#">CONTACTS</a></li>
            <c:if test="${sessionScope.username != null}">
                <li class="last"><a href="/logout">Logout</a></li>
            </c:if>
        </ul>
    </nav>
</header>
