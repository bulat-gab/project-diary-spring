<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gab
  Date: 05.03.18
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Diary</title>
    <link href="<c:url value='/resources/css/index.css' />" type="text/css" rel="stylesheet">
     </head>
  <body>
  <header>
    <div class="header">
      <h1 class="kek">Welcome to the Diary service!
      </h1>
    </div>
  </header>
  <form method="post" action="login" name="Login">
    <h2>Login</h2>
    <label for="loginUsername"><b>Username</b></label>
    <input type="text" placeholder="Enter username" name="username" value="gab" id="loginUsername"required>
    <br>
    <label for="loginPassword"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" value="123" id="loginPassword"required>
    <br>
    <label for="login">Login</label>
    <input type="submit" value="login" name="login" id="login"/>
  </form>
  <br>

  <form method="get" action="logout" name="Logout">
    <h2>Logout</h2>
    <label for="login">Logout</label>
    <input type="submit" value="logout" name="login" id="logout"/>
  </form>
  <br>

  <form method="post" action="registration" name="Registration">
    <h2>Registration</h2>
    <label for="regUsername"><b>Username</b></label>
    <input type="text" placeholder="Enter username" name="username" id="regUsername" required>
    <br>
    <label for="regPassword"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" id="regPassword" required>
    <br>
    <label for="registration">Register</label>
    <input type="submit" value="registration" name="registration" id="registration"/>
  </form>
  </body>
</html>
