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
public class Producto {
    private Integer idProducto;
    private String nombre;
    private String descripcion;
    private Integer stock;

    public Producto() {
    }

    
    public Producto(Integer idProducto, String nombre, String descripcion, Integer stock) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }  
    
    @Override
    public String toString() {
        String resultado = "";
        resultado = Integer.toString(this.getIdProducto()) + '-' + this.getNombre() +
                '-' + this.getDescripcion() + '-' + Integer.toString(this.getStock());
        return resultado;
    }
}
