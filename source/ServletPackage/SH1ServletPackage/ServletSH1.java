package ServletPackage.SH1ServletPackage;

import PureJavaPackage.DBConnection;
import PureJavaPackage.employeeClass;
import PureJavaPackage.sh1Class;
import ServletPackage.ServletLogin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Echo01 on 4/8/2017.
 */
@WebServlet(name = "ServletPackage.SH1ServletPackage.ServletSH1")
public class ServletSH1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        show_table(req,resp);
    }

    private void show_table(HttpServletRequest request, HttpServletResponse response){
        ArrayList<sh1Class> list1 = new ArrayList<>();
        String query = "SELECT * FROM dogpatch06.SH1;";
        Connection connection = DBConnection.connect(ServletLogin.username,ServletLogin.password);
        try{
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                sh1Class obj1 = new sh1Class();
                obj1.setId(rs.getInt(1));
                obj1.setFirstname(rs.getString(2));
                obj1.setLastname(rs.getString(3));
                obj1.setPhysics(rs.getInt(4));
                obj1.setChemistry(rs.getInt(5));
                obj1.setMaths(rs.getInt(6));
                obj1.setPti(rs.getInt(7));
                obj1.setCti(rs.getInt(8));
                obj1.setMti(rs.getInt(9));
                obj1.setTeniaid(rs.getInt(10));
                list1.add(obj1);
            }
            request.setAttribute("sh1List",list1);
            request.getRequestDispatcher("/Pages/SH1Table.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            try {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
