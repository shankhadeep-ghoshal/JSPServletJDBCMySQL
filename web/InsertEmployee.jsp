<%@ page import="java.sql.Connection" %>
<%@ page import="PureJavaPackage.DBConnection" %>
<%@ page import="ServletPackage.ServletLogin" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: Echo01
  Date: 4/3/2017
  Time: 01:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%config.getInitParameter("Ins");%>
<html>
<head>
    <title>Insert Employee Record</title>
</head>
<body>
<h3>Please leave subjectid empty if the concerned personnel isn't a teacher</h3>
    <form action="ServletEmployee" method="get">
        <input type="submit" value="Back">
    </form>
    <div>
        <form action="ServletInsertEmployee" method="post">
            Name: <input type="text" name="name"><br>
            Job Designation: <input type="text" name="job"><br>
            Subject ID: <input type="text" name="subjectID"><br>
            Salary: <input type="text" name="salary"><br>
            <input type="submit" value="Submit">
        </form>
    </div>
    <div align="right">
        <h3>Course list</h3>
        <%
            Connection connection = DBConnection.connect(ServletLogin.username,ServletLogin.password);
            try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `dogpatch06`.`Subjects Taught`");
        %>
        <table>
            <th>ID</th>
            <th>Subject Name</th>
            <% while (resultSet.next()){%>
            <tr>
                <td><%=resultSet.getString(1)%></td>
                <td><%=resultSet.getString(2)%></td>
            </tr>
            <%}%>
            <%
                }catch (SQLException e){

                }finally {
                    try{
                        if(connection!=null) {
                            connection.close();
                        }
                    }catch (SQLException e){

                    }
                }
            %>
        </table>
    </div>
</body>
</html>
