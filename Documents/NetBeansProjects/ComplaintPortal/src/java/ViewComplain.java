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
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vanashree
 */
public class ViewComplain extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Connection con;
    PreparedStatement ps;
    PreparedStatement ps1;
       PreparedStatement ps2;
       ResultSet rs2;
    public void init(){
       try{
        Class.forName("com.mysql.jdbc.Driver");
        
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ooad?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false", "root", "root");
       
        String sql = "select d.deptid from dept d,faculty f where d.hodid=f.facultyid and f.facultyid=?";
        String sql2="select studentid from student where deptid=?";
        String sql3="select c.compid,c.complain,s.username,c.sdate from complain c,student s where s.studentid=c.studentid and c.studentid=?";
        ps = con.prepareStatement(sql);
        ps1 = con.prepareStatement(sql2);
         ps2 = con.prepareStatement(sql3);
        }catch(Exception e){
            e.printStackTrace();
        }
 
    }
    public void destroy(){
          try {
            con.close();
            System.out.println("Connection Closed.............");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                    String facultyid = request.getParameter("facultyid");
                    PrintWriter out = response.getWriter();
                    try{
                        ps.setString(1,facultyid);
                      ResultSet rs=ps.executeQuery();
                      rs.next();
                      int Deptid=rs.getInt("Deptid");

                     //out.println(Deptid);
                      
                      
                      
                      ps1.setInt(1,Deptid);
                      ResultSet rs1=ps1.executeQuery();
                      //rs1.next();
                      //int Studentid=rs1.getInt("Studentid");
                      // out.println(Studentid);
                         out.println("<html>");
                         out.println("<head>");
                    out.println("<link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"viewcomplain.css\">");
                          out.println("</head>");
                              
           out.println("<body>");
           out.println("<h1>Complains</h1>");
           out.println("<table  class=\"center\">");
           
           out.println("<tr>");
           out.println("<th>Complain id</th><th>Complain</th><th>StudentName</th><th>Date</th>");
           out.println("</tr>");
                      while(rs1.next()){
                         int i=0;
                         
                         int Studentid[]=new int[50];
                       

                         Studentid[i]=rs1.getInt("Studentid");
                         ps2.setInt(1,Studentid[i]);
                         ResultSet rs2=ps2.executeQuery();
                         while(rs2.next()){
                             String compid=rs2.getString("compid");
                             
           
               String complain=rs2.getString("complain");
               String username=rs2.getString("username");
               String sdate=rs2.getString("sdate");
              
               out.println("<tr>");
               out.println("<td>"+compid+"</td>");
               out.println("<td>"+complain+"</td>");
               out.println("<td>"+username+"</td>");    
               out.println("<td>"+sdate+"</td>");
              
               out.println("</tr>");


           }
                         i++;
                      }
                      
                      
                     // ps2.setInt(1,Studentid);
                     // ResultSet rs2=ps2.executeQuery();
                    //out.println("<html>");
          // out.println("<body>");
           //out.println("<table border=3>");
           //out.println("<tr>");
          // out.println("<th>Complain</th><th>Username</th><th>Date</th>");
          // out.println("</tr>");
          /* while(rs2.next()){
               String complain=rs2.getString("complain");
               String username=rs2.getString("username");
               String sdate=rs2.getString("sdate");
         
               out.println("<tr>");
               out.println("<td>"+complain+"</td>");
               out.println("<td>"+username+"</td>");    
               out.println("<td>"+sdate+"</td>");
              
               out.println("</tr>");
           }*/
           out.println("</table>");
           out.println("<div class=new>");
            out.println("<h4><a href=facultydashboard.jsp>Faculty Dashboard</a></h4>");
            out.println("<h4><a href=deletecomp.jsp>delete complain</a></h4>");
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
