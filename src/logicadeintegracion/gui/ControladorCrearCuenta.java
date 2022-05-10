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
public class ControladorCrearCuenta {
  
  public ArrayList cargarClientes () {
    ClienteCRUD clienteCRUD = new ClienteCRUD ();
    ArrayList<Cliente> listaClientes = clienteCRUD.consultarClientes();
    ArrayList listaClientesP = new ArrayList ();
    for (Cliente cliente: listaClientes ) {
      String mensaje = ""+ cliente.getIdentificacion() +" "+ 
              cliente.getPrimerApellido() + " "+ cliente.getSegundoApellido() 
              +" "+ cliente.getNombre();
      listaClientesP.add(mensaje);
    }
    return listaClientesP;
  }
  
  public String controlarRegistroCuenta (String pPin, String pNum, String pIdentificacion) {
    double deposito = Double.parseDouble(pNum);
    Cuenta cuenta = new Cuenta (pPin, deposito);
    //CuentaCRUD cuentaCRUD = new CuentaCRUD ();
    //cuentaCRUD.registrarCuenta(cuenta, pIdentificacion);
    ClienteCRUD clienteCRUD = new ClienteCRUD ();
    Cliente clienteRegistrado = clienteCRUD.consultarCliente(pIdentificacion);
    System.out.println(clienteRegistrado.toString());
    String mensaje = "Se ha creado una nueva cuenta en el sistema, los datos de"
            + " la cuenta son:\n Número de cuenta: "+cuenta.getNumeroCuenta() 
            + "\n Estatus de la cuenta: " + cuenta.getEstatus() + "\n"+
            "Saldo actual: "+cuenta.getSaldo()+"\n ---\n "
            + "Nombre del dueño de la cuenta: "+clienteRegistrado.getNombre()
            + " "+ clienteRegistrado.getPrimerApellido()+ " " + 
            clienteRegistrado.getSegundoApellido() +"\n "
            + "Número de teléfono asociado a la cuenta:" 
            +clienteRegistrado.getNumeroTelefono() + "\n "
            + "Dirección de correo electrónico ?asociada? a la cuenta:"
            +clienteRegistrado.getCorreoElectronico();
    return mensaje;
  }
  
  
  
}
