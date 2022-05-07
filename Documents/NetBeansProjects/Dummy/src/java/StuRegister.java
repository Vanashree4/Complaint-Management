/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vanashree
 */
public class StuRegister extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PrintWriter out=response.getWriter();
       //username=EN18CS301285&password=123&Dname=CSE&email=aaa%40gmail.com&mobile=56789050
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String dname=request.getParameter("Dname");
        String email=request.getParameter("email");
        String mobile=request.getParameter("mobile");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ooad?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false", "root", "root");
            String sql1="select Deptid from Dept where Dname=?";  
            PreparedStatement ps=con.prepareStatement(sql1);
            ps.setString(1,dname);
            ResultSet rs=ps.executeQuery();
            rs.next();
            int Deptid=rs.getInt("Deptid");
            String sql2="INSERT INTO student(username,password,email,mobile,Deptid) values(?,?,?,?,?)";
            PreparedStatement ps1=con.prepareStatement(sql2);
            ps1.setString(1, username);
            ps1.setString(2, password);
            ps1.setString(3, email);
            ps1.setString(4, mobile);
            ps1.setInt(5,Deptid);
            ps1.executeUpdate();
          
            con.close();
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"viewcomplain.css\">");
            out.println("</head>");
            out.println("<body>");
            //out.println("<table Registration Completed</h1>");
            out.println("<table  class=\"center\">");
           
           out.println("<tr>");
           out.println("<td>Registration Completed!</td>");
           out.println("</tr>");
           out.println("</table>");
           
            out.println("<div class=\"new\">");

            out.println("<a href=index.jsp>Login-Now</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e){
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
