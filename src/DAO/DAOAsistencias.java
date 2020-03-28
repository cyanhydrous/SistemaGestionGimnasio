/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelos.ModeloAsistencia;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phant
 */
public class DAOAsistencias implements IDAO{

    @Override
    public boolean agregar(Object obj) {
        ConexionMySQL c = new ConexionMySQL();
        Connection conn = c.connect();
        ModeloAsistencia as = (ModeloAsistencia) obj;
        LocalDate hoy = LocalDate.now();

        System.out.println(as.getCliente().getId());
        String query = "INSERT IGNORE INTO asistencia(fecha, idcliente) VALUES(\'" + hoy.toString() + "\',\'"  + as.getCliente().getId() + "\');";

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
        ModeloAsistencia mm = (ModeloAsistencia) obj;

        String query = "DELETE FROM asistencia WHERE idcliente=" + mm.getCliente().getId() + ";";

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
        List asists = new ArrayList<>();
        ConexionMySQL c = new ConexionMySQL();
        Connection conn = c.connect();

        try {
            Statement s = conn.createStatement();
            String query = "SELECT * FROM asistencia";
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                ModeloAsistencia as = new ModeloAsistencia(Integer.parseInt(rs.getString("idcliente")), rs.getString("fecha"));
                asists.add(as);
            }
            conn.close();
        } catch (SQLException | NumberFormatException ex) {
            System.out.println(ex);
        }

        return asists;
    }
    
}
