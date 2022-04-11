import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.sql.*;


public class admin_termination extends HttpServlet{
    public void doGet(HttpServletRequest req , HttpServletResponse res)throws IOException , ServletException{

        String str = req.getParameter("cont");
        PrintWriter out = res.getWriter();
        if(str.equals("yes")){
            res.sendRedirect("add_trains.html");

        }
        else{
            res.sendRedirect("index.html");
        }
        
    }
}