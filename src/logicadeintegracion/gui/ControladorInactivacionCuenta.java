/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadeintegracion.gui;

import logicadeaccesodedatos.ClienteCRUD;
import logicadeaccesodedatos.CuentaCRUD;
import logicadenegocios.Cliente;
import logicadenegocios.Cuenta;
import serviciosexternos.Correo;

/**
 *
 * @author Alejandra Merino
 */
public class ControladorInactivacionCuenta {
  private String mensaje;
  
  public void controlarInactivarCuenta (String pNumCuenta) {
    ClienteCRUD clienteCRUD = new ClienteCRUD ();
    CuentaCRUD cuentaCRUD = new CuentaCRUD ();
    Cliente cliente = clienteCRUD.consultarPropietarioCuenta(pNumCuenta);
    Cuenta cuenta = cuentaCRUD.consultarCuenta(pNumCuenta);
    cuenta.inactivarCuenta();
    cuentaCRUD.cambiarEstatus(cuenta);
    Correo correo = new Correo ();
    if (correo.enviarCorreo(cliente.getCorreoElectronico(), 
          cliente.getNombre(), pNumCuenta)) {
      return;
    }
  }

  public String getMensaje() {
    return mensaje;
  }
  
  
}
