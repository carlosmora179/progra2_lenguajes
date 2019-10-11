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
public class Factura implements GenerarInforme{
    private Date fechaFactura;
    private Servicio servicio;
    private List<Compra> compras;
    private Tienda tienda;

    public Factura() {
    }

    public Factura(Date fechaFactura, Servicio servicio, List<Compra> compras, Tienda tienda) {
        this.fechaFactura = fechaFactura;
        this.servicio = servicio;
        this.compras = compras;
        this.tienda = tienda;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
    
    @Override
    public String generarInforme() {
        
        String compras = "";
        
        for(int x = 0; x < this.compras.size(); x++){
            compras += this.compras.get(x).toString() + '/';
        }
        
        String resultado = "";
        resultado = this.getFechaFactura().toString() + '-' + this.getServicio().toString() +
                '-' + compras;
        return resultado;
    }
    
}
