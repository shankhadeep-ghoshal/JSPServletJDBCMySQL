<%--
  Created by IntelliJ IDEA.
  User: Echo01
  Date: 4/2/2017
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%config.getInitParameter("sel");%>
<html>
<head>
    <title>Select Table</title>
</head>
<body>
    <form method="get" action="ServletEmployee">
        <input type="submit" value="Employee">
    </form>
    <form method="get" action="ServletSH1">
        <input type="submit" value="SH1">
    </form>
</body>
</html>
