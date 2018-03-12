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
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta http-equiv="X-UA-Compatible" content="ie=edge">
      <%--<META HTTP-EQUIV="refresh" CONTENT="1">--%>
      <title>Diary Service</title>
  </head>
  <body>
  <%@include file="header.jsp"%>
    <br>
   <<br>
  <div class="container">
      <div class="login">
          <form method="post" action="login" name="Login">
              <h2>Log in</h2>
              <p>
                  <label for="loginUsername"><strong>Username</strong></label>
                  <input type="text" placeholder="Enter username" name="username" value="gab" id="loginUsername"required>
              </p>
              <p>
                  <label for="loginPassword"><strong>Password</strong></label>
                  <input type="password" placeholder="Enter Password" name="password" value="123" id="loginPassword"required>
              </p>
              <p>
                  <input type="submit" value="Login" name="login" class="button"/>
              </p>
          </form>
      </div>

      <div class="registration">
          <form method="post" action="registration" name="Registration">
              <h2>Registration</h2>
              <p>
                  <label for="regUsername"><strong>Username</strong></label>
                  <input type="text" placeholder="Enter username" name="username" id="regUsername" required>
              </p>
              <p>
                  <label for="regPassword"><strong>Password</strong></label>
                  <input type="password" placeholder="Enter Password" name="password" id="regPassword" required>
              </p>
              <p>
                  <input type="submit" value="Register" name="registration"  class="button"/>
              </p>
          </form>
      </div>
  </div>


  <%--<div class="logout">
      <form method="get" action="logout" name="Logout">
          <h2>Logout</h2>
          <input type="submit" value="Logout" name="login" id="logout"/>
      </form>
  </div>--%>

  </body>
</html>
