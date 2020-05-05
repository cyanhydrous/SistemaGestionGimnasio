/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Modelos.ModeloAsistencia;
import Negocio.NegocioAsistencia;
import Negocio.NegocioMembresia;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author joshua
 */
public class MainClienteFrm extends javax.swing.JFrame {

    NegocioAsistencia asis = new NegocioAsistencia();
    NegocioMembresia mems = new NegocioMembresia();

    /**
     * Creates new form MainClienteFrm
     */
    public MainClienteFrm() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Asistencias");
        lblStatus.setText("");
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
        txfIdCliente = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ingrese su ID y presione Enter");

        txfIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfIdClienteActionPerformed(evt);
            }
        });
        txfIdCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfIdClienteKeyPressed(evt);
            }
        });

        lblStatus.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(txfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStatus)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(txfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblStatus)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfIdClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfIdClienteKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (registrarAsistencia()) {
                lblStatus.setText("Bienvenido " + mems.obtenerMembresia(txfIdCliente.getText()).getCliente().getNombre());
                //JOptionPane.showMessageDialog(new JPanel(), "El cliente es bienvenido!");
            }

            txfIdCliente.setText("");
        }

    }//GEN-LAST:event_txfIdClienteKeyPressed

    private boolean validarCte(String id) {

        if (id.matches("[0-9]+")) {
            boolean memVigente = mems.isMembresiaVigente(id);
            boolean cteExiste = mems.existeMembresiaIdCliente(Integer.parseInt(id));            
            if (!cteExiste) {
                //JOptionPane.showMessageDialog(new JPanel(), "No hay una membresia con ese ID", "Error", JOptionPane.ERROR_MESSAGE);
                lblStatus.setText("No hay una membresía con ese ID");
                return false;
            } else if (!memVigente) {
                //JOptionPane.showMessageDialog(new JPanel(), "La membresia del cliente no está vigente", "Error", JOptionPane.ERROR_MESSAGE);
                lblStatus.setText("Su membresía ha expirado!");
                return false;
            }
        } else {
            //JOptionPane.showMessageDialog(new JPanel(), "El id debe contener solo números!", "Error", JOptionPane.ERROR_MESSAGE);
            lblStatus.setText("El id debe contener solo números!");
            return false;
        }

        return true;
    }

    private boolean registrarAsistencia() {

        if (validarCte(txfIdCliente.getText())) {
            int id = Integer.parseInt(txfIdCliente.getText());
            LocalDate hoy = LocalDate.now();
            ModeloAsistencia as = new ModeloAsistencia(id, hoy);

            boolean stat = asis.addAsistencia(as);

            if (!stat) {
                lblStatus.setText("Usted ya está registrado el día de hoy");
                //JOptionPane.showMessageDialog(new JPanel(), "Error: Usted ya está registrado el día de hoy.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                
            }

            return stat;
        }

        return false;
    }

    private void txfIdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfIdClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfIdClienteActionPerformed

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
            java.util.logging.Logger.getLogger(MainClienteFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainClienteFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainClienteFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainClienteFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainClienteFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTextField txfIdCliente;
    // End of variables declaration//GEN-END:variables
}
