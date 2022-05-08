<%
 
    String username=(String)session.getAttribute("uname");
    if(username==null){
        response.sendRedirect("index.jsp");
    }
    
%>

<html>
    <head>
        <style>
                                                          h3{
	/*text-align: center;
	font-variant: small-caps;
	font-size: 150%;
        color:#ffffff;*/
        text-align: center;
	font-variant: small-caps;
	color:black;
	font-size: 150%;
        padding: 10px;
        display: block;
        background:#9e9e9ea6; 
}

  
            div.new{
                text-align: center;
            }
                 /*   a:link{
                        margin-top: 20px;
        
	padding: 10px;

        text-align: center;
        display: inline-block;
        border-radius: 2px;
	color:#ffffff;
        background:#09eee3f2;        
        font-size: 150%;
        text-decoration: none;
       
     }*/
                   a:link{
            margin-left: 6%;
        margin-right: 7%;
	padding: 10px 70px;

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
             html{
               background: url('https://previews.123rf.com/images/patpataor/patpataor1706/patpataor170600240/80995159-business-woman-showing-presentation-components-of-the-complaints-management-system-on-black-backgrou.jpg') no-repeat center center fixed; 
               -webkit-background-size: cover;
               -moz-background-size: cover;
               -o-background-size: cover;
               background-size: cover;            }
        
            </style>

    </head>
    <body>
        <h3>Student dashboard</h3>
        
           <table class="center" border="0">
                        <tr>
                            <td>Welcome  <%=username%> !</td>
                        </tr>
                        
                    </table>
       <!-- <div class="new"> <a href="compupload.jsp">Add Complain</a>-->
        <a href="compupload.jsp">Add Complain</a>
        <a href="Complist.jsp">Previously Posted Complain</a>
        <a href ="EndSession">Logout</a>
        
       
               
    </body>
</html>