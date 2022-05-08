<html>
    <head>
        <style>
             .button {
  background-color: #ffffff;
  border: none;
  color:#09eee3f2; 
  padding: 10px 15px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
input{
    
    padding: 5px 15px 5px 15px;
}

h1{
	text-align: center;
	font-variant: small-caps;
	color:#ffffff;
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

                background:#09eee3f2;        
                color:#ffffff;
            }
           html{
                    background:linear-gradient(to bottom, #332b2b 0%, #9e9e9e 100%);

            }
     
        </style>
            
    </head>
    <body>
        <h1>Faculty Update Form</h1>
         
        <form action="FacultyAccountUpdate" method="get">
            <table border="0" class="center">
                <tr>
                    <td>Username</td><td><input type="text" name="username"/></td>
                </tr>
                <tr>
                    <td>New Password</td><td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td>Address</td><td><input type="text" name="address"/></td>
                </tr>
                <tr>
                    <td>Email</td><td><input type="text" name="email"/></td>
                </tr>
                <tr>
                    <td>Mobile</td><td><input type="text" name="mobile"/></td>
                </tr>
                <tr>
                    <td><input type="submit" class="button" value="Update"/><td><input type="reset" class="button" value="Reset"/></td>
                </tr>
            </table>
        </form>
    
    </body>
</html>
