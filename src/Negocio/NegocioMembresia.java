/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DAO.DAOClientes;
import DAO.DAOMembresias;
import Modelos.ModeloMembresia;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author phant
 */
public class NegocioMembresia {
    DAOMembresias membs = new DAOMembresias();
    DAOClientes ctes = new DAOClientes();
    
    public boolean addMembresia(ModeloMembresia mem) {
        throw new UnsupportedOperationException("lol nope");
    }
    
    public boolean delMembresia(ModeloMembresia mem) {
        throw new UnsupportedOperationException("lol nope");
    }
    
    public boolean updMembresia(ModeloMembresia mem) {
        throw new UnsupportedOperationException("lol nope");
    }
    
    public boolean buscarMembresia(String id) {
        throw new UnsupportedOperationException("lol nope");
    }
    
    public ModeloMembresia obtenerMembresia(String id) {
        throw new UnsupportedOperationException("lol nope");
    }
    
    public ArrayList desplegarMembresias() {
        throw new UnsupportedOperationException("lol nope");
    }
    
    public boolean validarMembresia(ModeloMembresia mem) {
        throw new UnsupportedOperationException("lol nope");
    }
    
    public boolean validarMembresia(Date fecha) {
        throw new UnsupportedOperationException("lol nope");
    }
    
    public boolean isMembresiaVigente(String id) {
        throw new UnsupportedOperationException("lol nope");
    }
    
    public boolean renovarFechaVenc(ModeloMembresia mem, Date fecha) {
        throw new UnsupportedOperationException("lol nope");
    }
}
