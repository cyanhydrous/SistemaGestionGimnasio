/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelos.ModeloEquipo;
import Modelos.ModeloMantenimiento;
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
public class DAOMantenimiento implements IDAO{

    @Override
    public boolean agregar(Object obj) {
        ConexionMySQL c = new ConexionMySQL();
        Connection conn = c.connect();
        ModeloMantenimiento man = (ModeloMantenimiento) obj;

        //System.out.println(mem.getCliente().getId());
        String query = "INSERT INTO mantenimiento(idequipo,estado) VALUES(\'" + man.getEquipo().getIdequipo() +"\',"+ man.isEstadoEquipo() + ");";

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
        ModeloMantenimiento man = (ModeloMantenimiento) obj;

        //System.out.println(mem.getCliente().getId());
        String query = "DELETE FROM mantenimiento WHERE idmant=" + man.getIdmantenimiento() +";";

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
        ModeloMantenimiento man = (ModeloMantenimiento) obj;

        //System.out.println(mem.getCliente().getId());
        String query = "UPDATE mantenimiento SET estado="+man.isEstadoEquipo()+" WHERE idmant="+man.getIdmantenimiento()+";";

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
        List mants = new ArrayList<>();
        ConexionMySQL c = new ConexionMySQL();
        Connection conn = c.connect();

        try {
            Statement s = conn.createStatement();
            String query = "SELECT * FROM mantenimiento";
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                ModeloMantenimiento eq = new ModeloMantenimiento(rs.getString("idmant"),rs.getString("idequipo"),Boolean.parseBoolean(rs.getString("estado")));
                mants.add(eq);
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return mants;
    }
    
}
