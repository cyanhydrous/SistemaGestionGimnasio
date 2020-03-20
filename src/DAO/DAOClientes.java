/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelos.ModeloCliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phant
 */
public class DAOClientes implements IDAO {
 boolean testing = true;
    @Override
    public boolean agregar(Object obj) {
        ConexionMySQL c = new ConexionMySQL();
        Connection conn = c.connect();
        ModeloCliente cte = (ModeloCliente) obj;
        int id = cte.getId(), control=0;
        

//        do{
//            id = generateUniqueId();            
//            if(control == Integer.MAX_VALUE){
//                if(testing){
//                System.out.println("Se acabaron los IDs disponibles, favor de cambiarlo.");
//                }
//                break;            
//            }
//            
//            control++;
//        }while(buscarID(Integer.toString(id)));
        
        String query = "INSERT INTO cliente VALUES(\'" + id + "\',\'" + cte.getNombre() + "\',\'" + cte.getTelefono() + "\',\'"+ cte.getDireccion() +"\');";
        
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
        throw new UnsupportedOperationException("No se tiene en cuenta la eliminacion de clientes aun"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(Object obj) {
        ConexionMySQL c = new ConexionMySQL();
        Connection conn = c.connect();
        ModeloCliente cte = (ModeloCliente) obj;
        int id = cte.getId();
        
        String query = "UPDATE cliente SET nombre=\'"+ cte.getNombre() + "\',telefono=\'"+ cte.getTelefono()+ "\',direccion=\'"+ cte.getDireccion() +"\' WHERE idcliente=" + id+";";
        
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

        for (Object cli : lista) {
            if (cli.toString().equals(obj.toString())) {
                return true;
            }
        }
        return false;
    }

    public boolean buscarID(String id) {
        List lista = getAll();

        for (Object cli : lista) {
            ModeloCliente m = (ModeloCliente) cli;
            if (Integer.toString(m.getId()).equals(String.valueOf(id))) {
                return true;
            }
        }
        return false;
    }
    
    public boolean buscarPorNombre(String nombre) {
        List lista = getAll();

        for (Object cli : lista) {
            ModeloCliente m = (ModeloCliente) cli;
            if (m.getNombre().equals(nombre)) {
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
        List clientes = new ArrayList<>();
        ConexionMySQL c = new ConexionMySQL();
        Connection conn = c.connect();

        try {
            Statement s = conn.createStatement();
            String query = "SELECT * FROM cliente";
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                ModeloCliente cte = new ModeloCliente(Integer.parseInt(rs.getString("idcliente")),rs.getString("nombre"), rs.getString("telefono"), rs.getString("direccion"));
                clientes.add(cte);
            }
            conn.close();
        } catch (SQLException | NumberFormatException ex) {
            System.out.println(ex);
        }

        return clientes;
    }

    /**
     * Con este método se van a generar los IDs de los clientes. *
     */
    public int generateUniqueId() {
        UUID idOne = UUID.randomUUID();
        String str = "" + idOne;
        int uid = str.hashCode();
        String filterStr = "" + uid;
        str = filterStr.replaceAll("-", "").substring(3,9);
        return Integer.parseInt(str);
    }
    
    
}
