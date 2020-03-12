/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DAO.DAOClientes;
import DAO.DAOMembresias;
import Modelos.ModeloMembresia;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author phant
 */
public class NegocioMembresia {

    DAOMembresias membs = new DAOMembresias();
    DAOClientes ctes = new DAOClientes();

    public boolean addMembresia(ModeloMembresia mem) {
        return membs.agregar(mem);
    }

    //Hay que ver si se va ocupar en el futuro
    public boolean delMembresia(ModeloMembresia mem) {
        return membs.eliminar(mem);
    }

    public boolean updMembresia(ModeloMembresia mem) {
        return membs.actualizar(mem);
    }

    public boolean buscarMembresia(String id) {
        throw new UnsupportedOperationException("lol nope");
    }

    public ModeloMembresia obtenerMembresia(String id) {
        throw new UnsupportedOperationException("lol nope");
    }

    public List desplegarMembresias() {
        return membs.getAll();
    }

    public boolean isMembresiaVigente(String id) {       
        LocalDate hoy = LocalDate.now();
        
        return false;
    }

    public boolean renovarFechaVenc(ModeloMembresia mem, LocalDate fecha) {
        throw new UnsupportedOperationException("lol nope");
    }
}
