/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.ConexionDB.Consulta;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Producto;
import modelo.Tienda;

/**
 *
 * @author alece
 */
@WebServlet(name = "ConsultaTienda", urlPatterns = {"/ConsultaTienda"})
public class ConsultaTienda extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConsultaTienda</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConsultaTienda at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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

    public Tienda consultaGeneral(){
        List<Producto> productos = new ArrayList<>();
        ConexionDB cn = new ConexionDB("root","123456");
        ResultSet rs2 = Consulta(cn,"Select * from Producto p inner join Tienda t on p.Tienda_idTienda = t.idTienda;");
        
        try {
            while(rs2.next()){
                Producto tempo = new Producto(rs2.getInt("idProducto"), rs2.getString("nombre"), 
                rs2.getString("descripcion"), rs2.getInt("stock"));
                
                productos.add(tempo);
            }
            cn.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        Tienda tienda = new Tienda(productos);
        return tienda;
    }
    
        public boolean borrarProducto(Integer id){
        ConexionDB cn = new ConexionDB("root","123456");
        System.out.println(id);
        PreparedStatement pst;
        String sql = "delete from Producto where idProducto = ?;";
       // boolean rs2 = Borrar(cn,"delete from Mascota where idMascota = ?;");
        boolean confirmacion = false;
        try {
            
            pst = cn.con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            pst.close();
            cn.con.close();
            confirmacion = true;
        } catch (SQLException ex) {
            
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            confirmacion = false;
        }
        
        return confirmacion;
    }
}
