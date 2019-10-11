/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexionDB {
    Connection con;
    public ConexionDB(String usuario, String pass){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://35.202.37.125:3306/Veterinaria", usuario, pass);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error: "+e);
        }
    }
    public static ResultSet Consulta(ConexionDB conex,String consulta){
        
        Statement st;
        ResultSet rs;
        ResultSet resultado = null;
        try {
            st = conex.con.createStatement();
            rs = st.executeQuery(consulta);
            
            resultado = rs;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
        
    }
    public static void Insert(ConexionDB conex,String consulta){
        
        Statement st;
        
        
        try {
            st = conex.con.createStatement();
            st.executeUpdate(consulta);
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public static void main(String[] args){
        ConexionDB cn = new ConexionDB("root","123456");
        ResultSet rs2 = Consulta(cn,"select * from Veterinario");
        
        try {
            while(rs2.next()){
                System.out.println(rs2.getInt("cedula")+" "+rs2.getString("nombre")+" "+rs2.getString("apellido1")+" "+rs2.getString("especialidades"));
            }
            cn.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
