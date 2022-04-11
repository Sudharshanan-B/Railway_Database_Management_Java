import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.sql.*;
import java.util.*;


public class passenger_details extends HttpServlet{
    public void doGet(HttpServletRequest req , HttpServletResponse res)throws IOException , ServletException{

        String s1 = req.getParameter("t_name");
        String s = req.getParameter("coach");
        String s2 = req.getParameter("p_name");
        String url =  "jdbc:mysql://localhost:3306/railway_database";
        String username = "root";
        String password = "sUd2808#";
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");
        
        try{
            
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConnection = DriverManager.getConnection(url, username, password);
            //System.out.println("connected Successfully");
            //create a statement object
            Statement myStatement = myConnection.createStatement();
            //execute query
            PreparedStatement st = myConnection.prepareStatement("insert into reservation values(?,?,?,?,?,?,?,?)"); 
           
            Random rn = new Random();
            int pnr = rn.nextInt(100) ;
            
            st.setInt(1,pnr);
            st.setString(2,s1);
     
            String source = String.valueOf(req.getSession().getAttribute("source"));
            String destination = String.valueOf(req.getSession().getAttribute("destination"));
            st.setString(3, source);
            st.setString(4, destination);
            st.setString(5, s2);
            st.setString(6, s);
            String sql_query = "select train_details.no_of_seats from train_details inner join trains on trains.train_name = train_details.train_name where trains.source = " + "'" + source + "'" + "and trains.destination = " + "'" + destination + "'" + "and train_details.coach = " + "'" + s + "'" + "and trains.train_name = " + "'" + s1 + "'";;
            
            
            ResultSet rs = myStatement.executeQuery(sql_query);
            String type;
            if(!rs.next()){
                res.sendRedirect("ticket_reservation.jsp");
            }
            int seat_no = Integer.parseInt(rs.getString("no_of_seats"));
            if(seat_no > 0){
                st.setInt(7 , seat_no);
                type = "confirm";
            }
            else{
                st.setInt(7 , seat_no - 1);
                type = "Wait List";
            }
            
            st.setString(8 , type);
            st.executeUpdate();
            Statement st2 = myConnection.createStatement();
            String sql_query2 = "update train_details set no_of_seats = (no_of_seats - 1) where train_details.coach = " + "'" + s + "'" + " and train_details.train_name = " + "'" + s1 + "'";
            st2.executeUpdate(sql_query2);

            res.sendRedirect("continue.html");

            
        

            
        }
        catch(Exception e){}
        
    
        
    }
}