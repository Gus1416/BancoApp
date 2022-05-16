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
public class ControladorEstatusCuenta {
  private String mensaje;
  private Cuenta cuenta;
  private CuentaCRUD cuentaCRUD;

  public ControladorEstatusCuenta() {
    cuentaCRUD = new CuentaCRUD ();
  }
  
  
  
  public void controlarEstatusCuenta (String pNunCuenta) {
    cuenta = cuentaCRUD.consultarCuenta(pNunCuenta);
    mensaje = "La cuenta n�mero "+cuenta.getNumeroCuenta() +" tiene estatus "
            + "de " + cuenta.getEstatus();
  }

  public String getMensaje() {
    return mensaje;
  }
  
  
}