/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DAO.DAOAsistencias;
import Modelos.ModeloAsistencia;
import java.util.ArrayList;

/**
 *
 * @author phant
 */
public class NegocioAsistencia {
    DAOAsistencias asis = new DAOAsistencias();
    NegocioMembresia mem = new NegocioMembresia();
    
    public boolean addAsistencia(ModeloAsistencia asi) {
        if (mem.existeMembresiaIdCliente(asi.getCliente().getId())) {
            if (mem.isMembresiaVigente(Integer.toString(asi.getCliente().getId()))) {
                return asis.agregar(asi);
            } else {
                System.out.println("NegocioAsistencia: La membresia no está vigente");
            }
        } else {
            System.out.println("NegocioAsistencia: No existe una membresia con ese ID cliente");
        }
        
        return false;
    }
    
    public boolean delAsistencia(ModeloAsistencia asi) {
        throw new UnsupportedOperationException("lol nope");
    }
    
    public ArrayList buscarAsistencias() {
        throw new UnsupportedOperationException("lol nope");
    }
}
