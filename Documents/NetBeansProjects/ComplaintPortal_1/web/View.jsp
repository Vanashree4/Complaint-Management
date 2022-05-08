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
           /* table.center{
                margin-left: auto;
                margin-right: auto;
                margin-top: 50px;
                margin-bottom: 50px;
                padding-top: 20px;
                padding-right: 20px;
                padding-bottom: 20px;
                padding-left: 20px;
                text-align: center;
                font-size:150%;
                background:#09eee3f2;        
                color:#ffffff;
            }
            */
            a:link{
            margin-left: 7%;
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
     a,a:hover, a:focus, a:active {
      text-decoration: none;
      
      color:#ffffff;
}
             
            /*html{
                    background:linear-gradient(to bottom, #332b2b 0%, #9e9e9e 100%);

            }*/
            html{
               background: url('https://previews.123rf.com/images/patpataor/patpataor1706/patpataor170600240/80995159-business-woman-showing-presentation-components-of-the-complaints-management-system-on-black-backgrou.jpg') no-repeat center center fixed; 
               -webkit-background-size: cover;
               -moz-background-size: cover;
               -o-background-size: cover;
               background-size: cover;            }
        
        </style>
            
    </head>
    <body>
        <!--<span>  <h3>Enter id</h3></span>-->
        
        <form action="ViewComplain" method="get">
            <table  class="center" border="0">
                <tr>
                    <td>Id</td><td><input type="text" name="facultyid"/></td>
                </tr>
                
                <tr>
                    <td><input type="submit" class="button" value="Enter"/><td><input type="reset" value="Reset" class="button"/></td>
                </tr>
            </table>
        </form>
        <div class="new">  
        <a class="home" href="facultydashboard.jsp">FacultyDashboard</a>
        </div>
    </body>
</html>
