package ServletPackage.EmployeeServletPackage;

import PureJavaPackage.DBConnection;
import ServletPackage.Exception_class;
import ServletPackage.ServletLogin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Created by Echo01 on 4/3/2017.
 */
@WebServlet(name="ServletPackage.EmployeeServletPackage.ServletInsertEmployee")
public class ServletInsertEmployee extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            insert_record(req,resp);
    }
    private void insert_record(HttpServletRequest request,HttpServletResponse response){
        String query = "INSERT INTO `dogpatch06`.`employee`(ID,Name,Job_Designation,`Subject ID`,Salary)" +
        "VALUES(?,?,?,?,?);";
        String name,Job;int ID=0,salary,subjectID;

        Connection connection = DBConnection.connect(ServletLogin.username,ServletLogin.password);
        try {
            name = request.getParameter("name");
            Job = request.getParameter("job");
            salary  = Integer.parseInt(request.getParameter("salary"));
            subjectID = Integer.parseInt(request.getParameter("subjectID"));
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `dogpatch06`.`employee`;");
            while(resultSet.next()){
                ID = Integer.parseInt(resultSet.getString("ID"));
            }
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,ID+1);preparedStatement.setString(2,name);
            preparedStatement.setString(3,Job);preparedStatement.setInt(4,subjectID);
            preparedStatement.setInt(5,salary);
            preparedStatement.executeUpdate();
            response.sendRedirect("/InsertEmployee");return;
        } catch (SQLException e) {
            Exception_class.exception_method(e,response);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 1);
            Exception_class.close_connection(connection);
        }
    }
}
