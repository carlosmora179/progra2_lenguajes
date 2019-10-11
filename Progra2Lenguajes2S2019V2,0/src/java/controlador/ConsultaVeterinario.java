/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Especialidad;
import modelo.Veterinario;
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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alece
 */
@WebServlet(name = "ConsultaVeterinario", urlPatterns = {"/ConsultaVeterinario"})
public class ConsultaVeterinario extends HttpServlet {

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
            out.println("<title>Servlet ConsultaVeterinario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConsultaVeterinario at " + request.getContextPath() + "</h1>");
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
    
    public List<Especialidad> obtenerEspecialidades(String especialidades){
        List<Especialidad> lista = new ArrayList<Especialidad>();
        String[] parseados = especialidades.split(",");
        
        for(int x = 0; x < parseados.length; x++){
            Especialidad tempo = new Especialidad(parseados[x]);
            lista.add(tempo);
        }
        
        return lista;
    }
    
    public List<Integer> obtenerTelefonos(String telefonos){
        List<Integer> lista = new ArrayList<Integer>();
        String[] parseados = telefonos.split(",");
        
        for(int x = 0; x < parseados.length; x++){
            lista.add(Integer.parseInt(parseados[x]));
        }
        
        return lista;
    }
    
    public List<Veterinario> consultaGeneral(){
        List<Veterinario> veterinarios = new ArrayList<Veterinario>();
        ConexionDB cn = new ConexionDB("root","123456");
        ResultSet rs2 = Consulta(cn,"select * from Veterinario");
        veterinarios.clear();
        try {
            while(rs2.next()){
                Veterinario tempo = new Veterinario(rs2.getInt("cedula"), rs2.getString("nombre"), 
                rs2.getString("apellido1"), rs2.getString("apellido2"), rs2.getString("direccion"),
                this.obtenerTelefonos(rs2.getString("telefonos")), this.obtenerEspecialidades(rs2.getString("especialidades")),
                null);
                
                veterinarios.add(tempo);
                System.out.println(tempo.getNombre());
            }
            cn.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return veterinarios;
    }
    
}
