
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SaveComplainServlet extends HttpServlet {

    private PreparedStatement ps,ps1;
    private Connection con;
    private ResultSet rs;
    
    public void init() {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ooad?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false", "root", "root");
       String sql1="select Studentid from student where username=?";
        String sql = "INSERT INTO complain(complain,sdate,Studentid) values(?,?,?)";
        ps1=con.prepareStatement(sql1);
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
        HttpSession session=request.getSession();
                String username=(String)session.getAttribute("uname");

        String complain = request.getParameter("complain");
        
        java.util.Date dt=new java.util.Date();
        long val=dt.getTime();
        java.sql.Date sqlDate=new java.sql.Date(val);
        //process-the-request
        try {
                        ps1.setString(1,username);
                        rs=ps1.executeQuery();
            rs.next();
            int Studentid=rs.getInt("Studentid");

            
            
            ps.setString(1,complain);
            ps.setDate(2,sqlDate);
            ps.setInt(3,Studentid);
            ps.executeUpdate();
            System.out.println("Query Executed.............");
            //provide the response
            out.println("<html>");
             out.println("<head>");
              out.println("<link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"viewcomplain.css\">");
            out.println("</head>");

            out.println("<body>");
            //out.println("<h1>Complain Added Succesfully</h1>");
            out.println("<table  class=\"center\">");
           
           out.println("<tr>");
           out.println("<td>Complaint Added Sucessfully!</td>");
           out.println("</tr>");
           out.println("</table>");
            out.println("<div class=new>");
            out.println("<a href=studentdashboard.jsp>StudentDashboard</a>");
            out.println("<a href=compupload.jsp>Another Complain</a>");
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
