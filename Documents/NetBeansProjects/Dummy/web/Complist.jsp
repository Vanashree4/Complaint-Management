<%@page import="java.sql.*" %>

<%
 
    String username=(String)session.getAttribute("uname");
    Class.forName("com.mysql.jdbc.Driver");
        
    
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ooad?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false", "root", "root");
   String sql="select Studentid from student where username=?";
    PreparedStatement ps=con.prepareStatement(sql);
    ps.setString(1,username);
    ResultSet rs=ps.executeQuery();
    
    rs.next();
    int userid=rs.getInt("Studentid");
    
    String sql1="select compid,complain,sdate from complain where Studentid=? order by sdate";
   PreparedStatement ps1=con.prepareStatement(sql1);
   ps1.setInt(1,userid);
       ResultSet rs1=ps1.executeQuery();
       
       

    
%>


<html>
    <head>
        <style>
                                                     h1{
	text-align: center;
	font-variant: small-caps;
	color:black;
	font-size: 200%;
        padding: 10px;
        display: block;
        background:#9e9e9ea6; 
}

                     table.center{
                margin-left: auto;
                margin-right: auto;
                margin-top: 50px;
                margin-bottom: 50px;
                padding-top: 40px;
                padding-right: 40px;
                padding-bottom: 40px;
                text-align: center;
                font-size:150%;              
                padding-left: 40px;

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
    <body>
        <h1>Previously Filed Complaints</h1>
        <table class="center">
            <tr>
                <th>Complain Id</th>
                <th>Complain</th>
                <th>Sdate</th>
            </tr>
            <%
                while(rs1.next()){
                    String cid=rs1.getString(1);
                    String complain=rs1.getString(2);
                    String date=rs1.getString(3);
                

            %>
                
                <tr>
                    <td><%=cid%></td>
                    <td><%=complain%></td>
                    <td><%=date%></td>
                    
                </tr>
            <%
                    }
             %>
        </table>
        
        <div class="new">
        <a href="deletecomp1.jsp">Delete Complain</a>
        <a href="studentdashboard.jsp">student Dashboard</a>
        </div>
    </body>
</html>
