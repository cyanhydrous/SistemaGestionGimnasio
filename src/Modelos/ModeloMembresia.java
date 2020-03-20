/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author phant
 */
public class ModeloMembresia {
    int id;
    ModeloCliente cliente;
    LocalDate fechaIn, fechaFin;

    public int getId() {
        return id;
    }

    public ModeloMembresia(){
        
    }
    
    public ModeloMembresia(int id, ModeloCliente cliente, LocalDate fechaIn, LocalDate fechaFin) {
        this.id = id;
        this.cliente = cliente;
        this.fechaIn = fechaIn;
        this.fechaFin = fechaFin;
    }

    public ModeloMembresia(int id, String fechaIn, String fechaFin, int idcliente) {
        this.id = id;
        this.cliente = new ModeloCliente();
        this.cliente.setId(idcliente);
        this.fechaIn = LocalDate.parse(fechaIn);
        this.fechaFin = LocalDate.parse(fechaFin);
    }
    
    public ModeloMembresia(ModeloCliente cliente, LocalDate fechaIn, LocalDate fechaFin) {
        this.cliente = cliente;
        this.fechaIn = fechaIn;
        this.fechaFin = fechaFin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ModeloCliente getCliente() {
        return cliente;
    }

    public void setCliente(ModeloCliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaIn() {
        return fechaIn;
    }

    public void setFechaIn(LocalDate fechaIn) {
        this.fechaIn = fechaIn;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "ModeloMembresia{" + "id=" + id + ", cliente=" + cliente + ", fechaIn=" + fechaIn + ", fechaFin=" + fechaFin + '}';
    }
    
    
    
}
