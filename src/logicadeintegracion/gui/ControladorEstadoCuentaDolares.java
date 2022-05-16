/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadeintegracion.gui;

import logicadeaccesodedatos.CuentaCRUD;
import logicadenegocios.Cuenta;

/**
 *
 * @author Alejandra Merino
 */
public class ControladorEstadoCuentaDolares {
  private String mensaje;
  private CuentaCRUD cuentaCRUD;
  private Cuenta cuenta;

  public ControladorEstadoCuentaDolares() {
    cuentaCRUD = new CuentaCRUD ();
    cuenta = new Cuenta (); 
  }
  
  public void controlarEstadoCuentaDolares (String pNumCuenta) {
    cuenta = cuentaCRUD.consultarCuenta(pNumCuenta);
    mensaje = cuenta.estadoCuentaDolares();
  }
  
  public String getMensaje() {
    return mensaje;
  }
}