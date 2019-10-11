/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.ConexionDB.Consulta;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Dueño;
import modelo.Factura;
import modelo.Mascota;

/**
 *
 * @author carlo
 */
public class ConsultaDuenios extends HttpServlet {

    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

    private List<Dueño> dueños = new ArrayList<Dueño>();
    
    public List<Dueño> getDueños() {
        return dueños;
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConsultaDuenios</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConsultaDuenios at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    public List<Mascota> obtenerMascotas(ConexionDB conect ,Integer dueid ) throws SQLException{
        List<Mascota> mascotas = new ArrayList<Mascota>();
                         ResultSet rst1 = Consulta(conect,"select * from Mascota where Dueño_idDueño = '"+ dueid+"'");

         while(rst1.next()){
             
             
         }
                
       return mascotas; 
    }
    public List<Integer> obtenerTelefonos(String telefonos){
        List<Integer> lista = new ArrayList<Integer>();
        String[] parseados = telefonos.split(",");
        
        for(int x = 0; x < parseados.length; x++){
            lista.add(Integer.parseInt(parseados[x]));
        }
        
        return lista;
    }
    
    public Integer obtenerId(ConexionDB conec,String nombredue) throws SQLException{
        Integer id ;
        ResultSet rst = Consulta(conec,"Select idDueño From Dueño where nombre = '"+nombredue+"'");
        
        
          id = rst.getInt("idDueño");
        
        return id;
        
    }
    
    public List<Dueño> consultaGeneral(){
    
    
    
    
    List<Factura> facturas = new ArrayList<Factura>();
        ConexionDB cn = new ConexionDB("root","123456");
        ResultSet rs2 = Consulta(cn,"select * from Dueño");
        dueños.clear();
        try {
            while(rs2.next()){
                
                Dueño tempo = new Dueño(rs2.getInt("idDueño"),rs2.getInt("cedula"), rs2.getString("nombre"), 
                rs2.getString("apellido1"), rs2.getString("apellido2"), rs2.getString("direccion"),
                this.obtenerTelefonos(rs2.getString("telefonos")),null,null);
                
                dueños.add(tempo);
                System.out.println(tempo.toString());
                
            }
            cn.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dueños;
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
