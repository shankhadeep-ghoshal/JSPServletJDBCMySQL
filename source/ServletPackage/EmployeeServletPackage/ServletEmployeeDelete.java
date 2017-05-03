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
 * Created by Echo01 on 4/7/2017.
 */
@WebServlet(name = "ServletPackage.EmployeeServletPackage.ServletEmployeeDelete")
public class ServletEmployeeDelete extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        delete_record(req,resp);
    }

    private void delete_record(HttpServletRequest request, HttpServletResponse response){
        String query = "DELETE FROM dogpatch06.employee where ID=?";
        Connection connection = DBConnection.connect(ServletLogin.username,ServletLogin.password);
        int ID = Integer.parseInt(request.getParameter("idField"));
        try{
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1,ID);
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
