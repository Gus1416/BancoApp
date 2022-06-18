package logicadepresentacion.gui;

import logicadevalidacion.ValidacionCliente;
import logicadevalidacion.ValidacionPersona;
import javax.swing.JOptionPane;
import logicacreacional.SimpleValidacionFactory;
import logicadeintegracion.gui.ControladorRegistroCliente;

/**
 *
 * @author Alejandra Merino
 */
public class RegistrarCliente extends javax.swing.JPanel {
    private SimpleValidacionFactory factoryValidacion;
  /**
   * Creates new form RegistrarCliente
   */
  public RegistrarCliente(SimpleValidacionFactory pFactoryValidacion) {
    initComponents();
    factoryValidacion = pFactoryValidacion;
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator7 = new javax.swing.JSeparator();
        bgRegistrarCliente = new javax.swing.JPanel();
        titleRegistraClienteLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt1Apellido = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        txt2Apellido = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        txtNombre = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        txtIdentificacion = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        btnGuardarClientePanel = new javax.swing.JPanel();
        btnGuardarClienteLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        txtCorreo = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        fechaNacimientoCliente = new com.toedter.calendar.JDateChooser();

        setPreferredSize(new java.awt.Dimension(830, 710));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bgRegistrarCliente.setBackground(new java.awt.Color(255, 255, 255));
        bgRegistrarCliente.setPreferredSize(new java.awt.Dimension(830, 710));

        titleRegistraClienteLabel.setBackground(new java.awt.Color(0, 0, 0));
        titleRegistraClienteLabel.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        titleRegistraClienteLabel.setForeground(new java.awt.Color(0, 0, 0));
        titleRegistraClienteLabel.setText("Registra un nuevo cliente");

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Primer apellido");

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Segundo apellido");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Identificaci�n");

        jLabel6.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Fecha de nacimiento");

        txt1Apellido.setBackground(new java.awt.Color(255, 255, 255));
        txt1Apellido.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        txt1Apellido.setForeground(new java.awt.Color(153, 153, 153));
        txt1Apellido.setBorder(null);

        txt2Apellido.setBackground(new java.awt.Color(255, 255, 255));
        txt2Apellido.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        txt2Apellido.setForeground(new java.awt.Color(153, 153, 153));
        txt2Apellido.setBorder(null);

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(153, 153, 153));
        txtNombre.setBorder(null);

        txtIdentificacion.setBackground(new java.awt.Color(255, 255, 255));
        txtIdentificacion.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        txtIdentificacion.setForeground(new java.awt.Color(153, 153, 153));
        txtIdentificacion.setBorder(null);

        btnGuardarClientePanel.setBackground(new java.awt.Color(115, 56, 242));

        btnGuardarClienteLabel.setFont(new java.awt.Font("Montserrat Black", 0, 14)); // NOI18N
        btnGuardarClienteLabel.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarClienteLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGuardarClienteLabel.setText("Guardar");
        btnGuardarClienteLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarClienteLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarClienteLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnGuardarClientePanelLayout = new javax.swing.GroupLayout(btnGuardarClientePanel);
        btnGuardarClientePanel.setLayout(btnGuardarClientePanelLayout);
        btnGuardarClientePanelLayout.setHorizontalGroup(
            btnGuardarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnGuardarClienteLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
        );
        btnGuardarClientePanelLayout.setVerticalGroup(
            btnGuardarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnGuardarClienteLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Tel�fono");

        jLabel7.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Correo electr�nico");

        txtTelefono.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefono.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(153, 153, 153));
        txtTelefono.setBorder(null);

        txtCorreo.setBackground(new java.awt.Color(255, 255, 255));
        txtCorreo.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(153, 153, 153));
        txtCorreo.setBorder(null);

        fechaNacimientoCliente.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout bgRegistrarClienteLayout = new javax.swing.GroupLayout(bgRegistrarCliente);
        bgRegistrarCliente.setLayout(bgRegistrarClienteLayout);
        bgRegistrarClienteLayout.setHorizontalGroup(
            bgRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgRegistrarClienteLayout.createSequentialGroup()
                .addGroup(bgRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgRegistrarClienteLayout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(titleRegistraClienteLabel))
                    .addGroup(bgRegistrarClienteLayout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(btnGuardarClientePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(bgRegistrarClienteLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(bgRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt1Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt2Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addGroup(bgRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(fechaNacimientoCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(bgRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(bgRegistrarClienteLayout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(474, 474, 474))
                        .addGroup(bgRegistrarClienteLayout.createSequentialGroup()
                            .addComponent(jSeparator5)
                            .addGap(171, 171, 171))))
                .addGap(0, 53, Short.MAX_VALUE))
        );
        bgRegistrarClienteLayout.setVerticalGroup(
            bgRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgRegistrarClienteLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(titleRegistraClienteLabel)
                .addGap(45, 45, 45)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt1Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt2Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(1, 1, 1)
                .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechaNacimientoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btnGuardarClientePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        add(bgRegistrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 700));
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarClienteLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarClienteLabelMouseClicked
			try {
				ValidacionPersona validacionPersona = (ValidacionPersona) (factoryValidacion.crearValidacion("ValidacionPersona"));
				validacionPersona.validarDatosPersona(txt1Apellido.getText(),
								txt2Apellido.getText(), txtNombre.getText(),
								txtIdentificacion.getText());
				ValidacionCliente validacionCliente = (ValidacionCliente) (factoryValidacion.crearValidacion("ValidacionCliente"));
				validacionCliente.validarDatosCliente(txtTelefono.getText(),
								txtCorreo.getText());

				if (validacionPersona.esValido && validacionCliente.esValido) {
					ControladorRegistroCliente control = new ControladorRegistroCliente();
					control.controlarRegistroCliente(txtIdentificacion.getText(),
									txt2Apellido.getText(), txt1Apellido.getText(),
									txtNombre.getText(), fechaNacimientoCliente.getDate(),
									txtTelefono.getText(), txtCorreo.getText());
					validacionCliente.setResultado(control.getMensaje());
				}
				JOptionPane.showMessageDialog(this, validacionPersona.resultado + "\n"
								+ validacionCliente.resultado);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
				System.out.println(ex.getMessage() + " aa");
			}
    }//GEN-LAST:event_btnGuardarClienteLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgRegistrarCliente;
    private javax.swing.JLabel btnGuardarClienteLabel;
    private javax.swing.JPanel btnGuardarClientePanel;
    private com.toedter.calendar.JDateChooser fechaNacimientoCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel titleRegistraClienteLabel;
    private javax.swing.JTextField txt1Apellido;
    private javax.swing.JTextField txt2Apellido;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
