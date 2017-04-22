package ServletPackage.SH1ServletPackage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Echo01 on 4/21/2017.
 */
public class InsertSH1 extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    private void insert_record(HttpServletRequest request,HttpServletResponse response){
        String list[] = new String[9];
        for(int i =0;i<9;i++){
            list[i]=request.getParameter(String.valueOf(i));
        }
    }
}
