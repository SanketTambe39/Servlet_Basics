<%--
  Created by IntelliJ IDEA.
  User: Sanket
  Date: 8/25/2021
  Time: 6:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
<h3>Hi <%= request.getAttribute("userID") %>, LogIn Done..!</h3>
<a href="login.html">Back</a>
</body>
</html>
