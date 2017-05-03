package ServletPackage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Echo01 on 4/7/2017.
 */
public class Exception_class extends HttpServlet {
    public static void exception_method(Throwable e, HttpServletResponse response) {
        try {
            response.sendError(500,e.getMessage());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    public static void close_connection(Connection connection){
        try{
            if(connection!=null)connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
