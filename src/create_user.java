import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.sql.*;


public class create_user extends HttpServlet{
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
            PreparedStatement st = myConnection.prepareStatement("insert into user values(?, ?)");
            st.setString(1, s);
            st.setString(2, s1);
            st.executeUpdate();
            

            res.sendRedirect("login.html");
        }
        catch(Exception e){}
       
        
    }
}