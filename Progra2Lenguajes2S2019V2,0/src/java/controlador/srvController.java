/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.ConexionDB.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Dueño;

/**
 *
 * @author carlo
 */
public class srvController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException
            {
        response.setContentType("text/html;charset=UTF-8");
        ConexionDB conec = new ConexionDB("root","123456");
        
        
        if(request.getParameter("agregvet") != null){
            Insert(conec,"insert into Veterinario(cedula,nombre,apellido1,apellido2,direccion,telefonos,especialidades, Horario_idHorario) values('"+
                                request.getParameter("cedula")+"','"+request.getParameter("nombre")+"','"+request.getParameter("apll1")+"','"+request.getParameter("apll2")
                                +"','"+request.getParameter("direc")+"','"+request.getParameter("telefonos")+"','"+request.getParameter("espv")+"','"+request.getParameter("horariovet")+"')");
            response.sendRedirect("index.jsp?msg=Datos guardados");
            
            
        }
        if(request.getParameter("hagregar") != null){
            
            Insert(conec,"Insert into Horario (entrada,salida,diasSemana) values('"+request.getParameter("hentrada")+"','"+request.getParameter("hsalida")+"','"+request.getParameter("hdias")+"')");
            response.sendRedirect("agregarVeterinario.jsp?msg=Datos guardados");
            
        }
        
        if(request.getParameter("agduenio") != null){
            response.sendRedirect("agregarDuenio.jsp");
            
        }
        if(request.getParameter("dueagregar") != null){
            Insert(conec,"insert into Dueño(cedula,nombre,apellido1,apellido2,direccion,telefonos) values('"+request.getParameter("duecedula")+"','"+request.getParameter("duenombre")+"','"+request.getParameter("dueapll1")+"','"+request.getParameter("dueapll2")
                                +"','"+request.getParameter("duedirec")+"','"+request.getParameter("duetelefonos")+"')");
            
            response.sendRedirect("agregarMascota.jsp");
            
        }
        if(request.getParameter("magregar") != null){
            ConsultaDuenios duenios = new ConsultaDuenios();
            Integer iddue = duenios.obtenerId(conec, request.getParameter("duenombre"));
            
            Insert(conec,"");
            
            Insert(conec,"insert into mascota(tipoMascota, nombre, fechaNacimiento, Expediente_idExpediente,Dueño_idDueño)");
            response.sendRedirect("index.jsp");
            
        }
        
        
        conec.con.close();
       
        
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(srvController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(srvController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
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
