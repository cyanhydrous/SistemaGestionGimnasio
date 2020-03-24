/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DAO.DAOClientes;
import Modelos.ModeloCliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phant
 */
public class NegocioCliente {
    DAOClientes ctes = new DAOClientes();
    
    public boolean addCliente(ModeloCliente cte) {
        if(validarCliente(cte)){
            System.out.println("No se encontró el cliente en la BD... Agregando...");
            return ctes.agregar((ModeloCliente) cte);
        }
        System.out.println("Error! Saliendo..");
        return false;
    }
    
    public boolean delCliente(ModeloCliente cte) {
        throw new UnsupportedOperationException("No se si se va a implementar la eliminacion de clientes...");
    }
    
    public boolean updCliente(ModeloCliente cte) {
        System.out.println("NegocioCliente: Buscando ID " + cte.getId());
        if(validarCliente(Integer.toString(cte.getId()))){
            System.out.println("Se encontró el cliente! Llamando a actualizar()..");
            return ctes.actualizar(cte);
        }
        
        System.out.println("El cliente no existe... No hay nada que actualizar.");
        return false;
    }
    
    public ModeloCliente buscarCliente(String cte) {
        throw new UnsupportedOperationException("???");
    }
    
    public List desplegarClientes() {
        return ctes.getAll();
    }
    
    /*Este método valida que no exista un cliente en la BD que se da como parametro*/
    private boolean validarCliente(ModeloCliente cte) {
                
        if(ctes.buscar(cte)){
            System.out.println("El cliente ya está agregado en la BD");
            return false;
        } else if (ctes.buscarID(Integer.toString(cte.getId()))) {
            System.out.println("Ya hay un cliente en la BD con el mismo ID!");
            return false;
        } else if (ctes.buscarPorNombre(cte.getNombre())){ //Puede que se elimine esta parte más adelante...
            System.out.println("Ya hay un cliente en la BD con exactamente ese mismo nombre!");
            return false;
        }
        return true;
    }
    
     /*Este método busca un ID en la base de datos*/
    public boolean validarCliente(String id) {
        return ctes.buscarID(id);
    }
    
}
