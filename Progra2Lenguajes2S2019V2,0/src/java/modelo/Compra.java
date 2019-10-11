/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author alece
 */
public class Compra {
    private Date fechaCompra;
    private Producto producto;
    private Integer cantidad;

    public Compra() {
    }

    
    public Compra(Date fechaCompra, Producto producto, Integer cantidad) {
        this.fechaCompra = fechaCompra;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    @Override
    public String toString() {
        String resultado = "";
        resultado = this.getFechaCompra().toString() + '-' + this.getProducto().toString() +
                '-' + Integer.toString(this.getCantidad());
        return resultado;
    }
}
