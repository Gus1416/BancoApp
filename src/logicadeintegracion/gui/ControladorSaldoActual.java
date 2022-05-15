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
public class ControladorSaldoActual {
  private CuentaCRUD cuentaCRUD; 
  private Cuenta cuenta;
  private String mensaje;

  public ControladorSaldoActual() {
    cuentaCRUD = new CuentaCRUD ();
    cuenta = new Cuenta ();
  }
  
  public void controlarSaldoActual (String pNumCuenta) {
  cuenta = cuentaCRUD.consultarCuenta(pNumCuenta);
  mensaje = "Estimado usuario el saldo actual de su cuenta es: " 
          +cuenta.getSaldo() + " colones.";
  }

  public String getMensaje() {
    return mensaje;
  }
  
}
