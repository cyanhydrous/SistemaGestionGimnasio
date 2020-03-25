/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DAO.DAOAsistencias;
import DAO.DAOClientes;
import Modelos.ModeloAsistencia;
import Modelos.ModeloCliente;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author phant
 */
public class NegocioAsistencia {

    DAOAsistencias asis = new DAOAsistencias();
    NegocioMembresia mem = new NegocioMembresia();
    NegocioCliente ctes = new NegocioCliente();

    public boolean addAsistencia(ModeloAsistencia asi) {
        //LocalDate hoy = LocalDate.now();
        List asistencias = desplegarAsistencias();
        //System.out.println(asi.getFecha().toString());
        if (mem.existeMembresiaIdCliente(asi.getCliente().getId())) {
            if (mem.isMembresiaVigente(Integer.toString(asi.getCliente().getId()))) {
                for (int i = 0; i < asistencias.size(); i++) {
                    ModeloAsistencia m = (ModeloAsistencia) asistencias.get(i);
                    LocalDate ld = m.getFecha();
                    int id = m.getCliente().getId();
                    //System.out.println(m.toString());
                    if (asi.getFecha().equals(ld) && asi.getCliente().getId() == id) {
                        System.out.println("NegocioAsistencia: Ya está registrada la asistencia el dia de hoy");
                        return false;
                    }
                }
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

    public List desplegarAsistencias() {
        List asistencias = asis.getAll();
        List clientes = ctes.desplegarClientes();
        for (int i = 0; i < asistencias.size(); i++) {
            ModeloAsistencia as = (ModeloAsistencia) asistencias.get(i);
            for (int j = 0; j < clientes.size(); j++) {
                ModeloCliente cte = (ModeloCliente) clientes.get(j);
                if (as.getCliente().getId() == cte.getId()) {
                    as.setCte(cte);
                }
            }
        }
        
        return asistencias;
        
        //return asis.getAll();
    }
}
