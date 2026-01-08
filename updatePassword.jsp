<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<body>

<h2>Update Password</h2>

<form action="updatePassword" method="post">
    Username: <input type="text" name="username" required><br><br>
    New Password: <input type="password" name="newpassword" required><br><br>
    <input type="submit" value="Update Password">
</form>

<p style="color:red;">
<%= request.getAttribute("message") == null ? "" : request.getAttribute("message") %>
</p>

<a href="login.jsp">Back to Login</a>

</body>
</html>