/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author phantomcide
 */
public class ModeloProducto {

    String idproducto;
    String nombre;
    int cantidad;
    int categoria;
    double precio;

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ModeloProducto() {
    }

    public ModeloProducto(String idproducto, String nombre, int cantidad, double precio, int categoria) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.categoria = categoria;
    }

    public ModeloProducto(String nombre, int cantidad, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public ModeloProducto(String nombre, int cantidad, double precio, int categoria) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.precio = precio;
    }    
    

    public ModeloProducto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = 0;
    }
}
