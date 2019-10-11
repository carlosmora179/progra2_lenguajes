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
public class Tienda {
    private List<Producto> inventario;

    public Tienda() {
    }

    
    public Tienda(List<Producto> inventario) {
        this.inventario = inventario;
    }

    public List<Producto> getInventario() {
        return inventario;
    }

    public void setInventario(List<Producto> inventario) {
        this.inventario = inventario;
    }
}
