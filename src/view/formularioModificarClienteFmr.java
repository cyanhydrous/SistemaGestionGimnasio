/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Modelos.ModeloCliente;
import Modelos.ModeloMembresia;
import Negocio.NegocioCliente;
import Negocio.NegocioMembresia;
import java.time.LocalDate;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author joshua
 */
public class formularioModificarClienteFmr extends javax.swing.JFrame {

    String accion = "modificar";
    double precio = 0;
    NegocioCliente clientes = new NegocioCliente();
    NegocioMembresia membresias = new NegocioMembresia();
    MainEmpleadoFrm main;

    /**
     * Creates new form formularioModificarClienteFmr
     */
    public formularioModificarClienteFmr(String accion, MainEmpleadoFrm main) {
        this.main = main;
        this.accion = accion;
        initComponents();
        this.setLocationRelativeTo(null);
        if (accion == "registrar") {
            this.setTitle("Registrar Membresia");

            txfID.setEnabled(false);
            btnModificar.setText("Registrar");
        } else if (accion == "renovar") {
            this.setTitle("Renovar Membresia");
            txfID.setEditable(false);
            btnModificar.setText("Renovar");
        }

    }

    public formularioModificarClienteFmr() {
        initComponents();
        this.setTitle("Modificar Membresia");
        txfID.setEditable(false);
        this.setLocationRelativeTo(null);
    }

    public formularioModificarClienteFmr(MainEmpleadoFrm main) {
        initComponents();
        this.main = main;
        this.setTitle("Modificar Membresia");
        txfID.setEditable(false);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txfNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txfDireccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txfID = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txfTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel1.setText("STEEL FACTORY GYM");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Direccion");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ID");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Telefono");

        jLabel6.setText("Tipo de Membresia");

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semanal", "Mensual", "Dia" }));
        comboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(37, 37, 37))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txfID, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(txfDireccion)
                    .addComponent(txfNombre)
                    .addComponent(txfTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(comboTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnModificar))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        //validarEntrada(); No funca todavía
        switch (accion) {
            case "registrar":
                registrarMembresia();
                break;
            case "renovar":
                renovarMembresia();
                break;
            case "modificar":
                modificarCliente();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Esta ventana no se inicializó correctamente");
                this.dispose();
                break;
        }


    }//GEN-LAST:event_btnModificarActionPerformed

    private void renovarMembresia() {        
        String nombre = txfNombre.getText();
        String direccion = txfDireccion.getText();
        String telefono = txfTelefono.getText();
        LocalDate hoy = LocalDate.now();
        String anio = Integer.toString(hoy.getYear());
        String mes = Integer.toString(hoy.getMonthValue());
        String dia = Integer.toString(hoy.getDayOfMonth());

        LocalDate fin = getFechaFin();
        String tipo = comboTipo.getSelectedItem().toString();
        int id = Integer.parseInt(txfID.getText());

        ModeloCliente cte = new ModeloCliente(id, nombre, telefono, direccion);
        ModeloMembresia mem = new ModeloMembresia(cte, hoy, fin);

        if (!membresias.isMembresiaVigente(Integer.toString(id))) {
            boolean exitomem = membresias.renovarFechaVenc(mem, fin);

            if (!exitomem) {
                JOptionPane.showMessageDialog(new JPanel(), "No se pudo renovar: Revise la consola","Error",JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Se renovó la membresia de: " + cte.getNombre() + "\n El precio es de: " + precio);
                try {
                    main.llenarTabla();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        } else {
            JOptionPane.showMessageDialog(new JPanel(), "No se pudo renovar: La membresia aun está vigente","Error",JOptionPane.ERROR_MESSAGE);
        }

        this.dispose();
    }

    private void modificarCliente() {
        String nombre = txfNombre.getText();
        String direccion = txfDireccion.getText();
        String telefono = txfTelefono.getText();

        int id = Integer.parseInt(txfID.getText());

        ModeloCliente cte = new ModeloCliente(id, nombre, telefono, direccion);
        boolean exitocte = clientes.updCliente(cte);

        if (!exitocte) {
            JOptionPane.showMessageDialog(new JPanel(), "No se pudo renovar: Revise la consola","Error",JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Se actualizó la información del cliente: " + cte.getId());
            try {
                main.llenarTabla();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        
        this.dispose();
    }

    private void registrarMembresia() {
        String nombre = txfNombre.getText();
        String direccion = txfDireccion.getText();
        String telefono = txfTelefono.getText();
        LocalDate hoy = LocalDate.now();
        String anio = Integer.toString(hoy.getYear());
        String mes = Integer.toString(hoy.getMonthValue());
        String dia = Integer.toString(hoy.getDayOfMonth());

        LocalDate fin = getFechaFin();
        String tipo = comboTipo.getSelectedItem().toString();
        ModeloCliente cte = new ModeloCliente(generateUniqueId(), nombre, telefono, direccion);
        ModeloMembresia mem = new ModeloMembresia(cte, hoy, fin);
        boolean exitocte = clientes.addCliente(cte);
        boolean exitomem = membresias.addMembresia(mem);

        if (!exitocte || !exitomem) {
            JOptionPane.showMessageDialog(new JPanel(), "No se pudo renovar: Revise la consola","Error",JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Se registró la membresia con el ID: " + cte.getId() + "\n El precio es de: " + precio);
            main.llenarTabla();
        }
        
        this.dispose();
    }

    private LocalDate getFechaFin() {
        LocalDate hoy = LocalDate.now(); //Fecha de hoy
        //260 mes, 80 semana y 20 el día
        
        //Aquí se determina cuanto hay que sumarle a la fecha de hoy
        if (comboTipo.getSelectedItem().toString().equals("Mensual")) {
            LocalDate fin = hoy.plusMonths(1); 
            precio = 260;
            return fin;
        } else if(comboTipo.getSelectedItem().toString().equals("Semanal")){
            LocalDate fin = hoy.plusWeeks(1); 
            precio = 80;
            return fin;
        } else {
            LocalDate fin = hoy.plusDays(1);
            precio = 20;
            return fin;
        }
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void comboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoActionPerformed

    public int generateUniqueId() {
        UUID idOne = UUID.randomUUID();
        String str = "" + idOne;
        int uid = str.hashCode();
        String filterStr = "" + uid;
        System.out.println(filterStr);
        str = filterStr.replaceAll("-", "").substring(3, 9);
        return Integer.parseInt(str);
    }

    private boolean validarEntrada() {

        if (!txfNombre.getText().matches("[a-zA-Z\\s]+")) {
            System.out.println("Nombre invalido");
            return false;
        } else if (!txfDireccion.getText().matches("[a-zA-Z\\s]+")) {
            System.out.println("Dirección invalida");
            return false;
        } else if (!txfTelefono.getText().matches("[0-9]")) {
            System.out.println("El telefono no puede contener caracteres que no sean numeros");
            return false;
        } else if (txfTelefono.getText().length() != 10) {
            System.out.println("El telefono debe tener 10 digitos");
            return false;
        }

        System.out.println("OK");
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formularioModificarClienteFmr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formularioModificarClienteFmr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formularioModificarClienteFmr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formularioModificarClienteFmr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formularioModificarClienteFmr().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnModificar;
    public javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public javax.swing.JTextField txfDireccion;
    public javax.swing.JTextField txfID;
    public javax.swing.JTextField txfNombre;
    public javax.swing.JTextField txfTelefono;
    // End of variables declaration//GEN-END:variables
}
