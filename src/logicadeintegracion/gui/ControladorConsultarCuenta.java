/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadeintegracion.gui;

import java.util.ArrayList;
import logicadeaccesodedatos.ClienteCRUD;
import logicadeaccesodedatos.CuentaCRUD;
import logicadenegocios.Cliente;
import logicadenegocios.Cuenta;

/**
 *
 * @author Alejandra Merino
 */
public class ControladorConsultarCuenta {
 
public ArrayList cargarCuentas () {
    CuentaCRUD cuentaCRUD = new CuentaCRUD ();
    ArrayList<Cuenta> listaCuentas = cuentaCRUD.consultarCuentas();
    ArrayList listaCuentasP = new ArrayList ();
    for (Cuenta cuenta: listaCuentas ) {
      String mensaje = ""+ cuenta.getNumeroCuenta() +" "+ 
              cuenta.getEstatus()  + " "+ cuenta.getSaldo();
              
      listaCuentasP.add(mensaje);
    }
    return listaCuentasP;
  }

public String cargarPropietarioCuenta (String pNumCuenta) {
  ClienteCRUD clienteCRUD = new ClienteCRUD ();
  Cliente cliente = clienteCRUD.consultarPropietarioCuenta(pNumCuenta);
  String mensaje = "" + cliente.getIdentificacion() + " " + 
          cliente.getPrimerApellido() + " "+ cliente.getSegundoApellido() + " "+
          cliente.getNombre();
  return mensaje;
  }

public String cargarCuenta (String pNumCuenta) {
  CuentaCRUD cuentaCRUD = new CuentaCRUD ();
  Cuenta cuenta = cuentaCRUD.consultarCuenta(pNumCuenta);
  String mensaje = cuenta.estadoCuentaColones();
  return mensaje;
  }
  
}
