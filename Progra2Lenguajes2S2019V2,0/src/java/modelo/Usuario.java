/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author alece
 */
public abstract class Usuario {
    private Integer cedula;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String direccion;
    private List<Integer> telefonos;

    public Usuario() {
    }

    public Usuario(int cedula, String nombre, String apellido1, String apellido2, String direccion, List<Integer> telefonos) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.direccion = direccion;
        this.telefonos = telefonos;
    }
    
    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Integer> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Integer> telefonos) {
        this.telefonos = telefonos;
    }
    
    public String getTelefonosToString() {
        String resultado = "";
        
        for(int x = 0; x < this.telefonos.size(); x++){
            resultado = Integer.toString(this.telefonos.get(x)) + '|';
        }
        return resultado;
    }
    
}
