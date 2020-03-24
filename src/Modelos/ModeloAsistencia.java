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
public class ModeloAsistencia {
    ModeloCliente cte;
    LocalDate fecha;

    public ModeloAsistencia(int id, LocalDate fecha){
        cte = new ModeloCliente();
        cte.setId(id);       
        this.fecha = fecha;
    }
    
    public ModeloAsistencia(int id, String fecha){
        cte = new ModeloCliente();
        cte.setId(id);       
        this.fecha = LocalDate.parse(fecha);
    }
    
    public ModeloCliente getCliente() {
        return cte;
    }

    public void setCte(ModeloCliente cte) {
        this.cte = cte;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "ModeloAsistencia{" + "cte=" + cte + ", fecha=" + fecha + '}';
    }
    
    
}
