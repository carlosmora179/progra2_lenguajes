/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

public class Mascota implements GenerarInforme{
    private Integer idMascota;
    private String tipoMascota;
    private String nombre;
    private Date fechaNacimiento;
    private Expediente expediente;

    public Mascota() {
    }

    
    public Mascota(int idMascota, String tipoMascota, String nombre, Date fechaNacimiento, Expediente expediente) {
        this.idMascota = idMascota;
        this.tipoMascota = tipoMascota;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.expediente = expediente;
    }

    public Integer getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getTipoMascota() {
        return tipoMascota;
    }

    public void setTipoMascota(String tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    public String getNombreMascota() {
        return nombre;
    }

    public void setNombreMascota(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }   

    
    @Override
     public String toString() {
        String resultado = "";
        resultado = Integer.toString(this.getIdMascota()) + '-' + this.getTipoMascota() +
                '-' + this.getNombreMascota() + '-' + this.getFechaNacimiento().toString().replace('-', '/');
        return resultado;
    }
     
    @Override
    public String generarInforme() {
        String resultado = "";
        resultado = Integer.toString(this.getIdMascota()) + '-' + this.getTipoMascota() +
                '-' + this.getNombreMascota() + '-' + this.getFechaNacimiento().toString();
        return resultado;
    }
}
