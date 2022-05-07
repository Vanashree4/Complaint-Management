<%@page import="java.sql.*" %>
<%
    Class.forName("com.mysql.jdbc.Driver");
        
    String compid=request.getParameter("compid");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ooad?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false", "root", "root");
   String sql="delete from complain where compid=?";
    PreparedStatement ps=con.prepareStatement(sql);
    ps.setString(1,compid);
    ps.executeUpdate();
    
    con.close();
    
    %>
<html>
    <head>
              <style>
                        table.center{
                margin-left: auto;
                margin-right: auto;
                margin-top: 50px;
                margin-bottom: 50px;
                padding-top: 40px;
                padding-right: 40px;
                padding-bottom: 40px;
                text-align: center;
                font-size:150%;                padding-left: 40px;

                background:black;        
                color:#ffffff;
            }
        
    
div.new{
                text-align: center;
            }        
                           a:link{
                        margin-top: 20px;
        
	padding: 10px;

        text-align: center;
        display: inline-block;
        border-radius: 2px;
	color:#ffffff;
        background:black;        
        font-size: 150%;
        text-decoration: none;
       
     }
     a,a:hover, a:focus, a:active {
      text-decoration: none;
      
      color:#ffffff;
}
             
          html{
               background: url('https://previews.123rf.com/images/patpataor/patpataor1706/patpataor170600240/80995159-business-woman-showing-presentation-components-of-the-complaints-management-system-on-black-backgrou.jpg') no-repeat center center fixed; 
               -webkit-background-size: cover;
               -moz-background-size: cover;
               -o-background-size: cover;
               background-size: cover;            }
</style>  
    </head>
    <body> <table class="center" border="0">
                        <tr>
                            <td>Complaint Deleted!</td>
                        </tr>
                        
                    </table>
        
        
        
        <div class="new"> 
        <a href="facultydashboard.jsp">Faculty Dashboard</a>
        <br>
     
        </div>
        
        
    </body>
</html>
