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
import modelo.Compra;
import modelo.Dueño;
import modelo.Factura;
import modelo.Mascota;
import modelo.Producto;
import modelo.Servicio;

/**
 *
 * @author alece
 */
@WebServlet(name = "ConsultaFactura", urlPatterns = {"/ConsultaFactura"})
public class ConsultaFactura extends HttpServlet {

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
            out.println("<title>Servlet ConsultaFactura</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConsultaFactura at " + request.getContextPath() + "</h1>");
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
    
    public List<Factura> consultaGeneral(String fechaInicio, String fechaFin){
        List<Factura> lista = new ArrayList<>();
        ConexionDB cn = new ConexionDB("root","123456");
        PreparedStatement pst;
        String sql = "select f.idFactura, c.idCompra, c.fechaCompra, p.nombre, c.cantidad, (select s.nombre from Servicio  s where s.idServicio = f.Servicio_idServicio) " +
            "from  Factura f inner join Factura_has_Compra x on x.Factura_idFactura = f.idFactura\n" +
            "inner join Compra c on c.idCompra = x.Compra_idCompra inner join Producto p\n" +
            "on c.Producto_idProducto = p.idProducto where f.fechaFactura between ? and ?;";
        
        ResultSet rs2;
        
        if(fechaInicio.isEmpty()){
            fechaInicio = "1900/01/01";
        
        }
        if(fechaFin.isEmpty()){
            fechaFin = "2020/01/01";
            
        }
        
        try {
            pst = cn.con.prepareStatement(sql);
            pst.setString(1, fechaInicio);
            pst.setString(2, fechaFin);
            rs2 = pst.executeQuery();
            
            
            while(rs2.next()){
            
                Servicio servicio = new Servicio(null, rs2.getString(6));
                Factura factura = new Factura(rs2.getInt("idFactura"), rs2.getDate("fechaCompra"), servicio, null, null); 
                Producto producto = new Producto(null, rs2.getString(4), null, null);
                Compra compra = new Compra(rs2.getDate("fechaCompra"), producto, null);

                if(lista.isEmpty()){
                    factura.agregarCompra(compra);
                    lista.add(factura);
                    
                    
                }else{
                    boolean bandera = false; 
                    for(int x = 0; x < lista.size(); x++){
                        if(lista.get(x).getIdFactura().compareTo(rs2.getInt("idFactura")) == 0){
                            lista.get(x).agregarCompra(compra);
                            bandera = true;
                        }
                    }
                    
                    if(!bandera){
                        factura.agregarCompra(compra);
                        lista.add(factura);
                    }
                }
  
            }
            pst.close();
            cn.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public List<Factura> consultaEspecifica(Integer cedula){
        List<Factura> lista = new ArrayList<>();
        ConexionDB cn = new ConexionDB("root","123456");
        PreparedStatement pst;
        ResultSet rs2;
        String sql = "select f.idFactura, c.idCompra, c.fechaCompra, p.nombre, c.cantidad, (select s.nombre from Servicio  s where s.idServicio = f.Servicio_idServicio) " +
                    "from Dueño d " +
                    "inner join  Factura f " +
                    "on d.idDueño = f.Dueño_idDueño " +
                    "inner join Factura_has_Compra x " +
                    "on x.Factura_idFactura = f.idFactura " +
                    "inner join Compra c " +
                    "on c.idCompra = x.Compra_idCompra " +
                    "inner join Producto p " +
                    "on c.Producto_idProducto = p.idProducto " +
                    "where d.cedula = ?;";
        
        

        
        try {
            pst = cn.con.prepareStatement(sql);
            pst.setInt(1, cedula);
            rs2 = pst.executeQuery();
            while(rs2.next()){
            
                Servicio servicio = new Servicio(null, rs2.getString(6));
                Factura factura = new Factura(rs2.getInt("idFactura"), rs2.getDate("fechaCompra"), servicio, null, null); 
                Producto producto = new Producto(null, rs2.getString(4), null, null);
                Compra compra = new Compra(rs2.getDate("fechaCompra"), producto, null);

                if(lista.isEmpty()){
                    factura.agregarCompra(compra);
                    lista.add(factura);
                    
                    
                }else{
                    boolean bandera = false; 
                    for(int x = 0; x < lista.size(); x++){
                        if(lista.get(x).getIdFactura().compareTo(rs2.getInt("idFactura")) == 0){
                            lista.get(x).agregarCompra(compra);
                            bandera = true;
                        }
                    }
                    
                    if(!bandera){
                        factura.agregarCompra(compra);
                        lista.add(factura);
                    }
                }
  
            }
            pst.close();
            cn.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }

}
