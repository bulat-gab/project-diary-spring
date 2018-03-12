<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gab
  Date: 06.03.18
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<%
    String username = (String) session.getAttribute("username");
    DiaryService diaryService = new DiaryServiceImpl() ;
    List<Diary> diaries = diaryService.getAllDiariesByUserName(username);
%>--%>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
<%@include file="header.jsp"%>
    <header>
        <h1>Greetings, ${sessionScope.username}</h1>
    </header>

    <div class="dashboard">
        <h3>Here is your diary list: </h3>
        <ul>
        <c:forEach items="${requestScope.diaries}" var="diary">
            <li>
                    <strong>${diary.getName()}</strong> <br>
                    ${diary.getNote()}
            </li>
        </c:forEach>
        </ul>
    </div>

    <div class="add_diary">
        <form method="post" action="add-diary" id="add-diary">
            <input type="text" placeholder="Enter a diary name" name="name" required>
            <input type="submit" name="add-diary" value="Add diary" class="button button-add-diary">
            <textarea rows="4" cols="50" name="note" form="add-diary" placeholder="Enter your diary here" required></textarea>
        </form>
         </div>

    <br>

    <div class="delete_diary">
        <form method="post" action="delete-diary">
            <label></label>
            <input type="text" name="diaryToDelete" placeholder="Enter a diary name to delete" required>
            <input type="submit" value="Delete diary" name="delete" class="button button-delete-diary">
        </form>
    </div>
</body>
</html>
