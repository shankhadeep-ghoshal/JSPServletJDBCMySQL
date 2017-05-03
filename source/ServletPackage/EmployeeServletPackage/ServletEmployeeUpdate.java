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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Echo01 on 4/5/2017.
 */
@WebServlet(name="ServletPackage.EmployeeServletPackage.ServletEmployeeUpdate")
public class ServletEmployeeUpdate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        update_record(req,resp);
    }
    private void update_record(HttpServletRequest request, HttpServletResponse response){
        String query = "UPDATE dogpatch06.employee set Name=?,Job_Designation=?,`Subject ID`=?,Salary=? WHERE ID=?;";
        Connection connection = DBConnection.connect(ServletLogin.username,ServletLogin.password);
        try{
            int ID = Integer.parseInt(request.getParameter("idField"));
            String NAME = request.getParameter("nameField");
            String Job = request.getParameter("jobField");
            int salary  = Integer.parseInt(request.getParameter("salaryField"));
            int subjectID = Integer.parseInt(request.getParameter("subjectidField"));
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1,NAME);pst.setString(2,Job);
            pst.setInt(3,subjectID);pst.setInt(4,salary);pst.setInt(5,ID);
            pst.executeUpdate();
            response.sendRedirect("/ServletEmployee");
        } catch (SQLException e) {
            e.printStackTrace();
            Exception_class.exception_method(e,response);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Exception_class.close_connection(connection);
        }
    }
}
