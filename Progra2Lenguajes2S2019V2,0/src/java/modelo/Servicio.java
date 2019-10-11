/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


/**
 *
 * @author alece
 */
public class Servicio {
    private Integer idServicio;
    private String nombre;

    public Servicio() {
    }

    
    public Servicio(Integer idServicio, String nombre) {
        this.idServicio = idServicio;
        this.nombre = nombre;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        String resultado = "";
        resultado = Integer.toString(this.getIdServicio()) + '-' + this.getNombre();
        return resultado;
    }
    
}
