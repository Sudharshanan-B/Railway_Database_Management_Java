import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.sql.*;


public class admin_navigation extends HttpServlet{
    public void doGet(HttpServletRequest req , HttpServletResponse res)throws IOException , ServletException{

        int choice = Integer.parseInt(req.getParameter("choice"));
        PrintWriter out = res.getWriter();
        if(choice == 1){
            res.sendRedirect("add_trains.html");

        }
        else{
            res.sendRedirect("admin_options.html");
        }
        
    }
}