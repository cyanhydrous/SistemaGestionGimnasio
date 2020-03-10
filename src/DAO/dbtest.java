/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelos.ModeloCliente;
import Modelos.ModeloMembresia;
import Negocio.NegocioCliente;
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

            ModeloCliente mc = new ModeloCliente(399755,"Bulio Iván","444","ffffff");
            LocalDate ld = LocalDate.parse("2020-05-10");
            LocalDate s = LocalDate.now();
            ModeloMembresia mm = new ModeloMembresia(mc, s, ld);
            DAOMembresias dm = new DAOMembresias();

            dm.agregar(mm);
            
            ld = LocalDate.parse("2020-06-10");
            
            
            dm.actualizar(mm);
            
        List l = dm.getAll();

        for (Object l1 : l) {
            ModeloMembresia m = (ModeloMembresia) l1;
            System.out.println("id: " + m.getId() + " fechaIn: " + m.getFechaIn().toString() + " fechaFin: " + m.getFechaFin() + " cliente: " + m.getCliente().getId());
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
