/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DAO.DAOVentas;
import Modelos.ModeloProducto;
import Modelos.ModeloVenta;
import java.util.List;

/**
 *
 * @author phantomcide
 */
public class NegocioVenta {
    
    DAOVentas dv = new DAOVentas();    
    
    public boolean addVenta(ModeloVenta venta){
        return dv.agregar(venta);
    }
    
//    public boolean delVenta(ModeloVenta venta){
//        return dv.eliminar(venta);
//    }
    
    public boolean delVentas(String id){
        return dv.eliminar(id);
    }
    
    public boolean updVenta(ModeloVenta venta){
        return dv.actualizar(venta);
    }
    
    public List desplegarVentas(){
        NegocioProducto np = new NegocioProducto();
        List ventas = dv.getAll();
        List productos = np.desplegarProductos();
        
        for (int i = 0; i < ventas.size(); i++) {
            ModeloVenta venta = (ModeloVenta) ventas.get(i);
            for (int j = 0; j < productos.size(); j++) {
                ModeloProducto prod = (ModeloProducto) productos.get(j);
                if (venta.getProducto().getIdproducto().equals(prod.getIdproducto())) {
                    venta.setProducto(prod);
                }
            }
        }
        
        return ventas;
    }
    
    
}
