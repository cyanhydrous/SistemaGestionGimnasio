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
public class ModeloEquipo {
    String idequipo;
    String nombre;

    public ModeloEquipo() {
    }

    public ModeloEquipo(String idequipo, String nombre) {
        this.idequipo = idequipo;
        this.nombre = nombre;
    }

    public String getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(String idequipo) {
        this.idequipo = idequipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
