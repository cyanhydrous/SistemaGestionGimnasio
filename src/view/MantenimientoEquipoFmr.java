/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Modelos.ModeloEquipo;
import Modelos.ModeloMantenimiento;
import Negocio.NegocioEquipo;
import Negocio.NegocioMantenimiento;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joshua
 */
public class MantenimientoEquipoFmr extends javax.swing.JFrame {

    private NegocioMantenimiento nm = new NegocioMantenimiento();
    private NegocioEquipo ne = new NegocioEquipo();
    String accion = "eq";

    /**
     * Creates new form MantenimientoEquipoFmr
     */
    public MantenimientoEquipoFmr() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Registro de Mantenimiento");
        llenarTabla();
        btn_resolver.setEnabled(false);
        btn_resolver.setVisible(false);
    }

    public MantenimientoEquipoFmr(String accion) {
        this.accion = accion;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Administrar Mantenimientos");
        llenarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMant = new javax.swing.JTable();
        btnMant = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btn_resolver = new javax.swing.JButton();

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Seleccionar el Equipo al que se le Realizara Mantenimiento");

        tablaMant.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Ocupa repararse?", "Comentario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaMant);

        btnMant.setText("Registrar Mantenimiento");
        btnMant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btn_resolver.setText("Resolver");
        btn_resolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btnMant)
                .addGap(57, 57, 57)
                .addComponent(btn_resolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMant)
                    .addComponent(btnCancelar)
                    .addComponent(btn_resolver))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnMantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantActionPerformed

        if (tablaMant.getSelectedRow() != -1) {
            if (accion.equals("eq")) {
                registrarMant();
                llenarTabla();
            } else if (accion.equals("ma")) {
                actualizarMant();
                llenarTabla();
            }

        } else {
            JOptionPane.showMessageDialog(new JPanel(), "Seleccione un equipo primero!", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnMantActionPerformed

    private void btn_resolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resolverActionPerformed

        int input = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea resolverlo?\n¡Esto no se podrá deshacer!");
        if (input == 0) {
            if (tablaMant.getSelectedRow() != -1) {
                resolverMant();
                
                if (nm.desplegarMantenimientos().isEmpty()) {
                    this.dispose();
                } else {
                    llenarTabla();
                }                
            } else {
                JOptionPane.showMessageDialog(new JPanel(), "Seleccione un mantenimiento primero!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btn_resolverActionPerformed

    private void resolverMant() {
        ModeloMantenimiento man = obtenerMantLista();

        if (nm.delMantenimiento(man)) {
            JOptionPane.showMessageDialog(new JPanel(), "Hecho!");
        } else {
            JOptionPane.showMessageDialog(new JPanel(), "Error al resolver el mantenimiento!\n Ver la consola para más detalle", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarMant() {
        ModeloMantenimiento man = obtenerMantLista();
        if (tablaMant.getValueAt(tablaMant.getSelectedRow(), 3).toString() == null || tablaMant.getValueAt(tablaMant.getSelectedRow(), 3).toString().isEmpty()) {
            man.setComentario("N/A");
        } else {
            man.setComentario(tablaMant.getValueAt(tablaMant.getSelectedRow(), 3).toString());
        }

        if (nm.updMantenimiento(man)) {
            JOptionPane.showMessageDialog(new JPanel(), "Hecho!");
        } else {
            JOptionPane.showMessageDialog(new JPanel(), "Error al actualizar mantenimiento!\n Ver la consola para más detalle", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void registrarMant() {

        ModeloEquipo eq = obtenerEquipoLista();
        ModeloMantenimiento man = new ModeloMantenimiento();
        man.setEquipo(eq);
        man.setEstadoEquipo(true);
        if (tablaMant.getValueAt(tablaMant.getSelectedRow(), 3).toString() == null || tablaMant.getValueAt(tablaMant.getSelectedRow(), 3).toString().isEmpty()) {
            man.setComentario("N/A");
        } else {
            man.setComentario(tablaMant.getValueAt(tablaMant.getSelectedRow(), 3).toString());
        }

        if (nm.addMantenimiento(man)) {
            JOptionPane.showMessageDialog(new JPanel(), "Hecho!");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(new JPanel(), "Error al registrar mantenimiento!\n Ver la consola para más detalle", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private ModeloEquipo obtenerEquipoLista() {
        String id = tablaMant.getValueAt(tablaMant.getSelectedRow(), 0).toString();
        List eqs = ne.desplegarEquipos();
        for (int i = 0; i < eqs.size(); i++) {
            ModeloEquipo eq = (ModeloEquipo) eqs.get(i);
            if (eq.getIdequipo().equals(id)) {
                return eq;
            }
        }
        return null;
    }

    private ModeloMantenimiento obtenerMantLista() {
        String id = tablaMant.getValueAt(tablaMant.getSelectedRow(), 0).toString();
        List mants = nm.desplegarMantenimientos();
        for (int i = 0; i < mants.size(); i++) {
            ModeloMantenimiento man = (ModeloMantenimiento) mants.get(i);
            if (man.getIdmantenimiento().equals(id)) {
                return man;
            }
        }
        return null;
    }

    private void llenarTabla() {

        vaciarTabla();
        if (accion.equals("eq")) {
            for (Object obj : ne.desplegarEquipos()) {
                ModeloEquipo mm = (ModeloEquipo) obj;
                ((DefaultTableModel) tablaMant.getModel()).addRow(new Object[]{
                    mm.getIdequipo(), mm.getNombre(), true, ""});
            }
        } else if (accion.equals("ma")) {
            for (Object obj : nm.desplegarMantenimientos()) {
                ModeloMantenimiento mm = (ModeloMantenimiento) obj;
                String comentario;

                if (mm.getComentario() == null || mm.getComentario().isEmpty()) {
                    comentario = "N/A";
                } else {
                    comentario = mm.getComentario();
                }
                ((DefaultTableModel) tablaMant.getModel()).addRow(new Object[]{
                    mm.getIdmantenimiento(), mm.getEquipo().getNombre(), true, comentario});
            }
        }
    }

    private void vaciarTabla() {
        DefaultTableModel model = (DefaultTableModel) tablaMant.getModel();
        model.setRowCount(0);
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
            java.util.logging.Logger.getLogger(MantenimientoEquipoFmr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantenimientoEquipoFmr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantenimientoEquipoFmr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenimientoEquipoFmr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantenimientoEquipoFmr().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnMant;
    private javax.swing.JButton btn_resolver;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaMant;
    // End of variables declaration//GEN-END:variables
}
