package ServletPackage.SH1ServletPackage;

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
 * Created by Echo01 on 4/21/2017.
 */
@WebServlet(name="ServletPackage.SH1ServletPackage.ServletInsertSH1")
public class ServletInsertSH1 extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        insert_record(req,resp);
    }
    private void insert_record(HttpServletRequest request,HttpServletResponse response){
        String list[] = new String[10];
        int x=0;
        for(int i =1;i<list.length;i++){
            list[i]=request.getParameter(String.valueOf(i));
        }
        Connection connection = DBConnection.connect(ServletLogin.username,ServletLogin.password);
        String query = "INSERT INTO `dogpatch06`.`SH1`(`ID`,`First Name`,`Last Name`,`Physics`,`Chemistry`,`Maths`,`Physics " +
                "Teacher ID" +
                "`,`Chemistry Teacher ID`,`Maths Teacher ID`,`Co-Ordinator ID`) " +
                "VALUES" +
                "(?,?,?," +
                "?," +
                "?,?,?,?," +
                "?,?);";
        try{
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM `dogpatch06`.`SH1`;");
            while(set.next()){
                x = set.getInt("ID");
            }
            x +=1;
            String ID;
            ID = Integer.toString(x);
            list[0] = ID;
            PreparedStatement pst = connection.prepareStatement(query);
            for(int i=0;i<list.length;i++){
                pst.setString(i+1,list[i]);
            }
            pst.executeUpdate();
            response.sendRedirect("/InsertSH1");
        }catch (SQLException e){
            Exception_class.exception_method(e,"/InsertSH1",response);
        } catch (IOException e) {
            Exception_class.exception_method(e,"/InsertSH1",response);
        }finally {
            Exception_class.close_connection(connection);
        }
    }
}
