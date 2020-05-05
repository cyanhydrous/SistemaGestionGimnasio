/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DAO.DAOEquipo;
import Modelos.ModeloEquipo;
import java.util.List;

/**
 *
 * @author phantomcide
 */
public class NegocioEquipo {
    DAOEquipo de = new DAOEquipo();
    public boolean addEquipo(ModeloEquipo eq){
        return de.agregar(eq);
    }
    
    public boolean delEquipo(ModeloEquipo eq){
        return de.eliminar(eq);
    }
    
    public boolean updEquipo(ModeloEquipo eq){
        return de.actualizar(eq);
    }
    
    public boolean buscarEquipo(ModeloEquipo eq){
        return de.buscar(eq);
    }
    
    public List desplegarEquipos(){
        return de.getAll();
    }
}
