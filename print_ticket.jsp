<%@ page language = "java" contentType="text/html; charset = UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*"%>
<%@ page import ="java.util.*"%>
<html>

    <body>
        <%
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
                String sql_query = "select * from reservation";
                ResultSet rs = myStatement.executeQuery(sql_query);
                int flag = 0;
                out.println("your ticket details are : " + "<br>");
                while(rs.next()){
                    
                    if(flag == 0){
                        
                        String train_name = rs.getString("train_name");
                        String source = rs.getString("source");
                        String destination = rs.getString("destination");
                        out.println("train name : " + train_name + "<br>");
                        out.println("source : " + source + "<br>");
                        out.println("destination : " + destination + "<br>");
                        out.println("<table border = '1' width=20% , height=10% >");
                        
                        out.println("<tr><th>pnr</th><th>name</th><th>coach</th><th>seat no</th><th>type</th></tr>");
                        flag = 1;
                    }
                    
                    int pnr = rs.getInt("pnr_no");
                    
                    String coach = rs.getString("coach");
                    int seat_no = rs.getInt("seat_no");
                    String type = rs.getString("type");
                    String name = rs.getString("name");
                    out.println("<tr><td>" + pnr + "</td><td>" + name + "</td><td>" + coach + "</td><td>" + seat_no + "</td><td>" + type + "</td></tr>");   

                    
                }
                
            }
            catch(Exception e){}
           
        %>
        
            
    </body>

</html>