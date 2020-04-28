/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Modelos.ModeloProducto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phantomcide
 */
public class DAOProductos implements IDAO {

    @Override
    public boolean agregar(Object obj) {
        ConexionMySQL c = new ConexionMySQL();
        Connection conn = c.connect();
        ModeloProducto prod = (ModeloProducto) obj;

        //System.out.println(mem.getCliente().getId());
        String query = "INSERT INTO producto(nombre, cantidad, precio) VALUES(\'" + prod.getNombre() + "\',\'" + prod.getCantidad() + "\',\'" + prod.getPrecio() + "\');";

        try {
            Statement s = conn.createStatement();
            s.execute(query);
            conn.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean eliminar(Object obj) {
        ConexionMySQL c = new ConexionMySQL();
        Connection conn = c.connect();
        ModeloProducto prod = (ModeloProducto) obj;

        String query = "DELETE FROM producto WHERE idproducto=" + prod.getIdproducto() + ";";

        try {
            Statement s = conn.createStatement();
            s.execute(query);
            conn.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean actualizar(Object obj) {
        ConexionMySQL c = new ConexionMySQL();
        Connection conn = c.connect();
        ModeloProducto prod = (ModeloProducto) obj;

        String query = "UPDATE producto SET nombre=\'" + prod.getNombre() + "\',cantidad=\'" + prod.getCantidad() + "\',precio=\'" + prod.getPrecio() + "\' WHERE idproducto=" + prod.getIdproducto() + ";";

        try {
            Statement s = conn.createStatement();
            s.execute(query);
            conn.close();
            return true; //Redundante? execute devuelve boolean
            //Nope, hay que cerrar la conexion(?
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean buscar(Object obj) {
        List lista = getAll();

        for (Object prods : lista) {
            if (prods.toString().equals(obj.toString())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAll() {
        List productos = new ArrayList<>();
        ConexionMySQL c = new ConexionMySQL();
        Connection conn = c.connect();

        try {
            Statement s = conn.createStatement();
            String query = "SELECT * FROM producto";
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                ModeloProducto prod = new ModeloProducto(rs.getString("idproducto"), rs.getString("nombre"), Integer.parseInt(rs.getString("cantidad")), Double.parseDouble(rs.getString("precio")));
                productos.add(prod);
            }
            conn.close();
        } catch (SQLException | NumberFormatException ex) {
            System.out.println(ex);
        }
        return productos;
    
    }
    
}
