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
import serviciosexternos.CorreoLenguajeDecorator;
import serviciosexternos.ICorreo;

/**
 *
 * @author Alejandra Merino
 */
public class ControladorInactivacionCuenta {
  
  
  public void controlarInactivarCuenta (String pNumCuenta) {
    ClienteCRUD clienteCRUD = new ClienteCRUD ();
    CuentaCRUD cuentaCRUD = new CuentaCRUD ();
    Cliente cliente = clienteCRUD.consultarPropietarioCuenta(pNumCuenta);
    Cuenta cuenta = cuentaCRUD.consultarCuenta(pNumCuenta);
    cuenta.inactivarCuenta();
    cuentaCRUD.cambiarEstatus(cuenta);
		ICorreo correo = new CorreoLenguajeDecorator(new Correo(cliente.getNombre(), pNumCuenta));
    //Correo correo = new Correo (cliente.getNombre(), pNumCuenta);
	correo.enviarCorreo(cliente.getCorreoElectronico());
  }
  
  
}
