<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.RequestDispatcher" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
    <style>
        body {
            font-family: Arial;
            text-align: center;
            margin-top: 100px;
        }
        .link {
            display: inline-block;
            margin: 10px;
            font-weight: bold;
        }
        .logout {
            color: red;
            text-decoration: none;
        }
    </style>
</head>
<body>

<%
    String username = (String) session.getAttribute("username");

    if (username == null) {
        request.setAttribute("error", "Session expired! Please login again.");
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
        return;
    }
%>

<h2>Welcome, <%= username %>!</h2>
<p>You are successfully logged in.</p>

<a href="updatePassword.jsp" class="link">Change Password</a>
<br><br>

<a href="logout" class="logout">Logout</a>

</body>
</html>