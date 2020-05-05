/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Modelos.*;
import Negocio.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import static view.formularioModificarClienteFmr.main;

/**
 *
 * @author joshua
 */
public class MainEmpleadoFrm extends javax.swing.JFrame {

    NegocioMembresia membs = new NegocioMembresia();
    NegocioCliente ctes = new NegocioCliente();
    NegocioProducto np = new NegocioProducto();

    /**
     * Creates new form MainEmpleadoFrm
     */
    public MainEmpleadoFrm() {
        initComponents();
        this.setTitle("STEEL FACTORY GYM SISTEMA DE GESTION");
        this.setLocationRelativeTo(null);
        //this.setResizable(false);
        rellenarTabla(membs.desplegarMembresias());
        crearEventoTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelImagen = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        panelInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDireccion = new javax.swing.JTextArea();
        btnEliminar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        objMenuRegistrarMembresia = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        objMenuModificarMembresia = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        objMenuRenovarMembresia = new javax.swing.JMenuItem();
        menuProductos = new javax.swing.JMenu();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        objMenuRegistroProductos = new javax.swing.JMenuItem();
        objMenuInventario = new javax.swing.JMenuItem();
        editarProductoMenu = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        objMenuVentaProducto = new javax.swing.JMenuItem();
        menuReporteVentas = new javax.swing.JMenu();
        objMenuReporteVentas = new javax.swing.JMenuItem();
        MenuEquipo = new javax.swing.JMenu();
        objMenuRegistrarEquipo = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        objMenuMantenimiento = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuAsistencias = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        labelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/steelFactoryGym.jpg"))); // NOI18N

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Inicio", "Fin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        panelInfo.setVisible(false);
        panelInfo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Nombre:");

        lblNombre.setText("-");

        jLabel3.setText("Telefono;");

        lblTelefono.setText("-");

        jLabel5.setText("Dirección:");

        txtDireccion.setEditable(false);
        txtDireccion.setColumns(20);
        txtDireccion.setLineWrap(true);
        txtDireccion.setRows(5);
        txtDireccion.setWrapStyleWord(true);
        txtDireccion.setAutoscrolls(false);
        jScrollPane2.setViewportView(txtDireccion);

        javax.swing.GroupLayout panelInfoLayout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(panelInfoLayout);
        panelInfoLayout.setHorizontalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelInfoLayout.createSequentialGroup()
                        .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelInfoLayout.setVerticalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTelefono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jMenu1.setText("Membresia");

        objMenuRegistrarMembresia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        objMenuRegistrarMembresia.setText("Registrar Nueva Membresia");
        objMenuRegistrarMembresia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                objMenuRegistrarMembresiaActionPerformed(evt);
            }
        });
        jMenu1.add(objMenuRegistrarMembresia);
        jMenu1.add(jSeparator1);

        objMenuModificarMembresia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        objMenuModificarMembresia.setText("Modificar Membresia");
        objMenuModificarMembresia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                objMenuModificarMembresiaActionPerformed(evt);
            }
        });
        jMenu1.add(objMenuModificarMembresia);
        jMenu1.add(jSeparator2);

        objMenuRenovarMembresia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        objMenuRenovarMembresia.setText("Renovar Membresia");
        objMenuRenovarMembresia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                objMenuRenovarMembresiaActionPerformed(evt);
            }
        });
        jMenu1.add(objMenuRenovarMembresia);

        jMenuBar1.add(jMenu1);

        menuProductos.setText("Productos");
        menuProductos.add(jSeparator3);

        objMenuRegistroProductos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK));
        objMenuRegistroProductos.setText("Registrar Productos");
        objMenuRegistroProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                objMenuRegistroProductosActionPerformed(evt);
            }
        });
        menuProductos.add(objMenuRegistroProductos);

        objMenuInventario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.SHIFT_MASK));
        objMenuInventario.setText("Inventariar Productos");
        objMenuInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                objMenuInventarioActionPerformed(evt);
            }
        });
        menuProductos.add(objMenuInventario);

        editarProductoMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK));
        editarProductoMenu.setText("Editar producto");
        editarProductoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarProductoMenuActionPerformed(evt);
            }
        });
        menuProductos.add(editarProductoMenu);
        menuProductos.add(jSeparator4);

        objMenuVentaProducto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        objMenuVentaProducto.setText("Vender Productos");
        objMenuVentaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                objMenuVentaProductoActionPerformed(evt);
            }
        });
        menuProductos.add(objMenuVentaProducto);

        jMenuBar1.add(menuProductos);

        menuReporteVentas.setText("Reporte de Ventas");

        objMenuReporteVentas.setText("Generar Reporte de Ventas");
        objMenuReporteVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                objMenuReporteVentasActionPerformed(evt);
            }
        });
        menuReporteVentas.add(objMenuReporteVentas);

        jMenuBar1.add(menuReporteVentas);

        MenuEquipo.setText("Equipo");

        objMenuRegistrarEquipo.setText("Registrar Equipo");
        objMenuRegistrarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                objMenuRegistrarEquipoActionPerformed(evt);
            }
        });
        MenuEquipo.add(objMenuRegistrarEquipo);
        MenuEquipo.add(jSeparator5);

        objMenuMantenimiento.setText("Registrar Mantenimiento de Equipo");
        objMenuMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                objMenuMantenimientoActionPerformed(evt);
            }
        });
        MenuEquipo.add(objMenuMantenimiento);

        jMenuBar1.add(MenuEquipo);

        jMenu2.setText("Asistencias");

        menuAsistencias.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuAsistencias.setText("Abrir menú de asistencias");
        menuAsistencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAsistenciasActionPerformed(evt);
            }
        });
        jMenu2.add(menuAsistencias);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar))
                    .addComponent(panelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnActualizar)
                            .addComponent(btnEliminar))
                        .addGap(18, 18, 18)
                        .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void objMenuRenovarMembresiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objMenuRenovarMembresiaActionPerformed
        solicitaId si = new solicitaId("Renovar", this);
        si.setVisible(true);
    }//GEN-LAST:event_objMenuRenovarMembresiaActionPerformed

    private void objMenuRegistrarMembresiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objMenuRegistrarMembresiaActionPerformed
        formularioModificarClienteFmr modificar = new formularioModificarClienteFmr("registrar", this);
        modificar.setVisible(true);

    }//GEN-LAST:event_objMenuRegistrarMembresiaActionPerformed

    private void objMenuModificarMembresiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objMenuModificarMembresiaActionPerformed
        solicitaId si = new solicitaId("Modificar", this);
        si.setVisible(true);
    }//GEN-LAST:event_objMenuModificarMembresiaActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        rellenarTabla(membs.desplegarMembresias());
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed

    private void tablaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaKeyPressed

        if (evt.getSource() == tabla) {
            switch (evt.getKeyCode()) {
                case KeyEvent.VK_R:
                    if (tabla.getSelectedRow() != -1) {
                        if (!membs.isMembresiaVigente(tabla.getValueAt(tabla.getSelectedRow(), 0).toString())) {
                            formularioModificarClienteFmr modificar = new formularioModificarClienteFmr("renovar", this);
                            llenarFormulario(modificar, "Renovar");
                        } else {
                            JOptionPane.showMessageDialog(new JPanel(), "La membresia del cliente todavía está vigente, no se puede renovar!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(new JPanel(), "No ha seleccionado una membresia a renovar!", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    break;

                case KeyEvent.VK_M:
                    if (tabla.getSelectedRow() != -1) {
                        formularioModificarClienteFmr modificar = new formularioModificarClienteFmr(this);
                        modificar.comboTipo.setEnabled(false);
                        llenarFormulario(modificar, "");
                    } else {
                        JOptionPane.showMessageDialog(new JPanel(), "No ha seleccionado una membresia de un cliente a modificar!", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    break;
            }
        }

    }//GEN-LAST:event_tablaKeyPressed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (tabla.getSelectedRow() != -1) {
            eliminarMembresia();
        } else {
            JOptionPane.showMessageDialog(new JPanel(), "No ha seleccionado una membresia de un cliente a eliminar!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void objMenuMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objMenuMantenimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_objMenuMantenimientoActionPerformed

    private void objMenuRegistrarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objMenuRegistrarEquipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_objMenuRegistrarEquipoActionPerformed

    private void objMenuReporteVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objMenuReporteVentasActionPerformed
        // TODO add your handling code here:
        PeriodoFmr p  = new PeriodoFmr();
        p.setVisible(true);
    }//GEN-LAST:event_objMenuReporteVentasActionPerformed

    private void objMenuVentaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objMenuVentaProductoActionPerformed
        // TODO add your handling code here:
        ProductoFmr p = new ProductoFmr("Venta Productos");
        if (p.llenarComboVenta()) {
            p.setVisible(true);
        } else {
            p.noserequiere = true;
            p.dispose();
            JOptionPane.showMessageDialog(new JPanel(), "No hay inventario o no hay productos registrados!\nFavor de inventariar productos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_objMenuVentaProductoActionPerformed

    private void objMenuInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objMenuInventarioActionPerformed
        // TODO add your handling code here:
        ProductoFmr p = new ProductoFmr("Inventariar Productos");
        p.setVisible(true);
    }//GEN-LAST:event_objMenuInventarioActionPerformed

    private void objMenuRegistroProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objMenuRegistroProductosActionPerformed
        // TODO add your handling code here:
        RegistrarProducto rp = new RegistrarProducto();
        rp.setVisible(true);
    }//GEN-LAST:event_objMenuRegistroProductosActionPerformed

    private void editarProductoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarProductoMenuActionPerformed
        if (np.desplegarProductos().isEmpty()) {
            JOptionPane.showMessageDialog(new JPanel(), "No hay productos registrados!\nFavor de registrar productos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            solicitaProducto sp = new solicitaProducto();
            sp.setVisible(true);
        }
    }//GEN-LAST:event_editarProductoMenuActionPerformed

    private void menuAsistenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAsistenciasActionPerformed
        if (ctes.desplegarClientes().isEmpty()) {
            JOptionPane.showMessageDialog(new JPanel(), "No hay productos registrados!\nFavor de registrar productos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            MainClienteFrm cf = new MainClienteFrm();
            cf.setVisible(true);
        }
    }//GEN-LAST:event_menuAsistenciasActionPerformed

    private void eliminarMembresia() {
        String id = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();

        if (!membs.isMembresiaVigente(id)) {
            int input = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar la membresía?\n¡Esto no se podrá deshacer!");
            if (input == 0) {
                boolean stat = membs.delMembresia(id);
                if (!stat) {
                    JOptionPane.showMessageDialog(new JPanel(), "Error al eliminar!\n Ver la consola para más detalle", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(new JPanel(), "Hecho!");
                }
                llenarTabla();
            }
        } else {
            JOptionPane.showMessageDialog(new JPanel(), "Error al eliminar!\n La membresía aún está vigente!", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void llenarFormulario(formularioModificarClienteFmr modificar, String Accion) {
        ModeloMembresia mem = membs.obtenerMembresia(tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
        modificar.txfNombre.setText(mem.getCliente().getNombre());
        modificar.txfDireccion.setText(mem.getCliente().getDireccion());
        modificar.txfTelefono.setText(mem.getCliente().getTelefono());
        modificar.txfID.setText(Integer.toString(mem.getCliente().getId()));

        if ("Renovar".equals(Accion)) {
            modificar.txfNombre.setEnabled(false);
            modificar.txfID.setEnabled(false);
            modificar.txfDireccion.setEnabled(false);
            modificar.txfTelefono.setEnabled(false);
        }
        modificar.setVisible(true);
    }

    public void llenarTabla() {
        rellenarTabla(membs.desplegarMembresias());
    }

    public void actualizarLista() {

    }

    private void crearEventoTabla() {
        tabla.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            panelInfo.setVisible(true);
            String id;
            if (!e.getValueIsAdjusting() && tabla.getSelectedRow() != -1) {
                id = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
                ModeloCliente cte = ctes.obtenerCliente(id);
                lblNombre.setText(cte.getNombre());
                lblTelefono.setText(cte.getTelefono());
                txtDireccion.setText(cte.getDireccion());
            } else if (tabla.getSelectedRow() == -1) {
                panelInfo.setVisible(false);
            }

            //tabla.clearSelection();
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        });
    }

    private void rellenarTabla(List memlista) {
        vaciarTabla();
        for (Object obj : memlista) {
            ModeloMembresia mem = (ModeloMembresia) obj;
            ((DefaultTableModel) tabla.getModel()).addRow(new Object[]{
                mem.getCliente().getId(), mem.getCliente().getNombre(), mem.getFechaIn().toString(), mem.getFechaFin().toString()});
        }
    }

    private void vaciarTabla() {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
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
            java.util.logging.Logger.getLogger(MainEmpleadoFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainEmpleadoFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainEmpleadoFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainEmpleadoFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainEmpleadoFrm().setVisible(true);

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuEquipo;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JMenuItem editarProductoMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JMenuItem menuAsistencias;
    private javax.swing.JMenu menuProductos;
    private javax.swing.JMenu menuReporteVentas;
    private javax.swing.JMenuItem objMenuInventario;
    private javax.swing.JMenuItem objMenuMantenimiento;
    private javax.swing.JMenuItem objMenuModificarMembresia;
    private javax.swing.JMenuItem objMenuRegistrarEquipo;
    private javax.swing.JMenuItem objMenuRegistrarMembresia;
    private javax.swing.JMenuItem objMenuRegistroProductos;
    private javax.swing.JMenuItem objMenuRenovarMembresia;
    private javax.swing.JMenuItem objMenuReporteVentas;
    private javax.swing.JMenuItem objMenuVentaProducto;
    private javax.swing.JPanel panelInfo;
    public javax.swing.JTable tabla;
    private javax.swing.JTextArea txtDireccion;
    // End of variables declaration//GEN-END:variables

}
