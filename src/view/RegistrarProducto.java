/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Modelos.ModeloProducto;
import Negocio.NegocioProducto;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author k3vin
 */
public class RegistrarProducto extends javax.swing.JFrame {

    NegocioProducto productos = new NegocioProducto();
    String accion = "reg";
    ModeloProducto prod;

    /**
     * Creates new form RegistrarProducto
     */
    public RegistrarProducto() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Registrar Producto");
    }

    public RegistrarProducto(String accion, ModeloProducto prod) {
        this.prod = prod;
        this.accion = accion;
        initComponents();
        this.setTitle("Editar Producto");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        campoTextoNombre.setText(prod.getNombre());
        campoTextoPrecio.setText(prod.getPrecio() + "");
        campoTextoCantidad.setText(prod.getCantidad() + "");
        campoTextoCantidad.setEnabled(false);
        categorizarProducto(prod.getCategoria());
        System.out.println(prod.getCategoria());
        btnAgregar.setText("Actualizar");
        jLabel6.setText("Actualizar Producto");
    }

    private void registrarProducto() {
        if (campoTextoCantidad.getText().equals("")) {
            campoTextoCantidad.setText("0");
        }
        if (accion == "reg") {
            if (validarEntrada()) {
                String nombre = campoTextoNombre.getText();
                String precio = campoTextoPrecio.getText();
                String cantidad = campoTextoCantidad.getText();
                int categoria = obtenerCategoria();
                try {
                    double test = Double.parseDouble(precio);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(new JPanel(), "Cantidad Inválida", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                ModeloProducto prod = new ModeloProducto(nombre, Integer.parseInt(cantidad), Double.parseDouble(precio), categoria);
                if (productos.addProducto(prod)) {
                    JOptionPane.showMessageDialog(new JPanel(), "Se registró el producto correctamente");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(new JPanel(), "Ocurrió un error interno, verifica la consola para mas detalles", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        } else if (accion == "ed") {
            if (validarEntrada()) {
                prod.setNombre(campoTextoNombre.getText());
                try {
                    double test = Double.parseDouble(campoTextoPrecio.getText());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(new JPanel(), "Cantidad Inválida", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                prod.setPrecio(Double.parseDouble(campoTextoPrecio.getText()));
                prod.setCategoria(obtenerCategoria());
                //ModeloProducto prod = new ModeloProducto(nombre, Integer.parseInt(cantidad), Double.parseDouble(precio), categoria);
                if (productos.updProducto(prod)) {
                    JOptionPane.showMessageDialog(new JPanel(), "Se actualizó el producto correctamente");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(new JPanel(), "Ocurrió un error interno, verifica la consola para mas detalles", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        }

    }

    private void categorizarProducto(int cat) {
        switch (cat) {
            case 1:
                comboBoxCategorias.setSelectedIndex(0);
                break;
            case 2:
                comboBoxCategorias.setSelectedIndex(1);
                break;
            case 3:
                comboBoxCategorias.setSelectedIndex(2);
                break;
            case 4:
                comboBoxCategorias.setSelectedIndex(3);
                break;
            case 5:
                comboBoxCategorias.setSelectedIndex(4);
                break;
            default:
                System.out.println("Error");
                break;
        }
    }

    private int obtenerCategoria() {
        String categoria = comboBoxCategorias.getSelectedItem().toString();
        switch (categoria) {
            case "Articulos para Ejercicio":
                return 1;
            case "Proteina":
                return 2;
            case "Aminoácidos":
                return 3;
            case "Termogenico":
                return 4;
            case "Otro":
                return 5;
        }

        return -1;
    }

    private boolean validarEntrada() {
        String nombre = campoTextoNombre.getText();
        String precio = campoTextoPrecio.getText();
        String cantidad = campoTextoCantidad.getText();
        //String categoria = comboBoxCategorias.getSelectedItem().toString();
        if (!nombre.matches("[ 0-9A-Za-zñÑáéíóúÁÉÍÓÚ]{1,45}")) {
            JOptionPane.showMessageDialog(new JPanel(), "El nombre no es válido\n No debe contener símbolos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (existeProductoNombre(nombre)) {
            JOptionPane.showMessageDialog(new JPanel(), "El nombre no es válido\n Ya existe un producto con ese nombre", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (nombre.length() > 45) {
            JOptionPane.showMessageDialog(new JPanel(), "El nombre no es válido\n Excede 45 caracteres", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!cantidad.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(new JPanel(), "Cantidad inválida", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!precio.matches("[0-9]+(.[0-9]+)?")) {
            JOptionPane.showMessageDialog(new JPanel(), "Precio inválido", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private boolean existeProductoNombre(String nombre) {
        List prods = productos.desplegarProductos();

        for (int i = 0; i < prods.size(); i++) {
            ModeloProducto mp = (ModeloProducto) prods.get(i);
            if (mp.getNombre().equals(nombre)) {
                return true;
            }
        }

        return false;
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoTextoNombre = new javax.swing.JTextField();
        campoTextoPrecio = new javax.swing.JTextField();
        comboBoxCategorias = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        campoTextoCantidad = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Steel Factory Gym");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Precio:");

        jLabel4.setText("Categoria:");

        campoTextoPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoTextoPrecioKeyPressed(evt);
            }
        });

        comboBoxCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Articulos para Ejercicio", "Proteina", "Aminoácidos", "Termogenico", "Otro" }));
        comboBoxCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCategoriasActionPerformed(evt);
            }
        });
        comboBoxCategorias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboBoxCategoriasKeyPressed(evt);
            }
        });

        jLabel6.setText("Registrar Producto");

        jLabel7.setText("Cantidad:");

        campoTextoCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoTextoCantidadKeyPressed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                            .addComponent(campoTextoNombre)
                            .addComponent(campoTextoPrecio)
                            .addComponent(comboBoxCategorias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoTextoCantidad)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addComponent(jLabel6)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoTextoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoTextoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(campoTextoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnSalir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCategoriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxCategoriasActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        registrarProducto();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void campoTextoCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTextoCantidadKeyPressed
        if (evt.getSource().equals(campoTextoCantidad)) {
            switch (evt.getKeyCode()) {
                case KeyEvent.VK_ENTER:
                    btnAgregarActionPerformed(null);
                    break;
            }
        }
    }//GEN-LAST:event_campoTextoCantidadKeyPressed

    private void campoTextoPrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTextoPrecioKeyPressed
        if (evt.getSource().equals(campoTextoPrecio)) {
            switch (evt.getKeyCode()) {
                case KeyEvent.VK_ENTER:
                    btnAgregarActionPerformed(null);
                    break;
            }
        }
    }//GEN-LAST:event_campoTextoPrecioKeyPressed

    private void comboBoxCategoriasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboBoxCategoriasKeyPressed
        if (evt.getSource().equals(comboBoxCategorias)) {
            switch (evt.getKeyCode()) {
                case KeyEvent.VK_ENTER:
                    btnAgregarActionPerformed(null);
                    break;
            }
        }
    }//GEN-LAST:event_comboBoxCategoriasKeyPressed

    public String generateUniqueId() {
        UUID idOne = UUID.randomUUID();
        String str = "" + idOne;
        int uid = str.hashCode();
        String filterStr = "" + uid;
        System.out.println(filterStr);
        str = filterStr.replaceAll("-", "").substring(3, 9);
        return str;
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
            java.util.logging.Logger.getLogger(RegistrarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JTextField campoTextoCantidad;
    private javax.swing.JTextField campoTextoNombre;
    private javax.swing.JTextField campoTextoPrecio;
    private javax.swing.JComboBox<String> comboBoxCategorias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
