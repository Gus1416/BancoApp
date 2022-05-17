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
public class ControladorCambioPin extends Controlador {
  
  public void controlarCambioPin (String pNumCuenta, String pPinNuevo) {
    CuentaCRUD cuentaCRUD = new CuentaCRUD ();
    Cuenta cuenta = cuentaCRUD.consultarCuenta(pNumCuenta);
    cuenta.setPin(pPinNuevo);
    cuentaCRUD.cambiarPin(cuenta);
    super.mensaje = "Estimado usuario, se ha cambiado satisfactoriamente el "
            + "PIN de su cuenta: " + cuenta.getNumeroCuenta();
  }
  
}
