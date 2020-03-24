/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelos.ModeloMembresia;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phant
 */
public class DAOMembresias implements IDAO {

    @Override
    public boolean agregar(Object obj) {
        ConexionMySQL c = new ConexionMySQL();
        Connection conn = c.connect();
        ModeloMembresia mem = (ModeloMembresia) obj;

        System.out.println(mem.getCliente().getId());
        String query = "INSERT INTO membresia(fecha_inicial, fecha_fin, idcliente) VALUES(\'" + mem.getFechaIn().toString() + "\',\'" + mem.getFechaFin().toString() + "\',\'" + mem.getCliente().getId() + "\');";

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
        ModeloMembresia mm = (ModeloMembresia) obj;

        String query = "DELETE FROM membresia WHERE idcliente=" + mm.getCliente().getId() + ";";

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
        ModeloMembresia mm = (ModeloMembresia) obj;

        String query = "UPDATE membresia SET fecha_inicial=\'" + mm.getFechaIn().toString() + "\',fecha_fin=\'" + mm.getFechaFin().toString() + "\' WHERE idcliente=" + mm.getCliente().getId() + ";";

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

        for (Object mem : lista) {
            if (mem.toString().equals(obj.toString())) {
                return true;
            }
        }
        return false;
    }

    public boolean existeMembresiaIdCliente(int id) {
        List lista = getAll();

        for (Object lis : lista) {
            ModeloMembresia mem = (ModeloMembresia) lis;
            if (mem.getCliente().getId() == id) {
                return true;
            }
        }
        return false;
    }

    /*Este método devuelve una membresía en base a un id de un cliente*/
    @Override
    public Object get(Object obj) {

        int id = Integer.parseInt(obj.toString());
        if (existeMembresiaIdCliente(id)) {
            List lista = getAll();

            for (Object ob : lista) {
                ModeloMembresia mm = (ModeloMembresia) ob;
                if (mm.getCliente().getId() == id) {
                    System.out.println("Se encontró la membresía");
                    return mm;
                }
            }
        }
        System.out.println("No hay una membresía con ese idcliente");

        return null;
    }

    @Override
    public List getAll() {
        List membresias = new ArrayList<>();
        ConexionMySQL c = new ConexionMySQL();
        Connection conn = c.connect();

        try {
            Statement s = conn.createStatement();
            String query = "SELECT * FROM membresia";
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                ModeloMembresia cte = new ModeloMembresia(Integer.parseInt(rs.getString("idmembresia")), rs.getString("fecha_inicial"), rs.getString("fecha_fin"), Integer.parseInt(rs.getString("idcliente")));
                membresias.add(cte);
            }
            conn.close();
        } catch (SQLException | NumberFormatException ex) {
            System.out.println(ex);
        }
        return membresias;
    }
}
