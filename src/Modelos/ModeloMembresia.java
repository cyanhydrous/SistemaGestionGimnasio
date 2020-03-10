/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.Date;

/**
 *
 * @author phant
 */
public class ModeloMembresia {
    String id;
    ModeloCliente cliente;
    Date fechaIn, fechaFin;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ModeloCliente getCliente() {
        return cliente;
    }

    public void setCliente(ModeloCliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaIn() {
        return fechaIn;
    }

    public void setFechaIn(Date fechaIn) {
        this.fechaIn = fechaIn;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    
}
