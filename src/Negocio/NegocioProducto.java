/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DAO.DAOProductos;
import Modelos.ModeloProducto;
import java.util.List;

/**
 *
 * @author phantomcide
 */
public class NegocioProducto {

    DAOProductos dp = new DAOProductos();

    public boolean addProducto(ModeloProducto prod) {
        if (productoExiste(prod.getNombre())) {
            System.out.println("Ya hay un producto con el mismo nombre!");
            return false;
        } else {
            return dp.agregar(prod);
        }
    }

    public boolean delProducto(ModeloProducto prod) {
        NegocioVenta nv = new NegocioVenta();
        return nv.delVentas(prod.getIdproducto()) && dp.eliminar(prod);
    }

    public boolean updProducto(ModeloProducto prod) {
        return dp.actualizar(prod);
    }

    public boolean productoExiste(String nombre) {
        List productos = desplegarProductos();

        for (Object o : productos) {
            ModeloProducto mp = (ModeloProducto) o;
            if (mp.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public boolean inventariarProducto(ModeloProducto prod, int cantidad) {
        if (cantidad > 0) {
            prod.setCantidad(prod.getCantidad() + cantidad);
            return updProducto(prod);
        }
        System.out.println("Se ingresó una cantidad inválida!");
        return false;
    }

    public boolean desinventariarProducto(ModeloProducto prod, int cantidad) {
        if (cantidad > 0) {
            if (prod.getCantidad() < cantidad) {
                System.out.println("La cantidad a desinventariar excede el numero disponible del producto, poniendo 0...");
                prod.setCantidad(0);
                return updProducto(prod);
            } else {
                prod.setCantidad(prod.getCantidad() - cantidad);
                return updProducto(prod);
            }
        }
        System.out.println("Se ingresó una cantidad invalida!");
        return false;
    }

    public List desplegarProductos() {
        return dp.getAll();
    }
}
