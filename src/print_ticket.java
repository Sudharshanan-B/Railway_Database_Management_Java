import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.sql.*;
import java.util.*;


public class print_ticket extends HttpServlet{
    public void doGet(HttpServletRequest req , HttpServletResponse res)throws IOException , ServletException{

        String s = req.getParameter("checking");
        String url =  "jdbc:mysql://localhost:3306/railway_database";
        String username = "root";
        String password = "sUd2808#";
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");
        if(s.equals("yes")){
            res.sendRedirect("ticket_reservation.jsp");
        }

        else{
            res.sendRedirect("print_ticket.jsp");
            
        }
        
    
    
        
    }
}