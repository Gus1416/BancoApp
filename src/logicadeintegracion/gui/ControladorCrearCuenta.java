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
public class ControladorCrearCuenta  extends Controlador {
 
  public ArrayList cargarClientes () {
    ClienteCRUD clienteCRUD = new ClienteCRUD ();
    ArrayList<Cliente> listaClientes = clienteCRUD.consultarClientes();
    ArrayList listaClientesP = new ArrayList ();
    for (Cliente cliente: listaClientes ) {
      String mensaje = ""+ cliente.getPrimerApellido() +" "+ 
              cliente.getSegundoApellido()  + " "+ cliente.getNombre() 
              +" "+ cliente.getIdentificacion();
      listaClientesP.add(mensaje);
    }
    return listaClientesP;
  }
  
  public void controlarRegistroCuenta (String pPin, String pNum, String pIdentificacion) {
    double deposito = Double.parseDouble(pNum);
    CuentaCRUD cuentaCRUD = new CuentaCRUD ();
    int numeroCuentas = cuentaCRUD.obtenerCantidadCuentas();
    ClienteCRUD clienteCRUD = new ClienteCRUD ();
    Cliente clienteRegistrado = clienteCRUD.consultarCliente(pIdentificacion);
    clienteRegistrado.crearCuenta(pPin, deposito, numeroCuentas);
    int ultimo = clienteRegistrado.getCuentas().size();
    Cuenta cuenta = (clienteRegistrado.getCuentas()).get(ultimo-1);
    cuentaCRUD.registrarCuenta(cuenta, pIdentificacion);
    
    
    super.mensaje = "Se ha creado una nueva cuenta en el sistema, los datos de"
            + " la cuenta son:\n Número de cuenta: "+cuenta.getNumeroCuenta() 
            + "\n Estatus de la cuenta: " + cuenta.getEstatus() + "\n"+
            "Saldo actual: "+cuenta.getSaldo()+"\n ---\n "
            + "Nombre del dueño de la cuenta: "+clienteRegistrado.getNombre()
            + " "+ clienteRegistrado.getPrimerApellido()+ " " + 
            clienteRegistrado.getSegundoApellido() +"\n "
            + "Número de teléfono asociado a la cuenta: " 
            +clienteRegistrado.getNumeroTelefono() + "\n "
            + "Dirección de correo electrónico asociada a la cuenta: "
            +clienteRegistrado.getCorreoElectronico();
    
  }
  
  
  
}
