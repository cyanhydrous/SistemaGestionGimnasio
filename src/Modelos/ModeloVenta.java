/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.time.LocalDate;

/**
 *
 * @author phantomcide
 */
public class ModeloVenta {
    String idventa;
    ModeloProducto producto;
    LocalDate fechaventa;

    public ModeloVenta() {
    }

    public ModeloVenta(String idventa, ModeloProducto producto, LocalDate fechaventa) {
        this.idventa = idventa;
        this.producto = producto;
        this.fechaventa = fechaventa;
    }

    public ModeloVenta(String idventa, LocalDate fechaventa, String idproducto) {
        this.idventa = idventa;
        producto = new ModeloProducto();
        producto.setIdproducto(idproducto);
        this.fechaventa = fechaventa;
    }

    public String getIdventa() {
        return idventa;
    }

    public void setIdventa(String idventa) {
        this.idventa = idventa;
    }

    public ModeloProducto getProducto() {
        return producto;
    }

    public void setProducto(ModeloProducto producto) {
        this.producto = producto;
    }

    public LocalDate getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(LocalDate fechaventa) {
        this.fechaventa = fechaventa;
    }
    
    
}
