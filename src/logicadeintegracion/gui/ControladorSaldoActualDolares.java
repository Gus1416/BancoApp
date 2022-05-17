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
public class ControladorSaldoActualDolares extends Controlador {
  private CuentaCRUD cuentaCRUD; 
  private Cuenta cuenta;

  public ControladorSaldoActualDolares() {
    cuentaCRUD = new CuentaCRUD ();
    cuenta = new Cuenta ();
  }
  
  public void controlarSaldoActualDolares (String pNumCuenta) {
  cuenta = cuentaCRUD.consultarCuenta(pNumCuenta);
  double saldoDolares = cuenta.getSaldoDolares();
  double redondeo = Math.round(saldoDolares*100.0)/100.0;
  super.mensaje = "Estimado usuario el saldo actual de su cuenta es: " 
          +redondeo + " d�lares.";
  }
  
}
