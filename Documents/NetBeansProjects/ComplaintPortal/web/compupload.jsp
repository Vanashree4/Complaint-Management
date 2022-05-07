<html>
    <head>
         <style>
            .button {
  background-color: #ffffff;
  border: none;
  color:black; 
  padding: 10px 15px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
input{
    
    padding: 5px 5px 5px 5px;
}

                                                      h3{
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
    <body>
        <form action="SaveComplainServlet" method="get">
            <h3>Upload Your Complaint</h3>
            <table class="center">
          
            <tr>
                <td>Complain</td>
                <td>
                    <textarea rows="5" cols="50" name="complain"></textarea>
                </td>
            </tr>
            
            <tr>
                <td><input type="submit" class="button" value="Add"></td>
                <td><input type="reset" class="button" value="Reset"></td>
            </tr>
            </table>
        </form>
        <div class="new">
        <a class="home" href="studentdashboard.jsp">Student Dashboard</a>
        </div>
    </body>
</html>