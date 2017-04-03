package ServletPackage;

import PureJavaPackage.employeeClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Echo01 on 4/2/2017.
 */
@WebServlet(name = "ServletPackage.ServletEmployee")
public class ServletEmployee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        show_table(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private void show_table(HttpServletRequest request,HttpServletResponse response){
        Connection connection = ServletLogin.connection;
        String query = "SELECT * FROM `dogpatch06`.`employee`";
        ArrayList<employeeClass> list = new ArrayList<>();
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                employeeClass obj2 = new employeeClass();
                obj2.setId(rs.getInt("ID"));
                obj2.setName(rs.getString("Name"));
                obj2.setJob(rs.getString("Job_Designation"));
                obj2.setSubjectid(rs.getInt("Subject ID"));
                obj2.setSalary(rs.getInt("Salary"));
                list.add(obj2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("listEmp",list);
        try {
            request.getRequestDispatcher("/Pages/EmployeeTable.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
