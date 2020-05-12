/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DAO.DAOMantenimiento;
import Modelos.ModeloEquipo;
import Modelos.ModeloMantenimiento;
import java.util.List;

/**
 *
 * @author phantomcide
 */
public class NegocioMantenimiento {
    DAOMantenimiento dm = new DAOMantenimiento();
    NegocioEquipo ne = new NegocioEquipo();
    
    public boolean addMantenimiento(ModeloMantenimiento mm){
        return dm.agregar(mm);
    }
    
    public boolean delMantenimiento(ModeloMantenimiento mm){
        return ne.delEquipo(mm.getEquipo()) && dm.eliminar(mm);
    }
    
    public boolean updMantenimiento(ModeloMantenimiento mm){
        return dm.actualizar(mm);
    }
    
    public List desplegarMantenimientos(){
        List mants = dm.getAll();
        List eqs = ne.desplegarEquipos();
        
        for (int i = 0; i < mants.size(); i++) {
            ModeloMantenimiento man = (ModeloMantenimiento) mants.get(i);
            for (int j = 0; j < eqs.size(); j++) {
                ModeloEquipo eq = (ModeloEquipo) eqs.get(j);
                if (man.getEquipo().getIdequipo().equals(eq.getIdequipo())) {
                    man.setEquipo(eq);
                }
            }
        }
        
        return mants;
    }
}
