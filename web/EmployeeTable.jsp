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
<meta HTTP-EQUIV="Pragma" content="no-cache">
<meta HTTP-EQUIV="Expires" content="-1">

<head>
    <title>Employee List</title>
    <script language="JavaScript1.5" type="text/javascript" src="Scripts/EmployeeCleanup.js"></script>
</head>
<body>
<form method="get" action="SelectTable">
    <input type="submit" value="Back">
</form>
    <table id="employeeT">
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
    <form method="post" action="ServletUpdate">
        ID:<input type="text" id="idField" name="idField" readonly><br>
        Name:<input type="text" id="nameField" name="nameField" disabled><br>
        Job Designation:<input type="text" id="jobField" name="jobField" disabled><br>
        Subject ID<input type="text" id="subjectidField" name="subjectidField" disabled><br>
        Salary:<input type="text" id="salaryField" name="salaryField" disabled><br>
        <button formmethod="post" formaction="InsertEmployee">Insert</button>
        <input type="submit" id="updateBtn" value="Update" disabled>
        <button formaction="ServletEmployeeDelete" formmethod="post" id="del" disabled>Delete</button>
    </form>
    <script type="text/javascript" language="JavaScript">
        move_elements();
    </script>
    <script type="text/javascript" language="JavaScript">
        cleanup();
    </script>
</body>
</html>