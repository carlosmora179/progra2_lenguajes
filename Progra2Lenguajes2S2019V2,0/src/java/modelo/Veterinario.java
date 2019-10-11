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
public class Veterinario extends Usuario{
    private List<Especialidad> especialidades;
    private Horario horario;

    public Veterinario() {
    }

    
    public Veterinario(int cedula, String nombre, String apellido1, String apellido2, String direccion, 
            List<Integer> telefonos, List<Especialidad> especialidades, Horario horario) {
        
        super(cedula, nombre, apellido1, apellido2, direccion, telefonos);
        this.especialidades = especialidades;
        this.horario = horario;
    }

    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    
    @Override
    public String toString() {
        String resultado = "";
        resultado = Integer.toString(this.getCedula()) + '-' + this.getNombre() +
                '-' + this.getApellido1() + '-' + this.getApellido2() + '-' +
                this.getDireccion() + '-' + this.getTelefonosToString();
  
        return resultado;
    }
    
    
    
}
