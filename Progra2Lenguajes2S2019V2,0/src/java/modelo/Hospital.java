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
public class Hospital {
    private List<Veterinario> veterinarios;
    private List<Mascota> mascotas;
    private String direccion;
    private Tienda tienda;

    public Hospital() {
    }

    
    public Hospital(List<Veterinario> veterinarios, List<Mascota> mascotas, String direccion, Tienda tienda) {
        this.veterinarios = veterinarios;
        this.mascotas = mascotas;
        this.direccion = direccion;
        this.tienda = tienda;
    }

    public List<Veterinario> getVeterinarios() {
        return veterinarios;
    }

    public void setVeterinarios(List<Veterinario> veterinarios) {
        this.veterinarios = veterinarios;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
    
    
}
