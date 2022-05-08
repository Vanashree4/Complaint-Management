
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserAuthentication1 extends HttpServlet {

     private PreparedStatement ps,ps1;
    private Connection con;
    
    public void init() {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ooad?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false", "root", "root");
        String sql = "SELECT * FROM student WHERE username=? AND password=?";
        String sql2="select * from faculty where username=? and password=?"; 
        ps = con.prepareStatement(sql);
        ps1=con.prepareStatement(sql2);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void destroy() {
        try {
            con.close();
            System.out.println("Connection Closed.............");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
            
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String usertype = request.getParameter("usertype");
        String save=request.getParameter("save");
        PrintWriter out = response.getWriter();

         if (usertype.equals("faculty")) {
                
            try{
                 ps1.setString(1, username);
                ps1.setString(2, password);
                ResultSet rs=ps1.executeQuery();
                boolean found=rs.next();    //true-rs-contains-1-row(credentials are correct,false-rs-empty-credentials are wrong
                if(found){
                    //cookie thing
                    if(save!=null)
               //cokkie maring
                {
           
                    Cookie c1=new Cookie("uname",username);
                    c1.setMaxAge(30);
                    Cookie c2=new Cookie("pwd",password);
                    c2.setMaxAge(30);
                    response.addCookie(c1);
                    response.addCookie(c2);
                        } 
                    
                          String facultyid=rs.getString("facultyid");
                    out.println(facultyid);
                    HttpSession session=request.getSession();
                    
                    session.setAttribute("facultyid",facultyid);
                    
                    //
                    session.setAttribute("uname",username);
                    String status=rs.getString("status");
                    //RequestDispatcher rd=request.getRequestDispatcher("studentdashboard.jsp");
                    //rd.forward(request, response);
                    if(status.equals("disable")){
                      response.sendRedirect("facultyprofileupdate.jsp");

                    }
                    else{
                    response.sendRedirect("facultydashboard.jsp");
                    }
                }
                else{
                    out.println("<html>");
                     out.println("<head>");
                       out.println("<link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"viewcomplain.css\">");
                      out.println("</head>");
                      out.println("<body>");
                    out.println("<h1>Invalid Faculty Account</h1>");
                    out.println("<div class=\"new\">");
                    out.println("<a href=\"index.jsp\">Try Again</a>");
                    out.println("</div>");
                    out.println("</body>");
                    out.println("</html>");
                }
               
            }
            catch(Exception e){
                out.println(e);
            }
        }
         else if (usertype.equals("student")) {
       
             
//we will match the id/pwd coming with request to credentials stored in db.
                  
            try{
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs=ps.executeQuery();
                boolean found=rs.next();    //true-rs-contains-1-row(credentials are correct,false-rs-empty-credentials are wrong
                if(found){
                    //RequestDispatcher rd=request.getRequestDispatcher("studentdashboard.jsp");
                    //rd.forward(request, response);
                    //cookie thing
                         if(save!=null)
               //cokkie maring
                {
           
                    Cookie c3=new Cookie("uname",username);
                    c3.setMaxAge(60*60*24);
                    Cookie c4=new Cookie("pwd",password);
                    c4.setMaxAge(60*60*24);
                    response.addCookie(c3);
                    response.addCookie(c4);
                        } 
                    
                    
                    
                    
                    //
                    
                       HttpSession session=request.getSession();
                    session.setAttribute("uname",username);
                    
                    //cookie thing
                  
                   
                    //
                    response.sendRedirect("studentdashboard.jsp");
                   // out.println("Welcome Student");
                }else{
                    out.println("<html>");
                     out.println("<head>");
                       out.println("<link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"viewcomplain.css\">");
                      out.println("</head>");
                      out.println("<body>");
                    out.println("<h1>Invalid Student Account</h1>");
                    out.println("<div class=\"new\">");
                    out.println("<a href=\"index.jsp\">Try Again</a>");
                    out.println("</div>");
                    out.println("</body>");
                    out.println("</html>");
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
