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
public class ModeloMantenimiento {
    String idmantenimiento;
    ModeloEquipo equipo;
    boolean estadoEquipo;
    String comentario;

    public ModeloMantenimiento() {
    }

    public ModeloMantenimiento(String idmantenimiento, ModeloEquipo equipo, boolean estadoEquipo) {
        this.idmantenimiento = idmantenimiento;
        this.equipo = equipo;
        this.estadoEquipo = estadoEquipo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public ModeloMantenimiento(String idmantenimiento, String idequipo, boolean estadoEquipo, String comentario) {
        this.idmantenimiento = idmantenimiento;
        this.equipo = new ModeloEquipo();
        equipo.setIdequipo(idequipo);
        this.estadoEquipo = estadoEquipo;
        this.comentario = comentario;
    }
    
    public String getIdmantenimiento() {
        return idmantenimiento;
    }

    public void setIdmantenimiento(String idmantenimiento) {
        this.idmantenimiento = idmantenimiento;
    }

    public ModeloEquipo getEquipo() {
        return equipo;
    }

    public void setEquipo(ModeloEquipo equipo) {
        this.equipo = equipo;
    }

    public boolean isEstadoEquipo() {
        return estadoEquipo;
    }

    public void setEstadoEquipo(boolean estadoEquipo) {
        this.estadoEquipo = estadoEquipo;
    }
    
    
}
