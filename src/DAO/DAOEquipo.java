/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelos.ModeloEquipo;
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
public class DAOEquipo implements IDAO{

    @Override
    public boolean agregar(Object obj) {
        ConexionMySQL c = new ConexionMySQL();
        Connection conn = c.connect();
        ModeloEquipo eq = (ModeloEquipo) obj;

        //System.out.println(mem.getCliente().getId());
        String query = "INSERT INTO equipo(nombre) VALUES(\'" + eq.getNombre() + "\');";

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
        ModeloEquipo eq = (ModeloEquipo) obj;

        //System.out.println(mem.getCliente().getId());
        String query = "DELETE FROM equipo WHERE idequipo=" + eq.getIdequipo()+";";

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
        ModeloEquipo eq = (ModeloEquipo) obj;

        //System.out.println(mem.getCliente().getId());
        String query = "UPDATE equipo SET nombre=\'"+eq.getNombre()+"\' WHERE idequipo="+eq.getIdequipo()+";";

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
    public boolean buscar(Object obj) {
        List lista = getAll();

        for (Object eqs : lista) {
            if (eqs.toString().equals(obj.toString())) {
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
        List equipos = new ArrayList<>();
        ConexionMySQL c = new ConexionMySQL();
        Connection conn = c.connect();

        try {
            Statement s = conn.createStatement();
            String query = "SELECT * FROM equipo";
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                ModeloEquipo eq = new ModeloEquipo(rs.getString("idequipo"),rs.getString("nombre"));
                equipos.add(eq);
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return equipos;
    }
    
}
