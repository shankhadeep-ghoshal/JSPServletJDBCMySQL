<%--
  Created by IntelliJ IDEA.
  User: Echo01
  Date: 4/2/2017
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>Employee List</title>
</head>
<body>
    <table>
        <th>ID</th>
        <th>Name</th>
        <th>Job Designation</th>
        <th>Subject ID</th>
        <th>Salary</th>
        <c:forEach items="${listEmp}" var="list">
            <tr>
                <td><c:out value="${list.id}"/></td>
                <td><c:out value="${list.name}"/></td>
                <td><c:out value="${list.job}"/></td>
                <td><c:out value="${list.subjectid}"/></td>
                <td><c:out value="${list.salary}"/></td>
            </tr>
        </c:forEach>
    </table>
<form method="post" action="InsertEmployee">
    <input type="submit" value="Insert">
</form>
</body>
</html>
