/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DAO.DAOAsistencias;
import Modelos.ModeloAsistencia;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phant
 */
public class NegocioAsistencia {

    DAOAsistencias asis = new DAOAsistencias();
    NegocioMembresia mem = new NegocioMembresia();

    public boolean addAsistencia(ModeloAsistencia asi) {
        LocalDate hoy = LocalDate.now();
        List asistencias = desplegarAsistencias();
        if (mem.existeMembresiaIdCliente(asi.getCliente().getId())) {
            if (mem.isMembresiaVigente(Integer.toString(asi.getCliente().getId()))) {
                for (int i = 0; i < asistencias.size(); i++) {
                    ModeloAsistencia m = (ModeloAsistencia) asistencias.get(i);
                    if (asi.getFecha().toString().equals(m.getFecha().toString())) {
                        System.out.println("NegocioAsistencia: Ya está registrada la asistencia");
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
        return asis.getAll();
    }
}
