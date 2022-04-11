import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.sql.*;


public class user_navigation extends HttpServlet{
    public void doGet(HttpServletRequest req , HttpServletResponse res)throws IOException , ServletException{

        int choice = Integer.parseInt(req.getParameter("choice"));
        PrintWriter out = res.getWriter();
        if(choice == 1){
            res.sendRedirect("source_destination.html");
        }
        else if(choice == 2){
            out.println("ticket_cancellation.html");
        }
        else if(choice == 3){
            out.println("ticket_status.html");
        }
        else{
            res.sendRedirect("user_options.html");
        }
        
    }
}