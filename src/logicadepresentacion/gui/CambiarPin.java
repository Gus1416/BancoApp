/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package logicadepresentacion.gui;

import javax.swing.JOptionPane;
import logicadeintegracion.gui.ControladorCambioPin;
import logicadeintegracion.gui.ControladorInactivacionCuenta;
import logicadevalidacion.ValidacionCuenta;

/**
 *
 * @author Alejandra Merino
 */
public class CambiarPin extends javax.swing.JPanel {
  public ControladorCambioPin control;
  private ValidacionCuenta validacionCuenta;
  /**
   * Creates new form CambiarPin
   */
  public CambiarPin() {
    initComponents();
    control = new ControladorCambioPin ();
    validacionCuenta = new ValidacionCuenta ();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    txtNumCuenta = new javax.swing.JTextField();
    jSeparator1 = new javax.swing.JSeparator();
    jLabel3 = new javax.swing.JLabel();
    txtPinActual = new javax.swing.JTextField();
    jSeparator2 = new javax.swing.JSeparator();
    jLabel4 = new javax.swing.JLabel();
    txtPinNuevo = new javax.swing.JTextField();
    jSeparator3 = new javax.swing.JSeparator();
    btnCambiarPinPanel = new javax.swing.JPanel();
    btnCambiarPinLabel = new javax.swing.JLabel();

    setPreferredSize(new java.awt.Dimension(829, 710));

    jPanel1.setBackground(new java.awt.Color(255, 255, 255));

    jLabel1.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(0, 0, 0));
    jLabel1.setText("Cambie su PIN");

    jLabel2.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
    jLabel2.setText("Ingrese su n�mero de cuenta:");

    txtNumCuenta.setBackground(new java.awt.Color(255, 255, 255));
    txtNumCuenta.setBorder(null);
    txtNumCuenta.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtNumCuentaActionPerformed(evt);
      }
    });

    jLabel3.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
    jLabel3.setText("Ingrese el PIN actual de su cuenta:");

    txtPinActual.setBackground(new java.awt.Color(255, 255, 255));
    txtPinActual.setBorder(null);

    jLabel4.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
    jLabel4.setText("Ingrese el nuevo PIN de su cuenta:");

    txtPinNuevo.setBackground(new java.awt.Color(255, 255, 255));
    txtPinNuevo.setBorder(null);

    btnCambiarPinLabel.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
    btnCambiarPinLabel.setForeground(new java.awt.Color(255, 255, 255));
    btnCambiarPinLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    btnCambiarPinLabel.setText("Cambiar");
    btnCambiarPinLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnCambiarPinLabel.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        btnCambiarPinLabelMouseClicked(evt);
      }
    });

    javax.swing.GroupLayout btnCambiarPinPanelLayout = new javax.swing.GroupLayout(btnCambiarPinPanel);
    btnCambiarPinPanel.setLayout(btnCambiarPinPanelLayout);
    btnCambiarPinPanelLayout.setHorizontalGroup(
      btnCambiarPinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(btnCambiarPinLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
    );
    btnCambiarPinPanelLayout.setVerticalGroup(
      btnCambiarPinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(btnCambiarPinPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(btnCambiarPinLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        .addContainerGap())
    );

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(300, 300, 300)
            .addComponent(jLabel1))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(163, 163, 163)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(jLabel2)
              .addComponent(jSeparator1)
              .addComponent(txtNumCuenta)
              .addComponent(jLabel3)
              .addComponent(txtPinActual)
              .addComponent(jSeparator2)
              .addComponent(jLabel4)
              .addComponent(txtPinNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
              .addComponent(jSeparator3)))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(338, 338, 338)
            .addComponent(btnCambiarPinPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(163, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(79, 79, 79)
        .addComponent(jLabel1)
        .addGap(35, 35, 35)
        .addComponent(jLabel2)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(txtNumCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel3)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(txtPinActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jLabel4)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(txtPinNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(45, 45, 45)
        .addComponent(btnCambiarPinPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(301, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
  }// </editor-fold>//GEN-END:initComponents

  private void txtNumCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumCuentaActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_txtNumCuentaActionPerformed

  private void btnCambiarPinLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambiarPinLabelMouseClicked
    System.out.println("Cantidad de veces que falla antes: "+validacionCuenta.getFallaPin());
    validacionCuenta.validarCambioPin(txtPinActual.getText(), txtPinNuevo.getText(), txtNumCuenta.getText());
    System.out.println("Cantidad de veces que falla: "+validacionCuenta.getFallaPin());
    if (validacionCuenta.esValido()) {
      String mensaje = control.controlarCambioPin(txtNumCuenta.getText(), txtPinNuevo.getText());
      validacionCuenta.setResultado(mensaje);
    }
    JOptionPane.showMessageDialog(this, validacionCuenta.getResultado());
    
  }//GEN-LAST:event_btnCambiarPinLabelMouseClicked


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel btnCambiarPinLabel;
  private javax.swing.JPanel btnCambiarPinPanel;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JSeparator jSeparator2;
  private javax.swing.JSeparator jSeparator3;
  private javax.swing.JTextField txtNumCuenta;
  private javax.swing.JTextField txtPinActual;
  private javax.swing.JTextField txtPinNuevo;
  // End of variables declaration//GEN-END:variables
}
