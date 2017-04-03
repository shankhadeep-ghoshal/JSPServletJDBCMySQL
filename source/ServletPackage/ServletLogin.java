package ServletPackage;

import PureJavaPackage.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;


/**
 * Created by Echo01 on 4/2/2017.
 */
@WebServlet(name = "ServletPackage.ServletLogin")
public class ServletLogin extends HttpServlet {
    static Connection connection = null;
    public static String username,password;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        login_method(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public void login_method(HttpServletRequest request,HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        connection = DBConnection.connect(username,password);
        if(connection!=null){
            try {
                request.getRequestDispatcher("/Pages/SelectTable.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.username=username;
            this.password=password;
        }else{
            try(PrintWriter pw = response.getWriter()){
                pw.println("<h3>Username or password wrongly typed</h3>");
                request.getRequestDispatcher("index.jsp").include(request,response);
            } catch (IOException | ServletException e1) {
                    e1.getMessage();
            }
        }
    }
}
