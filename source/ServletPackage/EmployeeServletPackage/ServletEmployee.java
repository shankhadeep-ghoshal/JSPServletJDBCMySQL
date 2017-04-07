package ServletPackage.EmployeeServletPackage;

import PureJavaPackage.DBConnection;
import PureJavaPackage.employeeClass;
import ServletPackage.Exception_class;
import ServletPackage.ServletLogin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Echo01 on 4/2/2017.
 */
@WebServlet(name = "ServletPackage.EmployeeServletPackage.ServletEmployee")
public class ServletEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        show_table(request,response);
    }

    public static void show_table(HttpServletRequest request, HttpServletResponse response){
        Connection connection = DBConnection.connect(ServletLogin.username,ServletLogin.password);
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
            try {
                PrintWriter pw = response.getWriter();
                pw.println("<h3>"+e.getMessage()+"</h3>");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        request.setAttribute("listEmp",list);
        try {
            request.getRequestDispatcher("/EmployeeTable.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 1);
            Exception_class.close_connection(connection);
        }
    }
}