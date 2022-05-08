
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FacultyAccountUpdate extends HttpServlet {

    private PreparedStatement ps;
    private Connection con;
    
    public void init() {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ooad?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false", "root", "root");
       
        String sql = "update faculty set password=?,address=?,email=?,mobile=?,status='enable' where username=?";
        ps = con.prepareStatement(sql);
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

        PrintWriter out = response.getWriter();
        //read-the-request
        //userid&password&name&address&email&mobile
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        //process-the-request
        try {
            ps.setString(1, password);
            
            ps.setString(2, address);
            ps.setString(3, email);
            ps.setString(4, mobile);
            ps.setString(5,username);
            ps.executeUpdate();
            System.out.println("Query Executed.............");
            //provide the response
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"viewcomplain.css\">");
             out.println("</head>");

            out.println("<body>");
           
            out.println("<h1>profile updated</h1>");
           out.println("<div class=\"new\">");
            out.println("<a href=index.jsp>Login-Now</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            //e.printStackTrace();
            out.println(e);
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
