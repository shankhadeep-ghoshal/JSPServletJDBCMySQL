package PureJavaPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Echo01 on 4/2/2017.
 */
public class DBConnection {
    public static Connection connect(String username,String password){
        Connection connection = null;
        String url = "jdbc:mysql://db4free.net:3307/dogpatch06";
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url,username,password);
            return connection;
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e){
            return null;
        }
    }
}
