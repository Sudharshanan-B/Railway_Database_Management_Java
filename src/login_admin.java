import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.sql.*;


public class login_admin extends HttpServlet{
    public void doGet(HttpServletRequest req , HttpServletResponse res)throws IOException , ServletException{

        String s1 = req.getParameter("password");
        String s = req.getParameter("username");
        String url =  "jdbc:mysql://localhost:3306/railway_database";
        String username = "root";
        String password = "sUd2808#";
        PrintWriter out = res.getWriter();
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConnection = DriverManager.getConnection(url, username, password);
            //System.out.println("connected Successfully");
            //create a statement object
            Statement myStatement = myConnection.createStatement();
            //execute query
            String sql_query = "select * from admin where username = " + '"' + s + '"' + " and password = " + '"' + s1 + '"';
            ResultSet myResultSet = myStatement.executeQuery(sql_query);
            
            if(!myResultSet.next()){
                res.sendRedirect("login_admin.html");
            }
            else{
                res.sendRedirect("admin_options.html");
            }


            
        }
        catch(Exception e){}
       
        
    }
}