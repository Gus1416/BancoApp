/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package logicadepresentacion.gui;

/**
 *
 * @author Alejandra Merino
 */
public class CrearCuenta extends javax.swing.JPanel {

  /**
   * Creates new form CrearCuenta
   */
  public CrearCuenta() {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    bgCrearCuenta = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();

    setBackground(new java.awt.Color(255, 255, 255));
    setPreferredSize(new java.awt.Dimension(830, 710));
    setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    bgCrearCuenta.setBackground(new java.awt.Color(255, 255, 255));

    jLabel1.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(0, 0, 0));
    jLabel1.setText("Crea una nueva cuenta");

    javax.swing.GroupLayout bgCrearCuentaLayout = new javax.swing.GroupLayout(bgCrearCuenta);
    bgCrearCuenta.setLayout(bgCrearCuentaLayout);
    bgCrearCuentaLayout.setHorizontalGroup(
      bgCrearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(bgCrearCuentaLayout.createSequentialGroup()
        .addGap(247, 247, 247)
        .addComponent(jLabel1)
        .addContainerGap(292, Short.MAX_VALUE))
    );
    bgCrearCuentaLayout.setVerticalGroup(
      bgCrearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(bgCrearCuentaLayout.createSequentialGroup()
        .addGap(76, 76, 76)
        .addComponent(jLabel1)
        .addContainerGap(604, Short.MAX_VALUE))
    );

    add(bgCrearCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 710));
  }// </editor-fold>//GEN-END:initComponents


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel bgCrearCuenta;
  private javax.swing.JLabel jLabel1;
  // End of variables declaration//GEN-END:variables
}
