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
select,input{
    
    padding: 5px 15px 5px 15px;
}


                                h1{
	text-align: center;
	font-variant: small-caps;
	color:black;
	font-size: 200%;
        padding: 10px;
        display: block;
        background:#9e9e9ea6; 
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
        <h1>Student-Registration-Form</h1>
         
        <form action="StuRegister" method="get">
            <table class="center" border="0">
                <tr>
                    <td>Username</td><td><input type="text" name="username"/></td>
                </tr>
                <tr>
                    <td>Password</td><td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td>Department </td><td><select name="Dname"><option>CSE</option><option>MEC</option>
                            <option>EE</option><option>EC</option><option>ARG</option><option>IT</option><option>CE</option></select></td>
                </tr>
                <tr>
                    <td>Email</td><td><input type="text" name="email"/></td>
                </tr>
                <tr>
                    <td>Mobile</td><td><input type="text" name="mobile"/></td>
                </tr>
                <tr>
                    <td><input type="submit" class="button" value="Register"/><td><input type="reset" class="button" value="Reset"/></td>
                </tr>
            </table>
        </form>
        
        <div class="new">
        <a href="index.jsp">Home</a>
        </div>
    </body>
</html>
