/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DAO.DAOMembresias;
import Modelos.ModeloCliente;
import Modelos.ModeloMembresia;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author phant
 */
public class NegocioMembresia {
    
    
    DAOMembresias membs = new DAOMembresias();
    NegocioCliente ctes = new NegocioCliente();    
    
    public NegocioMembresia(){
        
    }
    
    public boolean addMembresia(ModeloMembresia mem) {
        return membs.agregar(mem);
    }

    //Hay que ver si se va ocupar en el futuro
    public boolean delMembresia(ModeloMembresia mem) {
        return membs.eliminar(mem) && ctes.delCliente(mem.getCliente());
    }
    
    public boolean delMembresia(String id) {
        NegocioAsistencia asis = new NegocioAsistencia();
        ModeloMembresia mem = obtenerMembresia(id);
        asis.delAsistencias(id);
        return membs.eliminar(mem) && ctes.delCliente(mem.getCliente());
    }
    
    public boolean updMembresia(ModeloMembresia mem) {
        return membs.actualizar(mem);
    }
    
    public boolean buscarMembresia(String id) {
        throw new UnsupportedOperationException("lol nope");
    }
    
    public ModeloMembresia obtenerMembresia(String id) {
        List mems = desplegarMembresias();
        for (int i = 0; i < mems.size(); i++) {
            ModeloMembresia mm = (ModeloMembresia) mems.get(i);
            if (Integer.toString(mm.getCliente().getId()).equals(id)){
                return mm;
            }
        }
        return null;
    }
    
    public List desplegarMembresias() {
        List membresias = membs.getAll();
        List clientes = ctes.desplegarClientes();
        for (int i = 0; i < membresias.size(); i++) {
            ModeloMembresia mem = (ModeloMembresia) membresias.get(i);
            for (int j = 0; j < clientes.size(); j++) {
                ModeloCliente cte = (ModeloCliente) clientes.get(j);
                if (mem.getCliente().getId() == cte.getId()) {
                    mem.setCliente(cte);
                }
            }
        }
        
        return membresias;
    }
    
    public boolean existeMembresiaIdCliente(int id) {
        return membs.existeMembresiaIdCliente(id);
    }
    
    public boolean isMembresiaVigente(String id) {
        LocalDate hoy = LocalDate.now();
        ModeloMembresia ms = (ModeloMembresia) membs.get(id);
        
        if (ms == null) {
            System.out.println("No existe una membresia con ese id");
            return false;
        } else if (ms.getFechaFin().isAfter(hoy)) {
            System.out.println("La membresia es vigente");
            return true;
        }
        
        System.out.println("La membresía no es vigente");
        return false;
    }
    
    public boolean renovarFechaVenc(ModeloMembresia mem, LocalDate fecha) {
        mem.setFechaFin(fecha);
        return updMembresia(mem);
    }
}
