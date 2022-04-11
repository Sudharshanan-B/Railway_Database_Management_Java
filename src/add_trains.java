import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.sql.*;
import java.util.*;

public class add_trains extends HttpServlet{
    public void doGet(HttpServletRequest request , HttpServletResponse response)throws IOException , ServletException{

        String url =  "jdbc:mysql://localhost:3306/railway_database";
        String username = "root";
        String password = "sUd2808#";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConnection = DriverManager.getConnection(url, username, password);
            //System.out.println("connected Successfully");
            //create a statement object
            Statement myStatement = myConnection.createStatement();
            //execute query
            PreparedStatement st = myConnection.prepareStatement("insert into trains values (? , ? , ? , ?)");
            PreparedStatement st2 = myConnection.prepareStatement("insert into train_details values(? , ? , ? , ?)");
            PreparedStatement st3 = myConnection.prepareStatement("insert into train_details values(? , ? , ? , ?)");
            PreparedStatement st4 = myConnection.prepareStatement("insert into train_details values(? , ? , ? , ?)");
            PrintWriter out = response.getWriter();
             
            String t_name = request.getParameter("tname");
            
            int t_no = Integer.parseInt(request.getParameter("tno"));
            
            String source = request.getParameter("source");
            String destination = request.getParameter("destination");
            int no_3ac = Integer.parseInt(request.getParameter("no_3AC"));
            float fare_3AC = Float.parseFloat(request.getParameter("fare_3AC"));
            int no_2ac = Integer.parseInt(request.getParameter("no_2AC"));
            float fare_2AC = Float.parseFloat(request.getParameter("fare_2AC"));
            int no_sl = Integer.parseInt(request.getParameter("no_SL"));
            float fare_sl = Float.parseFloat(request.getParameter("fare_SL"));
           
            st.setString(1, t_name);
            st.setInt(2, t_no);
            st.setString(3, source);
            st.setString(4, destination);
                       
            st2.setString(1, "3AC");
            st2.setInt(2, no_3ac);
            st2.setFloat(3, fare_3AC);
            st2.setString(4, t_name);

            
            st3.setString(1, "2AC");
            st3.setInt(2, no_2ac);
            st3.setFloat(3, fare_2AC);
            st3.setString(4, t_name);
            
            st4.setString(1, "sl");
            st4.setInt(2, no_sl);
            st4.setFloat(3, fare_sl);
            st4.setString(4, t_name);
            
            st.executeUpdate();
            st2.executeUpdate();
            st3.executeUpdate();
            st4.executeUpdate();
            response.setContentType("text/html");
            out.println("successfully added" + "<br>");
            out.println("<form action = admin_termination>");
            out.println("do you want to add more trains : <input type = " + '"' + "text" + '"' + "name = " + '"' + "cont" + '"' + "<br>");
            out.println("<input type = submit>" );
            out.println("</form>");
            //ResultSet rs = myStatement.executeQuery(sql_query);
            
            
        }
        catch(Exception e){}
    }
}
