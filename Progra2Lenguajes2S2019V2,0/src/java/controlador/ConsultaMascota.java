/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.ConexionDB.Borrar;
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
import modelo.Dueño;
import modelo.Mascota;

/**
 *
 * @author alece
 */
@WebServlet(name = "ConsultaMascota", urlPatterns = {"/ConsultaMascota"})
public class ConsultaMascota extends HttpServlet {

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
            out.println("<title>Servlet ConsultaMascota</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConsultaMascota at " + request.getContextPath() + "</h1>");
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
    
    public List<Integer> obtenerTelefonos(String telefonos){
        List<Integer> lista = new ArrayList<Integer>();
        String[] parseados = telefonos.split(",");
        
        for(int x = 0; x < parseados.length; x++){
            lista.add(Integer.parseInt(parseados[x]));
        }
        
        return lista;
    }
    
    public List<Dueño> consultaGeneral(){
        List<Dueño> dueños = new ArrayList<>();
        ConexionDB cn = new ConexionDB("root","123456");
        ResultSet rs2 = Consulta(cn,"select * from Mascota m inner join Dueño d on m.Dueño_idDueño = d.idDueño;");
        
        try {
            
            
            while(rs2.next()){
                
                boolean bandera = false;
                Mascota tempo = new Mascota(rs2.getInt("idMascota"), rs2.getString("tipoMascota"), 
                rs2.getString("nombre"), rs2.getDate("fechaNacimiento"), null);
                System.out.println(tempo.toString());
                if(dueños.isEmpty()){
                    Dueño temp = new Dueño(rs2.getInt("cedula"), rs2.getString(9),
                        rs2.getString("apellido1"), rs2.getString("apellido2"), rs2.getString("direccion"),
                        this.obtenerTelefonos(rs2.getString("telefonos")), null);
                    
                    temp.agregarMascota(tempo);
                    dueños.add(temp);
            
                }else{
                    for(int x = 0; x < dueños.size(); x++){
                        if(dueños.get(x).getCedula() == rs2.getInt("cedula")){
                           
                            dueños.get(x).agregarMascota(tempo);
                            bandera = true;
                      
                        }
                    }
                    
                    if(bandera == false){
                        Dueño temp = new Dueño(rs2.getInt("cedula"), rs2.getString(9),
                            rs2.getString("apellido1"), rs2.getString("apellido2"), rs2.getString("direccion"),
                            this.obtenerTelefonos(rs2.getString("telefonos")), null);
                        temp.agregarMascota(tempo);
                        dueños.add(temp);
                    }
                }  
            }
            cn.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dueños;
    }
    
    public boolean borrarMascota(Integer id){
        ConexionDB cn = new ConexionDB("root","123456");
        System.out.println(id);
        PreparedStatement pst;
        String sql = "delete from Mascota where idMascota = ?;";
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
