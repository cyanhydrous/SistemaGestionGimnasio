/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelos.ModeloVenta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phantomcide
 */
public class DAOVentas implements IDAO{

    @Override
    public boolean agregar(Object obj) {
        ConexionMySQL c = new ConexionMySQL();
        Connection conn = c.connect();
        ModeloVenta venta = (ModeloVenta) obj;

        //System.out.println(mem.getCliente().getId());
        String query = "INSERT INTO venta(fecha, idproducto) VALUES(\'" + venta.getFechaventa() + "\',\'" + venta.getProducto().getIdproducto() + "\');";

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

        String query = "DELETE FROM venta WHERE idproducto=" + obj.toString() + ";";

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean buscar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            String query = "SELECT * FROM venta";
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                ModeloVenta prod = new ModeloVenta(rs.getString("idventa"), LocalDate.parse(rs.getString("fecha")), rs.getString("idproducto"));
                productos.add(prod);
            }
            conn.close();
        } catch (SQLException | NumberFormatException ex) {
            System.out.println(ex);
        }
        return productos;
    }
    
}
