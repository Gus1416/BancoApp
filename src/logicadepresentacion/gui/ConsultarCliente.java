/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package logicadepresentacion.gui;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import logicadeintegracion.gui.ControladorConsultarCliente;
import logicadeintegracion.gui.ControladorCrearCuenta;
import logicadenegocios.Ordenacion;

/**
 *
 * @author Alejandra Merino
 */
public class ConsultarCliente extends javax.swing.JPanel {
  private ArrayList listaClientes;
  private ControladorCrearCuenta control;
  private ControladorConsultarCliente consulta;
  /**
   * Creates new form ConsultarCliente
   */
  public ConsultarCliente() {
    initComponents();
    control = new ControladorCrearCuenta ();
    consulta = new ControladorConsultarCliente ();
    listaClientes = control.cargarClientes();
    cargarListaClientes();
    Ordenacion ordena = new Ordenacion ();
    ordena.insercion(listaClientes);
  }
  
  private void cargarListaClientes() {
    for (int i =0;i<listaClientes.size(); i++) {
      cbxListadoClientes.addItem(listaClientes.get(i).toString());
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

    panel1 = new java.awt.Panel();
    jLabel1 = new javax.swing.JLabel();
    cbxListadoClientes = new javax.swing.JComboBox<>();
    jLabel2 = new javax.swing.JLabel();
    panel2 = new java.awt.Panel();
    btnConsultarClienteLabel = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    txtMuestraConsultaCliente = new javax.swing.JTextArea();

    setBackground(new java.awt.Color(255, 255, 255));
    setPreferredSize(new java.awt.Dimension(830, 710));

    jLabel1.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(0, 0, 0));
    jLabel1.setText("Consulte un cliente");

    cbxListadoClientes.setBackground(new java.awt.Color(255, 255, 255));
    cbxListadoClientes.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

    jLabel2.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(0, 0, 0));
    jLabel2.setText("Seleccione un cliente de la lista:");

    panel2.setBackground(new java.awt.Color(153, 153, 153));

    btnConsultarClienteLabel.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
    btnConsultarClienteLabel.setForeground(new java.awt.Color(255, 255, 255));
    btnConsultarClienteLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    btnConsultarClienteLabel.setText("Consultar");
    btnConsultarClienteLabel.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        btnConsultarClienteLabelMouseClicked(evt);
      }
    });

    javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
    panel2.setLayout(panel2Layout);
    panel2Layout.setHorizontalGroup(
      panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(btnConsultarClienteLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
    );
    panel2Layout.setVerticalGroup(
      panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(btnConsultarClienteLabel)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

    txtMuestraConsultaCliente.setBackground(new java.awt.Color(255, 255, 255));
    txtMuestraConsultaCliente.setColumns(20);
    txtMuestraConsultaCliente.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
    txtMuestraConsultaCliente.setRows(5);
    jScrollPane1.setViewportView(txtMuestraConsultaCliente);

    javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
    panel1.setLayout(panel1Layout);
    panel1Layout.setHorizontalGroup(
      panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panel1Layout.createSequentialGroup()
        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(panel1Layout.createSequentialGroup()
            .addGap(262, 262, 262)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(panel1Layout.createSequentialGroup()
            .addGap(173, 173, 173)
            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(jLabel2)
              .addComponent(cbxListadoClientes, 0, 466, Short.MAX_VALUE)
              .addComponent(jScrollPane1)))
          .addGroup(panel1Layout.createSequentialGroup()
            .addGap(339, 339, 339)
            .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(191, Short.MAX_VALUE))
    );
    panel1Layout.setVerticalGroup(
      panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panel1Layout.createSequentialGroup()
        .addGap(97, 97, 97)
        .addComponent(jLabel1)
        .addGap(35, 35, 35)
        .addComponent(jLabel2)
        .addGap(18, 18, 18)
        .addComponent(cbxListadoClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(46, 46, 46)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(29, 29, 29)
        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(71, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
  }// </editor-fold>//GEN-END:initComponents

  private void btnConsultarClienteLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarClienteLabelMouseClicked
    String idCliente = (String) cbxListadoClientes.getSelectedItem();
    idCliente = idCliente.trim();
    String[] listaCliente = idCliente.split(" ");
    String resultado = consulta.controlarConsultaCliente(listaCliente[listaCliente.length-1]);
    txtMuestraConsultaCliente.setText(resultado);
  }//GEN-LAST:event_btnConsultarClienteLabelMouseClicked


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel btnConsultarClienteLabel;
  private javax.swing.JComboBox<String> cbxListadoClientes;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JScrollPane jScrollPane1;
  private java.awt.Panel panel1;
  private java.awt.Panel panel2;
  private javax.swing.JTextArea txtMuestraConsultaCliente;
  // End of variables declaration//GEN-END:variables
}
