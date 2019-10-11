/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import java.util.List;

/**
 *
 * @author alece
 */
public class Tratamiento {
    private Date fechaTratamiento;
    private String descripcion;
    private Veterinario veterinario;
    private List<Compra> medicamentos;

    public Tratamiento() {
    }

    public Tratamiento(Date fechaTratamiento, String descripcion, Veterinario veterinario, List<Compra> medicamentos) {
        this.fechaTratamiento = fechaTratamiento;
        this.descripcion = descripcion;
        this.veterinario = veterinario;
        this.medicamentos = medicamentos;
    }

    public Date getFechaTratamiento() {
        return fechaTratamiento;
    }

    public void setFechaTratamiento(Date fechaTratamiento) {
        this.fechaTratamiento = fechaTratamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public List<Compra> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Compra> medicamentos) {
        this.medicamentos = medicamentos;
    }
    
    @Override
    public String toString() {
        String medicamentos = "";
        
        for(int x = 0; x < this.medicamentos.size(); x++){
            medicamentos += this.medicamentos.get(x).toString() + '/';
        }
        String resultado = "";
        resultado =  this.getDescripcion() + '-' + this.veterinario.toString() + 
                '-' + this.getFechaTratamiento().toString() + '-' + medicamentos;

        return resultado;
    }
    
}
