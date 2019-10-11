/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alece
 */
public class Dueño extends Usuario implements GenerarInforme{
    
    private List<Mascota> mascotas;
    private List<Factura> facturas;

    public Dueño() {
        super();
    }
    
    
    public Dueño(int cedula, String nombre, String apellido1, String apellido2, 
            String direccion, List<Integer> telefonos, 
            List<Factura> facturas) {
        
        super(cedula, nombre, apellido1, apellido2, direccion, telefonos);
        this.facturas = facturas;
        this.mascotas = new ArrayList<Mascota>();
    }
    
    public List<Mascota> getMascotas() {
        return mascotas;
    }
    
    public void agregarMascota(Mascota mascota){
        this.mascotas.add(mascota);
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }
    
    public void agregarFactura(Factura factura){
        this.facturas.add(factura);
    }

    @Override
    public String generarInforme() {
        String resultado = "";
        resultado = Integer.toString(this.getCedula()) + '-' + this.getNombre()
                + '-' + this.getApellido1() + '-' + this.getApellido2() + '-' +
                this.getMascotas().toString() + '-' + this.getDireccion() + '-' 
                + this.getFacturas().toString();
        return resultado;
    }
 
}
