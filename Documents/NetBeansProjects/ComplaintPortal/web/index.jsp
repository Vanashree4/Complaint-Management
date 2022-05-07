<%
    
     //reading cookies
    //step-1    (fetch all cookies coming with request)
    Cookie ck[]=request.getCookies();
    //step-2    (search for desired one)
    //searching for 2 cookies (id,pw)
    String v1="",v2="";
    
    if(ck!=null)
        for(Cookie c:ck){
            String name=c.getName();
            if(name.equals("uname")){
                v1=c.getValue();
            }else if(name.equals("pwd")){
                v2=c.getValue();
            }
        }
    
    
    
    
    
%>
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
        nav a:link{
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
        
	<header>
		<h1>Complaint Management Portal</h1>
		<nav>
			<a href="aboutus.jsp">About</a>
			<a href="contactus.jsp">Contact Us</a>
	                <a href="StudentRegi.jsp">New-Student-Registration</a>	
		</nav>
	</header>
        

        <form action="UserAuthentication1" method="get">
            <table class="center" border="0">
                <tr>
                    <td>Username</td><td><input type="text" name="username" value="<%=v1%>"/></td>
                </tr>
                <tr>
                    <td>Password</td><td><input type="password" name="password"value="<%=v2%>" /></td>
                </tr>
                <tr>
                    <td>Usertype</td><td><select name="usertype"><option>faculty</option><option>student</option></select></td>
                </tr>
                <tr>
                    <td>Save Password</td><td><input type="checkbox" name="save" value="yes"/></td>
                </tr>
                <tr>
                    <td><input type="submit" class="button" value="Login"/><td><input type="reset" class="button" value="Reset"/></td>
                </tr>
            </table>
        </form>
        
        
    </body>
</html>
