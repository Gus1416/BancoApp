/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package logicadepresentacion.gui;

import java.util.ArrayList;
import logicadeintegracion.gui.ControladorConsultarCuenta;
import logicadenegocios.Ordenacion;

/**
 *
 * @author Alejandra Merino
 */
public class ConsultarCuenta extends javax.swing.JPanel {
  private ControladorConsultarCuenta consulta;
  private ArrayList listaCuentas;
  /**
   * Creates new form ConsultarCuenta
   */
  public ConsultarCuenta() {
    initComponents();
    consulta = new ControladorConsultarCuenta ();
    listaCuentas = consulta.cargarCuentas();
    Ordenacion ordena = new Ordenacion ();
    ordena.insercion(listaCuentas);
  }
  
  private void cargarListaCuentas() {
    for (int i =0;i<listaCuentas.size(); i++) {
      cbxListaCuentas.addItem(listaCuentas.get(i).toString());
    }
    
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
    cbxListaCuentas = new javax.swing.JComboBox<>();
    jScrollPane1 = new javax.swing.JScrollPane();
    txtConsultaCuenta = new javax.swing.JTextArea();
    btnConsultarCuentaPanel = new javax.swing.JPanel();
    btnConsultaCuentaLabel = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jSeparator1 = new javax.swing.JSeparator();
    jScrollPane2 = new javax.swing.JScrollPane();
    txtDuenioCuenta = new javax.swing.JTextArea();

    jPanel1.setBackground(new java.awt.Color(255, 255, 255));

    jLabel1.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(0, 0, 0));
    jLabel1.setText("Consulte una cuenta");

    jLabel2.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(0, 0, 0));
    jLabel2.setText("Seleccione una cuenta de la lista:");

    cbxListaCuentas.setBackground(new java.awt.Color(255, 255, 255));
    cbxListaCuentas.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
    cbxListaCuentas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
    cbxListaCuentas.setBorder(null);
    cbxListaCuentas.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseReleased(java.awt.event.MouseEvent evt) {
        cbxListaCuentasMouseReleased(evt);
      }
    });

    txtConsultaCuenta.setBackground(new java.awt.Color(255, 255, 255));
    txtConsultaCuenta.setColumns(20);
    txtConsultaCuenta.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
    txtConsultaCuenta.setRows(5);
    jScrollPane1.setViewportView(txtConsultaCuenta);

    btnConsultaCuentaLabel.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
    btnConsultaCuentaLabel.setForeground(new java.awt.Color(255, 255, 255));
    btnConsultaCuentaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    btnConsultaCuentaLabel.setText("Consultar");
    btnConsultaCuentaLabel.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        btnConsultaCuentaLabelMouseClicked(evt);
      }
    });

    javax.swing.GroupLayout btnConsultarCuentaPanelLayout = new javax.swing.GroupLayout(btnConsultarCuentaPanel);
    btnConsultarCuentaPanel.setLayout(btnConsultarCuentaPanelLayout);
    btnConsultarCuentaPanelLayout.setHorizontalGroup(
      btnConsultarCuentaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnConsultarCuentaPanelLayout.createSequentialGroup()
        .addContainerGap(10, Short.MAX_VALUE)
        .addComponent(btnConsultaCuentaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );
    btnConsultarCuentaPanelLayout.setVerticalGroup(
      btnConsultarCuentaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(btnConsultarCuentaPanelLayout.createSequentialGroup()
        .addGap(14, 14, 14)
        .addComponent(btnConsultaCuentaLabel)
        .addContainerGap(15, Short.MAX_VALUE))
    );

    jLabel4.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(0, 0, 0));
    jLabel4.setText("Due�a (o) de la cuenta:");

    txtDuenioCuenta.setBackground(new java.awt.Color(255, 255, 255));
    txtDuenioCuenta.setColumns(20);
    txtDuenioCuenta.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
    txtDuenioCuenta.setRows(5);
    txtDuenioCuenta.setBorder(null);
    jScrollPane2.setViewportView(txtDuenioCuenta);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
              .addGap(263, 263, 263)
              .addComponent(jLabel1))
            .addGroup(jPanel1Layout.createSequentialGroup()
              .addGap(358, 358, 358)
              .addComponent(btnConsultarCuentaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
              .addGap(107, 107, 107)
              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(cbxListaCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
                  .addComponent(jScrollPane2))
                .addComponent(jLabel4)
                .addComponent(jLabel2)))))
        .addContainerGap(97, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(68, 68, 68)
        .addComponent(jLabel1)
        .addGap(18, 18, 18)
        .addComponent(jLabel2)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(cbxListaCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jLabel4)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(btnConsultarCuentaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(70, 70, 70))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 717, Short.MAX_VALUE)
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

  private void cbxListaCuentasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxListaCuentasMouseReleased
    String idCuenta = (String) cbxListaCuentas.getSelectedItem();
    idCuenta = idCuenta.trim();
    String[] listaCuenta = idCuenta.split(" ");
    String resultado = consulta.cargarPropietarioCuenta(listaCuenta[0]);
    txtDuenioCuenta.setText(resultado);
  }//GEN-LAST:event_cbxListaCuentasMouseReleased

  private void btnConsultaCuentaLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultaCuentaLabelMouseClicked
    String idCuenta = (String) cbxListaCuentas.getSelectedItem();
    idCuenta = idCuenta.trim();
    String[] listaCuenta = idCuenta.split(" ");
    String resultado = consulta.cargarCuenta(idCuenta);
    txtConsultaCuenta.setText(resultado);
  }//GEN-LAST:event_btnConsultaCuentaLabelMouseClicked


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel btnConsultaCuentaLabel;
  private javax.swing.JPanel btnConsultarCuentaPanel;
  private javax.swing.JComboBox<String> cbxListaCuentas;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JTextArea txtConsultaCuenta;
  private javax.swing.JTextArea txtDuenioCuenta;
  // End of variables declaration//GEN-END:variables
}
