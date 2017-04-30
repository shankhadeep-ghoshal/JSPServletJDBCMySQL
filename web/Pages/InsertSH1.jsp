<%@ page import="java.util.ArrayList" %>
<%@ page import="ServletPackage.ServletLogin" %><%--
  Created by IntelliJ IDEA.
  User: Echo01
  Date: 4/8/2017
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%config.getInitParameter("ServletInsertSH1");%>
<%
    ArrayList<String> det = new ArrayList<>();
    det.add(ServletLogin.username);det.add(ServletLogin.password);
    request.setAttribute("det",det);
%>

<html>
<head>
    <title>Insert new SH1 Student</title>
</head>
<body>
    <div>
        <form method="post" action="ServletInsertSH1">
            First Name:             <input type="text" name="1"><br>
            Last Name:              <input type="text" name="2"><br>
            Physics Marks:          <input type="text" name="3"><br>
            Chemistry Marks:        <input type="text" name="4"><br>
            Maths Marks:            <input type="text" name="5"><br>
            Physics Teacher ID:     <input type="text" name="6"><br>
            Chemistry Teacher ID:   <input type="text" name="7"><br>
            Maths Teacher ID:       <input type="text" name="8"><br>
            Coordinator ID:         <input type="text" name="9"><br>
            <input type="submit" value="Insert Record"><br>
        </form>
    </div>
    <div>
        <sql:setDataSource var="url" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://db4free.net:3307/dogpatch06"
            user="${det.get(0)}" password="${det.get(1)}"/>
        <sql:query var="record" dataSource="${url}">
            SELECT ID,Name,Job_Designation,`Subject ID` FROM dogpatch06.employee WHERE `Subject ID` IS NOT NULL;
        </sql:query>
        <table align="right" cellspacing="2">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Job Designation</th>
                <th>Subject ID</th>
            </tr>
            <c:forEach var="res" items="${record.rows}">
                <tr>
                    <td><c:out value="${res.ID}"/></td>
                    <td><c:out value="${res.Name}"/></td>
                    <td><c:out value="${res.Job_Designation}"/></td>
                    <td><c:out value="${res['Subject ID']}"/></td>
                </tr>
            </c:forEach>

        </table>
    </div>

