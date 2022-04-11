<%@ page language = "java" contentType="text/html; charset = UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*"%>
<%@ page import ="java.util.*"%>
<html>

    <body>
        <%

            String s1 = request.getParameter("destination");
            String s = request.getParameter("source");
           
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
                String sql_query = "select * from trains where source = " + "'" + s + "'" + " and destination = " + "'" + s1 + "'";
                ResultSet rs = myStatement.executeQuery(sql_query);
                int flag = 0;
                ArrayList<String> train_names = new ArrayList<String>();
                while(rs.next()){
                    flag = 1;
                    
                    String str = rs.getString("train_name");
                    train_names.add(str);
                    
                }
                if(flag == 0){
                    response.sendRedirect("source_destination.html");
                }
                
                for(String t_name : train_names){

                
                    out.println("train name : " + t_name );
                    String sql_query_2 = "select * from train_details where train_name = " +  "'" + t_name + "'"; 
                    ResultSet rs2 = myStatement.executeQuery(sql_query_2);
                    out.println("<table border = '1' width=20% , height=20% >");  
                    out.println("<tr><th>coach</th><th>number of seats</th><th>fare</th></tr>");
                    while (rs2.next()){ 
                        
                        String n = rs2.getString("coach");  
                        String nm = rs2.getString("no_of_seats");  
                        String st = rs2.getString("fare");   
                        out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + st + "</td></tr>");   
                    }
                    out.println("</table><br><br>");                            
                
                }
    
                
            }
            catch(Exception e){}
            request.getSession().setAttribute("source", s);
            request.getSession().setAttribute("destination", s1);
        %>
        <form action = "ticket_details">
            1.Enter the train name : <input type = "text" name = "t_name"><br>
            2.Enter the coach : <input type = "text" name = "coach"><br>
            3.Enter passenger name : <input type = "text" name = "p_name"><br>     
            <input type = "submit"><br>
            Note : you will redirected to the same page if you entered an invalid input<br>
        </form>
            
    </body>

</html>