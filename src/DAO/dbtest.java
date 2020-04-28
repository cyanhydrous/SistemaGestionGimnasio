/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Negocio.*;
import Modelos.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phant
 */
public class dbtest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //ModeloCliente mc = new ModeloCliente(387375,"Bulio Iván","444","ffffff");
//            ModeloCliente mc1 = new ModeloCliente(433257,"Memb Vigente Test", "666", "En su casa");
//            //LocalDate ld = LocalDate.parse("2018-05-10");
//            LocalDate ld = LocalDate.now();
//            LocalDate s = LocalDate.now();
//            ModeloMembresia mm = new ModeloMembresia(mc1, s, ld);
//            DAOMembresias dm = new DAOMembresias();
//            DAOClientes dc = new DAOClientes();
        //dm.agregar(mm);
        //dm.eliminar(mm);
//        NegocioAsistencia na = new NegocioAsistencia();
//        List a = na.desplegarAsistencias();
//        
//        for (Object obj : a) {
//            ModeloAsistencia ma = (ModeloAsistencia) obj;
//            System.out.println(ma.toString());
//        } 

//            System.out.println(dm.existeMembresiaIdCliente(387375));
//            
//        List l = dm.getAll();
//
//        for (Object l1 : l) {
//            ModeloMembresia m = (ModeloMembresia) l1;
//            System.out.println("id: " + m.getId() + " fechaIn: " + m.getFechaIn().toString() + " fechaFin: " + m.getFechaFin() + " cliente: " + m.getCliente().getId());
////        }
//        NegocioMembresia nm = new NegocioMembresia();
//        System.out.println(nm.isMembresiaVigente("433257"));

            DAOProductos dp = new DAOProductos();
            //ModeloProducto mp = new ModeloProducto("Multivitaminico ario xd",50,350.0);
            //System.out.println(dp.agregar(mp));
        for (Object obj : dp.getAll()) {
            ModeloProducto m = (ModeloProducto) obj;
            System.out.println(m.getNombre());
        } 
    }
    
    public static void actualizarCte(ModeloCliente cte) {
        DAOClientes d = new DAOClientes();
        System.out.println(d.actualizar(cte));
    }
    
    public static void buscarID(String id) {
        DAOClientes d = new DAOClientes();
        System.out.println(d.buscarID(id));
    }
    
    public static int generateUniqueId() {
        UUID idOne = UUID.randomUUID();
        System.out.println("idOne: " + idOne);
        String str = "" + idOne;
        System.out.println("srt: " + str);
        int uid = str.hashCode();
        System.out.println("uid: " + uid);
        String filterStr = "" + uid;
        System.out.println("filterStr: " + filterStr);
        str = filterStr.replaceAll("-", "").substring(3, 9);
        return Integer.parseInt(str);
    }
    
    private static void buscar(ModeloCliente cte) {
        DAOClientes d = new DAOClientes();
        System.out.println(d.buscar((Object) cte));
    }
    
    private static void insertar(ModeloCliente cte) {
        DAOClientes d = new DAOClientes();
        System.out.println(d.agregar((Object) cte));
    }
    
    private static void getAllTest() {
        DAOClientes d = new DAOClientes();
        List list = d.getAll();
        for (int i = 0; i < list.size(); i++) {
            ModeloCliente ct = (ModeloCliente) list.get(i);
            System.out.print("Nombre: " + ct.getNombre() + ", Direccion: " + ct.getDireccion() + ", Telefono: " + ct.getTelefono() + "\n");
        }
    }
    
    private static void uh() {
        ConexionMySQL c = new ConexionMySQL();
        Connection conn = c.connect();
        try {
            Statement s = conn.createStatement();
            String query = "SELECT * FROM cliente WHERE idcliente = 1";
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                int idcliente = rs.getInt("idcliente");
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");
                System.out.println(idcliente + "\t" + nombre
                        + "\t" + telefono + "\t" + direccion
                        + "\t");
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(dbtest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
