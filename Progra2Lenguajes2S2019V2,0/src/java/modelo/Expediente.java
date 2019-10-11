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
public class Expediente {
    private List<Tratamiento> tratamientos;
    private List<Compra> compras;

    public Expediente() {
    }

    
    public Expediente(List<Tratamiento> tratamientos, List<Compra> compras) {
        this.tratamientos = tratamientos;
        this.compras = compras;
    }

    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }
    
    public String toString() {
        String tratamientos = "";
        String compras = "";
        
        for(int x = 0; x < this.tratamientos.size(); x++){
            tratamientos += this.tratamientos.get(x).toString() + '/';
        }
        
        for(int x = 0; x < this.compras.size(); x++){
            compras += this.compras.get(x).toString() + '/';
        }
        String resultado = "";
        resultado = tratamientos + '-' + compras;
        return resultado;
    }
    
}
