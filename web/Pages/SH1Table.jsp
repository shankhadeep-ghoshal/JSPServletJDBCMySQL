<%--
  Created by IntelliJ IDEA.
  User: Echo01
  Date: 4/8/2017
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <script language="JavaScript1.5" type="text/javascript" src="Scripts/SH1CleanupScript.js"></script>
</head>
<body>
    <form method="get" action="SelectTable">
        <input type="submit" value="Back">
    </form>

    <div id="TableDiv">
        <table id="SH1Table" cellspacing="6">
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Marks in Physics</th>
                <th>Marks in Chemistry</th>
                <th>Marks in Maths</th>
                <th>Physics Teacher ID</th>
                <th>Chemistry Teacher ID</th>
                <th>Maths Teacher ID</th>
                <th>Co-Ordinator ID</th>
            </tr>
            <c:forEach items="${sh1List}" var="list">
                <tr>
                    <td align="center"><c:out value="${list.id}"/></td>
                    <td><c:out value="${list.firstname}"/></td>
                    <td><c:out value="${list.lastname}"/></td>
                    <td align="center"><c:out value="${list.physics}"/></td>
                    <td align="center"><c:out value="${list.chemistry}"/></td>
                    <td align="center"><c:out value="${list.maths}"/></td>
                    <td align="center"><c:out value="${list.pti}"/></td>
                    <td align="center"><c:out value="${list.cti}"/></td>
                    <td align="center"><c:out value="${list.mti}"/></td>
                    <td align="center"><c:out value="${list.teniaid}"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div id="detDiv">
        <form method="post">
            ID:                     <input type="text" id="idField" name="idField" readonly><br>
            First Name:             <input type="text" id="fn" name="fn" disabled><br>
            Last Name:              <input type="text" id="ln" name="ln" disabled><br>
            Marks in Physics:       <input type="text" id="phy" name="phy" disabled><br>
            Marks in Chemistry:     <input type="text" id="chem" name="chem" disabled><br>
            Marks in Maths:         <input type="text" id="maths" name="maths" disabled><br>
            Physics Teacher ID:     <input type="text" id="pid" name="pid" disabled><br>
            Chemistry Teacher ID:   <input type="text" id="cid" name="cid" disabled><br>
            Maths Teacher ID:       <input type="text" id="mid" name="mid" disabled><br>
            Co-Ordinator ID:        <input type="text" id="tid" name="tid" disabled><br>
            <button formmethod="post" formaction="InsertSH1" value="Insert">Insert</button>
            <button formmethod="post" formaction="ServletSH1" id="updateBtn" value="Update" name="Button"
                    disabled>Update
            </button>
            <button formmethod="post" formaction="ServletSH1" id="del" value="Delete" name="Button" disabled>Delete
            </button>
        </form>
    </div>

    <script>move_elements();</script>
    <script>cleanup();</script>

</body>
</html>
