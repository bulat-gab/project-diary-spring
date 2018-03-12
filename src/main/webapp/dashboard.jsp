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
    <div class="content-wrapper">
        <div class="content dashboard">
            <h3>Here is your diary list: </h3>
            <ol>
                <c:forEach items="${requestScope.diaries}" var="diary">
                    <li>
                        <strong>${diary.getName()}</strong> <br>
                            ${diary.getNote()}
                    </li>
                </c:forEach>
            </ol>
        </div>

        <div class="content add_diary">
            <form method="post" action="add-diary" id="add-diary">
                <p>
                    <input type="text" placeholder="Enter a diary name" name="name" required>
                </p>
                <p>
                    <textarea rows="4" cols="50" name="note" form="add-diary" placeholder="Enter your diary here" required></textarea>
                </p>
                <p>
                    <input type="submit" name="add-diary" value="Add diary" class="button button-add-diary">
                </p>

            </form>
        </div>

        <br>

        <div class="content delete_diary">
            <form method="post" action="delete-diary">
                <p>
                    <input type="text" name="diaryToDelete" placeholder="Enter a diary name to delete" required>
                </p>
                <p>
                    <input type="submit" value="Delete diary" name="delete" class="button button-delete-diary">
                </p>
            </form>
        </div>
    </div>

</body>
</html>
