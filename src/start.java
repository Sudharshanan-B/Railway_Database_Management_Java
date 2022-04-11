import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;


public class start extends HttpServlet{
    public void doGet(HttpServletRequest req , HttpServletResponse res)throws ServletException,IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String s = req.getParameter("checking");
        String s1 = req.getParameter("type");
        if(s.equals("no") && s1.equals("user")){   
            res.sendRedirect("signup.html");
        }

        else if(s.equals("no") && s1.equals("admin")){
            res.sendRedirect("signup_admin.html");
        }

        else if(s.equals("yes") && s1.equals("user")){
            res.sendRedirect("login.html");
        }
        else if(s.equals("yes") && s1.equals("admin")){
            res.sendRedirect("login_admin.html");
        }
        else{    
            res.sendRedirect("index.html");
        }
              
    }
}