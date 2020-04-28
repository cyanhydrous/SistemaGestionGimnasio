/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DAO.DAOProductos;
import Modelos.ModeloProducto;

/**
 *
 * @author phantomcide
 */
public class NegocioProducto {
    
    DAOProductos dp = new DAOProductos();

    public boolean addProducto(ModeloProducto prod){
        return false;
    }
    
    public boolean delProducto(ModeloProducto prod){
        return false;
    }
    
    public boolean updProducto(ModeloProducto prod){
        return false;
    }
    
    public boolean buscarProducto(String nombre){
        return false;
    }
    
    public boolean inventariarProducto(ModeloProducto prod, int cantidad){
        return false;
    }
}
